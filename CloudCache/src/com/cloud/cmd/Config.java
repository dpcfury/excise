package com.cloud.cmd;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Created by dpc on 12/4/14.
 */
//负责创建用户集群和为集群添加节点的类
public class Config {
	
	private JedisCluster jedisCluster;
	private UserConfig userConfig;//某个用户的配置信息
	
	
	public Config() {

	}

	public Config(String userName, int memorySize) throws IOException,
			InterruptedException {

		create(userName, memorySize);
	}

	public void create(String userName, int memorySize) throws IOException,
			InterruptedException {
		int num = (int) Math.ceil(1.0 * memorySize / 200) * 2;
		String cmd;
		Runtime rt = Runtime.getRuntime();
		String redisInfo[] = new String[2];
		Vector<String> vector = new Vector<String>();

		userConfig = new UserConfig(userName, memorySize);

		if (num < 6)
			num = 6;

		userConfig.setNumOfNodes(num);

		cmd = "bash findCluster.sh " + num;
		File dir = new File("/home/coolws");
		Process p = rt.exec(cmd, null, dir);

		// p =
		// rt.exec("./redis-trib.rb create --replicas 1 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005",
		// null, dir);
		p.waitFor();
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			if (line.contains(" ")) {
				redisInfo = line.split(" ");
				// System.out.println(redisInfo[1]+"&&&&"+redisInfo[0]+"&&&&");
				// // containerIP containterID
				userConfig.addRedisNode(redisInfo[1], redisInfo[0]);
				vector.add(redisInfo[1]);
			}
		}

		String IPs = "";
		for (int i = 0; i < vector.size(); i++)
			IPs += vector.get(i) + ":6379 ";

		// System.out.println(IPs);

		cmd = "./redis-trib.rb create --replicas 1 " + IPs;
		dir = new File("/home/coolws/redis-3.0.0-rc1/src");
		p = rt.exec(cmd, null, dir);

		// p =
		// rt.exec("./redis-trib.rb create --replicas 1 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005",
		// null, dir);
		p.waitFor();
		is = p.getInputStream();
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);

		}

		updateRedisID();
	

	}

	public void addNode(int memorySize) throws IOException,
			InterruptedException {
		int num = (int) Math.ceil(1.0 * memorySize / 200); // add node
															// number,not total
															// number
		String cmd;
		Runtime rt = Runtime.getRuntime();
		String redisInfo[] = new String[2];

		userConfig.setNumOfNodes(num + userConfig.getNumOfNodes());

		Vector<String> vector = new Vector<String>(); // IP list

		cmd = "bash findCluster.sh " + num;
		File dir = new File("/home/coolws");
		Process p = rt.exec(cmd, null, dir);

		// p =
		// rt.exec("./redis-trib.rb create --replicas 1 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005",
		// null, dir);
		p.waitFor();
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			// System.out.println(line);
			if (line.contains(" ")) {
				redisInfo = line.split(" ");
				System.out.println(redisInfo[1] + "&&&&" + redisInfo[0]
						+ "&&&&"); // containerIP containterID
				if (userConfig.RedisNodeIndex(redisInfo[1]) == -1) {
					vector.add(redisInfo[1]);
					userConfig.addRedisNode(redisInfo[1], redisInfo[0]);
				}

			}
		}

		String existIP = userConfig.getRedisNodes().get(0).getRedisIP();

		dir = new File("/home/coolws/redis-3.0.0-rc1/src");

		for (int i = 0; i < vector.size(); i++) {
			cmd = "./redis-trib.rb add-node " + vector.get(i) + ":6379 "
					+ existIP + ":6379 ";

			p = rt.exec(cmd, null, dir);

			// p =
			// rt.exec("./redis-trib.rb create --replicas 1 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005",
			// null, dir);
			p.waitFor();
			is = p.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			line = null;
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
			}

			updateRedisID();

		}

		for (int i = 0; i < vector.size(); i++) {
			String redisID = userConfig.ipToRedisID(vector.get(i));

			dir = new File("/home/coolws/");
			cmd = "bash  reshardCluster.sh " + vector.get(i) + ":6379 "
					+ redisID;

			System.out.println("###redisID: " + redisID + " ip: "
					+ vector.get(i));
			System.out.println(cmd + "###");

			p = rt.exec(cmd, null, dir);

			// p =
			// rt.exec("./redis-trib.rb create --replicas 1 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005",
			// null, dir);
			p.waitFor();
			is = p.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		
	}

	public void delNode() throws IOException, InterruptedException { // kill all
																		// docker
																		// container
		Runtime rt = Runtime.getRuntime();

		for (int i = 0; i < userConfig.getRedisNodes().size(); i++) {
			String cmd = "bash killCluster.sh "
					+ userConfig.getRedisNodes().get(i).getDockerID();
			File dir = new File("/home/coolws");
			Process p = rt.exec(cmd, null, dir);

			// p =
			// rt.exec("./redis-trib.rb create --replicas 1 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005",
			// null, dir);
			p.waitFor();

			InputStream is = p.getInputStream();

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if (line.contains(" ")) {
					// redisInfo = line.split(" ");
					// System.out.println(redisInfo[1]+"&&&&"+redisInfo[0]+"&&&&");
					// // containerIP containterID
					// vector.add(redisInfo[1]);
					// userConfig.addRedisNode(redisInfo[1],redisInfo[0]);
				}
			}
		}
	}

	public void updateRedisID() {
		init(userConfig.getRedisNodes().get(0).getRedisIP(), 6379); // update
		JedisCluster jedisCluster = this.getJedisCluster();

		Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();

		System.out.println(" &&&&&&& ");

		// System.out.println(key + " +++++");
		String str;
		JedisPool jedisPool;
		do {
			jedisPool = clusterNodes.get(userConfig.getRedisNodes().get(0)
					.getRedisIP()
					+ ":6379");
			// String str = jedisPool.getResource().asking();
			// System.out.print(str+" asking +++" );
			// str = jedisPool.getResource().clusterInfo(); // link state

			str = jedisPool.getResource().clusterNodes(); // node state
		} while (str.contains("master") == false);

		// System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		// System.out.println(str + " cluster node");
		// System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		String[] infos = new String[50];
		String[] perLine = new String[10];
		infos = str.split("\\n");
		System.out.println("#######");
		boolean flag = false;

		// System.out.println("##################################");
		// for(int k=0;k<userConfig.getRedisNodes().size();k++)
		// {
		// System.out.println(userConfig.getRedisNodes().get(k).getRedisIP());
		// }
		// System.out.println("##################################");

		for (int i = 0; i < infos.length; i++) {
			System.out.println(infos[i] + "!!!");
			perLine = infos[i].split(" ");
			for (int j = 0; j < perLine.length; j++) {
				if (perLine[j].contains("master")) {
					for (int k = 0; k < userConfig.getRedisNodes().size(); k++) {
						if (perLine[j - 1].contains(userConfig.getRedisNodes()
								.get(k).getRedisIP())) {
							userConfig.getRedisNodes().get(k)
									.setRedisID(perLine[j - 2]);
							flag = true;
							break;
						}
					}
					// System.out.println(infos[i-2]+"**"+infos[i-1]+"**"+infos[i]);
				}
				if (perLine[j].contains("slave")) {
					for (int k = 0; k < userConfig.getRedisNodes().size(); k++) {
						if (perLine[j - 1].contains(userConfig.getRedisNodes()
								.get(k).getRedisIP())) {
							userConfig.getRedisNodes().get(k)
									.setRedisID(perLine[j - 2]);
							flag = true;
							break;
						}
					}
					// System.out.println(infos[i-2]+"**"+infos[i-1]+"**"+infos[i]);
				}
				if (flag == true)
					break;
			}
			flag = false;

		}
		System.out.println("#######");

		// System.out.print(str + " +++++");
		System.out.println();

		for (int i = 0; i < userConfig.getRedisNodes().size(); i++) {
			RedisNode redisNode = userConfig.getRedisNodes().get(i);
			System.out.println(redisNode.getDockerID() + "$$$"
					+ redisNode.getRedisIP() + "$$$" + redisNode.getRedisID());
		}
	}

	public JedisCluster getJedisCluster() {
		return jedisCluster;
	}

//	private void runShell(int num) throws IOException, InterruptedException {
//		String cmd;
//		Runtime rt = Runtime.getRuntime();
//		String redisInfo[] = new String[2];
//
//	}

	private void init(String IP, int port) {
		Set<HostAndPort> hostCluster = new HashSet<HostAndPort>();
		hostCluster.add(new HostAndPort(IP, port));
		jedisCluster = new JedisCluster(hostCluster);
	}

}

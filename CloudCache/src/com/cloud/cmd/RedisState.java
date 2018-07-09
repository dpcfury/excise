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
 * Created by dpc on 12/9/14.
 */
public class RedisState {
    RedisState(){
    }
    public RedisState(String IP){
        this.IP=IP;
        stateIO=new Vector<String>();
        stateMEM=new Vector<String>();
        stateCPU=new Vector<String>();

    }

    public Vector<String> getStateCPU() {
        return stateCPU;
    }

    public void setStateCPU(Vector<String> stateCPU) {
        this.stateCPU = stateCPU;
    }

    public Vector<String> getStateMEM() {

        return stateMEM;
    }

    public void setStateMEM(Vector<String> stateMEM) {
        this.stateMEM = stateMEM;
    }

    public Vector<String> getStateIO() {

        return stateIO;
    }

    public void setStateIO(Vector<String> stateIO) {
        this.stateIO = stateIO;
    }

    public void getInfo() throws IOException, InterruptedException {
        getSystemState();
        getClusterState();
    }

    public void getSystemState() throws InterruptedException, IOException {
        String[] infos = new String[17];
        Runtime rt = Runtime.getRuntime();
        //String cmd="sshpass -p '123456' ssh -o \"StrictHostKeyChecking no\" root@"+IP+" \"vmstat | tail -n 1\" ";
        String cmd="bash findRedisInfo.sh "+IP;
        File dir = new File("/home/coolws");
        Process p = rt.exec(cmd, null, dir);

        System.out.println("%%%%%");

        //p = rt.exec("./redis-trib.rb create --replicas 1 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005", null, dir);
        p.waitFor();
        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while((line = br.readLine())!=null){
            System.out.println(line);
            if(line.contains("Warning")==false)
            {
                infos=line.trim().split("\\s+");
                for(int i=0;i<17;i++)
                {
                    if(i>=2&&i<=5)
                        stateMEM.add(infos[i]);
                    if(i>=8&&i<=9)
                        stateIO.add(infos[i]);
                    if(i>=12&&i<=16)
                        stateCPU.add(infos[i]);

                    //  System.out.println("###"+infos[i]+"###");
                }

                System.out.println("### stateMEM ###");
                for(int i=0;i<stateMEM.size();i++)
                    System.out.println(stateMEM.get(i));
                System.out.println("### stateIO ###");
                for(int i=0;i<stateIO.size();i++)
                    System.out.println(stateIO.get(i));
                System.out.println("### stateCPU ###");
                for(int i=0;i<stateCPU.size();i++)
                    System.out.println(stateCPU.get(i));
            }
        }
    }

    public void getClusterState(){
        Set<HostAndPort> hostCluster = new HashSet<HostAndPort>();    // method 2
        hostCluster.add(new HostAndPort(IP,6379));
        JedisCluster jedisCluster = new JedisCluster(hostCluster);

        Map<String,JedisPool> clusterNodes = jedisCluster.getClusterNodes();

        System.out.println(" &&&&&&& ");

        //System.out.println(key + " +++++");
        JedisPool jedisPool = clusterNodes.get(IP+":6379");
//        String str = jedisPool.getResource().asking();
//        System.out.print(str+" asking +++" );
        String str = jedisPool.getResource().clusterInfo();   // link stateIO

        System.out.println("%%%%%"+str);
    }
    private String IP;
    private Vector<String> stateIO;
    private Vector<String> stateMEM;
    private Vector<String> stateCPU;
}

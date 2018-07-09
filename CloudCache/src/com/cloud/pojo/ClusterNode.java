package com.cloud.pojo;


//记录用户的集群节点的相关信息的实体类
public class ClusterNode {

	private int userID;//所属的用户
	private String userName;//所属的用户名
	private String dockerID;//docker容器的ID
	private String dockerIP;//与docker容器ID对应的docker容器IP
	private String phicsIP;//docker容器运行依附的物理机IP
	private String redisID;//docker容器中运行的redis节点ID
	
	public ClusterNode(){
		super();
	}
	

	public ClusterNode(int userID, String userName, String dockerID,
			String dockerIP, String phicsIP, String redisID) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.dockerID = dockerID;
		this.dockerIP = dockerIP;
		this.phicsIP = phicsIP;
		this.redisID = redisID;
	}


	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getDockerID() {
		return dockerID;
	}
	public void setDockerID(String dockerID) {
		this.dockerID = dockerID;
	}
	public String getDockerIP() {
		return dockerIP;
	}
	public void setDockerIP(String dockerIP) {
		this.dockerIP = dockerIP;
	}
	public String getPhicsIP() {
		return phicsIP;
	}
	public void setPhicsIP(String phicsIP) {
		this.phicsIP = phicsIP;
	}
	public String getRedisID() {
		return redisID;
	}
	public void setRedisID(String redisID) {
		this.redisID = redisID;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "ClusterNode [userID=" + userID + ", userName=" + userName
				+ ", dockerID=" + dockerID + ", dockerIP=" + dockerIP
				+ ", phicsIP=" + phicsIP + ", redisID=" + redisID + "]";
	}



	
}

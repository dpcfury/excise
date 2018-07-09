package com.cloud.pojo;

//缓存集群用户类
public class CloudUser {
	
	private int id;//用户唯一标识id
	private String userName;//用户登录网页端的用户名
	private String password;//用户登录时的口令
	private int memsize;//这里以MB为单位
	
	public CloudUser(){
		super();
		
	}
	
	public CloudUser(int id, String userName, String password, int memsize) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.memsize = memsize;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMemsize() {
		return memsize;
	}
	public void setMemsize(int memsize) {
		this.memsize = memsize;
	}

	//重写打印输出用户全部信息的方法
	@Override
	public String toString() {
		return "CloudUser [id=" + id + ", userName=" + userName + ", password="
				+ password + ", memsize=" + memsize + "]";
	}
	
	
	
	
	
}

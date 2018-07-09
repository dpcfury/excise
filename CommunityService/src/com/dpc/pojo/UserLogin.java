package com.dpc.pojo;

public class UserLogin {

	
	private int id;//id 唯一值
	private  String userNanme;//用户民
	private String password;//密码
	
	
	
	public UserLogin() {
		super();
	}
	public UserLogin(int id, String userNanme, String password) {
		super();
		this.id = id;
		this.userNanme = userNanme;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserNanme() {
		return userNanme;
	}
	public void setUserNanme(String userNanme) {
		this.userNanme = userNanme;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//重写了hashCode和equals方法表示只要id相同就认为两个User对象是相同的
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}

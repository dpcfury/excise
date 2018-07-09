package com.cloud.pojo;

//弹性云缓存管理员（运维人员）
public class CloudAdmin {
	
	private int id;
	private String adminName;
	private String password;
	
	public CloudAdmin(){
		super();
	}
	
	public CloudAdmin(int id, String adminName, String password) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CloudAdmin [id=" + id + ", adminName=" + adminName
				+ ", password=" + password + "]";
	}
	
	
	
}

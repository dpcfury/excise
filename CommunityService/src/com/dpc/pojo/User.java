package com.dpc.pojo;

//一个完整的用户信息类
public class User {

	private int userid;//用户id
	private String username;//用户名
	private String password;//密码
	private String realname;//真实姓名
	private String sex;//性别
	private int age;//年龄
	private String address;//地址
	private String phonenumber;//联系方式
	
	
	
	public User() {
		super();
	}
	
	
	
	public User(int userid, String username, String password, String realname,
			String sex, int age, String address, String phonenumber) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.phonenumber = phonenumber;
	}

	

	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRealname() {
		return realname;
	}



	public void setRealname(String realname) {
		this.realname = realname;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", realname=" + realname
				+ ", sex=" + sex + ", age=" + age + ", address=" + address
				+ ", phonenumber=" + phonenumber + "]";
	}

	
	
	
//	@Override
//	public String toString(){
//		
//		return "用户名为:"+username+" \n密码为:"+password+" \n真实姓名为:"+realName+
//				"\n年龄为:"+age+" \n性别为:"+sex+" \n地址为:"+address+" \n联系方式为:"+phone+"\n";
//	}
	
	
}

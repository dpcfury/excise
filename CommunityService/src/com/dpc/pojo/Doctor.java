package com.dpc.pojo;

//后台管理端使用的医生用户
public class Doctor {
	private int doctorid;
	private String realname;
	private int age;
	private String sex;
	private String address;
	private String phonenumber;
	private String position;
	private String keshi;
	
	public Doctor(){
		
	}

	public Doctor(int doctorid, String realname, int age, String sex,
			String address, String phonenumber, String position, String keshi) {
		super();
		this.doctorid = doctorid;
		this.realname = realname;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.phonenumber = phonenumber;
		this.position = position;
		this.keshi = keshi;
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getKeshi() {
		return keshi;
	}

	public void setKeshi(String keshi) {
		this.keshi = keshi;
	}

	@Override
	public String toString() {
		return "Doctor [doctorid=" + doctorid + ", realname=" + realname
				+ ", age=" + age + ", sex=" + sex + ", address=" + address
				+ ", phonenumber=" + phonenumber + ", position=" + position
				+ ", keshi=" + keshi + "]";
	}
	
	
}
	
	
	
	
	
	
	
	


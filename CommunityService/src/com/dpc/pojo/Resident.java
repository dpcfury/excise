package com.dpc.pojo;

public class Resident {
	
	private String ID;
	private String name;
	private int age;
	private String sex;
	private String address;
	private String moreInfoId;
	
	public Resident(){
		
		
	}

	public Resident(String iD, String name, int age, String sex,
			String address, String moreInfoId) {
		super();
		ID = iD;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.moreInfoId = moreInfoId;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMoreInfoId() {
		return moreInfoId;
	}

	public void setMoreInfoId(String moreInfoId) {
		this.moreInfoId = moreInfoId;
	}

	@Override
	public String toString() {
		return "Resident [ID=" + ID + ", name=" + name + ", age=" + age
				+ ", sex=" + sex + ", address=" + address + ", moreInfoId="
				+ moreInfoId + "]";
	}
	
	
	
}

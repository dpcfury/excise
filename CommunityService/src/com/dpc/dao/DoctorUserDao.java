package com.dpc.dao;

import com.dpc.pojo.Doctor;

public interface DoctorUserDao {

	//医生用户登录的方法
	public Doctor checkDoctor(String userName,String password);
	
	//医生用户跟新账户和个人相关信息
	//public Doctor updateInfo(Doctor doctor);
	

	
	
}

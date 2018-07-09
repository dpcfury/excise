package com.dpc.service;

import com.dpc.pojo.Doctor;

//底层医生信息服务类
public interface DoctorUserService {

	//医生登录方法
	public Doctor checkDoctor(String userName,String password);
	
	//医生用户跟新账户和个人相关信息
	//public Doctor updateInfo(Doctor doctor);
}

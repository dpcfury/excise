package com.dpc.service.impl;

import com.dpc.dao.DoctorUserDao;
import com.dpc.pojo.Doctor;
import com.dpc.service.DoctorUserService;

//医生信息服务接口的实现类
public class DoctorUserServiceImpl implements DoctorUserService {

	private DoctorUserDao doctorUserDao;
	
	//医生登录的方法(通过用户名和口令来验证)
	@Override
	public Doctor checkDoctor(String userName, String password) {
		
		return doctorUserDao.checkDoctor(userName, password);
	}
	
	public DoctorUserDao getDoctorUserDao() {
		return doctorUserDao;
	}
	
	public void setDoctorUserDao(DoctorUserDao doctorUserDao) {
		this.doctorUserDao = doctorUserDao;
	}

	
	//医生用户跟新账户和个人相关信息
	
//	public Doctor updateInfo(Doctor doctor) {
//		return doctorUserDao.updateInfo(doctor);
//	}

	
	
}

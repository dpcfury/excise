package com.dpc.service.impl;

import java.util.List;

import com.dpc.dao.DoctorInfoDao;
import com.dpc.pojo.Doctor;
import com.dpc.service.DoctorInfoService;

public class DoctorInfoServiceImpl implements DoctorInfoService {

	private DoctorInfoDao doctorInfoDao;
	
	//方便注入
	
	public DoctorInfoDao getDoctorInfoDao() {
		return doctorInfoDao;
	}



	public void setDoctorInfoDao(DoctorInfoDao doctorInfoDao) {
		this.doctorInfoDao = doctorInfoDao;
	}



	public List<Doctor> getAllDoctorInfo(String keshi) {
		
		return doctorInfoDao.getAllDetailDoctorInfo(keshi);
	}



	

}

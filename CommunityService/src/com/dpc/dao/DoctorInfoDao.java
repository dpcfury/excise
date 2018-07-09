package com.dpc.dao;

import java.util.List;

import com.dpc.pojo.Doctor;

public interface DoctorInfoDao {
	
	//获得对应科室医生集合
	public List<Doctor> getAllDetailDoctorInfo(String keshi);
}

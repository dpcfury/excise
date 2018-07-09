package com.dpc.service;

import java.util.List;

import com.dpc.pojo.Doctor;

public interface DoctorInfoService {

	//获得符合科室的所有医生
	public List<Doctor> getAllDoctorInfo(String keshi);
}

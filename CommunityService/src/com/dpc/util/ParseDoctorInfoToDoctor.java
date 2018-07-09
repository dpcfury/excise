package com.dpc.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dpc.pojo.BloodPressure;
import com.dpc.pojo.BloodPressureRecord;
import com.dpc.pojo.Doctor;

public class ParseDoctorInfoToDoctor {
	
	// 转换一下Date
		public static Doctor parse(Doctor doctor) {
			Doctor record = new Doctor();
			record.setDoctorid(doctor.getDoctorid());
			record.setRealname(doctor.getRealname());
			record.setAge(doctor.getAge());
			record.setSex(doctor.getSex());
			record.setAddress(doctor.getAddress());
			record.setPhonenumber(doctor.getPhonenumber());
			record.setPosition(doctor.getPosition());
			record.setKeshi(doctor.getKeshi());
			return record;
		}

		// 批量转换血压集合
		public static List<Doctor> parse(List<Doctor> doctor) {
			List<Doctor> record = new ArrayList<Doctor>();
			if (doctor != null) {
				Iterator<Doctor> it = doctor.iterator();
				while (it.hasNext()) {
					Doctor d = it.next();
					Doctor dr = parse(d);
					record.add(dr);
				}
				return record;
			} else
				return null;
		}
}

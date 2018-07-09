package com.dpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dpc.dao.DoctorInfoDao;
import com.dpc.pojo.BloodPressure;
import com.dpc.pojo.Doctor;
import com.dpc.util.DBConnection;

public class DoctorInfoDaoImpl implements DoctorInfoDao {

	private Connection con;

	public DoctorInfoDaoImpl() {
		super();
		con = DBConnection.getConnection();
	}
	
	@Override
	public List<Doctor> getAllDetailDoctorInfo(String keshi) {

		List<Doctor>list = new ArrayList<Doctor>();
		
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from doctordetail where doctordetail.section=?");
			pstmt.setString(1, keshi);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorid(result.getInt(2));
				doctor.setRealname(result.getString(3));
				doctor.setAge(result.getInt(4));
				doctor.setSex(result.getString(5));
				doctor.setAddress(result.getString(6));
				doctor.setPhonenumber(result.getString(7));
				doctor.setPosition(result.getString(8));
				doctor.setKeshi(result.getString(9));
				
				list.add(doctor);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

		}

		return list;
	}

}

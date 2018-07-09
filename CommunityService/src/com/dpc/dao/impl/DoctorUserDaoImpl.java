package com.dpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dpc.dao.DoctorUserDao;
import com.dpc.pojo.BloodPressure;
import com.dpc.pojo.Doctor;
import com.dpc.pojo.User;
import com.dpc.util.DBConnection;

//医生用户信息服务实现类
public class DoctorUserDaoImpl implements DoctorUserDao {

	private Connection con;

	public DoctorUserDaoImpl() {
		super();
		con = DBConnection.getConnection();

	}

	// 医生登录后台的方法
	@Override
	public Doctor checkDoctor(String userName, String password) {
		Doctor doctor = null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select doctorlogin.doctor_id, doctordetail.real_name,doctordetail.age,doctordetail.sex,doctordetail.address,doctordetail.phone_number,doctordetail.position,doctordetail.section from doctorlogin,doctordetail where doctorlogin.doctor_id=doctordetail.doctor_id and  username=? and password =?");
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				doctor = new Doctor();
				doctor.setDoctorid(result.getInt(1));
				doctor.setRealname(result.getString(2));
				doctor.setAge(result.getInt(3));
				doctor.setSex(result.getString(4));
				doctor.setAddress(result.getString(5));
				doctor.setPhonenumber(result.getString(6));
				doctor.setPosition(result.getString(7));
				doctor.setKeshi(result.getString(8));

			}
			return doctor;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DoctorUserDaoImpl err\n");
		}

		return null;
	}

	// 医生用户修改个人信息的方法

	// public Doctor updateInfo(Doctor doctor) {
	//
	// try {
	// PreparedStatement pstmt = con
	// .prepareStatement("update doctor set username=?,password=?,realname=?,age=?,sex=?,address=?,phoneNum=? where id=?");
	// pstmt.setString(1, doctor.getUserName());
	// pstmt.setString(2, doctor.getPassword());
	// pstmt.setString(3, doctor.getRealName());
	// pstmt.setInt(4, doctor.getAge());
	// pstmt.setString(5, doctor.getSex());
	// pstmt.setString(6, doctor.getAddress());
	// pstmt.setString(7, doctor.getPhoneNum());
	// pstmt.setString(8, doctor.get());
	// pstmt.executeUpdate();
	// pstmt.close();
	// return doctor;
	// } catch (Exception e) {
	// System.out.println("DoctorUserDao update Err\n");
	// e.printStackTrace();
	// }
	//
	// return null;
	// }

}

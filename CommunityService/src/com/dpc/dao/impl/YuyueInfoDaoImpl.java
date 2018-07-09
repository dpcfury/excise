package com.dpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dpc.dao.YuyueInfoDao;
import com.dpc.pojo.BloodPressure;
import com.dpc.pojo.YuyueDetail;
import com.dpc.util.DBConnection;

public class YuyueInfoDaoImpl implements YuyueInfoDao {

	private Connection con;

	public YuyueInfoDaoImpl() {
		super();
		con = DBConnection.getConnection();
	}
	
	@Override
	public boolean addYuyueInfo(YuyueDetail detail) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into orderdetail (user_id,patient_name,doctor_id,doctor_name,date,time,section) values(?,?,?,?,?,?,?) ");
			if (detail != null) {
				System.out.println(detail);
			} else {
				System.out.println("android 传过来的detail为空");
			}
			pstmt.setInt(1, detail.getUserid());
			pstmt.setString(2, detail.getPatientname());
			pstmt.setInt(3, detail.getDoctorid());
			pstmt.setString(4, detail.getDoctorname());
			pstmt.setString(5, detail.getDate());
			pstmt.setString(6, detail.getTime());
			pstmt.setString(7, detail.getKeshi());
			int result = pstmt.executeUpdate();// 代表插入更新操作的放回结果
			if (result > 0) {

				return true;
			} else {
				return false;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<YuyueDetail> getYuyueInfo(int userId) {
		List<YuyueDetail> list = new ArrayList<YuyueDetail>();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from orderdetail where user_id =?");
			pstmt.setInt(1, userId);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				YuyueDetail record = new YuyueDetail();
				record.setId(result.getInt(1));
				record.setUserid(result.getInt(2));
				record.setPatientname(result.getString(3));
				record.setDoctorid(result.getInt(4));
				record.setDoctorname(result.getString(5));
				record.setDate(result.getString(6));
				record.setTime(result.getString(7));
				record.setKeshi(result.getString(8));
				list.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean delYuyueInfo(String doctorname) {
		boolean result = false;
		try{
			PreparedStatement pstmt = con.prepareStatement("delete from orderdetail where doctor_name = ?");
			pstmt.setString(1, doctorname);
			int flag = pstmt.executeUpdate();
			if(flag !=0){
				result = true;
			}
			System.out.println("取消的结果:"+result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	//根据ID删除相应的预约信息
	public boolean delYuyueInfo(int id){
		boolean result = false;
		try{
			PreparedStatement pstmt = con.prepareStatement("delete from orderdetail where id = ?");
			pstmt.setInt(1, id);
			int flag = pstmt.executeUpdate();
			if(flag !=0){
				result = true;
			}
			System.out.println("取消的结果:"+result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	//带分页显示所有用户预约信息
	public List<YuyueDetail> getUserYuyueInfo(int offSet,int pageSize){
		List<YuyueDetail> list = new ArrayList<YuyueDetail>();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from orderdetail limit ?,?");
			pstmt.setInt(1, offSet);
			pstmt.setInt(2, pageSize);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				YuyueDetail record = new YuyueDetail();
				record.setId(result.getInt(1));
				record.setUserid(result.getInt(2));
				record.setPatientname(result.getString(3));
				record.setDoctorid(result.getInt(4));
				record.setDoctorname(result.getString(5));
				record.setDate(result.getString(6));
				record.setTime(result.getString(7));
				record.setKeshi(result.getString(8));
				list.add(record);
			}
			result.close();
			pstmt.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	//返回所有预约信息的条数
	public int getYuyueInfoCount(){
		int count=0;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select count(*) from orderdetail");
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				count=result.getInt(1);
			}
			result.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
		
	}
	
}

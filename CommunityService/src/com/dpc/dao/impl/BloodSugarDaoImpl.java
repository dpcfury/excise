package com.dpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.dpc.dao.BloodSugarDao;
import com.dpc.pojo.BloodPressure;
import com.dpc.pojo.BloodSugar;
import com.dpc.util.DBConnection;

public class BloodSugarDaoImpl implements BloodSugarDao {
	
	
	private Connection con;

	public BloodSugarDaoImpl() {
		super();
		con = DBConnection.getConnection();
	}

	// 添加记录的方法
	@Override
	public boolean addBloodSugarRecord(BloodSugar record) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into bsrecord (user_id,bsugar,date,flag) values(?,?,?,?) ");
			if (record != null) {
				System.out.println(record);
			} else {
				System.out.println("android 传过来的record为空");
			}
			System.out.println(String.valueOf(record.getLeftsugar())+"."+String.valueOf(record.getRightsugar()));
			System.out.println(Double.parseDouble("2.5"));
			pstmt.setInt(1, record.getUserId());
			pstmt.setDouble(2,Double.parseDouble(String.valueOf(record.getLeftsugar())+"."+String.valueOf(record.getRightsugar())));
			pstmt.setLong(3, record.getDate());
			pstmt.setInt(4, record.getFlag());
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
	
	//查询出所有记录
	@SuppressWarnings("unchecked")
	public List<BloodSugar> getBloodSugarRecord(int userId){
		List<BloodSugar> list = new ArrayList<BloodSugar>();
		
		try{
			PreparedStatement pstmt = con.prepareStatement("select * from bsrecord where user_id=? order by date desc limit 12");
			pstmt.setInt(1, userId);
			ResultSet result = pstmt.executeQuery();
			while(result.next()){
				BloodSugar bs = new BloodSugar();
				bs.setId(result.getInt(1));
				bs.setUserId(result.getInt(2));
				String sugar = String.valueOf(result.getDouble(3));
				String [] value = sugar.split("\\.");
				bs.setLeftsugar(Integer.parseInt(value[0]));
				bs.setRightsugar(Integer.parseInt(value[1]));
				bs.setDate(result.getLong(4));
				bs.setFlag(result.getInt(5));
				list.add(bs);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败");
		}
		
		Collections.sort(list);
		return list;
		
	}


}

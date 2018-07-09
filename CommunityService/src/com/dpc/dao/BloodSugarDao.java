package com.dpc.dao;

import java.util.List;

import com.dpc.pojo.BloodSugar;

public interface BloodSugarDao {
	//添加血糖的值
	public boolean addBloodSugarRecord(BloodSugar record);
	//查询血糖值
	public List<BloodSugar> getBloodSugarRecord(int userId);
	
	
}

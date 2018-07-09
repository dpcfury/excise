package com.dpc.service;

import java.util.List;

import com.dpc.pojo.BloodSugar;

public interface BloodSugarService {
		//插入血糖值
		public boolean addBloodSugarRecord(BloodSugar record);
		//查询所有血糖值
		public List<BloodSugar> getBloodSugarRecord(int userId);
}

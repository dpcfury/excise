package com.dpc.service;

import java.sql.Date;
import java.util.List;

import com.dpc.pojo.BloodPressure;

//血压上传记录的服务接口
public interface BloodPresureService {

	//添加记录的方法
	public boolean addBloodPresureRecord(BloodPressure record);
	
	//根据用户信息查询记录的方法
	public List<BloodPressure> findRecordByUserId(int userId);
	
	//根据日期和用户信息查询记录的方法
	public BloodPressure findRecordByDateUserId(Date date,int userId);
	
	//修改记录的方法
	public boolean updateBooldPresureRecord(BloodPressure record);
	
	//根据日期删除记录的方法
	public boolean deleteBloodPresureRecord(Date date,int userId);
	
	//查看最近一周血压测量指标的方法
	public List<BloodPressure> getRecentWeekRecord(int userId);
	
	//查看最近一个月的血压测量记录的方法
	public List<BloodPressure> getRecentMonthRecord(Date currentDate,int userId);
	
	//查看用户是否出现连续次数的指标不正常
	public boolean checkBPException(int userId);
	
	//获取连续不正常的测量指标的记录对象
	public List<BloodPressure> getUnNormalBPException(int userId);
	
}

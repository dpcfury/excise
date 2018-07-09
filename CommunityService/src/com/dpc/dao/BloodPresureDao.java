package com.dpc.dao;

import java.sql.Date;
import java.util.List;

import com.dpc.pojo.BloodPressure;

//高血压测量记录的Dao类(记录的基本的增删查改)
public interface BloodPresureDao {

	// 添加记录的方法
	public boolean addBloodPresureRecord(BloodPressure record);

	// 根据用户信息查询记录的方法
	public List<BloodPressure> findRecordByUserId(int userId);

	// 根据日期查询记录的方法
	public BloodPressure findRecordByDate(Date date, int UserId);

	// 修改记录的方法
	public boolean updateBooldPresureRecord(BloodPressure record);

	// 根据日期删除记录的方法
	public boolean deleteBloodPresureRecord(Date date, int userId);

	// 查看最近一周内的血压记录的方法
	public List<BloodPressure> getRecentWeeklyRecord(Date fromWhen, Date toWhen,
			int userId);
	
	//检测最近连续三次的记录是否异常
	public boolean checkBPException(int userId);
	
	//查询返回连续三次不正常的血压测量指标
	public List<BloodPressure> getUnNormalBPRecord(int userId);
	
	
}

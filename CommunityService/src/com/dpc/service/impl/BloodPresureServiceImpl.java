package com.dpc.service.impl;

import java.sql.Date;
import java.util.List;

import com.dpc.dao.BloodPresureDao;
import com.dpc.pojo.BloodPressure;
import com.dpc.service.BloodPresureService;
import com.dpc.util.DateUtil;

//血压记录的服务实现类
public class BloodPresureServiceImpl implements BloodPresureService {

	private BloodPresureDao bloodPresureDao;

	// 方便Spring依赖注入
	public BloodPresureDao getBloodPresureDao() {
		return bloodPresureDao;
	}

	public void setBloodPresureDao(BloodPresureDao bloodPresureDao) {
		this.bloodPresureDao = bloodPresureDao;
	}

	// 添加血压测量记录的方法
	public boolean addBloodPresureRecord(BloodPressure record) {
		return bloodPresureDao.addBloodPresureRecord(record);
	}

	// 根据用户信息查找对应的上传记录
	public List<BloodPressure> findRecordByUserId(int userId) {
		return bloodPresureDao.findRecordByUserId(userId);
	}

	// 根据日期和用户id查找对应的记录
	public BloodPressure findRecordByDateUserId(Date date, int userId) {
		return bloodPresureDao.findRecordByDate(date, userId);
	}

	// 修改用户上传的记录
	public boolean updateBooldPresureRecord(BloodPressure record) {
		return bloodPresureDao.updateBooldPresureRecord(record);
	}

	// 根据日期和用户id删除对应的上传记录
	public boolean deleteBloodPresureRecord(Date date, int userId) {
		return bloodPresureDao.deleteBloodPresureRecord(date, userId);
	}

	// 根据当天的日期查看最近一周内的血压测量记录
	@Override
	public List<BloodPressure> getRecentWeekRecord(int userId) {

		return bloodPresureDao.findRecordByUserId(userId);
	}

	// 查看最近一个月内血压测量记录的方法
	@Override
	public List<BloodPressure> getRecentMonthRecord(Date currentDate, int userId) {
		Date pre=DateUtil.getPreMonthDate(currentDate);
		
		return bloodPresureDao.getRecentWeeklyRecord(pre, currentDate, userId);
	}

	//检测某个用户是否出现了连续次数的上传指标不正常
	@Override
	public boolean checkBPException(int userId) {
		
		return bloodPresureDao.checkBPException(userId);
	}

	//获取连续不正常的血压测量值得记录集合
	@Override
	public List<BloodPressure> getUnNormalBPException(int userId) {
		
		return bloodPresureDao.getUnNormalBPRecord(userId);
	}

}

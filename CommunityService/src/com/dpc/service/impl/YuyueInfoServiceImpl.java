package com.dpc.service.impl;

import java.util.List;

import com.dpc.dao.YuyueInfoDao;
import com.dpc.pojo.YuyueDetail;
import com.dpc.service.YuyueInfoService;

public class YuyueInfoServiceImpl implements YuyueInfoService {

	private YuyueInfoDao yuyueInfoDao;
	
	
	
	public YuyueInfoDao getYuyueInfoDao() {
		return yuyueInfoDao;
	}



	public void setYuyueInfoDao(YuyueInfoDao yuyueInfoDao) {
		this.yuyueInfoDao = yuyueInfoDao;
	}



	@Override
	public boolean addYuyueInfo(YuyueDetail detail) {
		return yuyueInfoDao.addYuyueInfo(detail);
	}



	@Override
	public List<YuyueDetail> getYuyueInfo(int userId) {
		return yuyueInfoDao.getYuyueInfo(userId);
	}



	@Override
	public boolean delYuyueInfo(String doctorname) {
		
		return yuyueInfoDao.delYuyueInfo(doctorname);
	}
	
	//根据ID删除对应的预约信息
	public boolean delYuyueInfo(int id){
		return yuyueInfoDao.delYuyueInfo(id);
	}

	//返回所有预约信息的条数
	public int getYuyueInfoCount(){
		return yuyueInfoDao.getYuyueInfoCount();
	}
	
	
	//带分页显示所有用户的预约信息
	public List<YuyueDetail> getUserYuyueInfo(int pageSize,int nowPage,int pageCount){
		int offSet=0;
		int targetPage=1;
		
		if(nowPage<1)
			targetPage=1;
		else if(nowPage>pageCount)
			targetPage=pageCount;
		else
			targetPage=nowPage;
		
		offSet=(targetPage -1)*pageSize;
		
		return yuyueInfoDao.getUserYuyueInfo(offSet, pageSize);
	
	}
}

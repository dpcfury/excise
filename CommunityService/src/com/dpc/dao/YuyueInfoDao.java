package com.dpc.dao;

import java.util.List;

import com.dpc.pojo.YuyueDetail;

public interface YuyueInfoDao {
	
	//添加记录的方法
	public boolean addYuyueInfo(YuyueDetail detail);
	
	//查询记录的方法
	public List<YuyueDetail> getYuyueInfo(int userId);
	
	//删除预约信息
	public boolean delYuyueInfo(String doctorname);
	
	//删除预约信息根据ID
	public boolean delYuyueInfo(int id);
	
	//返回所有预约信息的条数
	public int getYuyueInfoCount();
	
	//带分页显示所有用户预约信息
	public List<YuyueDetail> getUserYuyueInfo(int offSet,int pageSize);
}


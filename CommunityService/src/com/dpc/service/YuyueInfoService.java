package com.dpc.service;

import java.util.List;

import com.dpc.pojo.YuyueDetail;

public interface YuyueInfoService {
	
	//增加预约信息
	public boolean addYuyueInfo(YuyueDetail detail);
	
	//查看预约信息
	public List<YuyueDetail> getYuyueInfo(int UserId);
	
	//删除预约信息
	public boolean delYuyueInfo(String doctorname);
	
	//根据ID删除对应的预约信息
	public boolean delYuyueInfo(int id);
	
	//返回所有预约信息的条数
	public int getYuyueInfoCount();
	
	//带分页显示所有用户的预约信息
	public List<YuyueDetail> getUserYuyueInfo(int pageSize,int nowPage,int pageCount);
}

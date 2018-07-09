package com.dpc.service;

import com.dpc.pojo.UserPush;

//推送消息的服务类接口
public interface PushService {

	//添加一个移动端用户的标示(包括baiduUserId和channelId)
	public boolean addUserPushList(int id,String baiduUserId,String channelId);
	
	//更新一个移动端用户的标示(包括baiduUserId和channelId)
	public boolean updateUserPushList(int id,String baiduUSerId,String channelId);
	
	//根据id检查一个用户是否在userpushlist表格中
	public boolean isExists(int id);
	
	//得到用户信息
	public UserPush getUserByID(int id);
}

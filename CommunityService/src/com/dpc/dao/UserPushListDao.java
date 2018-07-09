package com.dpc.dao;

import com.dpc.pojo.UserPush;

//居民用户的百度userid和channelid表的底层访问接口
public interface UserPushListDao {

	//插入一个用户的百度userid和channelId
	public boolean addUserPushList(int id,String baiduUserID,String channelId);
	
	//更新一个具体用户的百度userId和channelId
	public boolean updateUserPushList(int id,String baiduUserId,String channelId);
	
	//根据用户的id查找pushlist表中是否已经有记录
	public boolean isExists(int id);
	
	//根据用户的userId推送消息
	public UserPush getUser(int id);
}

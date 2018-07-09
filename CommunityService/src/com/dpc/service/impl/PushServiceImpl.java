package com.dpc.service.impl;

import com.dpc.dao.UserPushListDao;
import com.dpc.pojo.UserPush;
import com.dpc.service.PushService;

//推送服务的实现类
public class PushServiceImpl implements PushService {

	private UserPushListDao userPushListDao;
	//添加一个移动端用户的pushService绑定获得的baiduuserid和channelId
	@Override
	public boolean addUserPushList(int id, String baiduUserId, String channelId) {
		
		return userPushListDao.addUserPushList(id, baiduUserId, channelId);
	}

	//更新一个移动端用户的pushService绑定获得的baiduuserid和channelId
	@Override
	public boolean updateUserPushList(int id, String baiduUSerId, String channelId) {
		return userPushListDao.updateUserPushList(id, baiduUSerId, channelId);
	}

	public UserPushListDao getUserPushListDao() {
		return userPushListDao;
	}

	public void setUserPushListDao(UserPushListDao userPushListDao) {
		this.userPushListDao = userPushListDao;
	}

	
	@Override
	public boolean isExists(int id) {
		return userPushListDao.isExists(id);
	}
	//得到用户推送baiduUserID和channelID
	@Override
	public UserPush getUserByID(int id) {
		// TODO Auto-generated method stub
		return userPushListDao.getUser(id);
	}

	

	
	
	
}

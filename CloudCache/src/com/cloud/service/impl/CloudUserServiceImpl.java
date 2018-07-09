package com.cloud.service.impl;

import com.cloud.dao.CloudUserDao;
import com.cloud.pojo.CloudUser;
import com.cloud.service.CloudUserService;

//clouduser服务类的实现
public class CloudUserServiceImpl implements CloudUserService{

	private CloudUserDao cloudUserDao;
	
	//根据用户名和密码判断用户是否存在
	@Override
	public CloudUser isexists(String userName, String password) {
		return cloudUserDao.checkUserByUserNamePwd(userName, password);
	}

	//添加一个clouduser用户
	@Override
	public boolean addUser(CloudUser user) {
		return cloudUserDao.addCloudUser(user);
	}

	public CloudUserDao getCloudUserDao() {
		return cloudUserDao;
	}

	public void setCloudUserDao(CloudUserDao cloudUserDao) {
		this.cloudUserDao = cloudUserDao;
	}
	
	
	
}

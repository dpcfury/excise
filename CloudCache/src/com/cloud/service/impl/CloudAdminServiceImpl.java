package com.cloud.service.impl;

import com.cloud.dao.CloudAdminDao;
import com.cloud.pojo.CloudAdmin;
import com.cloud.service.CloudAdminService;

//管理员服务类实现类
public class CloudAdminServiceImpl implements CloudAdminService{

	private CloudAdminDao cloudAdminDao;
	
	//根据用户名和密码判断管理员用户是否存在
	@Override
	public CloudAdmin isExists(String adminName, String password) {
		
		return cloudAdminDao.checkAdmin(adminName, password);
	}

	public CloudAdminDao getCloudAdminDao() {
		return cloudAdminDao;
	}

	public void setCloudAdminDao(CloudAdminDao cloudAdminDao) {
		this.cloudAdminDao = cloudAdminDao;
	}

	

	
	
}

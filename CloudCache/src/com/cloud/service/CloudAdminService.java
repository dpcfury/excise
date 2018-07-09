package com.cloud.service;

import com.cloud.pojo.CloudAdmin;

//管理员信息服务类接口
public interface CloudAdminService{
	
	//根据用户名和密码判断管理员用户是否存在
	public CloudAdmin isExists(String adminName,String password);
	
}

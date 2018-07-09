package com.cloud.service;

import com.cloud.pojo.CloudUser;


//CloudUser基础服务类接口
public interface CloudUserService {

	//根据用户名和密码检测用户是否存在
	public CloudUser isexists(String userName,String password);
	
	//添加新的clouduser信息
	public boolean addUser(CloudUser user);
}

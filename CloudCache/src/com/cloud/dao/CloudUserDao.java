package com.cloud.dao;

import com.cloud.pojo.CloudUser;

//底层cloudUser与数据库操作的接口
public interface CloudUserDao {

	//根据用户名和密码判断数据库中是否存在该用户
	public CloudUser checkUserByUserNamePwd(String userName,String password);
	
	//添加新用户
	public boolean addCloudUser(CloudUser user);
}

package com.cloud.dao;

import com.cloud.pojo.CloudAdmin;

//底层管理员信息Dao 接口
public interface CloudAdminDao {

	//根据管理员输入的用户名和密码判断
	public CloudAdmin checkAdmin(String adminName,String password);
}

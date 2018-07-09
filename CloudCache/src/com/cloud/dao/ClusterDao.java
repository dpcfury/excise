package com.cloud.dao;

import java.util.List;

import com.cloud.pojo.ClusterNode;

//负责集群相关参数的Dao接口类
public interface ClusterDao {

	
	//根据用户的id查找属于其的节点信息List
	public List<ClusterNode> getNodeListByUserID(int userID);
}

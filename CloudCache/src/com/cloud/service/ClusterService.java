package com.cloud.service;

import java.util.List;

import com.cloud.pojo.ClusterNode;

//集群操作的服务类接口
public interface ClusterService {

	//查看某个用户的拥有的缓存节点列表
	public List<ClusterNode> getUserNodeList(int userID);
	
}

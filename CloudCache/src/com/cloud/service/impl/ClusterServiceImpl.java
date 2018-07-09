package com.cloud.service.impl;

import java.util.List;

import com.cloud.dao.ClusterDao;
import com.cloud.pojo.ClusterNode;
import com.cloud.service.ClusterService;

//集群操作服务接口的实现类
public class ClusterServiceImpl implements ClusterService{
	
	private ClusterDao clusterDao;

	//查询并返回一个用户拥有缓存节点列表
	@Override
	public List<ClusterNode> getUserNodeList(int userID) {
		
		return clusterDao.getNodeListByUserID(userID);
	}

	public ClusterDao getClusterDao() {
		return clusterDao;
	}

	public void setClusterDao(ClusterDao clusterDao) {
		this.clusterDao = clusterDao;
	}

	
}

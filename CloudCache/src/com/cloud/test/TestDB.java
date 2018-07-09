package com.cloud.test;

import java.util.List;

import com.cloud.dao.ClusterDao;
import com.cloud.dao.impl.ClusterDaoImpl;
import com.cloud.pojo.ClusterNode;

public class TestDB {

	public static void main(String[] args) {
		
		ClusterDao clusterDao =new ClusterDaoImpl();
		List<ClusterNode> list =clusterDao.getNodeListByUserID(1);
		
		if(list!=null){
			System.out.println(list);
			System.out.println(list.size());
		}else{
			System.out.println("error");
		}
	}
}

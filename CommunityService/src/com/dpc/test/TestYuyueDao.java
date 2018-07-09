package com.dpc.test;

import com.dpc.dao.YuyueInfoDao;
import com.dpc.dao.impl.YuyueInfoDaoImpl;

public class TestYuyueDao {
	public static void main(String[] args) {
			YuyueInfoDao yuyueDao =new YuyueInfoDaoImpl();
			
			System.out.println(yuyueDao.getYuyueInfoCount());
			
	}
}

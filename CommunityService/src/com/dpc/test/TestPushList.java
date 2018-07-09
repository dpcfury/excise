package com.dpc.test;

import com.dpc.dao.UserPushListDao;
import com.dpc.dao.impl.UserPushListDaoImpl;

public class TestPushList {

	
	public static void main(String[] args) {
		UserPushListDao pushDao =new UserPushListDaoImpl();
		
//		pushDao.addUserPushList(1,"dsaeecg144fs", "dsadttc215");
		
		pushDao.updateUserPushList(1, "cao", "cao");
	}
}

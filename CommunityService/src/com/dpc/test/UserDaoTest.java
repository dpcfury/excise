package com.dpc.test;

import com.dpc.dao.DoctorUserDao;
import com.dpc.dao.UserDao;
import com.dpc.dao.impl.DoctorUserDaoImpl;
import com.dpc.dao.impl.UserDaoImpl;
import com.dpc.pojo.Doctor;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDao userDao =new UserDaoImpl();

//		System.out.println(userDao.getUserInfo(10, 10));
//		System.out.println(userDao.getHBPUserInfo(0, 10).size());
//		String title="注意注意";
//		String message="涛哥喜欢大长腿";
//		
//		String msg ="{\"title\":\""+title+"\",\""+"message"+"\":\""+message+"\"}";
//		System.out.println(msg);
//		
//		DoctorUserDao doctorDao=new DoctorUserDaoImpl();
//		
//		Doctor doctor =doctorDao.checkDoctor("ddd", "123");
//		
//		if(doctor==null){
//			System.out.println("doctor 为空");
//		}
//		System.out.println(userDao.getHBSUserInfo(0, 10));
		System.out.println(System.currentTimeMillis());
//		
	}
}

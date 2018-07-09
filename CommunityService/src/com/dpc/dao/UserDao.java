package com.dpc.dao;

import java.util.List;

import com.dpc.pojo.User;


//实现user用户信息的增删查改操作
public interface UserDao {

	//根据用户名和密码检查用户是否存在，如果存在即返回一个完整的user对象
	public User checkUserByUserNamePwd(String userName,String password);
	
	
	//返回所有的居民信息记录条数
	public int getUserInfoCount();
	
	//返回所有的居民用户信息
	public List<User> getAllUserInfo();
	
	//带分页的返回部分居民的信息
	public List<User> getUserInfo(int offSet,int recordCount);
	
	//添加一个可登陆的居民用户账号()
	public boolean addUserLogin(User user);
	
	//添加居民用户的具体信息
	public boolean addUserDetail(User user);
	
	//根据用户名和口令获得居民用户的Id
	public int getUserId(String userName,String password);
	
	//删除某个居民用户
	public boolean deleteUser(int userId);
	
	//获得患有高血压的居民人数
	public int getHBPUserCount();
	
	//获得有高血压疾病的居民用户信息
	public List<User>getUsersWithHBP();
	
	
	//带分页的获得部分高血压居民的信息
	public List<User>getHBPUserInfo(int offSet ,int pageCount);
	
	//获得所有患有糖尿病的患者的人数
	public int getHBSUserCount();
	
	//带分页获得部分糖尿病患者信息
	public List<User> getHBSUserInfo(int offSet ,int pageCount);
	
	//根据id获得具体的一个用户user对象
	public User getUserById(int id);
		
		
		
}

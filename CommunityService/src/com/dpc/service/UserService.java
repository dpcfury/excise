package com.dpc.service;

import java.util.List;

import com.dpc.pojo.User;

//定义user用户类的服务接口
public interface UserService {

	//通过用户名和口令检查用户是否存在
	public User checkUserByUserNamePwd(String userName,String password);
	
	//添加一个居民用户
	public boolean addUser(User user);
	
	//删除一个居民用户
	public boolean deleteUser(int userId);
	
	//获得患有高血压疾病的居民人数
	public int getHBPUserCount();
	
	//获得患有糖尿病的居民人数
	public int getHBSUserCount();
	
	//获得有高血压的居民集合
	public List<User> getUsersWithHBP();
	
	//带分页的获得部分高血压居民的信息
	public List<User> getHBPUserInfo(int pageSize,int nowPage,int pageCount);
	
	//带分页获取部分糖尿病患者的信息
	public List<User> getHBSUserInfo(int pageSize,int nowPage,int pageCount);
	
	//获得全部居民信息
	public List<User> getAllUser();
	
	//获得所有居民信息的条数
	public int getUserInfoCount();
	
	//带分页的获得部分居民的信息
	public List<User> getUserInfo(int pageSize,int nowPage,int pageCount);
	
	//根据id获得居民User对象
	public User getUserById(int id);
}

package com.dpc.service.impl;

import java.util.List;

import com.dpc.dao.UserDao;
import com.dpc.dao.impl.UserDaoImpl;
import com.dpc.pojo.User;
import com.dpc.service.UserService;

//用户服务接口的实现类
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 检查用户是否存在
	@Override
	public User checkUserByUserNamePwd(String userName, String password) {
		return userDao.checkUserByUserNamePwd(userName, password);

	}

	// 添加一个居民用户
	@Override
	public boolean addUser(User user) {
		boolean result = false;
		int id = 0;
		// 首先添加该用户的登录账户
		if (userDao.addUserLogin(user)) {
			id = userDao.getUserId(user.getUsername(), user.getPassword());
			if (id != 0) {
				user.setUserid(id);
				if (userDao.addUserDetail(user)) {
					result = true;
				}
			}
		}

		// 获得用户的注册id
		// 添加详细信息

		return result;
	}

	// 根据id删除某个居民用户
	@Override
	public boolean deleteUser(int userId) {

		return userDao.deleteUser(userId);
	}
	
	//获得患有高血压疾病的居民 的人数
	public int getHBPUserCount(){
		return userDao.getHBPUserCount();
	}

	// 获得所有患有高血压的居民集合
	@Override
	public List<User> getUsersWithHBP() {
		return userDao.getUsersWithHBP();
	}

	@Override
	public List<User> getAllUser() {

		return userDao.getAllUserInfo();
	}

	// 根据居民用户的id查找并返回user对象
	@Override
	public User getUserById(int id) {

		return userDao.getUserById(id);
	}

	// 带分页的获得部分居民的信息
	@Override
	public List<User> getUserInfo(int pageSize,int nowPage,int pageCount) {
		int offSet=0;
		int targetPage=1;
		
		if(nowPage<1)
			targetPage=1;
		else if(nowPage>pageCount)
			targetPage=pageCount;
		else
			targetPage=nowPage;
		
		offSet=(targetPage -1)*pageSize;
		
		return userDao.getUserInfo(offSet, pageSize);
	}

	//带分页的获得部分高血压居民的信息
	public List<User> getHBPUserInfo(int pageSize,int nowPage,int pageCount){
		int offSet=0;
		int targetPage=1;
		
		if(nowPage<1)
			targetPage=1;
		else if(nowPage>pageCount)
			targetPage=pageCount;
		else
			targetPage=nowPage;
		
		offSet=(targetPage -1)*pageSize;
		
		return userDao.getHBPUserInfo(offSet, pageSize);
	}
	
	// 获得所有居民信息的条数
	public int getUserInfoCount() {
		return userDao.getUserInfoCount();
	}

	//获得患有糖尿病的居民人数
	public int getHBSUserCount(){
		return userDao.getHBSUserCount();
	}
	
	//带分页获取部分糖尿病患者的信息
	public List<User> getHBSUserInfo(int pageSize,int nowPage,int pageCount){
		int offSet=0;
		int targetPage=1;
		
		if(nowPage<1)
			targetPage=1;
		else if(nowPage>pageCount)
			targetPage=pageCount;
		else
			targetPage=nowPage;
		
		offSet=(targetPage -1)*pageSize;
		
		return userDao.getHBSUserInfo(offSet, pageSize);
	}
	
}

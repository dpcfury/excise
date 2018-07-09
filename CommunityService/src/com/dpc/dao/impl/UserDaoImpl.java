package com.dpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dpc.dao.UserDao;
import com.dpc.pojo.User;
import com.dpc.util.DBConnection;

public class UserDaoImpl implements UserDao {

	private Connection con;

	public UserDaoImpl() {
		super();
		con = DBConnection.getConnection();
	}

	// 根据用户名和密码检查用户是否存在如果存在就返回一个user对象，否则为空
	@Override
	public User checkUserByUserNamePwd(String userName, String password) {
		System.out.println("服务器端的接受到的信息 : username:" + userName);
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select a.user_id,a.username,a.password,b.real_name,b.sex,b.age,b.address,b.phone"
							+ " from userLogin as a,userDetail as b "
							+ "where a.user_id=b.id and a.username=? and a.password=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				User user = new User();
				int id = result.getInt(1);
				String username = result.getString(2);
				String pwd = result.getString(3);
				String realName = result.getString(4);
				String sex = result.getString(5);
				int age = result.getInt(6);
				String address = result.getString(7);
				String phone = result.getString(8);
				user.setUserid(id);
				user.setUsername(username);
				user.setPassword(pwd);
				user.setRealname(realName);
				user.setSex(sex);
				user.setAge(age);
				user.setAddress(address);
				user.setPhonenumber(phone);
				return user;
			}
			result.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// 获得所有的用户信息
	@Override
	public List<User> getAllUserInfo() {
		List<User> list = new ArrayList<User>();

		try {
			PreparedStatement pstmt = con
					.prepareStatement("select a.user_id,a.username,a.password,b.real_name,b.sex,b.age,b.address,b.phone from userLogin as a,userDetail as b where a.user_id=b.id");
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				User user = new User();
				user.setUserid(result.getInt(1));
				user.setUsername(result.getString(2));
				user.setPassword(result.getString(3));
				user.setRealname(result.getString(4));
				user.setSex(result.getString(5));
				user.setAge(result.getInt(6));
				user.setAddress(result.getString(7));
				user.setPhonenumber(result.getString(8));

				list.add(user);
			}

			result.close();
			pstmt.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 添加居民的登录账号信息
	@Override
	public boolean addUserLogin(User user) {

		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into userlogin(username,password) values(?,?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());

			pstmt.executeUpdate();
			pstmt.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// 添加居民用户的具体信息
	@Override
	public boolean addUserDetail(User user) {

		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into userdetail(real_name,sex,age,user_id,address,phone) values(?,?,?,?,?,?)");
			pstmt.setString(1, user.getRealname());
			pstmt.setString(2, user.getSex());
			pstmt.setInt(3, user.getAge());
			pstmt.setInt(4, user.getUserid());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getPhonenumber());

			pstmt.executeUpdate();

			pstmt.close();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 根据居民用户的用户名和口令获得用户的id (返回0)代表出错
	@Override
	public int getUserId(String userName, String password) {
		int id = 0;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select user_id from userlogin where username=? and password=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, password);

			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				id = result.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	// 根据id删除某个居民用户
	@Override
	public boolean deleteUser(int userId) {
		boolean result = false;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("delete from userLogin where user_id=?");
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//计算患有高血压疾病的居民的总人数
	public int getHBPUserCount(){
		int count=0;
		try{
			PreparedStatement pstmt =con.prepareStatement("select count(*) from userwithhbp");
			ResultSet result=pstmt.executeQuery();
			while(result.next()){
				count=result.getInt(1);
			}
			result.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count;
	}
	
	//获得所有患有糖尿病的患者的人数
	public int getHBSUserCount(){
		int count=0;
		try{
			PreparedStatement pstmt =con.prepareStatement("select count(*) from userwithhbs");
			ResultSet result=pstmt.executeQuery();
			while(result.next()){
				count=result.getInt(1);
			}
			result.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count;
	}
	
	// 筛选出出有高血压疾病的用户
	@Override
	public List<User> getUsersWithHBP() {
		List<User> list = new ArrayList<User>();
		try {

			PreparedStatement pstmt = con
					.prepareStatement("select a.user_id,a.username,a.password,c.real_name,c.sex,c.age,c.address,c.phone from userlogin as a, userwithhbp as b,userdetail as c where a.user_id=b.userId and a.user_id=c.id");
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				User user = new User();
				user.setUserid(result.getInt(1));
				user.setUsername(result.getString(2));
				user.setPassword(result.getString(3));
				user.setRealname(result.getString(4));
				user.setSex(result.getString(5));
				user.setAge(result.getInt(6));
				user.setAddress(result.getString(7));
				user.setPhonenumber(result.getString(8));

				list.add(user);
			}

			result.close();
			pstmt.close();

			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	//带分页的获得部分高血压居民的信息
		public List<User>getHBPUserInfo(int offSet ,int pageCount){
			List<User> list = new ArrayList<User>();
			try {

				PreparedStatement pstmt = con
						.prepareStatement("select a.user_id,a.username,a.password,c.real_name,c.sex,c.age,c.address,c.phone from userlogin as a, userwithhbp as b,userdetail as c where a.user_id=b.userId and a.user_id=c.id limit ?,?");
				pstmt.setInt(1, offSet);
				pstmt.setInt(2, pageCount);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					User user = new User();
					user.setUserid(result.getInt(1));
					user.setUsername(result.getString(2));
					user.setPassword(result.getString(3));
					user.setRealname(result.getString(4));
					user.setSex(result.getString(5));
					user.setAge(result.getInt(6));
					user.setAddress(result.getString(7));
					user.setPhonenumber(result.getString(8));

					list.add(user);
				}

				result.close();
				pstmt.close();

				return list;
			} catch (Exception e) {
				e.printStackTrace();

			}

			return null;
		}
	
	@Override
	public User getUserById(int id) {
		User user = null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select a.user_id,a.username,a.password,b.real_name,b.sex,b.age,b.address,b.phone from userLogin as a,userDetail as b where a.user_id=b.id and a.user_id=?");
			pstmt.setInt(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				user = new User();

				user.setUserid(result.getInt(1));
				user.setUsername(result.getString(2));
				user.setPassword(result.getString(3));
				user.setRealname(result.getString(4));
				user.setSex(result.getString(5));
				user.setAge(result.getInt(6));
				user.setAddress(result.getString(7));
				user.setPhonenumber(result.getString(8));

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return user;
	}

	// 返回居民信息的条数
	public int getUserInfoCount() {
		int count = 0;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select count(*) from userLogin as a,userDetail as b where a.user_id=b.id ");
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				count=result.getInt(1);
			}

			result.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	// 带分页的返回部分居民的信息
	@Override
	public List<User> getUserInfo(int offSet, int recordCount) {
		List<User> list = new ArrayList<User>();

		try {
			PreparedStatement pstmt = con
					.prepareStatement("select a.user_id,a.username,a.password,b.real_name,b.sex,b.age,b.address,b.phone from userLogin as a,userDetail as b where a.user_id=b.id limit ? ,?");
			pstmt.setInt(1, offSet);
			pstmt.setInt(2, recordCount);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				User user = new User();
				user.setUserid(result.getInt(1));
				user.setUsername(result.getString(2));
				user.setPassword(result.getString(3));
				user.setRealname(result.getString(4));
				user.setSex(result.getString(5));
				user.setAge(result.getInt(6));
				user.setAddress(result.getString(7));
				user.setPhonenumber(result.getString(8));

				list.add(user);
			}

			result.close();
			pstmt.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	//带分页获得部分糖尿病患者信息
	public List<User> getHBSUserInfo(int offSet ,int pageSize){
		List<User> list = new ArrayList<User>();
		try {

			PreparedStatement pstmt = con
					.prepareStatement("select a.user_id,a.username,a.password,c.real_name,c.sex,c.age,c.address,c.phone from userlogin as a, userwithhbs as b,userdetail as c where a.user_id=b.user_id and a.user_id=c.id limit ?,?");
			pstmt.setInt(1, offSet);
			pstmt.setInt(2, pageSize);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				User user = new User();
				user.setUserid(result.getInt(1));
				user.setUsername(result.getString(2));
				user.setPassword(result.getString(3));
				user.setRealname(result.getString(4));
				user.setSex(result.getString(5));
				user.setAge(result.getInt(6));
				user.setAddress(result.getString(7));
				user.setPhonenumber(result.getString(8));

				list.add(user);
			}

			result.close();
			pstmt.close();

			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

}

package com.cloud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cloud.dao.CloudUserDao;
import com.cloud.pojo.CloudUser;
import com.cloud.util.DBConnection;

//对clouduser表操作的Dao的实现类
public class CloudUserDaoImpl implements CloudUserDao {

	private Connection con = DBConnection.getConnection();

	// 根据用户名和密码判断用户是否存在的方法
	@Override
	public CloudUser checkUserByUserNamePwd(String userName, String password) {
		CloudUser user = null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select id,username,password,memsize from clouduser where username=? and password =?");
			pstmt.setString(1, userName);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new CloudUser();
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setMemsize(rs.getInt(4));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return user;
	}

	// 添加新用户的方法
	@Override
	public boolean addCloudUser(CloudUser user) {
		boolean result = false;// 定义添加的返回结果result
		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into clouduser (username,password,memsize) values(?,?,?)");
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getPassword());
			pstmt.setInt(3, user.getMemsize());
			
			pstmt.executeUpdate();
			result=true;
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

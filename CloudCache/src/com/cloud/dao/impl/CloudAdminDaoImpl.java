package com.cloud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cloud.dao.CloudAdminDao;
import com.cloud.pojo.CloudAdmin;
import com.cloud.util.DBConnection;

//负责底层和管理员身份信息处理的Dao的实现类
public class CloudAdminDaoImpl implements CloudAdminDao {

	private Connection con = DBConnection.getConnection();// 数据库连接对象s

	// 根据用户名和口令判断是否存在该管理员
	@Override
	public CloudAdmin checkAdmin(String adminName, String password) {
		CloudAdmin admin = null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select id, adminname,password from cloudadmin where adminname=? and password=?");
			pstmt.setString(1, adminName);
			pstmt.setString(2, password);
			
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()){
				admin=new CloudAdmin();
				admin.setId(rs.getInt(1));
				admin.setAdminName(rs.getString(2));
				admin.setPassword(rs.getString(3));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return admin;
	}

}

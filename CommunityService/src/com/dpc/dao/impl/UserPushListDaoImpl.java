package com.dpc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dpc.dao.UserPushListDao;
import com.dpc.pojo.UserPush;
import com.dpc.util.DBConnection;

public class UserPushListDaoImpl implements UserPushListDao {

	private Connection con = DBConnection.getConnection();

	// 向推送服务列表中添加一个用用户的baiduUserId和channelId
	@Override
	public boolean addUserPushList(int id, String baiduUserID, String channelId) {
		boolean result = false;
		PreparedStatement pstmt;
		try {
			pstmt = con
					.prepareStatement("insert into userpushlist (id,baiduUserId,channelId) values(?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, baiduUserID);
			pstmt.setString(3, channelId);

			int row = pstmt.executeUpdate();
			if (row > 0) {

				result = true;
				System.out.println("userPushList 已经成功添加了" + row + "条信息");
			}

			pstmt.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}

	// 在原有的用户推送相关信息上执行更新
	@Override
	public boolean updateUserPushList(int id, String baiduUserId,
			String channelId) {
		boolean result = false;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("update userpushlist set baiduUserId=? ,channelId=? where id=?");
			pstmt.setString(1, baiduUserId);
			pstmt.setString(2, channelId);
			pstmt.setInt(3, id);

			int row = pstmt.executeUpdate();

			if (row > 0) {
				result = true;
				System.out.println("userPushList 已经成功更新了" + row + "条信息");
			}

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean isExists(int id) {
		boolean result = false;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select id from userpushlist where id=?");
			pstmt.setInt(1, id);
			
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()){
				result = true;
				System.out.println("userPushList 表中" + id + "用户推送的信息已经存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
     //根据baiduUserID和channelId推送消息
	@Override
	public UserPush getUser(int id) {
		// TODO Auto-generated method stub
		UserPush u=null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from userpushlist where id=?");
			pstmt.setInt(1, id);			
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()){	
				u=new UserPush();
				u.setId(rs.getInt(1));
				u.setBaiduUserId(rs.getString(2));
				u.setChannelId(Long.parseLong(rs.getString(3)));			 
				System.out.println("userPushList 表中" +u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	

}

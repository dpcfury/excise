package com.cloud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cloud.dao.ClusterDao;
import com.cloud.pojo.ClusterNode;
import com.cloud.util.DBConnection;

//集群信息操作接口ClusterDao的实现类
public class ClusterDaoImpl implements ClusterDao {

	private Connection con = DBConnection.getConnection();

	// 根据用户的id查找并返回其缓存节点的列表
	@Override
	public List<ClusterNode> getNodeListByUserID(int userID) {
		List<ClusterNode> list = new ArrayList<ClusterNode>();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select clouduser.id,clouduser.username,userdockerip.dockerIP,dockeripid.dockerID,dockerphics.phicsIP,dockerredis.redisID from clouduser,userdockerip,dockeripid,dockerphics,dockerredis where clouduser.id=? and clouduser.id=userdockerip.userid and userdockerip.dockerIP=dockeripid.dockerIP and userdockerip.dockerIP=dockerphics.dockerIP and userdockerip.dockerIP=dockerredis.dockerIP;");
			pstmt.setInt(1,userID);
			
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()){
				ClusterNode node =new ClusterNode();
				node.setUserID(userID);
				node.setUserName(rs.getString(2));
				node.setDockerIP(rs.getString(3));
				node.setDockerID(rs.getString(4));
				node.setPhicsIP(rs.getString(5));
				node.setRedisID(rs.getString(6));
				
				list.add(node);
			}
			rs.close();
			pstmt.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

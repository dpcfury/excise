package com.dpc.test;

import java.sql.Connection;

import com.dpc.util.DBConnection;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection con =DBConnection.getConnection();
		
		if(con!=null){
			System.out.println("con连接是可以的");
			
		}else{
			System.out.println("con连接失败 ，可能是url错误");
		}
	}
}

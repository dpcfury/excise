package com.dpc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//创建数据源的类，负责返回一个connection
public class DBConnection {
	
	private static Connection con;

	public static Connection getConnection() {
		try {
			// 加载MySql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
		try {
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/communityCenter?useUnicode=true&characterEncoding=gb2312",
							"root", "");
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
		}
		
		System.out.println("建立并返回连接成功");
		return con;

	}
}

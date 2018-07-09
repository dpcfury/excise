package com.dpc.test;

import java.sql.Date;

import com.dpc.util.DateUtil;

//测试java.sql。Date相关的一些 操作
public class TestDate {

	public static void main(String[] args) {
		Date today = new Date(System.currentTimeMillis());
		Date pre= DateUtil.getPreMonthDate(today);
		System.out.println(pre);
	}
}

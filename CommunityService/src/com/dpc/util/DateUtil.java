package com.dpc.util;

import java.sql.Date;
import java.util.Calendar;

//处理java.sql.Date类型的转换工具
public class DateUtil {

	//得到前七天的日期
	public static Date getPreSevenDate(Date currentDate){
		Calendar cal=Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.DAY_OF_MONTH, -6);
		java.util.Date date =cal.getTime();
		java.sql.Date pre =new java.sql.Date(date.getTime());
		return pre;
	}
	
	//得到前一个月的日期
	public static Date getPreMonthDate(Date currentDate){
		Calendar cal=Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.DAY_OF_MONTH, -29);
		java.util.Date date =cal.getTime();
		java.sql.Date pre =new java.sql.Date(date.getTime());
		return pre;
	}
}

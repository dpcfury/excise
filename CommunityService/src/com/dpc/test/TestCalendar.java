package com.dpc.test;

import java.util.Calendar;
import java.util.Date;

public class TestCalendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 7, 1);
		System.out.println(cal.toString());
		cal.add(Calendar.DAY_OF_MONTH, -6);
		System.out.println(cal.getTime());
		Date date =cal.getTime();
		java.sql.Date d =new java.sql.Date(date.getTime());
		System.out.println(d.toString());
	}
		
}

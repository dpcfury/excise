package com.dpc.test;

import java.sql.Date;
import java.util.List;

import com.dpc.dao.BloodPresureDao;
import com.dpc.dao.impl.BloodPresureDaoImpl;
import com.dpc.pojo.BloodPressure;
import com.dpc.service.BloodPresureService;
import com.dpc.service.impl.BloodPresureServiceImpl;
import com.dpc.util.DateUtil;

public class TestBPService {

	public static void main(String[] args) {
		BloodPresureDao bloodPresureDao = new BloodPresureDaoImpl();
		Date date = new Date(114, 10, 26);
		Date pre = DateUtil.getPreSevenDate(date);
		List<BloodPressure> records = bloodPresureDao.getRecentWeeklyRecord(
				pre, date, 1);

		System.out.println(records);

	}
}

package com.dpc.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dpc.pojo.BloodPressure;
import com.dpc.pojo.BloodPressureRecord;

//转换工具
public class ParseBloodPresureToRecord {

	// 转换一下Date
	public static BloodPressureRecord parse(BloodPressure bloodPresure) {
		BloodPressureRecord record = new BloodPressureRecord();
		record.setHigh(bloodPresure.getHigh());
		record.setLow(bloodPresure.getLow());
		record.setId(bloodPresure.getId());
		record.setUserId(bloodPresure.getUserId());
		record.setDateStr(bloodPresure.getDate().toString());
		return record;
	}

	// 批量转换
	public static List<BloodPressureRecord> parse(List<BloodPressure> bloodPresure) {
		List<BloodPressureRecord> record = new ArrayList<BloodPressureRecord>();
		if (bloodPresure != null) {
			Iterator<BloodPressure> it = bloodPresure.iterator();
			while (it.hasNext()) {
				BloodPressure bp = it.next();
				BloodPressureRecord bloodRecord = parse(bp);
				record.add(bloodRecord);
			}
			return record;
		} else
			return null;
	}
}

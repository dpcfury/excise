package com.dpc.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.dpc.pojo.BloodPressure;
import com.dpc.pojo.BloodPressureRecord;
import com.dpc.pojo.BloodSugar;
import com.dpc.pojo.BloodSugarRecord;

public class ParseBloodSugarToRecord {

	//单独转换一个BloodSugar对象到Record等价类的对象
	public static BloodSugarRecord parse(BloodSugar bloodSugar){
		BloodSugarRecord record =new BloodSugarRecord();
		record.setId(bloodSugar.getId());
		record.setUserId(bloodSugar.getUserId());
		record.setFlag(bloodSugar.getFlag());
		
		//从毫秒到时间
		Date date=new Date(bloodSugar.getDate());
		record.setDate(date);
		String temp =bloodSugar.getLeftsugar()+"."+bloodSugar.getRightsugar();
		float value=Float.parseFloat(temp);
		record.setValue(value);
		
		return record;
	}
	
	//转换一个集合的BloodSugar对象到Record对象集
	public static List<BloodSugarRecord> parse(List<BloodSugar> bloodSugar){
		List<BloodSugarRecord> record = new ArrayList<BloodSugarRecord>();
		if (bloodSugar.size()>0) {
			Iterator<BloodSugar> it = bloodSugar.iterator();
			while (it.hasNext()) {
				BloodSugar bs = it.next();
				BloodSugarRecord sugarRecord = parse(bs);
				record.add(sugarRecord);
			}
			return record;
		} else
			return null;
		
	}
	
}

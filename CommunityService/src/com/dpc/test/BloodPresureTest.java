package com.dpc.test;

import java.util.ArrayList;
import java.util.List;

import com.dpc.dao.BloodPresureDao;
import com.dpc.dao.impl.BloodPresureDaoImpl;
import com.dpc.pojo.BloodSugar;
import com.dpc.util.ParseBloodSugarToRecord;

public class BloodPresureTest {
	public static void main(String[] args) {
		BloodPresureDao bdDao = new BloodPresureDaoImpl();
		// BloodPresure record =new BloodPresure();
		// record.setHigh(150);
		// record.setLow(96);
		// record.setDate(new Date(System.currentTimeMillis()));
		// record.setUserId(1);
		// if(bdDao.addBloodPresureRecord(record)){
		// System.out.println("添加记录成功");
		// }

		// 测试查询功能
		// List<BloodPresure> list =bdDao.findRecordByUserId(1);
		// Iterator<BloodPresure> it=list.iterator();
		// while(it.hasNext()){
		// System.out.println(it.next());
		// }

		// 测试根据日期查询功
		// BloodPresure bloodPresure =bdDao.findRecordByDate(new
		// Date(System.currentTimeMillis()) ,1);
		// System.out.println(new Date(114,7,6));
		// if(bloodPresure!=null){
		// System.out.println(bloodPresure);
		// }else{
		// System.out.println("结果为空");
		// }

		// 测试修改功能

		// BloodPresure newRecord =new BloodPresure();
		// newRecord.setHigh(140);
		// newRecord.setLow(80);
		// newRecord.setDate(new Date(System.currentTimeMillis()));
		// newRecord.setUserId(1);
		// if(bdDao.updateBooldPresureRecord(newRecord)){
		// System.out.println("修改记录成功");
		// }else{
		// System.out.println("修改记录失败");
		// }
		//
		//

		// //测试删除功能
		// if(bdDao.deleteBloodPresureRecord(new
		// Date(System.currentTimeMillis()), 1)){
		// System.out.println("删除成功");
		//
		// }else{
		// System.out.println("删除失败");
		// }

		// System.out.println(new Date(System.currentTimeMillis()).toString());

		// 测试获得一段时间的记录
//		Date fromWhen = Date.valueOf("2014-8-27");
//		Date toWhen = Date.valueOf("2014-8-28");
//		List<BloodPressure> list =bdDao.getRecentWeeklyRecord(fromWhen, toWhen,1);
//		System.out.println(list);
		
		//
//		if(bdDao.checkBPException(1)){
//			System.out.println("normal ");
//		}else{
//			System.out.println("innormal ");
//		}
		
//		List<BloodPressure> list =bdDao.getUnNormalBPRecord(1);
//		Iterator<BloodPressure> it=list.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
		
		BloodSugar bloodSugar01 =new BloodSugar(7,2,2,5,1428828722075l,1);
		BloodSugar bloodSugar02 =new BloodSugar(7,2,2,8,1428828722075l,1);
		BloodSugar bloodSugar03 =new BloodSugar(7,2,2,9,1428828722075l,1);
		BloodSugar bloodSugar04 =new BloodSugar(7,2,2,6,1428828722075l,1);
		
		List<BloodSugar> list=new ArrayList<BloodSugar>();
		list.add(bloodSugar01);
		list.add(bloodSugar02);
		list.add(bloodSugar03);
		list.add(bloodSugar04);
		
		
		System.out.println(ParseBloodSugarToRecord.parse(list));
		
		
	}
}

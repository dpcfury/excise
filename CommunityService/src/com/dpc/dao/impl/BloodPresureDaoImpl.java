package com.dpc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.dpc.dao.BloodPresureDao;
import com.dpc.pojo.BloodPressure;
import com.dpc.util.BloodPressureUtil;
import com.dpc.util.DBConnection;

public class BloodPresureDaoImpl implements BloodPresureDao {

	private Connection con;

	public BloodPresureDaoImpl() {
		super();
		con = DBConnection.getConnection();
	}

	// 添加记录的方法
	@Override
	public boolean addBloodPresureRecord(BloodPressure record) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into bprecord (high,low,date,user_id) values(?,?,?,?) ");
			if (record != null) {
				System.out.println(record);
			} else {
				System.out.println("android 传过来的record为空");
			}
			pstmt.setInt(1, record.getHigh());
			pstmt.setInt(2, record.getLow());
			pstmt.setDate(3, record.getDate());
			pstmt.setInt(4, record.getUserId());
			int result = pstmt.executeUpdate();// 代表插入更新操作的放回结果
			if (result > 0) {

				return true;
			} else {
				return false;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 根据用户id查找记录
	@Override
	public List<BloodPressure> findRecordByUserId(int userId) {
		List<BloodPressure> list = new ArrayList<BloodPressure>();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from bprecord where user_id = ? order by id desc limit 7");
			pstmt.setInt(1, userId);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				BloodPressure record = new BloodPressure();
				record.setId(result.getInt(1));
				record.setUserId(result.getInt(2));
				record.setHigh(result.getInt(3));
				record.setLow(result.getInt(4));
				record.setDate(result.getDate(5));
				list.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 根据日期和用户id查找记录
	@Override
	public BloodPressure findRecordByDate(Date date, int userId) {
		BloodPressure record = null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from bprecord where to_days(date)=to_days(?) and user_id=?");
			pstmt.setDate(1, date);
			pstmt.setInt(2, userId);

			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				record = new BloodPressure();
				record.setId(result.getInt(1));
				record.setHigh(result.getInt(2));
				record.setLow(result.getInt(3));
				record.setDate(result.getDate(4));
				record.setUserId(result.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}

	// 修改记录信息
	@Override
	public boolean updateBooldPresureRecord(BloodPressure record) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("update bprecord set high=?,low=? where user_id=? and to_days(date)=to_days(?)");
			pstmt.setInt(1, record.getHigh());
			pstmt.setInt(2, record.getLow());
			pstmt.setInt(3, record.getUserId());
			pstmt.setDate(4, record.getDate());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 根据日期和用户id删除记录
	@Override
	public boolean deleteBloodPresureRecord(Date date, int userId) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("delete from bprecord where to_days(date)=to_days(?) and user_id=?");
			pstmt.setDate(1, date);
			pstmt.setInt(2, userId);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

		}
		return false;
	}

	// 查询最近一段时间内的记录
	@Override
	public List<BloodPressure> getRecentWeeklyRecord(Date fromWhen,
			Date toWhen, int userId) {
		List<BloodPressure> list = new ArrayList<BloodPressure>();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from bprecord where to_days(date) between to_days(?) and to_days(?) and user_id=?");
			pstmt.setDate(1, fromWhen);
			pstmt.setDate(2, toWhen);
			pstmt.setInt(3, userId);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				BloodPressure record = new BloodPressure();
				record.setId(result.getInt(1));
				record.setHigh(result.getInt(2));
				record.setLow(result.getInt(3));
				record.setDate(result.getDate(4));
				record.setUserId(result.getInt(5));
				list.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	// 检测最近连续三次的记录是否都不正常
	@Override
	public boolean checkBPException(int userId) {
		List<BloodPressure> list = new ArrayList<BloodPressure>();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from bloodpresure where user_id =?");
			pstmt.setInt(1, userId);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				BloodPressure bloodPressure = new BloodPressure();
				bloodPressure.setId(result.getInt(1));
				bloodPressure.setHigh(result.getInt(2));
				bloodPressure.setLow(result.getInt(3));
				bloodPressure.setDate(result.getDate(4));
				bloodPressure.setUserId(result.getInt(5));
				list.add(bloodPressure);
			}

			// 存在的记录数进行判断，少于三个不进行判断
			if (list.size() > BloodPressureUtil.INNORMAL_COUNT) {
				// 挑选出最后的三个连续记录进行血压测量值的判断
				list = getLastThree(list);
				printList(list);
				// 逻辑判断
				if (!judgeBPException(list)) {
					// 出现了不正常
					return false;
				} else {
					// 血压值正常情况下
					return true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 挑选出list中最后连续的三条记录进行判断
	public List<BloodPressure> getLastThree(List<BloodPressure> list) {
		// list集合进行按日期额排序
		Collections.sort(list);
		// 查看排序的结果是否正确
		// printList(list);

		// 集合删减成最后三个
		list = list.subList(list.size() - BloodPressureUtil.INNORMAL_COUNT,
				list.size());

		System.out
				.println("tag :BloodPresureDaoImpl list size =" + list.size());
		return list;
	}

	// 打印输出一个血压测量结合
	public void printList(List<BloodPressure> list) {

		// System.out.println(list);
		Iterator<BloodPressure> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// 连续三次测量值的正常情况判断
	public boolean judgeBPException(List<BloodPressure> list) {
		boolean result = false;
		boolean temp[] = new boolean[BloodPressureUtil.INNORMAL_COUNT];
		for (int i = 0; i < list.size(); i++) {
			// 判断舒张压和收缩压是否在正常范围之内
			BloodPressure record = list.get(i);
			// 判断一组值是否正确
			temp[i] = BloodPressureUtil.checkRecord(record.getHigh(),
					record.getLow());
		}
		// 对照组中的值进行是否出现连续BloodPressure.INNORMAL_COUNT次的不正常
		for (int i = 0; i < temp.length; i++) {
			if (temp[i]) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public List<BloodPressure> getUnNormalBPRecord(int userId) {
		List<BloodPressure> list = new ArrayList<BloodPressure>();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from bloodpresure where user_id =?");
			pstmt.setInt(1, userId);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				BloodPressure bloodPressure = new BloodPressure();
				bloodPressure.setId(result.getInt(1));
				bloodPressure.setHigh(result.getInt(2));
				bloodPressure.setLow(result.getInt(3));
				bloodPressure.setDate(result.getDate(4));
				bloodPressure.setUserId(result.getInt(5));
				list.add(bloodPressure);
			}

			// 存在的记录数进行判断，少于三个不进行判断
			if (list.size() > BloodPressureUtil.INNORMAL_COUNT) {
				// 挑选出最后的三个连续记录进行血压测量值的判断
				list = getLastThree(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

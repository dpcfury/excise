package com.dpc.pojo;

import java.sql.Date;

//方便soap消息解析的血压记录类(java.sql.Date在soap消息中直接为空)
public class BloodPressureRecord {

	private int id;// 记录的编号
	private int high;// 收缩压
	private int low;// 舒张压
	private String dateStr;// 上传日期
	private int userId;// 用户的编号

	public BloodPressureRecord() {
		super();
	}

	public BloodPressureRecord(int id, int high, int low, String dateStr,
			int userId) {
		super();
		this.id = id;
		this.high = high;
		this.low = low;
		this.dateStr = dateStr;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	// 重写toString方法
	public String toString() {
		return "编号=" + id + "\n收缩压=" + high + "\n舒张压=" + low + "\n上传日期="
				+ dateStr + "\n用户编号=" + userId;
	}
}

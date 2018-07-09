package com.dpc.pojo;

import java.io.Serializable;
import java.sql.Date;

//血压测量记录类
public class BloodPressure implements Comparable<BloodPressure>,Serializable {

	private int id;// 记录的编号
	private int high;// 收缩压
	private int low;// 舒张压
	private Date date;// 上传日期
	private int userId;// 用户的编号

	public BloodPressure() {
		super();
	}

	public BloodPressure(int id, int high, int low, Date date, int userId) {
		super();
		this.id = id;
		this.high = high;
		this.low = low;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	// 重写toString方法
	public String toString() {
		return "编号=" + id + "\n收缩压=" + high + "\n舒张压=" + low + "\n上传日期=" + date
				+ "\n用户编号=" + userId;
	}

	//按日期进行比较的方法
	@Override
	public int compareTo(BloodPressure o) {
		int result =0;
		Boolean compare =date.before(o.getDate());
		if(compare==true){
			result =-1;
		}else{
			if(date.equals(o.getDate())){
				result =0;
			}else{
				result =1;
			}
		}
		return result;
	}

}

package com.dpc.pojo;

import java.util.Date;


//为了在图表等上方便显示的BloodSugar的等价类
public class BloodSugarRecord {
	
	private int id;// 记录的编号
	private int userId;// 用户的编号
	private float value;//血糖值
	private Date date;// 上传日期
	private int flag;//空腹和餐后血糖标志

	
	
	public BloodSugarRecord() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "BloodSugarRecord [id=" + id + ", userId=" + userId + ", value="
				+ value + ", date=" + date.toLocaleString()+ ", flag=" + flag + "]";
	}
	
	
	
	

	
	
}

package com.dpc.pojo;


import java.io.Serializable;
import java.sql.Date;


   //血糖测量记录类
   public class BloodSugar implements Serializable ,Comparable {

	private int id;// 记录的编号
	private int userId;// 用户的编号
	private int leftsugar;// 左部血糖值
	private int rightsugar;//右部血糖值
	private long date;// 上传日期
	private int flag;//空腹和餐后血糖标志
	
	public BloodSugar() {
		super();
	}

	public BloodSugar(int id, int userId, int leftsugar, int rightsugar,
			long date, int flag) {
		super();
		this.id = id;
		this.userId = userId;
		this.leftsugar = leftsugar;
		this.rightsugar = rightsugar;
		this.date = date;
		this.flag = flag;
	}



	public BloodSugar(int userId, int leftsugar, int rightsugar, long date,
			int flag) {
		super();
		this.userId = userId;
		this.leftsugar = leftsugar;
		this.rightsugar = rightsugar;
		this.date = date;
		this.flag = flag;
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



	public int getLeftsugar() {
		return leftsugar;
	}



	public void setLeftsugar(int leftsugar) {
		this.leftsugar = leftsugar;
	}



	public int getRightsugar() {
		return rightsugar;
	}



	public void setRightsugar(int rightsugar) {
		this.rightsugar = rightsugar;
	}



	public long getDate() {
		return date;
	}



	public void setDate(long date) {
		this.date = date;
	}



	public int getFlag() {
		return flag;
	}



	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public int compareTo(Object o) {
		BloodSugar sugar =(BloodSugar)o;
		return (int) (this.date-sugar.getDate());
	}


	

}

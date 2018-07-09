package com.dpc.pojo;


import java.io.Serializable;

public class YuyueDetail implements Serializable {
	private int id;
	private int userid;
	private String patientname;
	private int doctorid;
	private String doctorname;
	private String date;
	private String time;
	private String keshi;
	
	public YuyueDetail(){
		
	}

	public YuyueDetail(int id, int userid, String patientname, int doctorid,
			String doctorname, String date, String time, String keshi) {
		super();
		this.id = id;
		this.userid = userid;
		this.patientname = patientname;
		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.date = date;
		this.time = time;
		this.keshi = keshi;
	}

	public YuyueDetail(int userid, String patientname, int doctorid,
			String doctorname, String date, String time, String keshi) {
		super();
		this.userid = userid;
		this.patientname = patientname;
		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.date = date;
		this.time = time;
		this.keshi = keshi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getKeshi() {
		return keshi;
	}

	public void setKeshi(String keshi) {
		this.keshi = keshi;
	}

	@Override
	public String toString() {
		return "YuyueDetail [id=" + id + ", userid=" + userid
				+ ", patientname=" + patientname + ", doctorid=" + doctorid
				+ ", doctorname=" + doctorname + ", date=" + date + ", time="
				+ time + ", keshi=" + keshi + "]";
	}

	
	}
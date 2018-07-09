package com.dpc.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dpc.pojo.Doctor;
import com.dpc.service.DoctorUserService;
import com.opensymphony.xwork2.ActionSupport;

public class DoctorAction extends ActionSupport implements SessionAware{
	
	private DoctorUserService doctorUserService;
	private Doctor doctor;
	private Map<String,Object>session;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	//医生修改个人信息的方法
	public String updateInfo(){
		
//		doctor.setDoctorid(((Doctor)session.get("doctorInUse")).getDoctorid());
////		System.out.println(doctor);
//		Doctor doctorTemp;
//		if((doctorTemp=doctorUserService.updateInfo(doctor))!=null){
//			session.remove("doctorInUse");
//			session.put("doctorInUse", doctorTemp);
//			return "update_success";
//			
//		}else
			return NONE;
	}
	
	
	//查询信息的方法
	public String queryInfo(){
		if(session.get("doctorInUse")!=null){
			return "queryInfo_success";
		}else
			return NONE;
		
		
	}
	
	//提供可供修改的信息方法
	public String showInfoForUpdate(){
		
		return "showInfoForUpdate_success";
	}
	
	public DoctorUserService getDoctorUserService() {
		return doctorUserService;
	}

	public void setDoctorUserService(DoctorUserService doctorUserService) {
		this.doctorUserService = doctorUserService;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	
	
}

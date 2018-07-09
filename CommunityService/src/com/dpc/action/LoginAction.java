package com.dpc.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dpc.pojo.Doctor;
import com.dpc.service.DoctorUserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String userName;
	private String password;
	private DoctorUserService doctorUserService;
	private Map<String,Object>session;
	
	@Override
	public String execute() throws Exception {
		
		Doctor doctor =null;
		System.out.println(userName+"\n"+password);
		doctor =doctorUserService.checkDoctor(userName, password);
		if(doctor!=null){
			session.put("doctorInUse",doctor);
			return "doctor_login_success";
		}
		else{
			System.out.println("LoginAction===="+"login failure ");
			return "doctor_login_failure";
		}
		
	}

	public String logout(){
		session.remove("doctorInUse");//移除回话对象中的user
		return "login";
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DoctorUserService getDoctorUserService() {
		return doctorUserService;
	}

	public void setDoctorUserService(DoctorUserService doctorUserService) {
		this.doctorUserService = doctorUserService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
	
}

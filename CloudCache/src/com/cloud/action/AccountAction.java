package com.cloud.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cloud.pojo.CloudAdmin;
import com.cloud.pojo.CloudUser;
import com.cloud.service.CloudAdminService;
import com.cloud.service.CloudUserService;
import com.opensymphony.xwork2.ActionSupport;

//用户在网页登陆处理的Action
public class AccountAction extends ActionSupport implements SessionAware {
	private String userName;
	private String password;
	private String adminName;
	private String adminPassword;
	private CloudUser cloudUser;
	private CloudUserService cloudUserService;
	private CloudAdminService cloudAdminService;
	private Map<String, Object> session;// session对象

	// clouduser登陆的方法
	public String cloudUserLogin() {
		CloudUser user = cloudUserService.isexists(userName, password);
		if (user != null) {
			// 将用户信息对象存入回话session对象
			session.put("cloudUser", user);
			return "cloudUser_login_success";
		} else {
			return "login";
		}

	}
	
	//cloudUser注册的方法
	public String cloudUserRegister(){
		cloudUser.setMemsize(0);
		if(cloudUserService.addUser(cloudUser)){
			return "cloudUser_register_success";
		}else
			return "cloudUser_register_success";
	}
	
	//clouduser注销的方法
	public String cloudUserLogOut(){
		//移除session会话对象中的clouduser对象
		session.remove("cloudUser");
		return "login";
	}

	// cloudAdmin登录的方法
	public String cloudAdminLogin() {
		CloudAdmin admin = cloudAdminService.isExists(adminName,
				adminPassword);
		if(admin!=null){
			//将管理员用户信息存入session
			session.put("cloudAdmin",admin);
			return "cloudAdmin_login_success";
		}else{
			return "login";
		}

	}
	
	//cloudAdmin的注销方法
	public String cloudAdminLogOut(){
		//移除session会话对象中的cloudADmin对象
		session.remove("cloudAdmin");
		return LOGIN;
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

	public CloudUserService getCloudUserService() {
		return cloudUserService;
	}

	public void setCloudUserService(CloudUserService cloudUserService) {
		this.cloudUserService = cloudUserService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public CloudAdminService getCloudAdminService() {
		return cloudAdminService;
	}

	public void setCloudAdminService(CloudAdminService cloudAdminService) {
		this.cloudAdminService = cloudAdminService;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public CloudUser getCloudUser() {
		return cloudUser;
	}

	public void setCloudUser(CloudUser cloudUser) {
		this.cloudUser = cloudUser;
	}


	

}

package com.dpc.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dpc.pojo.BloodPressure;
import com.dpc.pojo.BloodSugar;
import com.dpc.pojo.BloodSugarRecord;
import com.dpc.pojo.User;
import com.dpc.pojo.UserPush;
import com.dpc.service.BloodPresureService;
import com.dpc.service.BloodSugarService;
import com.dpc.service.PushService;
import com.dpc.service.UserService;
import com.dpc.util.AndroidPushMessageSample;
import com.dpc.util.ParseBloodSugarToRecord;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChartAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private BloodPresureService bloodPresureService;
	private BloodSugarService bloodSugarService;
	private String userID;// 居民用户的id号
	private UserService userService;
	private String message;
	private String id;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public BloodPresureService getBloodPresureService() {
		return bloodPresureService;
	}

	public void setBloodPresureService(BloodPresureService bloodPressureService) {
		this.bloodPresureService = bloodPressureService;
	}

	public String execute() throws Exception {
		return super.execute();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String showBPRecord() throws Exception {
		// System.out.println("action能执行到里面\n");
		List<BloodPressure> records;

		User userTemp = userService.getUserById(Integer.parseInt(userID));
		if (userTemp != null) {
			session.put("userForChart", userTemp);
		}

		records = bloodPresureService.findRecordByUserId(Integer
				.parseInt(userID));
		session.put("records", records);
		return "show_pressure_record";
	}

	// 查看某个用户血糖测量记录的图表
	public String showBSRecord() {
		List<BloodSugar> list = bloodSugarService.getBloodSugarRecord(Integer
				.parseInt(userID));
		List<BloodSugarRecord> records = ParseBloodSugarToRecord.parse(list);

		session.put("records", records);
		User u = userService.getUserById(Integer.parseInt(userID));
		session.put("user", u);
		
		return "show_sugar_record";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

		session = arg0;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BloodSugarService getBloodSugarService() {
		return bloodSugarService;
	}

	public void setBloodSugarService(BloodSugarService bloodSugarService) {
		this.bloodSugarService = bloodSugarService;
	}

}

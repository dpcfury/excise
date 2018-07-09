package com.dpc.ws.impl;

import java.sql.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import redis.clients.jedis.Jedis;

import com.dpc.pojo.BloodPressure;
import com.dpc.pojo.BloodPressureRecord;
import com.dpc.pojo.BloodSugar;
import com.dpc.pojo.Doctor;
import com.dpc.pojo.Resident;
import com.dpc.pojo.User;
import com.dpc.pojo.YuyueDetail;
import com.dpc.service.BloodPresureService;
import com.dpc.service.BloodSugarService;
import com.dpc.service.DoctorInfoService;
import com.dpc.service.PushService;
import com.dpc.service.UserService;
import com.dpc.service.YuyueInfoService;
import com.dpc.util.ParseBloodPresureToRecord;
import com.dpc.util.ParseDoctorInfoToDoctor;
import com.dpc.ws.WebServiceForApp;

//必须用@WebService修饰，并且有参数
@WebService(endpointInterface = "com.dpc.ws.WebServiceForApp", serviceName = "UserService", targetNamespace = "http://hl.dpc.ws.com.org/")
public class WebServiceForAppImpl implements WebServiceForApp {

	private UserService userService;
	private BloodPresureService bloodPresureService;
	private PushService pushService;
	private YuyueInfoService yuyueInfoService;
	private DoctorInfoService doctorInfoService;
	private BloodSugarService bloodSugarService;

	public WebServiceForAppImpl() {

	}

	public YuyueInfoService getYuyueInfoService() {
		return yuyueInfoService;
	}

	public void setYuyueInfoService(YuyueInfoService yuyueInfoService) {
		this.yuyueInfoService = yuyueInfoService;
	}

	public DoctorInfoService getDoctorInfoService() {
		return doctorInfoService;
	}

	public void setDoctorInfoService(DoctorInfoService doctorInfoService) {
		this.doctorInfoService = doctorInfoService;
	}

	public UserService getUserService() {
		return userService;
	}

	public BloodPresureService getBloodPresureService() {
		return bloodPresureService;
	}

	public void setBloodPresureService(BloodPresureService bloodPresureService) {
		this.bloodPresureService = bloodPresureService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PushService getPushService() {
		return pushService;
	}

	public void setPushService(PushService pushService) {
		this.pushService = pushService;
	}

	public BloodSugarService getBloodSugarService() {
		return bloodSugarService;
	}

	public void setBloodSugarService(BloodSugarService bloodSugarService) {
		this.bloodSugarService = bloodSugarService;
	}

	@Override
	@WebMethod(action = "http://dpc.ws.com.org/login")
	public User login(@WebParam(name = "username") String username,
			@WebParam(name = "password") String password) {
		return userService.checkUserByUserNamePwd(username, password);
	}

	// // 添加血压记录的方法
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/addBloodPresureRecord")
	public boolean addBloodPresureRecord(@WebParam(name = "high") int high,
			@WebParam(name = "low") int low,
			@WebParam(name = "userId") int userId) {

		BloodPressure record = new BloodPressure();
		record.setHigh(high);
		// System.out.println("WS接收到的high=="+high);
		record.setLow(low);
		record.setUserId(userId);
		record.setDate(new Date(System.currentTimeMillis()));

		return bloodPresureService.addBloodPresureRecord(record);
	}

	// 添加血糖记录的方法
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/addBloodSugarRecord")
	public boolean addBloodSugarRecord(@WebParam(name = "userId") int userId,
			@WebParam(name = "leftsugar") int leftsugar,
			@WebParam(name = "rightsugar") int rightsugar,
			@WebParam(name = "flag") int flag) {

		BloodSugar record = new BloodSugar();
		record.setUserId(userId);
		record.setLeftsugar(leftsugar);
		record.setRightsugar(rightsugar);
		record.setDate(System.currentTimeMillis());
		record.setFlag(flag);

		return bloodSugarService.addBloodSugarRecord(record);

	}

	// 查询上传的某一天记录的方法
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/findBloodPresureRecord")
	public BloodPressureRecord findBloodPresureRecord(int year, int month,
			int day, int userId) {
		Date date = new Date(year, month, day);
		System.out.println(date);
		BloodPressure bloodPresure = bloodPresureService
				.findRecordByDateUserId(date, userId);
		return ParseBloodPresureToRecord.parse(bloodPresure);
	}

	// 获取血糖记录
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/getSugarRecord")
	public List<BloodSugar> getSugarRecord(@WebParam(name = "userId") int userId) {
		// 获得当前的日期
		// long time = System.currentTimeMillis();
		return bloodSugarService.getBloodSugarRecord(userId);
	}

	// 获得最近一周内的血压测量记录的方法
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/getRecentWeekRecord")
	public List<BloodPressureRecord> getRecentWeekRecord(
			@WebParam(name = "userId") int userId) {
		List<BloodPressure> bloodPresure = bloodPresureService
				.getRecentWeekRecord(userId);
		return ParseBloodPresureToRecord.parse(bloodPresure);
	}

	// 获得最近一个月血压测量记录的方法
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/")
	public List<BloodPressureRecord> getRecentMonthRecord(
			@WebParam(name = "userId") int userId) {

		Date currentDate = new Date(System.currentTimeMillis());
		List<BloodPressure> bloodPresure = bloodPresureService
				.getRecentMonthRecord(currentDate, userId);

		return ParseBloodPresureToRecord.parse(bloodPresure);
	}

	// 检测是否出现连续的血压指标吧不正常的情况
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/checkBPException")
	public boolean checkBPException(@WebParam(name = "userId") int userId) {

		return bloodPresureService.checkBPException(userId);
	}

	// 查看连续几次不正常的信息的方法
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/getUnNormalBPRecord")
	public List<BloodPressureRecord> getUnNormalBPRecord(
			@WebParam(name = "userId") int userId) {
		System.out.println("web service 调用到了这个方法");
		List<BloodPressure> list = bloodPresureService
				.getUnNormalBPException(userId);

		return ParseBloodPresureToRecord.parse(list);
	}

	// 用户返回百度云pushService绑定的结果（userId,channelId）
	@Override
	public boolean sendMyUserIdAndChannelId(int id, String baiduUserId,
			String channelId) {
		boolean result = false;
		if (pushService.isExists(id)) {
			// 已经存在则更新
			result = pushService.updateUserPushList(id, baiduUserId, channelId);
		} else
			result = pushService.addUserPushList(id, baiduUserId, channelId);

		return result;
	}

	// 获得医生信息
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/getDoctorInfo")
	public List<Doctor> getDoctorInfo(@WebParam(name = "keshi") String keshi) {
		List<Doctor> doctorinfo = doctorInfoService.getAllDoctorInfo(keshi);

		return ParseDoctorInfoToDoctor.parse(doctorinfo);
	}

	// 上传（添加）预约信息
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/addYuyueDatail")
	public boolean addYuyueDetail(@WebParam(name = "userid") int userid,
			@WebParam(name = "patientname") String patientname,
			@WebParam(name = "doctorid") int doctorid,
			@WebParam(name = "doctorname") String doctorname,
			@WebParam(name = "date") String date,
			@WebParam(name = "time") String time,
			@WebParam(name = "keshi") String keshi) {
		YuyueDetail detail = new YuyueDetail();
		detail.setUserid(userid);
		detail.setPatientname(patientname);
		detail.setDoctorid(doctorid);
		detail.setDoctorname(doctorname);
		detail.setDate(date);
		detail.setTime(time);
		detail.setKeshi(keshi);

		return yuyueInfoService.addYuyueInfo(detail);
	}

	// 删除预约信息
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/delYuyueDetail")
	public boolean delYuyueDetail(
			@WebParam(name = "doctorname") String doctorname) {
		return yuyueInfoService.delYuyueInfo(doctorname);
	}

	// 得到预约信息
	@Override
	@WebMethod(action = "http://dpc.ws.com.org/getYuyueDetail")
	public List<YuyueDetail> getYuyueDetail(
			@WebParam(name = "userId") int userId) {
		return yuyueInfoService.getYuyueInfo(userId);
	}

}

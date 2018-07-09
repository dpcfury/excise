package com.dpc.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.dpc.pojo.BloodPressureRecord;
import com.dpc.pojo.BloodSugar;
import com.dpc.pojo.Doctor;
import com.dpc.pojo.Resident;
import com.dpc.pojo.User;
import com.dpc.pojo.YuyueDetail;

@WebService(targetNamespace = "http://dpc.ws.com.org/")
public interface WebServiceForApp {
	// 用户登录的web service方法
	@WebMethod(action = "http://dpc.ws.com.org/login")
	public User login(@WebParam(name = "username") String username,
			@WebParam(name = "password") String password);

	// 添加血压记录的方法
	@WebMethod(action = "http://dpc.ws.com.org/addBloodPresureRecord")
	public boolean addBloodPresureRecord(@WebParam(name = "high") int high,
			@WebParam(name = "low") int low,
			@WebParam(name = "userId") int userId);
	
	// 添加血糖记录的方法
			@WebMethod(action = "http://dpc.ws.com.org/addBloodSugarRecord")
			public boolean addBloodSugarRecord(
					@WebParam(name = "userId") int userId,
					@WebParam(name = "leftsugar") int leftsugar,
					@WebParam(name = "rightsugar") int rightsugar,
					@WebParam(name = "flag") int flag);

	// 查询上传的某一天记录的方法
	@WebMethod(action = "http://dpc.ws.com.org/findBloodPresureRecord")
	public BloodPressureRecord findBloodPresureRecord(
			@WebParam(name = "year") int year,
			@WebParam(name = "month") int month,
			@WebParam(name = "day") int day,
			@WebParam(name = "userId") int userId);
	
	//获得血糖的记录集合
		@WebMethod(action = "http://dpc.ws.com.org/getSugarRecord")
		public List<BloodSugar> getSugarRecord(
				@WebParam(name = "userId") int userId);

	// 获得最近一周内的血压测量记录的方法
	@WebMethod(action = "http://dpc.ws.com.org/getRecentWeekRecord")
	public List<BloodPressureRecord> getRecentWeekRecord(
			@WebParam(name = "userId") int userId);

	// 获得最近一个月血压测量记录的方法
	@WebMethod(action = "http://dpc.ws.com.org/getRecentMonthRecord")
	public List<BloodPressureRecord> getRecentMonthRecord(
			@WebParam(name = "userId") int userId);

	// 检测用户在连续的三次上传记录中是否都是出现了异常
	@WebMethod(action = "http://dpc.ws.com.org/checkBPException")
	public boolean checkBPException(@WebParam(name = "userId") int userId);

	// 获得连续的几次不正常血压测量指标的对象集合
	@WebMethod(action = "http://dpc.ws.com.org/getUnNormalBPRecord")
	public List<BloodPressureRecord> getUnNormalBPRecord(
			@WebParam(name = "userId") int userId);



	// 用户返回百度云pushService绑定的结果（userId,channelId）
	@WebMethod(action = "http://dpc.ws.com.org/sendMyUserIdAndChannelId")
	public boolean sendMyUserIdAndChannelId(@WebParam(name = "id") int id,
			@WebParam(name = "baiduUserId") String baiduUserId,
			@WebParam(name = "channelId") String channelId);
	
	// 获得医生信息
			@WebMethod(action = "http://dpc.ws.com.org/getDoctorInfo")
			public List<Doctor> getDoctorInfo(
					@WebParam(name = "keshi") String keshi);
			
		//上传（添加）预约信息
			@WebMethod(action = "http://dpc.ws.com.org/addYuyueDetail")
			public boolean addYuyueDetail(
					@WebParam(name = "userid") int userid,
					@WebParam(name = "patientname") String patientname,
					@WebParam(name = "doctorid") int doctorid,
					@WebParam(name = "doctorname") String doctorname,
					@WebParam(name = "date") String date,
					@WebParam(name = "time") String time,
					@WebParam(name = "keshi") String keshi
					
			);

		//删除预约信息
			@WebMethod(action = "http://dpc.ws.com.org/delYuyueDetail")
			public boolean delYuyueDetail(
					@WebParam(name = "doctorname") String  doctorname);
			
			// 获得预约信息
			@WebMethod(action = "http://dpc.ws.com.org/getYuyueDetail")
			public List<YuyueDetail> getYuyueDetail(
						@WebParam(name = "userId") int userId);

}

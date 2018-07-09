package com.dpc.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dpc.pojo.User;
import com.dpc.pojo.YuyueDetail;
import com.dpc.service.YuyueInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class AppointmentAction extends ActionSupport implements SessionAware {

	/**
	 * author by dpc 苏州科技学院 2014-4.13
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private YuyueInfoService yuyueInfoService;
	
	private int id;//代表预约信息的编号

	/* 分页部分 */
	private final int pageSize = 10;// 默认每页显示的信息条数
	private int pageCount;// 一共信息有多少页
	private int total;// 一共有多少条消息
	private int nowPage;// 当前页码
	private int menu_index;// 对应的左侧导航选中的

	private List<Integer> index;

	// 返回所有用户预约信息(第一页)
	public String listAllYuyueInfo() {
		total = yuyueInfoService.getYuyueInfoCount();// 获取所有的记录条数
		nowPage = 1;// 默认显示当第一页
		pageCount = countPages();

		List<YuyueDetail> list = yuyueInfoService.getUserYuyueInfo(pageSize, nowPage, pageCount);
		// 存入session中
		session.put("yuyueInfo", list);
		initIndex();
		session.put("index", index);// 页码组
		session.put("nowPage", nowPage);// 存入当前显示的页面数
		session.put("pageCount", pageCount);// 存入一共的页数
		session.put("menu_index", menu_index);// 上次点击的menu中哪一个
		return "yuyueInfoList";
	}
	
	//获得部分预约信息
	public String listYuyueInfo(){
		
		total = yuyueInfoService.getYuyueInfoCount();// 获取所有的记录条数
		pageCount = countPages();

		List<YuyueDetail> list = yuyueInfoService.getUserYuyueInfo(pageSize, nowPage, pageCount);
		// 存入session中
		session.put("yuyueInfo", list);
		initIndex();
		session.put("index", index);// 页码组
		session.put("nowPage", nowPage);// 存入当前显示的页面数
		session.put("pageCount", pageCount);// 存入一共的页数
		session.put("menu_index", menu_index);// 上次点击的menu中哪一个
		return "yuyueInfoList";
		
	}

	
	//删除预约信息
	public String delYuyueInfo(){
		if(yuyueInfoService.delYuyueInfo(id)){
			session.put("delete_result", "预约信息已成功删除");
			return "delete_success";
		}
		else
			return "delete_error";
	}
	
	
	// 根据总信息条数和pagesize计算一共的页数
	private int countPages() {
		return this.total % this.pageSize == 0 ? this.total / this.pageSize
				: this.total / this.pageSize + 1;
	}

	public void initIndex() {
		index = new ArrayList<Integer>();
		for (int i = 0; i < pageCount; i++)
			index.add(i, i + 1);
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

		this.session=arg0;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getMenu_index() {
		return menu_index;
	}

	public void setMenu_index(int menu_index) {
		this.menu_index = menu_index;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public int getPageSize() {
		return pageSize;
	}

	public YuyueInfoService getYuyueInfoService() {
		return yuyueInfoService;
	}

	public void setYuyueInfoService(YuyueInfoService yuyueInfoService) {
		this.yuyueInfoService = yuyueInfoService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}

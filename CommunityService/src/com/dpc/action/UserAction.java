package com.dpc.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dpc.pojo.User;
import com.dpc.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

//负责居民信息处理的action
public class UserAction extends ActionSupport implements SessionAware {

	/**
	 * author dpc 苏州科技学院 2014.4.12
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;// 负责用户信息服务的service
	private Map<String, Object> session;

	/* 分页部分 */
	private final int pageSize = 10;// 默认每页显示的信息条数
	private int pageCount;// 一共信息有多少页
	private int total;// 一共有多少条消息
	private int nowPage;// 当前页码
	private int menu_index;// 对应的左侧导航选中的

	private List<Integer> index;

	public UserAction() {
		super();
	}

	// 获得所有用户信息并存入session供页面调用
	public String listAllUserInfo() {
		total = userService.getUserInfoCount();// 获取所有的记录条数
		nowPage = 1;// 默认显示当第一页
		pageCount = countPages();

		List<User> list = userService.getUserInfo(pageSize, nowPage, pageCount);
		// 存入session中
		session.put("users", list);
		initIndex();
		session.put("index", index);// 页码组
		session.put("nowPage", nowPage);// 存入当前显示的页面数
		session.put("pageCount", pageCount);// 存入一共的页数
		session.put("menu_index", menu_index);// 上次点击的menu中哪一个
		return "userList";
	}

	// 分页获得居民信息
	public String listUserInfo() {
		total = userService.getUserInfoCount();
		pageCount = countPages();
		List<User> list = userService.getUserInfo(pageSize, nowPage, pageCount);

		session.put("users", list);
		initIndex();
		session.put("index", index);
		session.put("nowPage", nowPage);
		session.put("pageCount", pageCount);

		return "userList";
	}

	// 根据总信息条数和pagesize计算一共的页数
	private int countPages() {
		return this.total % this.pageSize == 0 ? this.total / this.pageSize
				: this.total / this.pageSize + 1;
	}

	// 筛选出所有患有高血压的用户存入session
	public String listAllUsersWithHBP() {
		total = userService.getHBPUserCount();// 获得高血压患者的总人数
		pageCount = countPages();// 获得应该的页数
		nowPage = 1;// 第一次默认第一页
		List<User> list = userService.getHBPUserInfo(pageSize, nowPage,
				pageCount);

		initIndex();
		session.put("index", index);// 页码组
		session.put("nowPage", nowPage);// 存入当前显示的页面数
		session.put("pageCount", pageCount);// 存入一共的页数
		session.put("menu_index", menu_index);// 上次点击的menu中哪一个
		session.put("HBPUsers", list);

		return "HBPUserList";

	}

	// 获得部分高血压患者信息
	public String listHBPUserInfo() {
		total = userService.getHBPUserCount();
		pageCount = countPages();
		List<User> list = userService.getHBPUserInfo(pageSize, nowPage,
				pageCount);

		initIndex();
		session.put("index", index);
		session.put("nowPage", nowPage);
		session.put("pageCount", pageCount);
		session.put("HBPUsers", list);

		return "HBPUserList";
	}

	// 筛选出所有患有糖尿病的用户存入session(默认第一页)
	public String listAllUsersWithHBS() {
		total = userService.getHBSUserCount();// 获得糖尿病患者的总人数
		pageCount = countPages();// 获得应该的页数
		nowPage = 1;// 第一次默认第一页
		List<User> list = userService.getHBSUserInfo(pageSize, nowPage,
				pageCount);

		initIndex();
		session.put("index", index);// 页码组
		session.put("nowPage", nowPage);// 存入当前显示的页面数
		session.put("pageCount", pageCount);// 存入一共的页数
		session.put("menu_index", menu_index);// 上次点击的menu中哪一个
		session.put("HBSUsers", list);

		return "HBSUserList";
	}

	// 筛选出所有患有糖尿病的用户存入session
		public String listUsersWithHBS() {
			total = userService.getHBSUserCount();// 获得糖尿病患者的总人数
			pageCount = countPages();// 获得应该的页数
			
			List<User> list = userService.getHBSUserInfo(pageSize, nowPage,
					pageCount);

			initIndex();
			session.put("index", index);// 页码组
			session.put("nowPage", nowPage);// 存入当前显示的页面数
			session.put("pageCount", pageCount);// 存入一共的页数
			session.put("menu_index", menu_index);// 上次点击的menu中哪一个
			session.put("HBSUsers", list);

			return "HBSUserList";
		}
	
	public void initIndex() {
		index = new ArrayList<Integer>();
		for (int i = 0; i < pageCount; i++)
			index.add(i, i + 1);
	}

	public String execute() {

		return null;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public int getPageSize() {
		return pageSize;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getMenu_index() {
		return menu_index;
	}

	public void setMenu_index(int menu_index) {
		this.menu_index = menu_index;
	}

}

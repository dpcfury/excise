package com.cloud.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cloud.pojo.CloudUser;
import com.cloud.pojo.ClusterNode;
import com.cloud.service.ClusterService;
import com.opensymphony.xwork2.ActionSupport;

//对于集群操作请求的Action
public class ClusterAction extends ActionSupport implements SessionAware {

	Map<String, Object> session;
	private ClusterService clusterService;

	// 根据已登录用户的信息查看其缓存集群参数列表
	public String getUserClusterList() {
		// 首先从session会话对象中取出当前的用户对象
		CloudUser user = (CloudUser) session.get("cloudUser");
		
		List<ClusterNode> list = clusterService.getUserNodeList(user.getId());
		
		if(list!=null){
			//将list存入session供页面显示s
			session.put("myclusterNdeList",list);
			return "getUserClusterList_success";
		}else
			return NONE;
	}
	
	//云缓存用户查看其缓存集群状态
	public String getMyClusterStatus(){
		
		return "getMyClusterStatus_success";
	}
	
	//云缓存用户注册后开始申请缓存集群
	public String editApplication(){
		
		return "apply_cluster_edit";
	}
	
	//接受用户的云缓存集群的申请
	public String applyForCluster(){
		
		return "apply_cluster_done";
	}
	
	//管理员用户查看所有用户请求的方法
	public String checkApplications(){
		
		return "list_all_applications";
	}
	
	//管理员开始处理用户的请求
	public String beginToDealRequest(){
		
		return "start_deal_request";
	}

	//管理员处理为用户创建集群的请求
	public String createUserCluster(){
		
		return "create_user_cluster_success";
	}
	
	//云缓存用户查看申请的结果
	public String checkRequestResult(){
		
		return "show_request_result";
	}
	
	//云缓存用户提交增加缓存的申请
	public String editAddNodeRequest(){
		
		return "add_node_edit";
	}
	
	//管理员开始处理用户的扩容请求
	public String beginToDealUserAddRequest(){
		
		return "begin_to_add";
	}
	
	//管理员查看云缓存系统集群信息
	public String checkSysCluster(){
		
		return "show_cluster_status";
	}
	
	
	public String execute() {
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ClusterService getClusterService() {
		return clusterService;
	}

	public void setClusterService(ClusterService clusterService) {
		this.clusterService = clusterService;
	}

}

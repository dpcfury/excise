<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!-- 显示用户的缓存节点信息列表 -->
<div class="panel panel-primary">

	<!-- 列表标题 -->
	<div class="panel-heading">
		<h4 class="text-center">所有节点</h4>
	</div>

	<!-- 显示列表的表格 -->
	<table class="table table-striped">

		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>dockerIP</th>
			<th>dockerID</th>
			<th>phicsIP</th>
			<th>redisID</th>
			<th>运行状态</th>
		</tr>

		<!--循环输出列表中的节点信息 -->
		<s:iterator var="clusterNode" value="#session.myclusterNdeList">
			<tr>
				<th><s:property value="#clusterNode.userID" /></th>
				<th><s:property value="#clusterNode.userName" /></th>
				<th><s:property value="#clusterNode.dockerIP" /></th>
				<th><s:property value="#clusterNode.dockerID" /></th>
				<th><s:property value="#clusterNode.phicsIP" /></th>
				<th><s:property value="#clusterNode.redisID" /></th>
				<th><a class="btn btn-danger"><i class="fa  fa-hand-o-right fa-fw pull-right"></i> 查看</a></th>
			</tr>
		</s:iterator>
	</table>
	
	

</div>
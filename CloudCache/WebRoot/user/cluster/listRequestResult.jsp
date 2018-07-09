<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<base href="<%=basePath%>">

<div class="container">

	<div class="well ">
		<table class="table">
			<tr>
				<td>请求时间</td>
				<td>请求类型</td>
				<td>具体</td>
				<td>答复</td>
				<td>jar</td>
			</tr>

			<tr>
				<td>2014.12.29</td>
				<td>申请集群</td>
				<td>申请1GB缓存集群</td>
				<td><a class="btn btn-primary"
					href="ClustergetMyClusterStatus.action">已创建，点击查看集群</a></td>
				<td><a class="btn btn-primary" href="<%=basePath%>/resource/PowerJedis.jar">Jar包下载<i
						class="fa  fa-download fa-fw"></i></a></td>
			</tr>

		</table>
	</div>

</div>
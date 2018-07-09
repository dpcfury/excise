<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>显示全部的居民信息</title>

<link href="<%=basePath%>bootstrap/bootstrap.min.css" rel="stylesheet">
</head>

<body>

	<div class="container">

		<table class="table table-striped table-bordered">
			<thead></thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>住址</th>
				<th>操作</th>
			</tr>
			<s:iterator value="#session.users" var="userTemp">
				<tr>
					<td class="text-center"><s:property value="#userTemp.userid" /></td>
					<td class="text-center"><s:property value="#userTemp.realname" /></td>
					<td class="text-center"><s:property value="#userTemp.sex" /></td>
					<td class="text-center"><s:property value="#userTemp.age" /></td>
					<td class="text-center"><s:property value="#userTemp.address" /></td>
					<td class="text-center"><a
						href="chartshowBPRecord.action?userID=<s:property value="#userTemp.userid"/>"
						class=" btn btn-primary btn-sm">详细信息</a></td>
				</tr>

			</s:iterator>

		</table>
	</div>

	<div class="page_choose" style="text-align:center;">
		<nav>
		<ul class="pagination">
			<li id="index_pre"><a
				href="UserlistUserInfo.action?nowPage=${nowPage-1}"
				aria-label="Previous"> <span aria-hidden="true">&laquo;前一页</span>
			</a></li>
			<s:iterator value="#session.index" var="temp">
				<li id="index_<s:property value="#temp"/>"><a
					href="UserlistUserInfo.action?nowPage=<s:property value="#temp"/>&menu_index=1"><s:property
							value="#temp"></s:property></a></li>
			</s:iterator>
			<li id="index_next"><a
				href="UserlistUserInfo.action?nowPage=${nowPage+1}"
				aria-label="Next"> <span aria-hidden="true">后一页&raquo;</span>
			</a></li>

		</ul>
		</nav>
	</div>


</body>
</html>

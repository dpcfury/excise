<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<base href="<%=basePath%>">

<link href="<%=basePath%>bootstrap/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="container">

		<table class="table table-striped table-bordered">
			<thead></thead>
			<tr>
				<th>编号</th>
				<th>患者姓名</th>
				<th>预约医生姓名</th>
				<th>预约日期</th>
				<th>预约时间</th>
				<th>预约科室</th>
				<th>操作</th>
			</tr>
			<s:iterator value="#session.yuyueInfo" var="infoTemp">
				<tr>
					<td class="text-center"><s:property value="#infoTemp.id" /></td>
					<td class="text-center"><s:property
							value="#infoTemp.patientname" /></td>
					<td class="text-center"><s:property
							value="#infoTemp.doctorname" /></td>
					<td class="text-center"><s:property value="#infoTemp.date" /></td>
					<td class="text-center"><s:property value="#infoTemp.time" /></td>
					<td class="text-center"><s:property value="#infoTemp.keshi" /></td>
					<td class="text-center"><a
						href="AppointmentdelYuyueInfo.action?id=<s:property value="#infoTemp.id" />"
						class=" btn btn-danger btn-sm">删除<i class="fa fa-trash"></i></a></td>
				</tr>
			</s:iterator>

		</table>
	</div>

	<div class="page_choose" style="text-align:center;">
		<nav>
			<ul class="pagination">
				<li id="index_pre"><a
					href="AppointmentlistYuyueInfo.action?nowPage=${nowPage-1}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;前一页</span>
				</a></li>
				<s:iterator value="#session.index" var="temp">
					<li id="index_<s:property value="#temp"/>"><a
						href="AppointmentlistYuyueInfo.action?nowPage=<s:property value="#temp"/>&menu_index=3"><s:property
								value="#temp"></s:property></a></li>
				</s:iterator>
				<li id="index_next"><a
					href="AppointmentlistYuyueInfo.action?nowPage=${nowPage+1}"
					aria-label="Next"> <span aria-hidden="true">后一页&raquo;</span>
				</a></li>

			</ul>
		</nav>
	</div>

</body>

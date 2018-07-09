<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
<title>主操作界面</title>

<link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
	background: url(<%=basePath%>img/dust.png);
}

div#content {
	margin-top: 100px;
}
</style>

</head>

<body>


	<div id="content">
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-heading">
					默认当前操作路径:<strong>${current_key_path}</strong>
				</div>

				<div class="panel-body">
					<div class="span4">
						<table class="table table-striped table-bordered">
							<c:forEach items="${allSubKeys}" var="subKey">
								<tr>
									<td><a href="getSubKeysOrValues.htm?current_key_path=${current_key_path}&subKeyName=${subKey}">\&nbsp${subKey}</a></td>
									<td class="text-center">New key</td>
									<td class="text-center">New value</td>
									<td class="text-center">Delete</td>
									
								</tr>
								
							</c:forEach>
						</table>
					</div>

				</div>

			</div>

		</div>
	</div>

<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>

</body>
</html>

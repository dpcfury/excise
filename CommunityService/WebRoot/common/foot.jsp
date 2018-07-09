<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>页脚，版权等信息</title>
</head>

<body>

	<div class="navbar navbar-primary navbar-fixed-bottom" role="navigation">
		<p class="text-center" style="margin-top:20px">Corpright @ 夺宝联盟 --苏州科技学院</p>
	</div>

</body>
</html>

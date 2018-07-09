<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员操作主页面</title>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>font-awesome/css/font-awesome.min.css">

<style type="text/css">
body {
	background: url(<%=basePath%>img/dust.png);
}

.navbar {
	margin-bottom: 0px;
}

#usermenu {
	margin-top: 30px;
}

#usercontent {
	margin-top: 30px;
}

#first-panel {
	margin-top: 0px;
}

.list-group a {
	font-size: 18px;
}
.panel-success>.panel-heading{

	color: #020B12;
}
</style>

</head>
<body>
	<!-- 顶部固定的导航条 -->
	<jsp:include page="common/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3" id="usermenu">
				<jsp:include page="common/adminleft.jsp"></jsp:include>
			</div>

			<div class="col-md-9" id="usercontent">
				<jsp:include page="common/content.jsp"></jsp:include>
			</div>
		</div>

	</div>

	<script src="<%=basePath%>js/jquery.min.js"></script>
	<script src="<%=basePath%>js/bootstrap.min.js"></script>
</body>
</html>
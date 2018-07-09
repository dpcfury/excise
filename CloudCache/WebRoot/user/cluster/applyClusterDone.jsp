<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请缓存集群</title>

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

.panel-success>.panel-heading {
	color: #020B12;
}


#tip{
	wid
}
</style>

</head>
<body>
	<!-- 顶部固定的导航条 -->
	<jsp:include page="../common/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3" id="usermenu">
				<jsp:include page="../common/userleft.jsp"></jsp:include>
			</div>

			<div class="col-md-9" id="usercontent">
				<jsp:include page="showTip.jsp"></jsp:include>
			</div>
		</div>

	</div>

	<script src="<%=basePath%>js/jquery.min.js"></script>
	<script src="<%=basePath%>js/bootstrap.min.js"></script>
	<script src="<%=basePath%>js/jquery.pin.min.js"></script>
	
	<script>
		$(".pinned").pin();
		$("#collapseOne").addClass("in");
		$("textarea").css("font-size",18);
	</script>

</body>
</html>


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

<style>
body {
	background: url("<%=basePath%>img/bg.jpg");
	padding-bottom:70px;
}

.font_fam{
	font-family: Helvetica, Tahoma, Arial, STXihei, "华文细黑", Heiti, "黑体",
		"Microsoft YaHei", "微软雅黑", SimSun, "宋体", sans-serif;
}

#foot_part{
		height:30px;
	}
	
.featurette-divider {
	margin: 80px 0;
}
</style>
<title>主页面</title>
<link href="<%=basePath%>bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
</head>

<body>

	<div class="container-fluid">
	
		<jsp:include page="common/head.jsp"></jsp:include>
		

		<div class="row">
			<!-- 左边导航栏 -->
			<div class="col-md-3">
				<jsp:include page="common/menu.jsp"></jsp:include>
			</div>

			<!-- 右边的content主体 -->
			<div class="col-md-9">
				<jsp:include page="common/queryinfo.jsp"></jsp:include>
			</div>
			
		</div>

	</div>
	
		<!-- 页脚 -->
	<div class="row">
		<jsp:include page="common/foot.jsp"></jsp:include>
	</div>

	<script src="<%=basePath%>script/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>script/bootstrap.min.js"></script>
	
	
	<script type="text/javascript">
		$("a").addClass("text-center");
	</script>
		<script type="text/javascript">
		$("a").addClass("text-center");
		$(".col-md-3").addClass("text-center");
		$("body").addClass("font_fam");
	</script>
</body>
</html>

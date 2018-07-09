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
<title>添加结果的界面</title>

<link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=basePath%>/css/buttons.css" rel="stylesheet">
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
					<div class="row">
						<div class="col-md-1">
								<button onclick="history.back()" class="button button-large button-plain button-border button-circle">
									<i class="fa fa-reply"></i>
								</button>
								
						</div>

						<div class="col-md-11">
							默认当前操作路径:<strong>${current_key_path}</strong>
						</div>
						
						
					</div>
				</div>

				<div class="panel-body">
					<div class="text-center">
						<div class="row">
							<div class="col-md-4">
								<strong>添加成功，您添加的是<em>${addedValueType}</em>类型的value</strong>
							</div>
							<div class="col-md-4 center">
								<strong>valueName:</strong><em>${addedValueName}</em><br>
								<strong>value:</strong><em>${addedValue}</em>
							</div>
							<div class="col-md-4 text-center">
								<strong>当前value数量:</strong><em>${current_value_count}</em>
							</div>
						</div>

						<div class="row"></div>
					</div>

				</div>

			</div>

		</div>
	</div>

	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>

</body>
</html>

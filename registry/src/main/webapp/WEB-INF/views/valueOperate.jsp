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
<link href="<%=basePath%>/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
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
							<button onclick="history.back()"
								class="button button-large button-plain button-border button-circle">
								<i class="fa fa-reply"></i>
							</button>

						</div>

						<div class="col-md-11">
							默认当前操作路径:<strong>${current_key_path}</strong> <br>keyName:<strong>${keyName}</strong>
						</div>


					</div>
				</div>

				<div class="panel-body">
					<div class="text-center">
						<div class="row">
							<form class="form-inline" method="get" action="getValue.htm">
								<div class="form-group">
									<label for="exampleInputName2">ValueName:  </label> 
									<input type="text"
										class="form-control" id="exampleInputName2" name="valueName"
										placeholder="valueName:like xy">
								</div>
								<input type="text" hidden="true" name="current_key_path" value="${current_key_path }">
								
								<button type="submit" class="btn btn-primary">&nbsp;搜索  &nbsp; </button>
							</form>
						</div>

					</div>

				</div>

			</div>
		</div>

		<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
</body>
</html>

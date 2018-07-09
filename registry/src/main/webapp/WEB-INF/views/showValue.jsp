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
						<div class="col-offset-span4">
							<table class="table table-borderd table-striped table-bordered">
								<tr>
									<td class="text-center">valueName:&nbsp;</td>
									<td class="text-left">${valueName}</td>
								</tr>
								<tr>
									<td class="text-center">value:&nbsp;</td>
									<td class="text-left">${valueStr}</td>
								</tr>
							</table>
							
							<button type="button" class="btn btn-primary btn-sm"
											data-toggle="modal" data-target="#myModal">修改</button>
						</div>
					</div>
				</div>

			</div>
		</div>

		<!-- modal for 新建项 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title text-center" id="myModalLabel">修改value</h4>
					</div>
					<form action="updateValue.htm" method="get" name="form1">
						<div class="modal-body">

							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1"><i
									class="fa fa-pencil"></i></span> <input type="text"
									class="form-control" placeholder="${valueName}" name="valueName"
									aria-describedby="basic-addon1">
							</div>
							
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1"><i
									class="fa fa-pencil"></i></span> <input type="text"
									class="form-control" placeholder="${value}" name="newValue"
									aria-describedby="basic-addon1">
							</div>
							
							<input type="text" hidden="true" name="current_key_path"
								value="${current_key_path}">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-primary">创建</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
</body>
</html>

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
							<button onclick="history.back()"
								class="button button-large button-plain button-border button-circle">
								<i class="fa fa-reply"></i>
							</button>

						</div>

						<div class="col-md-8">
							默认当前操作路径:<strong>${current_key_path}</strong>
						</div>

						<div class="col-md-1">
							<button type="button"
								class="button button-large button-plain button-border button-circle"
								data-toggle="modal" data-target="#myModal">
								<i class="fa fa-plus-circle"></i>
							</button>
						</div>
						<div class="col-md-2">
							<button id="addValue"
								class="button button-glow button-rounded button-raised button-inverse button-plain"
								data-toggle="modal" data-target="#modalForAddValue">
								<i class="fa fa-plus"></i>&nbsp; value
							</button>
						</div>

					</div>
				</div>

				<div class="panel-body">
					<div class="text-center">
						

						<div class="row"></div>
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
					<h4 class="modal-title text-center" id="myModalLabel">创建项</h4>
				</div>
				<form action="createKey.htm" method="get" name="form1">
					<div class="modal-body">

						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1"><i
								class="fa fa-pencil"></i></span> <input type="text"
								class="form-control" placeholder="填入key的名称" name="new_subKey"
								aria-describedby="basic-addon1">
						</div>
						<input type="text" hidden="true" name="current_key_path"
							value="${current_key_path}">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">创建</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- addValue的模态框 -->

	<div class="modal fade" id="modalForAddValue" tabindex="-1"
		role="dialog" aria-labelledby="modalForAddValueLabel"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title text-center" id="modalForAddValueLabel">添加value</h4>
				</div>
				<form action="addValue.htm" method="get" name="form2">
					<div class="modal-body">

						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1"><i
								class="fa fa-chevron-down"></i></span> <select class="form-control"
								name="value_type">
								<option value="REG_SZ">REG_SZ</option>
								<option value="REG_DWORD">REG_DWORD</option>
							</select>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1"><i
								class="fa fa-pencil"></i></span> <input type="text"
								class="form-control" placeholder="填入value的名称" name="valueName"
								aria-describedby="basic-addon1">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon2"><i
								class="fa fa-pencil"></i></span> <input type="text"
								class="form-control" placeholder="填入value的值" name="value"
								aria-describedby="basic-addon2">
						</div>
						<input type="text" hidden="true" name="current_key_path"
							value="${current_key_path}">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
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

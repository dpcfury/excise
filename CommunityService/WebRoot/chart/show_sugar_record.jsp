<%@page import="org.w3c.dom.Document"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

<title></title>
</head>

<body>

	<div class="container">
		<div>
			<div>
				<div>
					<div id="chart" style="min-width:700px;height:400px"></div>
				</div>

				<div>
					<hr>
				</div>

				<div>
					<table class="table table-bordered table-striped table-hover">
						<tr>
							<th>编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th>住址</th>
							<th>操作</th>
						</tr>
						<tr>
							<td class="text-center"><s:property
									value="#session.user.userid" /></td>
							<td class="text-center"><s:property
									value="#session.user.realname" /></td>
							<td class="text-center"><s:property
									value="#session.user.sex" /></td>
							<td class="text-center"><s:property
									value="#session.user.age" /></td>
							<td class="text-center"><s:property
									value="#session.user.address" /></td>
							<td class="text-center">
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#myModal">发送警示信息</button>
							</td>

						</tr>
					</table>
				</div>
			</div>
		</div>


	</div>
	<!-- Modal -->

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="PushsendMessage.action" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">
							发送警示信息给用户
							<s:property value="#session.user.realname" />
							?
						</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<textarea class="form-control" name="message" id="message-text"></textarea>
						</div>
					</div>
					<input type="hidden"
						value="<s:property
									value="#session.user.userid" />"
						name="id">
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class=" btn btn-primary ">确认</button>
						<!--  <button type="submit"  class="btn btn-primary" 
          data-dismiss="modal">确认发送</button>-->
					</div>
				</form>
			</div>
		</div>
	</div>

	

</body>
</html>

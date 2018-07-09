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
#first-panel {
	margin-top: 0px;
}

.list-group a {
	font-size: 18px;
}

.panel-success>.panel-heading {
	color: #020B12;
}
</style>

<title>head</title>
</head>

<body>
	<div class="panel-group pinned" id="accordion" role="tablist"
		aria-multiselectable="true">
		<div class="panel panel-primary">
			<div class="panel-heading" role="tab" id="headingTwo">
				<h2 class="panel-title text-center" style="font-size:30px;">
					<i class="fa fa-hospital-o pull-left"></i>更多操作

				</h2>
			</div>
		</div>


		<div class="panel panel-success" id="first-panel">
			<div class="panel-heading" role="tab" id="headingOne">
				<h2 class="panel-title" style="font-size:20px;">
					<a data-toggle="collapse" href="#collapseOne" aria-expanded="true" data-parent="#accordion"
						aria-controls="collapseOne"><i
						class="fa fa-chevron-circle-down pull-left"></i>关于社区</a>
				</h2>
			</div>
			<div id="collapseOne" class="panel-collapse collapse "
				role="tabpanel" aria-labelledby="headingOne">
				<div class="list-group">
					<a href="UserlistAllUserInfo.action?menu_index=1"
						class="list-group-item"> <i class="fa fa-info pull-left"></i>居民信息<i
						class="fa fa-arrow-right pull-right fa-fw"></i>
					</a> <a href="<%=basePath%>message/send_message.jsp"
						class="list-group-item"><i class="fa fa-comment pull-left"></i>医疗消息<i
						class="fa fa-arrow-right pull-right fa-fw"></i> </a>
				</div>
			</div>
		</div>

		<div class="panel panel-success">
			<div class="panel-heading" role="tab" id="headingTwo">
				<h2 class="panel-title" style="font-size:20px;">
					<a class="collapsed" data-toggle="collapse" href="#collapseTwo" data-parent="#accordion"
						aria-expanded="false" aria-controls="collapseTwo"> <i
						class="fa fa-users pull-left"></i>慢性病居民管理
					</a>
				</h2>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
				aria-labelledby="headingTwo">
				<div class="list-group">
					<a href="UserlistAllUsersWithHBP.action?menu_index=2"
						class="list-group-item"><i class="fa fa-heart pull-left"></i>高血压居民<i
						class="fa fa-arrow-right pull-right"></i></a> <a
						href="UserlistAllUsersWithHBS.action?menu_index=2" class="list-group-item"><i
						class="fa fa-child pull-left fa-fw"></i>糖尿病居民<i
						class="fa fa-arrow-right pull-right"></i></a>
				</div>
			</div>
		</div>
		<div class="panel panel-success">
			<div class="panel-heading" role="tab" id="headingThree">
				<h2 class="panel-title" style="font-size:20px;">
					<a class="collapsed" data-toggle="collapse" href="#collapseThree" data-parent="#accordion"
						aria-expanded="false" aria-controls="collapseThree"><i
						class="fa fa-phone pull-left"></i>预约相关 </a>
				</h2>
			</div>
			<div id="collapseThree" class="panel-collapse collapse"
				role="tabpanel" aria-labelledby="headingThree">
				<div class="list-group">
					<a href="AppointmentlistAllYuyueInfo.action?menu_index=3"
						class="list-group-item"><i
						class="fa fa-envelope pull-left fa-fw"></i>居民预约信息<i
						class="fa fa-arrow-right pull-right"></i></a> 

				</div>
			</div>
		</div>

		<div class="panel panel-success">
			<div class="panel-heading" role="tab" id="headingFour">
				<h2 class="panel-title" style="font-size:20px;">
					<a class="collapsed" data-toggle="collapse" href="#collapseFour"
						aria-expanded="false" aria-controls="collapseFour"> <i
						class="fa fa-cog fa-fw pull-left"></i>账户相关
					</a>
				</h2>
			</div>
			<div id="collapseFour" class="panel-collapse collapse"
				role="tabpanel" aria-labelledby="headingFour">
				<div class="list-group">
					<a href="DoctorqueryInfo.action" class="list-group-item"><i
						class="fa fa-tags pull-left"></i>个人信息<i
						class="fa fa-arrow-right pull-right"></i></a> <a
						href="DoctorqueryInfo.action" class="list-group-item"><i
						class="fa fa-adjust pull-left"></i>信息修改<i
						class="fa fa-arrow-right pull-right"></i></a> <a
						href="setimproveinfo.jsp" class="list-group-item"><i
						class="fa fa-refresh fa-spin pull-left"></i>切换用户<i
						class="fa fa-arrow-right pull-right"></i></a>
				</div>
			</div>
		</div>
	</div>




</body>
</html>

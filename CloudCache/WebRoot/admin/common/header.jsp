<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<%
	String datetime = new SimpleDateFormat("yyyy-MM-dd")
			.format(Calendar.getInstance().getTime()); //获取系统时间
%>

<style>
.navbar{
  border-radius: 0px;
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
</style>
<nav class="navbar navbar-inverse " role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Our's Jedis</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">主页</a></li>
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" class="btn"><i
						class="fa  fa-calendar fa-fw"></i>&nbsp;&nbsp;<%=datetime%></a></li>
				<li class="dropdown"><a href="AccountcloudAdminLogOut.action"><span
						class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<s:property
							value="#session.cloudAdmin.adminName" default="Ginsak" /></a></li>
				<li><a href="AccountcloudUserLogOut.action" class="btn"><i
						class="fa   fa-unlock fa-fw"></i>&nbsp;&nbsp;注销</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>

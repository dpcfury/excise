<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>居民信息相关</title>
    <link href="<%=basePath%>bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
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

  </head>
  
  <body>
  	<div class="container-fluid">
  	<s:include value="../common/head.jsp"></s:include>
		
		<div class="row">
			<!-- 左边导航栏 -->
			<div class="col-md-3">
				<jsp:include page="../common/menu.jsp"></jsp:include>
			</div>

			<!-- 右边的content主体 -->
			<div class="col-md-9">
				<jsp:include page="list_userInfo.jsp"></jsp:include>
			</div>
			
		</div>
		
  	</div>
  	
  	<!-- 页脚 -->
	<div class="row">
		<jsp:include page="../common/foot.jsp"></jsp:include>
	</div>
  	
  	<script src="<%=basePath%>/script/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/bootstrap.min.js"></script>
	<script type="text/javascript">
	
		$("th").addClass("text-center");
	</script>
	
	<script type="text/javascript">
		$("a").addClass("text-center");
		$(".col-md-3").addClass("text-center");
		$("body").addClass("font_fam");
		var index="index_"+${nowPage};
		//alert(index);
		var pre_index=${nowPage-1};
		if(pre_index<=0){
			$("#index_pre").addClass("disabled");
		}
		var index_next=${nowPage+1};
		if(index_next>${pageCount}){
			$("#index_next").addClass("disabled");
		}
		$("#"+index).addClass("active");
		
		if(${menu_index}==1)
			$("#collapseOne").addClass("in");;
	</script>
	
  </body>
</html>

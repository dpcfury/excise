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

<link href="<%=basePath%>bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>font-awesome/css/font-awesome.min.css"
	rel="stylesheet">

<style>
body {
	background: url("<%=basePath%>img/bg.jpg");
	padding-bottom: 70px;
}

.font_fam {
	font-family: Helvetica, Tahoma, Arial, STXihei, "华文细黑", Heiti, "黑体",
		"Microsoft YaHei", "微软雅黑", SimSun, "宋体", sans-serif;
}

#foot_part {
	height: 30px;
}

.featurette-divider {
	margin: 80px 0;
}
</style>
</head>

<body>

	<div class="container-fluid">
		<s:include value="../common/head.jsp"></s:include>
		<%-- <s:include page="../common/head.jsp"></jsp:include>--%>


		<div class="row">
			<!-- 左边导航栏 -->
			<div class="col-md-3">
				<jsp:include page="../common/menu.jsp"></jsp:include>
			</div>

			<!-- 右边的content主体 -->
			<div class="col-md-9">
				<jsp:include page="show_sugar_record.jsp"></jsp:include>
			</div>

		</div>

	</div>

	<!-- 页脚 -->
	<div class="row">
		<jsp:include page="../common/foot.jsp"></jsp:include>
	</div>

	<script src="<%=basePath%>/script/jquery-2.1.1.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/script/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/highcharts.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/script/themes/grid.js"></script>

	<script type="text/javascript">
		$("a").addClass("text-center");
		$("th").addClass("text-center");
	</script>

	<script type="text/javascript">
		$("a").addClass("text-center");
		$(".col-md-3").addClass("text-center");
		$("body").addClass("font_fam");
		$("#collapseTwo").addClass("in");
	</script>


	<script type="text/javascript">
		$(function() {
			$('#chart').highcharts(
					{
						chart : {
							type : 'line'
						},
						title : {
							text : '近 期 空 腹 血 糖 测 量 值 '
						},
						subtitle : {
							text : '分析图表'
						},
						xAxis : {
							categories : [ '${records[0].date}',
									'${records[1].date}', '${records[2].date}',
									'${records[3].date}', '${records[4].date}',
									'${records[5].date}', '${records[6].date}',
									'${records[7].date}', '${records[8].date}',
									'${records[9].date}',
									'${records[10].date}',
									'${records[11].date}' ]
						},
						yAxis : {
							title : {
								text : '毫摩尔/升(mmol/L)'
							}
						},
						tooltip : {
							enabled : false,
							formatter : function() {
								return '<b>' + this.series.name + '</b><br/>'
										+ this.x + ': ' + this.y + '°C';
							}
						},
						plotOptions : {
							line : {
								dataLabels : {
									enabled : true
								},
								enableMouseTracking : false
							}
						},
						series : [ {
							name : '测量值',
							data : [ ${records[0].value}, ${records[1].value},
									${records[2].value}, ${records[3].value},
									${records[4].value}, ${records[5].value},
									${records[6].value}, ${records[7].value},
									${records[8].value}, ${records[9].value},
									${records[10].value}, ${records[11].value} ]
						} ]
					});
		});
	</script>
</body>
</html>

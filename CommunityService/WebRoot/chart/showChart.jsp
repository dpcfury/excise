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

<link rel="stylesheet" href="<%=basePath%>/bootstrap/bootstrap.min.css">
<script type="text/javascript" src="script/Chart.js"></script>
 <script type="text/javascript" src="script/jquery-2.1.1.min.js"></script>
</head>

<body>

	<div class="container">
		<div>
			<div>
				<div>
					<canvas id="canvas"></canvas>
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
									value="#session.userForChart.userid" /></td>
							<td class="text-center"><s:property
									value="#session.userForChart.realname" /></td>
							<td class="text-center"><s:property
									value="#session.userForChart.sex" /></td>
							<td class="text-center"><s:property
									value="#session.userForChart.age" /></td>
							<td class="text-center"><s:property
									value="#session.userForChart.address" /></td>
							<td class="text-center">
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#myModal">
									发送警示信息</button>
							</td>

						</tr>
					</table>
				</div>
			</div>
		</div>

		<script>
			var randomScalingFactor = function() {
				return Math.round(Math.random() * 100);
			};
			var lineChartData = {
				labels : [ "${records[6].date}", "${records[5].date}",
						"${records[4].date}", "${records[3].date}",
						"${records[2].date}", "${records[1].date}",
						"${records[0].date}" ],
				datasets : [
						{
							label : "My First dataset",
							fillColor : "rgba(220,220,220,0.2)",
							strokeColor : "rgba(220,220,220,1)",
							pointColor : "rgba(220,220,220,1)",
							pointStrokeColor : "#fff",
							pointHighlightFill : "#fff",
							pointHighlightStroke : "rgba(220,220,220,1)",
							data : [ "${records[6].high}",
									"${records[5].high}", "${records[4].high}",
									"${records[3].high}", "${records[2].high}",
									"${records[1].high}", "${records[0].high}" ]
						},
						{
							label : "My Second dataset",
							fillColor : "rgba(151,187,205,0.2)",
							strokeColor : "rgba(151,187,205,1)",
							pointColor : "rgba(151,187,205,1)",
							pointStrokeColor : "#fff",
							pointHighlightFill : "#fff",
							pointHighlightStroke : "rgba(151,187,205,1)",
							data : [ "${records[6].low}", "${records[4].low}",
									"${records[4].low}", "${records[3].low}",
									"${records[2].low}", "${records[1].low}",
									"${records[0].low}" ]
						} ]

			}

			window.onload = function() {
				var ctx = document.getElementById("canvas").getContext("2d");
				window.myLine = new Chart(ctx).Line(lineChartData, {
					responsive : true
				});
			}
				 
		</script>

	</div>
	<!-- Modal -->

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
    <form action="PushsendMessage.action" method="post">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">发送警示信息给用户<s:property
									value="#session.userForChart.realname" />?</h4>
      </div>            
      <div class="modal-body">
          <div class="form-group">
            <textarea class="form-control" name="message" 
              id="message-text"></textarea>
          </div>     
      </div>
           <input type="hidden" value="<s:property
									value="#session.userForChart.userid" />" name="id">
      <div class="modal-footer">
       <button type="button" class="btn btn-default" 
                 data-dismiss="modal">关闭</button>              
           <button type="submit" class=" btn btn-primary " >确认</button>
          <!--  <button type="submit"  class="btn btn-primary" 
          data-dismiss="modal">确认发送</button>-->
      </div>  
     </form>
    </div>
  </div>
</div>


 
</body>
</html>

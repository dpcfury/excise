<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示图表</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/Chart.min.js"></script>
</head>
<body>

	<div class="row">

		<div class="col-md-4">
			<div class="thumbnail">
				<div id="canvas-holder">
					<canvas id="chart-area1"/>
				</div>
				<div class="caption">
					<h3>Thumbnail label</h3>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">Button</a> <a
							href="#" class="btn btn-default" role="button">Button</a>
					</p>
				</div>
			</div>

		</div>
		
		<div class="col-md-4">
			<div class="thumbnail">
				<div id="canvas-holder">
					<canvas id="chart-area2" />
				</div>
				<div class="caption">
					<h3>Thumbnail label</h3>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">Button</a> <a
							href="#" class="btn btn-default" role="button">Button</a>
					</p>
				</div>
			</div>

		</div>
		
		<div class="col-md-4">
			<div class="thumbnail">
				<div id="canvas-holder">
					<canvas id="chart-area3" />
				</div>
				<div class="caption">
					<h3>Thumbnail label</h3>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">Button</a> <a
							href="#" class="btn btn-default" role="button">Button</a>
					</p>
				</div>
			</div>

		</div>

	</div>

	<script>
		var pieData = [ {
			value : 300,
			color : "#F7464A",
			highlight : "#FF5A5E",
			label : "Red"
		}, {
			value : 50,
			color : "#46BFBD",
			highlight : "#5AD3D1",
			label : "Green"
		}, {
			value : 100,
			color : "#FDB45C",
			highlight : "#FFC870",
			label : "Yellow"
		}, {
			value : 40,
			color : "#949FB1",
			highlight : "#A8B3C5",
			label : "Grey"
		}, {
			value : 120,
			color : "#4D5360",
			highlight : "#616774",
			label : "Dark Grey"
		}

		];

		window.onload = function() {
			var ctx1 = document.getElementById("chart-area1").getContext("2d");
			window.myPie = new Chart(ctx1).Pie(pieData);
			var ctx2 = document.getElementById("chart-area2").getContext("2d");
			window.myPie = new Chart(ctx2).Pie(pieData);
			var ctx3 = document.getElementById("chart-area3").getContext("2d");
			window.myPie = new Chart(ctx3).Pie(pieData);
		};
	</script>

</body>
</html>
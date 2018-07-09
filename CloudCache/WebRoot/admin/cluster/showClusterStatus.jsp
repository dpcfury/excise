<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="panel panel-defalut">
	<div class="panel-heading-small text-center">
		<h3>CPU 负载情况</h3>
	</div>


	<div class="panel-body">
		<div class="row">

			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="chart-area1" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.2:6379</h4>
						<p>
							节点cpu占用率:<strong>50%</strong><br>缓存大小:<strong>100MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>

			</div>

			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="chart-area2" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.3:6379</h4>
						<p>
							节点cpu占用率:<strong>20%</strong><br>缓存大小:<strong>100MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>

			</div>

			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="chart-area3" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.4:6379</h4>
						<p>
							节点cpu占用率:<strong>12%</strong><br>缓存大小:<strong>400MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>

			</div>

			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="chart-area4" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.5:6379</h4>
						<p>
							节点cpu占用率:<strong>26%</strong><br>缓存大小:<strong>400MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>

			</div>

		</div>

		<!-- 第二行显示5以上节点 -->
		<div class="row">

			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="chart-area5" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.6:6379</h4>
						<p>
							节点cpu占用率:<strong>10%</strong><br>缓存大小:<strong>100MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="chart-area6" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.7:6379</h4>
						<p>
							节点cpu占用率:<strong>20%</strong><br>缓存大小:<strong>200MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>

			</div>



		</div>


	</div>

</div>

<!-- 缓存使用情况 -->
<div class="panel panel-defalut">
	<div class="panel-heading-small text-center">
		<h3>Memory已使用情况</h3>
	</div>


	<div class="panel-body">
		<div class="row">

			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="mem-area1" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.2:6379</h4>
						<p>
							总大小:<strong>100MB</strong><br>已使用:<strong>77%</strong><br>剩余大小:<strong>23MB<i
								class="fa fa-exclamation-triangle fa-fw " style="color:red"></i></strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>

			</div>

			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="mem-area2" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.3:6379</h4>
						<p>
							总大小:<strong>100MB</strong><br>已使用:<strong>65%</strong><br>剩余大小:<strong>35MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>

			</div>

			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="mem-area3" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.4:6379</h4>
						<p>
							总大小:<strong>400MB</strong><br>已使用:<strong>26%</strong><br>剩余大小:<strong>296MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>

			</div>

			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="mem-area4" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.5:6379</h4>
						<p>
							总大小:<strong>400MB</strong><br>已使用:<strong>56%</strong><br>剩余大小:<strong>176MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>

			</div>

		</div>

		<!-- 显示5以上节点meme -->
		<div class="row">
		
			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="mem-area5" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.6:6379</h4>
						<p>
							总大小:<strong>100MB</strong><br>已使用:<strong>15%</strong><br>剩余大小:<strong>85MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>
			</div>
			
			<div class="col-md-3 text-center">
				<div class="thumbnail">
					<div id="canvas-holder">
						<canvas id="mem-area6" width="270" height="135"></canvas>
					</div>
					<div class="caption">
						<h4>Node:172.0.0.7:6379</h4>
						<p>
							总大小:<strong>200MB</strong><br>已使用:<strong>10%</strong><br>剩余大小:<strong>180MB</strong>
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">详情</a>
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>

</div>

<!-- Commands Processed -->
<div class="panel panel-defalut">
	<div class="panel-heading-small text-center">
		<h3>Commands Processed</h3>
	</div>


	<div class="panel-body">
		<div class="col-md-12">
			<div class="thumbnail">
				<canvas id="canvas"></canvas>
			</div>
		</div>
	</div>
</div>




<script>
	var pieData = [ {
		value : 50,
		color : "#46BFBD",
		highlight : "#5AD3D1",
		label : "未使用cpu %"
	}, {
		value : 50,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用cpu %"
	}

	];
	var pieData2 = [ {
		value : 80,
		color : "#46BFBD",
		highlight : "#5AD3D1",
		label : "未使用cpu %"
	}, {
		value : 20,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用cpu %"
	}

	];
	var pieData3 = [ {
		value : 88,
		color : "#46BFBD",
		highlight : "#5AD3D1",
		label : "未使用cpu %"
	}, {
		value : 12,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "Green"
	}

	];

	var pieData4 = [ {
		value : 74,
		color : "#46BFBD",
		highlight : "#5AD3D1",
		label : "未使用cpu %"
	}, {
		value : 26,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用cpu %"
	}

	];
	var pieData5 = [ {
		value : 90,
		color : "#46BFBD",
		highlight : "#5AD3D1",
		label : "未使用cpu %"
	}, {
		value : 10,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用cpu %"
	}

	];
	var pieData6 = [ {
		value : 95,
		color : "#46BFBD",
		highlight : "#5AD3D1",
		label : "未使用cpu %"
	}, {
		value : 5,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用cpu %"
	}

	];

	var randomScalingFactor = function() {
		return Math.round(Math.random() * 100)
	};
	var lineChartData = {
		labels : [ "1.42 下午", "2.24 下午", "3.24 下午", "4.24 下午", "5.24 下午",
				"6.24 晚", "7.24 晚" ],
		datasets : [ {
			label : "My First dataset",
			fillColor : "rgba(220,220,220,0.2)",
			strokeColor : "rgba(220,220,220,1)",
			pointColor : "rgba(220,220,220,1)",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(220,220,220,1)",
			data : [ randomScalingFactor(), randomScalingFactor(),
					randomScalingFactor(), randomScalingFactor(),
					randomScalingFactor(), randomScalingFactor(),
					randomScalingFactor() ]
		} ]

	};

	var doughnutData = [ {
		value : 77,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用大小%(单位)"
	}, {
		value : 23,
		color : "#FDB45C",
		highlight : "#FFC870",
		label : "剩余大小 %(单位)"
	}

	];
	var doughnutData2 = [ {
		value : 65,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用大小 %(单位)"
	}, {
		value : 35,
		color : "#FDB45C",
		highlight : "#FFC870",
		label : "剩余大小 %(单位)"
	}

	];
	var doughnutData3 = [ {
		value : 77,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用大小 %(单位)"
	}, {
		value : 23,
		color : "#FDB45C",
		highlight : "#FFC870",
		label : "剩余大小%(单位)"
	}

	];
	var doughnutData4 = [ {
		value : 77,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用大小 %(单位)"
	}, {
		value : 23,
		color : "#FDB45C",
		highlight : "#FFC870",
		label : "剩余大小 %(单位)"
	}

	];
	
	var doughnutData5 = [ {
		value : 15,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用大小 %(单位)"
	}, {
		value : 85,
		color : "#FDB45C",
		highlight : "#FFC870",
		label : "剩余大小 %(单位)"
	}

	];
	
	var doughnutData6 = [ {
		value : 10,
		color : "#F7464A",
		highlight : "#FF5A5E",
		label : "已使用大小 %(单位)"
	}, {
		value : 90,
		color : "#FDB45C",
		highlight : "#FFC870",
		label : "剩余大小 %(单位)"
	}

	];

	window.onload = function() {
		var ctx1 = document.getElementById("chart-area1").getContext("2d");
		window.myPie = new Chart(ctx1).Pie(pieData);
		var ctx2 = document.getElementById("chart-area2").getContext("2d");
		window.myPie = new Chart(ctx2).Pie(pieData2);
		var ctx3 = document.getElementById("chart-area3").getContext("2d");
		window.myPie = new Chart(ctx3).Pie(pieData3);
		var ctx4 = document.getElementById("chart-area4").getContext("2d");
		window.myPie = new Chart(ctx4).Pie(pieData4);
		var ctx4 = document.getElementById("chart-area5").getContext("2d");
		window.myPie = new Chart(ctx4).Pie(pieData5);
		var ctx4 = document.getElementById("chart-area6").getContext("2d");
		window.myPie = new Chart(ctx4).Pie(pieData6);

		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive : true
		});

		var ctx = document.getElementById("mem-area1").getContext("2d");
		window.myDoughnut = new Chart(ctx).Doughnut(doughnutData, {
			responsive : true
		});
		var ctx = document.getElementById("mem-area2").getContext("2d");
		window.myDoughnut = new Chart(ctx).Doughnut(doughnutData2, {
			responsive : true
		});
		var ctx = document.getElementById("mem-area3").getContext("2d");
		window.myDoughnut = new Chart(ctx).Doughnut(doughnutData3, {
			responsive : true
		});
		var ctx = document.getElementById("mem-area4").getContext("2d");
		window.myDoughnut = new Chart(ctx).Doughnut(doughnutData4, {
			responsive : true
		});
		var ctx = document.getElementById("mem-area5").getContext("2d");
		window.myDoughnut = new Chart(ctx).Doughnut(doughnutData5, {
			responsive : true
		});
		var ctx = document.getElementById("mem-area6").getContext("2d");
		window.myDoughnut = new Chart(ctx).Doughnut(doughnutData6, {
			responsive : true
		});
	};
</script>


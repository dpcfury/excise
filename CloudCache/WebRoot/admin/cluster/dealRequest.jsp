<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">

	<!-- 处理用户请求的界面 -->
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading text-center">
			<strong style="color:green">请求处理</strong>
		</div>


		<!-- Table -->
		<table class="table table-bordered">

			<tr>
				<td>用户民称</td>
				<td>请求类型</td>
				<td>要求容量大小</td>
				<td>请求时间</td>
				<td>是否有集群</td>
				<td>拥有节点数</td>
			</tr>

			<tr>
				<td>jack</td>
				<td>创建集群</td>
				<td>1GB</td>
				<td>2014.12.15</td>
				<td>无</td>
				<td>0</td>
			</tr>
		</table>

		<hr>

		<div class="row">
			<div class="col-md-6">
				<mark>用户附言：</mark>
				<i class="fa fa-quote-left fa-2x pull-left fa-border"></i>
				我们已经成功注册，现在希望能够使用云缓存系统，申请一个容量足够我么业务使用的缓存集群，希望尽早回复。<i
					class="fa fa-quote-right fa-2x pull-right fa-border"></i>
			</div>

			<div class="col-md-6">
				<div class="text-center col-md-4 pull-right">
					<button class="btn btn-primary btn-lg btn-block" id="createCluster">
						为其创建集群</button>
				</div>
			</div>
		</div>

	</div>


</div>

<!--选择了创建用户集群以后，将操作块显示出来 -->
<div class="container" id="operation">

	<div class="well">
		<h3 class="text-center text-info">节点配置</h3>
		<form class="form-horizontal" role="form" action="ClustercreateUserCluster.action">
			<div class="form-group">
				<label for="inputOne" class="col-md-2 control-label">100MB节点</label>
				<div class="col-md-10">
					<select class="form-control input-lg" id="inputOne" >
						<option>1</option>
						<option>2</option>
					</select>
					
				</div>
			</div>
			
		<div class="form-group">
				<label for="inputTwo" class="col-md-2 control-label">200MB节点</label>
				<div class="col-md-10">
					<select class="form-control input-lg" id="inputTwo">
						<option>1</option>
						<option>2</option>
						
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputThree" class="col-md-2 control-label">400MB节点</label>
				<div class="col-md-10">
					<select class="form-control input-lg" id="inputThree">
						<option>1</option>
						<option>2</option>
						
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputFour" class="col-md-2 control-label">800MB节点</label>
				<div class="col-md-10">
					<select class="form-control input-lg" id="inputFour">
						<option>1</option>
						<option>2</option>
						
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-md-offset-4 col-md-8">
					<div class="pull-right">
					<button type="submit" class="btn btn-primary">检查无误,确定</button>
					</div>
				</div>
			</div>
		</form>
	</div>


</div>




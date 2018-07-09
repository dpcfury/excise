<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">

	<table class="table table-striped">
		<tr>
			<td>用户名</td>
			<td>是否已有集群</td>
			<td>请求类型</td>
			<td>处理状态</td>
			<td>操作</td>
		</tr>
	
	<tr>
		<td>dpc</td>
		<td>有</td>
		<td>扩容200MB</td>
		<td>已处理</td>
		<td><a class="btn btn-primary" disabled> 点击处理</a></td>
	</tr>
	
	<tr>
		<td>wwt</td>
		<td>有</td>
		<td>扩容400MB</td>
		<td>已处理</td>
		<td><a class="btn btn-primary" disabled> 点击处理</a></td>
	</tr>
	<tr>
		<td>ll</td>
		<td>有</td>
		<td>扩容200MB</td>
		<td>已处理</td>
		<td><a class="btn btn-primary" disabled> 点击处理</a></td>
	</tr>
	<tr>
		<td>jack</td>
		<td>无</td>
		<td>创建集群</td>
		<td>已处理</td>
		<td><a href="ClusterbeginToDealRequest.action" class="btn btn-primary" disabled>点击处理</a></td>
	</tr>
	<tr>
		<td>jack</td>
		<td>有</td>
		<td>增加缓存</td>
		<td>未处理</td>
		<td><a href="ClusterbeginToDealUserAddRequest.action" class="btn btn-primary">点击处理</a></td>
	</tr>
	
	
	</table>

</div>
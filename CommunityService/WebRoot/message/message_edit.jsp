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

<title>显示全部的居民信息</title>

<link href="<%=basePath%>bootstrap/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="<%=basePath%>/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="<%=basePath%>/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="<%=basePath%>/kindeditor/lang/zh_CN.js"></script>
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="message"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [ 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor',
					'bold', 'italic', 'underline', 'removeformat', '|',
					'justifyleft', 'justifycenter', 'justifyright',
					'insertorderedlist', 'insertunorderedlist', '|',
					'emoticons', 'image', 'link' ]
		});
	});
</script>
</head>

<body>

	<div id="message">

		<form action="PushsendBroadCastMessage.action" method="post">
			<div class="input-group col-md-8">
				<div class="row">
					<div class="col-md-10">
						<input type="text" class="form-control" placeholder="标题"
							name="title" aria-describedby="basic-addon1">
					</div>
					<div class="col-md-2">
						<button type="submit" class="btn btn-primary">
							发送社区消息&nbsp;<i class="fa fa-share-square"></i>
						</button>
					</div>
				</div>

			</div>
			<br>
			<div class="">
				<textarea name="message"
					style="width:800px;height:400px;visibility:hidden;">填写内容.....</textarea>
			</div>

		</form>
	</div>

	<script type="text/javascript"
		src="<%=basePath%>/script/jquery-2.1.1.min.js"></script>

</body>
</html>

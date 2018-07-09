<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<diV class="container-fluid">

	<!-- 填写申请的编辑组件 -->
	<div class="panel panel-primary">

		<!-- 标题 -->
		<div class="panel-heading">
			<p class="text-center" style="font-size:20px;">填写申请</p>
		</div>

		<!-- 输入 -->
		<div class="panel-body">

			<form class="form-horizontal" role="form"
				action="ClusterapplyForCluster.action" method="post">

				<div class="form-group form-group-lg">

					<div class="container">
						<label class="col-md-2 control-label" for="formGroupInputLarge">缓存大小:</label>
						<div class="col-md-6">
							<input type="text" id="formGroupInputLarge" class="form-control"
								placeholder="输入您要申请的缓存大小，如 1GB">
						</div>
					</div>
				</div>


				<div class="form-group form-group-lg">
					<div class="container">
						<label class="col-md-2 control-label" for="formGroupInputLarge">附言:</label>
						<div class="col-md-6">
							<!-- <input class="form-control" type="" id="formGroupInputLarge"
							placeholder="Small input"> -->
							<textarea rows="10" cols="80" class="textarea">请在此补充您的需求以及申请理由。。。。
						</textarea>

						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-offset-4 col-md-1">
						<button type="submit" class="btn btn-primary btn-lg">提交申请</button>
					</div>
				</div>
			</form>

		</div>

		<!-- 脚注 -->
		<div class="panel-footer ">
			<p class="text-center text-danger" style="font-size:14px;">
				<strong>申请之后请及时查看</strong>
			</p>
		</div>

	</div>


</diV>
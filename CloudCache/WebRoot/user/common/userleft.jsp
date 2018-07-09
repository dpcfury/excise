<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<!-- 安置在左侧的可折叠式的导航-->
<div class="text-center">


	<div class="panel-group pinned" id="accordion" role="tablist"
		aria-multiselectable="true">
		<div class="panel panel-primary">
			<div class="panel-heading" role="tab" id="headingTwo">
				<h2 class="panel-title text-center" style="font-size:30px;">

					<i class="fa fa-cloud fa-fw pull-left"></i>相关操作

				</h2>
			</div>
		</div>


		<div class="panel panel-success" id="first-panel">
			<div class="panel-heading" role="tab" id="headingOne">
				<h2 class="panel-title" style="font-size:20px;">
					<a data-toggle="collapse" href="#collapseOne" aria-expanded="true"
						aria-controls="collapseOne"><i
						class=" fa fa-database pull-left fa-fw"></i> 缓存集群相关 </a>
				</h2>
			</div>
			<div id="collapseOne" class="panel-collapse collapse " role="tabpanel"
				aria-labelledby="headingOne">
				<div class="list-group">
				<a href="ClustereditApplication.action" class="list-group-item"><i
						class="fa fa-bar-chart pull-left fa-fw"></i>申请缓存集群<i
						class="fa fa-arrow-right pull-right fa-fw"></i> </a>
					<a href="ClustergetMyClusterStatus.action" class="list-group-item"><i
						class="fa fa-bar-chart pull-left fa-fw"></i> 查看当前缓存集群状态<i
						class="fa fa-arrow-right pull-right fa-fw"></i> </a> <a
						href="ClustergetUserClusterList.action" class="list-group-item"><i
						class="fa fa-line-chart pull-left fa-fw"></i>集群参数列表<i
						class="fa fa-arrow-right pull-right fa-fw"></i></a> <a href="#"
						class="list-group-item"><i class="fa fa-file pull-left fa-fw"></i>集群使用日志<i
						class="fa fa-arrow-right pull-right fa-fw"></i></a>
				</div>
			</div>
		</div>
		
		<div class="panel panel-success">
			<div class="panel-heading" role="tab" id="headingTwo">
				<h2 class="panel-title" style="font-size:20px;">
					<a class="collapsed" data-toggle="collapse" href="#collapseTwo"
						aria-expanded="false" aria-controls="collapseTwo"> <i
						class="fa fa-pencil fa-fw pull-left"></i>申请扩容
					</a>
				</h2>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
				aria-labelledby="headingTwo">
				<div class="list-group">
					<a href="ClustereditAddNodeRequest.action" class="list-group-item"><i
						class="fa fa-sign-in pull-left fa-fw"></i>增加缓存<i
						class="fa fa-arrow-right pull-right"></i></a> <a href="ClustercheckRequestResult.action"
						class="list-group-item"><i
						class="fa fa-search pull-left fa-fw"></i>查看申请结果<i
						class="fa fa-arrow-right pull-right"></i></a>
				</div>
			</div>
		</div>
		<div class="panel panel-success">
			<div class="panel-heading" role="tab" id="headingThree">
				<h2 class="panel-title" style="font-size:20px;">
					<a class="collapsed" data-toggle="collapse" href="#collapseThree"
						aria-expanded="false" aria-controls="collapseThree"> <i
						class="fa fa-cog fa-fw pull-left"></i>设置
					</a>
				</h2>
			</div>
			<div id="collapseThree" class="panel-collapse collapse"
				role="tabpanel" aria-labelledby="headingThree">
				<div class="panel-body">Anim pariatur cliche reprehenderit,
					enim eiusmod high life accusamus terry richardson ad squid. 3 wolf
					moon officia aute, non cupidatat skateboard dolor brunch. Food
					truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor,
					sunt aliqua put a bird on it squid single-origin coffee nulla
					assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer
					labore wes anderson cred nesciunt sapiente ea proident. Ad vegan
					excepteur butcher vice lomo. Leggings occaecat craft beer
					farm-to-table, raw denim aesthetic synth nesciunt you probably
					haven't heard of them accusamus labore sustainable VHS.</div>
			</div>
		</div>
	</div>

</div>
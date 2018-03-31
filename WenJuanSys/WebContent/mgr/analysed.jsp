<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分析查询</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jsapi.js"></script>
<script type="text/javascript" src="${path}/js/corechart.js"></script>
<script type="text/javascript"
	src="${path}/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.ba-resize.min.js"></script>
<script type="text/javascript">
	gvChartInit();
	$(document).ready(function() {
		$('#myTable1').gvChart({
			chartType : 'PieChart',
			gvSettings : {
				vAxis : {
					title : 'No of players'
				},
				hAxis : {
					title : 'Month'
				},
				width : 600,
				height : 550
			}
		});
	});
	$(document).ready(function() {
		$('#myTable5').gvChart({
			chartType : 'PieChart',
			gvSettings : {
				vAxis : {
					title : 'No of players'
				},
				hAxis : {
					title : 'Month'
				},
				width : 600,
				height : 550
			}
		});
	});
	function search() {

		var riqi = $('.riqi').val();
		var title = $('.title').val();
		var hop = "search";

		$
				.ajax({
					type : 'post',
					url : '${path}/dTKServlet',

					data : {
						op : hop,
						title : title,
						riqi : riqi
					},
					dataType : 'json',
					success : function(json) {
						$("#chart").empty();
						$(document).ready(function() {
							gvChartInit();
							$('#myTable5').gvChart({
								chartType : 'PieChart',
								gvSettings : {
									vAxis : {
										title : 'No of players'
									},
									hAxis : {
										title : 'Month'
									},
									width : 600,
									height : 550
								}
							});
						});
						$(document).ready(function() {
							$('#myTable1').gvChart({
								chartType : 'PieChart',
								gvSettings : {
									vAxis : {
										title : 'No of players'
									},
									hAxis : {
										title : 'Month'
									},
									width : 600,
									height : 550
								}
							});
						});
						$("#chart")
								.append(
										"<div class='col-sm-6'><table id='myTable5'><caption>问卷调查填空选择统计</caption><thead><tr><th></th><th>优秀</th><th>良好</th><th>合格</th><th>不合格</th>	</tr></thead><tbody><tr><th>1200</th><td>"+json.exe+"</td><td>"+json.fit+"</td><td>"+json.qua+"</td><td>"+json.nQu+"</td> </tr></tbody></table></div>");
						$("#chart")
						.append(
								"<div class='col-sm-6'><table id='myTable1'><caption>问卷调查性别分析统计</caption><thead><tr><th></th><th>男优秀</th><th>女优秀</th><th>男良好</th><th>女良好</th><th>男合格</th><th>女合格</th><th>男不合格</th><th>女不合格</th>	</tr></thead><tbody><tr><th>1200</th><td>"+json.mEcx+"</td><td>"+json.fEcx+"</td><td>"+json.mFit+"</td><td>"+json.fFit+"</td> <td>"+json.mQua+"</td><td>"+json.fQua+"</td><td>"+json.mNqua+"</td><td>"+json.fNqua+"</td></tr></tbody></table></div>");
						//$("#myTable5 tr:gt(0) td").each(function(){

						//$(this).html("100");

						//});
					},
					error : function(data) {
						alert("问卷不存在！");
					}

				});
	}
</script>



<style type="text/css">
.space {
	margin-top: 50px;
}
</style>


</head>
<body>

	<!-- 查询试卷的条件 -->
	<div class="row">
		<div class="col-sm-11 col-sm-offset-1">
			<form class="form-horizontal">
				<div class="form-group">
					<label for="inputPassword" class="col-sm-2 control-label">日期</label>
					<div class="col-sm-6">
						<input type="date" class="riqi form-control" id="inputPassword"
							placeholder="Password">
					</div>
				</div>
			</form>
			<div class="row">
				<div class="col-sm-6 col-sm-offset-2">
					<div class="input-group">
						<input type="text" class="title form-control"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-info" type="button" onclick="search();">Go!</button>
						</span>
					</div>
					<!-- /input-group -->
				</div>
				<!-- /.col-lg-6 -->
			</div>
		</div>
	</div>
	<div class="row" id="chart">
		<div class="col-sm-6">
			<table id='myTable5'>
				<caption>问卷调查填空选择统计</caption>
				<thead>
					<tr>
						<th></th>
						<th>优秀</th>
						<th>良好</th>
						<th>合格</th>
						<th>不合格</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>1200</th>
						<td>200</td>
						<td>200</td>
						<td>200</td>
						<td>200</td>

					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-sm-6">

			<table id='myTable1'>
				<caption>会员性别分布</caption>
				<thead>
					<tr>
						<th></th>
						<th>男</th>
						<th>女</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>1000</th>
						<td>450</td>
						<td>550</td>
					</tr>
				</tbody>
			</table>

		</div>

	</div>
	<div class="row">
		<form method="post" id="passForm" class="hidden"
			action="${path}/mgr/analysed.jsp">
			<input type="text" value="50" class="form-control" name="test2"
				id="test2">
		</form>

	</div>

</body>
</html>
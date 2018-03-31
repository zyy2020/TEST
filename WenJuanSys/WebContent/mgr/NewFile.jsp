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
<title>主页图片</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script src="${path}/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/js/jsapi.js"></script>
<script type="text/javascript" src="${path}/js/corechart.js"></script>		
<script type="text/javascript" src="${path}/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.ba-resize.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript">
gvChartInit();
$(document).ready(function(){
	$('#myTable5').gvChart({
		chartType: 'PieChart',
		gvSettings: {
			vAxis: {title: 'No of players'},
			hAxis: {title: 'Month'},
			width: 600,
			height: 650
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
</script>



</head>
<body>
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

</body>
</html>
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
<title>问卷操作</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript">
	function b(name) {
		alert(name);
		$.ajax({
			type : "post",
			url : "${path}/shiJuanServlet",
			dataType : "json",
			data : {},
			success : function(data) {
				alert(data.name);
				$('.all').empty();
			},
			error : function() {
				alert("error");
			}
		});

	}
</script>
<style type="text/css">
.d1 {
	background-color: #5cb85c;
}

.pa {
	padding-top: 60px;
}

.d2 {
	background-color: #5bc0de;
}

.d3 {
	background-color: #f0ad4e;
}

.f {
	font-family: Tsans-serif;
	font-size: 24px;
	color: #FFFFFF;
}

.g {
	font-family: Tsans-serif;
	font-size: 18px;
	color: #FFFFFF;
}

.d4 {
	padding-top: 190px;
}

.bo {
	padding-bottom: 60px;
}
</style>
</head>
<body>
	<div class="row">
		<div class="d1 col-sm-4 pa">
			<div class="row">
				<div class="col-sm-8">
					<img alt="" src="${path}/img/old.png">
				</div>
				<div class="d4 col-sm-4">
					<img alt="" src="${path}/img/pen.png" width="70%" height="70%">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-9 col-sm-offset-3">
					<font class="f">创建空白问卷</font>
				</div>
				<div class="row">

					<div class="col-sm-10 col-sm-offset-2">
						<font class="g">从一份空白问卷开始创建</font>
					</div>
				</div>
				<div class="row">
					<div class="bo col-sm-8 col-sm-offset-4">
						<a href="${path}/mgr/builtShiJuan.jsp" class="btn btn-default"
							target="iframe_a">添加问卷</a>

						<!-- <button type="button" class="btn btn-default" name="initial" onclick='b(this.name)'>开始创建</button> -->
					</div>
				</div>
			</div>
		</div>
		<div class="d2 col-sm-4 pa">
			<div class="row">
				<div class="col-sm-8">
					<img alt="" src="${path}/img/green.png">
				</div>
				<div class="d4 col-sm-4">
					<img alt="" src="${path}/img/pen2.png" width="70%" height="70%">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-9 col-sm-offset-3">
					<font class="f">问卷模板库</font>
				</div>
				<div class="row">
					<div class="col-sm-10 col-sm-offset-2">
						<font class="g">从0到100分的试题开始</font>
					</div>
				</div>
				<div class="row">
					<div class="bo col-sm-8 col-sm-offset-4">
					<a href="${path}/mgr/checkShiJuan.jsp" class="btn btn-default"
							target="iframe_a">开始查看</a>
					</div>
				</div>
			</div>
		</div>
		<div class="d3 col-sm-4 pa">
			<div class="row">
				<div class="col-sm-8">
					<img alt="" src="${path}/img/blue.png">
				</div>
				<div class="d4 col-sm-4">
					<img alt="" src="${path}/img/pen3.png" width="70%" height="70%">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-9 col-sm-offset-3">
					<font class="f">文本编辑问卷</font>
				</div>
				<div class="row">

					<div class="col-sm-10 col-sm-offset-2">

						<font class="g">为试卷添加趣味，由你开始</font>
					</div>
				</div>
				<div class="row">
					<div class="bo col-sm-8 col-sm-offset-4">
						<a href="${path}/mgr/modifyShiJuan.jsp" class="btn btn-default"
							target="iframe_a">编辑问卷</a>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
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
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<title>题库管理</title>

<style type="text/css">
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$("a").click(function() {
			$("a img").removeClass("img-circle");
			var img = $(this).find("img");
			img.addClass("img-circle")
		});

	});
</script>
</head>
<body>

	<div class="row">
		<div class="col-sm-3 col-sm-offset-2">
			<a href="${path}/mgr/exam.jsp" target="iframe_b"><img alt=""
				src="${path}/img/stu1.png" width="30%" height="30%"
				class="img-circle"></a>

		</div>
		<div class="col-sm-3">
			<a href="${path}/mgr/tianKongExam.jsp" target="iframe_b"><img
				alt="" src="${path}/img/stu2.png" width="30%" height="30%"></a>

		</div>
		<div class="col-sm-3">
			<a href="${path}/mgr/askExam.jsp" target="iframe_b"><img alt=""
				src="${path}/img/stu3.png" width="30%" height="30%"></a>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3 col-sm-offset-2">
			&nbsp;&nbsp;<span id="span1">选择题</span>
		</div>
		<div class="col-sm-3">
			&nbsp;&nbsp;<span id="span2">填空题</span>
		</div>
		<div class="col-sm-3">
			&nbsp;&nbsp;<span id="span3">问答题</span>
		</div>
	</div>
	<div class="row">
		<hr style="background-color: #272727; height: 2px" />
	</div>
	<div class="embed-responsive embed-responsive-4by3">
		<iframe class="embed-responsive-item" scrolling="no"
			src="${path}/mgr/exam.jsp" name="iframe_b"></iframe>
	</div>
</body>
</html>
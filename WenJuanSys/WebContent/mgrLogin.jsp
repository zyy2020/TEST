<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	function changeImg() {
		var img = document.getElementById("img");
		img.src = "${path}/codeServlet?date=" + new Date();
	}
	$(document).ready(function() {

		$("#code").blur(function() {

			var v = $("#code").val();
			if (v != "") {
				$.post("${path}/userServlet", {
					op : "yanzheng",
					code : v
				}, function(data) {
					if (data != "ok")//验证码输入不正确
						alert("验证码不正确，请重新输入");
				});
			}
		});
	});
</script>
<style type="text/css">
body {
	background: url('${path}/img/in.jpg');
}

.centre {
	margin-top: 100px;
	background-color: #337ab7;
}
.col{
background-color: #337ab7;

}
</style>
</head>
<body>
	<div class="container ">
		<div class="row">
			<div class="col-md-3 col-md-offset-5 centre">

				<h2>
					<font color="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;管理员登录</font><span
						class="glyphicon glyphicon-lock" aria-hidden="true"></span>
				</h2>
			</div>

		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-5 col">
				<form action="${path}/mgrServlet" method="post">
					<div class="form-group has-success">
						<label for="form-username">姓名</label> <input type="text"
							name="username" placeholder="username"
							class="form-username form-control" id="username"
							required="required">
					</div>
					<div class="form-group has-error has-feedback">
						<label for="Password">密码</label> <input type="password"
							name="password" required="required" class="form-control"
							id="password" placeholder="Password">

					</div>
					<div class="form-group has-error ">
						<img src="${path}/codeServlet" id="img" /> <a href='#'
							onclick="javascript:changeImg()" style="color: white;"><label
							style="color: white; font-family: 微软雅黑">看不清,换一张？</label></a> <input
							type="text" id="code" required="required" class="form-control"
							name="code" placeHolder="yanzhengma">

					</div>

					<button type="submit" id="submit"
						class="btn btn-success btn-md btn-block">Sumbit</button>
						<br>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
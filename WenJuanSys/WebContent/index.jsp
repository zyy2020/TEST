<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="path" value="${pageContext.request.contextPath }" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".button3").click(function() {
			$(".inputsignin").hide();
			$(".inputsignup").show();
			$(".inputsignup").removeClass("hidden");
			$(".button3").css("color", "#000000");
			$(".button2").css("color", "#AAAAAA");
		});

	});
	$(document).ready(function() {
		$(".button2").click(function() {
			$(".inputsignup").hide();
			$(".inputsignin").show();
			$(".button2").css("color", "#000000");
			$(".button3").css("color", "#AAAAAA");
		});
	});
	function changeImg() {
		var img = document.getElementById("img");
		img.src = "${path}/codeServlet?date=" + new Date();
	
	}

	function formCheck() {

		var pwd1 = document.getElementById("password1").value;
		var pwd2 = document.getElementById("password2").value;
		if (pwd1 != pwd2) {

			alert("两次输入的密码不一致！");
			return false;
		}
		return true;
	}
	$(document).ready(function(){

		$("#code").blur(function(){
			
			var v=$("#code").val();
			if(v!=""){
				$.post("${path}/userServlet",{op:"yanzheng",code:v},function(data){
					if(data!="ok")//验证码输入不正确
					{
						
						alert("验证码不正确，请重新输入");
						window.location.reload();
					}
					
				});
			}
		});
	});
</script>


<style type="text/css">
body {
	background-image: url('${path}/img/in.jpg');
}

#bb {
	font-family: 微软雅黑;
	font-size: 24px;
	color: #AAAAAA;
	text-decoration: none;
}

#aa {
	font-family: 微软雅黑;
	font-size: 24px;
	color: #000000;
	text-decoration: none;
}

.inputsignup {
	float: none;
	display: block;
	margin-left: auto;
	margin-right: auto;
	background-color: rgba(255, 255, 255, 0.3);
}

.inputsignin {
	float: none;
	display: block;
	margin-left: auto;
	margin-right: auto;
	background-color: rgba(255, 255, 255, 0.3);
}

.divtitle {
	margin-top: 80px;
	float: none;
	display: block;
	margin-left: auto;
	margin-right: auto;
}


</style>
</head>
<body>


		<div class="container">
			<div class="row">
				<div class="col-md-4 divtitle">
					&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
					&nbsp &nbsp<a href="#" class="button2" id="aa" role="button">登录</a>&nbsp
					&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<a href="#" class="button3"
						id="bb" role="button">注册</a>


				</div>
			</div>

			<div class="row">
				<div class="col-md-3 inputsignup hidden">
					<form method="post" action="${path}/userServlet?op=regist"
						onsubmit="return formCheck() " enctype="multipart/form-data">
						<div class="form-group has-success has-feedback">
							<label for="name">姓名</label> <input
								class="form-control" required="required" type="text"
								name="userName" placeholder="Name"
								aria-describedby="inputSuccess2Status"> <span
								class="glyphicon glyphicon-ok form-control-feedback"
								aria-hidden="true"></span> <span id="inputSuccess2Status"
								class="sr-only">(success)</span>


						</div>
						<div class="form-group has-error has-feedback">
							<label for="password1">密码</label> <input
								type="password" required="required" class="form-control"
								id="password1" name="password1" placeholder="Password">

						</div>
						<div class="form-group has-error has-feedback">
							<label for="password2">确认密码</label> <input
								type="password" class="form-control" required="required"
								id="password2" name="password2" placeholder="Password">

						</div>
						<div class="form-group has-error has-feedback">
							<label for="file">相片</label><input type="file"
								id="file" name="img">

                         <div class="form-group has-error has-feedback">
                          <label for="birth">出生日期</label>
                          <input type="date" id="birth"  name="birth" class="form-control" required="required">
                         
                         </div>

						</div>
						<div class="form-group as-warning has-feedback">
							<label class="radio-inline"> <input type="radio"
								name="inlineRadioOptions" checked id="gender1"
								value="male"> 男
							</label> <label class="radio-inline"><input type="radio"
								name="inlineRadioOptions" id="gender2" value="female">
								女 </label>
						</div>

						<button type="submit" class="btn btn-success btn-md btn-block">Sumbit</button>
						<br />
					</form>


				</div>
				<div class="col-md-3 inputsignin " id="divlogin">
					<form action="${path}/userServlet?op=login" method="post">
					
						<div class="form-group has-success has-feedback">
							<label for="exampleInputName1">姓名</label> <input
								class="form-control" required="required" type="text"
								id="exampleInputName1" name="userName" placeholder="Name"
								aria-describedby="inputSuccess2Status"> <span
								class="glyphicon glyphicon-ok form-control-feedback"
								aria-hidden="true"></span> <span id="inputSuccess2Status"
								class="sr-only">(success)</span>

						</div>
						<div class="form-group has-error has-feedback">
							<label for="exampleInputPassword2">密码</label> <input
								type="password" name="password" required="required" class="form-control"
								id="exampleInputPassword2" placeholder="Password">

						</div>
						<div class="form-group has-error has-feedback">
							<img src="${path}/codeServlet" id="img" /> <a href='#'
								onclick="javascript:changeImg()" style="color: white;"><label
								style="color: white; font-family: 微软雅黑">看不清,换一张？</label></a> <input
								type="text" id="code"required="required" class="form-control" name="code"  
								placeHolder="yanzhengma">

						</div>
						<button type="submit" class="btn btn-success btn-md btn-block">Sumbit</button>
						<br />
					</form>
				</div>


			</div>


		</div>




</body>
</html>
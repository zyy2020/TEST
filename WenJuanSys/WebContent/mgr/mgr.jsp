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
<title>管理主页</title>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/css/bootstrap.css">
<script type="text/javascript" src="${path}/js/bootstrap.js"></script>

<style type="text/css">
.test {
	padding-top: 5px;
	font-family: 微软雅黑;
	font-size: 16px;
}

.navbar {
	position: relative;
	min-height: 40px;
	margin-bottom: 20px;
	border: 1px solid transparent;
}

.navbar-default .navbar-brand {
	color: #333;
}
</style>
<script type="text/javascript">



	$(function() {

		$('.link li').click(function() {
			$('.link li').removeClass('active');
			$(this).addClass('active');

		})

	})
</script>
<script type="text/javascript">
alert("ff");
function SetPageHeight() {
//  var iframe = getUrlParam('ifname');
//  var myiframe = window.parent.document.getElementById(iframe);
//   iframeLoaded(myiframe);
//}
alert("gg");
var iframeLoaded = function (iframe) {
  if (iframe.src.length > 0) {
      if (!iframe.readyState || iframe.readyState == "complete") {
          var bHeight = 
          iframe.contentWindow.document.body.scrollHeight;
          var dHeight = 
          iframe.contentWindow.document.documentElement.scrollHeight;
          var height = Math.max(bHeight, dHeight);
          iframe.height = height;
      }
  }
}
//分页时重新设置 iframe 高度 ； 修改后：iframe.name = iframe.id
var reSetIframeHeight = function()
{
  try {
      var oIframe = parent.document.getElementById(window.name);
      oIframe.height = 100;
      iframeLoaded(oIframe);
  }
  catch (err)
  {
      try {
       parent.document.getElementById(window.name).height = 1000;
        } catch (err2) { }
  }
}
var sendcount = 0;
var completecount = 0;
// 添加ajax全局事件处理。
reSetIframeHeight();
$(document).ajaxStart(function (a, b, c) {
}).ajaxSend(function (e, xhr, opts) {
    sendcount++;
}).ajaxError(function (e, xhr, opts) {
}).ajaxSuccess(function (e, xhr, opts) {
}).ajaxComplete(function (e, xhr, opts) {
    completecount++; 
        reSetIframeHeight();

}).ajaxStop(function () {
});
</script>
<script type="text/javascript">

	$(function() {
		$("#clo").click(function() {
			$("#backdropId").hide();
		});
	})
	$(function(){
		$(".close").click(function() {
			$("#backdropId").hide();
		});
	})
	$(function(){

		$("#password2").blur(function(){
			var pwd1 = document.getElementById("password1").value;
			var pwd2 = document.getElementById("password2").value;
			if (pwd1 != pwd2) {

				alert("两次输入的密码不一致！");	
			}
		});
	})
	$(function(){
		var child = document.getElementById("iframe").contentWindow;
		$("#modify").click(function(){
			var genderJsp=$("input[name='inlineRadioOptions']:checked").val();
			var nameJsp=$("#name").val();
			var passwordJsp=$("#password1").val();
			var birthJsp=$("#birth").val();
			var idStrJsp=$("#idMember").val();
			$.ajax({
				type:"post",
				url:"${path}/userServlet",
				dataType:"json",
				data:{
					op:"insert",
					name:nameJsp,
					gender:genderJsp,
					birth:birthJsp,
					password:passwordJsp,
					idStr:idStrJsp
				},
				success:function(data){
					$("#backdropId").hide();
					child.location.reload();
					if(data.right=="yes"){
						alert("修改成功！");
						
					}
				},
				error:function(){
					$("#backdropId").hide();
					
					alert("系统错误！");
				}
				
			});
			
		})
	})
</script>


<style type="text/css">
.sp {
	padding-left: 750px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">


			<ul class="nav nav-pills navbar navbar-inverse">

				<li><a href="#">Home</a></li>
				<li><a href="#">Library</a></li>
				<li><a href="#">data</a></li>
				<li class="sp disabled"><a href="#" class="disabled">管理员：${mgr.getName()}</a></li>
				<li><a href="${path}/mgr/mgrLogin.jsp">登出</a></li>

			</ul>

		</div>
		<div class="row">
			<div class="col-md-2">

				<img alt="logo" src="${path}/img/logo.png" width="90%" height="50%">
				<ul class="nav nav-pills nav-stacked link">

					<li role="presentation" class="active navbar navbar-default"
						value="1"><a href="#">基本资料</a></li>
					<li role="presentation" value="2" class="navbar navbar-default"><a
						href="${path}/mgr/userMgr.jsp" target="iframe_a">用户管理</a>
					<li role="presentation" value="3" class="navbar navbar-default"><a
						href="${path}/mgr/subjectMgr.jsp" target="iframe_a">题目管理</a></li>
					<li role="presentation" value="3" class="navbar navbar-default"><a
						href="${path}/mgr/shiJuanMgr.jsp" target="iframe_a">试卷管理</a></li>

					<li role="presentation" class="navbar navbar-default"><a
						href="${path}/mgr/analysed.jsp" target="iframe_a">分析查询</a></li>
				</ul>
			</div>

			<div class="col-md-10">



				<div class="row">
					<div class="embed-responsive embed-responsive-4by3">
						<iframe class="embed-responsive-item" id='iframe' scrolling="no"
							src="${path}/mgr/NewFile.jsp" name="iframe_a" marginheight="0" marginwidth="0" onLoad="iFrameHeight()"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!-- 用户模态框 -->
		<div class="modal" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label for="exampleInputEmail1">姓名</label> <input type="text"
									class="form-control" id="name" placeholder="name"
									required="required">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">密码</label> <input
									type="password" class="form-control" id="password1"
									placeholder="password1" required="required">
							</div>
							<div class="form-group has-error has-feedback">
								<label for="password2">确认密码</label> <input type="password"
									class="form-control" required="required" id="password2"
									name="password2" placeholder="Password">

							</div>
							<div class="form-group has-error has-feedback">
								<label for="birth">出生日期</label> <input type="date" id="birth"
									name="birth" class="form-control" required="required">

							</div>
							<div class="form-group as-warning has-feedback">
								<label class="radio-inline"> <input type="radio"
									name="inlineRadioOptions" id="gender1" value="male"> 男
								</label> <label class="radio-inline"><input type="radio"
									name="inlineRadioOptions" id="gender2" value="female">
									女 </label>
							</div>
							<div class="form-group hidden">
								<label for="exampleInputEmail1">编号</label> <input type="text"
									class="form-control" id="idMember" placeholder="idMember"
									required="required">
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							id="clo">关闭</button>
						<button type="button" class="btn btn-primary" id="modify"
							data-dismiss="modal">修改</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal -->
		<div id='backdropId' style='display: none;'></div>
	</div>
</body>
</html>
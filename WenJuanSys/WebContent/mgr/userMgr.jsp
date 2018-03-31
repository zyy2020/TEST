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
<title>用户管理</title>
<!-- jquery要放到前面 -->
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/css/bootstrap.css">
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript">
function cc(value) {
	//value 就是当前页

	var num = value;
	$("tr:gt(0)").empty();
	$(".bs").empty();
	jiazai(num);

}
	$(function() {
	
		var count=1;
		jiazai(count);
		
		/*----------点击按钮打开模态框------------*/
		$("#chooseIndex").click(function() {

			var fatherBody = $(window.top.document.body);//找到父页面的body对象
			//var dialog = parent.$('#myModal');
			//dialog.load("${path}/mgr/userMgr.jsp", function() {
			//dialog.modal({
			//       backdrop: false
			//});
			//});
			//显示模态框背景遮罩，遮罩位于index.html页面

			$(fatherBody.find("#backdropId")).addClass('modal-backdrop');

			fatherBody.find("#backdropId").show();
			$(fatherBody.find("#myModal")).modal('toggle');

		});

	});
	
</script>
<script type="text/javascript">
function func(id) {
  
	$.ajax({
		type:"post",
		url:"${path}/userServlet",
		dataType:"json",
		data:{
			op:"delete",
			userId:id
		},
		success:function(data){
			alert(data.right);
			window.location.reload();
		},
		error:function(){
			alert("系统错误！");
		}
	});
	//刷新页面
    
}
function modify(value){
	var fatherBody = $(window.top.document.body);//找到父页面的body对象
	alert(value);
	$.ajax({
		type:"post",
		url:"${path}/userServlet",
		dataType:"json",
		async : false,
		data:{
			op:"search",
			id:value
		},
		success:function(data){
		    $(fatherBody.find("#name")).val(data.name);
		    var mon=(data.birth.month+1);
		    var monStr=(data.birth.month+1).toString();
		    if((data.birth.month+1)<9){
		    	monStr="0"+monStr;
		    }
		    var day=data.birth.date;
		    var dayStr=data.birth.date.toString();
		    if(day<9){
		    	dayStr="0"+dayStr;
		    }
		    var text=(data.birth.year+1900)+"-"+monStr+"-"+dayStr;
		    $(fatherBody.find("#birth")).val(text);
		    $(fatherBody.find("#idMember")).val(value);
		    $(fatherBody.find("#password1")).val(data.pwd);
	       $(fatherBody.find("#password2")).val(data.pwd);
	       alert(data.gender);
	       $(fatherBody.find("#gender1")).attr("checked",false);
	       $(fatherBody.find("#gender2")).attr("checked",false);
		    if(data.gender=="male"){
		    	 $(fatherBody.find("#gender1")).attr("checked",true);
		    }else{
		    	 $(fatherBody.find("#gender2")).attr("checked",true);
		    }
			
			
		},
		error:function(){
			alert("系统错误!");
		}
	
	});
	$(fatherBody.find("#backdropId")).addClass('modal-backdrop');
	fatherBody.find("#backdropId").show();
	$(fatherBody.find("#myModal")).modal('toggle');
}
function jiazai(count) {
	
	var num = count;
	$.ajax({
		type : "post",
		url : "${path}/userServlet",
		dataType : "json",
		data : {
			op : "inquire",
			pageNum : num
		},
		success : function(data) {
			var json = eval(data);
			var obj = json[0];
			var s = obj.currenPage;
			var ss = obj.allCount;
			var users = json[1];
			for (var i = 0; i < users.length; i++) {
				$('.con')
						.append(
								"<tr><td>"
										+ users[i].name
										+ " </td><td>"+users[i].gender+"</td><td>"+(1900+users[i].birth.year)+"-"+(users[i].birth.month+1)+"-"+users[i].birth.date+"</td><td><input type='button' class='btn btn-info btn-xs' onclick='func("
										+ users[i].id
										+ ");' value='删除'></td><td><input type='button' class='btn btn-info btn-xs' onclick='modify("+users[i].id+");' value='修改'></td></tr>")
			}

			$('.bs')
					.append(
							"<nav> <ul class='pagination'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <li id='first'><a  href='javascript:void(0);' >首页</a></li><li id='front'><a href='javascript:void(0);'>上一页</a></li><li id='next'><a href='javascript:void(0);'>下一页</a></li> <li id='final'><a href='javascript:void(0);'>尾页</a></li>    </ul></nav>")

			//$('table').append("<tr> <td class='active'>...</td><td class='success'>...<td class='warning'>...</td></tr>")				

			//设置最后一页和第一页
			var fir = $('#first').find('a');

			fir.attr("id", "1");

			var fin = $('#final').find('a');
			fin.attr("id", ss);
			
			if (s == 1 && s != ss) {
				//上一页不能执行

				$('#front').addClass('disabled');

				//说明不是最后一页,有下一页
				($('#next').find('a')).attr("id", s + 1);
			} else if (s != 1 && s != ss) {

				//在中间,有上一页也有下一页
				($('#front').find('a')).attr("id", s - 1);
				($('#next').find('a')).attr("id", s + 1);
			} else if (s == ss && s != 1) {
				//最后一页

				$('#next').addClass('disabled');

				($('#front').find('a')).attr("id", s - 1);
			} else {
				//只有一页

				$('#front').addClass('disabled');
				$('#next').addClass('disabled');
			}
			($('#first').find('a')).attr("onclick", "cc(this.id);");
			if ($('#front').prop("className") != "disabled") {

				($('#front').find('a')).attr("onclick",
						"cc(this.id);");
			}
			if ($('#next').prop("className") != "disabled") {
				($('#next').find('a')).attr("onclick",
						"cc(this.id);");
			}

			($('#final').find('a')).attr("onclick", "cc(this.id);");

		},
		error : function() {
          alert("系统错误");
		}
	});

}

</script>
<style type="text/css">
.mg{
margin-top:50px;
}

</style>
</head>
<body>
	
	<div class="row mg">
		<div class="col-sm-11 col-sm-offset-1">
			<table class="con table table-hover table-bordered">
				<tr class='info'>
					<td>姓名</td>
					<td>性别</td>
					<td>出生日期</td>
					<td>删除操作</td>
					<td>修改操作</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="bs col-sm-offset-10 "></div>
	

	</div>
</body>
</html>
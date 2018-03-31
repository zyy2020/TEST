<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<c:set var="val" value="${ request.getParameter('val')}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问卷填题</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<style type="text/css">
.space {
	margin-top: 20px;
	margin-bottom: 20px;
}

.b {
	border-bottom: 1px solid #555;
	border-top: 0px;
	border-left: 0px;
	border-right: 0px;
}
</style>
<script type="text/javascript">
var length1=0;
var length2=0;
var length3=0;
var shijuanId=0;


$(function() {
   
    //显示该试卷的内容
  
    show("1");
   
})

function show(value){
	var val=<%=  request.getParameter("val") %>
	var i=0;
	var j=0;
	$.ajax({
		type:"post",
		url:"${path}/shiJuanServlet",
		dataType:"json",
		data:{
			op:"show",
			sjId:val
		},
		success:function(data){
			var json = eval(data);
			var sjxzs=json.SJXZs;
			var sjtks=json.SJTKs;
			var sjasks=json.Asks;
			var text=json.title;
			shijuanId=json.shiJuanId;
			$('.s_title').append("<font size='6'>"+text+"</font>");
			var len1=sjxzs.length;
			if(len1>0){
				$('.ddl').append("<dt>一、选择题</dt><dd></dd>");
				for(i=0;i<len1;i++){
					var j=1;
					$('.ddl').append("<dt id='"+(sjxzs[i].id)+"'>"+(i+1)+"、"+sjxzs[i].title+"</dt><div class='radio'><dd>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<lable> <input type='radio' name='optionsRadios"+(i+1)+"' value='A'>A、"+sjxzs[i].key1+"</lable></dd><dd>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<lable> <input type='radio' name='optionsRadios"+(i+1)+"' id='optionsRadios2"+(j++)+"' value='B'>B、"+sjxzs[i].key2+"</lable></dd> <dd>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<lable> <input type='radio' name='optionsRadios"+(i+1)+"' id='optionsRadios2"+(j++)+"' value='C'>C、"+sjxzs[i].key3+"</lable></dd><dd>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<lable> <input type='radio' name='optionsRadios"+(i+1)+"' id='optionsRadios2"+(j++)+"' value='D'>D、"+sjxzs[i].key4+"</lable></dd></div>");
				}
				length1=i;
			}
			var len2=sjtks.length;
			if(len2>0){
				$('.ddl').append("<dt>二、填空题</dt><dd></dd>");
				for(i=0;i<len2;i++){
					
					$('.ddl').append("<dt>"+(i+1)+"、"+sjtks[i].question+"</dt><dd>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;答案：<input type='text' class='b' name='"+sjtks[i].id+"' id='text"+(i+1)+"'></dd>");
				}
			}
			length2=len2;
			var len3=sjasks.length;
			if(len3>0){
				$('.ddl').append("<dt>三、问答题</dt><dd></dd>");
				for(i=0;i<len3;i++){
			
					$('.ddl').append("<dt>"+(i+1)+"、"+sjasks[i].question+"</dt><dd><textarea name='"+sjasks[i].id+"' id='textarea"+(i+1)+"' row='60' cols='100'></textarea></dd>");
				}
			}
			length3=len3;
		},
		error:function(){
			alert("error");
		}
		
	});
	
}
function sub(){
	/*
	  如果所有的问卷都有题目时，要考虑空白卷时
	*/
	var answers1=new Array();
	var answers2=new Array();
	var answers3=new Array();
	//选择题
	for(var i=1;i<=length1;i++){
		answers1.push(($(".ddl dt").eq(i).attr("id")));
		answers1.push($("input:radio[name='optionsRadios"+i+"']:checked").val());
		
	 }
	//填空题
	for(var j=1;j<=length2;j++){
		answers2.push(($('#text'+j).attr("name")));
		answers2.push($("#text"+j).val());
	}
	//问答题
	for(var k=1;k<=length3;k++){
		answers3.push($("#textarea"+k).attr("name"));
		answers3.push($("#textarea"+k).val());
	}
	$.ajax({
		type:"post",
		url:"${path}/dTKServlet",
		dataType:"json",
		traditional:true,//jquery会深度序列化参数对象，以适应如PHP和Ruby on Rails框架,我们可以通过设置traditional 为true阻止深度序列化
		data:{
			"op":"insert",
			"xuanZeAnsers":answers1,
			"tiankongAnswers":answers2,
			"askAnswers":answers3,
			"shiJuanId":shijuanId
		},
		success:function(json){
			if(json.data=="yes"){
				alert("提交成功！");
				 location.href="user.jsp";
			}else{
				alert("提交错误！");
			}
		},
		error:function(){
			alert("系统错误！");
		}
	});
}

</script>
</head>
<body>
	<div class="container space">
		<div class="row">
			<div class="s_title col-md-9 col-md-offset-3">
				
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-1 space">
				<span>您好，我们是XXX，我们正在进行一项关于大学生消费观的调查，想邀请您用几分钟时间帮忙填答这份问卷。本问卷实行匿名制，所有数据只用于统计分析，
					请您放心填写。题目选项无对错之分，请您按自己的实际情况填写。谢谢您的帮助。</span>
			</div>
			<div class="col-md-3 space">
			<a href="${path}/user/user.jsp" class="btn btn-info form-control">返回</a>
			
			</div>
		</div>
		<div class="row">
			<hr>
		</div>
		<div class="row">

			<dl class="ddl col-md-offset-1"></dl>
		</div>
		<div class="row"></div>
		<div class="row">
			<div class="col-md-3 col-md-offset-3">
				<input type="submit" class="btn btn-primary form-control"
					onclick='sub();' value="提交">
			</div>
		</div>
	</div>
</body>
</html>
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
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>删除问卷主页</title>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function() {
    var count=1;
    jiazai(count);
   var c= $('table tr:lt(2) td').find('a');
    //显示该试卷的内容
})
function jiazai(count){
	var num=count;
	$.ajax({
    	type:"post",
    	url:"${path}/shiJuanServlet",
    	dataType:"json",
    	data:{
    		op:"all",
    		pageNum : num
    	},
    	async : false,
    	success:function(data){
    		var json = eval(data);
    		var obj = json[0];
			var s = obj.currenPage;
			var ss = obj.allCount;
			
			var shijuans = json[1];
    		for(var i=0;i<shijuans.length;i++){
    			$('.sj').append("<tr><td><a value='"+shijuans[i].id+"'  href='#' onclick='res("+shijuans[i].id+");return false;'>"+(i+1)+"、"+shijuans[i].title+"</a></td></tr>")
    			
    		}
    		$('.limit')
			.append(
					"<nav> <ul class='pagination'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <li id='first'><a  href='javascript:void(0);' >首页</a></li><li id='front'><a href='javascript:void(0);'>上一页</a></li><li id='next'><a href='javascript:void(0);'>下一页</a></li> <li id='final'><a href='javascript:void(0);'>尾页</a></li>    </ul></nav>")
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
    	error:function(){
    		
    		alert("error");
    	}
    	
    	
    });
	
}
function cc(value) {
	//value 就是当前页

	var num = value;
	$("tr:gt(0)").empty();
	$(".limit").empty();
	jiazai(num);

}
function res(valueId){
	$.ajax({
		type:"post",
		url:"${path}/shiJuanServlet",
		dataType:"json",
		data:{
			id:valueId,
			op:"modify"
		},
		success:function(data){
			
		},
		error:function(){
			alert("系统错误！")
		}
	});
}
</script>
<style type="text/css">
.back {
	
}
</style>
</head>
<body>
	<div class="row">
		<div class=" back col-sm-6">
			<table class="sj  table table-hover table-striped">
				<!-- 必须有第一行，否则后面不管用 -->
				<tr>
					<td>全部问卷</td>
				</tr>
			</table>
			<div class="row">
				<div class="limit"></div>
			</div>
		</div>
		<div class="col-sm-6"></div>

	</div>
</body>
</html>
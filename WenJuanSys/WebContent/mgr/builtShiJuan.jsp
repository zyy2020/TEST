<%@page import="net.sf.json.JSONArray"%>
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
<title>创建问卷</title>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>

<style type="text/css">
body {
	background-color: #eee;
}

.de {
	background-color: #eee;
}

.dd2 {
	margin-top: 30px;
	padding-top: 30px;
	background-color: #FFF;
	margin-bottom: 30px;
	padding-bottom: 30px;
}
</style>
<script type="text/javascript">
	var checkbox1 = new Array();
	var checkbox2 = new Array();
	var checkbox3 = new Array();
	$(function() {
		var count1 = 1;
		jiazai(count1);
		jiazai1(count1);
		jiazai3(count1);
		$('.gs').hide();
		$('.gp').hide();
	});
	function jiazai(count) {
		var hop = "inquire";
		var num = count;
		$
				.ajax({
					type : 'post',
					url : '${path}/xuanZeServlet',
					data : {
						op : hop,
						pageNum : num
					},
					async : false,
					datatype : 'json',
					success : function(data) {
						var json = eval(data);
						var obj = json[0];
						var s = obj.currenPage;
						var ss = obj.allCount;
						var xuanzes = json[1];

						for (var i = 0; i < xuanzes.length; i++) {
							$('.con').append(
									"<tr><td>" + (i + 1) + "、"
											+ xuanzes[i].title
											+ " <input type='checkbox' value='"
											+ xuanzes[i].id + "' </td></tr>")
							$(".con").append(
									"<tr><td>A、" + xuanzes[i].key1
											+ "&nbsp;&nbsp;B、"
											+ xuanzes[i].key2
											+ "&nbsp;&nbsp;C、"
											+ xuanzes[i].key3
											+ "&nbsp;&nbsp;D、"
											+ xuanzes[i].key4 + "</td></tr>")
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
						alert("系统错误!");
					}
				});

	}
	function xuan() {
		//换页时需要保存所换的id
		//获取当前的被选中的checked

		$('.gg input:checked').each(function() {
			//如果已经没有了
			if (checkbox1.indexOf($(this).val) == -1) {
				checkbox1.push($(this).val());

			}
		});
		var notChecked = $(".gg input:checkbox").not("input:checked");
		notChecked.each(function() {

			var ind = checkbox1.indexOf($(this).val());
			if (ind != -1) {

				checkbox1.splice(ind, 1);
			}
		});
	}
	function tiankong() {
		//换页时需要保存所换的id
		//获取当前的被选中的checked

		$('.gs input:checked').each(function() {
			//如果已经没有了

			if (checkbox2.indexOf($(this).val) == -1) {
				checkbox2.push($(this).val());

			}
		});
		var notChecked = $(".gs input:checkbox").not("input:checked");
		notChecked.each(function() {

			var ind = checkbox2.indexOf($(this).val());
			if (ind != -1) {

				checkbox2.splice(ind, 1);
			}
		});
	}
	function ask() {
		//换页时需要保存所换的id
		//获取当前的被选中的checked

		$('.gp input:checked').each(function() {
			//如果已经没有了

			if (checkbox3.indexOf($(this).val) == -1) {
				checkbox3.push($(this).val());

			}
		});
		var notChecked = $(".gp input:checkbox").not("input:checked");
		notChecked.each(function() {

			var ind = checkbox3.indexOf($(this).val());
			if (ind != -1) {

				checkbox3.splice(ind, 1);
			}
		});
	}

	function cc(value) {
		//value 就是当前页

		var num = value;
		//获取已经选过的
		xuan();

		$(".gg tr:gt(0)").empty();
		$(".bs").empty();
		jiazai(num);
		//加载完后要重新设置已经选过的
		var notChecked = $(".gg input:checkbox").not("input:checked");

		notChecked.each(function() {
			var ind = checkbox1.indexOf($(this).val());
			if (ind != -1) {
				$(this).attr("checked", 'true');
			}
		});

	}

	function getPaging(value) {
		alert($('input:checked').length);
		if (value == "xuanze") {
			$('.gg').show();
			$('.gs').hide();
			$('.gp').hide();
		} else if (value == "tiankong") {
			$('.gs').show();
			$('.gg').hide();
			$('.gp').hide();
		} else {
			$('.gp').show();
			$('.gg').hide();
			$('.gs').hide();

		}

	}
	function jiazai1(count) {
		var hop = "inquire";
		var num = count;

		$
				.ajax({
					type : "post",
					url : "${path}/tianKongServlet",
					data : {
						op : hop,
						pageNum : num
					},
					async : false,
					dataType : 'json',
					success : function(data) {
						var json = eval(data);
						var obj = json[0];
						var s = obj.currPage;
						var ss = obj.allCount;
						var tiankongs = json[1];

						for (var i = 0; i < tiankongs.length; i++) {
							$('.cs')
									.append(
											"<tr class='danger'><td>"
													+ (i + 1)
													+ "、"
													+ tiankongs[i].question
													+ "&nbsp;&nbsp;&nbsp;("
													+ tiankongs[i].score
													+ "分)&nbsp;<input type='checkbox' value='"
													+ tiankongs[i].id
													+ "' </td></tr>")
							$('.cs').append(
									"<tr class='warning'><td>答案："
											+ tiankongs[i].answer
											+ "</td></tr>")
						}
						$('.vs')
								.append(
										"<nav> <ul class='pagination'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <li id='first2'><a  href='javascript:void(0);' >首页</a></li><li id='front2'><a href='javascript:void(0);'>上一页</a></li><li id='next2'><a href='javascript:void(0);'>下一页</a></li> <li id='final2'><a href='javascript:void(0);'>尾页</a></li>    </ul></nav>")

						//$('table').append("<tr> <td class='active'>...</td><td class='success'>...<td class='warning'>...</td></tr>")				
						//设置最后一页和第一页
						var fir = $('#first2').find('a');

						fir.attr("id", "1");

						var fin = $('#final2').find('a');
						fin.attr("id", ss);
						if (s == 1 && s != ss) {
							//上一页不能执行

							$('#front2').addClass('disabled');

							//说明不是最后一页,有下一页
							($('#next2').find('a')).attr("id", s + 1);
						} else if (s != 1 && s != ss) {

							//在中间,有上一页也有下一页
							($('#front2').find('a')).attr("id", s - 1);
							($('#next2').find('a')).attr("id", s + 1);
						} else if (s == ss && s != 1) {
							//最后一页

							$('#next2').addClass('disabled');

							($('#front2').find('a')).attr("id", s - 1);
						} else {
							//只有一页

							$('#front2').addClass('disabled');
							$('#next2').addClass('disabled');
						}
						($('#first2').find('a'))
								.attr("onclick", "bb(this.id);");
						if ($('#front2').prop("className") != "disabled") {

							($('#front2').find('a')).attr("onclick",
									"bb(this.id);");
						}
						if ($('#next2').prop("className") != "disabled") {
							($('#next2').find('a')).attr("onclick",
									"bb(this.id);");
						}

						($('#final2').find('a'))
								.attr("onclick", "bb(this.id);");
					},
					error : function() {
						alert("error");
					}
				});
	}
	function jiazai3(count) {
		var hop = "inquire";
		var num = count;

		$
				.ajax({
					type : "post",
					url : "${path}/askServlet",
					data : {
						op : hop,
						pageNum : num
					},
					async : false,
					dataType : 'json',
					success : function(data) {
						var json = eval(data);
						var obj = json[0];
						var s = obj.currPage;
						var ss = obj.allCount;
						var asks = json[1];
						var cla = "success";
						for (var i = 0; i < asks.length; i++) {
							cla = "success";
							if ((i + 1) % 2 == 0) {
								cla = "info";
							}
							$('.as').append(
									"<tr class='"+cla+"'><td>" + (i + 1) + "、"
											+ asks[i].question
											+ " <input type='checkbox' value='"
											+ asks[i].id + "' </td></tr>")
						}
						$('.ks')
								.append(
										"<nav> <ul class='pagination'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <li id='first3'><a  href='javascript:void(0);' >首页</a></li><li id='front3'><a href='javascript:void(0);'>上一页</a></li><li id='next3'><a href='javascript:void(0);'>下一页</a></li> <li id='final3'><a href='javascript:void(0);'>尾页</a></li>    </ul></nav>")

						//$('table').append("<tr> <td class='active'>...</td><td class='success'>...<td class='warning'>...</td></tr>")				

						//设置最后一页和第一页
						var fir = $('#first3').find('a');

						fir.attr("id", "1");

						var fin = $('#final3').find('a');
						fin.attr("id", ss);
						if (s == 1 && s != ss) {
							//上一页不能执行

							$('#front3').addClass('disabled');

							//说明不是最后一页,有下一页
							($('#next3').find('a')).attr("id", s + 1);
						} else if (s != 1 && s != ss) {

							//在中间,有上一页也有下一页
							($('#front3').find('a')).attr("id", s - 1);
							($('#next3').find('a')).attr("id", s + 1);
						} else if (s == ss && s != 1) {
							//最后一页

							$('#next3').addClass('disabled');

							($('#front3').find('a')).attr("id", s - 1);
						} else {
							//只有一页

							$('#front3').addClass('disabled');
							$('#next3').addClass('disabled');
						}
						($('#first3').find('a'))
								.attr("onclick", "aa(this.id);");
						if ($('#front3').prop("className") != "disabled") {

							($('#front3').find('a')).attr("onclick",
									"aa(this.id);");
						}
						if ($('#next3').prop("className") != "disabled") {
							($('#next3').find('a')).attr("onclick",
									"aa(this.id);");
						}

						($('#final3').find('a'))
								.attr("onclick", "aa(this.id);");

					},
					error : function() {
						alert("error");
					}
				});
	}
	function aa(value) {
		//value 就是当前页

		var num = value;
		ask();
		$(".gp tr:gt(0)").empty();
		$(".ks").empty();
		jiazai3(num);
		var notChecked = $(".gp input:checkbox").not("input:checked");

		notChecked.each(function() {

			var ind = checkbox3.indexOf($(this).val());
			if (ind != -1) {
				$(this).attr("checked", 'true');
			}
		});
	}
	function bb(value) {
		//value 就是当前页

		var num = value;
		tiankong();

		$(".gs tr:gt(0)").empty();
		$(".vs").empty();
		jiazai1(num);
		var notChecked = $(".gs input:checkbox").not("input:checked");

		notChecked.each(function() {

			var ind = checkbox2.indexOf($(this).val());
			if (ind != -1) {
				$(this).attr("checked", 'true');
			}
		});
	}
	function response() {

		//获取选择题
		if ($('#shijuan').val() == "") {
			alert("试卷标题不能为空！")
		} else {
			var sj = $('#shijuan').val();
			xuan();
			//到接收填空题
			tiankong();
			//到问答题
			ask();
			alert(checkbox1);
			alert(checkbox2);
			alert(checkbox3);
			$.ajax({
				type : "post",
				url : "${path}/shiJuanServlet",
				dataType : "json",
				traditional : true,
				data : {
					op : "initial",
					shijuan : sj,
					xuanzesId : checkbox1,
					tiankongsId : checkbox2,
					asksId : checkbox3
				},
				success : function(json) {
					if (json.right == "yes") {
						alert("试卷已生成！")
						window.location.reload();
					}
				},
				error : function() {
					alert("失败！");
					window.location.reload();
				}

			});

		}

	}
</script>
</head>
<body>
	<%
		JSONArray jsons = new JSONArray();
	%>
	<div class="row">

		<div class="dd1 col-sm-1"></div>
		<div class="dd2 col-sm-10">

			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="col-sm-1"></div>
				<div class="col-sm-10">
					<div class="row">
						<input type="text" class="form-control"
							style="border: none; text-align: center; font-size: 24px"
							value="" placeholder="问卷标题" name="shijuan" id="shijuan">
					</div>

					<div class="row">
						<hr>

					</div>

					<div class="row">

						<textarea class="form-control" rows="1">为了给您提供更好的服务，希望您能抽出几分钟时间，期待您的参与！</textarea>
					</div>
					<hr>
					<!-- 日期和和score -->
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-2">
							<h4>日期</h4>
						</div>
						<div class="col-sm-9">

							<input type="date" class="form-control" disabled
								style="text-align: center; font-size: 24px" required="required">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-2">
							<h4>score</h4>
						</div>
						<div class="col-sm-9">

							<input type="text" class="form-control" disabled
								style="text-align: center; font-size: 24px" value="0">
						</div>
					</div>

					<!-- 注释 -->
					<hr>
					<div class="row">
						<div class="col-sm-2">
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="true">
									默认选择题 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
									<li onclick="getPaging('xuanze');"><a href="#">选择题</a></li>
									<li onclick="getPaging('tiankong');"><a href="#">填空题</a></li>
									<li onclick="getPaging('wenda');"><a href="#">问答题</a></li>

								</ul>
							</div>
						</div>
						<div class="col-sm-10">
							<!-- 选择题 -->
							<div class="gg row">
								<div class="col-sm-11 col-sm-offset-1">
									<table class="con table table-hover table-striped">
										<!-- 必须有第一行，否则后面不管用 -->
										<tr class='active'>
											<td>选择题序列问题</td>
										</tr>
									</table>
									<div class="row">
										<div class="bs"></div>

									</div>
								</div>

							</div>
							<!-- 填空题 -->
							<div class="gs row">
								<div class="col-sm-11 col-sm-offset-1">
									<table class="cs table table-hover table-striped">
										<!-- 必须有第一行，否则后面不管用 -->
										<tr class='active'>
											<td>填空题序列问题</td>
										</tr>
									</table>
									<div class="row">
										<div class="vs"></div>

									</div>
								</div>

							</div>
							<!-- 问答题 -->
							<div class="gp row">
								<div class="col-sm-11 col-sm-offset-1">
									<table class="as table table-hover table-striped">
										<!-- 必须有第一行，否则后面不管用 -->
										<tr class='active'>
											<td>问答题序列问题</td>
										</tr>
									</table>
									<div class="row">
										<div class="ks"></div>

									</div>
								</div>

							</div>
						</div>
						</br>

					</div>

				</div>

				<div class="col-sm-1">
					<input type="button" class=" btn btn-lg btn-info" value="提交"
						onclick="response();">
				</div>
			</div>

			<div class="col-sm-1"></div>
		</div>
		<div class="col-sm-1"></div>

	</div>


</body>
</html>
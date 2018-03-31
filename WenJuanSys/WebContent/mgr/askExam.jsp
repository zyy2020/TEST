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
<title>问答题库</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var count1 = 1;
		jiazai(count1);
	});
	function cc(value) {
		//value 就是当前页

		var num = value;
		$("tr:gt(0)").empty();
		$(".bs").empty();
		jiazai(num);

	}
	function jiazai(count) {
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
							$('.cs')
									.append(
											"<tr class='"+cla+"'><td>"
													+ (i + 1)
													+ "、"
													+ asks[i].question
													+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id("
													+ asks[i].id
													+ ")</td><td> <input type='button' class='btn btn-danger btn-xs' onclick='func("
													+ asks[i].id
													+ ")' value='删除'></td></tr>")
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
						alert("error");
					}
				});
	}
	function func(id) {
		$.post("${path}/askServlet", {
			op : "delete",
			askId : id
		}, function(data) {
			if (data != "ok") {
				alert("error");
			}
		});
		//刷新页面
		window.location.reload();
	}
	function search() {

		var text = $('#idText').val();
		if (text == "") {
			alert("id不能为空！")
		} else {
			$.ajax({
				type : "post",
				url : "${path}/askServlet",
				data : {
					op : "search",
					id : text
				},
				dataType : 'json',
				success : function(res) {

					$('#question').val(res.question);

				},
				error : function() {
					alert("error");
				}
			});
		}

	}
	function judge() {
		return ($('#question').val() == "");

	}
	function f(name) {
		var idText = $('#idText').val();

		if (judge()) {
			alert("内容不能为空！");

		} else {

			document.update.action = "${path}/askServlet?op=" + name
					+ "&idText=" + idText;
			document.update.submit();
		}
	}
</script>
</head>
<body>
	<div class="col-sm-5">
		<table class="cs table table-hover">
			<tr class='info'>
				<td>填空题序列问题</td>
			</tr>
		</table>
		<div class="row">
			<div class="bs"></div>

		</div>
	</div>
	<div class="col-sm-1"></div>
	<div class="col-sm-6">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="input-group">
					<span class="input-group-btn">
						<button class="btn btn-info" type="button" onclick="search();">请输入题目id</button>
					</span> <input type="text" class="form-control"
						placeholder="Search for..." id="idText" name="idText">
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
			<div class="col-sm-2"></div>
		</div>
		<div class="row">
			<form action="" name="update" method="post">
				<div class="form-group">
					<label for="question">question</label> <input type="text"
						class="form-control" placeholder="question" name="question"
						id="question">
				</div>

				<div class="form-group">
					<input type="button" class="btn btn-warning" value="插入"
						name="insert" onclick="f(this.name);"> <input
						type="button" class="btn btn-danger" value="修改" name="modify"
						onclick="f(this.name);">
				</div>
			</form>

		</div>
	</div>
</body>
</html>
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
<title>选择题库</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript">
	//主函数加载
	$(function() {
		var count1 = 1;
		jiazai(count1);
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
					datatype : 'json',
					success : function(data) {
						var json = eval(data);
						var obj = json[0];
						var s = obj.currenPage;
						var ss = obj.allCount;
						var xuanzes = json[1];
						for (var i = 0; i < xuanzes.length; i++) {
							$('.con')
									.append(
											"<tr><td>"
													+ (i + 1)
													+ "、"
													+ xuanzes[i].title
													+ "&nbsp;&nbsp;id("
													+ xuanzes[i].id
													+ ") </td><td><input type='button' class='btn btn-info btn-xs' onclick='func("
													+ xuanzes[i].id
													+ ")' value='删除'></td></tr>")
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
	function func(id) {
		
		$.post("${path}/xuanZeServlet", {
			op : "delete",
			xuanZeId : id
		}, function(data) {
			if (data != "ok") {
				alert("error");
			}
		});
		//刷新页面
		window.location.reload();
	}
	function cc(value) {
		//value 就是当前页

		var num = value;
		$("tr:gt(0)").empty();
		$(".bs").empty();
		jiazai(num);

	}
	function f(name) {
		var idText = $('#idText').val();
		if (judge()) {
			alert("内容不能为空！");
		} else {
			document.update.action = "${path}/xuanZeServlet?op=" + name
					+ "&idText=" + idText;
			document.update.submit();
		}

		//判断op的值

	}
	function search() {

		var text = $('#idText').val();
		if (text == "") {
			alert("id不能为空！")
		} else {
			$.ajax({
				type : "post",
				url : "${path}/xuanZeServlet",
				data : {
					op : "search",
					id : text
				},
				dataType : 'json',
				success : function(res) {

					$('#title').val(res.title);
					$('#key1').val(res.key1);
					$('#weight1').val(res.weight1);
					$('#key2').val(res.key2);
					$('#weight2').val(res.weight2);
					$('#key3').val(res.key3);
					$('#weight3').val(res.weight3);
					$('#key4').val(res.key4);
					$('#weight4').val(res.weight4);
				},
				error : function() {
					alert("error");
				}
			});

		}

	}
	//判断不能为空
	function judge() {
		return ($('#title').val() == "" || $('#key1').val() == ""
				|| $('weight1').val() == "" || $('#key2').val() == ""
				|| $('weight2').val() == "" || $('#key3').val() == ""
				|| $('weight3').val() == "" || $('#key4').val() == "" || $(
				'weight4').val() == "");

	}
</script>
<style type="text/css">
.bor {
	border-right: 1px solid #777;
}
</style>
</head>
<body>
	<div class="row">
		<table class="table">
			<tr class="danger">
				<td>&nbsp;&nbsp;&nbsp;&nbsp;警告！如果你需要修改题目必须填写题目id ，如果插入题目，id不能填！</td>
			</tr>
		</table>
	</div>
	<div class="row">
		<div class="col-md-5 col-sm-5  bor">
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
		<div class="col-md-1 col-sm-1"></div>
		<div class="col-md-6 col-sm-6">
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
						<label for="title">title</label> <input type="text"
							class="form-control" placeholder="title" name="title" id="title">
					</div>

					<div class="form-group">
						<div class="row">
							&nbsp;&nbsp;&nbsp;<label for="title">答案一</label>
						</div>
						<div class="row">
							<div class="col-md-6 col-sm-6">
								<input type="text" class="form-control" placeholder="key1"
									name="key1" id="key1">
							</div>
							<div class="col-md-6 col-sm-6">
								<input type="text" class="form-control" placeholder="weight1"
									name="weight1" id="weight1">

							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							&nbsp;&nbsp;&nbsp;<label for="title">答案二</label>
						</div>
						<div class="row">
							<div class="col-sm-6 col-md-6">

								<input type="text" id="key2" class="form-control"
									placeholder="key2" name="key2">
							</div>
							<div class="col-sm-6 col-md-6">

								<input type="text" id="weight2" class="form-control"
									placeholder="weight2" name="weight2">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							&nbsp;&nbsp;&nbsp;<label for="title">答案三</label>
						</div>
						<div class="row">
							<div class="col-sm-6 col-md-6">

								<input type="text" id="key3" class="form-control"
									placeholder="key3" name="key3">
							</div>
							<div class="col-sm-6 col-md-6">

								<input type="text" id="weight3" class="form-control"
									placeholder="weight3" name="weight3">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="row">
							&nbsp;&nbsp;&nbsp;<label for="title">答案四</label>
						</div>
						<div class="row">
							<div class="col-sm-6 col-md-6">

								<input type="text" id="key4" class="form-control"
									placeholder="key4" name="key4">
							</div>
							<div class="col-sm-6 col-md-6">

								<input type="text" id="weight4" class="form-control"
									placeholder="weight4" name="weight4">
							</div>
						</div>
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

	</div>


</body>
</html>
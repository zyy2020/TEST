<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问卷题目</title>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript">
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
							$('.con').append(
									"<tr><td>" + (i + 1) + "、"
											+ xuanzes[i].title
											+ " <input type='checkbox' value='"
											+ xuanzes[i].id + "'</td></tr>")
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

	function cc(value) {
		//value 就是当前页

		var num = value;
		$("tr:gt(0)").empty();
		$(".bs").empty();
		jiazai(num);

	}
</script>
</head>
<body>
	<div class="row">
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
</body>
</html>
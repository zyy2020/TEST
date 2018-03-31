<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script type="text/javascript">     
 function countDown(secs,surl){     
  //alert(surl);     
   var jumpTo = document.getElementById('jumpTo');
   jumpTo.innerHTML=secs;  
   if(--secs>0){     
      setTimeout("countDown("+secs+",'"+surl+"')",1000);     
      }     
  else{       
      location.href=surl;     
      }     
  }     
 </script> 
</head>
<body>
<div class="container">
   <div class="row">
   <div class="col-md-6 col-md-offset-4">
   <h1>注册成功！</h1>
   <span id="jumpTo">5</span>秒后自动跳转到登录页面
   </div>
   </div>
</div>
<script type="text/javascript">countDown(5,'index.jsp');</script>  

</body>
</html>
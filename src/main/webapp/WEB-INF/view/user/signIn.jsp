<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	
	$().ready(function() {
		
		$("#loginForm").find("input[type=submit]").click(function() {
			
			$("#loginForm").attr({
				"action" : "<c:url value="/club/signin" />",
				"method" : "post"
			});
			
			$("#loginForm").submit();
			
		});
		
	});

</script>

<title>로그인 화면</title>
</head>
<body>
	<form id = "loginForm">
		<input type="text" name="userId" placeholder="아이디를 입력해..." />
		<input type="password" name="userPassword" placeholder="암호를 입력해..." />
		<input type="submit" value="로그인" />
	</form>
	<div id ="signUp">
		<a href ="<c:url value="/club/signup"/>"> 회원 가입 </a>
	</div>
</body>
</html>
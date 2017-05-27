<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	
	$().ready(function() {
		
		$("#signUpForm").find("input[type=button]").click(function() {
			
			$("#signUpForm").attr({
				"action" : "<c:url value="/signup" />",
				"method" : "post"
			});
			
			$("#signUpForm").submit();
			
		});
		
/* 		
		$("#userPassword").keyup(function() {
			
			$.post("<c:url value="/signup/passwordcheck/"/>", {
				
				"userPassword" : $("#userPassword").val()

			}, function(response) {
				if(response.SUCCESS == "YES") {

				}
				
				else{
					alert("암호를 다시 체크해주세요...");
				}
			});
			
		});
		 */
		
	});

</script>
<title>회원가입</title>
</head>
<body>
	<form id = "signUpForm">
		<input type="text" name="user_id" placeholder="아이디를 입력하세요??" /> <br/>
		<input type="password" id="user_password" name="userPassword" placeholder="비밀번호를 입력하세요??" />  <br/>
		<input type="text" name="user_name" placeholder="이름을 입력하세요??" />  <br/>
		<input type="button" value="회원 가입" />
	</form>
</body>
</html>
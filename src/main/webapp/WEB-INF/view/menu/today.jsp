<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>

$().ready(function() {
	
	$("#likeBreakfast").click(function() {
		
		$.post("<c:url value="/menu/insertLike/"/>", {
			
			"user_no" : $("#user_no").val() ,
			"menu_no" : $("#first").val() ,
			"like" : true
	
		}, function(response) {
			if(response.SUCCESS == "YES") {
				alert("좋아요를 클릭하셨습니다.");
			}
			
			else{
				alert("클릭을 실패하였습니다.");
			}
		});
		
	});
	
			
	$("#dislikeBreakfast").click(function() {
				
			$.post("<c:url value="/menu/insertLike/"/>", {
					
				"user_no" : $("#user_no").val() ,
				"menu_no" : $("#first").val() ,
				"like" : false
			
			}, function(response) {
					if(response.SUCCESS == "YES") {
						alert("싫어요를 클릭하셨습니다.");
				}
					
					else{
						alert("클릭을 실패하였습니다.");
					}
				});
				
			});
			
			
	$("#likeLunch").click(function() {
						
		$.post("<c:url value="/menu/insertLike/"/>", {
							
		"user_no" : $("#user_no").val() ,
		"menu_no" : $("#second").val() ,
		"like" : true
					
						}, function(response) {
							if(response.SUCCESS == "YES") {
								alert("좋아요를 클릭하셨습니다.");
							}
							
							else{
								alert("클릭을 실패하였습니다.");
							}
						});
						
					});
					
					
					
							$("#dislikeLunch").click(function() {
								
								$.post("<c:url value="/menu/insertLike/"/>", {
									
									"user_no" : $("#user_no").val() ,
									"menu_no" : $("#second").val() ,
									"like" : false
							
								}, function(response) {
									if(response.SUCCESS == "YES") {
										alert("싫어요를 클릭하셨습니다.");
									}
									
									else{
										alert("클릭을 실패하였습니다.");
									}
								});
								
							});
							
							
							
									$("#likeDinner").click(function() {
										
										$.post("<c:url value="/menu/insertLike/"/>", {
											
											"user_no" : $("#user_no").val() ,
											"menu_no" : $("#third").val() ,
											"like" : true
									
										}, function(response) {
											if(response.SUCCESS == "YES") {
									
											}
											
											else{
												alert("클릭을 실패하였습니다.");
											}
										});
										
									});
									
									
									
									
											$("#dislikeDinner").click(function() {
												
												$.post("<c:url value="/menu/insertLike/"/>", {
													
													"user_no" : $("#user_no").val() ,
													"menu_no" : $("#third").val() ,
													"like" : false
											
												}, function(response) {
													if(response.SUCCESS == "YES") {
														alert("싫어요를 클릭하셨습니다.");
													}
													
													else{
														alert("클릭을 실패하였습니다.");
													}
												});
												
											});
											
											
										
});
			
											

</script>

<title>Insert title here</title>
</head>
<body>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="pull-left right">
			<h1>오늘의 식단</h1>
			<br /> <br />

			<table class="table">

				<tr>
					<th colspan="2">조식</th>
					<th colspan="2">중식</th>
					<th colspan="2">저녁</th>

				</tr>

				<tr>
					<td colspan="2"><c:forEach items="${todayBreakFast}"
							var="menuList">
								${menuList} 
					</c:forEach> <c:if test="empty ${todayBreakFast}">
							<td>해당하는 식단이 없습니다.</td>
						</c:if></td>

					<td colspan="2"><c:forEach items="${todayLunch}"
							var="menuList">
							${menuList} 
						</c:forEach> <c:if test="empty ${todayLunch}">
							<td>해당하는 식단이 없습니다.</td>
						</c:if></td>

					<td colspan="2"><c:forEach items="${todayDinner}"
							var="menuList">
								${menuList} 
						</c:forEach> <c:if test="empty ${todayDinner}">
							<td>해당하는 식단이 없습니다.</td>
						</c:if></td>

				</tr>

				<tr>

					<td><button type="button" class="btn-primary"
							id="likeBreakfast" value="${first}">좋아요</button></td>
					<td><button type="button" class="btn-danger"
							id="dislikeBreakfast" value="${first}">싫어요</button></td>
					<td><button type="button" class="btn-primary" id="likeLunch"
							value="${second}">좋아요</button></td>
					<td><button type="button" class="btn-danger" id="dislikeLunch"
							value="${second}">싫어요</button></td>
					<td><button type="button" class="btn-primary" id="likeDinner"
							value="${third}">좋아요</button></td>
					<td><button type="button" class="btn-danger"
							id="dislikeDinner" value="${third}">싫어요</button></td>
				</tr>

			</table>
		</div>

		<input type="hidden" id="user_no"
			value="${sessionScope._USER_.user_no}" />

	</div>
</body>
</html>
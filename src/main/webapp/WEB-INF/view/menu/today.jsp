<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>

		$("#likeBreakfast").click(function() {
			
			$.post("<c:url value="/menu/insertLike/"/>", {
				
				"user_no" : $("#user_").val() ,
				"menu_no" : $("#userPassword").val() ,
				"like" : true
		
			}, function(response) {
				if(response.SUCCESS == "YES") {
		
				}
				
				else{
				}
			});
			
		});

</script>

<title>Insert title here</title>
</head>
<body>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="pull-left right">
		<h1> 오늘의 식단 </h1>
		<br/><br/>
		
		<table class="table">
		 
			<tr> 
				<th colspan="2"> 조식 </th>
				<th colspan="2"> 중식 </th>
				<th colspan="2"> 저녁 </th>
				
			</tr>
			
			<tr>
				<td colspan="2">
					<c:forEach items="${todayBreakFast}" var="menuList">
								${menuList} 
					</c:forEach>
		
					
					<c:if test="empty ${todayBreakFast}">
						<td> 해당하는 식단이 없습니다. </td>
					</c:if>
					
				</td>
				
				<td colspan="2">
				
						<c:forEach items="${todayLunch}" var="menuList">
							${menuList} 
						</c:forEach>
					
					
					<c:if test="empty ${todayLunch}">
						<td> 해당하는 식단이 없습니다. </td>
					</c:if>
					
				</td>
				 
				 <td colspan="2">
				 	
						<c:forEach items="${todayDinner}" var="menuList">
								${menuList} 
						</c:forEach>
					
					
					<c:if test="empty ${todayDinner}">
						<td> 해당하는 식단이 없습니다. </td>
					</c:if>
					
				</td>
				 
			</tr>
		
			<tr>
				<td><button type="button" class="btn-primary" id="likeBreakfast">좋아요 </button></td>
				<td><button type="button" class="btn-danger" id="dislikeBreakfast">싫어요 </button></td>
				<td><button type="button" class="btn-primary" id="likeLunch">좋아요 </button></td>
				<td><button type="button" class="btn-danger" id="dislikeLunch">싫어요 </button></td>
				<td><button type="button" class="btn-primary" id="likeDinner">좋아요 </button></td>
				<td><button type="button" class="btn-danger" id="dislikeDinner">싫어요 </button></td>
			</tr>
		
		</table>
		</div>
	
	</div>
</body>
</html>
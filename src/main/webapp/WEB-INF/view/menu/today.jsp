<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				</td>
				
				<td colspan="2">
					<c:forEach items="${todayLunch}" var="menuList">
							${menuList} 
					</c:forEach>
				</td>
				 
				 <td colspan="2">
					<c:forEach items="${todayDinner}" var="menuList">
							${menuList} 
					</c:forEach>
				</td>
				 
			</tr>
		
			<tr>
				<td> 좋아요 </td>
				<td> 싫어요 </td>
				<td> 좋아요 </td>
				<td> 싫어요 </td>
				<td> 좋아요 </td>
				<td> 싫어요 </td>
			</tr>
		
		</table>
		</div>
	
	</div>
</body>
</html>
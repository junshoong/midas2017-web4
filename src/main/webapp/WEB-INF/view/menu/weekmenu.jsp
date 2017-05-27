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
		<table>
			<tr> 
				<th> 5월(test) </th>
				<th> 월 </th>
				<th> 화 </th>
				<th> 수 </th>
				<th> 목 </th>
				<th> 금 </th>
			</tr>
			
			<tr>
				<td> 조식 </td>
				<c:forEach items="${weekMenuBreakFast}" var="menuList">
					<td> ${menuList} </td>
				</c:forEach>
			</tr>
			
			<tr>
				<td> 중식 </td>
				<c:forEach items="${weekMenuLunch}" var="menuList">
					<td> ${menuList} </td>
				</c:forEach>
			</tr>
		
			<tr>
				<td> 석식 </td>
				<c:forEach items="${weekMenuDinner}" var="menuList">
					<td> ${menuList} </td>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>
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
	<h1>통계</h1>
	
	<table class="table">
	<tr>
		<th> 구분 </th>
		<th> 아침 </th>
		<th> 점심 </th>
		<th> 저녁 </th>
	</tr>
	<tr>
		<td> 총 식사 횟수 </td>
		<c:forEach var="m" items="${meals['all']}">
			<td>
				<c:set var="sum" value="${m[0] + m[1]}" />
				<c:out value="${sum}" /> (
				<c:out value="${m[0]}" /> /
				<c:out value="${m[1]}" /> )
			</td>
		</c:forEach>
	</tr>
	<tr>
		<td> 올해 식사 횟수 </td>
		<c:forEach var="m" items="${meals['year']}">
			<td>
				<c:set var="sum" value="${m[0] + m[1]}" />
				<c:out value="${sum}" /> (
				<c:out value="${m[0]}" /> /
				<c:out value="${m[1]}" /> )
			</td>
		</c:forEach>
	</tr>
	<tr>
		<td> 이번달 식사 횟수 </td>
		<c:forEach var="m" items="${meals['month']}">
			<td>
				<c:set var="sum" value="${m[0] + m[1]}" />
				<c:out value="${sum}" /> (
				<c:out value="${m[0]}" /> /
				<c:out value="${m[1]}" /> )
			</td>
		</c:forEach>
	</tr>
	</table>

</div>
</body>
</html>
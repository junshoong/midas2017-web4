<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> 식사 통계 </title>

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
		<th> 합계 </th>
	</tr>
	<tr>
		<td> 총 식사 횟수 </td>
		<c:set var="total" value="${0}" />
		<c:set var="total_like" value="${0}" />
		<c:set var="total_dislike" value="${0}" />
		<c:forEach var="m" items="${meals['all']}">
			<td>
				<c:set var="sum" value="${m[0] + m[1]}" />
				<c:out value="${sum}" /> (
				<c:out value="${m[0]}" /> /
				<c:out value="${m[1]}" /> )
				<c:set var="total" value="${total + m[0]}" />
				<c:set var="total_like" value="${total_like + m[0]}" />
				<c:set var="total_dislike" value="${total_dislike + m[1]}" />
			</td>
		</c:forEach>
		<td>
			<c:out value="${total}" /> (
			<c:out value="${total_like}" /> /
			<c:out value="${total_dislike}" /> )
		</td>
	</tr>
	<tr>
		<td> 올해 식사 횟수 </td>
		<c:set var="total" value="${0}" />
		<c:set var="total_like" value="${0}" />
		<c:set var="total_dislike" value="${0}" />
		<c:forEach var="m" items="${meals['year']}">
			<td>
				<c:set var="sum" value="${m[0] + m[1]}" />
				<c:out value="${sum}" /> (
				<c:out value="${m[0]}" /> /
				<c:out value="${m[1]}" /> )
				<c:set var="total" value="${total + m[0]}" />
				<c:set var="total_like" value="${total_like + m[0]}" />
				<c:set var="total_dislike" value="${total_dislike + m[1]}" />
			</td>
		</c:forEach>
		<td>
			<c:out value="${total}" /> (
			<c:out value="${total_like}" /> /
			<c:out value="${total_dislike}" /> )
		</td>

	</tr>
	<tr>
		<td> 이번달 식사 횟수 </td>
		<c:set var="total" value="${0}" />
		<c:set var="total_like" value="${0}" />
		<c:set var="total_dislike" value="${0}" />
		<c:forEach var="m" items="${meals['month']}">
			<td>
				<c:set var="sum" value="${m[0] + m[1]}" />
				<c:out value="${sum}" /> (
				<c:out value="${m[0]}" /> /
				<c:out value="${m[1]}" /> )
				<c:set var="total" value="${total + m[0]}" />
				<c:set var="total_like" value="${total_like + m[0]}" />
				<c:set var="total_dislike" value="${total_dislike + m[1]}" />
			</td>
		</c:forEach>
		<td>
			<c:out value="${total}" /> (
			<c:out value="${total_like}" /> /
			<c:out value="${total_dislike}" /> )
		</td>
	</tr>
	</table>

</div>
</body>
</html>
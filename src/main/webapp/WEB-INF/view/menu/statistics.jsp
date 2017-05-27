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
		<c:forEach var="meal" items="${meals}">
			<tr>
			<td>${meal.key}</td>
				<c:forEach var="m" items="${meal.value}">
					<td><c:out value="${m}" /></td>
				</c:forEach>
			</tr>
		</c:forEach>
		</tr>
	</table>

</div>
</body>
</html>
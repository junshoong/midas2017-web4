<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	search.jsp
	<form method="get">
	<input type="text" name="q" placeholder="메뉴 or 2017-05-27"></input>
	<button type="submit" class="btn btn-default"> 검색 </button>
	</form>

	<table class="table table-hover table-striped">
	<thead>
		<tr>
			<th>요일</th>
			<th>메뉴</th>
			<th>이미지</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ml" items="${menu_list}" varStatus="status">
		<c:choose>
			<c:when test="${ml.menu_kind == 10 }">
				<c:set var="menuKind" value="아침" />
			</c:when>
			<c:when test="${ml.menu_kind == 20 }">
				<c:set var="menuKind" value="점심" />
			</c:when>
			<c:when test="${ml.menu_kind == 30 }">
				<c:set var="menuKind" value="저녁" />
			</c:when>
		</c:choose>
		
		<tr>
			<td>
				${ml.menu_date } - ${menuKind }
			</td>
			<td class="text_center">
				<c:forEach var="mlf" items="${ml.foodVO }" varStatus="status">
				${mlf.food_name } <br />
				</c:forEach>
			</td>
			<td>
				<img class="img-responsive" src="" style="max-height:150px;" />
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</div>
</body>
</html>
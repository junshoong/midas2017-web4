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
		<h1>Bootstrap template</h1>
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row">
					<div class="col col-xs-6">
						Panel heading
					</div>
					<div class="col col-xs-6 text-right">
						<a class="btn btn-primary" href="regist">추가</a>
					</div>
				</div>
			</div>
			
			<div class="table-responsive">
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>요일</th>
							<th>메뉴</th>
							<th>이미지</th>
							<th>수정</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ml" items="${menu_list }" varStatus="status">
						<c:choose>
							<c:when test="${ml.menuVO.menu_kind == 10 }">
								<c:set var="menuKind" value="아침" />
							</c:when>
							<c:when test="${ml.menuVO.menu_kind == 20 }">
								<c:set var="menuKind" value="점심" />
							</c:when>
							<c:when test="${ml.menuVO.menu_kind == 30 }">
								<c:set var="menuKind" value="저녁" />
							</c:when>
						</c:choose>
						
						<tr>
							<td>
								${ml.menuVO.menu_date } - ${menuKind }
							</td>
							<td>
<%-- 								<c:forEach var="mlf" items="${ml.foodVO }" varStatus="status"> --%>
<%-- 								${mlf.food_name } --%>
<%-- 								</c:forEach> --%>
								${ml.foodVO }
							</td>
							<td>
								<img class="img-responsive" src="" style="max-height:150px;" />
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
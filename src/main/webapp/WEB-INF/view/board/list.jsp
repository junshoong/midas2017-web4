<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="<c:url value="/static/css/dashboard.css"/>" rel="stylesheet">
	<script src="<c:url value="/static/bootstrap/js/ie-emulation-modes-warning.js"/>"></script>


</head>

<style>
	.panel-table .panel-footer .pagination{
		margin:0;
	}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기본 게시판^-^</title>
</head>
	
<body class="cke_contents_ltr cke_show_borders">
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	
		<!-- board type-1 -->
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			
			<tbody>
				<c:if test="${empty boardList}">
				<tr>
					<td colspan="5">등록된 게시글이 존재하지 않습니다 </td>
				</tr>
				</c:if>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.articleId}</td>
						<td><a href="<c:url value="/board/detail/${board.articleId}"/>">${board.subject}</a></td>
						<td>${board.userVO.user_name}</td>
						<td>${board.createdDate}</td>
						<td>${board.readCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="controls pull-right">
			<a href="<c:url value="board/write"/>" class="btn btn-sm btn-primary"> 쓰기 </a>
		</div>

		<form id="searchForm">
			${pager} <br/>
			
		</form> <!-- /board type-1 -->
		
		<hr />
		
		<!-- board type-2 -->
		<div class="panel panel-default panel-table">
			<div class="panel-heading">
				<div class="row">
					<div class="col-sm-6 pull-right text-right">
						<a href="<c:url value="board/write"/>" class="btn btn-sm btn-primary"> 쓰기 </a>
					</div>
				</div>
			</div> <!-- /.panel-header -->
			
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${empty boardList}">
					<tr>
						<td colspan="5">등록된 게시글이 존재하지 않습니다 </td>
					</tr>
					</c:if>
					<c:forEach items="${boardList}" var="board">
						<tr>
							<td>${board.articleId}</td>
							<td><a href="<c:url value="/board/detail/${board.articleId}"/>">${board.subject}</a></td>
							<td>${board.userVO.user_name}</td>
							<td>${board.createdDate}</td>
							<td>${board.readCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table> <!-- /.table -->
			
			<div class="panel-footer">
				<div class="row">
					<div class="col col-xs-4">Page 1 of 5</div>
					<div class="col col-xs-8">
						<nav>
							<ul class="pagination pagination-sm pull-right">
								<li><a href="#" aria-label="Previous"><<</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#" aria-label="Next">>></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div> <!-- /.panel-footer -->

		</div> <!-- /.panel --> <!-- /board type-2 -->
	</div>
	
</body>

</html>
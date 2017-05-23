<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/static/js/ckeditor/contents.css?t=H0CG"/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/static/js/ckeditor/plugins/copyformatting/styles/copyformatting.css"/>" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"> </script>

</head>
<body class="cke_contents_ltr cke_show_borders">

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

		<h1>${board.subject}</h1>

		<hr />
		<div class="board">
			${board.createdDate} / ${board.readCount}
		</div>
		<br />
		<p>${board.content}</p>
		<hr />

		
		<div class="controls">
			<a href="<c:url value="/board/modify/${board.articleId}"/>">수정 </a> | <a
				href="<c:url value="/board/delete/${board.articleId}"/>">삭제 </a> | <a
				href="<c:url value="/"/>"> 목록보기 </a>
		</div>
	</div>

</body>
</html>
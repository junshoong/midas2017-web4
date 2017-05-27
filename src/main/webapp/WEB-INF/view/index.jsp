<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
    
<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
     <link href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
     
 
    <!-- Custom styles for this template -->
    <link href="<c:url value="/static/css/dashboard.css"/>" rel="stylesheet">
    <script src="<c:url value="/static/bootstrap/js/ie-emulation-modes-warning.js"/>"></script>

      
   <style>
		span {
			color:#eee;
		}
		
		.navbar-right {
			padding: 15px 15px;
		}
	</style>
    
  </head>

  <body>


    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<c:url value="/"/>">웹솔루션 4조</a>
        </div>

          <ul class="nav navbar-nav navbar-right">
            	<span> ${sessionScope._USER_.userName}님, 환영합니다.! </span>
			 	<a href="<c:url value="/logout"/>"> 로그 아웃 </a>
          </ul>

      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
        
        <c:if test="${sessionScope._USER_.userPermission=='10'}">
          <ul class="nav nav-sidebar">
            <li><a href="board">게시판</a></li>
            <li><a href="menumanage">식단 관리</a></li>
          </ul>
       </c:if>   
          <ul class="nav nav-sidebar">
            <li><a href="menusearch">식단 조회/검색</a></li>
            <li><a href="menutoday">오늘의 식사</a></li>
            <li><a href="menustatistics">통계</a></li>
          </ul>

        </div>
        
       
 		<jsp:include page="/WEB-INF/view/${content}"></jsp:include> 
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="<c:url value="/static/bootstrap/js/ie10-viewport-bug-workaround.js"/>"></script>
  

<svg xmlns="http://www.w3.org/2000/svg" width="200" height="200" viewBox="0 0 200 200" preserveAspectRatio="none" style="visibility: hidden; position: absolute; top: -100%; left: -100%;"><defs></defs><text x="0" y="10" style="font-weight:bold;font-size:10pt;font-family:Arial, Helvetica, Open Sans, sans-serif;dominant-baseline:middle">200x200</text></svg></body></html>
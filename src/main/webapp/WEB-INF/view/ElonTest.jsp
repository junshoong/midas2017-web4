<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Home</title>
    
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    
</head>
<body>
	<div class="container">
			<h1>Bootstrap template</h1>
			<h2>${value.subject}</h2>
			
			<form class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2 control-label">날짜</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="inputEmail3" placeholder="날짜">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">이미지</label>
					<div class="col-sm-10">
						<div class="fileinput fileinput-new" data-provides="fileinput">
						  <span class="btn btn-default btn-file"><span class="fileinput-new">Select file</span><span class="fileinput-exists">Change</span><input type="file" name="..."></span>
						  <span class="fileinput-filename"></span>
						  <a href="#" class="close fileinput-exists" data-dismiss="fileinput" style="float: none">&times;</a>
						</div>
					</div>
				</div>
			
			
			</form>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>

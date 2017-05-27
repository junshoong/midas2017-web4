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
			
			<form class="form-horizontal" method="post" enctype="multipart/form-data">
			
				<div id="menu-wrap">
					<h3>식단정보</h3>
					<hr />
				
					<div class="form-group">
						<label class="col-sm-2 control-label">날짜</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="MenuVO.menu_date" placeholder="2017-05-28" required>
						</div>
						<div class="col-sm-3">
							<select class="form-control" name="MenuVO.menu_kind">
								<option value="10">아침</option>
								<option value="20">점심</option>
								<option value="30">저녁</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">사진 업로드</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" name="image_file" required>
						</div>
					</div>
				</div>
				
				<hr />
				<div id="food-wrap">
					<div class="form-group">
						<label class="col-sm-2 control-label">밥 (칼로리)</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="foodVO[0].food_name" required>
							<input type="hidden" name="foodVO[0].food_kind" value="10" />
						</div>
						<div class="col-sm-3">
							<input type="number" class="form-control" name="foodVO[0].food_calory" placeholder="300" min="1" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">국 (칼로리)</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="foodVO[1].food_name" required>
							<input type="hidden" name="foodVO[1].food_kind" value="20" />
						</div>
						<div class="col-sm-3">
							<input type="number" class="form-control" name="foodVO[1].food_calory" placeholder="300" min="1" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">반찬 1</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="foodVO[2].food_name" required>
							<input type="hidden" name="foodVO[2].food_kind" value="30" />
						</div>
						<div class="col-sm-3">
							<input type="number" class="form-control" name="foodVO[2].food_calory" placeholder="300" min="1" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">반찬 2</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="foodVO[3].food_name" required>
							<input type="hidden" name="foodVO[3].food_kind" value="30" />
						</div>
						<div class="col-sm-3">
							<input type="number" class="form-control" name="foodVO[3].food_calory" placeholder="300" min="1" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">반찬 3</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="foodVO[4].food_name" required>
							<input type="hidden" name="foodVO[4].food_kind" value="30" />
						</div>
						<div class="col-sm-3">
							<input type="number" class="form-control" name="foodVO[4].food_calory" placeholder="300" min="1" required>
						</div>
					</div>
				</div>
				
				
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10 text-right">
						<a href="#" class="btn btn-default">취소</a>
						<button type="submit" class="btn btn-default">식단 등록</button>
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

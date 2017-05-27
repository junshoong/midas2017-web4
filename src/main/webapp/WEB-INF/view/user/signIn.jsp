<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

    <title>로그인 창</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
	
	
    <!-- Custom styles for this template -->
    <link href="<c:url value="/static/css/signin.css"/>" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="<c:url value="/static/bootstrap/js/ie-emulation-modes-warning.js"/>"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
	
	$().ready(function() {
		
		$(".form-signin").find("button[type=submit]").click(function() {
			
			$(".form-signin").attr({
				"action" : "<c:url value="/signin" />",
				"method" : "post"
			});
			
			$(".form-signin").submit();
			
		});
		
	});

</script>
    
    
    
</head>

<body>

	<div class="container">
	
		<form class="form-signin">
			<div class="panel panel-default">
				<div class="panel-body">
					<h2 class="form-signin-heading">Please sign in</h2>
					<input type="email" name="user_id" class="form-control" placeholder="아이디" required autofocus> 
					<input type="password" name="user_password" class="form-control" placeholder="패스워드" required>
					<div class="checkbox">
						<label>
							<input type="checkbox" value="remember-me"> Remember me
						</label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
					    
					<p class="media">
						계정이 없다면?
						<a href="<c:url value="/signup"/>">Create an account</a>.
					</p>
				</div>
			</div>
		</form>
	
	</div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="<c:url value="/static/bootstrap/js/ie10-viewport-bug-workaround.js"/>"></script>
  


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = 'c' uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="<c:url value="/static/js/ckeditor/plugins/copyformatting/styles/copyformatting.css"/>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"> </script>
<script src="<c:url value="/static/js/ckeditor/ckeditor.js"/>"> </script>
<script type="text/javascript">
	$().ready(function() {
		$("#saveBtn").click(function() {
			$("#writeForm").attr({
				"method" : "POST",
				"action" : "<c:url value="/board/write"/>"
			});
			$("#writeForm").submit();
		});
	});

</script>
<title>Insert title here</title>
</head>
<body>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	 <form id="writeForm">
	 		<input type="hidden" name="writer" value="${sessionScope._USER_.userName}"/>
	 		<input type="text" name="subject" id="subject"/>
            <textarea name="content" id="editor1" rows="10" cols="80">
                This is my textarea to be replaced with CKEditor.
            </textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace('content');
            </script>
        </form>
		<div id="uploadFiles"></div>
		<div>
			<form target="uploadFrame"
					method="post" action="<c:url value="/board/upload"/>"
					enctype="multipart/form-data" >
			<input type="file" name="file" />
			<input type="submit" value="Upload" />
			</form>
			<iframe name="uploadFrame" style="display: none;"></iframe>
		</div>
  
        
        <input type="button" id="saveBtn" value="Save" />
        <input type="button" id="cancelBtn" value="Cancel" />	
   </div>
</body>
</html>
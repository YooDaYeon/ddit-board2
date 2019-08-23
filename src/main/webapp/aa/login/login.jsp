<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="frm" action="${pageContext.request.contextPath }/login" method="post">
		<label for="userId" class="sr-only">Id</label> 
		<input type="text" id="userId" name="userId" value="sally"> <br>
		 <label for="inputPassword" class="sr-only">Password</label>
		<input type="password" id="pass" name="pass" value="sally1234"><br>
		<input type="submit" class="btn btn-lg btn-primary btn-block" id="btn" name="btn" value="SIGN UP">
	</form>
</body>
</html>
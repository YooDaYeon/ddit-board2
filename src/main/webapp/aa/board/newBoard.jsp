<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="aa.user.model.UserVO"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<!-- Bootstrap core CSS -->
<link href="${cp}/aa/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${cp}/aa/css/signin.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script>

	$(document).ready(function(){
		$('#newBtn').on('click',function(){
			
			$('#newfrm').submit();
			
		});
		
	})
	
	




</script>
<title>Insert title here</title>
<!-- css, js -->
<%@include file="/aa/common/basicLib.jsp" %>
</head>


<body>
	<!-- 	header -->
	<%@include file="/aa/common/header.jsp"%>
	
	<div class="container-fluid">
		<div class="row">
		 
			<!-- left -->
			<%@include file="/aa/common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
<!-- 			게시판 생성 -->
			<form action="${cp }/board/new" id="newfrm" method="post">
			
				게시판 이름 <input type="text" id="nboardName" name="nboardName">
						  <select name="nuse" id="nuse">
						  	<option value="사용" id="nuseOk" selected>사용</option>
						 	<option value="미사용" id="nuseNo">미사용</option>
						  </select>
						  <button id="newBtn" type="button" name="newBtn">생성</button>
						  <br>
			</form>
			
<!-- 			게시판 수정 -->
			<c:forEach items="${BOARDLIST }" var="boardList" >
				<form action="${cp }/board/revice" id="revicefrm" method="post">
					게시판 이름 <input type="text" id="boardName" name="boardName" value="${boardList.boardName }">
							 <input type="hidden" id="boardId" name="boardId" value="${boardList.boardId }">
							 <select name="use" id="use">
							 	<c:if test="${ boardList.boardUseYn == '사용'}">
							 		<option value="사용" id="useOk" selected>사용</option>
							 		<option value="미사용" id="useNo">미사용</option>
							 	</c:if>
							 	
							 	<c:if test="${ boardList.boardUseYn == '미사용'}">
							 		<option value="사용" id="useOk">사용</option>
							 		<option value="미사용" id="useNo" selected>미사용</option>
							 	</c:if>
							 	
							 </select>
							 <button id="saveBtn" type="submit" name="saveBtn">수정</button><br>
				</form>
			</c:forEach>
			
			
			
			</div>
		</div>
	</div>
	
	
	
</body>
</html>
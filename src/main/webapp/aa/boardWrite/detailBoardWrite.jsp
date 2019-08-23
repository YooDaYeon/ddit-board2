<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
 $(document).ready(function(){
	   
	$("#revicebtn").on("click",function(){
		$("#reviceform").submit();
		
	});
	 
	 $("#deletebtn").on("click",function(){
			$("#deleteform").submit();
			
		});
	 
	 $("#replybtn").on("click",function(){
			$("#replyform").submit();
			
		});
	 
	 
	 $("#commentsbtn").on("click",function(){
			$("#commentsfrm").submit(); 
	 });
	 
 	$("#comcontents").keyup(function(){
 		if($(this).val().length > $(this).attr('maxlength')){
 			alert("500자까지 가능합니다");
 		}
 		
 	});
	 
 });
 
 


</script>
<style>
	
	#replyInput{
		width : 430px;
	}

	button{
		width : 80px;
	}
	
</style>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>게시글 상세조회</title>
	
	<!-- css, js -->
	<%@include file="/aa/common/basicLib.jsp" %>
</head>

<body>

	<!-- header -->
	<%@include file="/aa/common/header.jsp" %>
	
	<div class="container-fluid">
		<div class="row">
			<!-- left -->
			<%@include file="/aa/common/left.jsp" %>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
				<div class="col-sm-8 blog-main">
						
				<form id="reviceform" action="${cp}/boardWrite/revice
					" >
					<input type="hidden" id="boardId" name="boardId" value="${detailvo.boardId}"/>
					<input type="hidden" id="writeId" name="writeId" value="${detailvo.writeId}"/>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${detailvo.title }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<label class="control-label">${detailvo.writeContent }</label>
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<c:forEach items="${attachList }" var = "attachList">
								<a href="${cp}/attach/down?fileId=${attachList.fileId}&writeId=${detailvo.writeId}">${attachList.originalFileName}</a>
								<br>
							</c:forEach>
						</div>
					</div>
					
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button id="revicebtn" type="button" class="btn btn-default">수정</button>
							</div>
						</div>
					</form>
					
					<form id="deleteform" action="${cp }/boardWrite/delete?writeId=${detailvo.writeId}&boardId=${detailvo.boardId}" method="post">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<c:if test = "${USER_INFO.userId == detailvo.userId}">
									<button id="deletebtn" type="submit" class="btn btn-default">삭제</button>
								</c:if>
								
							</div>
						</div>
					</form>
					
					<form id="replyform" action="${cp }/boardWrite/reply" method="get">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="hidden" id="writeId" name="writeId" value="${detailvo.writeId}">
								<input type="hidden" id="boardId" name="boardId" value="${detailvo.boardId}">
								<button id="replybtn" type="submit" class="btn btn-default">답글</button>
							</div>
						</div>
					</form>
					<br>
					
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">댓글</label>
						<div class="col-sm-10">
							<table  class="table table-striped text-center">
								<c:forEach items="${comList }" var = "comList">
									<tr>
										<c:if test="${comList.comYn == '사용' }">
										<td>${comList.comContents }[${comList.userId } / <fmt:formatDate value="${comList.comDate}" pattern="yyyy-MM-dd" />]</td>
										
										<td><a id="delete" 
										href="${cp }/comments/delete?comId=${comList.comId }&writeId=${comList.writeId}">x</a></td>
										</c:if>
										
										<c:if test="${comList.comYn == '미사용' }">
											<td>[삭제된 게시글(댓글)입니다]</td>
										</c:if>
									</tr>
								
								</c:forEach>
								
								
							</table>
							
							
							<form action="${cp }/comments/insert" id="commentsfrm" method="post">
								<input type="text" id="comcontents" name="comcontents" maxlength="500">
								<input type="hidden" id="boardId" name="boardId" value="${detailvo.boardId}">
								<input type="hidden" id="writeId" name="writeId" value="${detailvo.writeId}">
								<input type="button" id="commentsbtn"  class="btn btn-default" value="댓글저장">
							</form>
						</div>
					</div>
				
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
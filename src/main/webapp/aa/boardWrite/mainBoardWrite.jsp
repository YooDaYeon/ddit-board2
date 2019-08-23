<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="aa.user.model.UserVO"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<style>

	.boardTr{
		cursor: pointer;
	}
	
	

</style>

<script>
	$(document).ready(function() {
		
		$(".boardTr").on("click",function(){
			
			a = $(this).children("td:nth-child(1)").text();
			$(this).data("boardId");
		
			$("#writeId").val(a);
			
			
			$("#frm").submit();
			
			
		});
		
		$("#addbtn").on('click',function(){
			$("#addfrm").submit();
			
		});
		
	});
	
	


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
				<div class="row">
					<div class="col-sm-8 blog-main">
					<form id="frm" action="${cp }/boardWrite/detail">
						<input type="hidden" id="boardId" name="boardId" value="${param.boardId }">
						<input type="hidden" id="writeId" name="writeId" >
					</form>
					
					<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자 아이디</th>
									<th>작성일시</th>
								</tr>
						
							<c:forEach items="${bwList }" var="list" varStatus="status">
								<c:if test="${list.writeUseYn == '사용' }">
									<tr class="boardTr" >
											<td style="display:none">${list.writeId }</td>
											<td>${list.rn }</td>
										<c:choose>
												<c:when test="${list.parentId != 0}">
												<td style="padding-left:${list.lv}9px">ㄴ${list.title }</td>
												</c:when>
												
												<c:otherwise>
												<td>${list.title }</td>
												</c:otherwise>
										</c:choose>
										
										<td>${list.userId }</td>
										<td><fmt:formatDate value="${list.writeDate}" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:if>
								
								<c:if test="${list.writeUseYn == '미사용' }">
									<tr >
										<td colspan="4">[삭제된 게시글(댓글)입니다] </td>
									<tr>
								</c:if>
							</c:forEach>
					</table>
				</div>
			
			
			<div class="text-center">
					<ul class="pagination">

						<c:choose>
							<c:when test="${pageVO.page == 1 }">
								<li class="disabled"><span>««</span></li>
							</c:when>
							<c:otherwise>
								<li>
								<a href="${cp}/boardWrite/main?page=1&pageSize=${pageVO.pageSize}&boardId=${param.boardId}">««</a>
								</li>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${pageVO.page==1}">
								<li class="disabled"><span>«</span></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="${cp}/boardWrite/main?page=${pageVO.page-1}&pageSize=${pageVO.pageSize}&boardId=${param.boardId}"><span>«</span></a></li>
							</c:otherwise>
						</c:choose>

						<c:forEach begin="1" end="${paginationSize}" step="1" var="i">

							<c:choose>
								<c:when test="${pageVO.page == i }">
									<li class="active"><span> ${i}</span></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="${cp}/boardWrite/main?page=${i}&pageSize=${pageVO.pageSize}&boardId=${param.boardId}">${i}</a></li>
								</c:otherwise>
							</c:choose>

						</c:forEach>

						<c:choose>
							<c:when test="${pageVO.page==paginationSize}">
								<li class="disabled"><span>»</span></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="${cp}/boardWrite/main?page=${pageVO.page+1}&pageSize=${pageVO.pageSize}&boardId=${param.boardId}"><span>»</span></a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${pageVO.page == paginationSize }">
								<li class="disabled"><span>»»</span></li>
							</c:when>
							<c:otherwise>
								<li>
								<a href="${cp}/boardWrite/main?page=${paginationSize}&pageSize=${pageVO.pageSize}&boardId=${param.boardId}">»»</a>
								</li>
							</c:otherwise>
						</c:choose>
						

					</ul>
					
				</div>
					<form action ="${cp }/boardWrite/new" id="addfrm" >
						<input type="button" class="form-control" id="addbtn" name="addbtn" value="새글 등록" >
						<input type="hidden" id="boardId" name="boardId" value="${param.boardId }">
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	
	
</body>
</html>
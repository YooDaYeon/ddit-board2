<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   	


<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="${pageContext.request.contextPath}/aa/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="${pageContext.request.contextPath}/board/new">게시판 생성</a></li>
		
		<c:forEach items="${BOARDLIST }" var="BOARDLIST" >
			<c:if test="${BOARDLIST.boardUseYn == '사용' }" >
				 <li id="list" class="active"><a href="${pageContext.request.contextPath }/boardWrite/main?boardId=${BOARDLIST.boardId}">
				 ${BOARDLIST.boardName } </a></li>
			</c:if>
		</c:forEach>
			
		
	</ul>
</div>
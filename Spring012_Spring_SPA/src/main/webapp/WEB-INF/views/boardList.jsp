<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<!-- TODO 14_03 전체 게시글 출력 boardList.jsp -->
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<button onclick="location.href='./logout.do'">로그아웃</button>
${loginVo}<br>
${page}<br>
<div class="container">
	<form action="">
		<table class="table table-hover">
			<thead>
				<tr class="info">
					<c:if test="${loginVo.auth eq 'A'}">
						<td>
							<input type="checkbox" class="allCheck" id="allCheck" onclick="checkAll(this.checked)">
						</td>
					</c:if>
					<td>글번호</td>
					<td>작성자</td>
					<td>제목</td>
					<c:if test="${loginVo.auth eq 'A'}">
						<td>삭제여부</td>
					</c:if>
					<td>작성일</td>
				</tr>
			</thead>
			<!-- TODO 18_09 전달된 게시글의 정보 List row 출력 -->
			<tbody>
				<c:forEach var="vo" items="${list}" varStatus="vs">
					<tr>
						<c:if test="${loginVo.auth eq 'A'}">
							<td>
								<input type="checkbox" name="delCheck" value="${vo.seq}">
							</td>
						</c:if>
						<td>${vs.index}</td>
						<td>${vo.id}</td>
						<td>
							<c:set var="title" value="${vo.title}"/>
							${title.replaceAll("<img>", "<img src='./images/reply.png'>") }
						</td>
						<c:if test="${loginVo.auth eq 'A'}">
							<td>${vo.delflag}</td>
						</c:if>
						<td>${vo.regdate }</td>
					</tr>				
				</c:forEach>
			</tbody>
		</table>
	</form> 
</div>
</body>
</html>
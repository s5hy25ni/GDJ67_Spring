<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>유저 목록 <button class="btn btn-primary" onclick="location.href='./userInfo.do'">내 정보 확인</button></h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					<th>유형</th>
					<th>상태</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="vo" varStatus="vs">
					<tr>
						<td>${(page.curPage-1)*page.cntOnePage+1+vs.index}</td>
						<td>${vo.id}</td>
						<td>${vo.name}</td>
						<td>${vo.email}</td>
						<td>${(vo.auth=='U')?"사용자":"관리자"}</td>
						<td>${(vo.delflag=='N')?"활동":"휴면"}</td>
						<fmt:formatDate var="joindate" value="${vo.joindate}" pattern="yyyy-MM-dd"/>
						<td>${joindate}</td>
					</tr>			
				</c:forEach>
			</tbody>
		</table>
		<div style="text-align: center">
			<ul class="pagination">
				<c:if test="${page.startPage!=1}"><li><a href="./getUserList.do?page=1">◁</a></li></c:if>
				<c:if test="${page.startPage!=1}"><li><a href="./getUserList.do?page=${page.startPage-5}">◀</a></li></c:if>
				<c:forEach var="p" begin="${page.startPage}" end="${page.endPage}">
					<li ${page.curPage==p?"class='active'":""}><a href="./getUserList.do?page=${p}">${p}</a></li>
				</c:forEach>
				<c:if test="${page.endPage!=page.totalPage}"><li><a href="./getUserList.do?page=${page.startPage+5}">▶</a></li></c:if>
				<c:if test="${page.endPage!=page.totalPage}"><li><a href="./getUserList.do?page=${page.totalPage}">▷</a></li></c:if>
			</ul>
		</div>
	</div>
</body>
</html>
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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style type="text/css">
	.container{
		width: 600px;
		margin: 100px auto;
	}
</style>
</head>
<body>
	<div id="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>NO</th>
					<th>ID</th>
					<th>NAME</th>
					<th>EMAIL</th>
					<th>AUTH</th>
					<th>DELFLAG</th>
					<th>JOINDATE</th>
				</tr>
			</thead>
			<tbody>
				<fmt:parseNumber type ="number" var="start" value="${startNo}"/>
				<c:forEach items="${list}" var="vo" varStatus="vs">
					<tr>
						<td>${start + vs}</td>
						<td>${vo.id}</td>
						<td>${vo.name}</td>
						<td>${vo.email}</td>
						<td>${vo.auth}</td>
						<td>${vo.delflag}</td>
						<td>${vo.joindate}</td>
					</tr>			
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination">
		  <li><a href="#">1</a></li>
		  <li class="active"><a href="#">2</a></li>
		  <li><a href="#">3</a></li>
		  <li><a href="#">4</a></li>
		  <li><a href="#">5</a></li>
		</ul>
	</div>
</body>
</html>
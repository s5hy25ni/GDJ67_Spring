<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h4>${loginUser.id} 님! 환영합니다!</h4>
		<form action="./updatePassword.do" method="post">
			<table class="table">
				<tbody>
					<tr>
						<td>아이디</td>
						<th>${loginUser.id}</th>
					</tr>
					<tr>
						<td>이름</td>
						<th>${loginUser.name}</th>
					</tr>
					<tr>
						<td>이메일</td>
						<th>${loginUser.email}</th>
					</tr>
					<tr>
						<td>유형</td>
						<th>${(loginUser.auth=='U')?"사용자":"관리자"}</th>
					</tr>
					<tr>
						<td>상태</td>
						<th>${(loginUser.delflag=='N')?"활동":"휴면"}</th>
					</tr>
					<tr>
						<td>가입일</td>
						<fmt:formatDate var="joindate" value="${loginUser.joindate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						<th>${joindate}</th>
					</tr>
					<tr>
						<td>비밀번호 변경</td>
						<th><input type="password" class="form-control" id="pw" name="password"></th>
					</tr>
					<tr>
						<th colspan="2"><input type="submit" class="btn btn-success" value="비밀번호 변경"></th>					
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>
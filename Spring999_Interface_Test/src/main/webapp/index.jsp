<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
	.container{
		width: 200px;
		margin: 100px auto;
	}
</style>
</head>
<body>
	<%-- <jsp:forward page="/home.do"/> --%>
	<div class="container">
		<button type="button" class="btn btn-default" onclick="location.href='./joinForm.do'">회원가입</button>
		<button type="button" class="btn btn-success" onclick="location.href='./loginForm.do'">로그인</button>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>로그인</h1>
		<form action="./login.do" method="post">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input id="id" type="text" class="form-control" name="id" placeholder="id">
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				<input id="password" type="password" class="form-control" name="password" placeholder="Password">
			</div>
			<br>
			<input type="button" class="btn btn-default" onclick="javascript:history.back(-1)" value="취소">
			<input type="submit" class="btn btn-success" value="로그인">
		</form>
	</div>
</body>
</html>
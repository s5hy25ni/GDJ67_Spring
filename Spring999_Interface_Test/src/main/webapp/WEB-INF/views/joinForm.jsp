<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		<form action="./join.do" method="post">
			<div class="form-group">
			  <label for="id">ID:</label>
			  <input type="text" class="form-control" id="id" name="id">
			</div>
			<div class="form-group">
			  <label for="name">NAME:</label>
			  <input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
			  <label for="email">EMAIL:</label>
			  <input type="email" class="form-control" id="email" name="email">
			</div>
			<div class="form-group">
			  <label for="password">PASSWORD:</label>
			  <input type="password" class="form-control" id="password" name="password">
			</div>
			<input type="button" class="btn btn-default" onclick="javascript:history.back(-1)" value="취소">
			<input type="submit" class="btn btn-success" value="회원가입">
		</form>
	</div>
</body>
</html>
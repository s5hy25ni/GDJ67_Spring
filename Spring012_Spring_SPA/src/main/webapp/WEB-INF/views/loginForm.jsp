<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<!-- TODO 12_03 로그인 정보 입력 화면 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
	.container{
		width: 500px;
		margin: 200px auto;
	}
	
	.form-horizontal{
		border: 1px solid #ccc;
		border-radius: 20px;
		padding: 10px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="./js/login.js"></script>
</head>
<body>
	<div class="container">
		<form id="frm" class="form-horizontal">
		    <div class="input-group">
		      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		      <input id="id" type="text" class="form-control" name="id" placeholder="아이디입력">
		    </div>
		    <div class="input-group">
		      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
		      <input id="password" type="password" class="form-control" name="password" placeholder="비밀번호 입력">
		    </div>
		    <div>
		      <button type="submit" class="btn btn-success btn-block">로그인</button>
		    </div>
		    <a href="./signUp.do">회원가입</a>
		  </form>
	</div>
	<script type="text/javascript" src="./js/ObjectJS.js"></script>
</body>
</html>
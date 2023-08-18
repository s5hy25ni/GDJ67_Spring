<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
</head>
<body>
	<h1><a href="./home.do">HOME</a></h1>
	<div style="width:300px; margin:100px auto; border: 2px solid pink;">
		<form action="./info.do" method="post">
			이름 : <input type="text" name="name"><br>
			나이 : <input type="text" name="age"><br>
			<input type="submit" value="전송">
		</form>
	</div>
</body>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- TODO 07_02 index.jsp를 호출한 후에 다시 SpringContoller에 redirect -->
<%-- <% response.sendRedirect(request.getContextPath()+"/home.do"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처음 화면</title>
</head>
<body>
	<h2><a href="./home.do">home 요청</a></h2>
	<hr>
	
	<!-- TODO 08 POST 방식으로 info.do로 값 전달 <한글 깨짐> -->
	<div style="width:300px; margin:100px auto; border: 2px solid green;">
		<form action="./info.do" method="post">
			이름 : <input type="text" name="name"><br>
			나이 : <input type="text" name="age"><br>
			<input type="submit" value="전송">
		</form>
	</div>
</body>
</html>
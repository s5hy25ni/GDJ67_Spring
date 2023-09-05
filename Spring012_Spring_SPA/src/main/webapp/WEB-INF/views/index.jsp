<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	TODO 03_01 첫페이지 do 호출 설정 web.xml(deployment descriptor) 
		Custom Tag는 자바소스이다. 따라서 화면의 호출이 아님
-->
<jsp:forward page="/home.do"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>home page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	
	<fieldset>
		<legend>엘라스틱 서치로 검색엔진 만들기</legend>
		<a class="btn btn-success" href="./elastic.do">이동</a>
	</fieldset>
	<fieldset>
		<legend>자바스크립트로 엘라스틱 서치하기</legend>
		<a class="btn btn-success" href="./elastic2.do">이동</a>
	</fieldset>
	
	<fieldset>
		<legend>SQL 검색 비교하기</legend>
		<a class="btn btn-success" href="./searchTest.do">이동</a>
	</fieldset>
	
	<fieldset>
		<legend>PDF 업로드하여 PNG로 변환하기</legend>
		<a class="btn btn-success" href="./convert.do">이동</a>
	</fieldset>
</div>
</body>
</html>
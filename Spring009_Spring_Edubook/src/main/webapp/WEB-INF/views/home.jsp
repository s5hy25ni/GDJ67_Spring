<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spring Edubook 페이지 home.do</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<select id="lang" onchange="langChange()">
	<option value="ko" ${param.lang == "ko"?"selected":""}>한국어</option>
	<option value="en" ${param.lang == "en"?"selected":""}>영어</option>
</select>
<script type="text/javascript">
	function langChange(){
		var lange = document.getElementById("lang");
		var choiceValue = lang.options[lang.selectedIndex].value;
		console.log("선택된 언어 : ", choiceValue);
		location.href="./main.do?lang="+choiceValue;
	}
</script>
<div class="container">
	<form action="./login.do" method="POST">
		<table class="table">
			<tr class="warning">
				<th><spring:message code="label.id"/></th>
				<td>
					<input type="text" name="id" required="required">
				</td>
			</tr>
			<tr>
				<th><spring:message code="label.password"/></th>
				<td>
					<input type="password" name="password" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input class="btn btn-warning" type="submit" value='<spring:message code="label.login"/>'>
					<input class="btn btn-info" type="button" value="회원가입 Ajax">
					<input class="btn btn-info" type="button" value="회원가입 formValidation">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>

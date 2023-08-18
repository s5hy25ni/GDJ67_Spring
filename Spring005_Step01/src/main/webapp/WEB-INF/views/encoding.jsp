<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인코딩</title>
</head>
<body>
	<fieldset>
		<legend>JSP 인토딩 처리</legend>
		<div>
			JSP의 인코딩을 처리 하지 않으면 작성된 언어는 default로 OS으로 encoding되기 때문에 반드시 확인<br>
			<b>contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"</b>
		</div>
		<div style="text-align:center;">
			${serverTime}
		</div>
	</fieldset>
</body>
</html>
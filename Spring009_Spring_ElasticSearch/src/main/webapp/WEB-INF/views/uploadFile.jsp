<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>저장된 파일</legend>
		<div>
			<ul>
				<li>${originFileName}</li>
				<li>${saveFileName[0]}</li>
				<li>${path}</li>
				<li>
					<img src="./storage/${saveFileName[0]}">
				</li>
			</ul>
		</div>
	</fieldset>
</body>
</html>
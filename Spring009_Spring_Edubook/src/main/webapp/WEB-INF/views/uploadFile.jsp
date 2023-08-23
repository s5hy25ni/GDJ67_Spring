<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드된 파일 정보</title>
</head>
<body>
	<fieldset>
		<legend>저장된 파일</legend>
		<div>
			<ul>
				<li>${originFileName}</li>
				<li>${saveFileName}</li>
				<li>${path}</li>
				<li>
					<img src="./storage/${saveFileName}">
				</li>
			</ul>
		</div>
		<div>
			<div>파일 다운로드 REST 처리</div>
			<form action="./download.do" method="post">
				<input type="text" name="saveFileName" value="${saveFileName}">
				<input type="text" name="originFileName" value="${originFileName}">
				<input type="submit" value="다운로드">
			</form>
		</div>
	</fieldset>
	<ul>
		<li>
			<b>프로젝트의 path</b><br>
			request.getContextPath() : <%=request.getContextPath()%>
		</li>
		<li>
			<b>프로젝트의 path + 페이지의 경로</b><br>
			request.getRequestURI() : <%=request.getRequestURI()%> 
		</li>
		<li>
			<b>전체경로</b><br>
			request.getRequestURL() : <%=request.getRequestURL()%>
		</li>
		<li>
			<b>파일명</b><br>
			request.getServletPath() : <%=request.getServletPath()%>
		</li>
		<li>
			<b>파일의 물리적인 주소</b><br>
			request.getRealPath() : <%=request.getRealPath("")%>
		</li>
	</ul>
	
</body>
</html>
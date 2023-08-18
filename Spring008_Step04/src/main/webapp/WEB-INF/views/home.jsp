<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home 화면</title>
</head>
<body>
	- 서버 : <%=application.getServerInfo() %>
 	- 서블릿 : <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %>
	- JSP : <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
	<fieldset>
		<legend>처리 방식에 따른 Controller 연습</legend>
		<ul>
			<li>model 전달값 : ${requestScope.str}</li>
			<li>HttpServletRequest 전달값 : ${requestScope.req_str}</li>
		</ul>
		<ul>
			<!-- TODO 01_02 home.do를 GET 방식으로 호출 -->
			<li>
				<a href="./home.do?name=banana">home GET 호출</a>
			</li>
			
			<!-- TODO 02_01 home.do를 POST 방식으로 호출 -->
			<li>home.POST 호출<br>
				<form action="./home.do" method="POST">
					<input type="text" name="name" value="토마토"><br>
					<input type="submit" value="POST 전송">
				</form>
			</li>
			
			<!-- TODO 03_01 info.do GET 호출 Controller는 GET과 POST 둘 다 처리할 수 있음 -->
			<li>
				<a href="./info.do?name=한글&age=100">info GET 호출</a>
			</li>
			
			<!-- TODO 04_01 Spring Container에서의 Redirect 호출 -->
			<li>
				<a href="./redirect.do?name=바나나">redirect GET 호출</a>
			</li>
			
			<!-- TODO 05_01 Controller의 indexing 처리 방식을 통한 요청 -->
			<li>
				<a href="./user/logout.do">인덱싱 요청 처리</a>
			</li>
			
		</ul>
	</fieldset>
	
	<!-- TODO 06_01 EduBoardController의 selectBoard.do -->
	<fieldset>
		<legend>게시판 CRUD 및 Transaction</legend>
		<div>
			<a href="./selectBoard.do">게시글 전체보기</a>
		</div>
	</fieldset>
</body>
</html>
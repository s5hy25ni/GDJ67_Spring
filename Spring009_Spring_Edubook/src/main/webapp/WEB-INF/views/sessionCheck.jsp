<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 확인</title>
</head>
<body>
	<button onclick="javascript:location.href='./sessionInit.do'">모든 세션 추가</button>
	<fieldset>
		<legend>전달된 값 확인 영역</legend>
		<div>
			<h2>@SessionAttribute : ${sessionScope.sessionTest}</h2>
			<h2>HttpSession : ${sessionScope.httpsessionTest}</h2>
		</div>
	</fieldset>
	
	<div>
		<fieldset>
			<legend>같은 Controller에서의 확인</legend>
			<ul>
				<li>
					<a href="./test01.do">test01.do : @SessionAttribute 삭제</a>
					<button onclick="location.href='./result01.do'">결과 확인 Result01</button>
				</li>
				
				<li>
					<a href="./test02.do">test02.do : HttpAttribute 삭제</a>
					<button onclick="location.href='./result02S.do'">결과 확인 Result01</button>
				</li>
			</ul>
		</fieldset>
		<fieldset>
			<legend>다른 Controller에서의 확인</legend>
			<ul>
				<li>
					<a href="./test03.do">test03.do : @SessionAttribute 삭제</a>
					<button onclick="location.href='./result03.do'">결과 확인 Result01</button>
				</li>
				<li>
					<a href="./test04.do">test04.do : HttpSession 삭제</a>
					<button onclick="location.href='./result04.do'">결과 확인 Result01</button>
				</li>
			</ul>
		</fieldset>
	</div>
</body>
</html>
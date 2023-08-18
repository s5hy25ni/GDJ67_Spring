<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function findId(){
		console.log("아이디 찾기 함수");
		window.open("./findId.do", "아이디 찾기", "width=300px, height=300px");
	}
</script>
</head>
<body>
	<div class="container" style="margin-top: 100px">
		<form action="./login.do" method="post">
			<table class="table table-hover">
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" id="id">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pw">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<!-- TODO 06_01 로그인 UserControlloer -->
						<input type="submit" value="전송">
						
						<!-- TODO 03_01 회원가입 화면으로 이동 UserController signupForm.do -->
						<input type="button" value="회원가입" onclick="location.href='./signupForm.do'">
						<!-- TODO 05_01 아이디 찾기 window.open UserController findId.do -->
						<input type="button" value="아이디찾기" onclick="findId()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
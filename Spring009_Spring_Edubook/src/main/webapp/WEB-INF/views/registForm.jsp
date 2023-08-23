<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript">
	function duplicateId(){
		var url = "./duplicateId.do";
		var title = "아이디 중복 확인";
		var attr = "width=500px, height=500px";
		window.open(url,title,attr);
	}
	
</script>
</head>
<body>
	<div class="container">
		<h2>회원가입화면</h2>
		<div class="form-group">
			<label class="form-label col-sm-2" for="id">아이디</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="id" placeholder="아이디 입력" name="id" readonly="readonly">
				<input type="button" class="btn btn-success" value="중복확인" onclick="duplicateId()">
			</div>
		</div>
		<div class="form-group">
			<label class="form-label col-sm-2" for="name">성명</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name" placeholder="이름 입력" name="name">
			</div>
		</div>
		<div class="form-group">
			<label class="form-label col-sm-2" for="password">비밀번호</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password" placeholder="비밀번호 입력" name="password">
			</div>
		</div>
		<div class="form-group">
			<label class="form-label col-sm-2" for="pwdChk">비밀번호 확인</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="pwdChk" placeholder="비밀번호 확인">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">가입</button>
				<button type="button" class="btn btn-default" onclick="location.href='./main.do'">취소</button>
			</div>
		</div>
	</div>
</body>
</html>
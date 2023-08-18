<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
${param.chkVal}
<div class="container">
	<h2>답글 입력 폼</h2>
	<form action="./replyInsert.do" method="post">
		<input type="hidden" name="seq" value="${param.chkVal}">
		<div class="form-group">
			<label for="id">작성자</label>
			<input type="text" id="id" class="form-control" name="id" value="${sessionScope.loginVo.id}">
		</div>
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" id="title" class="form-control" name="title">
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" rows="5" id="content" name="content"></textarea>
		</div>
		<div>
			<input class="btn btn-success" type="submit" value="답글입력">
			<input class="btn btn-info" type="reset" value="초기화">
			<input class="btn btn-danger" type="button" value="취소" onclick="javascript:history.back(-1)">
		</div>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD &amp; 트랜잭션 연습 중</title>
</head>
<body>
<!--T TODO 06_03 처리된 결과를 EL로 출력한다 -->
 	${lists}
 	<hr>
 	
<!-- TODO 07_01 Controller에 POST 방식으로 id, title, context의 name으로 요청을 보낸다 -->
<fieldset>
	<legend>기본 Prameter 처리 DTO/VO</legend>
	<form action="./insertBoard.do" method="POST">
		<input type="text" name="id" value="B001">
		<input type="text" name="title" value="비가 올 거 같아요">
		<input type="text" name="content" value="오늘은 일찍 가세요">
		<input type="submit" value="전송">
	</form>
</fieldset>

<!-- 
	TODO 08_01 Bind되는 값의 객체(DTO/VO)가 없는 경우 java.util.Map을 통해서 Key:value의 형태 
	Key는 name, value는 value	
-->
<fieldset>
	<legend>기본 Prameter 처리 DTO/VO</legend>
	<form action="./insertBoardMap.do" method="POST">
		<input type="text" name="id" value="B002">
		<input type="text" name="title" value="Map으로 받아주세요">
		<input type="text" name="content" value="Map 객체로도 받을 수 있어용">
		<input type="submit" value="전송">
	</form>
</fieldset>

<!-- TODO 09_01 @RequestParam을 통한 param의 유효값 제어 -->
<fieldset>
	<legend>@RequestParam</legend>
	<p>
		화면에서 요청되는 name값을 변경하여 처리할 수 있다.<br>
		예를 들어 화면의 name이 pw라고 전송이 되고
		서버사이드에서 password의 name을 필요로 함<br>
		Strping password = request.getParameter("pw");
	</p>
	<p>
		문제점 해결<br>
		화면에서의 요청은 모두 문자열(String)이기 때문에 name이 없으면 null이 발생함<br>
		null이면 받는 값이 int로 bind되면 null 형변환에 문제가 발생
	</p>
	<form action="./insertBoardRequestParam.do" method="POST">
		<input type="text" name="a" value="B003">
		<input type="text" name="b" value="감기조심하세요">
		<input type="text" name="c" value="몸이 건강해야 공부도 잘 돼요">
		<input type="submit" value="전송">
	</form>
</fieldset>

<!-- TODO 10_01 @PathVaiable 요청되는 주소의 특정부분은 값으로 사용할 수 있다. -->
<fieldset>
	<legend>주소값을 Parameter 값으로 처리</legend>
	<form action="./com/min/edu/loging/paramValue.do" method="get">
		<input type="submit" value="주소처리 전송">
	</form>
</fieldset>

<!-- TODO 11_01 Transaction 처리 -->
<fieldset>
	<legend>Transaction Annotation 처리</legend>
	<form action="./transation.do" method="POST">
		<input type="text" name="id" value="B004">
		<input type="text" name="title" value="매운 갈비찜">
		<input type="text" name="content" value="태풍에는 매운 갈비찜">
		<input type="submit" value="전송">
	</form>
</fieldset>
</body>
</html>
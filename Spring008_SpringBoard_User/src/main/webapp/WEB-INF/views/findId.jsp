<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- TODO 05_03 아이디 찾기 rest 처리 화면 -->
<title>아이디 찾기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
/* 	$(document).ready(function(){
		document.getElementById("btnUseId").style.display="none";
	});
	
	function findId(){
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		console.log("findId 함수", name, email);
		if(name != "" && email !=""){
			$.ajax({
				url : "./findIdAjax.do",
				type:"post",
				data: {
					"name":name,
					"email":email
				},
				async: true,
				success:function(msg){
					console.log("Ajax 성공 :", msg)
 					if(msg==""){
						document.getElementById("condition").innerHTML="아이디가 없습니다.";
						document.getElementById("btnUseId").style.display="none";
					} else {
						document.getElementById("condition").innerHTML="아이디는 ["+msg+"] 입니다.";
						document.getElementById("btnUseId").style.display="block";
						document.getElementById("id").value = msg;
					} 
				},
				error: function(){
					alert("잘못된 요청값");
				}
			})
		}
	}
	
	function useId(){
		var id = document.getElementById("id").value;
		opener.document.getElementById("id").value=id;
		opener.document.getElementById("id").onclick = "";
		window.close();
	} */
	
	function findId(){
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		var info = document.getElementById("condition");
		
		// 이메일 정규화 표현
		var regex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		
		console.log(name, email);
		console.log(email.match(regex));
		if(email.match(regex)){
			$.ajax({
				url:"./findIdAjax.do",
				type:"post",
				async:true,
				data:{"name":name, "email":email},
				success:function(msg){
					console.log("요청된 결과 값 : ", msg);
					if(msg==""){
						info.innerHTML = "아이디를 찾을 수 없습니다.";
					} else {
						info.innerHTML = "회원님의 아이디는 ["+msg+"] 입니다.";
					}
				},
				error:function(){
					alert("잘못된 요청입니다. 관리자에게 문의하세요")
				}
			})
		} else {
			info.innerHTML = "email 형식이 아닙니다";
		}
	}
</script>
</head>
<body>
	<div class="container">
<!-- 		<h4>아이디 찾기</h4>
		<h3>이름 입력</h3>
		<input type="text" id="name" class="form-control">
		<h3>이메일 입력</h3>
		<input type="text" id="email" class="form-control">
		<input type="button" value="확인" class="btn btn-success" onclick="findId()">
		<input type="button" value="사용하기" class="btn btn-info" id="btnUseId" onclick="useId()"> -->
		이름:<input type="text" id="name"><br>
		이메일:<input type="text" id="email">
		<input type="button" onclick="findId()" value="아이디 찾기"><br>
		<input type="button" onclick="self.close()" value="창 닫기">
	</div>
	<div id="condition"></div>
	<input type="hidden" id="id" value="">
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- TODO 04_04 아이디 중복 검사 -->
<title>중복검사</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- TODO 04_05 id값을 Rest Ajax UserController로 전송 duplicationAjax.do -->
<!-- TODO 04_REST 처리 결과에 따라 아이디 사용여부 버튼 노출 -->
<!-- TODO 04 사용버튼을 누르면 값을 부모의 창으로 이동 -->
<script type="text/javascript">
	$(document).ready(function(){
		/* $("#btnUseId").css("display", "none"); */
		document.getElementById("btnUseId").style.display="none";
	});
	
	function checkId(){
		var id = document.getElementById("id").value;
		console.log("checkId 함수", id);
		if(id != ""){
			$.ajax({
				url : "./duplicationAjax.do",
				type:"post",
				data: "checkId="+id,
				async: true,
				success:function(msg){
					console.log("Ajax 성공 :", msg)
					if(msg=="true"){
						document.getElementById("condition").innerHTML="사용할 수 없습니다.";
						document.getElementById("btnUseId").style.display="none";
					} else {
						document.getElementById("condition").innerHTML="사용할 수 있습니다.";
						document.getElementById("btnUseId").style.display="block";
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
	}
</script>
</head>
<body>
	<div class="container">
		<h4>아이디 중복 확인</h4>
		<h4>ID를 입력해주세요</h4>
		<input type="text" id="id" class="form-control">
		<input type="button" value="확인" class="btn btn-success" onclick="checkId()">
		<input type="button" value="사용하기" class="btn btn-info" id="btnUseId" onclick="useId()">
	</div>
	<div id="condition"></div>
</body>
</html>
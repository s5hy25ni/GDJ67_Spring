<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
	window.onload=function(){
		document.getElementById("useId").style.display="none";
	}
	function checkId(){
		var id = document.getElementById("id").value;
		$.ajax({
			url:"./duplicateAjax.do",
			type:"post",
			async:true,
			data:"chkId="+id,
// 			dataType:"json",
			success:function(msg){
// 				console.log("값:", msg.isc, "반환된 타입:", typeof msg);
// 				console.log("JSON ID", msg.isc.id);
// 				console.log("JSON NAME", msg.isc.name);
				
// 				var convertJSON = JSON.parse(msg);
// 				console.log("값:", convertJSON.isc, "반환된 타입:", typeof convertJSON);
				
				if(msg.isc == "true"){
					document.getElementById("msg").innerHTML="사용가능";
					document.getElementById("useId").style.display="block";
				}else{
					document.getElementById("msg").innerHTML="사용불가";
					document.getElementById("useId").style.display="none";
				}
			},
			error:function(){
				alert("잘못된 요청처리");
			}
		});
	}
	
	function userId(){
		var id = document.getElementById("id").value;
		opener.document.getElementById("id").value=id;
		self.close();
	}
</script>
</head>
<body>
	<div>
		<input type="text" id="id" placeholder="아이디를 입력해주세요">
		<input type="button" value="Ajax확인" onclick="checkId()">
	</div>
	<div>
		<input type="button" value="사용" id="useId" onclick="userId()">
	</div>
	<div id="msg">
	</div>
</body>
</html>
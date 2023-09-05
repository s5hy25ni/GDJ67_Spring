<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript">

	$.ajax({
		type:"get",
		url:"./search.do",
		success: function(data){
			$('#result').text(data);
		}
		error: function(){
			alert("getContent.do 잘못된 요청입니다.");
		}
	});
</script>
</head>
<body>
	<div id="result"></div>
</body>
</html>
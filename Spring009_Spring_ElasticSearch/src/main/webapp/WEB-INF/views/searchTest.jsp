<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SQL 서치 테스트</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $('form').on('submit', function (event) {
        event.preventDefault();

        var subject = $("#subject").val();
        var nickname = $("#nickname").val();
		
        console.log(subject);
        console.log(nickname);

        $.ajax({
        	 url: "./searchTest.do",
        	    method: "post",
        	    dataType: 'json',
        	    data: {subject: subject,
        	    	   nickname: nickname},
        	    success: function (response) {
        	    	 var $results = $("#searchResults");
             	    $results.empty(); // 이전 검색 결과를 지움

             	    if (response.length === 0) {
             	        $results.append("<p>검색 조건에 해당하는 강사를 찾을 수 없습니다.</p>");
             	    } else {
             	        response.forEach(function(teacher) {
             	        	var introduction = teacher["introduction"];
            	            var name = teacher["nickname"];
            	            var location = teacher["available_location"];
            	            var subject = teacher["subject"];
            	            var age = teacher["age"];
            	            $results.append("<p>강사 이름: " + name + " | 소개: " + introduction + " | 과목: " + subject + "| 나이: "+ age +"</p>");
            	       });
             	    }
        	    },
        	    error: function(){
        	        alert("오류");
        	    }
        });
	});
});	

</script>
</head>
<body>
	<form id="searchForm">
		    <label for="subject"> 과목명:</label>
		    <input type="text" id="subject" name="subject">
		    <label for="subject"> 닉네임:</label>
		    <input type="text" id="nickname" name="nickname">
		    <input type="submit" value="검색">
	</form>
<hr>
 <div id="searchResults">
 </div>
</body>
</html>
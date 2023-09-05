<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PDF 파일 업로드 및 PNG 변환</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('form').on('submit', function(event) {
        event.preventDefault(); // 기본 form 제출 동작 중단

        var formData = new FormData(this); // form 데이터 생성
        
        if ($('input[type=file]')[0].files.length === 0) {
            alert("파일을 선택해주세요.");
            event.preventDefault(); 
            return;
        }

        $.ajax({
            url: './upload.do',
            type: 'POST',
            data: formData,
            processData: false,  // 필수 옵션
            contentType: false,  // 필수 옵션
            success: function(response) {
            	$("#loading").hide();
                if (response.errorMessage) {
                    alert(response.errorMessage);  // 에러 메시지가 있다면 표시
                } else {
                    alert("관리자에게 승인 요청되었습니다");  // 성공 메시지 표시
                    window.history.back();
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
            	$("#loading").hide();
                console.error(textStatus + " " + errorThrown);
                alert("오류가 발생했습니다");
            }
        });
    });
});

$(document).ajaxStart(function() {
    $("#loading").show(); // AJAX 요청이 시작되면 로딩 이미지를 보여줍니다.
}).ajaxStop(function(){});
</script>

</head>
<body>

	<form action="./upload.do" method="post" enctype="multipart/form-data">
		<h3>업로드할 PDF 파일</h3>
		<input type="file" name="file"><br>
		<input type="submit" value="업로드">
	</form>

	<div align="center" id="loading" style="display: none;">
		잠시만 기다려주세요...
	 <img src="./img/파일리.gif" alt="Loading..." />
	</div>
</body>
</html>
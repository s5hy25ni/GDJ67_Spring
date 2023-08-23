<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드 화면</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<!-- 
	■ form tag의 enctype 속성
	1. application/x-www-form-urlencoded : (default)
	2. multipart/form-data : fileupload 문자+데이터(post)
	3. text/plain : encode를 하지 않음
	
	■ 파일업로드 Ajax 사용방법
	var frm = document.forms[0];
	var formdata = new FormData();
	
	var files = document.querySelector("input[type=file]")[0];
	var formdata = new FormData();
	formdata.append("uploadFile",files);
	
	$.ajax({
		url:,
		enctype: "multipart/form-data",
		processData: false, //서버로 전송될 데이터가 쿼리스트링으로 되어있는지 여부를 체크
		contentType: false,
		data: formdata, //ajax는 html의 form의 데이터를 전송하지 못하기 때문에 new Formdata()를 통해서 감싸서 처리함
		type: post,
		success: function(msg){}
	});
-->
<body>
	<form action="./upload.do" method="post" enctype="multipart/form-data">
		<h3>업로드할 파일</h3>
		파일 : <input type="file" name="file"><br>
		설명 : <br>
		<textarea rows="10" cols="40" name="desc" class="content"></textarea>
		<input type="submit" value="전송">
	</form>
	
	<fieldset>
		<legend>AJAX를 통한 이미지 업로드 및 미리보기</legend>
		<div>
			<input type="file" class="hidden_input" id="reviewImageFileOpenInput" accept="image/*" multiple>
		</div>
		<div>
			<ul class="list_thumb">
				
			</ul>
		</div>
	</fieldset>
	<script type="text/javascript">
		window.onload = function(){
			document.getElementById("reviewImageFileOpenInput").onchange = function(){
				console.log("버튼 변화");
				var imgFile = this.value.toLowerCase();
				var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp)$/; // .앞에 모든 값을 선택 \.다음값
				var maxSize = 5*1024*1024;
				var fileSize = document.getElementById("reviewImageFileOpenInput").files[0].size;
				
				console.log(imgFile, fileForm, maxSize, fileSize);
				var chkImg = imgFile.match(fileForm);
				console.log(chkImg, fileSize);
				
				if(!chkImg){
					alert("이미지 파일만 업로드 가능합니다");
					return;
				}
				if(maxSize < fileSize){
					alert("용량이 너무 큽니다 (5MB 이하만 가능)");
					return;
				}
				
				readUrl(this);
			}
		}
		function readUrl(input){
			const target = document.getElementById("reviewImageFileOpenInput");
			const fileLength = target.files.length;
			console.log("파일의 검색", target.files);
			$.each(target.files, function(index,file){
				var reader = new FileReader();
				reader.onload = function(e){
					var info = e.target.result;
					console.log("result: ",info);
					let reviewImg = "";
					reviewImg += "<li class='item' style=''>";
					reviewImg += "<a href='#' class='anchor'>";
					reviewImg += "	<span class='submitImg'>전송</span>";
					reviewImg += "</a>";
					reviewImg += "<img src='"+e.target.result+"' width='130px' class='item_thumb'>";
					reviewImg += "<span class='img_border'></span>";
					reviewImg += "</li>";
					
					$(".list_thumb").append(reviewImg);
				}
				reader.readAsDataURL(file);
			});
		}
		
		//화면이 처음에 구성되어 있지 않은 이벤트는 선언을 해도 작동이 되지 않는다. 버블링 방식을 사용해야 한다
// 		document.querySelector(".submitImg").onclick = function(){
// 			console.log("submitImg 작동");
// 		}
		
// 		1) jquery 방식 on을 통한 이벤트
// 		$(document).on("click",".submitImg", function(){
// 			console.log("동적 TAG 실행");
// 			imageSubmit();
// 		});

// 		2) javascript 버블링으로 처리
		document.querySelector(".list_thumb").addEventListener("click",function(){imageSubmit();});
		
		function imageSubmit(){
			let content = document.querySelector(".content").value;
			let reviewImageFileOpenInput = document.getElementById("reviewImageFileOpenInput").files;
			console.log("content", content);
			console.log("reviewImageFileOpenInput", reviewImageFileOpenInput);
			
			let formdata = new FormData();
			
			if(reviewImageFileOpenInput.length >= 1){
				for(var i in reviewImageFileOpenInput){
					formdata.append("file", reviewImageFileOpenInput[i]);	
				}
			}
			formdata.append("desc", content);
			
			console.log(formdata.get("desc"));
			
			$.ajax({
				url:"./uploadAjax.do",
				type:"post",
				async: false,
				data: formdata,
				contentType:false,
				processData: false,
				dataType: 'json',
				success: function(msg){
					console.log(msg);
				},
				error: function(request, status, error){
					console.log(request, error);
				}
			});
		}
	</script>
</body>
</html>
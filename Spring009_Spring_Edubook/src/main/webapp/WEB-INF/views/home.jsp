<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spring Edubook 페이지 home.do</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<select id="lang" onchange="langChange()">
	<option value="ko" ${param.lang == "ko"?"selected":""}>한국어</option>
	<option value="en" ${param.lang == "en"?"selected":""}>영어</option>
</select>
<script type="text/javascript">
	window.onload = function(){
		var desc = document.getElementById("description");
		var descBtn = document.getElementById("descBtn");
		descBtn.onclick=function(){
			if(desc.style.display == "none"){
				desc.style.display = "block";
				descBtn.textContent = "설명닫기";
			} else {
				desc.style.display = "none";
				descBtn.textContent = "설명열기";
			}
		}
	}
	function langChange(){
		var lange = document.getElementById("lang");
		var choiceValue = lang.options[lang.selectedIndex].value;
		console.log("선택된 언어 : ", choiceValue);
		location.href="./main.do?lang="+choiceValue;
	}
</script>
<div class="container">
	<form action="./login.do" method="POST">
		<table class="table">
			<tr class="warning">
				<th><spring:message code="label.id"/></th>
				<td>
					<input type="text" name="id" required="required">
				</td>
			</tr>
			<tr>
				<th><spring:message code="label.password"/></th>
				<td>
					<input type="password" name="password" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input class="btn btn-warning" type="submit" value='<spring:message code="label.login"/>'>
					<input class="btn btn-info" type="button" value="회원가입 Ajax">
					<input class="btn btn-info" type="button" value="회원가입 formValidation">
				</td>
			</tr>
		</table>
	</form>
	
	<!-- HttpSession과 @SessionAttribute 설명 -->
	<fieldset>
		<legend>HttpSession과 @SessionAttribute 설명</legend>
		<a class="btn btn-success" href="./sessionInit.do">Session_1_Controller 이동</a>
		<button id="descBtn">설명열기</button>
		<div id="description">
			<pre>
				※ @SessionAttribute는 HttpSession을 사용할 때 @ModelAttribute와 이름을 같게 해야 한다.
					request scope가 아닌 sessionScope에 값을 저장할 수 있도록 함
				※ @SessionAttribute는 4.3버전 이상에서 추가된 Bind Annotation HttpSession에 저장
					저장 값을 타입 컨버팅을 쉽게 할 수 있도록 함
				◆ init.do에 의해서 HttpSession(:httpsessionTest), @SessionAttribute(:sessionTest)
					-> sessionCheck.jsp 출력
				◆ 같은 Controller의 HttpSession과 @SessionAttribute
					2) test01 > @SessionAttribute를 삭제하는 sessionStatus.setComplete();
								test01.do
					3) test02 > HttpSession을 삭제하는 session.invalidate();
								test02.do
				◆ 다른 Controller의 HttpSession과 @SessionAttribute
					4) test03 > @SessionAttribute를 삭제하는 sessionStatus.setComplete();
								test03.do
					5) test04 > HttpSession을 삭제하는 session.invalidate();
								test04.do
				
				■ 시나리오 및 결과 (HttpSession:h, @SessionAttribute:@)
				1. 같은 컨트롤러
					1) init.do(h/@생성) -> result01, result02 확인 -> h/@ 모두 사용 가능
					2) init.do(h/@생성) -> test01을 통해서 @만 삭제 -> h는 정상출력/@는 오류 발생
					3) init.do(h/@생성) -> test02을 통해서 h만 삭제 -> h는 null/@는 정상 출력
				2. 다른 컨드롤러
					1) init.do(h/@생성) -> result03, result04 확인 -> h/@ 모두 다른 컨트롤러에서도 같은 호출 방식으로 사용 가능
					2) init.do(h/@생성) -> test03을 통해서 @만 삭제 -> h/@ 모두 사용 가능
					3) init.do(h/@생성) -> test04을 통해서 h만 삭제 -> h/@ 모두 삭제
				
				<========================================================================================================>
					최종 결론 : 생성된 클래스가 아닌 다른 Controller에서는 HttpSession의 session.invalidate()를 통해서 
							모든 HttpSession과 @SessionAttribute로 생성된 객체를 삭제할 수 있다.
				<========================================================================================================>
			
			</pre>
		</div>
	</fieldset>
	<fieldset>
		<legend>SMTP Email 보내기</legend>
		<a class="btn btn-sucess" href="./mailForm.do">메일보내기</a>
	</fieldset>
	<fieldset>
		<legend>파일업로드 commons-fileupload</legend>
		<a class="btn btn-success" href="./uploadForm">파일업로드 작성화면</a>
	</fieldset>
</div>
</body>
</html>

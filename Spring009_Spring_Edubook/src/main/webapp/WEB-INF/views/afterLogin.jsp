<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 후 화면</title>
<style type="text/css">
	#page{
		width: 900px;
		margin: 0 auto;
	}
	#header{
		background:burlywood;
		text-align: center;
	}
	#header>h1, #header>div{
		display: inline-block;
		line-height: 40px;
	}
	#nav li{
		display: inline-block;
		background-color: lightcyan;
		height: 30px;
		text-align: center;
		line-height: 30px;
		margin-right: 10%;
	}
	#aside{
		border: 1px solid tan;
		width: 20%;
		min-height: 500px;
		float: left;
		line-height: 100px;
		padding-left: 10px;
	}
	
	#aside ul, li{
		list-style: none;
	}
	
	#section{
		border: 1px solid tan;
		min-height: 500px;
		margin-left: 200px;
	}
	
	#footer{
		clear: both;
		height: 80px;
		background: burlywood;
	}
	
	#footer p{
		text-align: center;
		line-height: 80px;
	}
</style>
</head>
<body>
	<div id="page">
		<header id="header">
			<h1>헤더영역</h1>
			${sessionScope.loginVo.name}님 반갑습니다
			<c:if test="${loginVo.auth eq 'A'}">
				<div>[관리자 모드]</div>
			</c:if>
			<div>
				<a href="#">[게시판 보기]</a>
			</div>
			<div>
				<a href="./logout.do">[로그아웃]</a>
			</div>
		</header>
		<nav id="nav">
			<ul>
				<li>회사소개</li>
				<li>제품소개</li>
				<li>채용정보</li>
				<li>고객센터</li>
			</ul>
		</nav>
		<aside id="aside">
			<div>
				<ul>
					<li>회사연혁</li>
					<li>협력사</li>
					<li>매출</li>
				</ul>
			</div>
		</aside>
		<section id="section">
			<div>
				전달받은 Model 및 HttpSession값 확인
				<ul>
					<li>model loginVo값 : ${requestScope.loginVo.name}</li>
					<li>HttpSession loginVo값 : ${sessionScope.loginVo.name}</li>
				</ul>
			</div>
			<br>
			<div>
				콘텐츠메뉴
				<ul>
					<li><a href="./sessionInit.do">HttpSession의 값을 사용해보자</a></li>
				</ul>
			</div>
		</section>
		<footer id="footer">
			<div id="copy">
				<p>copyright&copy;kor</p>
			</div>
		</footer>
	</div>
</body>
</html>
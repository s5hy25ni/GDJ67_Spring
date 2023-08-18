<%@page import="com.min.edu.vo.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var btn = "";
	$(document).ready(function(){
		$("button[name=btnChk]").click(function(){
			btn = $(this).attr("value");
		});
	});
	
	function checkBox(){
		var chks = document.getElementsByName("chksId");
		var data = $("#form").serialize();
		data += "&btnChk="+btn;
		console.log(data);
		return false;
	}
</script>
</head>
<body>
<%
	List<UserVo> lists = (List<UserVo>)request.getAttribute("lists");
%>
	<div class="container">
		<h1>회원관리</h1>
		<form action="./managementUser.do" id="form" method="post" name="form" onsubmit="return checkBox()"> 
			<table class="table table-hover">
				<thead>
					<tr>
						<th><input type="checkbox" onclick="allChk(this.checked)"></th>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
						<th>권한</th>
						<th>활성화여부</th>
						<th>가입일</th>
					</tr>
				</thead>
				<tbody>
						<%
							for(UserVo vo : lists){
								%>
								<tr>
									<td><input type="checkbox" name="chksId" value="<%=vo.getId()%>"></td>
									<td><%=vo.getId()%></td>
									<td><%=vo.getName()%></td>
									<td><%=vo.getEmail()%></td>
									
									<%
										if(vo.getAuth().equalsIgnoreCase("U")){
											%>
											<td>일반</td>
											<%
										} else {
											%>
											<td>관리자</td>
											<%
										}
									%>
									
									<%
										if(vo.getDelflag().equalsIgnoreCase("N")){
											%>
											<td>활동</td>
											<%
										} else {
											%>
											<td>중지</td>
											<%
										}
									%>
									
									<td><%=vo.getJoindate()%></td>
									
								</tr>
								<%
							}
						%>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="7" style="text-align:center;">
							<button name="btnChk" value="toAuth">관리자로 변경</button>
							<button name="btnChk" value="toUser">일반 사용자로 변경</button>
							<button name="btnChk" value="inactiveUser">활성화</button>
							<button name="btnChk" value="activeUser">비활성화</button>
							<input type="submit" value="serialize테스트">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<!-- TODO 14_03 전체 게시글 출력 boardList.jsp -->
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/boardListPage.js"></script>
<script type="text/javascript" src="./js/boardListEvent.js"></script>
<title>게시글 출력</title>
</head>
<body>
<button onclick="location.href='./logout.do'">로그아웃</button>
${loginVo}<br>
${page}
<br>
<div class="container">
	<form>
		<table class="table table-hover">
			<thead>
				<tr class="info">
					<c:if test="${loginVo.auth eq 'A'}">
						<td>
							<input type="checkbox" class="allCheck" id="allCheck" onclick="checkAll(this.checked)">
						</td>
					</c:if>
						<td>글번호</td>
						<td>작성자</td>
						<td>제목</td>
					<c:if test="${loginVo.auth eq 'A'}">
						<td>삭제여부</td>
					</c:if>
						<td>작성일</td>
				</tr>
			</thead>
			
		<!-- TODO 18_09 전달된 게시글의 정보 List Row를 출력 -->
<!-- 		<tbody> -->
<%-- 			<c:forEach var="vo" items="${lists}" varStatus="vs"> --%>
<!-- 				<tr> -->
<%-- 					<c:if test="${loginVo.auth eq 'A'}"> --%>
<!-- 						<td> -->
<%-- 							<input type="checkbox" name="delCheck" value="${vo.seq}"> --%>
<!-- 						</td> -->
<%-- 					</c:if> --%>
<%-- 					<td>${vs.index}</td> --%>
<%-- 					<td>${vo.id}</td> --%>
<!-- 					<td> -->
<%-- 						<c:set var="title" value="${vo.title}"/> --%>
<%-- 						${title.replaceAll('<img>',"<img src='./images/reply.png'>") } --%>
<!-- 					</td> -->
<%-- 					<c:if test="${loginVo.auth eq 'A'}"> --%>
<%-- 						<td>${vo.delflag}</td> --%>
<%-- 					</c:if> --%>
<!-- 					<td> -->
<%-- 						${vo.regdate} --%>
<!-- 					</td> -->
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 		</tbody> -->
		
		<!-- TODO 18_10 전달된 페이지의 정보를 상태에 따라서 출력 -->
<!-- 		<tfoot style="text-align: center;"> -->
<!-- 			<tr> -->
<%-- 				<td colspan="${loginVo.auth eq 'A' ? '6' : '4'}"> --%>
<!-- 					<ul class="pagination pagination-lg"> -->
<%-- 						<c:if test="${page.stagePage > 1}"> --%>
<!-- 							<li><a href="#" onclick="pageFirst()"><span class="glyphicon glyphicon-fast-backward"></span></a></li> -->
<%-- 							<c:if test="${page.stagePage - page.countPage >= 0}"> --%>
<%-- 								<li><a href="#" onclick="pagePrev(${page.stagePage}, ${page.countPage})"><span class="glyphicon glyphicon-step-backward"></span></a></li> --%>
<%-- 							</c:if> --%>
<%-- 						</c:if> --%>
						
<%-- 						<c:forEach var="i" begin="${page.stagePage}" end="${page.endPage}" step="1"> --%>
<%-- 							<li ${page.page == i ? 'class=active':''}><a href="javascript:page(${i})">${i}</a></li> --%>
<%-- 						</c:forEach> --%>
						
<%-- 						<c:if test="${page.page < page.totalPage}"> --%>
<%-- 							<c:if test="${page.stagePage+page.countPage < page.totalCount}"> --%>
<%-- 								<li><a href="#" onclick="pageNext(${page.stagePage}, ${page.countPage})"><span class="glyphicon glyphicon-step-forward"></span></a></li> --%>
<%-- 							</c:if> --%>
<%-- 							<li><a href="#" onclick="pageLast(${page.totalPage})"><span class="glyphicon glyphicon-fast-forward"></span></a></li> --%>
<%-- 						</c:if> --%>
<!-- 					</ul> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 		</tfoot> -->
		<!--
			TODO 19_01 SPA 처리를 위한 bootstrap collapse accordion
				https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_collapsible_accordion&stacked=h
		-->
			<tbody>
				<c:forEach var="vo" items="${lists}" varStatus="vs">
					<tr>
						<c:if test="${loginVo.auth eq 'A'}">
							<td><input type="checkbox" name="delCheck" value="${vo.seq}"></td>
						</c:if>
							<td>${page.totalCount - (page.page-1) * page.countList - vs.index}</td>
							<td>${vo.id}</td>
							
							<td>
								<div class="panel-heading">
									<a data-toggle="collapse" data-parent="#accordion" href="#collapse${vo.seq}">
										<c:set var="title" value="${vo.title}"/>
										${title.replaceAll("<img>","<img src='./images/reply.png'>")}
									</a>
								</div>
							</td>
							<c:if test="${loginVo.auth eq 'A'}">
								<td>${vo.delflag}</td>
							</c:if>
							<td>
								<fmt:parseDate var="patternDate" value="${vo.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
								<fmt:formatDate value="${patternDate}" pattern="yyyy년 MM월 dd일"/>
							</td>
					</tr>
					<tr>
						<td colspan="${loginVo.auth eq 'A' ? 6 : 4}">
							<div id="collapse${vo.seq}" class="panel-collapse collapse">
								<div class="form-group">
									<label>내용</label>
									<textarea rows="4" class="form-control" readonly>${vo.content}</textarea>
								</div>
								<div>
									<c:if test="${vo.id eq loginVo.id}">
										<input type="button" class="btn btn-primary" value="수정" onclick="modify('${vo.seq}')">
									</c:if>
									<c:if test="${vo.id eq loginVo.id || loginVo.auth eq 'A'}">
										<input type="button" class="btn btn-danger" value="삭제" onclick="del('${vo.seq}')">
									</c:if>
									<c:if test="${loginVo.auth eq 'U'}">
										<input type="button" class="btn btn-success" value="답글" onclick="reply('${vo.seq}')">
									</c:if>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
			<tfoot style="text-align: center;">
				<tr>
				<td colspan="${loginVo.auth eq 'A' ? '6' : '4'}">
					<ul class="pagination pagination-lg">
						<c:if test="${page.stagePage > 1}">
							<li><a href="#" onclick="pageFirst()"><span class="glyphicon glyphicon-fast-backward"></span></a></li>
							<c:if test="${page.stagePage - page.countPage >= 0}">
								<li><a href="#" onclick="pagePrev(${page.stagePage}, ${page.countPage})"><span class="glyphicon glyphicon-step-backward"></span></a></li>
							</c:if>
						</c:if>
						
						<c:forEach var="i" begin="${page.stagePage}" end="${page.endPage}" step="1">
							<li ${page.page == i ? 'class=active':''}><a href="javascript:page(${i})">${i}</a></li>
						</c:forEach>
						
						<c:if test="${page.page < page.totalPage}">
							<c:if test="${page.stagePage+page.countPage < page.totalCount}">
								<li><a href="#" onclick="pageNext(${page.stagePage}, ${page.countPage})"><span class="glyphicon glyphicon-step-forward"></span></a></li>
							</c:if>
							<li><a href="#" onclick="pageLast(${page.totalPage})"><span class="glyphicon glyphicon-fast-forward"></span></a></li>
						</c:if>
					</ul>
				</td>
			</tr>
			</tfoot>
		</table>
	</form>
</div>
<!-- TODO 21_08 글 수정 작성을 위한 Modal 영역 작성 -->
  <div class="modal fade" id="modify" role="dialog">
    <div class="modal-dialog modal-sm">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">글수정</h4>
        </div>
        <div class="modal-body">
          <form method="post" id="frmModify">
          	<input type="text">

          </form>
        </div>
      </div>
    </div>
  </div>
  
 <!-- TODO 22_08 답글을 위한 Modal 영역 작성 -->
  <div class="modal fade" id="reply" role="dialog">
    <div class="modal-dialog modal-md">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">답글작성</h4>
        </div>
        <div class="modal-body">
          <form method="post" id="frmReply">
          	<input type="text">

          </form>
        </div>
      </div>
    </div>
  </div>
</body>
<!-- TODO 19_02 동적으로 생성된 Element를 선택하여 자신을 제외한 모든 것을 hidden 처리 -->
<script type="text/javascript">
$("table").click(function(){
	console.log("클릭");
	$(".collapse").on("show.bs.collapse", function(){
		$(".collapse.in").collapse('hide');
	});
});
// $("a").on("click", function(){
// 	console.log("작동");
// 	var click = $(this).prop("href");
// 	var id = click.substring(click.lastIndexOf("#")+1);
// 	console.log("id값:",id);
	
// 	var contentRow = $('.panel-collapse');
// 	for(let i=0; i<contentRow.length; i++){
// 		if(id != contentRow[i].id){
// 			contentRow[i].className = "panel-collapse collapse";
// 			contentRow.slideUp();
// 		}
// 	}
	
// });
</script>
</html>
/**
 * TODO 18_11 MPA 방식으로 처리되는 javascript 페이지 클릭 이벤트에 따라 호출되는 함수처리
 */

function pageFirst(){
	location.href = "./boardList.do?page=1";
}

function pagePrev(stagePage, countPage){
	var page = (stagePage - countPage) < 0 ? 1 : (stagePage-countPage);
	location.href = "./boardList.do?page="+page;
}

function page(page){
	location.href="./boardList.do?page="+page;
}

function pageNext(stagePage, countPage){
	location.href="./boardList.do?page="+(stagePage+countPage);
}

function pageLast(totalPage){
	location.href="./boardList.do?page="+totalPage;
}

//TODO 19_03 SPA 방식으로 처리되는 Ajax 이벤트 javascript
function pageFirst(){
	console.log("pageFirst 처음페이지로 이동");
	spa_ajax(1);
}

function pagePrev(stagePage, countPage){
	console.log("pagePrev 이전 페이지 묶음으로 이동");
	var page = (stagePage - countPage) < 0 ? 1 : (stagePage-countPage);
	spa_ajax(page);
}

function page(page){
	console.log("page 현재 선택된 페이지로 이동");
	spa_ajax(page);
}

function pageNext(stagePage, countPage){
	console.log("pageNext 다음 페이지 묶음으로 이동");
	spa_ajax(stagePage+countPage);
}

function pageLast(totalPage){
	console.log("pageLast 끝 페이지로 이동");
	spa_ajax(totalPage);
}

//TODO 19_04 SPA로 처리할 jQuery Ajax 익명함수
var spa_ajax = function(...args){
	var choice_page = args[0];
	console.log("choice_page : ",choice_page);
	
	$.ajax({
		url:"./page.do",
		type:"post",
		async:true,
		data: {"page": choice_page},
		dataType:"json",
		success: function(data){
			console.log(data);
			//TODO 19_06 전달받은 게시글(lists), 페이징(row), 아이디값(memId)를 HTML을 구성하는 각 부분에 innerHTML 해준다
			$.each(data, function(key, value){
				console.log("전달받은 key : ", key);
				var n = $(".table tr:eq(0) td").length;
				var varHtml = "";
				var rowCnt = 0;
				
				if(key == "lists"){
					varHtml += "<thead>                                                                                                    "
					varHtml += "	<tr class='info'>                                                                                      "
					if(n == 6){
					varHtml += "			<td>                                                                                           "
					varHtml += "				<input type='checkbox' class='allCheck' id='allCheck' onclick='checkAll(this.checked)'>    "
					varHtml += "			</td>                                                                                          "
					}
					varHtml += "			<td>글번호</td>                                                                                "
					varHtml += "			<td>작성자</td>                                                                                "
					varHtml += "			<td>제목</td>                                                                                  "
					if(n == 6){
					varHtml += "			<td>삭제여부</td>                                                                              "
					}
					varHtml += "			<td>작성일</td>                                                                                "
					varHtml += "	</tr>                                                                                                  "
					varHtml += "</thead>                                                                                                   "
				
					varHtml += "<tbody>                                                                                                                "
					$.each(value, function(key, v){
					varHtml += "		<tr>                                                                                                           "
					if(n == 6){
					varHtml += "				<td><input type='checkbox' name='delCheck' value='"+v.seq+"'></td>                                     "
					}
					var index = data.row.totalCount -(data.row.page-1)*data.row.countList-rowCnt++;
					varHtml += "				<td>"+index+"</td>                                "
					varHtml += "				<td>"+v.id+"</td>                                                                                      "
					varHtml += "				                                                                                                       "
					varHtml += "				<td>                                                                                                   "
					varHtml += "					<div class='panel-heading'>                                                                        "
					varHtml += "						<a data-toggle='collapse' data-parent='#accordion' href='#collapse"+v.seq+"'>                  "
															let title = v.title;
															if(title.indexOf("<img>") != -1){
																title = title.replace("<img>", "<img src='./images/reply.png'>");
															}
					varHtml += 							title
					varHtml += "						</a>                                                                                           "
					varHtml += "					</div>                                                                                             "
					varHtml += "				</td>                                                                                                  "
					if(n == 6){
					varHtml += "					<td>"+v.delflag+"</td>                                                                             "
					}
					varHtml += "				<td>  "
													let date = new Date(v.regdate);
													let dateFormat = date.toLocaleString();
													let datePrint = `${date.getFullYear()}년도 ${date.getMonth()+1}월 ${date.getDate()}일`;
					varHtml += 							datePrint
					varHtml += "				</td>                                                                                                  "
					varHtml += "		</tr>                                                                                                          "
					varHtml += "		<tr>                                                                                                           "
					varHtml += "			<td colspan='"+n+"'>                                                              "
					varHtml += "				<div id='collapse"+v.seq+"' class='panel-collapse collapse'>                                           "
					varHtml += "					<div class='form-group'>                                                                           "
					varHtml += "						<label>내용</label>                                                                            "
					varHtml += "						<textarea rows='4' class='form-control' readonly>"+v.content+"</textarea>                      "
					varHtml += "					</div>                                                                                             "
					varHtml += "					<div>                                                                                              "
					if(data.memId == v.id){
					varHtml += "							<input type='button' class='btn btn-primary' value='수정' onclick='modify("+v.seq+")'>   "
					}
					if(data.memId == v.id || n == 6){
					varHtml += "							<input type='button' class='btn btn-danger' value='삭제' onclick='del("+v.seq+")'>       "
					}
					if(n != 6){
					varHtml += "							<input type='button' class='btn btn-success' value='답글' onclick='reply("+v.seq+")'>    "
					}
					varHtml += "					</div>                                                                                             "
					varHtml += "				</div>                                                                                                 "
					varHtml += "			</td>                                                                                                      "
					varHtml += "		</tr>                                                                                                          "
					});
					varHtml += "</tbody>                                                                                                               "
					
					varHtml += "<tfoot>                                                                                                               "
					varHtml += "</tfoot>                                                                                                               "
					
				} else {
					varHtml += "<tr>"
					varHtml += "	<td colspan='"+n+"'>                                                                                                        "
					varHtml += "		<ul class='pagination pagination-lg'>                                                                                                                "
					if(value.stagePage > 1){
					varHtml += "				<li><a href='#' onclick='pageFirst()'><span class='glyphicon glyphicon-fast-backward'></span></a></li>                                       "
						if(value.stagePage - value.countPage >= 0){
					varHtml += "					<li><a href='#' onclick='pagePrev("+value.stagePage+", "+value.countPage+")'><span class='glyphicon glyphicon-step-backward'></span></a></li>"
						}
					}
					varHtml += "			                                                                                                                                                 "
					for(let i=value.stagePage; i<=value.endPage; i++){
						let flag = value.page == i ? "class=active":"";
					varHtml += "				<li "+flag+"><a href='javascript:page("+i+")'>"+i+"</a></li>                                                      "
					}
					varHtml += "			                                                                                                                                                 "
					if(value.page < value.totalPage){
						if((value.stagePage+value.countPage) < value.totalCount){
					varHtml += "					<li><a href='#' onclick='pageNext("+value.stagePage+", "+value.countPage+")'><span class='glyphicon glyphicon-step-forward'></span></a></li> "
						}
					varHtml += "				<li><a href='#' onclick='pageLast("+value.totalPage+")'><span class='glyphicon glyphicon-fast-forward'></span></a></li>                        "
					}
					varHtml += "		</ul>                                                                                                                                                "
					varHtml += "	</td>                                                                                                                                                    "
					varHtml += "</tr>"
					
				}
				
				//화면에 HTML을 그려주는 동작
				if(key == "lists"){
					$(".table").html(varHtml);
				} else {
					$("tfoot").append(varHtml);
					$("tfoot").css("text-align","center");
				}
				
			});
		},
		error: function(e){
			console.log("잘못된 요청처리 ",e);
		}
	});
}

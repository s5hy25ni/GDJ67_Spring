var ws = null;
var url = null;
var nick = null;

//채팅을 위한 webSocket 객체를 생성
$(document).ready(function(){
	$(window).on("beforeunload",function(){
		ws.close();
		return "Any Change will be lost";
	});
	
	console.log("그룹 채팅 로딩");
	
	var ws = null;
	var url = location.href; //현재 웹주소
	var checkUrl = "ws:"+url.substring(url.indexOf('//'),url.lastIndexOf('/')+1)+"wsChatGr.do"; //웹소켓 주소
	var nickName = document.querySelector("#nickName>b").textContent;
	var group = document.getElementById("group").textContent;
	console.log(checkUrl, nickName, group);
	
	$(".chat").focus();
	
	//웹소켓 객체를 생성
	ws = new WebSocket(checkUrl);
	console.log("생성된 websocket 객체 : ",ws);
	
	//웹소켓 오픈 후에 send()를 통해서 서버에 Text를 전송 -> handlerTextMessage -> SessionMap
	ws.onopen = function(){
		console.log("웹소켓 오픈");
		ws.send("#&nick_"+nickName); //->handlerTextMessage
	}
	
	ws.onmessage = function(event){
		var msg = event.data;
		console.log("서버로부터 전송된 메시지 : ",msg);
		/*$(".receive_msg").append($("<div class='noticeTxt'>").append(msg+"<br>"));*/
		if(msg.startsWith("<font color=")){ // 입장 퇴장
			$(".receive_msg").append($("<div class='noticeTxt'>").append(msg+"<br>"));
			/*
				참가자 리스트 갱신
			*/
			viewList(group);
		} else if(msg.startsWith("[나]")){ // 내 대화내용
			msg = msg.substring(3);
			$(".receive_msg").append($("<div class='sendTxt'>").append($("<span class='send_img'>").text(msg))).append("<br><br>");			
		} else {
			$(".receive_msg").append($("<div class='receiveTxt'>").append($("<span class='receive_img'>").text(msg))).append("<br><br>");
		}
		$(".receive_msg").scrollTop($(".receive_msg")[0].scrollHeight);
	}
	
	ws.onclose = function(){
		alert("서버와 연결이 종료되었습니다. \n 채팅방이 삭제됩니다.");
	}
	
	$(".chat_btn").bind("click", function(){
		if($(".chat").val()==""){
			alert("내용을 입력해 주세요");
		} else {
			ws.send(nickName+" : "+$(".chat").val());
			$(".chat").val("");
			$(".chat").focus();
		}
	});
	
	// onbeforeunload시 강제 당기가 아니라 닫기 버튼으로 동작시 경고창을 없애기 위함
	var pageClosed = true;
	
});

var roomClose = function(){
	alert("채팅종료");
	$.ajax({
		type:"post",
		url:"./socketOut.do",
		async:true,
		success:function(){
			pageClosed = false;
			self.close();
		}
	});
}

function viewList(grId){
	$(".memList").children().remove();
	$.ajax({
		type:"post",
		url:"./viewChatList.do",
		data: "grId="+grId,
		dataType:"json",
		success:function(result){
			console.log(grId, result.list);
			for(let str in result.list){
				if(grId==result.list[str]){
					$(".memList").prepend("<p style='border-bottom:0.5px solid #b4b4b4;'>"+str+"</p>");
				}
			}
		}
		
	});
}
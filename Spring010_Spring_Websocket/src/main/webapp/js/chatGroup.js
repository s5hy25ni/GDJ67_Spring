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
});
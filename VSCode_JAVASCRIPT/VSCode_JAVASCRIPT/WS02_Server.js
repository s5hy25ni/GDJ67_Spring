// WS02_Client.html과 연결(주소:포트)을 하는 node서버
// node 엔진에 websocket 서버로 동작시키기 위해서 설치
// npm i ws
// 서버의 실행은 WS02_Server.js
// ws의 서버포트 설정 ex) 3000
// 서버의 내용이 중지되면 다시 실행
// ctrl + c
//1) 설치된 패키지를 로드
const Websocket = require('ws');
const wss = new Websocket.Server({port:3000});
//node Event는 .on으로 시작
wss.on('connection',(ws)=>{
    console.log('Server=> Websocket Connection.....');
    ws.send("Hello World");
    ws.on('close', (code, msg)=>{
        console.log(`Server => Websocket Closed.....${code} ${msg}`)
    })
    ws.on('error',(err)=>{
        console.log(`Server => Websocket Error.....${err}`)
    })
    ws.on('message',(evt)=>{
        console.log(`Server Message Broadcast => ${evt}`)
        ws.send("Server Message =>"+evt);
    })
});
"use strict";

function _typeof(o) { "@babel/helpers - typeof"; return _typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (o) { return typeof o; } : function (o) { return o && "function" == typeof Symbol && o.constructor === Symbol && o !== Symbol.prototype ? "symbol" : typeof o; }, _typeof(o); }
//javascript 변수 선언
//javascript 변수의 선언 var는 global 함수입니다.
//node 자체가 실행파일입니다.

var a = 100;
console.log("a=>" + a);

//1) javascript에서는 같은 변수 명으로 하위에 재선언해도 오류가 발생하지 않습니다.
//javascript scope의 문제점, 글로벌 함수를 잘못 선언했습니다.ㅠ

var a = 200;
console.log("a=>" + a);

//2) ES2015(ES6) 버전 이상에서만 지원하는 변수가 추가됩니다, 브라우저마다 지원 여부가 다릅니다. (바벨 io를 사용해서 문법을 변경해줍니다)
//let, const
//let : 지역 변수 선언 및 재입력은 가능하지만 재선언되지 않는다.

var b = "human";
console.log("b=>", b);
b = "robot";
console.log("b=>", b);
//javascript는 동적 변수이기 떄문에 어떤 값이 들어와도 상관 없음
b = 77;
console.log("b=>", b);
// var b = "animal"; // 변수가 동일해서 선언이 안됨, let는 재선언되지 않는다!

//let를 사용하는 이유? : let 변수는 global 영역을 오염시키지 않는다
//익명함수 호출, String으로 변경됨
// let alert = "afternoon";
// console.log(`\n alert=>${alert}, typeof(alert)=>${typeof alert}`);
// window.alert("Hello world"); //웹브라우저의 함수 
// var alert = "afternoon";
// window.alert("Hello world"); //글로벌 함수가 오염되면서 함수가 아니게 됩니다.

//const : 상수를 정의할 때 사용합니다.
//상수로 정의되기 때문에 값을 선언할 때부터 반드시 입력해줘야 하고, 재선언, 재입력 안됩니다
//숫자를 냅다 넣으면 리터럴, new로 선언하면 객체 리터럴
var CONST_VAL = 3.14;
console.log("CONST_VAL=> ".concat(CONST_VAL, ", typeof(CONST_VAL)=> ").concat(_typeof(CONST_VAL)));
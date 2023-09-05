/**
* Arrow Function_화살표 함수 : Java에서는 람다표현식이라고 함
* 화살표 함수 표현 (Arrow Function Expression) 
* 기본 function 표현에 비해서 구문이 짧습니다.
* 자신의 this, arguments super 또한 new.target 바인딩하지 못합니다.

* 화살표 함수는 항상 익명함수입니다.
* 화살표 함수는 메소드가 아닌 함수에서 가장 적절히 사용할 수 있습니다. (복잡한 처리는 어렵습니다)
* 생성자로는 사용이 불가능합니다.
* (param1, param2...) => (문법)
* (param1, param2...) => 표현식
*   ☞ return 표현식

* 매개변수가 하나인 경우 () 선택사항
* (param1) => {}
* param1 => {}
* 매개변수가 없는 경후 필수로 () 처리 해줘야 합니다,
* () => {}
* 
* ES6 문법이다.
*/

(function(){
    //기본 방식의 function 작성
    // var onAdd = function(){
    //     var x = 10, y = 20, result = 0;
    //     result = x+y;
    //     console.log(`${x}+${y}=${result}`);
    // }

    var onAdd = () => {
        var x = 10, y = 20, result = 0;
        result = x+y;
        console.log(`${x}+${y}=${result}`);
    }

    var onMin = (x,y) => {
        var result = x-y;
        console.log(`${x}-${y}=${result}`)
    }

    //매개변수가 없는 경우 () 필수
    //매개변수가 한 개만 있는 경우 () 선택
    var onSample1 = x => {return `${x}*10 = ${x*10}`}

    //함수의 {} 구분의 값이 리턴하는 명령어
    var onSample2 = x => `${x}*10 = ${x*10}`;

    //함수의 구문의 값이 아닌 실행문인 경우 리턴하지 않고 바로 실행될 때
    var onSample3 = x => console.log(`${x}*10 = ${x*10}`);

    onAdd();
    onMin(10,5);


    console.log(onSample1(3));
    console.log(onSample2(4));
    console.log(onSample3(5));
    onSample3(5);

})();
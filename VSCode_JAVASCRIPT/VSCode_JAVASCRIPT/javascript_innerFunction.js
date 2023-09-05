/**
 * innerFunction_내부함수
 * 즉시 실행 함수
 * javascirpt 동적 바인딩 (동적 할당). javascript 타입 Object, Array, Function
 * 즉시 실행 함수는 global 영역을 사용되지 않도록 합니다.
 * 
 * 함수(function)값 global 영역을 재정의하기 때문에 즉시실행함수로 사용하는 것이 좋습니다.
 * 
 * (＃°Д°) 호이스팅(hoisting)?
 *        : 선언된 함수 또는 변수의 수행이 하위에 작성되어 있어도 먼저 실행되는 것
 *        : 방지하려면? 규칙을 가지고 이름이 겹치지 않도록 잘 작성해야 함
 */

( function(){
    onAdd()
    onmin(10, 4)
    function onAdd(){
        var x = 10, y = 20, result = 0;
        result = x+y;
        console.log(`${x} + ${y} = ${result}`)
    }
    function onmin(x,y){
        var result = x+y;
        console.log(`${x} + ${y} = ${result}`);
    }

    //명시적 함수
    function onMulti(x,y){
        var result = x*y;
        return `${x} * ${y} = ${result}`;
    }

    //익명함수
    //함수 리터럴 : function을 값으로 가지고 있음, 함수 자체가 값으로 사용될 수 있음. 함수를 제어할 때 사용
    var onDiv = function(x,y){
        var result = x/y;
        return `${x} / ${y} = ${result}`;
    }
    
    var result = onMulti;
    console.log(result);
    
    var result = onDiv(10, 3);
    console.log(result);
    
})();

console.log(window);
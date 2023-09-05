/**
 * 즉시 실행 함수_Immediatly Invoked Function Expression : 정의하자마자 바로 실행되는 함수
 * class 안에 실행되는 함수를 따로 만들었다고 생각하면 됩니다.
 */

//window의 alert 메소드를 var를 통해 변수로 값을 할당
//전-역 변수
// alert = 10;
console.log(`alert=>${alert}, typeof(alert)=>`+typeof(alert));

//이제는 함수가 아닌 변수임. 따라서 에러가 발생
// alert("hello javascript");

//(✿◡‿◡) javascript의 함수는 {}에 scope를 갖습니다 *****
//이를 이용해서 즉시 실행 함수 형태를 구현할 수 있다 // 연산자 블럭 내에서만 사용 가능

(
    function (){  
        var A = 10;
        console.log('A=>'+A+', typeof(A) =>'+typeof(A));
        console.log(window);
    
        var alert = 10;
        console.log(`alert=> ${alert}, typeof(alert)=> ${typeof(alert)}`)
    }

)();

alert("Hello IIFE");
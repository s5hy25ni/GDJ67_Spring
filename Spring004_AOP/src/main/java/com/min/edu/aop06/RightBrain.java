package com.min.edu.aop06;

import org.springframework.stereotype.Component;

/*
 * TODO AOP06 06_02 LeftBrain을 spring bean으로 만들기위해 @Component를 선언
 */
@Component
public class RightBrain implements IPerson {
	@Override
	public void thinking() {		
		System.out.println("오른쪽 뇌 작동");
	}
	
	/*
	 * aop의 상위 부모에서 가지고 있는 메소드만을 VMI 실행시킨다
	 * 따라서 interface에 구성되어 있지 않는 메소드는 Auto-Proxy의 대상이 되지 않는다.
	 */
	public String use(String action) {
		System.out.println("반환과 Arguments가 있는 메소드");
		return action+"해본다";
	}
}

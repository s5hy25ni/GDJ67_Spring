package com.min.edu.aop06;

import org.springframework.stereotype.Component;

/*
 * TODO AOP06 06_02 LeftBrain을 spring bean으로 만들기위해 @Component를 선언
 */
@Component
public class LeftBrain implements IPerson {

	@Override
	public void thinking() {
		System.out.println("왼쪽 뇌 작동 : 생각");
	}

}

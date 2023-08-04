package com.min.edu.anno04;

import org.springframework.stereotype.Component;

/**
 * TODO anno04 04_03 공통기능을 작성하고 @Component를 선언하여 bean으로 등록
 * 		Raido 클래스와 다르게 value속성을 통해서 이름을 정의
 * @author GDJ67
 *
 */
@Component(value="samsung")
public class Television implements IFunction {

	@Override
	public void powerOn() {
		System.out.println("TV on");
	}

	@Override
	public void powerOff() {
		System.out.println("TV off");
	}

}

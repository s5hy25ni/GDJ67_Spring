package com.min.edu.anno04;

import org.springframework.stereotype.Component;

/**
 * TODO anno04 04_02 공통기능을 작성하고 @Component를 선언하여 bean으로 등록
 * @author GDJ67
 *
 */
@Component
public class Radio implements IFunction {

	@Override
	public void powerOn() {
		System.out.println("라디오 on");
	}

	@Override
	public void powerOff() {
		System.out.println("라디오 off");
	}

}

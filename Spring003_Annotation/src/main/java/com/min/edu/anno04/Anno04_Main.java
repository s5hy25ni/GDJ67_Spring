package com.min.edu.anno04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Anno04_Main {

	public static void main(String[] args) {
		ApplicationContext anno04 = new ClassPathXmlApplicationContext("com/min/edu/anno04/anno04_bean.xml");
		IFunction r = anno04.getBean("radio", IFunction.class);
		IFunction t = anno04.getBean("samsung", IFunction.class);
		
		r.powerOn();
		t.powerOff();
		
//		@Component(value="")를 작성했기 때문에 클래스 명명법을 따라가지 않음
//		IFunction tt = anno04.getBean("television", IFunction.class);
//		tt.powerOff();
	}

}

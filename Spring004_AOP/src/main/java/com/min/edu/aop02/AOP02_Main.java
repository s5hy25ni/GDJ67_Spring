package com.min.edu.aop02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP02_Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/min/edu/aop02/AOP-Context.xml");
		
		// Spring bean에 의해서 Auto-Proxy된 객체는 java의 객체가 아니다 jdk.proxy2.$proxy4
		
//		IHumanWork emp = appContext.getBean("employee", Employee.class);
//		emp.work();
		
		IHumanWork emp = appContext.getBean("employee", IHumanWork.class);
		emp.work();
	}

}

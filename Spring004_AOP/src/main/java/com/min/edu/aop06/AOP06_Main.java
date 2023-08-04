package com.min.edu.aop06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP06_Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/min/edu/aop06/AOP-Comtext.xml");
//		IPerson lb = appContext.getBean("leftBrain",IPerson.class);
//		lb.thinking();
		
		IPerson rb = appContext.getBean("rightBrain",IPerson.class);
		rb.thinking();
		
		System.out.println(">>>>>>>>>>>>>>>>> VMI에 선언하지 않은 메소드 use(String action) 실행");
		RightBrain rbVMI = appContext.getBean("rightBrain", RightBrain.class);
		
		/*
		 * Bean named 'rightBrain' is expected to be of type 'com.min.edu.aop06.RightBrain' but was actually of type 'jdk.proxy2.$Proxy15'
		 * Spring Framework는 기본구성이interface를 통한 VMI실행을 기본으로 함
		 * RightBrain의 use() 메소드는 interface인 IPerson에 작성되어 있지 않기 때문에 문제가 발생함
		 * 
		 * 이를 해결하기 위해서 Auto-Proxy의 설정을
		 * java가 framework인 Spring으로부터 독립적으로 작동될 수 있도록 설정
		 * proxy-target-class=true로 설정해주면 된다
		 * java의 객체의 생성은 invocationHandler로 동작이 되기 때문
		 */
		rbVMI.use("생각");
		
		
	}

}

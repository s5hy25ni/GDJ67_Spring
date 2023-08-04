package com.min.edu.bean1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean1_Main {

	public static void main(String[] args) {
		// Spring Container가 시작될 때 Spring Bean Configuration을 사용하여 bean을 객체로 만들어 사용
		ApplicationContext bean1 = new ClassPathXmlApplicationContext("com/min/edu/bean1/bean1.xml");
		
		IMessageBean coffee = bean1.getBean("Americano", IMessageBean.class); // arguments 1)이름 2)캐스팅될 객체
		coffee.call();
	}

}

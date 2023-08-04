package com.min.edu.aop04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP04_Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/min/edu/aop04/AOP-Context.xml");
		IHumanWork c = appContext.getBean("employee", IHumanWork.class);
		c.work();

	}

}

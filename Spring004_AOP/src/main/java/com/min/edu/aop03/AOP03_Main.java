package com.min.edu.aop03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOP03_Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/min/edu/aop03/AOP-Context.xml");
//		IHumanWork work = appContext.getBean("employee", IHumanWork.class);
//		work.work();
		IHumanWork work = appContext.getBean("cTo", IHumanWork.class);
		work.work();

	}

}

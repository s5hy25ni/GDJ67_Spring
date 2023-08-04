package com.min.edu.anno02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno02_Main {

	/**
	 * anno02 02_02 Spring Bean Configuration에 의해서 선언된 bean을 Spring Container가 읽을 수 있도록 해줌
	 */
	public static void main(String[] args) {
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/min/edu/anno02/anno02_bean.xml");
		NickNameProp nick = beans.getBean("nickNameProp", NickNameProp.class);
		System.out.println(nick);
	}

}

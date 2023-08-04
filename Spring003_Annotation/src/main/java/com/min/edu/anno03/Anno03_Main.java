package com.min.edu.anno03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno03_Main {

	public static void main(String[] args) {
		ApplicationContext anno03 = new ClassPathXmlApplicationContext("com/min/edu/anno03/anno03_bean.xml");
		
		// 사용도는 bean의 이름은 자동으로 클래스명의 camel 방식으로 이름이 선언됨
		NickNameProp3 nick = anno03.getBean("nickNameProp3", NickNameProp3.class);
		System.out.println(nick);

	}

}

package com.min.edu.anno05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno05_Main {

	public static void main(String[] args) {
		ApplicationContext anno05 = new ClassPathXmlApplicationContext("com/min/edu/anno05/anno05_bean.xml");

		
		//TODO anno05 05_03 주입 하지 않고 실행
//		School obj = (School)anno05.getBean("school");
//		System.out.println(obj);

		//TODO anno05 05_04 @Qualifier에 stu01를 value로 작성
//		School obj = (School)anno05.getBean("school");
//		System.out.println(obj);
		
//		TODO anno05 05_05 @Reaouce를 통해 주입
		School obj = (School)anno05.getBean("school");
		System.out.println(obj);
	}

}

package com.min.edu.bean2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean2_Main {

	public static void main(String[] args) {
		ApplicationContext bean2 = new ClassPathXmlApplicationContext("com/min/edu/bean2/bean2.xml");
		
		EmployeeAddress addr01 = (EmployeeAddress)bean2.getBean("myAddr01");
		System.out.println(addr01);
		
		JobAddress dev = (JobAddress)bean2.getBean("dev");
		System.out.println(dev);
		
	}

}

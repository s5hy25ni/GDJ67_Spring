package com.min.edu.bean3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean3_Main {

	public static void main(String[] args) {
		ApplicationContext bean3 = new ClassPathXmlApplicationContext("com/min/edu/bean3/bean3.xml");
		System.out.println(bean3.getBean("now"));
		System.out.println(bean3.getBean("myDate"));
		
		UserDto dto = bean3.getBean("myDto", UserDto.class);
		System.out.println(dto);
		System.out.println(dto.getName());
		System.out.println(dto.getPer());
		
		//IUserServiceImpl bean을 호출
		UserServiceImpl service = bean3.getBean("userServiceImpl", UserServiceImpl.class);
		service.getUser();
	}

}

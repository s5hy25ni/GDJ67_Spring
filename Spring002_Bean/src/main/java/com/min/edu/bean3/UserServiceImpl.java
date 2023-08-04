package com.min.edu.bean3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements IUserService {

	@Resource(name="myDto")
//	@Autowired // Spring Container에 있는 같은 타입의 객체를 자동으로 주입
	private UserDto dto;
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl 생성자");
	}
	
	@Override
	public void addUser(UserDto dto) {
		System.out.println("addUser 메소드 호출(Arguments) : "+ dto);
		System.out.println("addUser 메소드 호출(bean 주입) : "+ this.dto);
	}

	@Override
	public void getUser() {
		System.out.println("getUser 메소드 호출 : " + dto);
	}

}

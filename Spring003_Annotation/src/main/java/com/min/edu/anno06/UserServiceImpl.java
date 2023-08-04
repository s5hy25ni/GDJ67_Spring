package com.min.edu.anno06;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements IUserService {

	// 멤버필드 주입
//	@Autowired
//	private UserDto dto01;
	
//	@Autowired
//	@Qualifier(value="ud01")
//	private UserDto dto01;
	
//	@Resource(name="ud01")
//	private UserDto dto01;
	
	
	
	
	
	// setter 주입
	private UserDto dto01;
	
	@Autowired
	@Qualifier("ud01")
	public void setDto01(UserDto dto01) {
		this.dto01 = dto01;
	}
	
	
	@Override
	public void addUser() {
		System.out.println("추가된 멤버 : "+dto01.getName());
	}


}

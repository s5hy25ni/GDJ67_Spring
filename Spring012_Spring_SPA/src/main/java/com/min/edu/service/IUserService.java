package com.min.edu.service;

import java.util.Map;

import com.min.edu.vo.User_Vo;

public interface IUserService {
	
//TODO 11_01 Interface User Service login
//로그인 및 로그인 검증
	public User_Vo login(Map<String, Object> map);

}

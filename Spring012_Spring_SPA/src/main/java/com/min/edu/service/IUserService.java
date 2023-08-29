package com.min.edu.service;

import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserService {

	//TODO 11_01 Interface User Service login
	// 로그인 및 로그인 검증
	public UserVo login(Map<String, Object> map);
}

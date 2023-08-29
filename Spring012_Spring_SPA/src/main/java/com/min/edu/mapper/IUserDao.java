package com.min.edu.mapper;

import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserDao {

	//TODO 11_02 Interface User Service login
	// 로그인 및 로그인 검증
	public UserVo login(Map<String, Object> map);
}

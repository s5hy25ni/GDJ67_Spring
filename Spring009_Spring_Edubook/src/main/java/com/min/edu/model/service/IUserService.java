package com.min.edu.model.service;

import org.springframework.stereotype.Service;

import com.min.edu.vo.UserVO;

public interface IUserService {

	public UserVO login(UserVO vo);
}

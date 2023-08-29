package com.min.edu.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.mapper.IUserDao;
import com.min.edu.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	//TODO 11_03 User myBatis login 호출
	@Override
	public UserVo login(Map<String, Object> map) {
		log.info("UserService login {}", map);
		return dao.login(map);
	}

}

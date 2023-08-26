package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao dao;

	@Override
	public int joinUser(UserVo vo) {
		return dao.joinUser(vo);
	}

	@Override
	public int loginUser(Map<String, Object> map) {
		return dao.loginUser(map);
	}
	
	@Override
	public UserVo getUserInfo(String id) {
		return dao.getUserInfo(id);
	}

	@Override
	public int updatePassword(Map<String, Object> map) {
		return dao.updatePassword(map);
	}
	
	@Override
	public List<UserVo> getUserList(Map<String, Object> map) {
		return dao.getUserList(map);
	}
	
	@Override
	public int getUserCount() {
		return dao.getUserCount();
	}
}

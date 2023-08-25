package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.UserVo;


public interface IUserService {
	public int joinUser(UserVo vo);
	public int loginUser(Map<String, Object> map);
	public int updatePassword(Map<String, Object> map);
	public List<UserVo> getUserList(Map<String, Object> map);
	public int getUserCount();
}

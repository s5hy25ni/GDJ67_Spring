package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserDao {
	public int joinUser(UserVo vo);
	public int loginUser(Map<String, Object> map);
	public UserVo getUserInfo(String id);
	public int updatePassword(Map<String, Object> map);
	public List<UserVo> getUserList(Map<String, Object> map);
	public int getUserCount();
}

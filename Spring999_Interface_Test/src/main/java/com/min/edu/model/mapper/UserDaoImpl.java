package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int joinUser(UserVo vo) {
		return session.insert("com.min.edu.model.mapper.joinUser",vo);
	}

	@Override
	public int loginUser(Map<String, Object> map) {
		return session.selectOne("com.min.edu.model.mapper.loginUser",map);
	}
	
	@Override
	public UserVo getUserInfo(String id) {
		return session.selectOne("com.min.edu.model.mapper.getUserInfo", id);
	}
	
	@Override
	public int updatePassword(Map<String, Object> map) {
		return session.update("com.min.edu.model.mapper.updatePassword",map);
	}
	
	@Override
	public List<UserVo> getUserList(Map<String, Object> map) {
		return session.selectList("com.min.edu.model.mapper.getUserList", map);
	}
	
	@Override
	public int getUserCount() {
		return session.selectOne("com.min.edu.model.mapper.getUserCount");
	}
}

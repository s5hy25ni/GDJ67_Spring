package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

@Repository
public class UserDaoImpl implements IUserDao {

	private final String NS="com.min.edu.model.mapper.UserDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public UserVo getLogin(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"getLogin", map);
	}

	@Override
	public int isDuplicateCheck(String id) {
		return sqlSession.selectOne(NS+"isDuplicateCheck",id);
	}

	@Override
	public int signupMember(UserVo vo) {
		return sqlSession.insert(NS+"signupMember", vo);
	}

	@Override
	public List<UserVo> userSelectAll() {
		return sqlSession.selectList(NS+"userSelectAll");
	}

	@Override
	public UserVo userSelectOne(String id) {
		return sqlSession.selectOne(NS+"userSelectOne", id);
	}

	@Override
	public List<UserVo> getSerarchUser(UserVo vo) {
		return sqlSession.selectList(NS+"getSerarchUser", vo);
	}

	@Override
	public String findId(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"findId", map);
	}

	@Override
	public String pwChk(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"pwChk", map);
	}

	@Override
	public int changeAuthToA(Map<String, Object> map) {
		return sqlSession.update(NS+"changeAuthToA",map);
	}

	@Override
	public int changeAuthToU(Map<String, Object> map) {
		return sqlSession.update(NS+"changeAuthToU",map);
	}

	@Override
	public int changeDelflagToN(Map<String, Object> map) {
		return sqlSession.update(NS+"changeDelflagToN",map);
	}

	@Override
	public int changeDelflagToY(Map<String, Object> map) {
		return sqlSession.update(NS+"changeDelflagToY",map);
	}

	@Override
	public List<UserVo> getAllUser() {
		return sqlSession.selectList(NS+"getAllUser");
	}

}

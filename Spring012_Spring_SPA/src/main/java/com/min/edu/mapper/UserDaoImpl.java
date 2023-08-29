package com.min.edu.mapper;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// @Value 쓸 것, NAMESPACE+id
	private final String NAMESPACE = "com.min.edu.mapper.UserDaoImpl.";
	
	//TODO 11_04 User Dao myBatis login
	@Override
	public UserVo login(Map<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+"login",map);
	}

}

package com.min.edu.mapper;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.User_Vo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.min.edu.mapper.UserDaoImpl.";
	
	//TODO 11_04 User Dao MyBatis login
	@Override
	public User_Vo login(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"login",map);
	}

}

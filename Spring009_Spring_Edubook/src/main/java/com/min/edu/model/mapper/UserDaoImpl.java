package com.min.edu.model.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVO;

@Repository
public class UserDaoImpl implements IUserDao {
	
private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public UserVO login(UserVO vo) {
		return sqlSession.selectOne("com.min.edu.model.mapper.UserDaoImpl.login",vo);
	}

}

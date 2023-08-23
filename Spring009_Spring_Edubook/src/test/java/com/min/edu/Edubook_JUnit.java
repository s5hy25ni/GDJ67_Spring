package com.min.edu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Edubook_JUnit {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IUserService service;

	@Before
	public void test() {
		assertNotNull(sqlSession);
	}
	
	@Test
	public void login() {
		UserVO vo = new UserVO();
		vo.setId("hello");
		vo.setPassword("1234");
		UserVO One = service.login(vo);
		assertNotNull(One);
	}

}

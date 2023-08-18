package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.vo.EduVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SpringMybatis_JUnitTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate session;
	
//	@Test
	public void db_Connect_Test() {
		SqlSessionTemplate session = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
		assertNotNull(session);
	}
	
	@Test
	public void mybatis_SelectTest() {
		List<EduVo> lists = session.selectList("com.min.edu.model.EduBoardDaoImpl.selectBoard");
		System.out.println(lists);
		assertNotNull(lists);
	}

}

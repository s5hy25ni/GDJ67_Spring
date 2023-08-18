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

import com.min.edu.dto.TestDto;

//TODO 19 spring + JUnit 테스트 설정

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/application-context.xml")
public class SpringModel_JUnitTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
//	@Test
//	public void template_test() {
//		SqlSessionTemplate session = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
//		System.out.println(session.toString());
//		assertNotNull(session);
//	}
	
	@Test
	public void myBatis_Test() {
		List<TestDto> lists = sqlSession.selectList("com.min.edu.model.TestDaoImpl.selectAllTest");
		System.out.println(lists);
		
		assertNotNull(lists);
	}

}

package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.vo.Board_Vo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class JUnitTest {

	@Autowired
	private SqlSessionTemplate session;
	
	@Test
	public void test() {
		List<Board_Vo> list = session.selectList("com.min.edu.mapper.TestDaoImpl.getAllBoard");
		assertNotNull(list);
		System.out.println(list);
	}

}

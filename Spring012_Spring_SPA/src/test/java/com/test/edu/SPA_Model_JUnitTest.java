package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.min.edu.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration // 없어도 됨
public class SPA_Model_JUnitTest {
	
	//TODO 08_02 SqlSessionTemplate Bean 생성 테스트
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IBoardService service;

//	@Test
	public void test() {
		assertNotNull(sqlSession);
	}
	
	//TODO 10_04 myBatis LoginTest, Login
//	@Test
	public void loginTest() {
		Map<String, Object> map = new HashMap<String, Object>(){{
			put("id", "user");
			put("password", 1234);
		}};
		
		UserVo one = sqlSession.selectOne("com.min.edu.mapper.UserDaoImpl.login", map);
		assertNotNull(one);
	}
	
	//TODO 18_06 getAllBoardPage JUnitTest
	@Test
	public void getAllBoardPageTest() {
		Map<String, Object> map = new HashMap<String, Object>(){{
			put("first", 1);
			put("last", 5);
			put("auth", "U");
		}};
		
		List<BoardVo> lists = service.getAllBoardPage(map);
		assertEquals(5, lists.size());
	}

}

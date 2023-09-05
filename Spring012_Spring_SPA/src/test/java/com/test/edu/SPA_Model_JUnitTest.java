package com.test.edu;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import com.min.edu.vo.Board_Vo;
import com.min.edu.vo.User_Vo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
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
	
	//TODO 10_04 MyBatis LoginTest, login
//	@Test
	public void loginTest() {
		Map<String, Object> map = new HashMap<String, Object>(){{
			put("id", "user");
			put("password", "1234");
		}};
		
		User_Vo one =  sqlSession.selectOne("com.min.edu.mapper.UserDaoImpl.login", map);
		assertNotNull(one);
		
	}
	
	//TODO 18_06 getAllBoardPage JUnit Test
//	@Test
	public void getAllBoardPageTest() {
		Map<String, Object> map = new HashMap<String, Object>(){{
			put("first", 1);
			put("last", 5);
			put("auth","U");
		}};
		List<Board_Vo> list = service.getAllBoardPage(map);
		assertEquals(5, list.size());
	}

	//TODO 20_06 selBoardDelFlag JUnit test
//	@Test
	public void selBoardDelFlag() {
		int n = service.selBoardDelFlag("7");
		assertEquals(1, n);
	}
	
	//TODO 21_06 Board Dao getOneBoard, setBoardUpdate
//	@Test
	public void getOneBoard_setBoardUpdate() {
		Board_Vo vo = service.getOneBoard("361");
		assertNotNull(vo);
/*		int n = service.setBoardUpdate(new HashMap<String, Object>(){{
			put("seq","361");
			put("title","이차돌");
			put("content","이차돌은 차돌집");
		}});
		assertEquals(1, n);
		*/
	}
	
	//TODO 22_06 답글 작성 update, insert JUnit Test
	@Test
	public void setReplyUpdate_serReplyInsert() {
		Board_Vo vo = new Board_Vo();
		vo.setSeq(363);
		vo.setId("admin1");
		vo.setTitle("admin1 답글 제목!!");
		vo.setContent("admin1 답글 내용 내용 내용");
		
		boolean isc = service.setReply(vo);
		assertTrue(isc);
	}
}

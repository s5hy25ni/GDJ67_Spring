package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.BoardDaoImpl;
import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Board_JUnitTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private IBoardDao dao;
	
	@Before
	public void dbConnectTest() {
		SqlSessionTemplate session = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
		assertNotNull(session);
	}
	
//	@Test
	public void userBoardList_Test() {
		List<BoardVo> lists = dao.userBoardList();
		assertNotNull(lists);
	}
	
//	@Test
	public void delFlagBoard() {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", new String[] {"31","41"});
		int n = dao.delFlagBoard(map);
		assertEquals("삭제 실패ㅐㅐㅐㅐㅐㅐㅐㅐ!", 2, n, 0);
	}
	
//	@Test
	public void writeBoard() {
		BoardVo vo = new BoardVo(0, "포도3", "포도 알림 알림", "포도주스주스주스", 0, 0, 0, null, null);
		int n =  dao.writeBoard(vo);
		System.out.println("입력 후 SEQ"+vo.getSeq());
		assertEquals("입력", 1, n, 0);
	}

//	@Test
	public void getOneBoard() {
		BoardVo vo = dao.getOneBoard("344");
		assertNotNull(vo);
	}
	
//	@Test
	public void replyUpdate() {
		BoardVo vo = new BoardVo(344, "rain", "태풍", "태풍 지나가는 중", 0, 0, 0, null, null);
		int n = dao.replyUpdate(vo);
		assertEquals(2, n);
	}
	
//	@Test
	public void replyInsert() {
		BoardVo vo = new BoardVo(344, "rain", "태풍", "태풍 지나가는 중", 0, 0, 0, null, null);
		int n = dao.replyInsert(vo);
		assertEquals(1, n);
	}
	
//	@Test
	public void restoreBoard() {
		List<BoardVo> lists = dao.restoreBoard();
		assertNotNull(lists);
	}
	
	@Test
	public void restoreDelflag() {
		int n = dao.restoreDelflag("27");
		assertEquals(1, n);
	}
}

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

import com.min.edu.aes.Encrypt_AES;
import com.min.edu.model.mapper.BoardDaoImpl;
import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class User_JUnitTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private IUserDao dao;
	
//	@Test
	public void getLogin() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hello");
		map.put("pw", "1234");
		UserVo vo = dao.getLogin(map);
		assertNotNull(vo);
	}
	
//	@Test
	public void isDuplicateCheck() {
		int n = dao.isDuplicateCheck("hello");
		assertEquals(1, n);
	}
	
//	@Test
	public void signupMember() {
		UserVo vo = new UserVo("hello2", "하이", "1234", "hi@gmail.com", null, null, null, null, null);
		int n = dao.signupMember(vo);
		assertEquals(1, n);
	}
	
//	@Test
	public void userSelectAll() {
		List<UserVo> vo = dao.userSelectAll();
		assertNotNull(vo);
	}
	
//	@Test
	public void userSelectOne() {
		UserVo vo = dao.userSelectOne("hello");
		assertNotNull(vo);
	}
	
//	@Test
	public void getSerarchUser() {
		UserVo vo = new UserVo(null, null, null, null, null, null, null, "id", "h");
		List<UserVo> list = dao.getSerarchUser(vo);
		assertNotNull(list);
		UserVo vo2 = new UserVo(null, null, null, null, null, null, null, "name", "현");
		List<UserVo> list2 = dao.getSerarchUser(vo2);
		assertNotNull(list2);
	}
	
//	@Test
	public void findId() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "사용자");
		map.put("email", "hello@gmail.com");
		String id = dao.findId(map);
		assertEquals("hello", id);
	}
	
//	@Test
	public void pwChk() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hello");
		String pw = dao.pwChk(map);
		assertEquals("1234", pw);
	}
	
//	@Test
	public void changeAuthToA() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hello");
		int n = dao.changeAuthToA(map);
		assertEquals(1, n);
	}
	
//	@Test
	public void changeAuthToU() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hello");
		int n = dao.changeAuthToU(map);
		assertEquals(1, n);
	}
	
//	@Test
	public void changeDelflagToN() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hello");
		int n = dao.changeDelflagToN(map);
		assertEquals(1, n);
	}
	
//	@Test
	public void changeDelflagToY() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hello");
		int n = dao.changeDelflagToN(map);
		assertEquals(1, n);
	}
	
//	@Test
	public void getAllUser() {
		List<UserVo> list = dao.getAllUser();
		assertNotNull(list);
	}
	
	@Test
	public void cypto() throws Exception {
		Encrypt_AES en = new Encrypt_AES();
		String pwEncode = en.encrypt("1234");
		System.out.println("암호화된 1234 = "+pwEncode);
		
		String pwDecode = en.decrypt(pwEncode);
		System.out.println("복호화된 1234="+pwDecode);
		
		assertTrue(true);
	}
}

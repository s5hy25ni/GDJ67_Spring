package com.min.test;

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

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserJUnitTest {

	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private IUserService service;
	
//	@Test
	public void sessionTest() {
		assertNotNull(session);
	}
	
	@Test
	public void test() {
		// 회원가입 테스트
//		UserVo vo = new UserVo("sh123", "쏘현", "1234", "sh123@gmail.com");
//		int n = service.joinUser(vo);
//		assertEquals(n, 1);
		
		// 로그인 테스트
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "sh123");
//		map.put("password", "12344");
//		int n = service.loginUser(map);
//		assertEquals(0, n);
		
		// 유저 상세 조회 테스트
//		String id = "user01";
//		UserVo vo = service.getUserInfo(id);
//		assertNotNull(vo);
				
		
		// 비밀번호 업데이트 테스트
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "sh123");
//		map.put("password", "12344");
//		int n = service.updatePassword(map);
//		assertEquals(1, n);
		
		// 유저 목록 테스트
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("first", 1);
//		map.put("last", 10);
//		List<UserVo> list = service.getUserList(map);
//		assertEquals(10, list.size());
		
		// 총 유저
//		int n = service.getUserCount();
//		assertNotNull(n);

	}

}

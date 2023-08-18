package com.min.test;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.jdt.internal.compiler.env.IModule.IService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IJobsDao;
import com.min.edu.model.service.IJobsService;
import com.min.edu.vo.JobsVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class JobsJunitTest {

	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private IJobsDao dao;
	
	@Autowired
	private IJobsService service;
	
//	@Test
	public void test() {
		assertNotNull(session);
	}
	
//	@Test
	public void selectTest() {
		List<JobsVo> list = dao.selectAll();
		assertNotNull(list);
	}
	
	@Test
	public void insertJob() {
		JobsVo vo = new JobsVo("DEV", "Developer", 10000, 20000);
		int n = service.transaction(vo);
		assertEquals(1, n);
	}

}

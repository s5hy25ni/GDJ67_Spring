package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.dto.JobsDto;
import com.min.edu.mapper.MyBatisJobsInterface_Mapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class InterfaceMapperTest {

	@Autowired
	private MyBatisJobsInterface_Mapper mapper; 
	
//	@Test
	public void testAll() {
		List<JobsDto> list = mapper.selectAll();
		System.out.println(list);
		assertNotNull(list);;
	}
	
//	@Test
	public void testOne() {
		JobsDto one = mapper.selectOne("DEV");
		System.out.println(one);
		assertNotNull(one);
	}

	@Test
	public void testDynamic() {
		List<JobsDto> list = mapper.selectDynamic(null);
		System.out.println(list);
		assertNotNull(list);;
//		List<JobsDto> list = mapper.selectDynamic("DEV");
//		System.out.println(list);
//		assertNotNull(list);;
	}
}

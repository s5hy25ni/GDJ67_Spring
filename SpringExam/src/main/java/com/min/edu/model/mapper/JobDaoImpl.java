package com.min.edu.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.JobsVo;

@Repository
public class JobDaoImpl implements IJobDao {
	
	private String NS = "com.min.edu.model.mapper.JobDaoImpl.";

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<JobsVo> selAll() {
		return session.selectList(NS+"selAll");
	}
}

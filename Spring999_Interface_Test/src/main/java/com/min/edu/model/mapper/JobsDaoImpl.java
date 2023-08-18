package com.min.edu.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.JobsVo;

@Repository
public class JobsDaoImpl implements IJobsDao {

	private final String NS = "com.min.edu.model.mapper.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<JobsVo> selectAll() {
		return session.selectList(NS+"selectAll");
	}
	
	@Override
	public int updateUseage() {
		return session.update(NS+"updateUseage");
	}
	
	@Override
	public int insertJob(JobsVo vo) {
		return session.insert(NS+"insertJob", vo);
	}

}

package com.min.edu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.model.mapper.IJobsDao;
import com.min.edu.vo.JobsVo;

@Service
public class JobsServiceImpl implements IJobsService {

	@Autowired
	private IJobsDao dao;

	@Override
	public List<JobsVo> selectAll() {
		return dao.selectAll();
	}
	
//	@Transactional(readOnly = true)
	@Override
	public int transaction(JobsVo vo) {
		int n = dao.updateUseage();
		int m = dao.insertJob(vo);
		return (m>0 || n>0)?1:0;
	}


}

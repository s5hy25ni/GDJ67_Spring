package com.min.edu.model.mapper;

import java.util.List;

import com.min.edu.vo.JobsVo;

public interface IJobsDao {

	public List<JobsVo> selectAll();
	public int updateUseage();
	public int insertJob(JobsVo vo);
}

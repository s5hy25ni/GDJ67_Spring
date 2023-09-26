package com.min.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.min.edu.dto.JobsDto;

public interface MyBatisJobsInterface_Mapper {

	@Select("SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY FROM JOBS")
	public List<JobsDto> selectAll();
	
	@Select("SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY FROM JOBS WHERE JOB_ID=#{job_id}")
//	@Results({
//		@Result(property ="DTO의 set메소드명", column = "컬럼명") // resultMap
//	})
	public JobsDto selectOne(String job_id);
	
	@SelectProvider(type=JobProvider.class, method="getSelectAll")
	public List<JobsDto> selectDynamic(String job_id);
}

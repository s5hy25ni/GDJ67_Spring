package com.min.edu.mapper;

import org.apache.ibatis.jdbc.SQL;

// 쿼리를 생성하는 클래스
public class JobProvider {

	public String getSelectAll(String job_id) {
		SQL sql = new SQL() {{
			SELECT("JOB_ID");
			SELECT("JOB_TITLE");
			SELECT("MIN_SALARY");
			SELECT("MAX_SALARY");
			FROM("JOBS");
			if(job_id != null) {				
				WHERE("JOB_ID=#{job_id}");
			}
		}};
		System.out.println(sql.toString());
		return sql.toString();
	}
}

package com.min.edu.vo;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Getter
@Service
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JobsVo {

	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;
}

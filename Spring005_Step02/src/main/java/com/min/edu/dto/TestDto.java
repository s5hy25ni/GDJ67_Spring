package com.min.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//TODO 15 MyBatis에서 사용하게 될 DTO 객체
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
	private String job_id;
	private String title;
	private String min_salary;
	private String max_salary;
}

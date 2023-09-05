package com.min.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CareercertVO {
	
	private String name;
	private String contact;
	private String affiliation;
	private String position;
	private String period;
	private String job_desc;
	private String issuer_name;
	private String issuer_contact;
	private String create_date;
	private String company_name;

}

package com.min.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//TODO 10_01 UserInfo 테이블 매핑 VO

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User_Vo {

	private String id;
	private String name;
	private String password;
	private String email;
	private String auth;
	private String delflag;
	private String joindate;
	
}

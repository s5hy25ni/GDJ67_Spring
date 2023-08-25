package com.min.edu.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserVo {
	private String id;
	private String name;
	private String password;
	private String email;
	private String auth;
	private String delflag;
	private Date joindate;
	public UserVo(String id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	
}

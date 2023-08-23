package com.min.edu.vo;

import java.io.Serializable;

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
public class UserVO implements Serializable{
	
	private static final long serialVersionUID = -4968073999920724528L;
	
	private String id;
	private String name;
	private String password;
	private String email;
	private String auth;
	private String delflag;
	private String joindate;
	
}

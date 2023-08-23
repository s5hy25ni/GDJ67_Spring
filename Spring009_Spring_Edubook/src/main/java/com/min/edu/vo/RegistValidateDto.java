package com.min.edu.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

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
public class RegistValidateDto {
	
	@Null(message = "id는 필수입력입니다")
	@Size(min =1, max = 10)
	private String id;
	
	@Null(message = "null이 입력되었습니다")
	@Size(min =1, max = 10, message = "잘못된 크기의 입력값 입니다")
	private String name;
	
	@Null(message = "null이 입력되었습니다")
	@Size(min =1, max = 20, message = "잘못된 입력값 입니다")
	private String password;
	
	private String email;
	private String auth;
	private String delflag;
	private String joindate;
	
	
}

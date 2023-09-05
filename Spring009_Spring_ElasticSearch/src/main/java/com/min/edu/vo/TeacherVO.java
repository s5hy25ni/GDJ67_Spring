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
public class TeacherVO {

	private int id;
	private int age;
	private String gender;
	private String introduction;
	private String education;
	private String available_location;
	private String subject;
	private String specialty;
	private int minimum_fee;
	private String external_link_video;
	private String external_link_website;
	private String external_link_mobile;
	private String experience;
	private String nickname;

}

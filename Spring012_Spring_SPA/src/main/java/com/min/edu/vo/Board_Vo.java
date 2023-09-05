package com.min.edu.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//TODO 09_01 Answerboard 테이블 매핑 VO

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board_Vo {
	
	private int seq;
	private String id;
	private String title;
	private String content;
	private int step;
	private int ref;
	private int depth;
	private String regdate;
	private String delflag;
	private String likeUser;
	private String hitUser;

}

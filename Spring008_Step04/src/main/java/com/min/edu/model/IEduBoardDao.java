package com.min.edu.model;

import java.util.List;

import com.min.edu.vo.EduVo;

public interface IEduBoardDao {
	
	// 전체 조회
	public List<EduVo> selectBoard();
	
	// 글 입력
	public int insertBoard(EduVo vo);
	
	// 전체 글 delflag 수정
	public int updateBoard();
}

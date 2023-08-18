package com.min.edu.model;

import java.util.List;

import com.min.edu.vo.EduVo;

public interface IEduBoardService {

	public List<EduVo> selectBoard();
	public int insertBoard(EduVo vo);
	
	
	// updateBoard와 insertBoard를 실행해서 둘 중 하나라도 오류 발생 -> 모두 rollback 제어
	public int transactionTest(EduVo vo);
}

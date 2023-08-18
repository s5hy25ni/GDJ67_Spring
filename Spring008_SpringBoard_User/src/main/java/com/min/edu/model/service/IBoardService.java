package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardService {

	// 게시글 조회
	public List<BoardVo> userBoardList();
	
	// 게시글 다중 삭제
	public int delFlagBoard(Map<String, String[]> map);
	
	// 새 글 작성
	public int writeBoard(BoardVo vo);
	
	// 상세 조회
	public BoardVo getOneBoard(String seq);
	
	// 답글 입력
	public int reply(BoardVo vo);
	
	// 삭제글 조회
	public List<BoardVo> restoreBoard();
	
	// 삭제글 복구
	public int restoreDelflag(String seq);
}

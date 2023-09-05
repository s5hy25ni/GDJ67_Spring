package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.Board_Vo;

public interface IBoardService {
	
	//TODO 18_03 Interface Board Service getAllBoardPAge, getAllBoardCount
	public List<Board_Vo> getAllBoardPage(Map<String, Object> map);
	public int getAllBoardCount(Map<String, Object> map);
	
	//TODO 20_02 Interface Board Service selBoardDelFlag
	public int selBoardDelFlag(String seq);

	//TODO 21_02 Interface Board Service getOneBoard,setBoardUpdate
	public Board_Vo getOneBoard(String seq);
	public int setBoardUpdate(Map<String, Object> map);
	
	//TODO 22_02 Interface Board Serivce setReplyUpdate,setReplyInsert
	public boolean setReply(Board_Vo vo);
	
}

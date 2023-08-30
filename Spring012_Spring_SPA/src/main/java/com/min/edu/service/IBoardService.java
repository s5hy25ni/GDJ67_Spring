package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardService {

	//TODO 18_03 Interface Board Service getAllBoardPage, getAllBoardCount
	public List<BoardVo> getAllBoardPage(Map<String, Object> map);
	public int getAllBoardCount(Map<String, Object> map);
}

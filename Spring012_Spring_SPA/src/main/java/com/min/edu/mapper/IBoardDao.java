package com.min.edu.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardDao {

	//TODO 18_04 Interface Board Dao getAllBoardPage, getAllBoardCount
	public List<BoardVo> getAllBoardPage(Map<String, Object> map);
	public int getAllBoardCount(Map<String, Object> map);
}

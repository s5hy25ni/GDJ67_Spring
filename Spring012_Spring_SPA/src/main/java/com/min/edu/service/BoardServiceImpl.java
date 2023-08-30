package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements IBoardService {

	@Autowired
	private IBoardDao dao;
	
	//TODO 18_05 Board Service getAllBoardPage 및 getAllBoardCount
	@Override
	public List<BoardVo> getAllBoardPage(Map<String, Object> map) {
		log.info("Board Service Impl 전체글 조회 페이징");
		log.info("Board Service Impl 전달 받은 페이지 범위 및 권한 {}", map);
		return dao.getAllBoardPage(map);
	}
	@Override
	public int getAllBoardCount(Map<String, Object> map) {
		log.info("Board Service Impl 전체글 조회 페이징");
		log.info("Board Service Impl 전달 받은 권한 {}", map);
		return dao.getAllBoardCount(map);
	}

}

package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.mapper.IBoardDao;
import com.min.edu.vo.Board_Vo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements IBoardService {
	
	@Autowired
	private IBoardDao dao;

	//TODO 18_05 Board Service getAllBoardPage 및 getAllBoardCount
	@Override
	public List<Board_Vo> getAllBoardPage(Map<String, Object> map) {
		log.info("BoardServiceImpl 전체글 조회 페이징");
		log.info("BoardServiceImpl 전달받은 페이지 범위 및 권한 {}", map);
		return dao.getAllBoardPage(map);
	}

	@Override
	public int getAllBoardCount(Map<String, Object> map) {
		log.info("BoardServiceImpl 전체글 조회 페이징");
		log.info("BoardServiceImpl 전달받은 권한 {}", map);
		return dao.getAllBoardCount(map);
	}

	//TODO 20_04 Board Service selBoardDelFlag
	@Override
	public int selBoardDelFlag(String seq) {
		log.info("BoardServiceImpl 사용자 및 관리자 개인글 삭제 delflag", seq);
		return dao.selBoardDelFlag(seq);
	}
	
	//TODO 21_04 Board Service getOneBoard, setBoardUpdate
	@Override
	public Board_Vo getOneBoard(String seq) {
		log.info("BoardServiceImpl 사용자 게시글 정보 조회 getOneBoard : {}", seq);
		return dao.getOneBoard(seq);
	}
	
	@Override
	public int setBoardUpdate(Map<String, Object> map) {
		log.info("BoardServiceImpl 사용자 게시글 수정 정보 DB 저장 setBoardUpdate : {}", map);
		return dao.setBoardUpdate(map);
	}
	
	//TODO 23_03 Transaction annotation 처리
	@Transactional(readOnly = true)
	//TODO 22_04 Board Service
	@Override
	public boolean setReply(Board_Vo vo) {
		log.info("BoardServiceImpl 답글 업데이트 및 DB 저장 setReply : {}", vo);
		int n = dao.setReplyUpdate(vo);
		int m = dao.setReplyInsert(vo);
		return (n+m)>0?true:false;
	}

}

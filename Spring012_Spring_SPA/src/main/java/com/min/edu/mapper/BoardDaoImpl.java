package com.min.edu.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.Board_Vo;

@Repository
public class BoardDaoImpl implements IBoardDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	private final String NS = "com.min.edu.mapper.BoardDaoImpl.";

	@Override
	public List<Board_Vo> getAllBoardPage(Map<String, Object> map) {
		return session.selectList(NS+"getAllBoardPage", map);
	}

	@Override
	public int getAllBoardCount(Map<String, Object> map) {
		return session.selectOne(NS+"getAllBoardCount", map);
	}

	//TODO 20_05 Board Dao selBoardDelFlag
	@Override
	public int selBoardDelFlag(String seq) {
		return session.update(NS+"selBoardDelFlag",seq);
	}
	
	//TODO 21_05 Board Dao getOneBoard, setBoardUpdate
	@Override
	public Board_Vo getOneBoard(String seq) {
		return session.selectOne(NS+"getOneBoard",seq);
	}
	
	@Override
	public int setBoardUpdate(Map<String, Object> map) {
		return session.update(NS+"setBoardUpdate",map);
	}
	
	//TODO 22_05 답글 작성 update, insert
	@Override
	public int setReplyInsert(Board_Vo vo) {
		return session.insert(NS+"setReplyInsert",vo);
	}
	
	@Override
	public int setReplyUpdate(Board_Vo vo) {
		return session.update(NS+"setReplyUpdate",vo);
	}

}

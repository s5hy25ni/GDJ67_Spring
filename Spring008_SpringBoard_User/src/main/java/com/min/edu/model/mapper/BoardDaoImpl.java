package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;

@Repository
public class BoardDaoImpl implements IBoardDao {

	private final String NS="com.min.edu.model.mapper.BoardDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardVo> userBoardList() {
		
		return sqlSession.selectList(NS+"userBoardList");
	}

	@Override
	public int delFlagBoard(Map<String, String[]> map) {
		return sqlSession.update(NS+"delFlagBoard",map);
	}

	@Override
	public int writeBoard(BoardVo vo) {
		return sqlSession.insert(NS+"writeBoard",vo);
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		return (BoardVo)sqlSession.selectList(NS+"getOneBoard", seq).get(0);
	}

	@Override
	public int replyUpdate(BoardVo vo) {
		return sqlSession.update(NS+"replyUpdate",vo);
	}

	@Override
	public int replyInsert(BoardVo vo) {
		return sqlSession.insert(NS+"replyInsert", vo);
	}

	@Override
	public List<BoardVo> restoreBoard() {
		return sqlSession.selectList(NS+"restoreBoard");
	}

	@Override
	public int restoreDelflag(String seq) {
		return sqlSession.update(NS+"restoreDelflag", seq);
	}

}

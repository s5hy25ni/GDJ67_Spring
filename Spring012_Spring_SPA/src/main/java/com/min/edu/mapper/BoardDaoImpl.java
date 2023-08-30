package com.min.edu.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;


@Repository
public class BoardDaoImpl implements IBoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAMESPACE="com.min.edu.mapper.BoardDaoImpl.";

	@Override
	public List<BoardVo> getAllBoardPage(Map<String, Object> map) {
		return sqlSession.selectList(NAMESPACE+"getAllBoardPage", map);
	}

	@Override
	public int getAllBoardCount(Map<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+"getAllBoardCount", map);
	}

}

package com.min.edu.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.EduVo;

@Repository
public class EduBoardDaoImpl implements IEduBoardDao {

	private static final Logger logger = LoggerFactory.getLogger(EduBoardDaoImpl.class);
	private final String NS = "com.min.edu.model.EduBoardDaoImpl.";
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<EduVo> selectBoard() {
		logger.info("사용자 로거 {}", "selectBoard");
		return session.selectList(NS+"selectBoard");
	}

	@Override
	public int insertBoard(EduVo vo) {
		logger.info("사용자 로거 {} {}", "insertBoard", vo);
		return session.insert(NS+"insertBoard", vo);
	}

	@Override
	public int updateBoard() {
		logger.info("사용자 로거 {}", "updateBoard");
		return session.update(NS+"updateBoard");
	}
}

package com.min.edu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.vo.EduVo;

@Service
public class EduBoardServiceImpl implements IEduBoardService {

	@Autowired
	private IEduBoardDao dao;

	@Override
	public List<EduVo> selectBoard() {
		return dao.selectBoard();
	}

	@Override
	public int insertBoard(EduVo vo) {
		return dao.insertBoard(vo);
	}

	/*
	 * TODO 11_05 @Transactional(readOnly=[true|false])
	 * 				true : 읽기, fasle : 삭제, 수정, 입력 적용
	 * 				readOnly = true로 설정해서 Transaction이 동작하도록 설정한다.
	 * 				update 혹은 insert에 오류가 발생하면 service의 모든 dao를 rollback 처리
	 */
	@Override
	public int transactionTest(EduVo vo) {
		int m = dao.updateBoard();
		int n = dao.insertBoard(vo);
		return (m>0 || n>0)?1:0;
	}
}

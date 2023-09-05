package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.TeacherVO;

@Repository
public class TeacherDaoImpl implements ITeacherDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<TeacherVO> subjectSearch(String subject) {
		return sqlSession.selectList("com.min.edu.model.mapper.TeacherDaoImpl.subjectSearch", subject);
	}

	@Override
	public List<TeacherVO> nicknameSearch(String nickname) {
		return sqlSession.selectList("com.min.edu.model.mapper.TeacherDaoImpl.nicknameSearch", nickname);
	}

	@Override
	public int careerInsert(Map<String, Object> map) {
		return sqlSession.insert("com.min.edu.model.mapper.TeacherDaoImpl.careerInsert", map);
	}

}

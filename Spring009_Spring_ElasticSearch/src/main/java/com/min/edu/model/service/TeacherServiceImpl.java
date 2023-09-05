package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.ITeacherDao;
import com.min.edu.vo.TeacherVO;

@Service
public class TeacherServiceImpl implements ITeacherService {

	@Autowired
	private ITeacherDao dao;
	
	@Override
	public List<TeacherVO> subjectSearch(String subject) {
		return dao.subjectSearch(subject);
	}

	@Override
	public List<TeacherVO> nicknameSearch(String nickname) {
		return dao.nicknameSearch(nickname);
	}

	@Override
	public int careerInsert(Map<String, Object> map) {
		return dao.careerInsert(map);
	}

}

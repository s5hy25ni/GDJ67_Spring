package com.min.edu.model.mapper;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.TeacherVO;

public interface ITeacherDao {

	public List<TeacherVO> subjectSearch(String subject);
	
	public List<TeacherVO> nicknameSearch(String nickname);
	
	public int careerInsert(Map<String, Object> map);
	
	
}

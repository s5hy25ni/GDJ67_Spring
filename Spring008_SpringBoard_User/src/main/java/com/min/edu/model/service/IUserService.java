package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserService {

	// 로그인
	public UserVo getLogin(Map<String, Object> map);
	
	// 회원가입시 중복검사
	public int isDuplicateCheck(String id);
	
	// 회원가입
	public int signupMember(UserVo vo);
	
	// 사용 가능 사용자 전체 조회
	public List<UserVo> userSelectAll();
	
	// 사용자 상세조회
	public UserVo userSelectOne(String id);
	
	// 회원 검색 아이디 혹은 성명
	public List<UserVo> getSerarchUser(UserVo vo);
	
	// 아이디 찾기 email과 이름
	public String findId(Map<String, Object> map);
	
	// 비밀번호 조회
	public String pwChk(Map<String, Object> map);
	
	// 과제
	// 권한수정
	public int changeAuthToA(Map<String, Object> map);
	public int changeAuthToU(Map<String, Object> map);
	
	// 휴면계정
	public int changeDelflagToN(Map<String, Object> map);
	public int changeDelflagToY(Map<String, Object> map);
	
	
	//ㅈ 전체 사용자 조회
	public List<UserVo> getAllUser();

}

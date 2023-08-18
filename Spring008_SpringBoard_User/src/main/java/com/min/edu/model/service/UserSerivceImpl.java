package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

@Service
public class UserSerivceImpl implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserSerivceImpl.class);
	
	@Autowired
	private IUserDao dao;
	
	@Override
	public UserVo getLogin(Map<String, Object> map) {
		logger.info("UserSerivceImpl 로그인 getLogin {} ", map);
		return dao.getLogin(map);
	}

	@Override
	public int isDuplicateCheck(String id) {
		logger.info("UserSerivceImpl 회원가입시 중복검사 isDuplicateCheck {}", id);
		return dao.isDuplicateCheck(id);
	}

	@Override
	public int signupMember(UserVo vo) {
		logger.info("UserSerivceImpl 회원가입 signupMember {}", vo);
		return dao.signupMember(vo);
	}

	@Override
	public List<UserVo> userSelectAll() {
		logger.info("UserSerivceImpl 사용 가능 사용자 전체 조회 userSelectAll {}");
		return dao.userSelectAll();
	}

	@Override
	public UserVo userSelectOne(String id) {
		logger.info("UserSerivceImpl 사용자 상세조회 userSelectOne {}", id);
		return dao.userSelectOne(id);
	}

	@Override
	public List<UserVo> getSerarchUser(UserVo vo) {
		logger.info("UserSerivceImpl 회원 검색 아이디 혹은 성명 getSerarchUser {} {}", vo.getOpt(), vo.getKeyword());
		return dao.getSerarchUser(vo);
	}

	@Override
	public String findId(Map<String, Object> map) {
		logger.info("UserSerivceImpl 아이디 찾기 findId {}", map);
		return dao.findId(map);
	}

	@Override
	public String pwChk(Map<String, Object> map) {
		logger.info("UserSerivceImpl 비밀번호 조회 pwChk {}", map);
		return dao.pwChk(map);
	}

	@Override
	public int changeAuthToA(Map<String, Object> map) {
		logger.info("UserSerivceImpl {}");
		return dao.changeAuthToA(map);
	}

	@Override
	public int changeAuthToU(Map<String, Object> map) {
		logger.info("UserSerivceImpl {}");
		return dao.changeAuthToU(map);
	}

	@Override
	public int changeDelflagToN(Map<String, Object> map) {
		logger.info("UserSerivceImpl {}");
		return dao.changeDelflagToN(map);
	}

	@Override
	public int changeDelflagToY(Map<String, Object> map) {
		logger.info("UserSerivceImpl {}");
		return dao.changeDelflagToY(map);
	}

	@Override
	public List<UserVo> getAllUser() {
		logger.info("UserSerivceImpl {}");
		return dao.getAllUser();
	}
 
}

package com.min.edu;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.service.IUserService;
import com.min.edu.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	@Autowired
	private IUserService service;
	
	//TODO 12_01 UserController에서 /loginForm.do 요청 화면 이동
	@GetMapping("/loginForm.do")
	public String loginForm() {
		log.info("UserControllre 로그인 화면 이동");
		return "loginForm";
	}
	
	//TODO 12_06 로그인 화면에서 비동기식 로그인 정보 확인 REST 요청
	//		Rest요청 후 객체가 있으면 Session에 저장
	@PostMapping("/loginCheckText.do")
	@ResponseBody
	public ResponseEntity<?> loginCheckText(
			// 두 개의 @RequestBody를 사용할 수 없음		
//			@RequestBody UserVo vo
			@RequestBody Map<String, Object> map,
			HttpSession session
			){
//		log.info("UserController 로그인 정보 조회 비동기식 처리 : {}", vo);
		log.info("UserController 로그인 정보 조회 비동기식 처리 : {}", map);
		
		UserVo uVo = service.login(map);
		if(uVo != null) {
			session.setAttribute("loginVo", uVo);
			return ResponseEntity.ok("{\"key\":\"value\"}");	
		} else {
//			return new IllegalArgumentException("잘못된 로그인 정보");
			return new ResponseEntity<String>("등록 오류입니다.", HttpStatus.BAD_REQUEST);
		}
		
	}
}

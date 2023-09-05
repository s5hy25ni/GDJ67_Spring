package com.min.edu;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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
import com.min.edu.vo.Board_Vo;
import com.min.edu.vo.User_Vo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private IUserService service;
	
	//TODO 12_02 UserController에서 /loginForm.do 요청화면 이동
	@GetMapping("/loginForm.do")
	public String loginForm() {
		log.info("UserController 로그인 화면 이동");
		return "loginForm";
	}
	
	//TODO 12_06 로그인 화면에서 비동기식 로그인 정보 확인 REST 요청
	//		Rest 요청 후 객체가 있으면 Session에 저장
	@PostMapping(path ="/loginCheckText.do")
	@ResponseBody
	public ResponseEntity<?> loginCheckText(
//			두 개의 @RequestBody를 사용할 수 없음
//			@RequestBody User_Vo vo,
			@RequestBody Map<String, Object> map,
			HttpSession session
			){
//		log.info("UserController 로그인 정보 조회 비동기식 처리 : {}",vo);
		log.info("UserController 로그인 정보 조회 비동기식 처리 : {}",map);
		
		User_Vo uVo = service.login(map);
		if(uVo != null) {
			session.setAttribute("loginVo", uVo);
//			return ResponseEntity.ok("{\"key\":\"val\"}");
			return ResponseEntity.ok().body(uVo);
		} else {
//			return new IllegalArgumentException("잘못된 로그인 정보");
			return new ResponseEntity<String>("등록 오류입니다", HttpStatus.BAD_REQUEST);
		}
	}
	
	//TODO 13_02 로그인 정보를 Session에 저장한 후 null이면 loginForm.do로 보내고, 아니면 redirect:/boardList.do로 보냄
	@GetMapping("/login.do")
	public String loginSession(HttpSession session, HttpServletResponse response) throws IOException {
		if(session.getAttribute("loginVo") == null) {
			//TODO 13_03 User Library인 SpringUtils.servletAlert에서 패키징된 파일 사용
			SpringUtils.servletAlert(response, "잘못된 접근입니다", "loginForm.do");
			return "";
		} else {
			//TODO 14_01 로그인 후 이동하는 boardList 화면 이동
			return "redirect:/boardList.do";
		}
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home.do";
	}
	
	
	

}

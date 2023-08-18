package com.min.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVO;

@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/login.do")
	public String login(UserVO vo, HttpSession session, Model model, HttpServletRequest request) {
		logger.info("@Controller LoginController Login 요청받은 값 {}", vo);
		UserVO loginVo = service.login(vo);
		if(loginVo == null) {
			return "redirect:/main.do";
		} else {
			/*
			 * model은 spring container의 request 객체이다.
			 * @RequestMapping과 값을 공유
			 * 
			 * 1) org.springframework.ui.Model model -> model.addAttribute("loginVo", loginVo); => request scope 처리
			 * 2) javax.servlet.HttpSession session -> session.setAttribute("lgoinVo", loginVo); => session scope 처리
			 * 3) @SessionAttribute(loginVo) -> model.addAttribute("loginVo", loginVo); => session + Spring Container session scope 처리
			 * 
			 */
			
			session.setAttribute("loginVo", loginVo);
			model.addAttribute("loginVo", loginVo);
			
			return "afterLogin";
		}
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session, Model model) {
		logger.info("@Controller LoginController logout");
		logger.info("session 삭제는 session.invalidate()"); // session 사용이 무효화되어 메소드를 사용할 수 없다.
		
		UserVO modelVo = (UserVO)model.getAttribute("loginVo");
		if(modelVo == null) {
			logger.info("Model은 request scope이기 때문에 값을 유지할 수 없음");
		}
		
		UserVO sessionVo = (UserVO)session.getAttribute("loginVo");
		if(sessionVo != null) {
			logger.info("HttpSession은 session scope이기 때문에 값이 유지됨 {}", sessionVo.getName());
		}
		
		try {
//			session.invalidate();
			UserVO sessionVoTmp = (UserVO)session.getAttribute("loginVo");
		} catch (Exception e) {
			logger.info("invalidate는 객체 자체를 삭제하기 때문에 getAttribute() : 세션이 이미 무효화되었습니다.");
		}
		
		// 세션의 삭제는 invalidate()와 removeAttribute("key")가 있다.
		logger.info("session의 삭제는 session.removeAttribute()");
		session.removeAttribute("loginVo");
		UserVO sessionVoTmp2 = (UserVO)session.getAttribute("loginVo");
		logger.info("HttpSession의 내부에서 객체만 삭제된다. 삭제된 session {}", sessionVoTmp2);
		
		return "home";
	}
}

package com.min.edu;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("sessionTest")
public class Session_1_Controller {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/sessionInit.do")
	public String sessionInit(HttpSession session, Model model) {
		logger.info("Session_1_Controller sessionInit.do HttpSession 및 @SessionAttribute 테스트값 입력");
		logger.info("HttpSession:httpsessionTest  /  @SessionAttribute:sessionTest");
		
		session.setAttribute("httpsessionTest", "sessionInit.do 입력된 HttpSession 값");
		model.addAttribute("sessionTest", "sessionInit.do 입력된 @SessionAttribute 값");
		
		return "sessionCheck";
	}
	
	@GetMapping("/test01.do")
	public String test01(SessionStatus sessionStatus) {
		logger.info("Session_1_Controller test01.do @SessionAttribute를 setComplete로 삭제");
		sessionStatus.setComplete();
		return "sessionCheck";
	}
	
	@GetMapping("/result01.do")
	public String result01(HttpSession session, @SessionAttribute("sessionTest") String sessionTest) {
		logger.info("HttpSession과 @SessionAttribute를 출력");
		System.out.println("------------------HttpSession------------------" + session.getAttribute("httpsessionTest"));
		System.out.println("------------------@SessionAttribute------------------"+ sessionTest);
		return "sessionCheck";
	}
	
	@GetMapping(value="/test02.do")
	public String test02(HttpSession session) {
		logger.info("Session_1_Controller test02.do HttpSession을 invalidate로 삭제");
		session.invalidate();
//		session.getAttribute("httpsessionTest"); //invalidate에 의해서 무효화 되어 오류 발생됨
		return "sessionCheck";
	}
	
	@GetMapping("/result02.do")
	public String result02(HttpSession session) { //바인딩 객체를 새로 생성하기 때문에 null
		System.out.println("------------------HttpSession------------------" + (String)session.getAttribute("httpsessionTest"));
		return "sessionCheck";
	}
	
	
	
}

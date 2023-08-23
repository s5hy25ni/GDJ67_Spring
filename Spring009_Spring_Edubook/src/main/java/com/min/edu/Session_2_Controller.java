package com.min.edu;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

/*
 * 생성하지 않고 사용되는 HttpSession과 @SessionAttribute를 사용 / 삭제
 */
@Controller
public class Session_2_Controller {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/test03.do")
	public String test03(SessionStatus sessionStatus, @SessionAttribute("sessionTest") String sessionTest) {
		logger.info("다른 컨트롤러에서 @SessionAttribute를 사용 {}", sessionTest);
		logger.info("Welcome Session_2_Controller test03.do @SessionAttribute setComplete로 삭제");
		
		sessionStatus.setComplete();
		
		return "sessionCheck";
	}

	@GetMapping("/result03.do")
	public String result03(HttpSession session, @SessionAttribute("sessionTest") String sessionTest) {
		logger.info("HttpSession과 @SessionAttribute를 출력 \n 다른 컨트롤러에서는 sessionStatus.setComplete()를 수행하지 못함.");
		System.out.println("----------HttpSession----------"+session.getAttribute("httpsessionTest"));
		System.out.println("----------@SessionAttribute----------"+sessionTest);
		return "sessionCheck";
	}
	
	@GetMapping("/test04.do")
	public String test04(HttpSession session) {
		System.out.println("############## HttpSession삭제 ##############");
		session.invalidate();
		return "sessionCheck";
	}
	
	@GetMapping("/result04.do")
	public String result04(HttpSession session, @SessionAttribute("sessionTest") String sessionTest) {
		logger.info("HttpSession을 출력");
		System.out.println("############## HttpSession ##############"+session.getAttribute("httpsessionTest"));
		System.out.println("############## @SessionAttribute ##############"+sessionTest);
		return "sessionCheck";
	}
}

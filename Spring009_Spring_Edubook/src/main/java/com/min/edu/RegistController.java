package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/registForm.do")
	public String registForm() {
		logger.info("Welcome RegistController 일반회원 가입 화면으로 이동");
		return "registForm";
	}
	
	@GetMapping("/duplicateId.do")
	public String duplicateId() {
		logger.info("Welcome RegistController 아이디 중복 검사 이동");
		return "duplicateId";
	}
	
	
}

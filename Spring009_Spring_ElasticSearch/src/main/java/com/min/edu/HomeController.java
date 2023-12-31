package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale) {
		logger.info("Welcome home! main.do 실행");
		logger.info("처음페이지 home.jsp로 이동");
		
		return "home";
	}
	
	@GetMapping("/elastic.do")
	public String elasticGo() {
		return "elastic_controller";
	}
	
	@GetMapping("/elastic2.do")
	public String elastic2Go() {
		return "elastic_javascript";
	}
	
	@GetMapping("/searchTest.do")
	public String searchTest() {
		return "searchTest";
	}
	
	@GetMapping("/convert.do")
	public String convert() {
		return "convert";
	}
	
}

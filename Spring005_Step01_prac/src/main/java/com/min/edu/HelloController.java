package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	private Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(String hello, Model model) {
		logger.info("전달받은 값 : {}", hello);
		model.addAttribute("hello", hello);
		return "/WEB-INF/views/hello.jsp";
	}
}

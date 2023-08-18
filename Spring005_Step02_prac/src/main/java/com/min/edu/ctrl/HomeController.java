package com.min.edu.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public String home(String name, Model model) {
		logger.info("home에 전달 받은 param {}", name);
		model.addAttribute("name", name+"님 하이");
		return "home";
	}
	
	@RequestMapping(value="/info.do", method = RequestMethod.POST)
	public String info(String name, int age) {
		logger.info("info에서 전달받은 값 : {} {}", name, age);
		return "";
	}
}

package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class EduController {

	private Logger logger = LoggerFactory.getLogger(EduController.class);
	
	@GetMapping(value="/home.do")
	public String home(String name, Model model) {
		
		logger.info("@GetMapping home {}", name);
		
		model.addAttribute("name",name);
		return "home";
	}
}

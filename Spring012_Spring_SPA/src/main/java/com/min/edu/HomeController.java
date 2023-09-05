package com.min.edu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

//TODO 01_03 HomeController 작성
@Slf4j
@Controller
public class HomeController {

	@GetMapping("/home.do")
	public String home() {
		log.info("처음 시작하는 HomeController");
		return "home";
	}
	
}

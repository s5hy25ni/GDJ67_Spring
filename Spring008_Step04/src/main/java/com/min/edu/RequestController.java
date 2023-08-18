package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * TODO 05_02 Controller 클래스에 mapping의 indexing을 만들어서 해당 Controller는 /user/*만을 처리하도록 구분하여 사용
 */
@Controller
@RequestMapping("/user")
public class RequestController {
	
	private Logger logger = LoggerFactory.getLogger(RequestController.class);
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String requestCtrl() {
		logger.info("Welcome Request Controller logout");
		return "ctrl";
	}
}

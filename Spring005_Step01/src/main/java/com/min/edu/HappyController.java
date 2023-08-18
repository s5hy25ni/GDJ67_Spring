package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HappyController {

	private Logger logger = LoggerFactory.getLogger(HappyController.class);
	
	@RequestMapping(value="/", method= {RequestMethod.GET, RequestMethod.POST})
	public String happy(String name, Model model) {
		logger.info("전달받은 요청 값 : {}", name);
		model.addAttribute("result", name);
		return "/WEB-INF/views/happy.jsp";
	}
	
	@GetMapping(value="/param")
	public String param(HttpServletRequest request, String name, int month) { // spring 처리 방식
		logger.info("기존처리 방식의 parameter 처리");
		
		//1) 기존 처리(servlet) 방식
		String reqName = request.getParameter("name");
		String reqMonth = request.getParameter("month");
		
		logger.info("기존의 처리 방식은 request.getParameter() 메소드를 통해 처리 {} {}", reqName, reqMonth+0);
		logger.info("Spring은 자동 binding을 지원(타입 자동 변환) {} {}", name, month+1);
		
		return "/WEB-INF/views/param.jsp";
	}
	
	@GetMapping(value="/encoding")
	public String encoding(Model model, Locale local) {
		logger.info("전달받은 파라미터 {}", local);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, local);
		String formatDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formatDate);
		
		return "/WEB-INF/views/encoding.jsp";
	}
}

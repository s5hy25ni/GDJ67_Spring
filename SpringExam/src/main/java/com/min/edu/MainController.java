package com.min.edu;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.service.IJobService;
import com.min.edu.vo.JobsVo;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private IJobService service;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("요청 주소 home.do로 MainController 호출");
		model.addAttribute("tomato","멋쟁이 토마토");
		return "home";
	}
	
	@RequestMapping(value = "/joblist.do",method = RequestMethod.GET)
	public String jobList(Model model) {
		logger.info("화면 흐름제어 index->jobsLists");
		List<JobsVo> lists = service.selAll();
		model.addAttribute("joblist",lists);
		return "jobList";
	}
}

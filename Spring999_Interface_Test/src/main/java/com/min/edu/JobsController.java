package com.min.edu;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.model.service.IJobsService;
import com.min.edu.vo.JobsVo;

@Controller
public class JobsController {
	private static final Logger logger = LoggerFactory.getLogger(JobsController.class);
	
	@Autowired
	private IJobsService service;
	
	@RequestMapping(value="/jobsList.do", method = RequestMethod.GET)
	public String jobsList(Model model) {
		logger.info("@RequestMapping GET jobsList");
		List<JobsVo> lists = service.selectAll();
		model.addAttribute("lists", lists);
		return "jobsList";
	}
}

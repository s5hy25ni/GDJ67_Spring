package com.min.edu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.min.edu.model.service.IUserService;
import com.min.edu.vo.PageVo;
import com.min.edu.vo.UserVo;

@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService service;

	@RequestMapping(value="/joinForm.do", method = RequestMethod.GET)
	public String joinForm() {
		logger.info("@@@@@@@@@@GET joinUser");
		return "joinForm";
	}
	
	@RequestMapping(value="/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("@@@@@@@@@@GET loginForm");
		return "loginForm";
	}
	
	@RequestMapping(value="/join.do", method = RequestMethod.POST)
	public String join(UserVo vo) {
		logger.info("@@@@@@@@@@POST join : {}", vo);
		int n = service.joinUser(vo);
		return (n==1)?"loginForm":"joinForm";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, Model model) {
		int n =service.loginUser(map);
		return (n==1)?"redirect:/getUserList.do?page=1":"loginForm";
	}
	
	@RequestMapping(value="/getUserList.do", method = RequestMethod.GET)
	public String getUserList(String page, Model model) {
		logger.info("@@@@@@@@@@GET getUserList : {} page", page);
		
		PageVo p = new PageVo();
		p.setTotalUser(service.getUserCount());
		p.setCntOnePage(10);
		p.setCntViewPage(5);
		p.setTotalPage(0);
		p.setCurPage(Integer.parseInt(page));
		p.setStartPage(0);
		p.setEndPage(0);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", (Integer.parseInt(page)-1)*p.getCntOnePage()+1);
		map.put("last", (Integer.parseInt(page)-1)*p.getCntOnePage()+10);
		List<UserVo> list = service.getUserList(map);
		model.addAttribute("list", list);
		model.addAttribute("startNo", (Integer.parseInt(page)-1)*p.getCntOnePage()+1);
		return "userList";
	}
	
}

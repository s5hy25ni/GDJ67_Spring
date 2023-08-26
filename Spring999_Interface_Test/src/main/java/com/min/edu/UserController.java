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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.PageVo;
import com.min.edu.vo.UserVo;

@Controller
@SessionAttributes("loginUser")
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
		logger.info("@@@@@@@@@@POST login : {}", map);
		int n =service.loginUser(map);
		if(n>0) {
			UserVo vo = service.getUserInfo(map.get("id").toString());
			System.out.println(map.get("id").toString());
			model.addAttribute("loginUser", vo);
			return "redirect:/getUserList.do?page=1";
		} else {			
			return "loginForm";
		}
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
		model.addAttribute("page", p);
		return "userList";
	}
	
	@RequestMapping(value="/userInfo.do", method = RequestMethod.GET)
	public String userInfo(Model model) {
		return "userInfo";
	}
	
	@RequestMapping(value="/updatePassword.do", method = RequestMethod.POST)
	public String updatePassword(String password, Model model){		
		logger.info("@@@@@@@@@@GET updatePassword");
		UserVo vo = (UserVo)model.getAttribute("loginUser");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", vo.getId());
		map.put("password", password);
		service.updatePassword(map);
		return "loginForm";
	}
	
}

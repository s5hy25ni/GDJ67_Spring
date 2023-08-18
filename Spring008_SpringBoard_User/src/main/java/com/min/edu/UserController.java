package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.aes.Encrypt_AES;
import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService service;
	
	//TODO 02_02 로그인 화면으로 이동 처리
	@RequestMapping(value="/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("Welcome 로그인 화면 이동 loginForm");
		return "loginForm";
	}
	
	//TODO 03_02 회원가입 화면 signupForm 화면으로 이동
	@RequestMapping(value="/signupForm.do", method=RequestMethod.GET)
	public String signupForm() {
		logger.info("Welcome 회원가입 화면 이동 signupForm");
		return "signupForm";
	}
	
	//TODO 04_03 duplication.do 중복검사 JSP 요청
	@RequestMapping(value="/duplication.do", method=RequestMethod.GET)
	public String dupliation() {
		logger.info("welcome 아이디 중복검사 화면 open duplication");
		return "duplication";
	}
	
	//TODO 04_06 아이디 중복 처리를 위한 Rest처리 : text(true/false)만 전송
	@RequestMapping(value="/duplicationAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public String duplicationAjax(String checkId) {
		logger.info("welcome 아이디 중복검사 open duplicationAjax {}", checkId);
		int n = service.isDuplicateCheck(checkId);
		return (n>0)?"true":"false";
		
	}
	
	//TODO 04_10 회원가입 정볼르 입력받아 DB에 저장, 성공하면 redirect로 loginForm.do 호출
	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public String signup(
			UserVo vo, // 화면의 전달 값을 binding
			HttpServletResponse response // 회원 가입 실패시 알람창을 화면으로 전송
			) throws IOException {
		
		logger.info("welcome 회원가입 signup {}", vo);
		
		Encrypt_AES aes = new Encrypt_AES();
		try {
			vo.setPassword(aes.encrypt(vo.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int n = service.signupMember(vo);
		if(n==1) {
			return "redirect:/loginForm.do";
		} else {
			response.setContentType("text/html; charset=UTF-8;");
			response.getWriter().println("<script>alert=('회원가입에 실패하였습니다.'); location.href='./loginForm.do'</script>");
			return null;
		}
	}
	
	// TODO 05_02 아이디 찾기 화면 open
	@RequestMapping(value="/findId.do", method = RequestMethod.GET)
	public String findId() {
		logger.info("welcome 아이디 찾기 화면 open findId");
		return "findId";
	}
	
	// TODO 05_04 아이디 찾기 Ajax 실행결과 값 Text 반환
	@RequestMapping(value="/findIdAjax.do", method=RequestMethod.POST)
	@ResponseBody
	public String findIdAjax(@RequestParam Map<String, Object> map) {
		logger.info("welcome 아이디 찾기 findIdAjax {}", map);
		
		String id = service.findId(map);
		return (id!=null)?id:"";
	}
	
	// TODO 06_02 요청값을 map으로 처리, HttpSession에 저장, 성공하면 servlet alert을 통해서 알려준 후 boardList로 이동
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpSession session, 
						HttpServletResponse resp, HttpServletRequest req ) throws IOException {
		logger.info("Welcome 로그인 처리 login {}", map);
		
		resp.setContentType("text/html; charset=UTF-8");
		
		try {
			UserVo loginVo = service.getLogin(map);
			if(loginVo != null) {
				session.setAttribute("loginVo", loginVo);
				session.setMaxInactiveInterval(60*10);
				PrintWriter out = resp.getWriter();
				
				//TODO 07_01 BoardController 게시판 전체 조회 boardList.do
				out.println("<script>alert('로그인 되었습니다'); location.href='./boardList.do';</script>");
				out.flush();
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = resp.getWriter();
		
		out.println("<script>alert('로그인 정보가 없습니다.'); location.href='./loginForm.do';</script>");
		out.flush();
		
		return null;
	}
	
	//TODO 08_02 로그아웃 및 session 삭제
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("Welcome UserController 로그아웃");
		session.invalidate();
		return "redirect:/loginForm.do";
	}
	
	//TODO 09_02
	@RequestMapping(value = "/managementUser.do", method = RequestMethod.GET)
	public String managementUser(Model model) {
		logger.info("Welcome UserControlloer managementUser 회원관리 전체 조회");
		List<UserVo> lists = service.getAllUser();
		model.addAttribute("lists", lists);
		return "managementUser";
	}
}

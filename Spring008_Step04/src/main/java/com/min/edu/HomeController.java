package com.min.edu;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * @Controller는 stereotype Bean이 자동으로 등록되는 것들
 * servlet-context.xml > 자동등록 <context:component-scan base-package="com.min.edu"> 하위 
 * 								<context:annotation-config /> bean으로 생성된 객체 안에 있는 @(annotation)이 동작될 수 있도록 해줌
 * 요청되는 주소에서 실행하고자 하는 메소드를 찾아 줌(Handler-Mapping)
 * @RequestMapping(value="mapping명", method="requestMethod.[GET|POST] ..") 메소드 다중 선택 가능 
 * spring framework 4.3.25부터 RequestMapping을 구체적으로 구분하기 위해서
 * @GetMapping, @PostMapping .., 을 사용할 수 있음
 * 
 * String으로 요청되는 주소에서 Handle Adapter에 의해서 메소드를 찾아 실행
 * 요청(param) HttpServletRequest는 자동으로 자바의 객체와 mapping(type, 변수명)
 * --- 파싱(parsing)		: 값의 형태를 변환하는 것
 * --- 바인딩(binding)	: 값의 부분에 껴넣거나 비어있는 부분을 완성시키는 것
 * 
 * 화면의 흐름제어(forward, redirect)
 * Spring Framework의 화면제어는 기본적으로 IoC로 동작이 되기 때문에 DispatcherServlet이 가지고 있다.
 * 값은 Model 객체가 처리 + 화면은 View Resolver가 생성 => ModelAndView 객체를 통해서 하나의 객체로 만들 수 있음
 * Servlet 혹은 MVC에서는 Redirect는 브라우저에 주소에 요청한다라고 이야기 할 수 있음. response.sendRedirect("./화면이동");
 * 따라서 보안폴더인 WEB-INF는 접근하지 못하기 때문에 호출이 불가능함
 * Spring Framework에서의 Redirect는 Container가 가지고 있는 Mapping을 호출 : return "redirect:/호출.do"
 * 
 * 전송된 Scope 처리
 * page, request, session, application 종류가 있다.
 * Spring Model의 객체는 request scope 이다.
 * 하지만, HttpServletRequest를 사용해도 같은 역할(근데 사용하지 말 것)
 * 
 * 마지막 위의 설명에서 model과 이동화면을 같이 처리할 수 있는 객체는 ModelAndView
 * 사용하는 방법
 * 
 * 	public ModelAndView home(){
 * 		ModelAndView mav = new ModelAndView();
 * 		mav.addObject("key", value);
 *  	mav.setViewName("");
 *  	return mav;
 *  }
 * 
 * 
 */
@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//TODO 01_01 요청 home.do로 호출, @GetMapping을 GET방식만으로 처리
	@GetMapping(value = "/home.do")
	public String home(String name, HttpServletRequest request, Model model) {
		
		/*
		 *  전송된 QueryString을 요청명으로 자동 Bind되고 타입도 변환된다.
		 *  만약 bind 타입이 문자라면 문제X 
		 *  int와 같은 타입이면 null을 처리할 수 없기 때문에 오류 발생
		 */
		logger.info("@GetMapping home 요청 받은 name : {}", name);
		String redirectValue = (String)request.getAttribute("name");
		logger.info("@GetMapping home 요청 받은 redirectValue : {}", redirectValue);

		String str = "가장 좋아하는 과일은 ? "+name;
		
		request.setAttribute("req_str", str);
		model.addAttribute("str", str);
		
		// 만약 return이 null이라면 DispatcherServlet은 자동으로 method명을 사용하여 화면 요청
		return "home";
	}
	
	//TODO 02_02 요청 home.do로 호출 @PostMapping을 POST 방식만으로 처리
	@PostMapping(value="/home.do")
	public String home(String name, Model model) {
		logger.info("@PostMapping home 요청 받은 name : {}", name);
		String str="과일같은 야채 "+name;
		model.addAttribute("str", str);
		
		/*
		 * 반환 결과에 따른 구분
		 * 1) null : 자신의 메소드명
		 * 2) 문자열 : dispatcherServlet에 의해서 문자열이 ViewResolver로 이동, prefix+문자열+suffix로 구성되어 요청
		 * 3) resolver가 없는 경우 : 해당 위치를 모두 작성 ex) "/WEB-INF/views/home.jsp"
		 */
		return "home";
	}
	
	//TODO 03_02 요청 info.do로 호출 @RequestMapping을 GET과 POST 방식 모두 처리
	@RequestMapping(value="/info.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String info(String name, int age, Model model) {
		logger.info("GET/POST 모두 처리 : info.do");
		
		String msg = name+"/"+age;
		model.addAttribute("info", msg);
		return "info";
	}
	
	//TODO 04_02 Spring에서 redirect는 "return redirect:/이동"
	// 				작성된 Controller Bean 중 RequestMap의 value가 같은 매핑을 실행해줌
	//				이때 값은 전달이 불가능
	@GetMapping(value="/redirect.do")
	public String redirect(String name, Model model, HttpServletRequest req) {
		logger.info("@GetMapping redirect 요청받은 name값 {}", name);
		model.addAttribute("name",name);
		return "redirect:/home.do?name=redirect"; // redirect는 get방식 호출
	}
}

package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//TODO 03 <context:component-scan>에 의해서 bean으로 만들어질 수 있는 com.min.edu 패키지의 하위 @Controller
@Controller
public class HomeController {
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	//TODO 04 처음 요청되는 Mapping 메소드 작성
	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public String home(String name, Model model) {
		logger.info("home에 전달 받은 param {}", name);
		model.addAttribute("name", name+"님 안녕하세요");
		return "home"; // ☜ view resolver에 의해서 만들어질 view 페이지의 이름, null인 경우 method 이름을 반환
	}
	
	//TODO 09 index.jsp POST 요청을 통해 name과 age 처리
	//			name의 parameter 값이 한글로 입력되었다면 전달받은 Controller에서 request를 Encoding 처리 하지 않는다면 system의 Encoding을 따라감
	@RequestMapping(value="/info.do", method=RequestMethod.POST)
	public String info(String name, int age) { // binding은 String이 아닌 경우 타입 형변환 오류가 발생할 수 있음
									// @RequestParam(name="age", value="")로 서버랑 화면이 이름이 달라도 받을 수 있음
		logger.info("info에서 전달받은 값 : {} {}", name, age);
		return "";
	}
}

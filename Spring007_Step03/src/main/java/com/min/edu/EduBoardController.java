package com.min.edu;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.IEduBoardService;
import com.min.edu.vo.EduVo;

@Controller
public class EduBoardController {
	private static final Logger logger = LoggerFactory.getLogger(EduBoardController.class);
	
	@Value("${driver}")
	private String driver;
	
	@Autowired
	private IEduBoardService service;
	
	//TODO 06_02 GET방식으로 호출하여 MVC 모델을 VMI하여 사용
	@RequestMapping(value="/selectBoard.do", method=RequestMethod.GET)
	public String selectBoard(Model model) {
		logger.info("Welcome EduBoardController selectBoard {}", new Date());
		List<EduVo> lists = service.selectBoard();
		model.addAttribute("lists", lists);
		return "boardList";
	}
	
	//TODO 07_02 POST로 전송된 값을 Spring에 binding을 통해서 자동으로 DTO 객체로 만들어 준다(setter 메소드 필수)
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(EduVo vo) {
		logger.info("Welcome VO의 setter를 통해서 자동으로 Parameter를 받고 객체 생성 insertBoard {}", vo);
		int n = service.insertBoard(vo);
		if(n>0) {
			return "redirect:/selectBoard.do";
		} else {
			return "error";
		}
	}
	
	//TODO 08_02 객체를 매핑할 DTO/VO가 없는 경우 Map으로 사용하여 name:value의 Map 객체를 사용한다.
	@RequestMapping(value="/insertBoardMap.do", method=RequestMethod.POST)
	public String insertBoard(@RequestParam Map<String, Object> paramMap) {
		logger.info("Welcome Spring의 @RequestParam을 통해 Map으로 입력 받아 사용한다. {}", paramMap);
		/* int n = service.insertBoard(paramMap); */
		return "redirect:/selectBoard.do";
	}
	
	//TODO 09_02 전송되는 name을 변경하여 다른 변수에 Bind하여 사용
	// 			값이 null이거나 없을 경우 default 값을 입력할 수 있다.
	/*
	 * @RequestParam(value="화면의 name", defaultValue="null이면 입력되는 값") String 사용변수
	 * 만약 입력되는 변수가 paging 처리 때 처럼 처음 호출되는 값이 없다면 예외 발생
	 * 따라서 반드시 defaultValue 설정을 통해 값을 초기화
	 */
	@RequestMapping(value="/insertBoardRequestParam.do", method=RequestMethod.POST)
	public String insertBoardRequestParam(
			@RequestParam("a") String id,
			@RequestParam("b") String title,
			@RequestParam("c") String content,
			@RequestParam(value="page", defaultValue="1") int paging
			) {
		logger.info("Welcome @RequestParam으로 값 처리 a {}", id);
		logger.info("Welcome @RequestParam으로 값 처리 b {}", title);
		logger.info("Welcome @RequestParam으로 값 처리 c {}", content);
		logger.info("Welcome @RequestParam으로 값 처리 paging {}", paging);
		return "redirect:/selectBoard.do";
	}
	
	//TODO 10_02 요청된 주소에서 @PathValiable와 {}를 통해서 특정 부분을 값으로 사용할 수 있다.
	@RequestMapping(value="/com/min/edu/{loging}/paramValue.do", method=RequestMethod.GET)
	public String pathVariable(@PathVariable("loging") String path) {
		logger.info("context:property-placeholder를 통해서 사용하는 값 : {}", driver);
		return path+"/main";
	}
	
	//TODO 11_04 Spring에 Transaction은 auto-proxy에 의해서 spring 제어권을 가진다.
	@RequestMapping(value="/transation.do", method=RequestMethod.POST)
	public String transation(EduVo vo) {
		logger.info("Welcome AnnotationTrasaction 처리 {}", vo);
		int n = service.transactionTest(vo);
		logger.info("Welcome AnnotationTrasaction 완료 처리 갯수 {}", n);
		return "redirect:/selectBoard.do"; 
	}

}


package com.min.edu;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.vo.UserVO;

@RestController
public class RegistRestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	 *	Spring 3.x 버전에서는 일반 @Controller 클래스에서 특정 @RequestMapping에 추가로 @ResponseBody의 선언을 통해서
	 *	해당 Mapping된 메소드가 응답을 값으로 처리해줄 수 있도록 해줌 (HttpServletResponse : 값전달)
	 *	servlet-context.xml에 <mvc:annotation-driven/>을 설정하면 DispatcherServlet이 값을 전달할 수 있도록 해줌
	 *	
	 *	■ produces = text/html; charset=UTF-8;
	 *	  JSON(String) -> dataType: 	   ☞ string
	 *	  JSON(String) -> dataType: "json" ☞ object
	 *	  String 	   -> dataType: "json" ☞ String은 JSON의 객체로 변경이 되지 않기 때문에 오류가 발생
	 *
	 *	■ produces = application/json; charset=UTF-8;
	 *	  JSON(String) -> dataType:		   ☞ object
	 *	  JSON(String) -> dataType:"json"  ☞ object
	 *
	 *	■ produces = 
	 *	  JSON(String) -> dataType:		   ☞ JSON(string) ☞ JSON.parse(obj) -> object
	 *
	 *	※※※※ produces = text/html charset=UTF-8;
	 *	Map<String,Boolean> -> dataType:    -> 406코드 발생(Map은 jackson-bind에 의해서 반드시 JSON 객체이어야만 함
	 *													그런데, 현재 적용된 produces의 지원되지 않는 형태인 text로 만들기 때문에 서버에서 406코드 발생) 
	 *	=> 해결방법
	 *		1) produces를 지운다 : 전송데이터는 JSON(String)
	 *		2) jackson-bind에 맞는 JSON타입으로 produces를 선언한다 : 전송데이터는 JSON(String)
	 *
	 */
	
//	@PostMapping(value = "/duplicateAjax.do")
//				,produces = "application/json; charset=UTF-8")
//	public Map<String, Object> duplicateAjax(String chkId){
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		UserVO vo = new UserVO();
//		vo.setId(chkId);
//		vo.setName("독수리");
//		map.put("isc", vo);
		
//		return map;
//	}
	
	@PostMapping(value = "/duplicateAjax.do",produces = "application/json; charset=UTF-8")
	public String duplicateAjax(String chkId){
		return "{\"isc\":\"true\"}";
	}
	
	
}

package com.min.edu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.service.IBoardService;
import com.min.edu.vo.Board_Vo;
import com.min.edu.vo.Paging_Vo;
import com.min.edu.vo.User_Vo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestPageController {
	
	@Autowired
	private IBoardService service;
	
	//TODO 19_05 페이징 REST 처리를 위한 REST API /page.do
	@PostMapping(value ="/page.do")
	public Map<String, Object> page(@RequestParam(name="page") int selectPage,
									HttpSession session,
									Model model){
		log.info("RestPageController 게시판 페이지 REST 처리를 위한 page.do : {}", selectPage);
		log.info("RestPageController page.do의 Session 확인 : {}, {}", session.getAttribute("loginVo"), session.getAttribute("row"));
		User_Vo loginVo = (User_Vo)session.getAttribute("loginVo");
		Paging_Vo pVo = (Paging_Vo)session.getAttribute("row");
		
		// ---- 페이징 VO 객체 값 입력
		pVo.setTotalCount(service.getAllBoardCount(new HashMap<String, Object>(){{
			put("auth", loginVo.getAuth());
		}}));
		
		pVo.setCountList(5);
		pVo.setCountPage(5);
		pVo.setTotalPage(pVo.getTotalCount());
		pVo.setPage(selectPage);
		pVo.setStagePage(selectPage);
		pVo.setEndPage(pVo.getCountPage());
		
		// ---- 게시글의 페이징 처리된 리스트
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", pVo.getPage()*pVo.getCountList()-(pVo.getCountList()-1));
		map.put("last", pVo.getPage()*pVo.getCountList());
		
		List<Board_Vo> lists = service.getAllBoardPage(map);
		
		// 반환되는 JSON 객체로 변환이 가능한 Map을 생성
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("lists", lists);
		result.put("row", pVo);
		result.put("memId", loginVo.getId());
		
//		return new HashMap<String, Object>(){{
//			put("check", "return value");
//		}};
		
		return result;
	}
	
}

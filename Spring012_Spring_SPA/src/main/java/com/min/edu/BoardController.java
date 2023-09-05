package com.min.edu;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.service.IBoardService;
import com.min.edu.vo.Board_Vo;
import com.min.edu.vo.Paging_Vo;
import com.min.edu.vo.User_Vo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {

	@Autowired
	private IBoardService service;
	
	@GetMapping("/boardList.do")
	public String boardList(Model model, HttpSession session,
			@RequestParam(required = false, defaultValue = "1")String page) {
		User_Vo loginVo = (User_Vo)session.getAttribute("loginVo");
		log.info("BoardController 게시글 전체 값을 저장하여 이동하는 boardList");
		//TODO 18_01 게시판(페이징) 전체글 조회하기
		//TODO 18_07 게시판(페이징) 테스트 후 값 전달하기
		//TODO 18_08 로그인 정보와 page 객체를 판단하여 현재 페이지의 글 개수와 페이지 객체를 전달
		//			 로그인된 권한에 따라 다른 쿼리의 결과를 가져온다
		log.info("BoardController 게시글 조회 전달된 page : {}", page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("auth", loginVo.getAuth());
		
		//현재 보고있는 페이지를 Session에 저장하여 페이지 번호를 유지한다
		Paging_Vo pVo = null;
		if(session.getAttribute("row")==null) {
			pVo = new Paging_Vo();
			session.setAttribute("row", pVo);
		} else {
			pVo = (Paging_Vo)session.getAttribute("row");
			page = String.valueOf(pVo.getPage());
		}
		
		log.info("----------------현재페이지 : {}", page);
		int selectPage = Integer.parseInt(page);
		log.info("----------------선택된페이지 : {}", selectPage);
		
		pVo.setTotalCount(service.getAllBoardCount(map)); //총 게시물의 개수
		pVo.setCountList(5); //출력될 게시글의 개수
		pVo.setCountPage(5); // 화면에 몇 개의 페이지를 보여줄 건지 (페이지 그룹)
		pVo.setTotalPage(pVo.getTotalCount()); // 총 페이지의 개수
		pVo.setPage(selectPage); // 화면에서 선택된 페이지 번호
		pVo.setStagePage(selectPage); // 페이지 그룹의 시작 번호
		pVo.setEndPage(pVo.getCountPage()); // 끝 번호
		
		//페이징처리된 결과를 가지고 옴
		// 현재 페이지 * 한 페이지의 글 개수 row - (한 페이지의 글 개수 row -1) : 1*5 - (5-1) = 1
		map.put("first", pVo.getPage()*pVo.getCountList()-(pVo.getCountList()-1));
		// 현재 페이지 * 한 페이지의 글 개수 row
		map.put("last", pVo.getPage()*pVo.getCountList());
		
		List<Board_Vo> lists = service.getAllBoardPage(map);
		
		model.addAttribute("lists", lists);
		model.addAttribute("page",pVo);
		
		return "boardList";
	}
	
	//TODO 20_07
	@GetMapping("/boardDelte.do")
	public String selBoardDelFlag(String seq, HttpServletResponse response) throws IOException {
		log.info("BoardController 게시글 삭제처리 selBoardDelFlag : {}",seq);
		int n = service.selBoardDelFlag(seq);
		if(n == 1) {
			return "redirect:/boardList.do";
		} else {
			SpringUtils.servletAlert(response, "잘못된 삭제 처리", "logout.do");
			return null;
		}
	}
	
	
	
}

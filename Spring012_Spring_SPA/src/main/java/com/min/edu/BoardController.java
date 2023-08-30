package com.min.edu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.PagaVo;
import com.min.edu.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private IBoardService service;

	@GetMapping(value="/boardList.do")
	public String boardList(Model model, HttpSession session,
							@RequestParam(required=false, defaultValue="1") String page ) {
		log.info("BoardController 게시글 전체 값을 지정하여 이동하는 boardList");
		UserVo vo = (UserVo)session.getAttribute("loginVo");
		//TODO 18_01 게시판(페이징) 전체글 조회하기
		//TODO 18_07 게시판(페이징) 테스트 후 값 전달
		//TODO 18_08 로그인 정보와 page 객체를 판단하여 현재 페이지의 글 갯수와 페이지 객체 전달
		//				로그인 된 권한에 따라 다른 쿼리의 결과 가져옴
		
		log.info("BoardController page : {}",page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("auth", vo.getAuth());
		
		// 현재 보고 있는 페이지를 Session에 저장하여 페이지 번호를 유지
		PagaVo pVo = null;
		if(session.getAttribute("row")==null) {
			pVo = new PagaVo();
		} else {
			pVo = (PagaVo)session.getAttribute("row");
			page = String.valueOf(pVo.getPage());
		}
		
		log.info("--------------------- 현재 : {}", page);
		int selectPage = Integer.parseInt(page);
		log.info("--------------------- 선택 : {}", selectPage);
		
		pVo.setTotalCount(service.getAllBoardCount(map)); // 총 게시물 갯수
		pVo.setCountList(5); // 출력될 게시글 갯수
		pVo.setCountPage(5); // 페이지 그룹
		pVo.setTotalPage(pVo.getTotalCount()); // 총 페이지의 갯수
		pVo.setPage(selectPage); // 화면에서 선택된 페이지 번호
		pVo.setStagePage(selectPage); // 페이지 그룹의 시작 번호
		pVo.setEndPage(pVo.getCountPage()); // 페이지 그룹의 끝 번호
		
		// 페이지 처리된 결과를 가지고 옴
		// 현재 페이지 * 한 페이지의 글 개수 (row) - (한페이지 글 개수 row-1)
		map.put("first", pVo.getPage()*pVo.getCountList()-(pVo.getCountList()-1));
		
		// 현재 페이지 * 한 페이지의 글 개수 (row)
		map.put("last", pVo.getPage()*pVo.getCountList());
		
		List<BoardVo> list = service.getAllBoardPage(map);
		model.addAttribute("list", list);
		model.addAttribute("page", pVo);
		
		return "boardList";
	}
}

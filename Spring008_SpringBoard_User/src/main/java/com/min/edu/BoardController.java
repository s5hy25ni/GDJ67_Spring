package com.min.edu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.UserVo;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IBoardService service;
	
	//TODO 07_02 게시글 전체 조회 후 Model로 값 전달
	@RequestMapping(value="/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model) {
		logger.info("Welcome BoardController 전체조회 boardList");
		List<BoardVo> list = service.userBoardList();
		for (BoardVo vo : list) {
			String content = vo.getContent();
			content.replaceAll("<", "&lt;");
			content.replaceAll(">", "&gt;");
			vo.setContent(content);
		}
		
		model.addAttribute("list",list);
		return "boardList";
	}
	
	//TODO 10_02 다중삭제 로직 후에 boardList.do로 redirect
	@RequestMapping(value="/multiDel.do", method = RequestMethod.POST)
	public String multiDel(String[] chkVal) {
		logger.info("Welcome BoardController 삭제 단일/다중 삭제");
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", chkVal);
		
		service.delFlagBoard(map);
		
		return "redirect:/boardList.do";
	}
	
	//TODO 11_02 새글작성 화면으로 이동
	@RequestMapping(value = "/insertBoard.do", method=RequestMethod.GET)
	public String insertBoard() {
		logger.info("Welcome BoardController 새글작성 화면이동");
		return "writeBoardFrom";
	}
	
	//TODO 11_04 새글정보 입력 BoardVo 바인딩
	@RequestMapping(value="/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(BoardVo bVo, HttpSession session) {
		logger.info("Welcome BoardController 새글 정보 입력 {}", bVo);
		bVo.setId(((UserVo)session.getAttribute("loginVo")).getId());
		int n = service.writeBoard(bVo);
		return (n==1)?"redirect:/boardList.do":"redirect:/logout.do";
	}
	
	//TODO 12_02 글 상세보기
	@RequestMapping(value="/detailBoard.do", method=RequestMethod.GET)
	public String detailBoard(@RequestParam("seq") String id, Model model) {
		logger.info("Welcome BoardController 상세글 보기");
		BoardVo vo = service.getOneBoard(id);
		model.addAttribute("vo", vo);
		return "detailBoard";
	}
	
	//TODO 15_02 답글 작성 화면으로 이동, parameter 전송범위
	@RequestMapping(value="/replyInsert.do", method=RequestMethod.GET)
	public String replyInsert() {
		logger.info("Welcome BoardController 답글입력 폼");
		return "replyInsert";
	}
	
	//TODO 15_04 답글 입력
	@RequestMapping(value="/replyInsert.do", method=RequestMethod.POST)
	public String replyInsert(BoardVo bVo, HttpSession session) {
		logger.info("Welcome BoardController 답글입력");
		UserVo uVo = (UserVo)session.getAttribute("loginVo");
		uVo.setId(uVo.getId());
		int n = service.reply(bVo);
		if(n!=0) {
			return "redirect:/boardList.do";			
		} else {			
			return "redirect:/replyInsert.do?chkVal="+bVo.getSeq();			
		}
	}
}

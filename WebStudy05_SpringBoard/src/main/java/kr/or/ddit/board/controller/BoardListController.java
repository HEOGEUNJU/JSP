package kr.or.ddit.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.dao.AttachDAO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.vo.AttatchVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

// /board/boardList.do (검색조건 : 작성자, 글의 내용, 전체)

@Controller
@RequestMapping("/board/boardList.do")
public class BoardListController {

	@Inject
	private BoardService service;


	@GetMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String boardList(
	 // required true면 param이 무조건 있어야한다 라는 뜻이다. false면 default값 줘야함.
      @RequestParam(value="page", required=false, defaultValue="1") int currentPage
      , @ModelAttribute("simpleCondition") SearchVO searchVO
      , Model model
	) throws ServletException {
      PagingVO<BoardVO> pagingVO = new PagingVO<>();
      pagingVO.setCurrentPage(currentPage);
      pagingVO.setSimpleCondition(searchVO);
		
      service.retrieveBoardList(pagingVO);
      
      model.addAttribute("pagingVO", pagingVO);
      
      return "board/boardList";
	}
}

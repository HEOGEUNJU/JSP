package kr.or.ddit.board.controller;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.board.dao.BoardDAO;
import kr.or.ddit.board.exception.AuthenticationException;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.validate.UpdateGroup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/board/boardUpdate.do")
public class BoardUpdateController {
	
	//boardService를 타겟으로한 프록시
	private final BoardService service;
	
	@PostConstruct
	public void init() {
		  log.info("주입된 service 객체 : {}" , service.getClass().getName()); 
	   }
	
	@GetMapping
	public String updateForm(
		@RequestParam("what") int boNo,
		Model model
	) {
		BoardVO board = service.retrieveBoard(boNo);
		model.addAttribute("board", board);
		return "board/boardEdit";
	}
	
	@PostMapping
	public String updateProcess(
		@Validated(UpdateGroup.class) @ModelAttribute("board") BoardVO board
		, Errors errors
		, Model model
		) {
		
		String viewName = null;
		if(!errors.hasErrors()) {
			try {
				int result = service.modifyBoard(board);
				if(result>0) {
					viewName = "redirect:/board/boardView.do?what="+board.getBoNo();
				}
				else {
					model.addAttribute("message", "서버 오류, 쫌다 다시");
					viewName = "board/boardEdit";
				}
			}catch (AuthenticationException e) {
				model.addAttribute("message", "비번오류");
				viewName = "board/boardEdit";
			}
		}else {
			viewName = "board/boardEdit";
		}
		return viewName;
	}
	
	
}

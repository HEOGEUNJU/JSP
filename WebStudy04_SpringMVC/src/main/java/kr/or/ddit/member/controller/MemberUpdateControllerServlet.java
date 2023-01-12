package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vaildate.InsertGroup;
import kr.or.ddit.vaildate.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/member/memberUpdate.do")
public class MemberUpdateControllerServlet{
	
	private final MemberService service;
	
	@GetMapping
	public String updateForm(
		@SessionAttribute("authMember") MemberVO authMember
		, Model model
		){
			MemberVO member = service.retrieveMember(authMember.getMemId());
			
			model.addAttribute("member", member);
			
			return "member/memberForm";
	}
	
	@PostMapping 
	public String updateProcess(
//		 @RequestPart(value="memImage", required =false) MultipartFile memImage
//		Group을 사용하기 위해 Validated사용
		 @Validated(UpdateGroup.class) @ModelAttribute("member") MemberVO member
		, BindingResult errors //검증을 하고 바인딩을 할때는 검증을 한 파라미터 바로 뒤에 넣어야한다.
		, @Valid ProdVO prod
//		, Errors errorProd
		, Model model
		, HttpSession session//session에 값을 넣어야 한다면 이렇게 작성해야 한다.
	) throws ServletException, IOException{
//		member.setMemImage(memImage);
		
		String viewName = null;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyMember(member);
			switch (result) {
			case INVALIDPASSWORD:
				model.addAttribute("message", "비밀번호 오류");
				viewName = "member/memberForm";
				break;
			case FAIL:
				model.addAttribute("message", "서버 오류, 쫌따 다시.");
				viewName = "member/memberForm";
				break;
				
			default:
				MemberVO modifiedMember = service.retrieveMember(member.getMemId());
				session.setAttribute("authMember", modifiedMember);
				viewName = "redirect:/mypage.do";
				break;
			}
		}else {
			viewName = "member/memberForm";
		}
		return viewName;
	}
}
























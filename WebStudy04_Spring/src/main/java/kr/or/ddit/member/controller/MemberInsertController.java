package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.MemberVO;

/**
 *	Backend controller(command handler) --> Plain Old Java Object
 */
@Controller
@RequestMapping("/member/memberInsert.do")
public class MemberInsertController{
	private MemberService service = new MemberServiceImpl();
	
	@GetMapping
	public String memberForm() {
		return "member/memberForm";
	}
	
	@PostMapping
	public String memberInsert(
			HttpServletRequest req
			, @Validated(InsertGroup.class) @ModelAttribute("member") MemberVO member
			, Errors errors
			, @RequestPart(value="memImage", required=false) MultipartFile memImage
		)throws ServletException, IOException {

		boolean valid = !errors.hasErrors();
		
		String viewName = null;
		
		if(valid) {
			ServiceResult result = service.createMember(member);
			switch (result) {
			case PKDUPLICATED:
				req.setAttribute("message", "아이디 중복");
				viewName = "member/memberForm";
				break;
				
			case FAIL:
				req.setAttribute("message", "서버에 문제 있음. 쫌따 다시 하셈");
				viewName = "member/memberForm";
				break;
				
			default:
				viewName = "redirect:/";
				break;
			}
		} else {
			viewName = "member/memberForm";
		}
		return viewName;
	}
}

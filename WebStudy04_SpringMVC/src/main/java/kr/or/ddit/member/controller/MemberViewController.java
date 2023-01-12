package kr.or.ddit.member.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberViewController{
	
	private final MemberService service;
	
//	void 리턴 타입으로 logical view name 이 생략된 경우,
//	HandlerAdapter는 RequestToViewNameTraslator를 이용해 view를 검색함
	
	@GetMapping("/member/memberView.do")
	public void memberView(
		@RequestParam(value="who", required=true) String memId
		, Model model
	) {
//		1. 
//		String memId = req.getParameter("who");
//		if(StringUtils.isBlank(memId)) {
//			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//			return null;
//		}
//		2. 
		MemberVO member = service.retrieveMember(memId);
//		3. 
		model.addAttribute("member", member);
//		4.
//		String viewName = "member/memberView";
//		
//		return viewName;
	}
}
	

























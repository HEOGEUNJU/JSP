package kr.or.ddit.member.controller;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.security.AuthMember;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

@Controller
public class MypageController{
	
	@Inject
	private MemberService service;
	
	@RequestMapping("/mypage")
	public String myPage(
		Model model,
		@AuthenticationPrincipal MemberVOWrapper principal,
		@AuthenticationPrincipal(expression="realMember") MemberVO member,
		@AuthMember MemberVO authMember
	) {
		MemberVOWrapper principal = (MemberVOWrapper) req.getUserPrincipal();
		
//		MemberVO authMember = principal.getRealMember();
		
//		MemberVO member = service.retrieveMember(authMember.getMemId()); // 현재 로그인된 모든 MemberVO
		
		model.addAttribute("member", member);
		
		return "member/memberView"; // logical view name

	}
}

package kr.or.ddit.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

@Controller
public class MypageControllerServlet extends HttpServlet{
	
	@Inject
	private MemberService service;
	
	
	@RequestMapping("/mypage.do")
	public String myPage(
		//request, response, session과 같은 저수준의 api는 스프링에 잘 사용하지 않는다.
		  Model model
		, MemberVOWrapper principal
	) {
//		MemberVOWrapper principal = (MemberVOWrapper) req.getUserPrincipal();
		
		MemberVO authMember = principal.getRealMember();
		
		MemberVO member = service.retrieveMember(authMember.getMemId());
		
		model.addAttribute("member", member);
		
		return "member/memberView";
	}
}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		new InternalResourceViewResolver("/WEB-INF/views/", ".jsp").resolveView(viewName, req, resp);
//	}
//}





















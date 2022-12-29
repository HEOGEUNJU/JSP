package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.memo.controller.MemoControllerServlet;
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteControllerServlet extends HttpServlet {
	
	private MemberService service = new MemberServiceImpl();
	
	private static final Logger log = LoggerFactory.getLogger(MemoControllerServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String memPass = req.getParameter("memPass");
		HttpSession session = req.getSession();
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		req.setAttribute("member", authMember);
		
		ServiceResult result = null;
		String viewName = null;
		
		if(memPass.equals(authMember.getMemPass())) {
			result = service.removeMember(authMember);
		}else {
			result = ServiceResult.INVALIDPASSWORD;
		}
		switch (result) {
		case INVALIDPASSWORD:
			req.setAttribute("message", "비밀번호 오류.");
			viewName = "member/memberView";
			break;
		case FAIL:
			req.setAttribute("message", "서버에 문제 있음. 좀따 다시 하셈.");
			viewName = "member/memberView";
			break;
		default:
			req.setAttribute("message", "정상적으로 삭제 되었습니다.");
			session.invalidate();
			viewName = "redirect:/";
			break;
		}
		
		new InternalResourceViewResolver("/WEB-INF/views/",".jsp").resolveView(viewName, req, resp);
		
	}
}

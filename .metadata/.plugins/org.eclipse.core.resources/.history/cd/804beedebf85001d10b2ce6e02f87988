package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberView.do")
public class MemberViewControllerServlet extends HttpServlet{

	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 대상찾기
		String who = req.getParameter("who");
		if(StringUtils.isBlank(who)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
//		2. vo선언, 서비스 메소드 쓰고
		MemberVO memberImpl = service.retrieveMember(who);
//		3. vo값 setattribute해주고
		req.setAttribute("member", memberImpl);
//		4. viewname만들고
		String viewName = "/WEB-INF/views/member/memberView.jsp";
//		5. 전송
		 if(viewName.startsWith("redirect:")) {
	        viewName = viewName.substring("redirect:".length());
	        resp.sendRedirect(req.getContextPath() + viewName);
	    } else {
	        req.getRequestDispatcher(viewName).forward(req, resp);
	    }
	}
}

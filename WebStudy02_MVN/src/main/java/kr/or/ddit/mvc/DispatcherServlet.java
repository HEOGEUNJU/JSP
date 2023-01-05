package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.commons.IndexControllerServlet;
import kr.or.ddit.login.controller.LoginProcessControllerServlet;
import kr.or.ddit.login.controller.LogoutControllerServlet;
import kr.or.ddit.member.controller.MemberInsertControllerServlet;
import kr.or.ddit.member.controller.MemberListControllerServlet;
import kr.or.ddit.member.controller.MemberViewControllerServlet;
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.mvc.view.ViewResolver;
import kr.or.ddit.prod.controller.ProdListControllerServlet;

public class DispatcherServlet extends HttpServlet {
	private ViewResolver viewResolver;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		viewResolver = new InternalResourceViewResolver("/WEB-INF/views/" , ".jsp");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

//		String requestURI = req.getRequestURI();
//		requestURI = requestURI.substring(req.getContextPath().length());
		String requestURI = req.getServletPath();
		
		AbstractController controller = null;
		if("/member/memberList.do".equals(requestURI)) {
			controller = new MemberListControllerServlet();
		}else if("/prod/prodList.do".equals(requestURI)) {
			controller = new ProdListControllerServlet();
		}else if("/member/memberView.do".equals(requestURI)) {
			controller = new MemberViewControllerServlet();
		}else if("/index.do".equals(requestURI)) {
			controller = new IndexControllerServlet();
		}else if("/member/memberInsert.do".equals(requestURI)) {
			controller = new MemberInsertControllerServlet();
		}else if("/login/loginProcess.do".equals(requestURI)) {
			controller = new LoginProcessControllerServlet();
		}else if("/login/logout.do".equals(requestURI)) {
			controller = new LogoutControllerServlet();
		}
		
			
		
		// 처리할 수 없는 요청일때
		if(controller==null) {
			resp.sendError(404, requestURI+" 는 처리할 수 없는 자원임(Not found).");
			return;
		}
		String viewName = controller.process(req,resp);
		if(viewName == null) {
			if(!resp.isCommitted()) {
				resp.sendError(500, "논리적인 뷰 네임은 null일 수 없음.");
			}
		}else {
			viewResolver.resolveView(viewName, req, resp);
		}

	}

}

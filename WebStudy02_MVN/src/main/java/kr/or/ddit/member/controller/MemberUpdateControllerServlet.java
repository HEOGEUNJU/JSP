package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.memo.controller.MemoControllerServlet;
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.validate.ValidationUtils;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberUpdate.do")
public class MemberUpdateControllerServlet extends HttpServlet{

	private MemberService service = new MemberServiceImpl();
	
	private static final Logger log = LoggerFactory.getLogger(MemoControllerServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		
		MemberVO member = service.retrieveMember(authMember.getMemId());
		
		log.info("member : {}", member);
		
		req.setAttribute("member", member);
		
		String viewName = "member/memberForm";
		
		new InternalResourceViewResolver("/WEB-INF/views/",".jsp").resolveView(viewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		2. vo에 만들고 파라미터값 넣기
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
//		1. form 파라미터 받아오기
//		member.setMemId(req.getParameter("memId"));
		
		try {
			BeanUtils.populate(member, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new ServletException(e);
		}
		String viewName = null;
		
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		
		boolean valid = ValidationUtils.validate(member, errors, UpdateGroup.class);
		
		if(valid) {
			log.info("member : {}", member);
			ServiceResult result = service.modifyMember(member);
			switch (result) {
			case INVALIDPASSWORD:
				req.setAttribute("message", "비밀번호 오류.");
				viewName = "member/memberForm";
				break;
			case FAIL:
				req.setAttribute("message", "서버에 문제 있음. 좀따 다시 하셈.");
				viewName = "member/memberForm";
				break;
			default:
				viewName = "redirect:/mypage.do";
				break;
			}
		}else {
			viewName = "member/memberForm";
		}
		
		
		new InternalResourceViewResolver("/WEB-INF/views/",".jsp").resolveView(viewName, req, resp);
	}
}

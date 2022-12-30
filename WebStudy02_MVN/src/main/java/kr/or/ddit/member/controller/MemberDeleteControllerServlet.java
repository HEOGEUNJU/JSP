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

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.validate.DeleteGruop;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.ValidationUtils;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteControllerServlet extends HttpServlet{
   
   private MemberService service = new MemberServiceImpl();
   private MemberDAO dao = new MemberDAOImpl();
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
//      1. 
      HttpSession session = req.getSession();
      MemberVO authMember = (MemberVO) session.getAttribute("authMember");
      String memId = authMember.getMemId();
      String memPass = req.getParameter("memPass");
      
      MemberVO inputData = new MemberVO();
      inputData.setMemId(memId);
      inputData.setMemPass(memPass);
      
      Map<String, List<String>> errors = new LinkedHashMap<>();
      boolean valid = ValidationUtils.validate(inputData, errors, DeleteGruop.class);
      
      String viewName = null;
      
      if(valid) {
         ServiceResult result = service.removeMember(inputData);
         switch (result) {
         case INVALIDPASSWORD:
            session.setAttribute("message", "비번 오류");
            viewName = "redirect:/mypage.do";
            break;
         case FAIL:
            session.setAttribute("message", "서버 오류");
            viewName = "redirect:/mypage.do";
            
            break;

         default: // OK
            session.invalidate();
            viewName = "redirect:/";
            break;
         }
      }else {
         session.setAttribute("message", "아이디나 비밀번호 누락");
         viewName = "redirect:/mypage.do";
      }
      
      new InternalResourceViewResolver().resolveView(viewName, req, resp);
   }
}
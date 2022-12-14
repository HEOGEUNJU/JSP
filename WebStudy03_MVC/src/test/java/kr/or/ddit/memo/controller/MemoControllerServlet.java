package kr.or.ddit.memo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import kr.or.ddit.memo.dao.DataBaseMemoDAOImpl;
import kr.or.ddit.memo.dao.MemoDAO;
import kr.or.ddit.vo.MemoVO;

@WebServlet("/memo")
public class MemoControllerServlet extends HttpServlet{
   
//   private MemoDAO dao = FileSystemMemoDAOImpl.getInstance();
   private MemoDAO dao = DataBaseMemoDAOImpl.getInstance();
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   // 1. 요청분석
      String accept = req.getHeader("Accept");
      if(accept.contains("xml")) {
         resp.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
         return;
      }
   // 2. 모델확보
      List<MemoVO> memoList = dao.selectMemoList();
      System.out.println(memoList);
   // 3. 모델공유
      req.setAttribute("memoList", memoList);
   // 4. 뷰선택
      String viewName = "/jsonView.do";
   // 5. 뷰로 이동
      req.getRequestDispatcher(viewName).forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      Post-Redirect-Get : PRG pattern
      MemoVO memo = getMemoFromRequest(req);
      dao.insertMemo(memo);
      resp.sendRedirect(req.getContextPath() + "/memo");
   }
   
   private MemoVO getMemoFromRequest(HttpServletRequest req) throws IOException {
      req.setCharacterEncoding("UTF-8");
      MemoVO memo = null;
      
      String contentType = req.getContentType();
      
      if(contentType.contains("json")) {
         try(
               BufferedReader br = req.getReader(); // body content read 용 입력 스트림
            ){
               memo =  new ObjectMapper().readValue(br, MemoVO.class);
            }
      } else if(contentType.contains("xml")) {
         try(
               BufferedReader br = req.getReader(); // body content read 용 입력 스트림
            ){
               memo =  new XmlMapper().readValue(br, MemoVO.class);
            }
      } else {
         memo = new MemoVO();
         memo.setWriter(req.getParameter("writer"));
         memo.setDate(req.getParameter("date"));
         memo.setContent(req.getParameter("content"));
      }
      return memo;
      
   }

   @Override
   protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      
   }
   
   @Override
   protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      
   }
}
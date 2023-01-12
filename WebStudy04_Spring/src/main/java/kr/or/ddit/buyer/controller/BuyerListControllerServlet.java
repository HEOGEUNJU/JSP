package kr.or.ddit.buyer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.mvc.annotation.resolvers.ModelAttribute;
import kr.or.ddit.mvc.annotation.resolvers.RequestParam;
import kr.or.ddit.mvc.annotation.stereotype.Controller;
import kr.or.ddit.mvc.annotation.stereotype.RequestMapping;
import kr.or.ddit.mvc.view.InternalResourceViewResolver;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BuyerListControllerServlet extends HttpServlet{
	private BuyerService service = new BuyerServiceImpl();
	
	@RequestMapping("/buyer/buyerList.do")
	public String buyerList(
		@RequestParam(value="page", required=false, defaultValue="1") int currentPage
		, @ModelAttribute SearchVO simpleCondition
		, HttpServletRequest req
	){
		PagingVO<BuyerVO> pagingVO = new PagingVO<>(4,2); 
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);
		
		service.retrieveBuyerList(pagingVO);
		
		req.setAttribute("pagingVO" , pagingVO);
		
		log.info("paging data : {}", pagingVO);
		
		String viewName = "buyer/buyerList";
		return viewName;
	}
}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		
//		String pageParam = req.getParameter("page");
//		String searchType = req.getParameter("searchType");
//		String searchWord = req.getParameter("searchWord");
//		
//		SearchVO simpleCondition = new SearchVO(searchType, searchWord);
//		
//		int currentPage = 1;
//		if(StringUtils.isNumeric(pageParam)) {
//			currentPage = Integer.parseInt(pageParam);
//		}
//		
//	
//		
//		
//
//		new InternalResourceViewResolver("/WEB-INF/views/", ".jsp").resolveView(viewName, req, resp);
//	}
//}












package kr.or.ddit.prod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.mvc.annotation.resolvers.RequestParam;
import kr.or.ddit.mvc.annotation.stereotype.Controller;
import kr.or.ddit.mvc.annotation.stereotype.RequestMapping;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

@Controller
public class ProdUpdateController {
	private ProdService service = new ProdServiceImpl();
	
	@RequestMapping("/prod/prodUpdate.do")
	public String updateForm(
		@RequestParam(value="what", required=true) String prodId
		, HttpServletRequest req
	) {
		ProdVO prod = service.retrieveProd(prodId);
		
		req.setAttribute("prod", prod);
		
		String viewName = "prod/prodForm"; // logical view name
		
		return viewName;
	}
}

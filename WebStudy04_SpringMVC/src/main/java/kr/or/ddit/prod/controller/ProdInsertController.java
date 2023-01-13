package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.vaildate.InsertGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

@RequestMapping(value ="/prod/new")
public class ProdInsertController{
   @Inject
   private ProdService service;

   @Inject
   private OthersDAO othersDAO;
	
	@ModelAttribute("lprodList")
	public List<Map<String, Object>> lprodList() {
	   return othersDAO.selectLprodList();
	}
	@ModelAttribute("buyerList")
	public List<BuyerVO> buyerList() {
		return othersDAO.selectBuyerList(null);
	}
	@ModelAttribute("prod")
	public ProdVO prod() {
		return new ProdVO();
	}
	@GetMapping
	public String prodForm(){
		return "prod/prodForm";
	}
	
	@PostMapping
	public String inserProcess(
		@Validated(InsertGroup.class) @ModelAttribute("prod") ProdVO prod //command pattern
		, Errors errors
		, HttpServletRequest req 
	) throws IOException, ServletException{
		
		boolean valid = !errors.hasErrors();
		
		String viewName = null;
		if(valid) {
			ServiceResult result = service.createProd(prod);
			if(ServiceResult.OK == result) {
				viewName = "redirect:/prod/" + prod.getProdId();
			}else {
				req.setAttribute("message", "서버 오류, 쫌따 다시");
				viewName = "prod/prodForm";
			}
		}else {
			viewName = "prod/prodForm";
		}
		return viewName;
		
		
		
	}
}

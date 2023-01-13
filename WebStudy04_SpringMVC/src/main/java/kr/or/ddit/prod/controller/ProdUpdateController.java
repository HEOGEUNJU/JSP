package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.vaildate.UpdateGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;

// /prod/prodUpdate.do(GET, POST)

@Controller
@RequestMapping("/prod/{prodId}/edit")
public class ProdUpdateController {

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
		
	@GetMapping
	public String updateForm(
		@PathVariable String prodId
		, Model model
	) {
		ProdVO prod = service.retrieveProd(prodId);
		
		model.addAttribute("prod", prod);
		
		String viewName = "prod/prodForm"; // logical view name
		
		return viewName;
	}
	
//	@PutMapping
	@PostMapping
	public String updateProd(
			@Validated(UpdateGroup.class)@ModelAttribute("prod")ProdVO prod
			, BindingResult errors
			, Model model
	) throws IOException, ServletException{

		String viewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyProd(prod);
			if(ServiceResult.OK == result) {
				viewName = "redirect:/prod/" + prod.getProdId();
			}else {
				model.addAttribute("message", "서버 오류, 쫌따 다시");
				viewName = "prod/prodForm";
			}
		}else {
			viewName = "prod/prodForm";
		}
		return viewName;
	}
	
}

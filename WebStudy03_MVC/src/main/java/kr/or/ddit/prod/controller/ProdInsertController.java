package kr.or.ddit.prod.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.mvc.annotation.RequestMethod;
import kr.or.ddit.mvc.annotation.resolvers.ModelAttribute;
import kr.or.ddit.mvc.annotation.resolvers.RequestPart;
import kr.or.ddit.mvc.annotation.stereotype.Controller;
import kr.or.ddit.mvc.annotation.stereotype.RequestMapping;
import kr.or.ddit.mvc.multipart.MultipartFile;
import kr.or.ddit.mvc.multipart.MultipartHttpServletRequest;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.ValidationUtils;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProdInsertController{

	private ProdService service = new ProdServiceImpl();
	private OthersDAO othersDAO = new OthersDAOImpl();
	
	private void addAttribute(HttpServletRequest req) {
		req.setAttribute("lprodList", othersDAO.selectLprodList());
		req.setAttribute("buyerList", othersDAO.selectBuyerList(null));
	}
	
	@RequestMapping("/prod/prodInsert.do")
	public String prodForm(HttpServletRequest req){
		addAttribute(req);
		return "prod/prodForm";
	}
	
	@RequestMapping(value ="/prod/prodInsert.do", method=RequestMethod.POST)
	public String inserProcess(
		@ModelAttribute("prod") ProdVO prod //command pattern
		, HttpServletRequest req 
		,@RequestPart("prodImage")MultipartFile prodImage
	) throws IOException, ServletException{
		
		addAttribute(req);
		
		prod.setProdImage(prodImage);
		
//		1. 저장
		String saveFolderURL = "/resources/prodImages";
		ServletContext application = req.getServletContext();
		String saveFolderPath = application.getRealPath(saveFolderURL);
		File saveFolder = new File(saveFolderPath);
		if(!saveFolder.exists())
				saveFolder.mkdirs(); //경로가 없다면 생성
		
		prod.saveTo(saveFolder);
		
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = ValidationUtils.validate(prod, errors, InsertGroup.class);
		String viewName = null;
		if(valid) {
			ServiceResult result = service.createProd(prod);
			if(ServiceResult.OK == result) {
				viewName = "redirect:/prod/prodView.do?what=" + prod.getProdId();
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

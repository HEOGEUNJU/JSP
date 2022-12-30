package kr.or.ddit.prod.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.exception.UserNotFoundException;
import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.login.service.AuthenticateServiceImpl;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.memo.controller.MemoControllerServlet;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements ProdService {
	// 결합력 최상인 상태
	private ProdDAO prodDAO = new ProdDAOImpl();
	
	// 인증관련된 service
	private AuthenticateService authService = new AuthenticateServiceImpl(); 
	
	private static final Logger log = LoggerFactory.getLogger(MemoControllerServlet.class);
	
	@Override
	public ProdVO retrieveProd(String prodId) {
		ProdVO prod = prodDAO.selectProd(prodId);
		if(prod == null)
			throw new RuntimeException(String.format(prodId +"에 해당하는 구매자 없음"));
//			throw new UserNotFoundException(String.format(prodId +"에 해당하는 구매자 없음"));
		return prod;
	}

	@Override
	public List<ProdVO> retrieveProdList(PagingVO<ProdVO> pagingVO) {
		pagingVO.setTotalRecord(prodDAO.selectTotalRecord(pagingVO));
		List<ProdVO> prodList = prodDAO.selectProdList(pagingVO); 
		pagingVO.setDataList(prodList);
		return prodList;
	}

}

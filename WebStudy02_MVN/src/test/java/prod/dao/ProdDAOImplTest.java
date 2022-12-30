package prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProdDAOImplTest {

	private ProdDAO dao = new ProdDAOImpl();
	
	
	@Test
	public void testSelectProd() {
		ProdVO prod =dao.selectProd("P101000001");
		assertNotNull(prod);
		log.info("buyer : {}" , prod.getBuyer());
		prod.getMemberSet().stream()
							.forEach(user->{
								log.info("구매자 : {}", user);
							});
	}
	@Test
	
	public void testListProd() {
		PagingVO<ProdVO> pagingVO = new PagingVO<>(); 
		pagingVO.setTotalRecord(dao.selectTotalRecord(pagingVO));
		pagingVO.setCurrentPage(2);
		List<ProdVO> prodList = dao.selectProdList(pagingVO);
		prodList.stream()
				.forEach(System.out::println);
		pagingVO.setDataList(prodList);
	}
}

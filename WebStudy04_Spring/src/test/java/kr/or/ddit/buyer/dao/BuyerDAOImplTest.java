package kr.or.ddit.buyer.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuyerDAOImplTest {
	
	private BuyerDAO dao = new BuyerDAOImpl();
	private PagingVO<BuyerVO> pagingVO;
	
	@Before
	public void setUp() {
		pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(1);
	}

	@Test
	public void testSelectTotalRecord() {
		int tr = dao.selectTotalRecord(pagingVO);
		log.info("total record : {}", tr);
	}

	@Test
	public void testSelectBuyerList() {
		List<BuyerVO> list = dao.selectBuyerList(pagingVO);
		list.stream().forEach(i->{
			log.info("{}", i);
		});
	}

	@Test
	public void testSelectBuyer() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertBuyer() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBuyer() {
		fail("Not yet implemented");
	}

}

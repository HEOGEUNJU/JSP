package kr.or.ddit.alba.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.ddit.alba.vo.AlbaVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:webapp/WEB-INF/spring/*-context.xml")
@WebAppConfiguration
@Slf4j
public class AlbaDAOTest {
	
	@Inject
	private AlbaDAO albaDAO;
	
	private PagingVO<AlbaVO> pagingVO;
	@Before
	public void setUp() throws Exception {
		pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(1);
	}

	//@Test
	public void testInsertAlba() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAlbaList() {
		List<AlbaVO> dataList = albaDAO.selectAlbaList(pagingVO);
		assertNotEquals(0, dataList.size());
	}

	//@Test
	public void testSelectTotalRecord() {
		fail("Not yet implemented");
	}

	//@Test
	public void testSelectAlba() {
		fail("Not yet implemented");
	}

	//@Test
	public void testUpdateAlba() {
		fail("Not yet implemented");
	}

	//@Test
	public void testDeleteAlba() {
		fail("Not yet implemented");
	}

}

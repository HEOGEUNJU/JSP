package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;
@RunWith(SpringRunner.class)
@ContextConfiguration("file:webapp/WEB-INF/spring/*-context.xml") // 2. 테스트용 가상 컨테이너 생성
@WebAppConfiguration// 3. WebApplicationContext로 가상 컨테이너 생성
@Slf4j
public class BoardDAOTest {
	@Inject
	private BoardDAO boardDAO;
	
	private PagingVO<BoardVO> pagingVO;	
	
	@Before
	public void setUp() throws Exception {
		pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(1);
	}

	//@Test
	public void testInsertBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectBoardList() {
		List<BoardVO> dataList = boardDAO.selectBoardList(pagingVO);
		assertNotEquals(0, dataList.size());
	}

	//@Test
	public void testSelectTotalRecord() {
		fail("Not yet implemented");
	}

	//@Test
	public void testSelectBoard() {
		fail("Not yet implemented");
	}

	//@Test
	public void testUpdateBoard() {
		fail("Not yet implemented");
	}

	//@Test
	public void testDeleteBoard() {
		fail("Not yet implemented");
	}

}

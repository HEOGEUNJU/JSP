package kr.or.ddit.alba.service;

import kr.or.ddit.alba.vo.AlbaVO;
import kr.or.ddit.vo.PagingVO;

public interface AlbaService {
	public int createAlba(AlbaVO alba);
	public void retrieveAlbaList(PagingVO<AlbaVO> pagingVO);
	public AlbaVO retrieveAlba(String alId);
	public int modifyAlba(AlbaVO alba);
	public int removeAlba(String alId);
	
}

package kr.or.ddit.alba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.alba.vo.AlbaVO;
import kr.or.ddit.vo.PagingVO;

@Mapper
public interface AlbaDAO {
	public int insertAlba(AlbaVO alba);
	public List<AlbaVO> selectAlbaList(PagingVO<AlbaVO> pagingVO);
	public int selectTotalRecord(PagingVO<AlbaVO> pagingVO);
	public AlbaVO selectAlba(String alId);
	public int updateAlba(AlbaVO alba);
	public int deleteAlba(String alId);
}

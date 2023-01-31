package kr.or.ddit;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AttatchVO;


@Mapper
public interface AttatchDAO {
//	public int insertAttatches(BoardVO board);
	public List<AttatchVO> selectAttatchList(int boNo);
	public AttatchVO selectAttatch(int attNo);
//	public int deleteAttatches(BoardVO board);
}

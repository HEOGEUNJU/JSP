package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.memo.dao.MemoDao;
import kr.or.ddit.mybatis.MybatisUtils;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;

public class MemberDAOImpl implements MemberDAO {
	
   private SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
	
   @Override
   public int insertMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();// 트랜잭션 시작
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapperProxy.insertMember(member);
//				int rowcnt = sqlSession.insert("kr.or.ddit.memo.dao.MemoDao.insertMemo", memo);
			sqlSession.commit(); // 트랜잭션 종료
			return rowcnt;
		}
   }
   //paging 처리할 때는 아래 두개가 한세트
   @Override
	public int selectTotalRecord(PagingVO<MemberVO> pagingVO) {
	   try(
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   ){
	   MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
	   return mapperProxy.selectTotalRecord(pagingVO);
//		return sqlSession.selectList("kr.or.ddit.memo.dao.MemberDAO.selectMemberList");
	   }
	}
   @Override
   public List<MemberVO> selectMemberList(PagingVO<MemberVO> pagingVO) {
	   try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectMemberList(pagingVO);
//				return sqlSession.selectList("kr.or.ddit.memo.dao.MemberDAO.selectMemberList");
		}

   }

   @Override
   public MemberVO selectMember(String memId) {
	   try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectMember(memId);
//			return sqlSession.selectList("kr.or.ddit.memo.dao.MemoDao.selectMemoList");
		}
   
   }

   @Override
   public int updateMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();// 트랜잭션 시작
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapperProxy.updateMember(member);
//					int rowcnt = sqlSession.insert("kr.or.ddit.memo.dao.MemoDao.insertMemo", memo);
			sqlSession.commit(); // 트랜잭션 종료
			return rowcnt;
		}
   }

   @Override
   public int deleteMember(String memId) {
      try(
		  SqlSession sqlSession = sqlSessionFactory.openSession();
	  ){
    	  MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
    	  int rowcnt = mapperProxy.deleteMember(memId);
    	  sqlSession.commit();
    	  return rowcnt;
      }
   }

}
package kr.or.ddit.memo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.MybatisUtils;
import kr.or.ddit.vo.MemoVO;

public class MemoDAOImpl implements MemoDao {
	private SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
	
	@Override
	public List<MemoVO> selectMemoList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemoDao mapperProxy = sqlSession.getMapper(MemoDao.class);
			return mapperProxy.selectMemoList();
//			return sqlSession.selectList("kr.or.ddit.memo.dao.MemoDao.selectMemoList");
		}
	}

	@Override
	public int insertMemo(MemoVO memo) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();// 트랜잭션 시작
		){
			MemoDao mapperProxy = sqlSession.getMapper(MemoDao.class);
			int rowcnt = mapperProxy.insertMemo(memo);
//			int rowcnt = sqlSession.insert("kr.or.ddit.memo.dao.MemoDao.insertMemo", memo);
			sqlSession.commit(); // 트랜잭션 종료
			return rowcnt;
		}
	}

	@Override
	public int updateMemo(MemoVO memo) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemoDao mapperProxy = sqlSession.getMapper(MemoDao.class);
			int rowcnt = mapperProxy.updateMemo(memo);
//			int rowcnt = sqlSession.update("kr.or.ddit.memo.dao.MemoDao.updateMemo", memo);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int deleteMemo(int code) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemoDao mapperProxy = sqlSession.getMapper(MemoDao.class);
			int rowcnt = mapperProxy.deleteMemo(code);
//			int rowcnt = sqlSession.delete("kr.or.ddit.memo.dao.MemoDao.deleteMemo", code);
			sqlSession.commit();
			return rowcnt;
		}
	}
}

package kr.or.ddit.memo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.memo.dao.FileSystemMemoDAOImpl;
import kr.or.ddit.memo.dao.MemoDao;
import kr.or.ddit.vo.MemoVO;

@Service
public class MemoService {

   private MemoDao dao;

   @Inject
   public MemoService(MemoDao dao) {
      super();
      this.dao = dao;
   }


   public List<MemoVO> retrieveMemoList(){
      return dao.selectMemoList();

   }

}
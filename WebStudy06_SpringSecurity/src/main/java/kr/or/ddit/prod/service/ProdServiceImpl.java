package kr.or.ddit.prod.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ProdServiceImpl implements ProdService {
   
   
   private final ProdDAO prodDAO;
   
   
	@Inject
	private WebApplicationContext context;
	// savefolder 하기 위함
	private File saveFolder;

	@PostConstruct
	public void init() throws IOException {
		String saveFolderURL = "/resources/prodImages";
//      ServletContext application = req.getServletContext();
//      String saveFolderPath = application.getRealPath(saveFolderURL);
		Resource saveFolderRes = context.getResource(saveFolderURL);
		saveFolder = saveFolderRes.getFile();
		
		if (!saveFolder.exists()) { // 얘가 실제로 있나 없나 확인
			saveFolder.mkdirs();
		}
	}
   
   
   private void processProdImage(ProdVO prod) {
      //1. 저장
      try {
         prod.saveTo(saveFolder);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
   

   @Override
   public ProdVO retrieveProd(String prodId) {
      ProdVO prod = prodDAO.selectProd(prodId);

      if(prod==null)
         throw new RuntimeException(String.format("%s는 없는 상품",prodId));
      
      return prod;   
   }


   @Override
   public void retrieveProdList(PagingVO<ProdVO> pagingVO) {
      int totalRecord = prodDAO.selectTotalRecord(pagingVO);
      pagingVO.setTotalRecord(totalRecord);
      List<ProdVO> dataList = prodDAO.selectProdList(pagingVO);
      pagingVO.setDataList(dataList);
   }

   
	// 상품 추가
//	@Inject
//	private SqlSessionFactory sqlSessionFactory;

	@Override
	public ServiceResult createProd(ProdVO prod) {

//		try (
//			// session open
//			SqlSession sqlSession = sqlSessionFactory.openSession(); // 트랜잭션 관리의 대상을 dao에서 service로 옯겨오기
//		) {
			int rowcnt = prodDAO.insertProd(prod);

			processProdImage(prod);
//			sqlSession.commit();// 트랜잭션 관리의 대상을 dao에서 service로 옯겨오기

			return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;


	}

   //상품 수정 
   @Override
   public ServiceResult modifyProd(ProdVO prod) {
      //상품이 존재하지 않는 경우 실행 
      retrieveProd(prod.getProdId());

      int rowcnt = prodDAO.updateProd(prod);
      processProdImage(prod);
      
      return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
   }




}
package kr.or.ddit.prod.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

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
    private ApplicationContext context;
	
	
	private File saveFolder;
	
	@PostConstruct
	public void init() throws IOException{
//		public void init() throws IOException {
		String saveFolderURL = "/resources/prodImages";
//		ServletContext application = req.getServletContext(); // application 기본 객체가 들어감!
//		String saveFolderPath = application.getRealPath(saveFolderURL);
		Resource saveFolderRes = context.getResource(saveFolderURL);
		saveFolder = saveFolderRes.getFile();
		if (!saveFolder.exists()) // savefolder가 없으면~
			saveFolder.mkdirs(); // mkdirs로 해야 계층구조로 쫙 만들어줘!
	   }	
	private void processProdImage(ProdVO prod) {
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
			throw new RuntimeException(String.format("%s 는 없는 상품", prodId));
		return prod;
	}
	
	@Override
	public void retrieveProdList(PagingVO<ProdVO> pagingVO) {
		int totalRecord = prodDAO.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<ProdVO> dataList = prodDAO.selectProdList(pagingVO);
		pagingVO.setDataList(dataList);
	}
	@Inject
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public ServiceResult createProd(ProdVO prod) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();//트랜잭션 시작
		){
			int rowcnt = prodDAO.insertProd(prod, sqlSession);
			processProdImage(prod);
			sqlSession.commit();
			return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		retrieveProd(prod.getProdId());
		int rowcnt = prodDAO.updateProd(prod);
		processProdImage(prod);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
}

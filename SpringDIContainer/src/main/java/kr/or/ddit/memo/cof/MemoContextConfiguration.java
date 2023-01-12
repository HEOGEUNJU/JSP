package kr.or.ddit.memo.cof;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import kr.or.ddit.memo.MemoTestView;
import kr.or.ddit.memo.dao.FileSystemMemoDAOImpl;
import kr.or.ddit.memo.dao.MemoDao;
import kr.or.ddit.memo.service.MemoService;

@ComponentScan("kr.or.ddit.memo")
@Lazy
public class MemoContextConfiguration {
//	@Bean
//	@Scope("prototype")
//	public MemoDao memoDao() {
//		return new FileSystemMemoDAOImpl();
//	}
//	
//	@Bean
//	public MemoService generateService(MemoDao dao) {
//		return new MemoService(dao);
//	}
//	
//	@Bean("testView")
//	public MemoTestView testView(MemoService service) {
//		MemoTestView view = new MemoTestView();
//		view.setService(service);
//		return view;
//	}
}

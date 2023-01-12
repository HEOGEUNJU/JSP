package kr.or.ddit.sample.service;

import java.util.Calendar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import kr.or.ddit.sample.dao.SampleDAO;
import kr.or.ddit.sample.dao.SampleDAOFactory;
import kr.or.ddit.sample.dao.SampleDAOImpl_Oracle;
import kr.or.ddit.sample.dao.SampleDAOImpl_Postgre;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SampleServiceImpl implements SampleService, ApplicationContextAware {

	private ConfigurableApplicationContext context;
	private Resource log4j2xml;
	
	public void init() {
		// TODO Auto-generated method stub
		log.info("{} 객체 초기화", getClass().getSimpleName());
		log4j2xml = context.getResource("classpath:log4j2.xml");
		log.info("{}리소스 로딩 완료", log4j2xml);

	}
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("{} 객체 소멸", getClass().getSimpleName());

	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = (ConfigurableApplicationContext) arg0;
		log.info("AplicationContextAware 구조로 컨테이너 주입됨.");
	}

//  case1 : 의존객체를 new 키워드로 직접 생성.(결합력 최상)
//	private SampleDAO dao = new SampleDAOImpl_Oracle();
//	private SampleDAO dao = new SampleDAOImpl_Postgre();
	
//	case2 : Factory Object[Method] Pattern
//	private SampleDAO dao = SampleDAOFactory.getSampleDAO();
	
//	case3 : Strategy Pattern(의존해야하는 전략 객체를 내가 특정하지 않고 구현하는 방법)
//			, 전력 주입자가 필요함. 뷰에 결합력이 남는 것이 문제가 된다.
	@javax.annotation.Resource(name="daoOracle")
	private SampleDAO dao;
//	@Autowired
	public SampleServiceImpl(SampleDAO dao) {
	super();
	this.dao = dao;
	log.info("{} 객체 생성 및 전략 객체({}) 주입", getClass().getSimpleName(), dao.getClass().getSimpleName());
}
//	case4 : DI Container

	public SampleServiceImpl() {
		super();
		log.info("{} 객체 생성", getClass().getSimpleName());
	}
	
//	private void setdao() {
//		// TODO Auto-generated method stub
//
//	}
	
	@Override
	public StringBuffer retrieveInformation(String pk) {
		String data = dao.selectRawData(pk);
		StringBuffer information = new StringBuffer();
		information.append(
				String.format("%tc에 조회된 데이터를 가공함 - %s", Calendar.getInstance(), data)
		);
		return information;
	}


}

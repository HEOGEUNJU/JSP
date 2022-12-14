package kr.or.ddit.servlet09.service;

import java.util.List;

import kr.or.ddit.servlet09.dao.DataBasePropertyDAO;
import kr.or.ddit.servlet09.dao.DataBasePropertyDAOImpl;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DataBasePropertyServiceImpl implements DataBasePropertyService {
	
	private DataBasePropertyDAO dao = new DataBasePropertyDAOImpl();
	
	@Override
	public List<DataBasePropertyVO> retrievePropertyList(String propertyName) {
		List<DataBasePropertyVO> list =dao.selectPropertyList(propertyName);
		list.stream()
			.forEach(System.out::println);//method reperence 문법
		return list;
	}

}

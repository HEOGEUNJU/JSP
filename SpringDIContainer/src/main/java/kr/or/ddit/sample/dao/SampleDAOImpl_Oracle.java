package kr.or.ddit.sample.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("daoOracle")
public class SampleDAOImpl_Oracle implements SampleDAO{

	public void init1() {
		log.info("{} 객체 초기화", getClass().getSimpleName());

	}
	public void destroy2() {
		log.info("{} 객체 소멸", getClass().getSimpleName());

	}
	
	private Map<String, String> dummyDB;
	
	//resource를 쓰려면 setter주입을 사용해야 하는데 생성자처럼 사용하고 싶다면
	//required로 꼭 주입을 해야만 한다는 조건을 걸 수 있음
	@Required
	@Resource(name="oracleDB")
	public void setDummyDB(Map<String, String> dummyDB) {
		log.info("{} 객체 생성, setter 주입으로 dummyDB 객체 주입.", getClass().getSimpleName());
		this.dummyDB = dummyDB;
	}

	@Override
	public String selectRawData(String primaryKey) {
		return dummyDB.get(primaryKey);
	}

}

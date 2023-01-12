package kr.or.ddit.di;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertiesContextTestView {
	public static void main(String[] args) {
//		System.getProperties().forEach((k,v)->{
//			System.out.printf("%s : %s\n", k,v);
//		});
//		System.getenv().forEach((k,v)->{
//			System.err.printf("%s : %s\n", k,v);
//		});
//		1. 컨테이너 생성
		ConfigurableApplicationContext context = 
				new GenericXmlApplicationContext("classpath:kr/or/ddit/di/conf/Properties-Context.xml");
//		2. 셧다운훅 생성
		context.registerShutdownHook();
//		3. 객체 주입
		DBinfoVO vo1 = context.getBean("dbInfo1",DBinfoVO.class);
		log.info("주입된 객체 : {}", vo1);
		DBinfoVO vo2 = context.getBean("dbInfo2",DBinfoVO.class);
		log.info("주입된 객체 : {}", vo2);
	}
}

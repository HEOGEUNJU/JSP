package kr.or.ddit.di;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VariousDITestView {
   public static void main(String[] args) {
//      컨테이너 객체 생성
//      필요없으면 자동으로 소멸
//      컨테이너에 있는 모든 것들은 라이프 사이드 콜백을 갖고 있어야함
//      객체가 생성, 소멸 되었다는 로그가 있어야함
//      메인 메소드 안에서 빈 주입을 받음
//      그 빈을 프로퍼티로 뭐 출력을 함? 머라꼬?
      
      ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("kr/or/ddit/di/conf/ValiousDI-Context.xml");
      context.registerShutdownHook();
      
      VariousDIVO vo1 = context.getBean("vo1", VariousDIVO.class);
      VariousDIVO vo2 = context.getBean("vo2", VariousDIVO.class);
      
      log.info("주입된 객체 : {}", vo1);
      log.info("주입된 객체 : {}", vo2);
   }
}
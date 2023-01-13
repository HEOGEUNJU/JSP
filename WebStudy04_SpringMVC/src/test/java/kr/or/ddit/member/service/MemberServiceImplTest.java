package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.junit.Test;

import kr.or.ddit.AbstractTestCase;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
//Mock request
@Slf4j
public class MemberServiceImplTest extends AbstractTestCase {
	@Inject
	private MemberService service;
	
	@Test
	public void testInit() {
		//member vo 객체 생성
		MemberVO member = new MemberVO();
		member.setMemName("가나다");
		member.setMemId("123");
		member.setMemPass("java");
		//memberSerive사용 
	}


}

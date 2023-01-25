package kr.or.ddit.member.service;

import javax.inject.Inject;

import org.junit.Test;

import kr.or.ddit.AbstractTestCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberServiceImplTest extends AbstractTestCase {
	
	// Mock request
	
	@Inject
	private MemberService service;
	
	@Test
	public void testInit() {
		log.info("주입된 객체 : {}", service);
	}
	
	
}

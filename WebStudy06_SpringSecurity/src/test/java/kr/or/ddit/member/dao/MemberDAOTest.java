package kr.or.ddit.member.dao;

import javax.inject.Inject;

import org.junit.Test;

import kr.or.ddit.AbstractTestCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberDAOTest extends AbstractTestCase {

	@Inject
	private MemberDAO memberDao;

	@Test
	public void test() {
		log.info("주입된 객체 : {}", memberDao);
	}

}
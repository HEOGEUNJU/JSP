package kr.or.ddit.security;

import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordEncoderTest {
	
	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	String password = "java";
	String mem_pass = "{bcrypt}$2a$10$JFJKlbY.Aunx7SbhabQnsOKxoLOF7Z1bDN.l0M.1J7z/DqSza1Y.e";
	
	public void encodeTest() {
		String encoded = encoder.encode(password);
		log.info("mem_pass : {}", encoded);
	}
	
	@Test
	public void matchTest() {
		;
		log.info("match result : {}", encoder.matches(password, mem_pass));
	}
}

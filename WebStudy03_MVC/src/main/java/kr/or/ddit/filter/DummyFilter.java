package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyFilter implements Filter{ //webFilter라고 부른다
	//filter도 컨테이너에 의해서 관리된다.
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("{}초기화", this.getClass().getName());
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 요청 필터링(request filterling)
		log.info("==================요청 필터링==================");
		chain.doFilter(request, response); //--------------------다음 필터에게 제어권 이동
		// 응답 필터링
		log.info("==================응답 필터링==================");
	}

	@Override
	public void destroy() {
		log.info("{}초기화", this.getClass().getName());
		
	} 

}
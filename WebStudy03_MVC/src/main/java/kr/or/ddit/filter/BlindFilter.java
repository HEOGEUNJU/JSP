package kr.or.ddit.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlindFilter implements Filter{

   private Map<String, String> blindMap;
   
   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      log.info("{} 초기화", this.getClass().getName());
      blindMap = new LinkedHashMap<>();
      blindMap.put("127.0.0.1", "나니까 블라인드");
      blindMap.put("0:0:0:0:0:0:0:1", "나니까 블라인드");
      blindMap.put("192.168.35.25", "나니까 블라인드");
      blindMap.put("192.168.35.42", "나니까 블라인드");
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
      log.info("blind filter 동작 시작");
      // 1. client ip 필요
      // 2. 블라인드 대상을 선언
      String ipAddress = request.getRemoteAddr();
      
      // 3. 블라인드 대상 아니면 정상적으로 서비스 이용 가능하게 하기
      if(blindMap.containsKey(ipAddress)) {
         String reason = blindMap.get(ipAddress);
         String message = String.format("당신은 %s 사유로 블라인드 처리 됐씀다.", reason);
         request.setAttribute("message", message);
         String viewName = "";
         request.getRequestDispatcher("/WEB-INF/views/commons/messageView.jsp").forward(request, response);
      // 4. 대상이라면 통과시키면 안됨. ~사유로 블라인드 처리 되었습니다 라는 메세지 필요
      }else {
         chain.doFilter(request, response);
      }
      
      log.info("blind filter 동작 종료");
      
   }

   @Override
   public void destroy() {
      // TODO Auto-generated method stub
      
   }

}
package kr.or.ddit.servlet06;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.print.attribute.standard.Severity;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.Module.SetupContext;

@WebServlet(value = "/bts", loadOnStartup=1)

public class BTSServlet extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext application = config.getServletContext();
		application.setAttribute("btsMembers", getBtsMemberList());
	}
	public Map<String, String[]> getBtsMemberList() {
		Map<String, String[]> members = new LinkedHashMap<>();
		int idx = 1;
		members.put("B00"+idx++,new String[] {"RM","/WEB-INF/views/bts/rm.jsp"});
		members.put("B00"+idx++,new String[] {"BUI","/WEB-INF/views/bts/bui.jsp"});
		members.put("B00"+idx++,new String[] {"JHOP","/WEB-INF/views/bts/jhop.jsp"});
		members.put("B00"+idx++,new String[] {"JIMIN","/WEB-INF/views/bts/jimin.jsp"});
		members.put("B00"+idx++,new String[] {"JUNGKUK","/WEB-INF/views/bts/jungkuk.jsp"});
		members.put("B00"+idx++,new String[] {"SUGA","/WEB-INF/views/bts/suga.jsp"});
		members.put("B00"+idx++,new String[] {"JIN","/WEB-INF/views/bts/jin.jsp"});
		return members;
	}
	
	public String[] getMemberContent(String code) {
		String[] content = getBtsMemberList().get(code);
		return content;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 요청분석(line, header, body)
		String accept = req.getHeader("Accept");
//		2. 모델확보
		Map<String, String[]> bts = getBtsMemberList();
//		3. 모델공유(setAttribute)
		req.setAttribute("bts", bts);
//		System.out.println(bts);
//		4. 뷰선택
		String path = null;
		if(accept.startsWith("*/*") || accept.toLowerCase().contains("html")) {
	         path = "/08/btsForm.jsp";
	      } else if(accept.toLowerCase().contains("json")) {
	    	  path = "/jsonView.do";
	      } else if(accept.toLowerCase().contains("xml")){
	    	  path = "/xmlView.do";
	      }
//		System.out.println(path);
//		5. 뷰로 이동
		req.getRequestDispatcher(path).forward(req, resp);
	}
}

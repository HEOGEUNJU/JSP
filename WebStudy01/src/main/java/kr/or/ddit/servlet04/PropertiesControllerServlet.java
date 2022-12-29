package kr.or.ddit.servlet04;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.or.ddit.servlet01.DescriptionServlet;

@WebServlet("/03/props/propsView1.do")
public class PropertiesControllerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String accept = req.getHeader("Accept");
		if (accept.toLowerCase().contains("json")) {
			StringBuffer json = new StringBuffer();
			// native(DataStore.properties) -> json : marshalling
			Properties properties = new Properties();
			try (InputStream is = DescriptionServlet.class
					.getResourceAsStream("/kr/or/ddit/props/DataStore.properties");

			) {
				properties.load(is);
				Enumeration<Object> en = properties.keys();
				json.append("[");
				 String ptrn = "\"%s\":\"%s\"";
				while (en.hasMoreElements()) {
					Object key = (Object) en.nextElement();
					Object value = properties.get(key);
					 json.append("{");
				      json.append(String.format(ptrn, "key", key));
				      json.append(",");
				      json.append(String.format(ptrn, "value", value));
				      json.append("}");
				      json.append(",");
				}
				  json.append("]");
				int lastIndex = json.lastIndexOf(",");
				if(lastIndex!=-1) {
				      json.deleteCharAt(lastIndex);
				   }
			}
			System.out.println(json);
//			{"prop1":"value1",....}
			resp.setContentType("application/json; charset = utf-8");
			try (PrintWriter out = resp.getWriter();) {
				out.print(json);
			}
		} else {
			// accept를 확인했을 때 json이면 아래 방식
//			String path = "/WEB-INF/views/03/propsView.jsp";
//			req.getRequestDispatcher(path).forward(req, resp);
		}

	}
}

package kr.or.ddit.servlet01;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageListServlet extends HttpServlet{
	private String imageFolder;
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
		imageFolder=application.getInitParameter("imageFolder");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		File imageFile = new File(imageFolder);
		
		String[] fileName = imageFile.list();
		
		
		resp.setContentType("text/html;charset=UTF-8"); 
	    StringBuffer content = new StringBuffer();
	    content.append("<html>\n");
	    content.append("<body>\n");
	    content.append("<h2>보고싶은 파일 이름을 고르세요</h2>");
	    for(int i=0; i<fileName.length; i++) {
	    	System.out.println(fileName[i]);
	    	content.append("<input type=button value="+fileName[i]+"\n>");
	    	content.append("\n");
	    }
	    content.append("</body>\n");
	    content.append("</html>\n");
	    
	    PrintWriter out = resp.getWriter();
	    out.println(content);
	    out.close();
	}
}

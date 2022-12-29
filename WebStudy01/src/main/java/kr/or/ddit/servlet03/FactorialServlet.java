package kr.or.ddit.servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/02/factorial.do")
public class FactorialServlet extends HttpServlet{

	 private static final long serialVersionUID = 1L;
	
	public FactorialServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String numParam = req.getParameter("number");
		if(numParam ==null || !numParam.matches("\\d{1,2}")){
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
		    return;
		}
		int input = Integer.parseInt(numParam);
		String pattern ="%d != %d";
		int result = fact(input);
		String expr = String.format(pattern, input, result);
		try(
			PrintWriter out = resp.getWriter();
		
		){
			out.print(expr);
		}
	}
	private int fact (int num){
		   if(num<0)
		      throw new IllegalArgumentException("음수는 연산 불가");
		   if (num<=1){
		      return num;
		   } else {
		      return fact(num-1)*num;
		   }
	}
}

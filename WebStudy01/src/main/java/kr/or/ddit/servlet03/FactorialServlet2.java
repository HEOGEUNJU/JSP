package kr.or.ddit.servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/02/factorial1.do")
public class FactorialServlet2 extends HttpServlet{

	 private static final long serialVersionUID = 1L;
	
	public FactorialServlet2() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("html/text; charset=utf-8");
		String number = req.getParameter("number");
		int num = Integer.parseInt(number);
		
		System.out.println("ajax"+num);
		int result=fact(num);
		String pattern ="%d != %d";
		String expr = String.format(pattern, num, result);
		try(
				PrintWriter out = resp.getWriter();
			
			){
				out.print(expr);
			}
	}
	private int fact(int num){
		   if(num<0)
		      throw new IllegalArgumentException("음수는 연산 불가");
		   if (num<=1){
		      return num;
		   } else {
		      return fact(num-1)*num;
		   }
	}
}

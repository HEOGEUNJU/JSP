/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.84
 * Generated at: 2022-12-27 05:55:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._06;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class memoView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>06/memoView.jsp</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/includee/preScript.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h4>Restful 기반의 메모 관리</h4>\r\n");
      out.write("<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/memo\" method=\"post\" id =\"myForm\">\r\n");
      out.write("	<input type=\"text\" name =\"writer\" placeholder=\"작성자\"/>\r\n");
      out.write("	<input type=\"date\" name =\"date2\" placeholder=\"작성일\"/>\r\n");
      out.write("	<textarea name = \"content\"></textarea>\r\n");
      out.write("	<input type=\"submit\" value=\"등록\"/>\r\n");
      out.write("</form>\r\n");
      out.write("<table class=\"table-bordered\">\r\n");
      out.write("   <thead>\r\n");
      out.write("      <tr>\r\n");
      out.write("         <th>작성자</th>\r\n");
      out.write("         <th>작성일</th>\r\n");
      out.write("      </tr>\r\n");
      out.write("   </thead>\r\n");
      out.write("   <tbody id=\"listBody\">\r\n");
      out.write("   \r\n");
      out.write("   </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<!-- Modal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("  <div class=\"modal-dialog\">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("        <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Modal title</h1>\r\n");
      out.write("        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("        ...\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-footer\">\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary\">Save changes</button>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("// 	EDD(Event Driven Development)방법론 : 뭐든 이벤트로 처리되는 방법\r\n");
      out.write("//  TDD(Text Driven Development)방법론 : 단계적인 프린트를 진행하면서 로직을 만들어 나가는 과정\r\n");
      out.write("\r\n");
      out.write("   $(\"#exampleModal\").on(\"show.bs.modal\", function(event){\r\n");
      out.write("//    	 this==event.target : modal창 자체\r\n");
      out.write("		let memo=$(event.relatedTarget).data(\"memo\") //modal을 띄울 때 사용한 element(대상), tr태그\r\n");
      out.write("		console.log(memo.writer)\r\n");
      out.write("		$(this).find(\".modal-body\").html(memo.content)\r\n");
      out.write("	}).on(\"hidden.bs.modal\",function(event){\r\n");
      out.write("		$(event.target).find(\".modal-body\").empty();\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("   $\r\n");
      out.write("   let listBody = $(\"#listBody\");\r\n");
      out.write("   let makeListBody = function(memoList){\r\n");
      out.write("      listBody.empty();\r\n");
      out.write("      let trTags=[];   \r\n");
      out.write("       if(makeListBody.length>0){\r\n");
      out.write("//          data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\"\r\n");
      out.write("          $.each(memoList, function(index, memo){\r\n");
      out.write("             let tr = $(\"<tr>\").append(\r\n");
      out.write("                $(\"<td>\").html(memo.writer)      \r\n");
      out.write("                ,$(\"<td>\").html(this.date2)      \r\n");
      out.write("             ).attr({\r\n");
      out.write("               \"data-bs-toggle\":\"modal\"\r\n");
      out.write("               ,\"data-bs-target\":\"#exampleModal\"\r\n");
      out.write("             }).data(\"memo\",memo);\r\n");
      out.write("             trTags.push(tr);\r\n");
      out.write("          });\r\n");
      out.write("      }else{\r\n");
      out.write("         let tr = $(\"<tr>\").html(\r\n");
      out.write("            $(\"<td>\")\r\n");
      out.write("               .attr(\"colspan\",\"2\")   \r\n");
      out.write("               .html(\"작성된 메모 없음.\")\r\n");
      out.write("         );\r\n");
      out.write("         trTags.push(tr);\r\n");
      out.write("      }\r\n");
      out.write("       listBody.append(trTags);\r\n");
      out.write("    }\r\n");
      out.write("   \r\n");
      out.write("   $.ajax({\r\n");
      out.write("      url : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/memo\",\r\n");
      out.write("      method : \"get\",\r\n");
      out.write("      dataType : \"json\" //json으로 하면 리턴 타입은 언마샬링 script 타입이 온다.\r\n");
      out.write("      ,\r\n");
      out.write("      success : function(resp) {\r\n");
      out.write("    	 console.log(resp)\r\n");
      out.write("         makeListBody(resp.memoList)\r\n");
      out.write("            \r\n");
      out.write("      },\r\n");
      out.write("      error : function(jqXHR, status, error) {\r\n");
      out.write("         console.log(jqXHR);\r\n");
      out.write("         console.log(status);\r\n");
      out.write("         console.log(error);\r\n");
      out.write("      }\r\n");
      out.write("   });   \r\n");
      out.write("   \r\n");
      out.write("//    1. form을 비동기로 받아서 post할 예정 ( 서밋을 버튼으로 바꾸기)\r\n");
      out.write("   $('#myForm').submit(function(){\r\n");
      out.write("	   $.ajax({\r\n");
      out.write("		      url : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/memo\",\r\n");
      out.write("		      method : \"post\",	\r\n");
      out.write("		      dataType : \"json\" //json으로 하면 리턴 타입은 언마샬링 script 타입이 온다.\r\n");
      out.write("		      ,\r\n");
      out.write("		      success : function(resp) {\r\n");
      out.write("		      	 console.log(resp)\r\n");
      out.write("		      },\r\n");
      out.write("		      error : function(jqXHR, status, error) {\r\n");
      out.write("		         console.log(jqXHR);\r\n");
      out.write("		         console.log(status);\r\n");
      out.write("		         console.log(error);\r\n");
      out.write("		      }\r\n");
      out.write("		   });   \r\n");
      out.write("   })\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("</script>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/includee/postScript.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/requestDesc.jsp</title>
</head>
<body>
<h4> request (HttpServletRequest )</h4>
<form method=""></form>
<pre>
	HTTP 의 요청 패키징 방식
	: 자원에 대한 식별 + 자원에 대한 행위 정보를 기본으로 함.
	
	1. Request Line : URI, http(request) Method
		request Method : 행위, 의도(목적)
		GET(R)
		POST(C)
		PUT/PATCH(U) -전체 다 수정 / 일부데이터만 수정
		DELETE(D)
		HEAD : 응답데이터의 패키징 구조(LINE + HEADER)
		OPTIONS : 현재 서버가 특정 메소드를 지원하는지 여부를 확인하기 위한 사전 요청(preFlight request)에 사용.
		TRACE : 서버 디버깅 용도로 제한적으로 사용 (intranet안에서만 관리 목적으로 사용할 수 있음)
		
		
		ex) 
		case1)
		/member/memberInsert.do
		
		case2) RESTful URI (자원식별과 행위를 분리하자) -JSON/XML로 자원 표현.
		/member GET - 전체회원을 다 조회(select)한다.
		/member/a001 GET - a001을 조회
		/member/a001 PUT - a001을 수정(update)한다.
		/member POST - 회원가입
		<%
			String requestURI = request.getRequestURI();
			StringBuffer requestURL = request.getRequestURL();
			String method = request.getMethod();
		%>
		requestURI : <%=requestURI %>
		requestURL : <%=requestURL %>
		request method : <%=method %>
		
	2. Request Header: 클라이언트에 대한 부가정보(meta data)
						: 이름-값의 쌍으로 구성된 "문자" 데이터
	<%
		String userAgent = request.getHeader("User-Agent");
		out.println(userAgent);
		
	%>
	3. Reqeust Body(optional) : POST, PUT
							: 클라이언트가 서버로 보내는 컨텐츠 영역(Content-Body, Message-Body)
		<%=request.getInputStream().available() %>


</pre>
<table border="1">
   <thead>
      <td>헤더명</td>
      <td>헤더값</td>
   </thead>
   <tbody>
      <%
      Enumeration<String> em = request.getHeaderNames();
      while(em.hasMoreElements()){
         String headerName = em.nextElement();
         String headerValue = request.getHeader(headerName);
      %>
      <tr>
         <th><%=headerName %></th>
         <th><%=headerValue %></th>
      </tr>
      <%
      }
      %>

   </tbody>
</table>
</body>
</html>
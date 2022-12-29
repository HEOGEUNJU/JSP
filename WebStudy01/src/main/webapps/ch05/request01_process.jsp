<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//호스트명
    	String hostValue = request.getHeader("host");
    	//설정된 언어
    	String alValue = request.getHeader("accept-language");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objects</title>
</head>
<body>
	<p>아이디 : <%=request.getParameter("id") %></p>
	<p>비밀번호 : <%=request.getParameter("passwd")%></p>
	<p>호스트명 : <%=hostValue%></p>
	<p>설정된 언어 : <%=alValue%></p>
	
</body>
</html>
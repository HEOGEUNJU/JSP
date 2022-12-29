<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object(내장객체)</title>
</head>
<body>
	<%
		//스크립틀릿
		//모든 헤더의 이름을 가져와보자 => 리턴타입: Enumeration(열거형)
		//열거형 : 삼겹살, 치킨, 쿠키, 라면, 떡볶이, 요거트, 초콜릿
		Enumeration en = request.getHeaderNames();
		//hasMoreElements() 값이 더 있니?
		while(en.hasMoreElements()){
			//현재 헤더 이름을 가져옴(Object(먹을것) -> String(삼겹살)으로 downcasting)
			String headerName = (String)en.nextElement();
			//headerName : host 
			//request.getHeader("host");
			String headerValue = request.getHeader(headerName);
			out.print("<p>"+headerName+" : "+headerValue +"</p>");
		}
	%>
</body>
</html>
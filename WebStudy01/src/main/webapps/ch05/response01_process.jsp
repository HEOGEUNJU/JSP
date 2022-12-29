<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("id");
		String password = request.getParameter("password");
	%>
		<c:set var ="id" value="<%=userId %>"/>
		<c:set var ="passwd" value="<%=password %>"/>
		아이디 : ${id} , 비밀번호: ${passwd} <br/>
<script type="text/javascript">
	let varId = "${id}";
	let passwd = "${passwd}";
	
	if(varId =="a001"&&passwd=="java"){
		location.href="response01_success.jsp";
	}else{
		location.href="/WebStudy01/ch05/response01_failed.jsp";
	}
</script>
	<%
		//userId가 a001이고 동시에 password가 java이라면
		//response01_success.jsp로 페이지 이동
		//아니면
		//resonse01_failed.jsp
// 		if(userId.equals("a001")&&password.equals("java")){
// 			response.sendRedirect("/WebStudy01/ch05/response01_success.jsp");
// 		}else{
// 			response.sendRedirect("/WebStudy01/ch05/resonse01_failed.jsp");
// 		}
		
	%>
	
</body>
</html>
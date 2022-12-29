<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		요청 URI : response01_process.jsp?id=a001&passwd=java
	 -->
	<form action="response01_process.jsp" method="post">
		<p>아이디 : <input type="text" name ="id" required="required">
		<p>비밀번호 : <input type="text" name ="password" required="required">
		<p><input type="submit" value="전송" >
		
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%= request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
	<form action="/WebStudy01/03/calculateForm2.jsp" method="post">
		<input type="text" name="leftOp" placeholder ="좌측피연산자"/>
		<select name="operator">
			<option value="PLUS">+</option>
			<option value="MINUS">-</option>
			<option value="MULTIPLY">*</option>
			<option value="DIVIDE">/</option>
		</select>
		<input type="text" name="rightOp" placeholder ="우측피연산자"/>
		<button type ="submit" >=</button>
	</form>
	
<script type="text/javascript">
	
</script>
</body>
</html>
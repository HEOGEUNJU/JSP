<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="euc-kr">
<title>03/sampleForm.jsp</title>
</head>
<body>
<h4> �Է� ���</h4>
<form action="sampleProcess.jsp" method="post" enctype="multipart/form-data">
	<input type="text" name="param1" placeholder="param1" />
	<input type="text" name="param2" placeholder="param2"/>
	<input type="text" name="param2" placeholder="param2"/>
	<input type="file" name="file1" placeholder="file1" />
	<input type="submit" value="SUBMIT" />
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
// 	$(document).ready(function(){});
// 	$(document).on("ready",function(){});
// 	$(function(){
	$(document).ready(function(){
		  $('#submit').click(function(){
			  AjaxConGet();
			  
		  });
	});
		  
	 function AjaxConGet(){
		$.ajax({
			type:"GET",
			url : "<%=request.getContextPath()%>/02/factorial1.do",
			data : {
				number : $('#number').val()		
			},
			
			dataType : "text" //json으로 하면 리턴 타입은 언마샬링 script 타입이 온다.
			,
			success : function(resp) {
				alert('ajax GET 통신 성공');
				$("#resultArea").append(resp)
				
			},
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			}
		});
	};
</script>
</head>
<body>

	<input type = "number" id = "number"/>
	<input type = "button" id = "submit" value = "전송"/>
	<input type = "reset" value = "취소"/>
	<input type = "button" value = "버튼"/>
	
<div id="resultArea">

</div>
</body>
</html>
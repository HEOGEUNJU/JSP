<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int a;

	public static int fact(int n){
		if(n<0)
			throw new IllegalArgumentException("음수는 연산 불가");
		if(n<=1)
			return n;
		else
			return fact(n-1)*n;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>팩토리얼 연산 처리</h4>
<div>숫자 입력 : 
<input type="text" id="num1" value ="" />
<button id = "btn1">계산 시작!</button>
</div>
<div>결과 : 
<input type="text" id="result" value=""/>
</div>
<script type="text/javascript">
	document.getElementById('btn1').addEventListener('click',factorial);	
	function factorial(a){
		console.log(document.getElementById('num1').value)
		a = document.getElementById('num1').value;
		if(a===0||a===1)
			return -1;
		
		for (var i = a-1; i>=1; i--){
			a *= i;
		}
		return a;
		console.log(factorial(5))
	}
	
// 		document.getElementById("result").innerText = factorial(a);
	
		
		
	
</script>

</body>
</html>
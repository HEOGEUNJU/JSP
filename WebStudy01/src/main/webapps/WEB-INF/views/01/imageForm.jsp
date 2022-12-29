
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
</head>
<body>
	<form action ='${cPath}/imageStreaming.do'>
		<select name='image' value="">
		${options}
		</select> 
		<input type='submit'value='전송'>
	<form>	
	<div id="na">
		<img id="na_image" src="">
	</div>
	
	<script type="text/javascript">
		$("[name=image]").on("change",function(event){
			
				$("#na_image").attr('src',"${cPath}/imageStreaming.do?image="+$(this).val());
		});
		
	</script>
</body>
</html>

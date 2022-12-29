<%@page import="java.util.Enumeration"%>
<%@ page import="java.util.ResourceBundle" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/messageView.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
옵션값 자동으로 채울 수 있게 만들기<br>
<select id = "selName" onchange="changeFn()">
<%
	ResourceBundle bundle = null;
	try {
	    bundle = ResourceBundle.getBundle("kr.or.ddit.props.Message");
	    Enumeration keys = bundle.getKeys();
	    for (; keys.hasMoreElements(); ) {
	    	
%><option><% 
	        String name = (String)keys.nextElement();
	        out.println(name);
		    }
		} catch (Exception e) {
		    out.println("Err: "+e.toString());
		}
%></option>
</select>

<!-- 	<option>prop1</option> -->
<!-- 	<option>prop2</option> -->
<!-- 	<option>prop3</option> -->
<!-- 	<option>prop4</option> -->
<!-- 	<option>prop5</option> -->
<!-- 	<option>hi</option> -->
<h4 id="greetingArea" data-key1="prop1" data-key2="sample" data-other-key="TEST"></h4>
<input type="radio" id="dataType" name = "dataType" data-data-type="json" checked/>JSON
<input type="radio" id="dataType" name = "dataType" data-data-type="xml"/>XML
<input type="radio" id="dataType" name = "dataType" data-data-type="text"/>PLAIN

<input type="radio" name="language" data-locale="ko" />한국어
<input type="radio" name="language" data-locale="en" />영어

<table border=1px>
 	<tbody id="tbody" >
   
   </tbody>
</table>
<script type="text/javascript">
	let dataKey1=$("#selName option:selected").text()
	let greetingArea = $("#greetingArea");
	let name = greetingArea.data("key1")
	console.log("초기 name 값 : "+ name)
	
	
	function changeFn(){
		console.log("====================================")
		dataKey1=$("#selName option:selected").text()
		console.log("select 후 dataKey1의 값 : "+dataKey1)
		name = greetingArea.attr('data-key1', dataKey1);
		console.log("select 후 attr한 key1의 값 : "+greetingArea.data("key1"))
		console.log("select 후 attr한 name의 값 : "+name)
	}
	
	let radioBtns = $('[type="radio"]')
	let dataTypes = radioBtns.filter("[name=dataType]")
	let locales = radioBtns.filter("[name=language]")
	let successes={
			json:function(resp){
				console.log(resp);
				greetingArea.text(resp.message);
				console.log("json일 때 key1의 값 : "+greetingArea.data("key1"))
			},
			xml:function(docResp){
				console.log(docResp);
				let message = $(docResp).find("message").text();
				greetingArea.html(message)
				console.log("xml일 때 key1의 값 : "+greetingArea.data("key1"))
			},
			text:function(plain){
				console.log(plain);
				greetingArea.html(plain)
				console.log("plain일 때 key1의 값 : "+greetingArea.data("key1"))
			}
	}
	
	let settings={
			url : "<%=request.getContextPath()%>/04/getGreetingMessage",
			error : function(jqXHR, status, error) {
				console.log(jqXHR);
				console.log(status);
				console.log(error);
			}
	};

	radioBtns.on("change",function(){
		greetingArea.empty();
// 		greetingArea.html("");
		let dataType = dataTypes.filter(":checked").data("dataType")

		settings.dataType = dataType;
		settings.success=successes[dataType];
		settings.data ={
				name: greetingArea.data("key1")
// 			name: greetingArea.attr("data-key1")
			//여기만 잘 바꾸면 될 듯 
		}
		let locale = locales.filter(":checked").data("locale");
		if(locale){
// 			settings.data={
// 				locale:locale
// 			}
			settings.data.locale=locale;
		}
		
		console.log("=================");
		console.log(settings);
		console.log("=================");
		$.ajax(settings);
	}).trigger("change");
	
	
	
	
</script>
</body>
</html>
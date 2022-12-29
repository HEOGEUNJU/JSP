<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="resultArea">
	 <%
        request.setCharacterEncoding("UTF-8"); //인코딩 형식
        
        int num1 = Integer.parseInt(request.getParameter("leftOp"));
        int num2 = Integer.parseInt(request.getParameter("rightOp"));
        
        String operator = request.getParameter("operator"); //select 태그의 name 값 operator에 저장
        
    %>
    <%
    //select 태그 option 값에 따라 사칙연산
    if (operator.equals("PLUS")) { %>
           <%=num1%> + <%=num2%> = <%=num1+num2 %>
       <%
        } else if (operator.equals("MINUS")) { %>
            <%=num1%> - <%=num2%> = <%=num1-num2 %>
       <%
        }else if (operator.equals("MULTIPLY")){ %>
            <%=num1%> * <%=num2%> = <%=num1*num2 %>
       <%
        }else{    %>
            <%=num1%> / <%=num2%> = <%=num1/num2 %>
       <%
        }
        %>
		
	</div>	
</body>
</html>
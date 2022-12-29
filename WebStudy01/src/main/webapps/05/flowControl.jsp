<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/05/flowControl.jsp</title>
<%-- <jsp:include page="/includee/preScript.jsp"/> --%>
<%@include file="/includee/preScript.jsp" %>
<%=varInPre %>
</head>
<body>
<h4>흐름 제어 방법</h4>
<pre>
	Http : Connectless, Stateless 
	A -> B 이동 방식
	1. 요청 분기(request dispatch) //핵심은 앞에 요청이라는 단어가 붙어 있다는게 핵심이다.
	   : A를 대상으로 한 최초의 요청이 계속 유지됨.
		1) forward(Model2) : A(request 처리=controller)->B(response 생성=view)로 일단 이동 이후에 최종 응답을 B에서 전송.
		2) include(페이지 모듈화) : A로 최초요청 발생 -> B -> A 최종 응답에는 A와 B의 컨텐츠 모두가 포함됨.
			내포되는 시점과 내포되는 대상에 따라 분류됨.
			- 정적 내포 : 컴파일되기 전에 소스가 파싱되는 단계에서 소스파일 자체가 내포됨
			- 동적 내포 : 실행시에 실행의 결과 데이터가 내포됨
			<%	
				request.setAttribute("attr1", new Date());
				//요청을 분기하는 방식
				String path = "/02/standard.jsp";
// 				request.getRequestDispatcher(path).forward(request, response);
// 				request.getRequestDispatcher(path).include(request, response); // 페이지를 모듈화 할 때 제일 많이 사용
				pageContext.include(path); // include랑 비교해보깅
			 %>
	2. Redirect : 
		일단 A로 요청 -> response body가 없고, Line(302) + Header(Location) 로만 구성된 응답이 전송
		-> Location 방향으로 새로운 요청을 전송함 -> B에서 Body를 가진 최종 응답이 전송됨.
		<%--
			session.setAttribute("attr2", "세션속성");
			String location=request.getContextPath()+path;
			response.sendRedirect(location);
			//request 정보를 안보내는 것이 가장 큰 차이점이다.
		--%>
</pre>
</body>
</html>
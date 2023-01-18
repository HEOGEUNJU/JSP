<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
	<form method="post" action='<c:url value ='/login/loginProcess.do'/>'>
		<security:csrfInput/>
		<ul>
			<li>
				<c:set var="savedId" value="${cookie['saveId']['value'] }"/>
				<input type="text" name="memId" placeholder="아이디" value="${not empty validId ? validId : savedId}"/>
				<input type="checkbox" name="saveId" ${not empty savedId ? 'checked' : ''}/>아이디기억하기 <%--체크박스 누르면 5일간 기억시간 설정, 체크안할때 : 기존의 쿠키도 삭제 로그인 실패하면 고려X  --%>
				<c:remove var="validId" scope="session"/>
			</li>
			<li>
				<input type="text" name="memPass" placeholder="비밀번호"/>
				<input type="submit" value="로그인"/>
			</li>
		</ul>
	</form>

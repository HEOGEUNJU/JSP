<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/memberList.do</title>
<jsp:include page="/includee/preScript.jsp"/>
</head>
<body>
<h4>회원 목록 조회</h4>

<table>
	<thead>
		<tr>
			<th>회원아이디</th>
			<th>회원명</th>
			<th>이메일</th>
			<th>휴대폰</th>
			<th>거주지역</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${not empty memberList }">
				<c:forEach items="${memberList }" var="memberVO">
					<tr>
						<td>${memberVO.memId }</td>
						<td>
							<c:url value="/member/memberView.do" var="viewURL">
								<c:param name="who" value="${memberVO.memId }"/>
							</c:url>
							<a href="${viewURL }">${memberVO.memName }</a>
						</td>
						<td>${memberVO.memMail }</td>
						<td>${memberVO.memHp }</td>
						<td>${memberVO.memAdd1 }</td>
						<td>${memberVO.memMileage }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="6">조건에 맞는 회원이 없음.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<jsp:include page="/includee/postScript.jsp"/>
</body>
</html>
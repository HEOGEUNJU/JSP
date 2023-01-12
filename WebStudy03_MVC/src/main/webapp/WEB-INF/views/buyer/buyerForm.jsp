<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
<c:if test="${not empty message }">
   <script type="text/javascript">
      alert("${message}");
   </script>
</c:if>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>판매자아이디</th>
				<td><input class="form-control" type="text" 
					name="buyerId" value="${buyer.buyerId}"  readOnly /><span class="text-danger">${errors.buyerId}</span></td>
			</tr>
			<tr>
				<th>거래처 이름</th>
				<td><input class="form-control" type="text" 
					name="buyerName" value="${buyer.buyerName}" /><span
					class="text-danger">${errors.buyerName}</span></td>
			</tr>
			 <tr>
         <th>상품분류</th>
         <td>
           <select name="prodLgu">
              <option value>분류</option>
              <!-- <option value="P101">삼성컴퓨터</option> -->
              <c:forEach items="${lprodList }" var="lprod">
                 <option value="${lprod.lprodGu }" 
                    ${lprod.lprodGu eq prod.prodLgu ? "selected" : ""}
                 >${lprod.lprodNm }</option>
              </c:forEach>
           </select>
         <span class="text-danger">${errors.prodLgu}</span></td>
      </tr>
			<tr>
				<th>은행</th>
				<td><input class="form-control" type="text" name="buyerBank"
					value="${buyer.buyerBank}" /><span class="text-danger">${errors.buyerBank}</span></td>
			</tr>
			<tr>
				<th>계좌번호</th>
				<td><input class="form-control" type="text" name="buyerBankno"
					value="${buyer.buyerBankno}" /><span class="text-danger">${errors.buyerBankno}</span></td>
			</tr>
			<tr>
				<th>예금주</th>
				<td><input class="form-control" type="text"
					name="buyerBankname" value="${buyer.buyerBankname}" /><span
					class="text-danger">${errors.buyerBankname}</span></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input class="form-control" type="text" name="buyerZip"
					value="${buyer.buyerZip}" /><span class="text-danger">${errors.buyerZip}</span></td>
			</tr>
			<tr>
				<th>주소1</th>
				<td><input class="form-control" type="text" name="buyerAdd1"
					value="${buyer.buyerAdd1}" /><span class="text-danger">${errors.buyerAdd1}</span></td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td><input class="form-control" type="text" name="buyerAdd2"
					value="${buyer.buyerAdd2}" /><span class="text-danger">${errors.buyerAdd2}</span></td>
			</tr>
			<tr>
				<th>회사번호</th>
				<td><input class="form-control" type="text" 
					name="buyerComtel" value="${buyer.buyerComtel}" /><span
					class="text-danger">${errors.buyerComtel}</span></td>
			</tr>
			<tr>
				<th>팩스</th>
				<td><input class="form-control" type="text" 
					name="buyerFax" value="${buyer.buyerFax}" /><span
					class="text-danger">${errors.buyerFax}</span></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input class="form-control" type="text" 
					name="buyerMail" value="${buyer.buyerMail}" /><span
					class="text-danger">${errors.buyerMail}</span></td>
			</tr>
			<tr>
				<th>담당자</th>
				<td><input class="form-control" type="text" name="buyerCharger"
					value="${buyer.buyerCharger}" /><span class="text-danger">${errors.buyerCharger}</span></td>
			</tr>
			<tr>
	         <td colspan="2">
	            <input type="submit" value="저장">
	     	    <input type="reset" value="취소">
         	</td>
      		</tr>
		</table>
	</form>
<script type="text/javascript">
//초기값 세팅
let prodBuyerTag = $("[name=prodBuyer]");
$("[name=prodLgu]").on("change", function(){
   let prodLgu = $(this).val();
   if(prodLgu){
	  prodBuyerTag.find("option:gt(0)").hide();
	  prodBuyerTag.find("option."+prodLgu).show();
   }
}).trigger("change");
</script>

   <jsp:include page="/includee/postScript.jsp" />
</body>
</html>
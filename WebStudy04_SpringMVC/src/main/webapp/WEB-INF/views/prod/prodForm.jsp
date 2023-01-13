<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
<form:form modelAttribute="prod" enctype="multipart/form-data">
<!-- 		<input type="hidden" name = "_method" value="PUT"/> -->
   <table>
      <tr>
         <th>상품아이디</th>
         <td>
         	<input class="form-control" type="text" name="prodId" value="${prod.prodId}" readOnly />
            <form:errors path="prodId" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>상품명</th>
         <td>
         	<input class="form-control" type="text" name="prodName" value="${prod.prodName}" />
            <form:errors path="prodName" element="span" cssClass="text-danger"/>
		</td>
      </tr>
      <tr>
         <th>상품분류</th>
         <td>
           <form:select path="prodLgu">
              <option value>분류</option>
              	<c:forEach items="${lprodList }" var="lprod">
              <!-- <option value="P101">삼성컴퓨터</option> -->
                 <form:option value="${lprod.lprodGu }" label="${lprod.lprodNm }"/>
              </c:forEach>
           </form:select>
        <form:errors path="prodLgu" element="span" cssClass="text-danger"/>
      </tr>
      <tr>
         <th>거래처</th>
         <td>
<%--        <form:select path="prodBuyer" items="${buyerList }" itemValue="buyerId" itemLabel="buyerName"/> --%>
			<form:select path="prodBuyer">
				<option value>거래처</option>
				<c:forEach items="${buyerList }" var="buyer">
					<form:option value="${buyer.buyerId }" label="${buyer.buyerName }" cssClass="${buyer.buyerLgu }" />
				</c:forEach>
			</form:select>
        	<form:errors path="prodBuyer" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>구매가</th>
         <td>
         	<input class="form-control" type="number" name="prodCost" value="${prod.prodCost}" />
         	<form:errors path="prodCost" element="span" cssClass="text-danger"/>
          </td>
      </tr>
      <tr>
         <th>판매가</th>
         <td>
         	<input class="form-control" type="number" name="prodPrice" value="${prod.prodPrice}" />
            <form:errors path="prodPrice" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>세일가</th>
         <td>
         	<input class="form-control" type="number" name="prodSale" value="${prod.prodSale}" />
			<form:errors path="prodSale" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>상품요약</th>
         <td>
         	<input class="form-control" type="text" name="prodOutline" value="${prod.prodOutline}" />
            <form:errors path="prodOutline" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>상품상세</th>
         <td>
         	<input class="form-control" type="text" name="prodDetail"value="${prod.prodDetail}" />
            <form:errors path="prodDetail" element="span" cssClass="text-danger"/>
          </td>
      </tr>
      <tr>
         <th>상품이미지</th>
         <td>
	         <input type="file" name="prodImage" accept = "image/*"/>
	         <form:errors path="prodName" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>재고</th>
         <td>
         	<input class="form-control" type="number" name="prodTotalstock" value="${prod.prodTotalstock}" />
            <form:errors path="prodTotalstock" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>입고일</th>
         <td>
         	<input class="form-control" type="date" name="prodInsdate" value="${prod.prodInsdate}" />
            <form:errors path="prodInsdate" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>적정재고</th>
         <td>
         	<input class="form-control" type="number"  name="prodProperstock" value="${prod.prodProperstock}" />
            <form:errors path="prodProperstock" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>크기</th>
         <td>
         	<input class="form-control" type="text" name="prodSize" value="${prod.prodSize}" />
            <form:errors path="prodSize" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>색상</th>
         <td>
         	<input class="form-control" type="text" name="prodColor" value="${prod.prodColor}" />
            <form:errors path="prodColor" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>배송방법</th>
         <td>
         	<input class="form-control" type="text" name="prodDelivery" value="${prod.prodDelivery}" />
            <form:errors path="prodDelivery" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>단위</th>
         <td>
         	<input class="form-control" type="text" name="prodUnit" value="${prod.prodUnit}" />
            <form:errors path="prodUnit" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>입고량</th>
         <td>
         	<input class="form-control" type="number" name="prodQtyin" value="${prod.prodQtyin}" />
			<form:errors path="prodQtyin" element="span" cssClass="text-danger"/>
            </td>
      </tr>
      <tr>
         <th>출고량</th>
         <td>
         	<input class="form-control" type="number" name="prodQtysale" value="${prod.prodQtysale}" />
            <form:errors path="prodQtysale" element="span" cssClass="text-danger"/>
         </td>
      </tr>
      <tr>
         <th>마일리지</th>
         <td>
         	<input class="form-control" type="number" name="prodMileage" value="${prod.prodMileage}" />
            <form:errors path="prodMileage" element="span" cssClass="text-danger"/>
          </td>
      </tr>
      <tr>
         <td colspan="2">
            <input type="submit" value="저장">
            <input type="reset" value="취소">
         </td>
      </tr>
   </table>
</form:form>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.ddit.or.kr/class305" prefix="ui" %>

<table>
   <thead>
      <tr>
         <th>일련번호</th>
         <th>제목</th>
         <th>작성자</th>
         <th>이메일</th>
         <th>작성일</th>
         <th>조회수</th>
      </tr>
   </thead>
   <tbody>
<%--       <c:set var="boardList" value="${pagingVO.dataList}"></c:set> --%>
<%--       <c:choose> --%>
<%--          <c:when test="${not empty boardList }"> --%>
<%--             <c:forEach items="${boardList }" var="board"> --%>
<!--                <tr> -->
<%--                   <td>${board.rnum }</td> --%>
<!--                   <td> -->
<%--                      <c:url value="/board/boardView.do" var="viewURL"> --%>
<%--                         <c:param name="what" value="${board.boNo }" /> --%>
<%--                      </c:url> --%>
<%--                      <a href="${viewURL }">${board.boTitle }[${board.attCount }]</a> --%>
<!--                   </td> -->
<%--                   <td>${board.boWriter }</td> --%>
<%--                   <td>${board.boMail }</td> --%>
<%--                   <td>${board.boDate }</td> --%>
<%--                   <td>${board.boHit }</td> --%>
<!--                </tr> -->
<%--             </c:forEach> --%>
<%--          </c:when> --%>
<%--          <c:otherwise> --%>
<!--             <tr> -->
<!--                <td colspan="6">게시글 없음.</td> -->
<!--             </tr> -->
<%--          </c:otherwise> --%>
<%--       </c:choose> --%>script로 이동
   </tbody>
   <tfoot>
      <tr>
         <td colspan="6">
            <div id="pagingArea">
<%--                ${pagingVO } --%>
<%--                <%=new BootstrapPaginationRender().renderPagination((PagingVO)request.getAttribute("pagingVO")) %> --%>
<%--                <ui:pagination pagingVO="${pagingVO }" type="bootstrap"/> --%>script로 이동/ paginationRender이용하면됨-> 컨트롤러로 정보보내기
            </div>
            <form:form id="searchUI" modelAttribute="simpleCondition" method="get" onclick="return false;">
               <form:select path="searchType">
                  <option value>전체</option>
                  <form:option value="writer" label="작성자" />
                  <form:option value="content" label="내용" />
               </form:select>
               <form:input path="searchWord"/>
               <input type="button" id="searchBtn" value="검색" />
            </form:form>
         </td>
      </tr>
   </tfoot>
</table>
<form:form id="searchForm" modelAttribute="simpleCondition" method="get">
   <form:hidden path="searchType"/>
   <form:hidden path="searchWord"/>
   <input type="hidden" name="page" />
</form:form>
<script>
   $("[name=searchType]").val("${searchVO.searchType}");
   $("[name=searchWord]").val("${searchVO.searchWord}");
   
   let searchForm = $("#searchForm");
   let searchUI = $("#searchUI").on("click", "#searchBtn" , function(event){
      let inputs = searchUI.find(":input[name]");
      $.each(inputs, function(index, input){
         let name = this.name;
         let value = $(this).val();
         searchForm.find("[name="+name+"]").val(value);
      });
      searchForm.submit();
   });
   
   $("a.paging").on("click", function(event){
      event.preventDefault();
      let page =  $(this).data("page");
      if(!page){
         return false;
      }
      searchForm.find("[name=page]").val(page);
      searchForm.submit();
      return false;
   });
</script>
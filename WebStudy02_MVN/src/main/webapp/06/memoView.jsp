<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/memoView.jsp</title>
<jsp:include page="/includee/preScript.jsp"></jsp:include>
</head>
<body>
<h4>Restful 기반의 메모 관리</h4>
<form action="${pageContext.request.contextPath }/memo" method="post" id ="myForm">
	<input type="text" name ="writer" placeholder="작성자"/>
	<input type="date" name ="date2" placeholder="작성일"/>
	<textarea name = "content"></textarea>
	<input type="submit" value="등록"/>
</form>
<table class="table-bordered">
   <thead>
      <tr>
         <th>작성자</th>
         <th>작성일</th>
      </tr>
   </thead>
   <tbody id="listBody">
   
   </tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
// 	EDD(Event Driven Development)방법론 : 뭐든 이벤트로 처리되는 방법
//  TDD(Text Driven Development)방법론 : 단계적인 프린트를 진행하면서 로직을 만들어 나가는 과정

   $("#exampleModal").on("show.bs.modal", function(event){
//    	 this==event.target : modal창 자체
		let memo=$(event.relatedTarget).data("memo") //modal을 띄울 때 사용한 element(대상), tr태그
		console.log(memo.writer)
		$(this).find(".modal-body").html(memo.content)
	}).on("hidden.bs.modal",function(event){
		$(event.target).find(".modal-body").empty();
	});
	
   $
   let listBody = $("#listBody");
   let makeListBody = function(memoList){
      listBody.empty();
      let trTags=[];   
       if(makeListBody.length>0){
//          data-bs-toggle="modal" data-bs-target="#exampleModal"
          $.each(memoList, function(index, memo){
             let tr = $("<tr>").append(
                $("<td>").html(memo.writer)      
                ,$("<td>").html(this.date2)      
             ).attr({
               "data-bs-toggle":"modal"
               ,"data-bs-target":"#exampleModal"
             }).data("memo",memo);
             trTags.push(tr);
          });
      }else{
         let tr = $("<tr>").html(
            $("<td>")
               .attr("colspan","2")   
               .html("작성된 메모 없음.")
         );
         trTags.push(tr);
      }
       listBody.append(trTags);
    }
   
   $.ajax({
      url : "${pageContext.request.contextPath}/memo",
      method : "get",
      dataType : "json" //json으로 하면 리턴 타입은 언마샬링 script 타입이 온다.
      ,
      success : function(resp) {
    	 console.log(resp)
         makeListBody(resp.memoList)
            
      },
      error : function(jqXHR, status, error) {
         console.log(jqXHR);
         console.log(status);
         console.log(error);
      }
   });   
   
//    1. form을 비동기로 받아서 post할 예정 ( 서밋을 버튼으로 바꾸기)
   $('#myForm').submit(function(){
	   $.ajax({
		      url : "${pageContext.request.contextPath}/memo",
		      method : "post",	
		      dataType : "json" //json으로 하면 리턴 타입은 언마샬링 script 타입이 온다.
		      ,
		      success : function(resp) {
		      	 console.log(resp)
		      },
		      error : function(jqXHR, status, error) {
		         console.log(jqXHR);
		         console.log(status);
		         console.log(error);
		      }
		   });   
   })
   
   
</script>
<jsp:include page="/includee/postScript.jsp"/>
</body>
</html>
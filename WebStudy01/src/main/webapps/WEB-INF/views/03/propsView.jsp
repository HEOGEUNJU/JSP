<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src= "<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
<h4> properties 파일 뷰어 </h4>
<%--    <img src="<%=request.getContextPath() %>/resources/images/cat1.jpg"/> --%>
<label>
   <input type="radio" name = "dataType" value="json" checked>JSON
</label>
<label>
   <input type="radio" name = "dataType" value="xml">XML
</label>
<button type = "button" class = "loadData">LOAD DATA</button>
<button type = "button" class = "clearData">CLEAR DATA</button>

<table border=1px>
   <thead>
      <tr>
         <th>
            key
         </th>
         <th>
            value
         </th>
      </tr>
   </thead>
   <tbody id="tbody" >
   
   </tbody>
</table>
<script type="text/javascript">
   let listBody  = $("#tbody");
   let dataTypes = $("[name=dataType]");
   let makeTrTag = function(name, value){
	   let tr = $("<tr>").append(
               $("<td>").html(name)
               , $("<td>").html(value)
            );
	   return tr
   }
   let sucesses = {
      json : function(resp){
         console.log(resp.message)
         let trTags =[];
         $.each(resp.message, function(name, value){
            trTags.push(makeTrTag(name,value));
         });
         listBody.empty();
         listBody.append(trTags);
      },
      xml : function(domResp){
    	  console.log(domResp)
           let root = $(domResp).find("message");
           let trTags = [];
           root.children().each(function(idx, child){
            	let name = child.tagName;
            	let value= child.innerHTML;
            	let tr 	 = makeTrTag(name,value);
            	trTags.push(tr);
            });
           listBody.empty();
           listBody.append(trTags);
      }
   }
   let btn = $(".loadData").on("click",function(){
      let dataType = dataTypes.filter(":checked").val()
      $.ajax({
         dataType : dataType //json으로 하면 리턴 타입은 언마샬링 script 타입이 온다.
         ,
         success : sucesses[dataType],
         error : function(jqXHR, status, error) {
            console.log(jqXHR);
            console.log(status);
            console.log(error);
         }
      });
      
   });
   
   let clearBtn =  $(".clearData").on("click",function(){
      listBody.empty();
   });
</script>
</body>
</html>
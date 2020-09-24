<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html, body {
   text-align: center;
}

#table, tr, th, td {
   border: 1px solid silver;
   text-align: center;
   margin-left: auto;
   margin-right: auto;
   width: auto;
   height: auto;
}

.txt {
   width: 200px;
   height: 20px;
   border-style: none;
   text-align: center;
}

.select {
   width: 150px;
   height: 25px;
}

.draft {
   width: 500px;
   height: 20px;
   border-style: none;
   text-align: center;
   "
}

.draft2 {
   width: 600px;
   text-align: center;
}

.draft3 {
   width: 230px;
   border-style: none;
   text-align: center;
}

#ect {
   height: 300px;
   width: 950px;
}
</style>
</head>
<body>
<form id="fo">
      <div style="width: auto; background-color: #FFB2D9; color: white; padding: 1%;">기안문  상세보기</div>
      <div style="height: auto; padding-top: 5px; background-color: #F8F7F7;">
         <table id="table">
            <tr>
               <th>제목</th>
               <th><input type="hidden" name="j_title" value="${pa.p_title}">${pa.p_title}
               </th>

            </tr>
            <tr>
               <th>결재자</th>
               <th id="line">
               <input type="hidden" value="${pa.p_approver1}" name="appval">결재자1: ${pa.p_approver1} || 
                  <input type="hidden" value="${pa.p_approver2}" name="appval">결재자2: ${pa.p_approver2} || 
                  <input type="hidden" value="${pa.p_approver3}" name="appval">결재자3:${pa.p_approver3}
               </th>

            </tr>
            <tr>
               <th>내용</th>
               <td>
                  <div style="border: 1px solid #EAEAEA; background-color: white;">
                     <div>
                        <table>
                           <tr>
                              <th colspan="2">문서번호</th>
                              <th colspan="6"><input type="text" name="p_documentcode"
                                 class="txt" value="${pa.p_documentcode}" readonly>
                           </tr>
                           <tr>
                              <th colspan="2">거래처</th>
                              <td colspan="6"><input type="text" name="p_clcode"
                                 class="draft3" value="${pa.p_clcode}" readonly></td>
                               <%-- <th colspan="2">비용구분</th>
                              <td colspan="2"><input type="text" name="p_budget"
                                 class="draft3" value="${pa.p_budget}" readonly></td> --%>

                           </tr>
                           <tr>
                              <th colspan="2">제품일련번호</th>
                              <td colspan="2"><input type="text" name="p_productnum"
                                 class="txt" value="${pa.p_productnum}" readonly></td>
                              <th colspan="2">구매일</th>
                              <td colspan="2"><input type="text" name="p_day" class="txt" value="${pa.p_day}" readonly></td>
                           </tr>
                           <tr>
                           	  <th colspan="3">상품명</th>
							  <th >품목코드</th> 
							  <th >수량</th>
							  <th >단가</th>
							  <th colspan="2">합계</th>
                           </tr>
                           <tbody id="tbody"></tbody>
                           <tr>
                              <th colspan="2">기타</th>
                              <td colspan="6"><input type="text" name="p_etc"
                                 class="draft" value="${pa.p_etc}" readonly></td>
                           </tr>
                           <tr>
                              <th>반려사유</th>
                              <th colspan="8"><input type="text" name="j_reasion"
                                 value="${ac.j_reasion}" id="ect"></th>
                           </tr>
                        </table>
                     </div>
                  </div>
               </td>
            </tr>
         </table>
       </div>
     </form>
     
     <script type="text/javascript">
     	$(document).ready(function(){
     		var arr = new Array();
     	    var cnt = $("input[name='checknum']:checked").length;
     	      $("input[name='checknum']:checked").each(function() {
     	         arr.push($(this).attr('value'));
     	      });
     			
     		$.ajax({
     		   url : '/erp/rest/Purchase/addApproval',
               type : 'post',
               traditional : true,
               data : 'ARR=' + arr + '&CNT=' + cnt,
               datatype : 'json',
               success : function(data) {
            	   
               }
     		})
     		
        	
     		var pList = ${pList};
        	console.log(pList);
       		var str="";
        	for(var i in pList){
    			str+="<tr><td colspan=5'><input type='text' class='aaa' name='p_name' value='"+pList[i].p_name+"' readonly></td>";
    			str+="<td colspan='1'><input type='text' class='aaa' name='p_itcode' value='"+pList[i].p_itcode+"' readonly></td>";
    			str+="<td><input type='text' class='aaa'  name='p_amount' value='"+pList[i].p_amount+"' readonly></td>";
    			str+="<td><input type='text' class='aaa' name='p_unlit' value='"+pList[i].p_unlit+"' readonly></td>";
    			str+="<td colspan='1'><input type='text' class='aaa' name='p_budget' value='"+pList[i].p_budget+"' readonly></td></tr>";
       		};
        	$('#tbody').html(str);
   
     	})
     </script>
</body>
</html>
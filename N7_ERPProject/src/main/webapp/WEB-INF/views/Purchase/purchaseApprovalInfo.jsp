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
                           <tr>
                              <th colspan="2">제품일련번호</th>
                              <td colspan="6"><input type="text" name="p_productnum"
                                 class="draft" value="${pa.p_productnum}" readonly></td>
                           </tr>
                           <tr>
                           	  <th>상품명</th>
							  <th>품목코드</th>
							  <th>수량</th>
							  <th>단가</th>
							  <th>합계</th>
                           </tr>

                           <tr>
                              <th colspan="2">적요</th>
                              <td colspan="6"><input type="text" name="p_etc"
                                 class="draft" value="${pa.p_etc}" readonly></td>
                           </tr>
                           <tr>
                              <th>반려사유</th>
                              <th colspan="8"><input type="text" name="j_reasion"
                                 value="${ac.j_reasion}" id="ect"></th>
                           </tr>
                        </table>
                        <div>
                          <button type="button" id="submit">승인하기</button>
         				  <button type="button" id="">반려하기</button>
                        </div>
                     </div>
                  </div>
               </td>
            </tr>
         </table>
       </div>
     </form>
 <script type="text/javascript">
 	$(document).ready(function(){
 		arr= new Array();
 		var cnt= $("input[name='appval']").each(function(){
 			arr.push($(this).attr('value'));
 		});
 		
 		$.ajax({
 			url: '/erp/rest/Purchase/getApprovalInfo',
 			type: 'post',
 			traditional: true,
 			
 		})
 	})
 </script>
</body>
</html>
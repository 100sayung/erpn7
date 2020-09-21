<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
html,body{
text-align: center;
}
#pprogramwrite{
margin-top: 50px;
}
#table, tr, th, td{
border: 1px solid silver;
text-align: center;
margin-left: auto;
margin-right: auto;
}
.txt{
width: 200px;
height: 20px;
text-align: center;
}
.txt1{
width: 350px;
height: 20px;
text-align: center;
}
.select{
width: 150px;
height: 25px;
}   
.draft{
width: 500px; 
height: 20px; 
text-align: center;"
}
.draft2{
width: 600px; 
text-align: center;
}
.draft3{
width: 230px;
text-align: center;
}
#ect{
resize: none;
}
.aaa{
text-align: center;
}
</style>
</head>
<body>
   <form id="pprogramwrite">
   <div style="width: auto; background-color: white; padding: 1%;">
      <button type="button" id="approvalLine">결재라인 불러오기</button>
      <input type="button" id="submit" value="제출"> 
   </div>
   <div style="width: auto; background-color: #FFB2D9; color: white; padding: 1%;">기안문 작성</div>
   <div style="height: auto; padding-top: 5px; background-color: #F8F7F7;">
         <table id="table">
            <tr>
               <th>일자</th>
               <th><input type="text" name="p_date" class="draft2" placeholder="자동생성" readonly></tr>
            <tr>
               <th>제목</th>
               <th><input type="text" name="p_docuname" class="draft2"></th>
            </tr>
           <tr>
           		<th>상신자</th> 
           		<th><input type="text" name="p_writer" class="draft2" value="${ps.p_writer}" readonly></th>
           </tr>
            <tr>
               <th>결재자</th>
               <th id="line"></th>
            </tr>
            <tr>
               <th>내용</th>
               <td>
                        <table>
                           <tr>
                              <th colspan="8">구매 계획서</th>
                              <th><input type="text" name="p_documentcode" class="txt" value="${ps.p_documentcode}" readonly></th>
                           </tr>
                           <tr>
                              <th colspan="4">거래처</th>
                              <th><input type="text" name="p_clcode" class="txt" value="${ps.p_clcode}" readonly></th>
                              <th>구매일</th>
                              <th><input type="text" name="p_day" class="txt" value="${ps.p_day}" readonly></th>
                              <th colspan="1">제품일련번호</th>
                              <th><input type="text" name="p_productnum" class="txt" value="${ps.p_productnum}" readonly></th>
                           </tr>
                           <tr>
                              <th colspan="5">품명</th>
                              <th colspan="1">폼목코드</th>
                              <th>수량</th>
                              <th>단가</th>
                              <th colspan="1">합계</th>
                           </tr>
                           <tbody id=tbody></tbody>
                           <tr>
                              <th>기타</th>
                              <th colspan="9"><textarea rows="10" cols="125" name="p_ect" id="ect"></textarea></th>
                           </tr>
                    </table>
               </td>
            </tr>
         </table>
      </div>
   </form>
   <script>
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
    	
    	
    	$("#approvalLine").click(function() {
    	      window.open('/erp/Purchase/approvalLine', 'approvalLine', 'width=1400,height=700');
    	   });
    		
    	function setChildValue(data) {
    		console.log(data);
    		if (data.tList1 != "") {
    		var str = "";
    			for ( var i in data.tList1) {
    		        str +="<input type='text' name='rs_apcode"+i+"' value='"+data.tList1[i].hc_hrcode+"' hidden='true'>";
    				str +=data.tList1[i].hc_position+"/";
    				str +="<input style='width:50px;' type='text' name='p_approvel"+i+"' value='"+ data.tList1[i].m_name+"'>&nbsp;&nbsp;||&nbsp;&nbsp;";
    			}
    			console.log(str)
    			$("#line").append(str);
    		};
    	};
    	   
      	    $('#submit').click(function(){
    		   var obj = $('#pprogramwrite').serialize();
    		   $.ajax({
    			   url: '/erp/rest/Purchase/purchaseApproval',
    			   type: 'post',
    			   data: obj,
    			   dataType: 'json',
    			   success: function(data){
    				   console.log(data);
    			   },
    			   error: function(error){
    				   console.log(error);
    			   }
    		   });
    	   });    
    	
   </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영업결재 상세페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
html, body {
   text-align: center;
}

table, tr, th, td {
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
<<<<<<< HEAD
   <form id="fo">
=======
 ${msg}
   <form id="for">
>>>>>>> origin/JSJ
     <br>
     <br>
      <div style="width: auto; background-color: #FFB2D9; color: white; padding: 1%;">기안문 상세보기</div>
      <div style="height: auto; padding-top: 5px; background-color: #F8F7F7;">
         <table>
            <tr>
               <th>제목</th>
<<<<<<< HEAD
               <th><input type="hidden" name="bs_docuname" value="${sb.bs_docuname}"></th>
=======
               <th><input type="hidden" name="bs_docuname" value="${app.bs_docuname}">${app.bs_docuname}</th>
>>>>>>> origin/JSJ
            </tr>
            <tr>
               <th>결재자</th>
               <th id="line">
<<<<<<< HEAD
                  <input type="hidden" value="bs_approver1" name="bs_approver1">결재자1: ${ap.bs_approver1} || 
                  <input type="hidden" value="bs_approver2" name="">결재자2: ${ap.bs_approver2} || 
                  <input type="hidden" value="bs_approver3" name="">결재자3: ${ap.bs_approver3} ||
=======
                  <input type="hidden" value="${app.bs_apcode1}" name="code"> <!-- code -->
                  <input type="hidden" value="${app.bs_apcode2}" name="code"> <!-- code -->
                  <input type="hidden" value="${app.bs_apcode3}" name="code"> <!-- code -->
>>>>>>> origin/JSJ
               </th>

            </tr>
            <tr>
               <th>내용</th>
               <td>
                  <div style="border: 1px solid #EAEAEA; background-color: white;"><div>
                        <table>
                           <tr>
                              <th colspan="2">출하번호</th>
<<<<<<< HEAD
                              <th colspan="2"><input type="text" name="bs_docunum" class="txt" value="${sb.bs_docunum}" readonly></th>
                              <th colspan="2">거래처 회사코드</th>
                              <th colspan="2"><input type="text" name="bs_clcode" class="txt" value="${sb.bs_clcode}" readonly>
=======
                              <th colspan="2"><input type="text" name="bs_docunum" class="txt" value="${app.bs_docunum}" readonly></th>
                              <th colspan="2">거래처 회사코드</th>
                              <th colspan="2"><input type="text" name="bs_clcode" class="txt" value="${app.bs_clcode}" readonly>
>>>>>>> origin/JSJ
<%--                          <input type="hidden" name="j_grade" class="draft3" value="${ac.j_grade}" readonly></th>
                              <td>결재상태</td> --%>

                           </tr>
                           <tr>
                            <th colspan="2">회사코드</th>
<<<<<<< HEAD
                              <th colspan="2"><input type="text" name="bs_ccode" class="txt" value="${sb.bs_ccode}" readonly>
                              <%-- <input type="hidden" name="j_ccode" class="txt" value="${ac.j_ccode}" readonly></th> --%>
                              <th colspan="2">품목코드</th>
                              <th colspan="2"><input type="text" name="bs_itcode" class="txt" value="${sb.bs_itcode}" readonly></th> 
                           </tr>
                           <tr>
                              <th colspan="2">제품명</th>
                              <td colspan="2"><input type="text" name="bs_proname" class="draft3" value="${sb.bs_proname}" readonly></td>
                              <th colspan="2">예상납기일</th>
                              <td colspan="2"><input type="text" name="bs_basedate" class="draft3" value="${sb.bs_basedate}" readonly></td>
=======
                              <th colspan="2"><input type="text" name="bs_ccode" class="txt" value="${app.bs_ccode}" readonly>
                              <%-- <input type="hidden" name="j_ccode" class="txt" value="${ac.j_ccode}" readonly></th> --%>
                              <th colspan="2">품목코드</th>
                              <th colspan="2"><input type="text" name="bs_itcode" class="txt" value="${app.bs_itcode}" readonly></th> 
                           </tr>
                           <tr>
                              <th colspan="2">제품명</th>
                              <td colspan="2"><input type="text" name="bs_proname" class="draft3" value="${app.bs_proname}" readonly></td>
                              <th colspan="2">예상납기일</th>
                              <td colspan="2"><input type="text" name="bs_basedate" class="draft3" value="${app.bs_basedate}" readonly></td>
>>>>>>> origin/JSJ

                           </tr>
                          <tr>
                              <th colspan="2">판매단가</th>
<<<<<<< HEAD
                              <td colspan="5"><input type="text" name="bs_unit" class="draft" value="${sb.bs_unit}" readonly></td>
                           </tr>
                           <tr>
                              <th colspan="2">수량</th>
                              <td colspan="5"><input type="text" name="bs_quantity" class="draft" value="${sb.bs_quantity}" readonly></td>
=======
                              <td colspan="5"><input type="text" name="bs_unit" class="draft" value="${app.bs_unit}" readonly></td>
                           </tr>
                           <tr>
                              <th colspan="2">수량</th>
                              <td colspan="5"><input type="text" name="bs_quantity" class="draft" value="${app.bs_quantity}" readonly></td>
>>>>>>> origin/JSJ
                           </tr>

                           <tr>
                              <th>판매금액</th>
<<<<<<< HEAD
                              <td colspan="7"><input type="text" name="bs_price" class="draft" value="${sb.bs_price}" readonly></td>
=======
                              <td colspan="7"><input type="text" name="bs_price" class="draft" value="${app.bs_price}" readonly></td>
>>>>>>> origin/JSJ
                           </tr>
                            <tr>
                              <th>반려사유</th>
                              <th colspan="8"><input type="text" name="bs_ect" id="ect"></th>
                           </tr>
                        </table>
                     </div>
                  </div>
               </td>
            </tr>
         </table>  
<<<<<<< HEAD
   <script>
/*    $(document).ready(function(){
    $.ajax({
       
    });
   }); */
  
   
   </script>
=======
       </form>
         <br>
   <script>
/* 	$('#for').click(function() {
	  
		var obj = $("#for").serialize();
	   console.log(obj);

	$.ajax({
		url : '/erp/rest/sales/approvaldetailinput',
		type : 'post',
		data : obj,
		dateType : "json",
		success : function(data) {
			if (data == 1) {
				console.log(data);
				$("#for")[0].reset();
				alert("결재안 저장을 완료하였습니다.");
			} else {
				alert("결재안 저장이 실패하였습니다.");
				console.log(data);
			}
		},
		error : function(error) {
			console.log(error);
		}
	});
  }); */
	
  /*  $(document).ready(function(){
	      $.ajax({
	         url:'/erp/rest/sales/getMyInfo',
	         type:'get',
	         datatype:'json',
	         success:function(data){
	            console.log(data);
	            var str = "";
	            for ( var i in data.sList) {
	                 str +="<input type='text' name='bs_apcode"+(Number(i)+Number(1))+"' value='"+data.sList[i].hc_hrcode+"' hidden='true'>";
	               str +=data.sList[i].hc_position+"/";
	               str +="<input style='width:50px;' type='text' name='bs_approver"+(Number(i)+Number(1))+"' value='"+ data.sList[i].m_name+"'>&nbsp;&nbsp;||&nbsp;&nbsp;";
	            }
	            console.log(str)
	            $("#line").html(str);
	         
	         },
	         error:function(error){
	            console.log(error);
	         }
	      });
	       
	    }); */
   
   
  	$(document).ready(function() {
				var arr = new Array();
				var cnt = $("input[name='code']").length;

				$("input[name='code']").each(function() {
					arr.push($(this).attr('value'));
				}); 
				

				$.ajax({
							url : '/erp/rest/sales/getApprinfo',
							type : 'post',
							traditional : true,
							data : 'ARR=' + arr + '&CNT=' + cnt,
							success : function(data) {
								console.log(data);
								var str = "";
								for ( var i in data.sList) {
									str += "<input type='text' name='bs_apcode"+(Number(i)+Number(1))+"' value='"+data.sList[i].hc_hrcode+"' hidden='true'>";
									str += data.sList[i].hc_position
											+ "/";
									str += "<input style='width:50px;' type='text' name='bs_approver"+(Number(i)+Number(1))+"' value='"+ data.sList[i].m_name+"'>&nbsp;&nbsp;||&nbsp;&nbsp;";
								}
								console.log(str)
								$("#line").append(str);

							},
							error : function(error) {
								console.log(error);
							}
						});
			});  
			
			
            
</script>
>>>>>>> origin/JSJ
</body>
</html>
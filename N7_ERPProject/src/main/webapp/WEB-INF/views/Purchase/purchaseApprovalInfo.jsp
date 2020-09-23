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
<form id="fo">
      <div style="width: auto; background-color: #FFB2D9; color: white; padding: 1%;">기안문  상세보기</div>
      <div style="height: auto; padding-top: 5px; background-color: #F8F7F7;">
         <table>
            <tr>
               <th>제목</th>
               <th><input type="hidden" name="j_title" value="${ac.j_title}">${ac.j_title}
               </th>

            </tr>
            <tr>
               <th>결재자</th>
               <th id="line">
               <input type="hidden" value="${ac.j_none}" name="j_none">결재자1: ${ac.j_none} || 
                  <input type="hidden" value="${ac.j_ntwo}" name="j_ntwo">결재자2: ${ac.j_ntwo} || 
                  <input type="hidden" value="${ac.j_nthr}" name="j_nthr">결재자3:${ac.j_nthr}
               </th>

            </tr>
            <tr>
               <th>내용</th>
               <td>
                  <div style="border: 1px solid #EAEAEA; background-color: white;">
                     <div>
                        <table>
                           <tr>
                              <th colspan="2">계정과목</th>
                              <th colspan="2"><input type="text" name="j_account"
                                 class="txt" value="${ac.j_account}" readonly></th>
                              <th colspan="2">문서번호</th>
                              <th colspan="2"><input type="text" name="j_docunum"
                                 class="txt" value="${ac.j_docunum}" readonly><input
                                 type="hidden" name="j_grade" class="draft3"
                                 value="${ac.j_grade}" readonly></th>
                              <!--                               <td>결재상태</td> -->

                           </tr>
                           <tr>
                              <th colspan="2">활동센터</th>
                              <th colspan="2"><input type="text" name="j_centre"
                                 class="txt" value="${ac.j_centre}" readonly><input
                                 type="hidden" name="j_ccode" class="txt"
                                 value="${ac.j_ccode}" readonly></th>
                              <th colspan="2">귀속부서</th>
                              <th colspan="2"><input type="text" name="j_section"
                                 class="txt" value="${ac.j_section}" readonly></th>
                           </tr>
                           <tr>
                              <th colspan="2">비용구분</th>
                              <td colspan="2"><input type="text" name="j_group"
                                 class="draft3" value="${ac.j_group}" readonly></td>
                              <th colspan="2">관계회사</th>
                              <td colspan="2"><input type="text" name="j_company"
                                 class="draft3" value="${ac.j_company}" readonly></td>

                           </tr>
                           <tr>
                              <th colspan="2">차변금액</th>
                              <td colspan="5"><input type="text" name="j_debit"
                                 class="draft" value="${ac.j_debit}" readonly></td>
                           </tr>
                           <tr>
                              <th colspan="2">대변금액</th>
                              <td colspan="5"><input type="text" name="j_credit"
                                 class="draft" value="${ac.j_credit}" readonly></td>
                           </tr>

                           <tr>
                              <th>적요</th>
                              <td colspan="7"><input type="text" name="j_sumup"
                                 class="draft" value="${ac.j_sumup}" readonly></td>
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
</body>
</html>
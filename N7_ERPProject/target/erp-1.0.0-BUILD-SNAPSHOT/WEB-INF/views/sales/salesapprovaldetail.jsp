<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영업결재 상세페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
html,body{
text-align: center;
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
/* border-style: none; */
border: 1px solid silver;
text-align: center;
}
.select{
width: 150px;
height: 25px;
}   
.draft{
width: 500px; 
height: 20px; 
/* border-style: none; */
border: 1px solid silver; 
text-align: center;"
}
.draft2{
width: 600px; 
text-align: center;
}
.draft3{
width: 230px;
/* border-style: none; */
border: 1px solid silver;
text-align: center;
}
#ect{
resize: none;
}
</style>
</head>
<body>
   <form id="">
   <div style="width: auto; background-color: white; padding: 1%;">
   </div>
   
   <div style="width: auto; background-color: #FFB2D9; color: white; padding: 1%;">영업결재 상세페이지</div>
   <div style="height: auto; padding-top: 5px; background-color: #F8F7F7;">
         <table id="table">
            <tr>
               <th>일자</th>
               <th><input type="date" name="bs_date" class="draft2" ></th>
            </tr>
            <tr>
               <th>제목</th>
               <th><input type="text" name="bs_docuname" class="draft2"></th>
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
                              <th colspan="6">출하 요청서</th>
                              <th><input type="radio" name="bs_credit" value="외상">&nbsp;외상
                                  <input type="radio" name="bs_credit" value="완납">&nbsp;완납 </th>
                              <th><input type="text" name="bs_docunum" value="${sb.bs_docunum}" placeholder="출하번호" class="txt"></th>
                           </tr>
                           <tr>
                          <th colspan="3">상신자</th>
                              <th colspan="1"><input type="text"></th> <!-- name="bs_approver1" --> <!--bo_num-->
                              <th colspan="2">거래처 회사코드</th>
                              <th colspan="2"><input type="text" name="bs_clcode" value="${sb.bs_clcode}" class="txt"></th>
                           </tr>
                        </table>
                     </td>
               </tr>
            </table>
         </div>
   </form>
   
   
   <script>     
   </script>
</body>
</html>
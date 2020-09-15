<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거래처등록</title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/erp/js/jquery.serializeObject.js"></script>
<style>
<
style>body, td, th, select, textarea {
   font-family: Nanum Gothic, Gulim, Arial, ms sans serif;
   font-size: 11px;
   color: #000;
}

.main {
   width: 50%;
   height: 50%;
   display: inline;
   float: left;
   overflow: auto:
}

#search {
   width: 50px;
}

#Info {
   text-align: center;
}
</style>
</head>
<body>
   <div id="mainhead" class="main">
      <br>
      <form id="code">
               <input type="text" name="c_code">
               <button type="button" id="codesearch">코드검색</button>
                       </form>
                       <button type="button" id="Alllist">전체리스트</button>
                    
                       <button type="button" id="delete">삭제</button>
      
         <table id="Info">
            <tbody id="Tbody">
               
            </tbody>
         </table>
   </div>
   <div id="maincontents" class="main">
      <form id="comInfo">
         <br>
         <table>
            <tbody>
               <tr>
                  <th class="th1">거래처코드</th>
                  <td class="th2"><input type="text" name="c_code"
                     class="noline00"
                     style="width: 45px; background: #FFFFFF;"></td>
                  <th class="th3">거래처명</th>
                  <td class="th4"><input type="text" name="c_name"
                     class="noline00"
                     style="width: 145px; background: #FFFFFF; -ms-ime-mode: active;"></td>
               </tr>
               <tr>
                  <th class="th1">사업자번호</th>
                  <td class="th2"><input type="text" autocomplete="off"
                     name="c_comnum" class="nolineEx"></td>
                  <th class="th3">대표자명</th>
                  <td class="th4"><input type="text" name="c_ceo"
                     class="noline00"
                     style="width: 145px; background: #FFFFFF; -ms-ime-mode: active;"></td>
               </tr>
               <tr>
                  <th class="th1">담당자명</th>
                  <td class="th2"><input type="text" name="c_employee"
                     class="noline00"
                     style="width: 145px; background: #FFFFFF; -ms-ime-mode: active;"></td>
                  <th class="th3">전화번호</th>
                  <td class="th4"><input type="text" name="c_phone"
                     class="noline00"
                     style="width: 145px; background: #FFFFFF;"></td>
               </tr>
               <tr>
                  <th class="th1">핸드폰번호</th>
                  <td class="th2"><input type="text" name="c_phone2"
                     class="noline00"
                     style="width: 145px; background: #FFFFFF;"></td>
                  <th class="th3">팩스번호</th>
                  <td class="th4"><input type="text" name="c_fax"
                     class="noline00"
                     style="width: 145px; background: #FFFFFF;" value=""></td>
               </tr>
               <tr>

                  <th class="th3">email</th>
                  <td class="th4"><input type="text" autocomplete="off"
                     name="c_email" class="noline00"
                     style="ime-mode: inactive; width: 145px; background: #FFFFFF;"
                     value=""></td>
               </tr>
               <tr>
                  <th class="th1">우편번호</th>
                  <td class="th2"><input type="text" name="c_addrnum"
                     class="noline00"
                     style="width: 80px; background: #FFFFFF;"></td>

               </tr>


               <tr>
                  <th class="th1">주소</th>
                  <td colspan="3"><input type="text" name="c_addr"
                     class="noline00"
                     style="width: 380px; background: #FFFFFF; -ms-ime-mode: active;"><br>
                  </td>
               </tr>
               <tr>
                  <th class="th1">업태</th>
                  <td class="th2"><input type="text" name="c_kind"
                     class="noline00"
                     style="width: 145px; background: #FFFFFF; -ms-ime-mode: active;"></td>
                  <th class="th3">종목</th>
                  <td class="th4"><input type="text" name="c_kind2"
                     class="noline00"
                     style="width: 145px; background: #FFFFFF; -ms-ime-mode: active;"></td>
               </tr>
               <tr>
                  <th class="th1">거래은행</th>
                  <td class="th2"><input type="text" name="c_bank"
                     class="noline00"
                     style="width: 145px; background: #FFFFFF; -ms-ime-mode: active;"></td>
                  <th class="th3">예금주</th>
                  <td class="th4"><input type="text" name="c_bankholder"
                     class="noline00"
                     style="width: 145px; background: #FFFFFF; -ms-ime-mode: active;"></td>
               </tr>
               <tr>
                  <th class="th1">계좌번호</th>
                  <td><input type="text" name="c_banknum"
                     class="noline00" style="width: 145px; background: #FFFFFF;"></td>
                  <th>종사업장번호</th>
                  <td><input type="text" name="c_comnum2"
                     class="noline00" style="width: 145px; background: #FFFFFF;"></td>
               </tr>
               <tr>
                  <th class="th1">유형</th>
                  <td class="th2" style="padding-left: 10px;"><select
                     name="c_kind3" class="select1"
                     style="width: 60px;">
                        <option value="">--</option>
                        <option value="매출">매출</option>
                        <option value="매입">매입</option>
                  </select></td>

                  <th class="th3">폐업일자</th>
                  <td class="th4" align="center"><input type="text"
                     name="c_finish"></td>
               </tr>

               <tr>
                  <th class="th1">메모</th>
                  <td colspan="3"><textarea name="c_memo"
                        style="width: 380px; height: 75px; background: #FFFFFF; -ms-ime-mode: active;"></textarea></td>
               </tr>
            </tbody>

         </table>
         <button type="button" id="insertcomlist">저장</button>
      </form>
   </div>

</body>
<script type="text/javascript">
   
    $("#Alllist").click(function(){
      $.ajax({
         url : 'rest/serchcomlist',
         type : 'get',
         contentType : 'application/json; charset=UTF-8',
         dataType : 'json',
         success : function(data) {
            console.log(data);
            var List="";
            List+="<tr><th><input name='Allcheck' type='checkbox'></th><th>코드</th><th>거래처명</th><th>사업자(주민)번호</th><th>대표자명</th><th>업태</th><th>유형</th></tr>";
            for ( var i in data.aList) {
               List+="<tr>";
               List+="<td><input type='checkbox' name='reportChkBxRow' value="+data.aList[i].c_code+"></td>";
               List+="<td>" + data.aList[i].c_code + "</td>";
               List+="<td>" + data.aList[i].c_name + "</td>";
               List+="<td>" + data.aList[i].c_comnum + "</td>";
                List+="<td>" + data.aList[i].c_ceo + "</td>";
               List+="<td>" + data.aList[i].c_kind + "</td>";
               List+="<td>" + data.aList[i].c_kind3 + "</td>";
               List+="</tr>";
            }
                 $("#Tbody").html(List);
                 $("input").html("");
         },
         error : function(error) {
            console.log(error);
         }
      });

   });

   $("#codesearch").click(function() {
      var obj = $("#code").serializeObject();
      var json = JSON.stringify(obj);
      console.log(json);
                  $.ajax({
                           url : 'rest/searchcode',
                           type : 'post',
                           contentType : 'application/json; charset=UTF-8',
                           data : json,
                           dataType : 'json',
                           success : function(data) {
                           
                              console.log(data);
                              var List="";
                              List+="<tr><th><input type='checkbox'></th><th>코드</th><th>거래처명</th><th>사업자(주민)번호</th><th>대표자명</th><th>업태</th><th>유형</th></tr>";
                              for ( var i in data.aList) {
                                 List+="<tr>";
                                 List+="<td><input type='checkbox' name='reportChkBxRow' value="+data.aList[i].c_code+"></td>";
                                 List+="<td>" + data.aList[i].c_code + "</td>";
                                 List+="<td>" + data.aList[i].c_name + "</td>";
                                 List+="<td>" + data.aList[i].c_comnum + "</td>";
                                  List+="<td>" + data.aList[i].c_ceo + "</td>";
                                 List+="<td>" + data.aList[i].c_kind + "</td>";
                                 List+="<td>" + data.aList[i].c_kind3 + "</td>";
                                 List+="</tr>";
                              }
                                   $("#Tbody").html(List);
                            },
                           error : function(error) {
                              console.log(error);
                           }
                        });
               });  
   
   $("#insertcomlist").click(function() {
                  var obj = $("#comInfo").serializeObject();
                  //var json = JSON.stringify(obj);
                  //console.log(json)
                  $.ajax({
                           url : 'rest/insertcomlist',
                           type : 'post',
                           //contentType : 'application/json; charset=UTF-8',
                           data : obj,
                           dataType : 'json',
                           success : function(data) {
                              console.log(data);
                              var List="";
                              List+="<tr><th><input type='checkbox'></th><th>코드</th><th>거래처명</th><th>사업자(주민)번호</th><th>대표자명</th><th>업태</th><th>유형</th></tr>";
                              for ( var i in data.aList) {
                                 List+="<tr>";
                                 List+="<td><input  type='checkbox' name='reportChkBxRow' value="+data.aList[i].c_code+"></td>";
                                 List+="<td>" + data.aList[i].c_code + "</td>";
                                 List+="<td>" + data.aList[i].c_name + "</td>";
                                 List+="<td>" + data.aList[i].c_comnum + "</td>";
                                  List+="<td>" + data.aList[i].c_ceo + "</td>";
                                 List+="<td>" + data.aList[i].c_kind + "</td>";
                                 List+="<td>" + data.aList[i].c_kind3 + "</td>";
                                 List+="</tr>";
                              }
                                   $("#Tbody").html(List);
                                   $("input").html("");
                           },
                           error : function(error) {
                              console.log(error);
                           }
                        });
               });
   
   $("#delete").click(function(){
       var cnt = $("input[name='reportChkBxRow']:checked").length;
        var arr = new Array();
           $("input[name='reportChkBxRow']:checked").each(function() {
               arr.push($(this).attr('value'));
               
              });
           if(cnt==0){
              alert("선택된 내용이 없습니다");
           }else{
      //var json = JSON.stringify(arr);
              $.ajax({
                 url:'rest/deleteCom',
                 type:'post',
                 traditional : true,
                 //contentType : 'application/json; charset=UTF-8',
                 data:'ARR='+arr+'&CNT='+cnt,
                 datatype:'json',
                 success:function(data){
                    console.log(data);
                    var List="";
                  List+="<tr><th><input type='checkbox'></th><th>코드</th><th>거래처명</th><th>사업자(주민)번호</th><th>대표자명</th><th>업태</th><th>유형</th></tr>";
                  for ( var i in data.aList) {
                     List+="<tr>";
                     List+="<td><input  type='checkbox' name='reportChkBxRow' value="+data.aList[i].c_code+"></td>";
                     List+="<td>" + data.aList[i].c_code + "</td>";
                     List+="<td>" + data.aList[i].c_name + "</td>";
                     List+="<td>" + data.aList[i].c_comnum + "</td>";
                      List+="<td>" + data.aList[i].c_ceo + "</td>";
                     List+="<td>" + data.aList[i].c_kind + "</td>";
                     List+="<td>" + data.aList[i].c_kind3 + "</td>";
                     List+="</tr>";
                  }
                       $("#Tbody").html(List);
                       $("input").html("");
                 },
                 error:function(error){
                    console.log(error);
                 }
                 
              });
           }
           console.log(arr);
           console.log(cnt);
           
   });
   
</script>
</html>
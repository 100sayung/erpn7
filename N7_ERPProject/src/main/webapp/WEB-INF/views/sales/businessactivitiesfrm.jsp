<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <center>
      <br>
        <button type="button" id="businessitemfrm">영업 실적조회</button>${msg}
        <br>
        <br>
        <div style="width:auto; background-color:#FFB2D9;  color:white; padding:1%;">영업활동</div>
         <select id="choice" style="width:180px;">
                      <option value="ba_ocode">영업코드</option>
                      <option value="ba_hrcode">사원코드</option></select>
          <input type="text" name="search" id="search">    
          <button type="button" id="searchh" value="검색">검색</button>   
        <form id="businessactivitiesinput">
        <div border="1" style="height:80px; padding-top:25px; background-color:#F8F7F7;">
        <table>
         <thead>
            <tr>
               <th>영업코드</th>
               <th><input type="text" name="ba_ocode" placeholder="자동생성" readonly></th>
               <th>회사코드</th>
               <th><input type="text" name="ba_ccode"></th>
               <th>거래처회사코드</th>
               <th><input type="text" name="ba_clcode"></th>
               <th>사원코드</th>
               <th><input type="text" name="ba_hrcode"></th>
            </tr>
            <tr>
               <th>사업단위</th>
               <th><input type="text" name="ba_unit"></th>
               <th>영업기간 시작</th>
               <th><input type="date" name="ba_startperiod" min="2000-01-01" max="2030-12-31" style="width:140px;"></th>
               <th>영업기간 끝</th>
               <th><input type="date" name="ba_endperiod" min="2000-01-01" max="2030-12-31" style="width:140px;"></th>
            </tr>
         </thead>
      </table>
      </div> 
            <div style="background-color:#ECEBEA;">
            <table id="item" summary="Code page support in different versions of MS Windows." rules="groups" frame="hsides" border="1">
                <colgroup align="center">
                </colgroup>
                <colgroup align="left">
                </colgroup>
                <colgroup span="2" align="center">
                </colgroup>
                <colgroup span="3" align="center">
                </colgroup>
                <thead valign="top">
                    <tr>
                        <th><input type="checkbox" id="allCheck"></th>
                        <th>날짜</th>
						<th>내용</th>
						<th>예상매출금액</th>
						<th>실제매출금액</th>
						<th>종료일자</th>
						<th>메모</th>					
					</tr>
                </thead>
                <tbody id="tBody">
                    <tr>
                        <td><input type="checkbox" class="each"></td>          
                        <td><input type="date" name="ba_date" id="add"></td>
                        <td><input type="text" name="ba_content"  required></td>
                        <td><input type="number" name="ba_estimatedsalesamount" required></td>
                        <td><input type="number" name="ba_actualsalesamount"></td>                
                        <td><input type="text" name="ba_enddate" required></td>
                        <td><input type="text" name="ba_memo" required></td>    
                    </tr>
                </tbody>
            </table>
            </div>  
        </form>
            <br>
            <button type="button" id="addList" value="추가">추가</button>
            <button type="button" id="change" value="변경" >변경</button>
            <button type="button" id="deleteCheck" value="삭제">삭제</button>
            <button type="button" id="sub" value="저장">저장</button>
            
    </center>
    <br>
    <br>

    
    <script type="text/javascript">
        $("#addList").click(function() {
            var str = '';
            for (var i = 0; i < $("#add").val(); i++) {
                str += '<tr><td><input type="checkbox" class="each"></td><td><input type="text" name="date" id="add" required></td><td><input type="text" name="client"  required></td><td><input type="text" name="content" required></td><td><input type="text" name="estimated_sales_amount" required></td><td><input type="text" name="actual_sales_amount" required></td><td><input type="text" name="end_date"></td></tr>';
            }
            $("#tBody").append(str);
            $("#add").val(1);
        });
        
        $("#deleteCheck").click(function() {
            for (var i = 0; i < $(".each").length; i++) {
                if ($(".each")[i].checked == true) {
                    $(".each")[i].parentElement.parentElement.remove();
                    i--;
                }
            }
        })
        
      $('#businessitemfrm').click(function(){
        	var str="";
        	
        	$.ajax({
        		url:'rest/businessitem',
        		type: 'get',
        		dataType: "json",
        		success:function(data){
        			console.log(data);
        			
        			for(var i in data.bList){
        				str+="<tr><td><input type='checkbox' name='checknum' value="+data.bList[i].ba_ocode+"></td>";
        				str+="<td><input type='text' value="+data.bList[i].ba_date+"></td>";
        				str+="<td><input type='text' value="+data.bList[i].ba_content+"></td>";
        				str+="<td><input type='text' value="+data.bList[i].ba_estimatedsalesamount+"></td>";
        				str+="<td><input type='text' value="+data.bList[i].ba_actualsalesamount+"></td>";
        				str+="<td><input type='text' value="+data.bList[i].ba_enddate+"></td>";
        				str+="<td><input type='text' value="+data.bList[i].ba_memo+"></td></tr>";

        			}
        				$('#tBody').html(str);
        		},
        		error:function(error){
        			console.log(error);
        		}
        	})
        });
        
       $('#sub').click(function(){
        	var obj= $('#businessactivitiesinput').serialize();

        	$.ajax({
        			type : 'post',
        			url : 'rest/businessactivitiesinput',
        			data:obj,
        			success : function(data) {
        				console.log(data);
        			},
        			error : function(error) {
        				console.log(error);
        			}
        		});
        	    $('input').val("");
        	});           
        
       $('#searchh').click(function(){
    	  var choice=$('#choice').val();
    	  var search=$('#search').val();
    	  
    	  $.ajax({
    		  type : 'post',
    	      url : 'rest/businessactivitiessearch',
    	      data: "choice="+choice+"&search="+search,
    	      dataType: "json",
    	      success : function(data){
    	    	  console.log(data);
    	    	  
    	    	  var str="";
    	    	  if(data.bList!=""){
    	          for(var i in data.bList){
      				str+="<tr class='tr'><td><input type='checkbox' name='each_check' value="+data.bList[i].ba_ocode+"></td>";
    				str+="<td><input type='text' value="+data.bList[i].ba_date+"></td>";
    				str+="<td><input type='text' value="+data.bList[i].ba_content+"></td>";
    				str+="<td><input type='text' value="+data.bList[i].ba_estimatedsalesamount+"></td>";
    				str+="<td><input type='text' value="+data.bList[i].ba_actualsalesamount+"></td>";
    				str+="<td><input type='text' value="+data.bList[i].ba_enddate+"></td>";
    				str+="<td><input type='text' value="+data.bList[i].ba_memo+"></td>";
    	          }
    	            $('#tBody').html(str);
    	    	  }else{
    	    		  alert("데이터가 없습니다.");
    	    	  }
    	      },
    	      error : function(error){
    	    	  console.log(error);
    	      } 
    	  });
       });

</script>
</body>
</html>
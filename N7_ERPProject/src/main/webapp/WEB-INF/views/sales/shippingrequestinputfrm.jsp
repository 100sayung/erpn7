<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<style>
html, body {
text-align:center;
	height: 100%;
	margin: 0
}

tr,td{
text-align: center;
width: 150px;
border: 1px solid;
}

</style>
<body>
    <center>
        <br>
        <button type="button" id="shippingitemfrm">출하등록 현황</button>
        <button type="button" id="approvalplan">결재 요청하기</button>
        <br>
        <br>
        <div style="width:auto; background-color:#FFB2D9;  color:white; padding:1%;">출하의뢰입력</div>
          <select id="choice" style="width:180px;">
                      <option value="bs_docunum">출하번호</option>                    
                      <option value="bs_bonum">수주번호</option>
                      <option value="bs_clcode">거래처회사코드</option>
          </select>
        <input type="text" name="search" id="search">    
        <button id="searchh">검색</button>   
        <form id="shippingrequestinput">
        <div border="1" style="height:60px; padding-top:25px; background-color:#F8F7F7;">
        <table>
         <thead>
            <tr>
               <th>출하번호</th>
               <th><input type="text" name="bs_docunum" placeholder="자동생성" readonly></th>
               <th>회사코드</th>
               <th><input type="text" name="bs_ccode"></th>
               <th>수주번호</th>
               <th><input type="text" name="bs_bonum"></th>
               <th>품목코드</th>
               <th><input type="text" name="bs_itcode"></th>
            </tr>
            <tr>
               <th>제품명</th>
               <th><input type="text" name="bs_proname"></th>
               <th>거래처회사코드</th>
               <th><input type="text" name="bs_clcode"></th>
               <th>출하의뢰일</th>
               <th><input type="date" name="bs_basedate"></th>         
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
						<th>판매단가</th>
						<th>수량</th>
						<th>판매금액</th>						
					</tr>
                </thead>
                <tbody id="tBody">
                    <tr>
                        <td><input type="checkbox" name="each_check" class="each"></td>          
                        <td><input type="number" name="bs_unit"  required></td>
                        <td><input type="number" name="bs_quantity" required></td>
                        <td><input type="number" name="bs_price" required></td>           
                    </tr>
                </tbody>
            </table>
            </div>  
            <br>
            <div>
              <button type="button" class="addList" value="추가">추가</button>
              <button type="button" id="deleteCheck" value="삭제">삭제</button>
              <button type="button" id="sub">저장</button>
            </div>
            </form>
    </center>
    <br>
    <br>
    <div id="a">
    
    
    </div>
    
    <script type="text/javascript">
    $('#shippingitemfrm').click(function(){
      var str="";
	
	  $.ajax({
		url: '/erp/rest/sales/shippingitem',
		type: 'get',
		dataType: "json",
		success:function(data){
			console.log(data);
			
			for(var i in data.sList){
				str+="<tr><td><input type='checkbox' name='each_check' value="+data.sList[i].bs_docunum+"></td>";
				str+="<td><input type='number' value="+data.sList[i].bs_unit+"></td>";
				str+="<td><input type='number' value="+data.sList[i].bs_quantity+"></td>";
				str+="<td><input type='number' value="+data.sList[i].bs_price+"></td>";				
			}
				$('#tBody').html(str);
		},
		error:function(error){
			console.log(error);
		}
	});
  });
      
        //추가삭제
        $(document).ready(function(){
              $('.addList').click(function(){
                 $('#tBody').append('<tr><td><input type="checkbox" name="each_check" class="each"></td><td><input type="number" name="bs_unit" class="input-text" ></td><td><input type="number" name="bs_quantity" class="input-text"></td><td><input type="number" name="bs_price" class="input-text" ></td><td><input type="button" value="삭제" onclick="javascript:thisRowDel(this);"></td></tr>');
              });                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
          }); 
           function thisRowDel(row){
                console.log(row);
                let tr = row.parentNode.parentNode;
                tr.parentNode.removeChild(tr);
         };    
        
        
    $('#sub').click(function(){
    	console.log("저장클릭");
    
    	var obj= $('#shippingrequestinput').serialize();

    	$.ajax({
    			type : 'post',
    			url : '/erp/rest/sales/shippingrequestinput',
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
    
		
         $("#approvalplan").click(function(){
        	 var check='';
        	 $("input[name=each_check]:checked").each(function(){
        		check= $(this).attr("value");
        		
        		console.log(check);
        		if(check!=""){
        			window.open("approvalplan?check="+check,'approvalplan','width=1200,height=700')
        		}
        	 }); 
         });
         
         
         $('#searchh').click(function(){
            var choice=$('#choice').val();
         	var search=$('#search').val();
         	console.log(choice);
         	console.log(search);
         	$.ajax({
         			type : 'post',
         			url : 'rest/shippingrequestsearch',
         			data: "choice="+choice+"&search="+search,
         			dataType: "json",
         			success : function(data) {       				
         				console.log(data);
         				
         				var str="";
             			if(data.sList!=""){
         				for(var i in data.sList){
         					str+="<tr class='tr'><td><input type='checkbox' name='each_check' value="+data.sList[i].bs_docunum+"></td>";
         					str+="<td><input type='number' value="+data.sList[i].bs_unit+"></td>";
         					str+="<td><input type='number' value="+data.sList[i].bs_quantity+"></td>";
         					str+="<td><input type='number' value="+data.sList[i].bs_price+"></td>";
             			  }
             				$('#tBody').html(str);
             			}else{
             				alert("데이터가 없습니다.");
             			}	
         			},
         			error : function(error) {
         				console.log(error);
         			}
         		});
         	});
         
         
         $('#deleteCheck').click(function(){
         	var check="";
         	$("input[name=each_check]:checked").each(function(){
         		check = $(this).attr("value");
         		console.log(check);
         	});
         	
         	$.ajax({
         			type : 'post',
         			url : 'rest/shippingrequestdelete',
         			data: {check:check},
         			dataType: "json",
         			success : function(data) {       				
         				console.log(data);
         				var str="";
         				
         				for(var i in data.sList){
         					str+="<tr><td><input type='checkbox' name='each_check' value="+data.sList[i].bs_docunum+"></td>";
         					str+="<td><input type='number' value="+data.sList[i].bs_unit+"></td>";
         					str+="<td><input type='number' value="+data.sList[i].bs_quantity+"></td>";
         					str+="<td><input type='number' value="+data.sList[i].bs_price+"></td>";
             			}
             				$('#tBody').html(str);
         			},
         			error : function(error) {
         				console.log(error);
         			}
         		});
         	});
	
</script>
</body>
</html>
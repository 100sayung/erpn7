<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거래처등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- <script src="js/jquery.serializeObject.js"></script> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- BOOTSTRAP STYLES-->
    <link href="/erp/assets/css/bootstrap.css" rel="stylesheet">
     <!-- FONTAWESOME STYLES-->
    <link href="/erp/assets/css/font-awesome.css" rel="stylesheet">
        <!-- CUSTOM STYLES-->
    <link href="/erp/assets/css/custom.css" rel="stylesheet">
     <!-- GOOGLE FONTS-->
   <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="/erp/assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="/erp/assets/js/bootstrap.min.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="/erp/assets/js/custom.js"></script>
<style>

body, td, th, select, textarea {
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
#maincontents{
border: 3px double #e1e1e1;
border-radius: 8px;
}
#mainhead{
border: 3px double #e1e1e1;
border-radius: 8px;
height: 485px;
text-align: center;
}

#Info{
width:100%;
}
.allinfo{
font-size: 20px;
}
</style>
</head>
<body>
	<div id="mainhead" class="main">
		<br>
		<!-- <form id="code"> -->
					<input type="text" id="code">
					<button type="button" id="codesearch">코드검색</button>
	                    <!-- </form> -->
	                    <button type="button" id="Alllist">전체리스트</button>
				        
	                    <button type="button" id="delete">삭제</button>
		
			<table id="Info" class="table">
				<tbody id="Tbody">
					
				</tbody>
			</table>
	</div>
	<div id="maincontents" class="main">
		<form id="comInfo">
			<br>
			<table>
				<tbody>
				    <tr><th><div class='input-group'><span class='input-group-addon'>거래처코드</span>
                <input type='text' name='cl_code' class='form-control'></div></th>
				<th><div class='input-group'><span class='input-group-addon'>거래처명</span>
                <input type='text' name='cl_name' class='form-control'></div></th>
					</tr>
					<tr>
				<th><div class='input-group'><span class='input-group-addon'>사업자번호</span>
                <input type='text' name='cl_comnum' class='form-control'></div></th>
				<th><div class='input-group'><span class='input-group-addon'>대표자명</span>
                <input type='text' name='cl_ceo' class='form-control'></div></th>
					</tr>
					<tr>
				<th><div class='input-group'><span class='input-group-addon'>&nbsp;담당자명&nbsp;</span>
                <input type='text' name='cl_employee' class='form-control'></div></th>
				<th><div class='input-group'><span class='input-group-addon'>전화번호</span>
                <input type='text' name='cl_phone' class='form-control'></div></th>
					</tr>
					<tr>
				<th><div class='input-group'><span class='input-group-addon'>핸드폰번호</span>
                <input type='text' name='cl_phone2' class='form-control'></div></th>
				<th><div class='input-group'><span class='input-group-addon'>팩스번호</span>
                <input type='text' name='cl_fax' class='form-control'></div></th>
					</tr>
					<tr>
				<th><div class='input-group'><span class='input-group-addon'>&nbsp;&nbsp;이메일&nbsp;&nbsp;</span>
                <input type='text' name='cl_email' class='form-control'></div></th>
                <th><div class='input-group'><span class='input-group-addon'>&nbsp;&nbsp;유형&nbsp;&nbsp;</span>
                <select name='cl_kind3' class='form-control'>
                <option value="">--</option>
				<option value="매출">매출</option>
				<option value="매입">매입</option>
                </select></div></th>
					</tr>
					<tr>
				<th><div class='input-group'><span class='input-group-addon'>&nbsp;우편번호&nbsp;</span>
                <input type='text' name='cl_addrnum' class='form-control'></div></th>
					</tr>


					<tr>
				<th colspan="2"><div class='input-group'><span class='input-group-addon'>&nbsp;&nbsp;&nbsp;주소&nbsp;&nbsp;&nbsp;</span>
                <input type='text' name='cl_addr' class='form-control' style="width:540px;"></div></th>
					</tr>
					<tr>
				<th><div class='input-group'><span class='input-group-addon'>&nbsp;&nbsp;&nbsp;업태&nbsp;&nbsp;&nbsp;</span>
                <input type='text' name='cl_kind' class='form-control' style="width:230px;"></div></th>
				<th><div class='input-group'><span class='input-group-addon'>&nbsp;&nbsp;종목&nbsp;&nbsp;</span>
                <input type='text' name='cl_kind2' class='form-control'></div></th>
					</tr>
					<tr>
				<th><div class='input-group'><span class='input-group-addon'>&nbsp;거래은행&nbsp;</span>
                <input type='text' name='cl_bank' class='form-control'></div></th>
				<th><div class='input-group'><span class='input-group-addon'>&nbsp;예금주&nbsp;</span>
                <input type='text' name='cl_bankholder' class='form-control'></div></th>
					</tr>
					<tr>
				<th><div class='input-group'><span class='input-group-addon'>&nbsp;계좌번호&nbsp;</span>
                <input type='text' name='cl_banknum' class='form-control'></div></th>
				<th><div class='input-group'><span class='input-group-addon'>종사업장번호</span>
                <input type='text' name='cl_comnum2' class='form-control' style="width:200px;"></div></th>
					</tr>
					<tr>
					</tr>

					<tr>
				<th colspan="2"><div class='input-group'><span class='input-group-addon'>&nbsp;&nbsp;&nbsp;메모&nbsp;&nbsp;&nbsp;</span>
                <textarea name='cl_memo' rows="3" cols="" class='form-control' style="width:539px;"></textarea></div></th>
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
			url : '/erp/rest/sales/searchcomlist',
			type : 'get',
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success : function(data) {
				console.log(data);
				var List="";
				List+="<tr><th class='allinfo'>체크</th><th class='allinfo'>코드</th><th class='allinfo'>거래처명</th><th class='allinfo'>사업자(주민)번호</th><th class='allinfo'>대표자명</th><th class='allinfo'>업태</th><th class='allinfo'>유형</th></tr>";
				for ( var i in data.aList) {
					List+="<tr class='success'>";
					List+="<td class='allinfo'><input type='checkbox' name='reportChkBxRow' value="+data.aList[i].cl_code+"></td>";
					List+="<td class='allinfo'>" + data.aList[i].cl_code + "</td>";
					List+="<td class='allinfo'>" + data.aList[i].cl_name + "</td>";
					List+="<td class='allinfo'>" + data.aList[i].cl_comnum + "</td>";
				    List+="<td class='allinfo'>" + data.aList[i].cl_ceo + "</td>";
					List+="<td class='allinfo'>" + data.aList[i].cl_kind + "</td>";
					List+="<td class='allinfo'>" + data.aList[i].cl_kind3 + "</td>";
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
		var code = $("#code").val();
		console.log(code);
						$.ajax({
									url : '/erp/rest/sales/searchcode',
									type : 'post',
									data : {code:code},
									dataType : 'json',
									success : function(data) {
									
										console.log(data);
										var List="";
										List+="<tr><th class='allinfo'>체크</th><th class='allinfo'>코드</th><th class='allinfo'>거래처명</th><th class='allinfo'>사업자(주민)번호</th><th class='allinfo'>대표자명</th><th class='allinfo'>업태</th><th class='allinfo'>유형</th></tr>";
										for ( var i in data.aList) {
											List+="<tr class='success'>";
											List+="<td class='allinfo'><input type='checkbox' name='reportChkBxRow' value="+data.aList[i].cl_code+"></td>";
											List+="<td class='allinfo'>" + data.aList[i].cl_code + "</td>";
											List+="<td class='allinfo'>" + data.aList[i].cl_name + "</td>";
											List+="<td class='allinfo'>" + data.aList[i].cl_comnum + "</td>";
										    List+="<td class='allinfo'>" + data.aList[i].cl_ceo + "</td>";
											List+="<td class='allinfo'>" + data.aList[i].cl_kind + "</td>";
											List+="<td class='allinfo'>" + data.aList[i].cl_kind3 + "</td>";
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
						var obj = $("#comInfo").serialize();
						//var json = JSON.stringify(obj);
						//console.log(json)
						$.ajax({
									url : '/erp/rest/sales/insertcomlist',
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
											List+="<td><input  type='checkbox' name='reportChkBxRow' value="+data.aList[i].cl_code+"></td>";
											List+="<td>" + data.aList[i].cl_code + "</td>";
											List+="<td>" + data.aList[i].cl_name + "</td>";
											List+="<td>" + data.aList[i].cl_comnum + "</td>";
										    List+="<td>" + data.aList[i].cl_ceo + "</td>";
											List+="<td>" + data.aList[i].cl_kind + "</td>";
											List+="<td>" + data.aList[i].cl_kind3 + "</td>";
											List+="</tr>";
										}
						                 $("#Tbody").html(List);
						                 $("input").val("");
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
	     			url:'/erp/rest/sales/deleteCom',
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
							List+="<td><input  type='checkbox' name='reportChkBxRow' value="+data.aList[i].cl_code+"></td>";
							List+="<td>" + data.aList[i].cl_code + "</td>";
							List+="<td>" + data.aList[i].cl_name + "</td>";
							List+="<td>" + data.aList[i].cl_comnum + "</td>";
						    List+="<td>" + data.aList[i].cl_ceo + "</td>";
							List+="<td>" + data.aList[i].cl_kind + "</td>";
							List+="<td>" + data.aList[i].cl_kind3 + "</td>";
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
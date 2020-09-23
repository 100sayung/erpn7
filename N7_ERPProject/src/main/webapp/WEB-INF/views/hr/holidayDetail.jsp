<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="holidayDetail"></div>

	<table>
		<tr>
			<td>${apholi.hap_docunum }</td>
			<td>${apholi.hap_docuname }</td>
		</tr>
		<tr>
			<td>신청인</td>
			<td>${apholi.hap_fromapprover }</td>
			<td>결재자</td>
			<td>${apholi.hap_toapprover }</td>
		</tr>
		<tr>
			<td>휴가시작일</td>
			<td>휴가종료일</td>
			<td>결재상태</td>
			<td>신청일</td>
		</tr>
		<tr>
			<td>${apholi.hap_startday }</td>
			<td>${apholi.hap_endday }</td>
			<td>${apholi.hap_status }</td>
			<td>${apholi.hap_applydate }</td>
		</tr>
		<tr>
			<td>${apholi.hap_reason }</td>
	</table>
	
	-- 이 아래는 toApprover만 볼수있음-- 
		<input type='hidden' value='${apholi.hap_docunum }' name='docunum' id="docunum">
		<button id="ok">승인</button> &nbsp;
		<button id='no'>거부</button>
	

	<script>
		$(document).ready(function(){
			console.log("123");
			console.log("${apholi.hap_fromapprover}");
		});
		
		$("button").click(function(){
			console.log(this.id);
			if(confirm("정말 등록하시겠습니까?")){
				regist(this.id);
			}else{
				alert("알겠습니다")
			}
		});
		
		function regist(yesno){
			$.ajax({
				url:"/erp/rest/hr/holidaystatus",
				dataType:"text",
				data:{yesno : yesno, docunum : $("#docunum").val()},
				method:"post",
				success : function(data){			
					window.open("about:blank", "_self").close();
				}, error : function(err){
					console.log(err);
				}
			});
			
		}
	</script>
</body>
</html>

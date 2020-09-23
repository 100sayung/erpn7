<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
table, tr, td {
	border: 1px solid black;
	text-align: center;
}

td {
	padding: 5px;
	font-size: large;
	width: 58px;
	height: 10px;
}
</style>
</head>
<body>
	<!-- 	<h1>acPend.jsp(임시저장)</h1> -->
	<table id="table">
		<tr id="m">
			<td>check</td>
			<td>문서번호</td>
			<td>회사코드</td>
			<td>결재문서이름</td>
			<td>결재올린사람</td>
			<td>결재받는사람</td>
			<td>올린시간</td>
			<td>결재상태</td>
		</tr>
	</table>
	<div id="Info"></div>
	<br>
	<button id="approval">결재안 상세보기</button>
</body>
<script>
	$.ajax({
				type : 'get',
				url : '/erp/rest/Account/acPendList',
				dataType : 'json',
	 			contentType : 'application/json; charset=UTF-8',
				success : function(data) {
					console.log(data);
					var str = "";
					for ( var i in data.pList) {
						str += "<tr>"
						str += "<td><input type='radio' name='checknum' class='check' value='"+data.pList[i].ap_docunum+"'></td>"
						str += '<td>' + data.pList[i].ap_docunum + '</td>'
						str += '<td>' + data.pList[i].ap_ccode + '</td>'
						str += '<td>' + data.pList[i].ap_docuname + '</td>'
						str += '<td>' + data.pList[i].ap_fromapprover + '</td>'
						str += '<td>' + data.pList[i].ap_toapprover + '</td>'
						str += '<td>' + data.pList[i].ap_date + '</td>'
						str += '<td>' + data.pList[i].ap_status + '</td>'
						str += '</tr>'
					}
					$("#Info").html(str);
				},
				error : function(err) {
					console.log(err);
				}
			});

	$("#approval").click(
			function() {
				var check = '';
				$("input[name='checknum']:checked").each(
						function() {
							check = $(this).attr('value');

							window.open(
									'/erp/rest/Account/acRequest?j_docunum='
											+ check, 'acRequest',
									'width=1500, height=600');
						});
			});
</script>
</html>






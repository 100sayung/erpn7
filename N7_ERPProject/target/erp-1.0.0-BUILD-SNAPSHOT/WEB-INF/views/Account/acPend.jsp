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
	<table>
		<tr id="m">
			<td>check</td>
			<td>문서번호</td>
			<td>결재상태</td>
			<td>문서제목</td>
			<td>계정과목</td>
			<td>비용구분</td>
			<td>차변금액</td>
			<td>대변금액</td>
			<td>귀속부서</td>
			<td>활동센터</td>
			<td>관계회사</td>
		</tr>
	</table>
	<div id="Info"></div>
	<br>
	<button id="approval">결재안 상세보기</button>
	<button id="acDelete2">삭제요청</button>
	<input type="hidden" value="${msg}">
	<!-- 	<button id="acBack2">반려요청</button> -->
	<!-- 	<button id="acDelete">삭제</button> -->
</body>
<script>
	$
			.ajax({
				type : 'get',
				url : '/erp/rest/Account/acPendList',
				dataType : 'json',
				success : function(data) {
					console.log(data);
					var str = "";
					for ( var i in data.aList) {
						str += "<tr>"
						str += "<td><input type='radio' name='checknum' class='check' value='"+data.aList[i].j_docunum+"'></td>"
						str += '<td>' + data.aList[i].j_docunum + '</td>'
						str += '<td>' + data.aList[i].j_grade + '</td>'
						str += '<td>' + data.aList[i].j_title + '</td>'
						str += '<td>' + data.aList[i].j_account + '</td>'
						str += '<td>' + data.aList[i].j_group + '</td>'
						str += '<td>' + data.aList[i].j_debit + '</td>'
						str += '<td>' + data.aList[i].j_credit + '</td>'
						str += '<td>' + data.aList[i].j_section + '</td>'
						str += '<td>' + data.aList[i].j_centre + '</td>'
						str += '<td>' + data.aList[i].j_company + '</td>'
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

	$("#acDelete2").click(function() {

		var check = '';
		$("input[name='checknum']:checked").each(function() {
			check = $(this).attr('value');

			$.ajax({
				url : '/erp/rest/Account/acDelete?j_docunum=' + check,
				type : 'post',
				success : function(data) {
					if(data == 1){
					alert("결재안 삭제가 완료되었습니다.");
					window.location.reload();
					console.log(data);
					}else{
						alert("결재안 삭제를 실패했습니다.");
// 						window.location.reload();
						console.log(data);
					}
				},
				error : function(error) {
					alert("결재안 삭제를 실패했습니다.")
					console.log(error);
				}
			});
		});

	});
</script>
</html>






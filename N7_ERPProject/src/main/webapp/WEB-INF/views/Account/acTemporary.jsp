<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- BOOTSTRAP STYLES-->
<link href="/erp/assets/css/bootstrap.css" rel="stylesheet">
<!-- FONTAWESOME STYLES-->
<link href="/erp/assets/css/font-awesome.css" rel="stylesheet">
<!-- CUSTOM STYLES-->
<link href="/erp/assets/css/custom.css" rel="stylesheet">
<!-- GOOGLE FONTS-->
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="/erp/assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="/erp/assets/js/bootstrap.min.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="/erp/assets/js/custom.js"></script>
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

#table {
	width: 1400px;
	height: auto;
}

#m {
	background-color: gray;
}
</style>
</head>
<body>
	<!-- 	<h1>acPend.jsp(임시저장)</h1> -->
	<table id="table">
		<tr id="m">
			<td>check</td>
			<td>문서번호</td>
			<td>문서제목</td>
			<td>계정과목</td>
			<td>비용구분</td>
			<td>차변금액</td>
			<td>대변금액</td>
			<td>귀속부서</td>
			<td>활동센터</td>
			<td>관계회사</td>
			<td>결재상태</td>
		</tr>
		<tbody id="Info">
		</tbody>
	</table>
	<br>
	<button id="approval">결재안 상세보기</button>
</body>
<script>
	$(document).ready(
					function() {

						$.ajax({
									type : 'get',
									url : '/erp/rest/Account/acTemporaryList',
									dataType : 'json',
									success : function(data) {
										console.log(data);
										var str = "";
										for ( var i in data.aList) {
											str += "<tr>"
											str += "<td><input type='radio' name='checknum' class='check' value='"+data.aList[i].j_docunum+"'></td>"
											str += '<td>'
													+ data.aList[i].j_docunum
													+ '</td>'
											str += '<td>'
													+ data.aList[i].j_title
													+ '</td>'
											str += '<td>'
													+ data.aList[i].j_account
													+ '</td>'
											str += '<td>'
													+ data.aList[i].j_group
													+ '</td>'
											str += '<td>'
													+ data.aList[i].j_debit
													+ '</td>'
											str += '<td>'
													+ data.aList[i].j_credit
													+ '</td>'
											str += '<td>'
													+ data.aList[i].j_section
													+ '</td>'
											str += '<td>'
													+ data.aList[i].j_centre
													+ '</td>'
											str += '<td>'
													+ data.aList[i].j_company
													+ '</td>'
											str += '<td>'
													+ data.aList[i].j_grade
													+ '</td>'
											str += '</tr>'
										}
										$("#Info").html(str);
									},
									error : function(err) {
										console.log(err);
									}
								});
					});

	$("#approval").click(
			function() {
				var check = '';
				$("input[name='checknum']:checked").each(
						function() {
							check = $(this).attr('value');

							window.open(
									'/erp/rest/Account/acRequest3?j_docunum='
											+ check, 'acRequest',
									'width=1500, height=600');
						});
			});
</script>
</html>






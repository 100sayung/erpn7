<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
		<tbody id="Info"></tbody>
	</table>
	<br>
	<br>
	<button id="approvaldetail">결재안 상세보기</button>
</body>
<script>
	$("#approvaldetail").click(
			function() {
				var check = '';
				$("input[name='checknum']:checked").each(
						function() {
							check = $(this).attr('value');

							window.open(
									'/erp/rest/sales/appRequest?bs_docunum='
											+ check, 'appRequest',
									'width=1500, height=600');
						});
			});
</script>
</html>
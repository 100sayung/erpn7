<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
html, body {
	text-align: center;
}

table, tr, th, td {
	border: 1px solid silver;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	width: auto;
	height: auto;
}

/* input{ */
/* 	border: 1px white; */
/* 	text-align: left; */
/* } */

 .txt { 
 	width: 200px;
	height: 20px;
	border-style: none;
	text-align: center;
 	
} 

.select {
	width: 150px;
	height: 25px;
}

.draft {
	width: 500px;
	height: 20px;
	border-style: none;
	text-align: center;
	"
}

.draft2 {
	width: 600px;
	text-align: center;
}

.draft3 {
	width: 230px;
	border-style: none;
	text-align: center;
}

#j_sumup {
	height: 300px;
	width: 950px;
}

td {
	font-size: large;
}

input {
/* 	width: 80px; */
/* 	height: 40px; */
	font-size: large;
	
}

#su {
	text-align: center;
}

</style>

</head>
<body>
	<form id="form1">
	<div
			style="width: auto; background-color: #FFB2D9; color: white; padding: 1%;">분개전표 작성
			</div>
	<div class="mainform" style="height: auto; padding-top: 5px; background-color: #F8F7F7;">
		<table>
				<tr>
					<th>제목</th>
					<th><input type="text" id="j_title" name="j_title" style="background-color:#F8F7F7; border: 1px #F8F7F7; width: 1020px; text-align: center;" placeholder="분개전표 제목을 입력해주세요." ></th>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<div style="border: 1px solid #EAEAEA; background-color: white;">
							<div>
								<table>
									<tr>
										<th colspan="2">계정과목</th>
										<th colspan="2">
										<input type="text" id="j_account" name="j_account" class="txt" style="width: 400px;">
										</th>
										<th colspan="2">문서번호</th>
										<td colspan="2"  style="width: 400px;">문서번호는 자동으로 입력됩니다.</td>
										<!-- 										<td>결재상태</td> -->

									</tr>
									<tr>
										<th colspan="2">활동센터</th>
										<th colspan="2">
										<input type="text" id="j_centre" name="j_centre" class="txt" style="width: 400px;">
										</th>
										<th colspan="2">귀속부서</th>
										<th colspan="2">
										<input type="text" id="j_section" name="j_section" class="txt" style="width: 400px;">
										</th>
									</tr>
									<tr>
										<th colspan="2">비용구분</th>
										<td colspan="2">
										<input type="text" id="j_group" name="j_group" class="draft3"style="width: 400px;">
										</td>
										<th colspan="2">관계회사</th>
										<td colspan="2">
										<input type="text" id="j_company" name="j_company" class="draft3" style="width: 400px;">
										</td>

									</tr>
									<tr>
										<th colspan="2">차변금액</th>
										<td colspan="5">
										<input type="text" id="j_debit" name="j_debit" class="draft"style="width: 900px;">
										</td>
									</tr>
									<tr>
										<th colspan="2">대변금액</th>
										<td colspan="5">
										<input type="text" id="j_credit" name="j_credit" class="draft" style="width: 900px;">
										</td>
									</tr>
									<tr>
										<th>적요</th>
										<th colspan="8">
										<input type="text" id="j_sumup" name="j_sumup">
										</th>
									</tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<button type="button" id="su">등록</button>
	</form>
</body>
<script>
	$('#su').click(
			function() {
				var title = document.getElementById('j_title');
				var account = document.getElementById('j_account');
				var group = document.getElementById('j_group');
				var debit = document.getElementById('j_debit');
				var credit = document.getElementById('j_credit');
				var sumup = document.getElementById('j_sumup');
				var section = document.getElementById('j_section');
				var centre = document.getElementById('j_centre');
				var company = document.getElementById('j_company');
				
				if (title.value == '' || title.value == null
						&& account.value == '' || account.value == null
						&& group.value == '' || group.value == null
						&& debit.value == '' || debit.value == null
						&& credit.value == '' || credit.value == null
						&& sumup.value == '' || sumup.value == null
						&& section.value == '' || section.value == null
						&& centre.value == '' || centre.value == null
						&& company.value == '' || company.value == null){
					alert("전부 입력해주세요");
				} else if (title.value == '' || title.value == null) {
					alert("문서제목을 입력해주세요");
				} else if (account.value == '' || account.value == null) {
					alert("계정과목을 입력해주세요");
				} else if (centre.value == '' || centre.value == null) {
					alert("활동센터를 입력해주세요");
				} else if (section.value == '' || section.value == null) {
					alert("귀속부서를 입력해주세요");
				} else if (group.value == '' || group.value == null) {
					alert("비용구분을 입력해주세요");
				} else if (company.value == '' || company.value == null) {
					alert("관계회사를 입력해주세요");
				} else if (debit.value == '' || debit.value == null) {
					alert("차변금액을 입력해주세요");
				} else if (credit.value == '' || credit.value == null) {
					alert("대변금액을 입력해주세요");
				} else if (sumup.value == '' || sumup.value == null) {
					alert("적요를 입력해주세요");
				} else {

					var obj = $("#form1").serialize();
					console.log(obj);

					$.ajax({
						url : '/erp/rest/Account/actempoInsert',
						type : 'post',
						data : obj,
						dateType : "json",
						success : function(data) {
							if (data == 1) {
								console.log(data);
								$("#form1")[0].reset();
								alert("결재안 임시저장을 완료하였습니다.");
							} else {
								alert("결재안 임시저장이 실패하였습니다.");
								console.log(data);
							}
						},
						error : function(error) {
							console.log(error);
							alert("야 오류얌");
						}

					})
				}
			});
</script>
</html>
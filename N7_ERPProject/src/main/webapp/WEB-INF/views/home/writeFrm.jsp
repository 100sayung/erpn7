<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#writeFrm{
	margin-left:500px; 
}
#writeTitle{
	width: 500px;
}
.writeclass{
	width: 20px;
	height: 15px;
}
.writeText{
	padding: 10px;
}
</style>
</head>
<body>
	<form action="writeBoard" id="writeFrm" method="post">
		<h1>글쓰기</h1>
		<table>
			<tr>
				<td><input id="CBID" placeholder="아이디를 입력해 주세요." required="required" class="writeText" name="CB_ID">
				<input placeholder="비밀번호를 입력해주세요" required="required" class="writeText" name="CB_PW">
				<input type="checkbox" class="writeclass" id="writecheck" checked="checked" name="CB_ONOFF" value="a">공개글
				<input type="checkbox" class="writeclass" name="CB_ONOFF" value="b">비밀글</td>
			</tr>
			<tr>
				<td><input id="writeTitle" placeholder="제목을 입력해 주세요." required="required" class="writeText" name="CB_TITLE"></td>
			</tr>
			<tr>
				<td><textarea rows="20" cols="100" required="required" name="CB_CONTENT">				
				</textarea>
				</td>
			</tr>
			<tr>
				<td><button type="submit">글 작성</button>
					<button type="reset">리셋</button>
					<a href="erpboard">게시판으로 돌아가기</a>
				</td>
			</tr>
		</table>
	</form>
</body>
<script>

</script>
</html>
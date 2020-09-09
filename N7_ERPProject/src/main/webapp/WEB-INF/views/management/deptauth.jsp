<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>다ㅣ른 레이아웃 적용</h1>





<script>

//부서 전체목록 출력
$.ajax({
	url:"/erp/rest/hr/deptlist",
	method:"get",
	dataType:"json",
	success : function(data){
		console.log(data);
	}, error : function(err){
		console.log(err);
	}
});
</script>

</body>
</html>
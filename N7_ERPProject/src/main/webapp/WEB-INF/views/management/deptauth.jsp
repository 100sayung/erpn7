

\'
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

한번에 확인누를거 or 아니면 등급별로 출력해서 등급바꿀떄마다 거기서 사라지게 만들기


<form action = "/erp/management/updateDeptAuth" method="post">
<div id = "container" >

</div>
<button>변경완료</button>
</form>

이거 왜 세번째부터 입력이안되냐 새로해야함 

<script>

//부서 전체목록 출력
$.ajax({
	url:"/erp/rest/hr/deptauthlist",
	method:"get",
	dataType:"json",
	success : function(data){
		console.log(data);
		let str = "";
		for(let i = 0 ; i<data.length ; i++){
			str += "<input type='text' name ='HDP_dept' value = '" + data[i].HDP_dept + "' readonly>";
			str += "<input type='text' name='HDP_position' value = '" + data[i].HDP_position + "' readonly>";
			str += "<input type='hidden' name='HDP_num' value='"+data[i].HDP_num+"'>";
			str+="<select name='hdp_auth'>";
			if(data[i].hdp_auth == 1){
				str+="<option value = '1' selected = 'selected'> 1 </option>";
				str+="<option value = '2'> 2 </option>";
				str+="<option value = '3'> 3 </option>";
			}else if(data[i].hdp_auth == 2){
				str+="<option value = '1'> 1 </option>";
				str+="<option value = '2' selected = 'selected'> 2 </option>";
				str+="<option value = '3'> 3 </option>";
			}else if(data[i].hdp_auth == 3){
				str+="<option value = '1'> 1 </option>";
				str+="<option value = '2'> 2 </option>";
				str+="<option value = '3' selected = 'selected'> 3 </option>";
			}else{
				str+="<option value = '1'> 1 </option>";
				str+="<option value = '2'> 2 </option>";
				str+="<option value = '3'> 3 </option>";
			}
			str += "</selected><br><br>";
		}
		$("#container").html(str);
	}, error : function(err){
		console.log(err);
	}
});
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html,body{
text-align: center;
}
table,th,td{
border: 1px solid silver; 
}
</style>
</head>
<body>
<table>
	<tr>
		<th></th>
		<th>문서번호</th>
		<th>회사코드</th>
		<th>결재제목</th>
		<th>상신자</th>
		<th>결재자</th>
		<th>올린시간</th>
		<th>상태코드</th>
	</tr>
	<tbody id="tboay"></tbody>
</table>
<div><button id="Info">결재상세보기</button></div>

<script type="text/javascript">
$(function(){
	var aList=${aList};
	var str="";
	for(var i=0; i<aList.length; i++){
		str+="<tr><td><input type='radio' name='checknum' value="+aList.ap_ap_docunum+"></td>";
		str+="<td>"+aList[i].ap_docunum+"</td>";
		str+="<td>"+aList[i].ap_ccode+"</td>";
		str+="<td>"+aList[i].ap_docuname+"</td>";
		str+="<td>"+aList[i].ap_fromapprover+"</td>";
		str+="<td>"+aList[i].ap_toapprover+"</td>";
		str+="<td>"+aList[i].ap_date+"</td>";
		str+="<td>"+aList[i].ap_status+"</td><tr>";
	}
	$("#tboay").append(str);
	console.log(aList);
})
/* 
	$('#Info').click(function(){
		var check= "";
		$("input[name='checknum']:checked").each(
			widow.open("/erp/rest/Purchase/psRequest?p_documentcode="+check, 'psRequest', 'width=1500, height=600');
		)
	}) */



</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="/erp/css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<style>
#header {
	width: 100%;
	height: 200px;
}

#side_menu {
	height: 100%;
	width: 250px;
	font-size: 20px;
	font-weight: bolder;
	float: left;
	border-right:1px solid #E6E6E6;
}

#side_menu #menuList {
	list-style: none;
	margin-top: 150px;
}

#side_menu #menuList li {
	margin: 20px;
}

a {
	text-decoration: none;
}

#description {
	float: left;
	height: 100%;
	width: 800px;
}

ul {
	list-style: none;
}
</style>
</head>
<body>
	<div id="header">
		<div id="logo">
			<h1>
				<a href="#">N7 ERP SYSTEM</a>
			</h1>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="/myInfo/myInfo" accesskey="4" title="">내 정보</a></li>
				<li><a href="/erp/hr/hr" accesskey="2"
					title="">인사 관리</a></li>
				<li><a href="#" accesskey="3" title="">영업 관리</a></li>
				<li><a href="#" accesskey="5" title="">구매 관리</a></li>
				<li><a href="#" accesskey="6" title="">자재 관리</a></li>
				<li><a href="#">회계 관리</a></li>
			</ul>
		</div>
	</div>
	<div id="side_menu">
		<ul id="menuList">
			<li><a href="/erp/myinfo/checkattendance">출/퇴근 등록</a></li>
			<li><a href="/erp/myinfo/myinfo">내 정보 보기</a></li>
			<li><a href="/erp/myinfo/myPaycheck">급여명세서 보기</a></li>
			<li><a href="#">내 출결 보기</a></li>
			<li><a href="#">내 휴가 보기</a></li>
			<li><a href="#">휴가신청</a></li>
			<li><a href="#">나의결재함</a></li>
		</ul>
	</div>
	<h1> 급여 명세서 보기 </h1>
	<table style="border: 1px solid black; width: 800px; height: 100px;">
		<tr>
			<td>사원코드 : </td>
			<td>${paycheck.hc_hrcode}</td>
			<td>이름 : </td>
			<td>${paycheck.m_name}</td>
			<td>입사일 : </td>
			<td>${paycheck.hc_joindate}</td>
		</tr>
		<tr>
			<td>부서 : </td>
			<td>${paycheck.hc_position}</td>
			<td>직급</td>
			<td>${paycheck.hc_dept}</td>
			<td>급여일</td>
			<td><input type="month" id="month" name="month"></td>
		</tr>
	</table>	
	<div id="paycheckpage">
		
	</div>
	<script>
		$("#month").change(function(){
			var month=$("#month").val();
			console.log(month);
			
			$.ajax({
				url:"/erp/myinfo/paycheckselect",
				method:'POST',
				data:{month : month},
				dataType:'JSON',
				success:function(data){
					if(data!="1"){
					console.log(data);
					var provide=Number(data.HDP_PAY)+Number(data.HP_INCEN);
					var ince=Number(data.HP_INSURANCE)+Number(data.HP_TAX);
					var receive=provide-ince;
					var str='';
						str+="<table style='border:1px solid black;width:800px;height:300px;'><tr>"
							+"<td>지급내역<td>"
							+"<td>지급액<td>"
							+"<td>공제내역<td>"
							+"<td>공제액<td></tr>"
							+"<tr><td>기본급<td>"
							+"<td>"+data.HDP_PAY+"<td>"
							+"<td>보험<td>"
							+"<td>"+data.HP_INSURANCE+"<td></tr>"
							+"<tr><td>인센티브<td>"
							+"<td>"+data.HP_INCEN+"<td>"
							+"<td>소득세<td>"
							+"<td>"+data.HP_TAX+"<td></tr>"
							+"<tr><td><td>"
							+"<td><td>"
							+"<td>공제액계<td>"
							+"<td>"+ince+"<td></tr>"
							+"<tr><td>급여 계<td>"
							+"<td>"+provide+"<td>"
							+"<td>실지급액<td>"
							+"<td>"+receive+"<td></tr>"
					$("#paycheckpage").html(str);
					}else if(data=="1"){
						$("#paycheckpage").html("<h1>선택한 날짜에는 받은 급여가 없습니다.</h1>");
					}
				},
				errorr:function(err){
					console.log(err);
					alert('이 달에 받은 급여가 없네요');
				}
			});
		});	
	</script>
</body>
</html>
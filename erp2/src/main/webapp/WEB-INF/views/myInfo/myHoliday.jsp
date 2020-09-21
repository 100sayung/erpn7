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
.attendance{
	border: 1px solid black;
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
				<li class="current_page_item"><a href="/erp/myInfo/myInfo" accesskey="4" title="">내 정보</a></li>
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
			<li><a href="/erp/myinfo/myPaycheck">급여명세서 보기</li>
			<li><a href="/erp/myinfo/myattendance">내 출결 보기</a></li>
			<li><a href="/erp/myinfo/myholiday">내 휴가 보기</a></li>
			<li><a href="/erp/myinfo/applyholiday">휴가신청</a></li>
			<li><a href="/erp/myinfo/mydocument">나의 결재함</a></li>
		</ul>
	</div>
	<div id="description"> 내 휴가 보기</div>
	<script>

	$(document).ready(function() {
		$.ajax({
			url : "/erp/rest/myinfo/myholiday",
			dataType : "json",
			method : "get",
			success : function(data){
				console.log(data);
			}, error : function(err){
				console.log(err);
			}
		});
	});
	function detail(docunum){
		console.log(docunum);

		$.ajax({
			url:"/erp/rest/hr/detailholiday",
			data:{docunum : docunum},
			dataType:"json",
			method:"get",
			success : function(data){
				console.log(data);
				let str = ""
				str += data.hap_docuname + "<br>";
				str += data.hap_startday + "부터 " +data.hap_endday + "까지 <br>";
				str += data.hap_status + "(0:대기 1:승인 2:반려)<br>";
				str += data.hap_reason + "<br>";
				str += data.hap_toapprover + "에게 " + data.hap_fromapprover + " 보냄<br>";
				str += data.hap_applydate + "(신청일) " + data.hap_type + "(타입)";
				$("#detail").html(str);
			}, error : function(err){
				console.log(err);
			}
		});

	}
	</script>
</body>
</html>

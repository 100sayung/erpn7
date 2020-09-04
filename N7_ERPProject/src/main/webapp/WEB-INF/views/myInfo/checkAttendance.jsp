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
				<li class="current_page_item"><a href="/myInfo/myInfo" accesskey="4" title="">내 정보</a></li>
				<li><a href="/hr/hr" accesskey="2"
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
			<li><a href="/erp/myinfo/myinfo">내 정보 보기</li>
			<li><a href="#">급여명세서 보기</li>
			<li><a href="#">내 출결 보기</li>
			<li><a href="#">내 휴가 보기</li>
			<li><a href="#">휴가신청</a></li>
			<li><a href="#">나의결재함</a></li>
		</ul>
	</div>
	<div id="description">
	
	<h1 align="center">오늘 날짜 현재 시각</h1>
	<div id="currentStatus"></div>
	<br>
	<span id="in" class="attendance"> 출근 등록 </span>
	<span id="out" class="attendance"> 퇴근 등록 </span>
	</div>
	


<script>
	var status = "";
	var load = function(){
		$.ajax({
			url:"/erp/rest/hr/currentattendance",
			dataType:"json",
			method:"get",
			success : function(status){
				console.log(status);
				if(data == 1){
					status = "근무중";
				}else{
					status = "퇴근중";
				}
				$("#currentStatus").html(status);
			}, error : function(err){
				console.log(err);
			}
		});
	};
	load();
	$(".attendance").click(function(){
		console.log(this.id);
		$.ajax({
			url:"/erp/rest/hr/attendance",
			data:{status : this.id},
			dataType:"json",
			method:"post",
			success: function(data){
				console.log(data);
				if(data == 1){
					alert("출근 등록 되었습니다.");
					status = "근무중";
				}else{
					alert("퇴근 등록 되었습니다.");
					status = "퇴근중";
				}
				$("#currentStatus").html(status);
			}, error : function(err){
				console.log(err);
			}
		});
	});
	
	
</script>
</body>
</html>
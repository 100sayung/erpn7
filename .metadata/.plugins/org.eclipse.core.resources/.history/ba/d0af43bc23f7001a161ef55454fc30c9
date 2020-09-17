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
			<li><a href="/erp/myinfo/myinfo">내 정보 보기</li>
			<li><a href="#">급여명세서 보기</li>
			<li><a href="/erp/myinfo/myattendance">내 출결 보기</li>
			<li><a href="/erp/myinfo/myholiday">내 휴가 보기</li>
			<li><a href="/erp/myinfo/applyholiday">휴가신청</a></li>
			<li><a href="/erp/myinfo/mydocument">나의 결재함</a></li>
		</ul>
	</div>
	<div id="description"> 휴가신청폼<br>
	
	<form action="/erp/hr/applyholiday" method="post">
	<input type="text" name="hap_docuname" placeholder="문서 제목을 입력해주세요 글자제한 20자" required="required">
	<input type="text" name="hap_type" placeholder="휴가 종류를 입력해주세요 글자제한 20자" required="required">
	<br>
	<input type="date" name="hap_startday" required="required">
	<span id="myleader"></span>
	<input type="date" name="hap_endday" required="required">
	<br>
	<textarea rows="10" cols="10" name="hap_reason"></textarea>
	<input type="submit" value="제출">
	</form>
	
	
	
	</div>
	<script>
	$(document).ready(function() {
		$.ajax({
			url : "/erp/rest/hr/myleaderlist",
			dataType : "json",
			method : "get",
			success : function(data){
				console.log(data);
				var str = "<td><select name='hap_toapprover'>";
				for(let i = 0 ; i<data.length ; i++){
					str += "<option value='"+data[i].hc_hrcode+"' selected='selected'>"+data[i].m_name+"("+data[i].hc_position+")</option>";
					}
				str += "</select>"
				$("#myleader").html(str);
			}, error : function(err){
				console.log(err);
			}
		});
	});
	
	</script>
</body>
</html>
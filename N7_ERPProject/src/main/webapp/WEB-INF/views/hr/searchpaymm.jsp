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
				<li><a href="/erp/myinfo/myinfo" accesskey="4" title="">내 정보</a></li>
				<li class="current_page_item"><a href="/erp/hr/hr" accesskey="2"
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
			<li id="showMenu1">인사 관리
				<ul id="smallMenu1" style="display: none;">
					<li><a href="/erp/hr/deptregistpage">부서등록</a></li>
					<li><a href="/erp/hr/movehrcardpage">인사카드</a></li>
				</ul>
			</li>

			<li id="showMenu2">근태 관리
				<ul id="smallMenu2" style="display: none;">
					<li><a href="">휴가 접수</a></li>
					<li><a href="">사원 출결 관리</a></li>
					<li><a href="">근무 조회</a></li>
					<li><a href="">휴/퇴직 관리</a></li>
				</ul>
			</li>
			<li id="showMenu3">급여 관리
				<ul id="smallMenu3" style="display: none;">
					<li><a href="/erp/hr/deptpay">부서/직급별 급여</a></li>
					<li><a href="/erp/hr/deduct">공제사항 관리</a></li>
					<li><a href="/erp/hr/searchpaymm">급여 관리</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<h1>급여 관리 페이지</h1>
	<table id="wages" style="text-align: center; width: 800px;">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>부서</td>
			<td>직책</td>
			<td>급여</td>
			<td>기본공제액</td>
			<td>기본수령액</td>
		</tr>
	</table>
	<script>
	//사원들 급여 조회
	
	$(function(){
	$.ajax({
		url:"/erp/hr/searchwages",
		method:'POST',
		dataType:'JSON',
		success:function(data){
			console.log(data);
			console.log(data.hc_id);
			console.log(data.length);
			var str='';
			var da=data.toString();
			for(var i=0;i<data.length;i++){
				var result=data[i].HDP_PAY-data[i].HDD_AMOUNT;
				str+="<tr id='\""+data[i].HC_ID+"\"'><td>"+data[i].HC_ID+"</td>"
					+"<td>"+data[i].M_NAME+"</td>"
					+"<td>"+data[i].HC_POSITION+"</td>"
					+"<td>"+data[i].HC_DEPT+"</td>"
					+"<td>"+data[i].HDP_PAY+"</td>"
					+"<td>"+data[i].HDD_AMOUNT+"</td>"
					+"<td>"+result+"</td>"
					+"<td><button type='button' onclick='clickwages(\""+data[i].HC_ID+"\")'>입력 수정하기</button></td>"
					+"<td><button type='button' onclick='wages(\""+data[i].HC_ID+"\")'>상세보기</button></tr>";
			}
			$("#wages").append(str);
		},error:function(err){
			console.log(err);
		}
	});
	});
	//사원 급여관리 수정 및 입력페이지 이동
	function clickwages(hc){
		$.ajax({
			url:"/erp/hr/paydetai",
			method:"get",
			data:{hc:hc},
			dataType:"html",
			success:function(data){
				location.href="/erp/hr/payinputmodify";
			},
			error:function(err){
				console.log(err);
			}
		});
	}
	//사원 급여 명세서 상세페이지 이동
	function wages(hc){
		$.ajax({
			url:"/erp/hr/paydetai",
			method:"get",
			data:{hc:hc},
			dataType:"html",
			success:function(data){
				location.href="/erp/hr/paydetail";
			},
			error:function(err){
				console.log(err);
			}
		});
	}
	
	
	
	
	
	
		$("#showMenu1").hover(function() {
			$("#smallMenu1").attr("style", "display:inline-block");
		}, function() {
			$("#smallMenu1").attr("style", "display:none");
		})
		$("#showMenu2").hover(function() {
			$("#smallMenu2").attr("style", "display:inline-block");
		}, function() {
			$("#smallMenu2").attr("style", "display:none");
		})
		$("#showMenu3").hover(function() {
			$("#smallMenu3").attr("style", "display:inline-block");
		}, function() {
			$("#smallMenu3").attr("style", "display:none");
		})
		
	</script>
</body>
</html>
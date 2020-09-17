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
<link href="/erp/css/default.css" rel="stylesheet" type="text/css" media="all" />
<style>
#header{
	width: 100%;
	height: 200px;
}

#side_menu{
	height: 100%;
	width: 250px;
	font-size: 20px;
	font-weight: bolder;
	float: left;
	border-right: 1px solid #E6E6E6;
}

#side_menu #menuList{
	list-style: none;
	margin-top: 150px;
}

#side_menu #menuList li{
	margin: 20px;
}

a{
text-decoration: none;
}

body{
position: relative; 
}

#description{
    float:left;
    height:100%;
    width:75%;
    position: absolute;
    transform:translate(300px, 0);   
}

ul{
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
				<li><a href="#" accesskey="4" title="">내 정보</a></li>
				<li><a href="#" accesskey="2" title="">인사 관리</a></li>
				<li><a href="#" accesskey="3" title="">영업 관리</a></li>
				<li class="current_page_item"><a href="#" accesskey="5" title="">구매 관리</a></li>
				<li><a href="#" accesskey="6" title="">자재 관리</a></li>
				<li><a href="#">회계 관리</a></li>
			</ul>
		</div>
	</div>
	
	<div id="side_menu">
      <ul id="menuList">
         <li id="showMenu2"><a href="pregistrationfrm" id="Pregistration">구매관리</a></li>
         <li id="showMenu3"><a href="returnregistration" id="Rregistration">반품 관리</a></li>
      </ul>
   	</div>
	<div id="description">본 화면</div>
	<script>
		
		$("#showMenu1").hover(function() {
			$("#smallMenu1").attr("style", "display:inline-block");
		}, function() {
			$("#smallMenu1").attr("style", "display:none");
		})
		
		$('#Pregistration').on('click', function(e) {
			e.preventDefault();
			$.ajax({
				type : 'get',
				url : 'pregistrationfrm',
				dataType : 'html',
				success : function(data) {
					//console.log(data);
					$('#description').html(data);
				},
				error: function(error){
					console.log(error);
				}
			});
		});
		
		$('#Rregistration').on('click', function(e) {
			e.preventDefault();
			$.ajax({
				type : 'get',
				url : 'returnregistration',
				dataType : 'html',
				success : function(data) {
					//console.log(data);
					$('#description').html(data);
				},
				error: function(error){
					console.log(error);
				}
			});
		});
		
		
		
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Document</title>
<link href="/erp/css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
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
	width: 1300px;
}
</style>
</head>
<body>
	<div id="header">
		<div id="logo">
			<h1>
				<a href="/erp/main">N7 ERP SYSTEM</a>
			</h1>
		</div>
		<div id="menu">
			<ul id="mainmenu">

			</ul>
		</div>
	</div>
	<div id="side_menu">
		<ul id="menuList">
			<li><a href="#" id="acPend">내가 올린 결재함</a></li>
			<li><a href="#" id="acDownlist">내가 받은 결재함</a></li>
			<!-- 			<li><a href="/erp/Account/acpreList" id="prelist">임시저장 결재함</a></li> -->
			<li><a href="#" id="acList">임시저장 결재함</a></li>
			<!-- 			<li><a href="javascript:Aj('/erp/Account/acpreList', '#description')"> 결재함</a></li> -->
		</ul>
	</div>
	<center>
		<div id="description"></div>
	</center>
</body>
<script>
	$("#acPend").click(function() {
		$.ajax({
			url : '/erp/Account/acPend',
			type : 'get',
			success : function(data) {
				$("#description").html(data);
			},
			error : function() {
			}
		});

	});

	$("#acDownlist").click(function() {
		$.ajax({
			url : '/erp/Account/acDownlist',
			type : 'get',
			success : function(data) {
				$("#description").html(data);
			},
			error : function() {
			}
		});

	});

// 	function Aj(url, position) {
// 		$.ajax({
// 			url : url,
// 			type : 'get',
// 			dataType : "html",
// 			success : function(page) {
// 				$(position).html(page);
// 			},
// 			error : function(error) {
// 				console.log(error);
// 			}
// 		});
// 	}

	// 	$("#prelist").click(function(){
	// 		$.ajax({
	// 			url : '/erp/Account/acpreList',
	// 			type : 'get',
	// 			success : function (data){
	// 				$("#description").html(data);
	// 			},
	// 			error : function(){

	// 			}

	// 		});

	// 	});

		$("#acList").click(function() {
			$.ajax({
				url :'/erp/Account/acpreList',
				success : function(data) {
					console.log(data);
					$("#description").html(data);
				},
				error : function(err) {
					console.log(err);
				}
			});

		});
</script>
</html>
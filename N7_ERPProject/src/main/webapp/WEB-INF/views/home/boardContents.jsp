<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License
Name       : UpRight 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20130526
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/erp/css/default.css" rel="stylesheet" type="text/css"
   media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<style type="text/css">
h2{
font-size: 50px;
margin-top: 20px;
margin-bottom: 10px;
margin-left: auto;
font-family: inherit;
font-weight: 500;
color: inherit;
text-transform: uppercase;
display: block;    
text-align: center;
}
</style>
</head>
<body>
	<div id="header" class="container">
		<div id="logo">
			<h1>
				<a href="/erp/" style="color: black;">N7 ERP SYSTEM</a>
			</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="/erp/">MAIN</a></li>
				<li><a href="/erp/introducecompany">회사 소개</a></li>
				<li><a href="/erp/erpboard" accesskey="5" title="">상담 게시판</a></li>
				<li><a href="/erp/erpapply">ERP 신청</a></li>
				<li><a href="/erp/login">LOGIN</a></li>
				<li><a href="/erp/join">JOIN</a></li>
				<li class="current_page_item"><a href="#">ERP시작</a></li>
			</ul>
		</div>
	</div>
	<form action="getContents">
		<h2>상세페이지</h2>
		<table>
		</table>
	</form>
</body>
</html>
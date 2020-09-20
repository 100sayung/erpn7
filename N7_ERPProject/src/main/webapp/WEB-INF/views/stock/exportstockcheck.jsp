<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	width: 1200px;
}

ul {
	list-style: none;
}

td, th, table {
	border: 1px solid white;
}

td, th {
	width: 100px;
	height: 30px;
}

tr {
	text-align: center;
}

button {
	width: 100px;
	height: 30px;
	background-color: #FFB2D9;
	border: 0px;
	border-radius: 8px;
	font-weight: bolder;
	font-size: 14px;
	color: white;
}

span {
	text-align: center;
	color: red;
}

input[type='text'], input[type='number'] {
	width: 70px;
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
				<li><a href="#" accesskey="5" title="">구매 관리</a></li>
				<li class="current_page_item"><a href="#" accesskey="6"
					title="">자재 관리</a></li>
				<li><a href="#">회계 관리</a></li>
			</ul>
		</div>
	</div>
	<div id="side_menu">
		<ul id="menuList">
			<li><a href="/erp/stock/setcategory">분류명 작성</a></li>
			<li><a href="/erp/stock/setitemcode">품목 코드 작성</a></li>
			<li><a href="/erp/stock/importlist">입/출고 내역</a></li>
			<li><a href="/erp/stock/importcheck">입고 수정 및 확정</a></li>
			<li><a href="/erp/stock/byitemdeallist">품목별 거래현황</a></li>
			<li><a href="/erp/stock/byitemstocklist">품목별 자재현황</a></li>
			<li><a href="/erp/stock/monthpayment">월수불실적</a></li>
			<li><a href="/erp/stock/exportstockcheck">출고 양식</a></li>
			<li><a href="/erp/stock/accountconfirm">거래처 등록</a></li>
		</ul>
	</div>

	<div id="description">
	<div id="getCt_code">
	</div>
		<div id="getItemCodeFromItemCcode">
		</div>
		<div id="contain">
		<form id = 'frm0'>
		<button type="button" onclick="addRow(0)">행 추가</button>
		<table class="tb">
		<caption><input type="text"></caption>
			<tr>
			<td>분류명</td><td>품목코드</td><td>단가</td><td>수량</td><td>삭제</td>
			</tr>
			<tr class="tr"><td></td><td></td><td><input type="number" min="10"></td><td><input type="number" min="0"> </td><td><button type="button" onclick="deleteRow(this)">삭제</button></td>
			</tr>		
		</table>
		</form>
		</div>
		<button type="button" id="btn">출고양식 추가</button>
		<button type="button" id="export">출고 확정</button>
	</div>
	<script>
	$('#btn').click(function() {
		var num ;
		for(var i = 0; ;){
			if($('#frm'+i).length!=0){
				i++;
			}else{
				num = i;
				break;
			}
		}
		var str = '<form id="frm'+num+'"><button type="button" onclick="addRow('+num+')">행 추가</button>'
		+'<table class="tb"><caption><input type="text"></caption>'
		+'<tr><td>분류명</td><td>품목코드</td><td>단가</td><td>수량</td><td>삭제</td>'
		+'</tr><tr class="tr"><td></td><td></td><td><input type="number" min="10"></td><td><input type="number" min="0"> </td>'
		+'<td><button type="button" onclick="deleteRow(this)">삭제</button></td>'
		+'</tr></table>';
		$('#contain').append(str);/
	});
	function addRow(num) {
		var str = '<tr class="tr"><td></td><td></td>'
			+'<td><input type="number" min="10"></td>'
			+'<td><input type="number" min="0"> </td>'
			+'<td><button type="button" onclick="deleteRow(this)">삭제</button></td></tr>';
		$('#frm'+num).children(".tb").append(str);
	}
	function deleteRow(id) {
		var child =  id.parentElement.parentElement;
		child.parentNode.removeChild(child);
	}
	</script>
</body>
</html>
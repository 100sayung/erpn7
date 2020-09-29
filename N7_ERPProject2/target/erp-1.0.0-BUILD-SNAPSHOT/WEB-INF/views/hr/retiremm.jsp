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
	border-right: 1px solid #E6E6E6;
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
				<li><a href="/erp/myinfo/myinfo" accesskey="4" title="">내
						정보</a></li>
				<li class="current_page_item"><a href="/erp/hr/hr"
					accesskey="2" title="">인사 관리</a></li>
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
					<li><a href="/erp/hr/receiptholiday">휴가 접수</a></li>
					<li><a href="/erp/hr/attendance">사원 출결 관리</a></li>
					<li><a href="/erp/hr/employeestatus">근무 조회</a></li>
					<li><a href="/erp/hr/retiremm">휴/퇴직 관리</a></li>
				</ul>
			</li>
			<li id="showMenu3">급여 관리
				<ul id="smallMenu3" style="display: none;">
					<li><a href="/erp/hr/deptpay">부서/직급별 급여</a></li>
					<li><a href="/erp/hr/deduct">공제사항 관리</a></li>
					<li><a href="">급여 관리</a></li>
				</ul>
			</li>
		</ul>
	</div>

	<div id="description">
	<br> 재직중일때 검색 기능 추가해야함 !! 정말 그럴거냐고 물어봐야함 !!<br>
	<br><h1>인사카드 등록이 한개라도 안되어있을땐 인사카드부터 하게해야함. 전부 예외처리해서 인사카드로 이동시켜야함.</h1>
		<a href="javascript:CheckRetired(0)"> 재직중(0) </a> 
		<a href="javascript:CheckRetired(1)"> 휴직중(1) </a> 
		<a href="javascript:CheckRetired(2)"> 퇴사(2) </a> <br>
		<div id="container">
			<input type="hidden" value="" id="status">
		</div>

	</div>
	<script>
	//검색 조건들 생성



	//검색 조건 끝

	function CheckRetired(status){
		$.ajax({
			url:"/erp/rest/hr/checkretired",
			dataType:"json",
			method:"get",
			data : {status : status},
			success : function(data){
				let str = "<table>";
				console.log(data);
				for(let i = 0 ; i<data.length ; i++){
					str += "<tr>"
					str += "<td><input type='hidden' name='hc_hrcode' value= '"+data[i].hc_hrcode+"'>"+data[i].m_name +"</td>";
					str += "<td><input type='text' name ='hc_dept' value = '" + data[i].hc_dept + "' readonly></td>";
					str += "<td><input type='text' name='hc_position' value = '" + data[i].hc_position + "' readonly></td>";
					str+="<td><select name='hc_work'>";
					if(status == 1){
						str+="<option value = '1' selected = 'selected'> 휴직 </option>";
						str+="<option value = '2'> 퇴사 </option>";
						str+="<option value = '0'> 재직 </option>";
					}else if(status == 2){
						str+="<option value = '1'> 휴직 </option>";
						str+="<option value = '2' selected = 'selected'> 퇴사 </option>";
						str+="<option value = '0'> 재직 </option>";
					}else if(status == 0){
						str+="<option value = '1'> 휴직 </option>";
						str+="<option value = '2'> 퇴사 </option>";
						str+="<option value = '0' selected = 'selected'> 재직 </option>";
					}
					str += "</select></td><td><input type='button' value='등록' onclick='javascript:thisRowDel(this);'></td></tr>";
				}
				str+="</table>"
				$("#container").html(str);
			}, error : function(err){
				console.log(err);
			}
		});
		$("#status").val(status);
	}


		function thisRowDel(row){
			console.log(row);
			let tr = row.parentNode.parentNode;
			console.log(tr.firstChild.firstChild.value);
			console.log(tr.lastChild.previousSibling.firstChild.value);
			$.ajax({
				url:"/erp/rest/hr/updateretired",
				data : {hrCode : tr.firstChild.firstChild.value, work : tr.lastChild.previousSibling.firstChild.value},
				dataType:"json",
				method:"post",
				success : function(data){
					console.log(data);
				},error : function(err){
					console.log(err)
				}
			});
			tr.parentNode.removeChild(tr);
		}
	//업데이트시











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
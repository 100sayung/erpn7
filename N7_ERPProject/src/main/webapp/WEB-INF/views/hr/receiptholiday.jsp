

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
	<script src=/erp/js/menu.js></script> <!-- 메뉴Ajax로 출력 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="/erp/css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="/erp/css/hrCss.css" rel="stylesheet" type="text/css"
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
}

table {
	text-align: center;
}

table, th, td {
	border-bottom: 1px solid balck;
	border-top: 1px solid black;
	border-collapse: collapse;
}

#calendar td {
	width: 30px;
}

width




:


 


800px




;
}
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	width: 30px
}

ul {
	list-style: none;
}
</style>
</head>
<body onload='build();'>
	<div id="header">
		<div id="logo">
			<h1>
				<a href="#">N7 ERP SYSTEM</a>
			</h1>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="/erp/myInfo/myInfo" accesskey="4" title="">내 정보</a></li>
				<ul id="mainmenu">
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
					<li><a href="/erp/hr/searchpaymm">급여 관리</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<!-- 09-25 change  -->
	<div id="description" align="center">
		<div class="divcss">사원 휴가 관리</div><br>
		<table align="center" >
			<tr style="border-left: 1px solid black;border-right: 1px solid black;">
				<td style="width: 100px;"><font color="#B3B6B3"><label
						onclick="beforem()" id="before"></label></font></td>
				<td style="width: 150px; font-size: 15px;" align="center"
					id="yearmonth" style="font-size: 15px;"></td>
				<td style="width: 100px;"><font color="#B3B6B3"><label
						onclick="nextm()" id="next"></label></font></td>
			</tr>
		</table>
		<table align="center" id="calendar">
		</table>
	<!-- ////////// -->
		<br>
		<div id="container"></div>

	</div>
<script src=/erp/js/menu.js></script><!-- 메뉴Ajax로 출력 -->
	<script>
		var str = "";
			$(document).ready(function() {
		})

		//이 아래로 달력
		var today = new Date(); // 오늘 날짜
		var date = new Date();

		function beforem() //이전 달을 today에 값을 저장
		{
			today = new Date(today.getFullYear(), today.getMonth() - 1, today
					.getDate());
			build(); //만들기
		}

		function nextm() //다음 달을 today에 저장
		{
			today = new Date(today.getFullYear(), today.getMonth() + 1, today
					.getDate());
			build();
		}

		function build() {
			var nMonth = new Date(today.getFullYear(), today.getMonth(), 1); //현재달의 첫째 날
			var lastDate = new Date(today.getFullYear(), today.getMonth() + 1,
					0); //현재 달의 마지막 날
			var tbcal = document.getElementById("calendar"); // 테이블 달력을 만들 테이블
			var yearmonth = document.getElementById("yearmonth"); //  년도와 월 출력할곳
			yearmonth.innerHTML = today.getFullYear() + "년 "
					+ (today.getMonth() + 1) + "월"; //년도와 월 출력

			if (today.getMonth() + 1 == 12) //  눌렀을 때 월이 넘어가는 곳
			{
				before.innerHTML = (today.getMonth()) + "월";
				next.innerHTML = "1월";
			} else if (today.getMonth() + 1 == 1) //  1월 일 때
			{
				before.innerHTML = "12월";
				next.innerHTML = (today.getMonth() + 2) + "월";
			} else //   12월 일 때
			{
				before.innerHTML = (today.getMonth()) + "월";
				next.innerHTML = (today.getMonth() + 2) + "월";
			}

			// 남은 테이블 줄 삭제
			while (tbcal.rows.length > 0) {
				tbcal.deleteRow(tbcal.rows.length - 1);
			}

			var row = null;
			row = tbcal.insertRow();
			var cnt = 0;
			// 달력 출력
			for (i = 1; i <= lastDate.getDate(); i++) // 1일부터 마지막 일까지
			{
				cell = row.insertCell();
				cell.innerHTML = "<span id="+i+"><a href='javascript:checkMyAt("
						+ i + ")'>" + i + "</a></span>";
				cnt = cnt + 1;
				if (cnt % 7 == 1) {//일요일 계산
					cell.innerHTML = "<span id="+i+"><a href='javascript:checkMyAt("
							+ i
							+ ")'><font color=#FF9090>"
							+ i
							+ "</font></a></span>";//일요일에 색
				}
				if (cnt % 7 == 0) { // 1주일이 7일 이므로 토요일 계산
					cell.innerHTML = "<span id="+i+"><a href='javascript:checkMyAt("
							+ i
							+ ")'><font color=#7ED5E4>"
							+ i
							+ "</font></a></span>";//토요일에 색
				}
				if (today.getFullYear() == date.getFullYear()
						&& today.getMonth() == date.getMonth()
						&& i == date.getDate()) {
					cell.bgColor = "#BCF1B1"; //오늘날짜배경색
				}
			}
			$.ajax({
				url : "/erp/rest/hr/employeeholiday",
				dataType : "json",
				data : {
					yearmonth : $("#yearmonth").html()
				},
				method : "get",
				success : function(data) {
					console.log(data);
					console.log($("#yearmonth").html());
					var month = $("#yearmonth").html().split("월");
					month = month[0].split(" ");
					var year = month[0].substr(0, 4);
					month = month[1];
					if (month < 10) {
						month = "0" + month;
					}
					row = calendar.insertRow();
					for (let k = 0; k < data.length; k++) {
						let startarr = data[k].hap_startday.split("-");
						let startday = "";
						for (let sa = 0; sa < startarr.length; sa++) {
							startday += startarr[sa];
						}
						let endarr = data[k].hap_endday.split("-");
						let endday = "";
						for (let sa = 0; sa < endarr.length; sa++) {
							endday += endarr[sa];
						}
						console.log(startday, endday);
						for (let j = 0; j < cnt + 1; j++) {
							cell = row.insertCell();
							let day = j + 1;
							if (day < 10) {
								day = "0" + day;
							}
							let date = "" + year + month + day;
							if (startday == date) {
								cell.innerHTML = "<-";
							} else if (endday == date) {
								cell.innerHTML = "->";
							} else if (startday < date && date < endday) {
								if (j != cnt) {
									cell.innerHTML = "--";
								} else {
									cell.innerHTML = data[k].m_name;
								}
							} else if (j == cnt) {
								cell.innerHTML = data[k].m_name;
							} else {
								cell.innerHTML = "";
							}
						}
						designThis(cell);
						row = calendar.insertRow();
					}
					str = data[0].hap_type;
				},
				error : function(err) {
					console.log(err);
				}
			});
		}

		function designThis(cell) {
			console.log(cell);
			cell.style.width = "100px";
		}

		$("#showMenu1").hover(function() {
			$("#smallMenu1").attr("style", "display:inline-block");
		}, function() {
			console.log(str);
			$("#smallMenu1").attr("style", "display:none");
		});
		$("#showMenu2").hover(function() {
			$("#smallMenu2").attr("style", "display:inline-block");
		}, function() {
			$("#smallMenu2").attr("style", "display:none");
		});
		$("#showMenu3").hover(function() {
			$("#smallMenu3").attr("style", "display:inline-block");
		}, function() {
			$("#smallMenu3").attr("style", "display:none");
		});
	</script>
</body>
</html>
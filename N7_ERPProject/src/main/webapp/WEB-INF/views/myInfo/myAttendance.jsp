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
table
{
     border:1px solid #BDBDBD;
     text-align:center;
     width:30%;
}
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

table{
	width : 1300px;
	height: 850px;
}
td{
	width:200px;
}
</style>
</head>
<body onload="build();">
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
			<li><a href="/erp/myInfo/myInfo">내 정보 보기</li>
			<li><a href="/erp/myinfo/myPaycheck">급여명세서 보기</li>
			<li><a href="/erp/myinfo/myattendance">내 출결 보기</li>
			<li><a href="/erp/myinfo/myholiday">내 휴가 보기</li>
			<li><a href="/erp/myinfo/applyholiday">휴가신청</a></li>
			<li><a href="/erp/myinfo/mydocument">나의 결재함</a></li>
		</ul>
	</div>
	<div id="description">
    <table align="center" id="calendar">
        <tr>
            <td><font color="#B3B6B3"><label onclick="beforem()" id="before" ></label></font></td>
            <td colspan="5" align="center" id="yearmonth"><font size="20px"></font></td>
            <td><font color="#B3B6B3"><label onclick="nextm()" id="next"></label></font></td>
        </tr>
        <tr>
            <td align="center"> <font color="#FF9090">일</font></td>
            <td align="center"> 월 </td>
            <td align="center"> 화 </td>
            <td align="center"> 수 </td>
            <td align="center"> 목 </td>
            <td align="center"> 금 </td>
            <td align="center"><font color=#7ED5E4>토</font></td>
        </tr>
    </table>
    <div id="at"></div>
	</div>

	<script src=/erp/js/menu.js></script> <!-- 메뉴Ajax로 출력 -->
	<script>
	function checkMyAt(i){
		$.ajax({
			url : "/erp/rest/myinfo/myattendance",
			method:"get",
			dataType:"json",
			data:{day : i, yearmonth : $("#yearmonth").html()},
			success : function(data){
				console.log(data);
				let str = "<table>";
				let type = "";
				for(let i = 0; i<data.length ; i++){
					if(data[i].ha_type=="1"){
						type = "출근"
					}else{
						type = "퇴근"
					}
					str += "<tr><td>" + data[i].ha_time + "</td><td>" + type + "</td></tr>";
				}
				str += "</table>"
				$("#at").html(str);
			}, error : function(err){
				console.log(err);
			}
		});
	}


//이 아래로 달력
    var today = new Date(); // 오늘 날짜
    var date = new Date();

    function beforem() //이전 달을 today에 값을 저장
    {
        today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
        build(); //만들기
    }

    function nextm()  //다음 달을 today에 저장
    {
        today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
        build();
    }

    function build()
    {
        var nMonth = new Date(today.getFullYear(), today.getMonth(), 1); //현재달의 첫째 날
        var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0); //현재 달의 마지막 날
        var tbcal = document.getElementById("calendar"); // 테이블 달력을 만들 테이블
        var yearmonth = document.getElementById("yearmonth"); //  년도와 월 출력할곳
        yearmonth.innerHTML = today.getFullYear() + "년 "+ (today.getMonth() + 1) + "월"; //년도와 월 출력

        if(today.getMonth()+1==12) //  눌렀을 때 월이 넘어가는 곳
        {
            before.innerHTML=(today.getMonth())+"월";
            next.innerHTML="1월";
        }
        else if(today.getMonth()+1==1) //  1월 일 때
        {
        before.innerHTML="12월";
        next.innerHTML=(today.getMonth()+2)+"월";
        }
        else //   12월 일 때
        {
            before.innerHTML=(today.getMonth())+"월";
            next.innerHTML=(today.getMonth()+2)+"월";
        }


        // 남은 테이블 줄 삭제
        while (tbcal.rows.length > 2)
        {
            tbcal.deleteRow(tbcal.rows.length - 1);
        }
        var row = null;
        row = tbcal.insertRow();
        var cnt = 0;

        // 1일 시작칸 찾기
        for (i = 0; i < nMonth.getDay(); i++)
        {
            cell = row.insertCell();
            cnt = cnt + 1;
        }

        // 달력 출력
        for (i = 1; i <= lastDate.getDate(); i++) // 1일부터 마지막 일까지
        {
            cell = row.insertCell();
            cell.innerHTML = "<span id="+i+"><a href='javascript:checkMyAt("+i+")'>"+i+"</a></span>" ;
            cnt = cnt + 1;
            if (cnt % 7 == 1) {//일요일 계산
                cell.innerHTML = "<span id="+i+"><a href='javascript:checkMyAt("+i+")'><font color=#FF9090>"+i+"</font></a></span>";//일요일에 색
            }
            if (cnt % 7 == 0) { // 1주일이 7일 이므로 토요일 계산
                cell.innerHTML = "<span id="+i+"><a href='javascript:checkMyAt("+i+")'><font color=#7ED5E4>"+i+"</font></a></span>";//토요일에 색
                row = calendar.insertRow();// 줄 추가
            }
            if(today.getFullYear()==date.getFullYear()&&today.getMonth()==date.getMonth()&&i==date.getDate())
            {
                cell.bgColor = "#BCF1B1"; //오늘날짜배경색
            }
        }$.ajax({
    		url:"/erp/rest/myinfo/allmyattendance",
    		data:{yearmonth:$("#yearmonth").html()},
    		dataType:"json",
    		method:"get",
    		success: function(data){
    			console.log(data);
    			for(let i = 0 ; i<data.length ; i++){
    				let str = "";
       				let time = data[i].ha_time.substr(16, 8);
    				if(data[i].ha_type=="1"){
    					str += "<font style='color:blue'>"
        				str += "<br>" + time;
						str+= " 출근</font>"
					}else{
						str += "<font style='color:red'>"
	    				str += "<br>" + time;
						str+= " 퇴근</font>"
					}
    				let date = data[i].ha_time.substring(8,10);
    				if(date<10){
    					date = date.substring(1);
    				}
    				console.log(date);
					$("#"+date).append(str);
    			}
    		}, error : function(err){
    			console.log(err);
    		}
    	});
    }

	</script>
</body>
</html>

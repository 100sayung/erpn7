<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/erp/css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet" type="text/css"></link>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
    <style>
        #container {
            width: 700px;
            margin-top: 100px;
        }

        button {
            margin-top: 10px;
            width: 100px;
            height: 50px;
            border: 0px;
            background-color: #FFB2D9;
            color: white;
            font-weight: bolder;
            border-radius: 8%;
        }
    </style>
</head>
<body>
    <div id="header" class="container">
        <div id="logo">
            <h1><a href="/erp/" style="color: black;">N7 ERP SYSTEM</a></h1>
        </div>
        <div id="menu">
            <ul>
                <li><a href="/erp/" accesskey="4" title="">MAIN</a></li>
                <li><a href="/erp/introducecompany" accesskey="2" title="">회사 소개</a></li>
                <li><a href="/erp/erpboard" accesskey="3" title="">상담 게시판</a></li>
                <c:if test="${id==null}">
                <li><a href="/erp/login" accesskey="5" title="">LOGIN</a></li>
                <li><a href="/erp/join" accesskey="6" title="">JOIN</a></li>
             	</c:if><c:if test="${id!=null}">
             	<li><form action="logout" method="post"><button>LOGOUT</button></form></li>
                <li class="current_page_item"><a href="#">ERP시작</a></li></c:if>
            </ul>
        </div>
    </div>
    <center>
        <div id="container">
        <br>
회사코드같은경우엔 자기가 입력할건지 (중복체크 필수), 우리가 자동으로생성해줄건지 결정<br>
주소검색 api설정<br>

        <br><br>
        
            <h1>erp 신청</h1>
			<form action="newerp" method="post" onsubmit="return sum();">
                <table class="table table-condensed">
                    <tr>
                        <td>회사명</td>
                        <td><input type="text" name="c_name"></td>
                    </tr>
                    <tr>
                        <td>회사코드</td>
                        <td><input type="text" name="c_code">
                        <button onclick="dupleCheck()">중복확인</button></td>
                    </tr>
                    <tr>
                        <td>대표자명</td>
                        <td><input type="text" name="c_ceo"></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input type="text" name="c_phonenum"></td>
                    </tr>
                    <tr>
                    	<td>업태</td>
                    	<td><input type='text' name='c_kind'></td>
                    </tr>
                    <tr>
                    	<td>종류</td>
                    	<td><input type='text' name='c_kind2'></td>
                    </tr>
                   <!--  <tr>
                        <td>구분</td>
                        <td><input type="radio" name="division" value="법인"> 법인 <input type="radio" name="division"
                                value="개인">개인</td>
                    </tr> -->
                    <tr>
                    	<td>주소</td>
                    	<td>
						<div class="form-group">
							<button id="postcodify_search_button" style="width: 100px;height: 30px;">주소검색</button>
							<input type="text" id="addr1" name="addr1" class="postcodify_address form-control" value="" />
							<input id="addr2" type="text" name="addr2" class="postcodify_details form-control" value="" />
							<input type="text" name="addr3" id="addr3" class="postcodify_extra_info form-control" value="" />
						</div>
						</td>
                    </tr>
                    <tr>
                    	<td>사업자번호</td>
                    	<td><input type='text' name='c_comnum'></td>
                    </tr>
                    <!-- <tr>
                        <td>필요 기능</td>
                        <td><input type="checkbox" name="require"> 인사 관리
                            <input type="checkbox" name="require"> 영업 관리
                            <input type="checkbox" name="require"> 구매 관리
                            <input type="checkbox" name="require"> 자재 관리
                            <input type="checkbox" name="require"> 회계 관리
                        </td>
                    </tr> -->
                    <tr>
                        <td colspan="2"><button style="margin-left: 305px;">신청</button></td>
                    </tr>
					<input type="hidden" name="c_addr" id="addr"></input>

                </table>
            </form>
        </div>
    </center>
    
    <script>
	$(function() { $("#postcodify_search_button").postcodifyPopUp(); }); 
	

	function sum(){
		$("#addr").val($('#addr1').val()+$('#addr2').val()+$('#addr3').val());
		return true;
	}
    </script>
</body>
</html>
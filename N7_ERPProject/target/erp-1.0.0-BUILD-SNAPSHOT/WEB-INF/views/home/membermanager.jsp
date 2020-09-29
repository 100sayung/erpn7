<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/erp/css/hrCss.css" rel="stylesheet" type="text/css" media="all" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="/erp/css/default.css" rel="stylesheet" type="text/css"
	media="all" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous" />
		<link href="img/favicon.png" rel="icon" />
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon" />
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  <link href="lib/icomoon/icomoon.css" rel="stylesheet" />
  <script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=1a9e4h5a1u&callback=initMap"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous" />
	<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
	<style>
.button {
	color: #ffffff;
}

#desc {
margin-left: 200px;
	font-size: 20px;
	font-weight: bolder;
}

</style>
</head>

<body>
	<div id="header" class="container">
		<div id="logo">
			<h1>
				<a href="/erp/">N7 ERP SYSTEM</a>
			</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="/erp/adminpage">ERP 등록</a></li>
				<li><a href="/erp/companymanager" accesskey="3" title="">회사 관리</a></li>
				<li><a href="/erp/membermanager" accesskey="4" title="">회원 관리</a></li>
			</ul>
		</div>
	</div>
	<div id="description">
	
	회원관리페이지 <h1> 탈퇴누르면 delete 시키는게 아니라 상태코드를 'X' 로 바꿔둠!!!!</h1>
	<br>
	검색기능 :
	<input type="text" id="m_id"></input>	<button id="searchbtn">검색</button> </br>
	<br></br>
	</div><!-- 옵션선택 -->
	
	
	<div id="container" style="text-align:center; align-content: center;">
	</div>
	<div id="paging" style="text-align: center"></div>
	<br><br></br></br><br></br>
	<div id="management"> 
	선택 멤버를 
	<select>
	<option value="0"> 일반회원</option>
	<option value="1"> ERP매니저</option>
	<option value="2"> ADMIN계정</option>
	</select>
	으로 
	<input type='button' value='변경' onclick="changeGrade()">
	<input type='button' value='강제탈퇴' onclick="forceWithdrawal()">
	</div>
	</div>
	
	<script>
	//테스트중
	/* 
	var currPage = 1;
	var contents;
	function pageNumber(num, addr){
		var pageNum;
		currPage = num;
		$.ajax({
			url:"/erp/rest"+addr,
			dataType:"json",
			async:false, //비동기통신을 동기통신으로 만들어줘야함
			method:"get",
			success : function(page){
				console.log(page);
				pageNum = page;
			}, error : function(err){
				console.log(err);
			}
		});
		console.log(pageNum);
		return pageNum;
	}
	
	function list(nowPage, addr, cntPerPage){
		$.ajax({
			url:"/erp/rest"+addr,
			dataType:"json",
			data:{nowPage : nowPage, cntPerPage : cntPerPage},
			method:"get",
			success : function(data){
				console.log(data);
				contents = data;
			}, error : function(err){
				console.log(err);
			}	
		});
		console.log(contents);
		return contents;
	}
	
	
	
	var Paging = function(num, pageAddr, contentsAddr, nowPage, cntPerPage){
		console.log(pageNumber(num, pageAddr));
		console.log(list(nowPage, contentsAddr, cntPerPage));
	}
	
	Paging(1, "/admin/memberpagenumber", "/admin/memberlist", 1, 10);
	
	 */
	</script>
	
	<script> 
	//페이지 변경 스크립트

	var currPage = 1;
	function selChange(){
		var sel = document.getElementById('cntPerPage').value;
		location.href ="memberlist?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
	
	function pageNumber(j){
		currPage = j;
		$.ajax({
			url:"/erp/rest/admin/memberpagenumber",
			dataType:"json",
			method:"get",
			success : function(page){
				console.log(page);
				var pagecnt = (page/10) + 1;
				let str = "";
				for(let i = 1 ; i < pagecnt ; i++){
					if(i == currPage){
						str += " &nbsp; ["+ i +"] &nbsp; ";
					}else{
						str += " &nbsp; <a href=javascript:paging("+i+")>["+ i +"]</a> &nbsp; ";
					}
				}
				console.log(str);
				$("#paging").html(str);
			}, error : function(err){
				console.log(err);
			}
		});
	}
	function paging(num){
		pageNumber(num);
		memberlist(num);
	}
	
	function memberlist(nowPage){
		$.ajax({
			url:"/erp/rest/admin/memberlist",
			dataType:"json",
			data:{nowPage : nowPage, cntPerPage : "10"},
			method:"get",
			success : function(data){
				console.log(data);
				let str = "";
				str = "<table>"
				str += "<tr class='infomenu'><td> &nbsp; </td><td style='width:200px;'>이름(아이디)</td><td style='width:150px;'>회사코드</td><td style='width:100px;'>등급</td></tr>"
				for(let i = 0 ; i<data.length ; i++){
				str += "<tr class = '' id='"+data[i].m_id+"'>";					
					str += "<td><input type='checkbox' id='chkbx' name='chkbx' value='"+data[i].m_id+"'></td>";
					str += "<td>" + data[i].m_name + "(" + data[i].m_id +")</td>";
					str += "<td>" + data[i].c_name + "("+ data[i].m_ccode + ")</td>";
					str += "<td>" + data[i].m_grade + "</td>";
					str += "</tr>"
				}
				str += "</table>";
				$("#container").html(str);
			}, error : function(err){
				console.log(err);
			}	
		});
	}
	
	memberlist(1);
	pageNumber(1); 
	
	</script>
	<script>
	
	
	function confirmcheck(){
		if(confirm("정말 하시겠습니까?") == true){
			return true;
		}else{
			return false;
		}
	}
	var gradeArr=[];
	function changeGrade(){
		if(confirmcheck()){
			$("input[name=chkbx]:checked").each(function(){
				var $id = $(this).val();
				var $grade = $("select").val();
				gradeArr.push({m_id :$id, m_grade :$grade});
			});
			console.log(gradeArr);
			
			gradeArr = JSON.stringify(gradeArr);
			
			$.ajax({
				url:"/erp/rest/admin/changegrade",
				data:{jsonStr : gradeArr},
				dataType:"json",
				method:"post",
				success : function(data){
					console.log(data)
				}, error : function(err){
					console.log(err);
				}
			});
			location.reload();
		}else{
			
		}
	}
	
	var forceArr = [];
	function forceWithdrawal(){
		if(confirmcheck()){
			$("input[name=chkbx]:checked").each(function(){
				var $id = $(this).val();
				forceArr.push($id);
			});
			console.log(forceArr);
			
			forceArr = JSON.stringify(forceArr);
			
			$.ajax({
				url:"/erp/rest/admin/forcewithdrawal",
				data:{jsonStr : forceArr},
				dataType:"json",
				method:"post",
				success : function(data){
					console.log(data);
				}, error : function(err){
					console.log(err);
				}
			});
			location.reload();
		}else{
			
		}
	}
	
	
	function SearchFromId(m_id){
		console.log(m_id);
		$.ajax({
			url:"/erp/rest/admin/searchfromid",
			dataType:"json",
			data:{m_id : m_id},
			method:"get",
			success : function(data){
				console.log(data);
				let str = "";
				str = "<table>"
				for(let i = 0 ; i<data.length ; i++){
					str += "<tr class = '' id='"+data[i].m_id+"'>";					
					str += "<td><input type='checkbox' id='chkbx' name='chkbx' value='"+data[i].m_id+"'></td>";
					str += "<td>" + data[i].m_name + "(" + data[i].m_id +")</td>";
					str += "<td>" + data[i].m_ccode + "</td>";
					if(data[i].m_grade == 0){
						str += "<td>일반회원</td>";						
					}else if(data[i].m_grade == 1){
						str += "<td>ERP매니저</td>";
					}else if(data[i].m_grade == 2){
						str += "<td>홈페이지ADMIN</td>";
					}
					str += "</tr>"
				}
				str += "</table>";
				$("#container").html(str);
			}, error : function(err){
				console.log(err);
			}
		});
	}
	
	$("#searchbtn").click(function() {
		SearchFromId($("#m_id").val());
	});
	
	</script>
	
</body>
</html>
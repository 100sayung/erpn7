<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
.modifyMode{
	background-color: skyblue;
}
.registMode{
	background-color:red;
}
img{
width: 200px;
height: 200px;
}
span{
	float: left;
}
.info{
	height:60px;
}
</style>

<meta charset="UTF-8">
</head>
<body>
<h1>인사카드 세부정보 / 수정</h1>
<div id="member"></div>

<br><br><br>

<table>
<div id="menu"></div>
</table>

<form id="form" method="post" onsubmit="return checkValue();">
<div id="hrDetailInfo">


<table border='1px solid black'>
<div id="addRecord"></div>
</table>
</div>
<input type='hidden' value='' id='current'>
<input type='button' value='추가하기' onclick='addRecord()' id='addRecordBtn'>
<br>
<input type='button' value='수정하기' onclick='changeMode()' id='changeBtn'>
<input type='submit' value='등록하기' disabled="disabled" id='registBtn'>
</form>

<


<script>
var num;
var id = location.search.substr(4);
$(document).ready(function(){
	$.ajax({
		url:"/erp/rest/hr/memberfromid",
		data:{m_id:id},
		dataType:"json",
		method:"get",
		contentType : 'application/json',
		success : function(data){
			console.log(data);
			let info = "";
			info += '<span style="height:200px;"><img src="/erp/upload/'+data.m_photo+'"></span>&nbsp;'
			info += '<span style="height:200px;"><table style="width:500px"><tr class="info"><td id="m_name">'+data.m_name+'</td><td id="m_gender">'+data.m_gender+'</td></tr>';
			info += '<tr class="info"><td id="m_phonenum">'+data.m_phonenum+'</td><td id="m_birth">'+data.m_birth+'</td></tr>';
			info += '<tr style="height:80px;"><td id="m_address" colspan="2">'+data.m_address+'</td></tr></table></span>';
			$("#member").html(info);
		},error : function(err){
		}
	});
	$.ajax({
		url:"/erp/rest/hr/hrcodefromid",
		data:{m_id:id},
		dataType:"json",
		method:"get",
		contentType: 'application/json',
		success : function(data){
			let str="";
			str+='<tr><td><a href="javascript:InCompanyInfo()"> 사내정보 </a></td>';
			if(data){
				str +='<td><a href="javascript:AcademicInfo()"> 학력 </a></td>';
				str +='<td><a href="javascript:CareerInfo() "> 이력 </a></td>';
				str +='<td><a href="javascript:CertificationInfo()"> 자격증 </a></td>';
			}
			str+='</tr>';
			$("#menu").html(str);
		}, error : function(err){
			console.log(err);
		}
	});
	console.log("load");
});

/* var str1 = Number(replaceAll($('.checkDate')[0].value,"-",""));
var str2;
if($('.checkDate')[1].value!=''){
str2 = Number(replaceAll($('.checkDate')[1].value,"-",""));
console.log(str1);
if(str1>str2){
   alert("종료일은 시작일보다 이전일 수 없습니다.");
   return;
}
} */


function replaceAll(str, searchStr, replaceStr) {
    return str.split(searchStr).join(replaceStr);
 }
 
function checkValue(){
	for(let i = 0 ; i<$("input").length ; i++){
		if($("input")[i].value==""){
			alert("값을 모두 입력해주세요.");	
			return false;
		}
	}
	return true;
}
function checkDateValue(val1, val2){
	let date1 = Number(replaceAll(val1.value, "-", ""));
	let date2 = Number(replaceAll(val2.value, "-", ""));
	if(date1>date2){
		alert("종료일은 시작일보다 이전일 수 없습니다.");
		val2.value = "";
	}
}
 
function addRecord(){
	let str ="";
	let cntAc = 0;
	let cntCt = 0;
	var $current = $("#current").val();
	console.log(num);
	if($current == 'Academic'){
		str += "<tr id='test'><td><input type='text' name='hac_school' class='detailInfo'></td>";
		str += "<td><input type='text' name='hac_major' class='detailInfo'></td>";
		str += "<td><input type='date' name='hac_year' class='detailInfo'></td>";
		str += "<td><input type='button' value='삭제' onclick='javascript:thisRowDel(this);'></td></tr>";
	}else if($current =='Certification'){
		str += "<tr><td><input type='text' name='hct_name' class='detailInfo'></td>";
		str += "<td><input type='text' name='hct_agency' class='detailInfo'></td>";
		str += "<td><input type='date' name='hct_date' class='detailInfo'></td>"
			str += "<td><input type='button' value='삭제' onclick='javascript:thisRowDel(this);'></td></tr>";
	}else if($current =='Career'){
		str += "<tr><td><input type='text' name='hca_cname' class='detailInfo'></td>";
		str += "<td><input type='date' name='hca_period' id='chk"+(num*2)+"' class='detailInfo checkDate'><br>";
		str += "<input type='date' name='hca_periodend' id='chk"+((num*2)+1)+"' class='detailInfo checkDate' onchange='checkDateValue(chk"+(num*2)+", chk"+((num*2)+1)+")'></td>"
		str += "<td><input type='text' name='hca_position' class='detailInfo'></td>";
		str += "<td><textarea rows='3' cols='20' name='hca_content' class='detailInfo'></textarea></td>"
		str += "<td><input type='button' value='삭제' onclick='javascript:thisRowDel(this);'></td></tr>";
		num++;
	}
	$("#hrDetailInfo").append(str);
}

function thisRowDel(row){
	console.log(row);
	let tr = row.parentNode.parentNode;
	tr.parentNode.removeChild(tr);
}

function changeMode(){
	console.log($("#changeBtn").attr('class'));
	if($("#changeBtn").attr('class')=="mf"){
		$(".detailInfo").attr("readonly", true).addClass("modifyMode").removeClass("registMode");
		$("#registBtn").attr("disabled", false);
	}else{
		$(".detailInfo").removeAttr("readonly").removeClass("modifyMode").addClass("registMode");
		$("#registBtn").attr("disabled", true);
	}
	$("#changeBtn").toggleClass("mf");
}

var formURL = "/erp/hr";


function AcademicInfo(){
	$("#form").attr("action", formURL + "/newacademic/" +id);
	$("#current").val("Academic");
	$.ajax({
		url:"/erp/rest/hr/academic",
		data:{m_id:id},
		dataType:"json",
		method:"get",
		contentType: 'application/json',
		success : function(data){
			if(data.length==undefined){
				var arr = [data]
				data = arr;
				}
			let str ="";
			str += "<table border='1px solid black'><tr>";
			str += "<td>학교/학위</td><td>전공</td><td>날짜</td></tr>";
			for(let i = 0 ; i <data.length ; i++){
			console.log(data[i].hac_year);
			str += "<tr><td><input type='text' name='hac_school' class='detailInfo' value='"+data[i].hac_school+"' readonly></td>"
			str += "<td><input type='text' name='hac_major' class='detailInfo' value='"+data[i].hac_major+"' readonly></td>";
			str += "<td><input type='date' name='hac_year' class='detailInfo' value='"+data[i].hac_year+"' readonly>";
			str += "<input type='hidden' name='hac_num' value='"+data[i].hac_num+"'></td></tr>";
			}
			str += "</table>";
			$("#hrDetailInfo").html(str);
		},error : function(err){
			/* let str ="";
			str += "<table border='1px solid black'><tr>";
			str += "<td>학교/학위</td><td>전공</td><td>날짜</td></tr>";
			str += "<tr><td><input type='text' name='hac_school' class='detailInfo'></td>"
			str += "<td><input type='text' name='hac_major' class='detailInfo'></td>";
			str += "<td><input type='date' name='hac_year' class='detailInfo'></td></tr>";
			str += "</table>";
			$("#hrDetailInfo").html(str); */
		} 
	}); 
}

function CertificationInfo(){
	$("#form").attr("action", formURL + "/newcertification/" +id);
	$("#current").val("Certification");
	$.ajax({
		url:"/erp/rest/hr/certification",
		data:{m_id:id},
		dataType:"json",
		method:"get",
		success : function(data){
			if(data.length==undefined){
			var arr = [data]
			console.log(arr);
			data = arr;
			}
			let str ="";
			str += "<table border='1px solid black'><tr>";
			str += "<td>자격증</td><td>발급처</td><td>발급일</td></tr>";
			for(let i = 0 ; i <data.length ; i++){
			str += "<tr><td><input type='text' name='hct_name' class='detailInfo' value='"+data[i].hct_name+"' readonly ></td>"
			str += "<td><input type='text' name='hct_agency' class='detailInfo' value='"+data[i].hct_agency+"' readonly ></td>";
			str += "<td><input type='date' name='hct_date' class='detailInfo' value='"+data[i].hct_date+"' readonly></td>";
			str += "<input type='hidden' name='hct_num' value='"+data[i].hct_num+"'></td></tr>";
			}str += "</table>";
			$("#hrDetailInfo").html(str);
		},error : function(err){
			/* let str ="";
			str += "<table border='1px solid black'><tr>";
			str += "<td>자격증</td><td>발급처</td><td>발급일</td></tr>";
			str += "<tr><td><input type='text' name='hct_name' class='detailInfo'></td>"
			str += "<td><input type='text' name='hct_agency' class='detailInfo'></td>";
			str += "<td><input type='date' name='hct_date' class='detailInfo' required pattern='\d{4}-\d{2}-\d{2}'></td></tr>";
			str += "</table>";
			$("#hrDetailInfo").html(str); */
		} 
	}); 
}
function CareerInfo(){
	$("#form").attr("action", formURL + "/newcareer/" +id);
	$("#current").val("Career");
	$.ajax({
		url:"/erp/rest/hr/career",
		data:{m_id:id},
		dataType:"json",
		method:"get",
		success : function(data){
			console.log("안됨?");
			let str ="";
			str += "<table border='1px solid black'><tr>";
			str += "<td>회사/프로젝트명</td><td>기간</td><td>직책</td><td>내용</td></tr>";
			for(let i=0; i<data.length ; i++){
			str += "<tr><td><input type='text' name='hca_cname' class='detailInfo' value='"+data[i].hca_cname+"' readonly ></td>"
			str += "<td><input type='date' name='hca_period' id='chk"+(i*2)+"'class='detailInfo checkDate' value='"+data[i].hca_period+"' readonly ><br>"
			str += "<input type='date' name='hca_periodend' id='chk"+((i*2)+1)+"' class='detailInfo checkDate' value='"+data[i].hca_periodend+"' readonly onchange='checkDateValue(chk"+(i*2)+", chk"+((i*2)+1)+")'> </td>"
			str += "<td><input type='text' name='hca_position' class='detailInfo' value='"+data[i].hca_position+"' readonly ></td>";
			str += "<td><textarea rows='3' cols='20' name='hca_content' class='detailInfo' value='"+data[i].hca_content+"'></textarea>";
			str += "<input type='hidden' name='hca_num' value='"+data[i].hca_num+"'></td></tr>'";
			}
			str+="</table>";
			$("#hrDetailInfo").html(str);
			num=data.length;
		},error : function(err){
			/* let str ="";
			str += "<table border='1px solid black'><tr>";
			str += "<td>회사/프로젝트명</td><td>기간</td><td>직책</td><td>내용</td></tr>";
			str += "<tr><td><input type='text' name='hca_cname' class='detailInfo'></td>"
			str += "<td><input type='date' name='hca_period' class='detailInfo'></td>"
			str += "<td><input type='date' name='hca_periodend' class='detailInfo'></td>"
			str += "<td><input type='text' name='hca_position' class='detailInfo'></td>";
			str += "<td><textarea rows='3' cols='20' name='hca_content' class='detailInfo'></textarea></td></tr></table>";
			$("#hrDetailInfo").html(str); */
		} 
	}); 
}
function InCompanyInfo(){
	$("#form").attr("action", formURL + "/newhrcard/" +id);
	$("#current").val("HRCard");
	$.ajax({
		url:"/erp/rest/hr/hrcard",
		data:{m_id:id},
		dataType:"json",
		method:"get",
		success : function(data){
			console.log(data);
			var married ="";
			var status ="";
			var work="";
			if(data.hc_status==1){
				status="근무";
			}else if(data.hc_status==0){
				status="퇴근"
			}else{
				status="휴가";
			}
			if(data.hc_work==1){
				work="재직";
			}else if(data.hc_work==2){
				work="휴직";
			}else{
				work="퇴사";
			}
			let str ="";
			str += "<table border='1px solid black'><tr>";
			str += "<td>사원코드</td><td>부서</td><td>직책</td></tr>";
			str += "<tr><td><input type='text' name='hc_code' value='"+data.hc_code+"' readonly></td>"
			str += "<td><input type='text' name='hc_dept' value='"+data.hc_dept+"' class='detailInfo' readonly></td>"
			str += "<td><input type='text' name='hc_position' value='"+data.hc_position+"' class='detailInfo' readonly></td></tr>";
			str += "<td colspan='3'>입사일</td></tr>";
			str += "<td colspan='3'><input type='date' name='hc_joindate' value='"+data.hc_joindate+"' class='detailInfo' readonly></td>"
			str += "<tr><td>현재 상태</td><td>재/휴직 상태</td><td>사용한 월차</td></tr>";
			str += "<td><input type='text' value='"+status+"' readonly></td>"
			str += "<td><input type='text' value='"+work+"'readonly></td>"
			str += "<td><input type='text' value='"+data.hc_numholi+"' readonly></td></tr></table>";
			$("#hrDetailInfo").html(str);
		},error : function(err){
			console.log(err);
			let str ="";
			str += "<table border='1px solid black'><tr>";
			str += "<td>사원코드</td><td>부서</td><td>직책</td></tr>";
			str += "<tr><td><input type='text' name='hc_code' placeholder='---' readonly></td>"
			str += "<td><input type='text' name='hc_dept' class='detailInfo'></td>"
			str += "<td><input type='text' name='hc_position' class='detailInfo'></td></tr>";
			str += "<td colspan='3'>입사일</td></tr>";
			str += "<td colspan='3'><input type='date' name='hc_joindate' class='detailInfo'></td></tr>"
			str += "<tr><td>현재 상태</td><td>재/휴직 상태</td><td>사용한 월차</td></tr>";
			str += "<td><input type='text' placeholder='---' readonly></td>"
			str += "<td><input type='text' placeholder='---' readonly></td>"
			str += "<td><input type='text' placeholder='---' readonly></td></tr></table>";
			$("#hrDetailInfo").html(str);
		} 
	}); 
}
</script>
</body>
</html>
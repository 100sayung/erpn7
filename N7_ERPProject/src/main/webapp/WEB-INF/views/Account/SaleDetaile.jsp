<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<meta charset="UTF-8">
<title>매출매입 상세정보</title>
<style>
table{
width:1000px;
}
tr, td {
	border: 1px solid;
	text-align: center;
}

#saledetaile{
width:1000px;
}

</style>
</head>
<body>
	<div id="saledetaile">

<<<<<<< HEAD
		<table id="table">
=======
		<table>
>>>>>>> origin/JSJ
			<c:forEach var="sale" items="${sList1}">
				<tr>
					<td>전표번호</td>
					<td>${sale.s_num}</td>
					<td>유형</td>
					<td>${sale.s_kind}</td>
					<td>입력자</td>
					<td colspan="2">${sale.s_employee}</td>
				</tr>
				<tr>
					<td>거래처</td>
					<td>${sale.s_company}</td>
					<td>사업자번호</td>
					<td>${sale.s_comnum}</td>
					<td>입력날짜</td>
					<td colspan="2">${sale.s_date}</td>
				</tr>
			</c:forEach>
			<tr>
				<td>품목</td>
				<td>수량</td>
				<td>단가</td>
				<td>공급가액</td>
				<td>부가세액</td>
				<td>합계</td>
				<td>적요</td>
			</tr>
			<tbody id="detaile">

			</tbody>
			<tr>
				<td colspan="2">총합계</td>
				<td colspan="5" id="allprice"></td>
			</tr>
		</table>
	</div>

	<div id="grafe">
		<table id="grafeInfo" style="border: 1px solid;">
			<tr>
				<td style="width: 80%;" rowspan="4"><div style="width: 100%;"
						id="chart_div"></div></td>
				<td>품목명</td>
				<td id="pkind"></td>
			</tr>
			<tr>
				<td>년 평균 단가</td>
				<td id="yearprice">(원)</td>
			</tr>
			<tr>
				<td>월 평균 단가</td>
				<td id="monthprice">(원)</td>
			</tr>
			<tr>
				<td>년 평균 대비 단가비교</td>
				<td id="yearp">(원)</td>
			</tr>
		</table>

	</div>
</body>

<script>
var data = ${sList2};
var str="";
var allprice=0;
for(var i in data){
	str+="<tr><td onclick='getpkind(\""+data[i].s_pkind+"\")'>"+data[i].s_pkind+"</td>";
	str+="<td>"+data[i].s_cnt+"</td>";
	str+="<td>"+data[i].s_price+"</td>";
	str+="<td>"+data[i].s_price2+"</td>";
	str+="<td>"+data[i].s_tax+"</td>";
	str+="<td class='total'>"+data[i].s_total+"</td>";
	str+="<td>"+data[i].s_memo+"</td></tr>";
	
 allprice+=Number(data[i].s_total);
}
console.log(allprice);
 $("#allprice").html(allprice);
 $("#detaile").html(str);
 
 google.charts.load('current', {packages: ['corechart', 'bar']});
 google.charts.setOnLoadCallback(drawBasic);

 function drawBasic() {

       var data = new google.visualization.arrayToDataTable([
     	  ['월별','단가'],
     	  ['1월',0],
     	  ['2월',0],
     	  ['3월',0],
     	  ['4월',0],
     	  ['5월',0],
     	  ['6월',0],
     	  ['7월',0],
     	  ['8월',0],
     	  ['9월',0],
     	  ['10월',0],
     	  ['11월',0],
     	  ['12월',0],
       ]);
    var date = new Date();
  var year = date.getFullYear();

       var options = {
         title: '매출/매입 통계분석 차트('+year+')',
         hAxis: {
           title: '단가통계',
           format: 'yyyy-MM',
           gridlines:{count:12}
         },
         vAxis: {
           format: 'decimal',
         
         }
       };

       var chart = new google.visualization.ColumnChart(
         document.getElementById('chart_div'));

       chart.draw(data, options);
     };
     
     function getpkind(pkind) {
			var arr = new Array();
$.ajax({
	url:'/erp/rest/Account/getpkind',
	type:'post',
	data:{pkind:pkind},
	datatype:'json',
	success:function(data){
		console.log(data);
		var yearprice=0;

		for(var i in data.sList){
			console.log(i)
			arr.push(Number(data.sList[i].s_price));
			yearprice+=Number(data.sList[i].s_price);
			
		}
		
		console.log(yearprice);
		$("#pkind").html(data.sList[0].s_pkind);
		var ever=yearprice/12;
		console.log(ever)
		 var ever2=Math.floor(Number(ever));
		$("#yearprice").html(ever2+"(원)");
		google.charts.load('current', {packages: ['corechart', 'bar']});
		google.charts.setOnLoadCallback(drawBasic);

		function drawBasic() {

		      var data = new google.visualization.arrayToDataTable([
		    	 // for(var i=0; i<arr.length; i++){
		    		  
		    	  ['월별','단가'],
		    	  ['1월',arr[0]],
		    	  ['2월',arr[1]],
		    	  ['3월',arr[2]],
		    	  ['4월',arr[3]],
		    	  ['5월',arr[4]],
		    	  ['6월',arr[5]],
		    	  ['7월',arr[6]],
		    	  ['8월',arr[7]],
		    	  ['9월',arr[8]],
		    	  ['10월',arr[9]],
		    	  ['11월',arr[10]],
		    	  ['12월',arr[11]],
		    	//  }
		      ]);
		   
		 var date = new Date();
		 var year = date.getFullYear();

		      var options = {
		        title: '매출 통계분석 차트('+year+')',
		        hAxis: {
		          title: '단가통계',
		          format: 'yyyy-MM',
		          gridlines:{count:12}
		        },
		        vAxis: {
		          format: 'decimal',
		        
		        }
		      };

		      var chart = new google.visualization.ColumnChart(
		        document.getElementById('chart_div'));

		      chart.draw(data, options);
		    }

		
	},
	error:function(error){
		console.log(error);
	}
});
};
</script>
</html>
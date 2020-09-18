<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>Document</title>
    <link href="/erp/css/default.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <style>
        #header{
            width: 100%;
            height: 200px;
        }
        #side_menu{
            height: 100%;
            width: 250px;
            font-size: 20px;
            font-weight: bolder;
            float: left;
        }
        #side_menu #menuList{
            list-style: none;
            margin-top: 150px;
        }
        #side_menu #menuList li{
            margin: 20px;
        }
        a{
            text-decoration: none;
        }
        #description{
            float: left;
            height: 100%;
            width: 1300px;
        }
    </style>
</head>
<body>
    <div id="header">
        <div id="logo">
            <h1><a href="#">N7 ERP SYSTEM</a></h1>
        </div>
        <div id="menu">
            <ul id="mainmenu">
              
            </ul>
        </div>
    </div>
    <div id="side_menu">
        <ul id="menuList">
            <li><a href="#" id="acountting">매츌/매입전표 작성</a></li>
            <li><a href="">분개전표입력</a></li>
        </ul>
    </div>
    <center>
    <div id="description">

    </div>
    </center>
</body>
<script>
$(document).ready(function(){
	$.ajax({
		url:'/erp/rest/managermode/getaddmenu',
		type:'get',
		datatype:'json',
		success:function(data){
			console.log(data);
			var str="";
			
			for(var i in data.mList){
				str+="<li><a id="+data.mList[i].f_functions+" onclick=menu('"+data.mList[i].f_functions+"')>"+data.mList[i].f_functions+"</a></li>";
			}
			
			$("#mainmenu").html(str);
		},
		error:function(error){
			console.log(error);
		}
		
	});
	
});

function menu(menu){
	console.log(menu);
	
	if(menu=="인사관리"){
		$("#"+menu).attr("href","/erp/myInfo/myInfo");	
		}else if(menu=="영업관리"){
		$("#"+menu).attr("href","");	
		}else if(menu=="구매관리"){
		$("#"+menu).attr("href","");	
		}else if(menu=="재고관리"){
		$("#"+menu).attr("href","");	
		}else if(menu=="회계관리"){
		$("#"+menu).attr("href","/erp/Account/acerp");	
		}
}


$("#acountting").click(function(){
	$.ajax({
		url:'/erp/Account/openTable',
		type:'get',
		success:function(data){
			$("#description").html(data);
		},
		error:function(){
			
		}
	});
	
});
</script>
</html>
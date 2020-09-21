<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1 user-scalable=no">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,700'
	rel='stylesheet' type='text/css'>

<script src="/erp/lib/jquery/jquery.min.js"></script>
<script src="/erp/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/erp/lib/php-mail-form/validate.js"></script>
<script src="/erp/lib/easing/easing.min.js"></script>

<!-- Template Main Javascript File -->
<script src="resources/js/main.js"></script>

<title>회사소개</title>

<style>
#container {
	border-bottom: gray 1px solid;
	border-top: gray 1px solid;
	line-height: 50px;
}

.list {
	float: left;
	padding: 30px;
}

.subNavBtn {
	width: 27%;
}

table, tr, td {
	border: 1px black solid;
}

#info {
	padding: 0 0 0 26%;
}
.wrap{
height:1000px;
}
.erpimg{
float: left;
width:300px;
height:450px;
margin-left: 6%;
}
.img{
width:300px;
height: 400px;

}
header{
padding-left: 300px;
}

#logo2{
width:50%;
position: absolute; 
left:25%;
top: 47%
}
.clearfix{
height: 700px;
}
</style>
</head>
<body data-spy="scroll" data-offset="58" data-target="#navbar-main">


  <div id="navbar-main">
    <!-- Fixed navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon icon-shield" style="font-size:30px; color:#3498db;"></span>
          </button>
          <a class="navbar-brand hidden-xs hidden-sm smoothscroll" href="#home"></a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="#home" class="smoothscroll">인사말</a></li>
            <li> <a href="#about" class="smoothscroll"> 회사소개</a></li>
            <li> <a href="#services" class="smoothscroll">회사기술</a></li>
            <li> <a href="#team" class="smoothscroll"> 오시는길</a></li>
            </ul>
        </div>
      </div>
    </div>
  </div>

  <!-- ==== HEADERWRAP ==== -->
  <div id="home"></div>
  <div id="headerwrap" name="home">
    <header class="clearfix">
      <h1>인사말
				</h1>
				<span> <br>최첨단 기술과 최고의 전문 인력으로 고객에게 최상의 결과물을 제공하는 IT기업,
					<span style="color: #FFB2D9">N7 ERP</span>입니다!</span>
				<p>ERP의 최신 기술을 경험해 보세요!</p>
				<span>눈앞에 물질보다 정보의 가치가 더 커진 요즘 고객들의 소중한 정보를 지키기 위해 보안 메일 솔루션을<br>
				구축하여 고객에게 안전한 업무 환경을 제공하고 있으며, 기업 관리 시스템 구축으로 보다 효율적으로 사업을 <br>
				진행할 수 있도록 도와드리고 있습니다.<br>
                              그 외에도 홈페이지 구축, 그룹웨어 등 기업에서 필요로 하는 많은 기술을 제공할 수 있는 기업이 되었습니다.</span>
                              <br><img src="/erp/img/logo.png" id="logo2">
    </header>
  </div>

  <!-- ==== ABOUT ==== -->
  <div class="container" id="about" name="about">
    <div class="row white">
      <br>
      <h1 class="centered">회사소개</h1>
      <hr>

      <div class="col-lg-6">
        <p><img src="img/companyimg.png" style="width:190%; height: 500px;"></p>
      </div>
    </div>
  </div>
<hr>
  <!-- ==== SERVICES ==== -->
  <div class="container" id="services" name="services">
    <br>
    <br>
    <div class="row">
      <h2 class="centered">회사기술</h2>
      <hr>
      <br>
                <div class="erpimg">
                <table>
                <tr><td><img class="img" src="img/erp1.png" alt="최고의 기술로 가치를 창조하고"></td></tr>
                <tr><td><span> 좋은 ERP로 최고의 기술의 가치를 창조하고</span></td></tr>
                </table>
                </div>

                <div class="erpimg">
                <table>
                <tr><td><img class="img" src="img/erp2.jpg" alt="혁신적인 기술로 시장을 선도하며"></td></tr>
                <tr><td><span>혁신적인 기술로 시장을 선도하며</span></td></tr>
                </table>
                </div>

                <div>
                <table class="erpimg">
                <tr><td><img class="img" src="img/erp3.jpg" alt="항상 고객을 최우선으로 생각하는 기업"></td></tr>
                <tr><td><span>항상 고객을 최우선으로 생각하는 기업</span></td></tr>
                </table>
                </div>
    </div>

  </div>
<hr>

  <!-- ==== SECTION DIVIDER2 -->
  <section class="section-divider textdivider divider2">
    <div class="container">

    </div>
    <!-- container -->
  </section>
  <!-- section -->

  <!-- ==== TEAM MEMBERS ==== -->
  <div class="container" id="team" name="team">
    <br>
    <div class="row white centered">
      <h1>오시는길</h1>
				<div id="info">
					<table>
						<tr>
							<td>회사이름</td>
							<td>달콤살벌한 SELECT</td>
						</tr>
						<tr>
							<td>회사전화번호</td>
							<td>010-6851-4495</td>
						</tr>
						<tr>
							<td>회사주소</td>
							<td>인천 미추홀구 매소홀로488번길 6-32 태승빌딩 4층</td>
						</tr>
					</table>
				</div>
				<div id="map"
					style="width: 600px; border: 1px solid black; height: 400px; margin: 20px auto; display: block;"></div>

			</div>
      </div>


</body>
<script type="text/javascript">

	var map = null;

	function initMap() {
		map = new naver.maps.Map('map', {
			center : new naver.maps.LatLng(37.438891, 126.675119),
			zoom : 15,
			mapTypeControl : true,
			zoomControl : true,
			zoomControlOptions : {
				position : naver.maps.Position.TOP_RIGHT
			}
		});
		var marker = new naver.maps.Marker({
			position : new naver.maps.LatLng(37.438891, 126.675119),
			map : map
		});
	}
</script>
</html>

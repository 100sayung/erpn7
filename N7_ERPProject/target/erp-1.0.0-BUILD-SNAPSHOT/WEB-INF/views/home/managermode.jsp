<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/publish/assets/css/bootstrap.css" rel="stylesheet">
<link href="/publish/assets/css/docs.css" rel="stylesheet">
<link href="/publish/assets/js/google-code-prettify/prettify.css" rel="stylesheet">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="/publish/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="/publish/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="/publish/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="/publish/assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="/publish/assets/ico/favicon.png"><!-- /부트스트랩3 관련 -->
<meta charset="UTF-8">


<!-- 부트스트랩3 관련 -->
<script src="/publish/assets/js/jquery.js"></script>
<script src="/erp/js/bootstrap.js"></script>
<script src="/publish/assets/js/bootstrap-alert.js"></script>
<script src="/publish/assets/js/bootstrap-modal.js"></script>
<script src="/publish/assets/js/bootstrap-dropdown.js"></script>
<script src="/publish/assets/js/bootstrap-scrollspy.js"></script>
<script src="/publish/assets/js/bootstrap-tab.js"></script>
<script src="/publish/assets/js/bootstrap-tooltip.js"></script>
<script src="/publish/assets/js/bootstrap-popover.js"></script>
<script src="/publish/assets/js/bootstrap-button.js"></script>
<script src="/publish/assets/js/bootstrap-collapse.js"></script>
<script src="/publish/assets/js/bootstrap-carousel.js"></script>
<script src="/publish/assets/js/bootstrap-typeahead.js"></script>
<script src="/publish/assets/js/bootstrap-affix.js"></script>
<script src="/publish/assets/js/application.js"></script><!-- /부트스트랩3 관련 -->
<script src="/publish/assets/js/holder/holder.js"></script>
<script src="/publish/assets/js/google-code-prettify/prettify.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="navbar navbar-fixed-top navbar-inverse">
 <!-- 컨테이너 -->
 <div class="container">
  <a class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse" href="#">
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
  </a>
  <a class="navbar-brand" href="{geturl('')}" id="siteTitle">
   <img src="siteTitle.png" alt="XpressEngine" cond="!Context::getSiteTitle() && !$layout_info->LOGO_IMG && !$layout_info->LOGO_TEXT">
   <block cond="Context::getSiteTitle() && !$layout_info->LOGO_IMG && !$layout_info->LOGO_TEXT">{Context::getSiteTitle()}</block>
   <img src="{$layout_info->LOGO_IMG}" alt="{$layout_info->LOGO_TEXT}" cond="$layout_info->LOGO_IMG">
   <block cond="!$layout_info->LOGO_IMG && $layout_info->LOGO_TEXT">{$layout_info->LOGO_TEXT}</block>
  </a>
  <div class="nav-collapse collapse">
    <ul class="nav">
      <li class="dropdown"|cond="$val1['list']" loop="$GNB->list=>$key1,$val1" class="active"|cond="$val1['selected']">
   <a class="dropdown-toggle"|cond="$val1['list']" data-toggle="dropdown"|cond="$val1['list']" href="{$val1['href']}" target="_blank"|cond="$val1['open_window']=='Y'">
   {$val1['link']}<b class="caret" cond="$val1['list']"></b>
   </a>
   <ul cond="$val1['list']" class="dropdown-menu">
    <li loop="$val1['list']=>$key2,$val2" class="active"|cond="$val2['selected']">
    <a href="{$val2['href']}" target="_blank"|cond="$val2['open_window']=='Y'">{$val2['link']}</a>
    </li>
   </ul>
      </li>
    </ul>
    <ul class="nav user-right">
      <!--@if($is_logged)-->
       <li><a href="{getUrl('act','dispMemberLogout')}">로그아웃</a></li>
       <!--@if($logged_info->is_admin)-->
       <li><a href="{getUrl('','mid','admin')}">관리</a></li>
       <!--@end-->
      <!--@else-->
       <li><a href="{getUrl('','mid','loginPage','act','dispMemberLoginForm')}">로그인</a></li><!--{getUrl('','mid','loginPage')}-->
      <!--@end-->
    </ul>
    <form class="navbar-form" role="search">
   <div class="input-group">
   <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
   <div class="input-group-btn">
   <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
   </div>
   </div>
    </form>
  </div><!-- /.nav-collapse -->
 </div><!-- /컨테이너 -->
</div><!-- /상단 네비 -->

{@ $_is_indexmodule = ($site_module_info->module_srl === $current_module_info->module_srl)}
<!-- XE엔진에서 {@ 구문 } 은 <?php 구문 ?> 으로 해석됨 -->
<!--@if($_is_indexmodule)-->
<!-- 메인 비주얼 -->
<div id="myCarousel" class="carousel slide">
 <ol class="carousel-indicators">
   <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
   <li data-target="#myCarousel" data-slide-to="1"></li>
   <li data-target="#myCarousel" data-slide-to="2"></li>
 </ol>
 <div class="carousel-inner">
   <div class="item active">
     <a href="#" title="링크1">
     <img src="/publish/assets/img/examples/slide-01.jpg" alt="">
     </a>
   </div>
   <div class="item">
     <a href="#" title="링크2">
     <img src="/publish/assets/img/examples/slide-02.jpg" alt="">
     </a>
   </div>
   <div class="item">
     <a href="#" title="링크3">
     <img src="/publish/assets/img/examples/slide-03.jpg" alt="">
     </a>
   </div>
 </div>
 <a class="left carousel-control" href="#myCarousel" data-slide="prev">
   <span class="glyphicon glyphicon-chevron-left"></span>
 </a>
 <a class="right carousel-control" href="#myCarousel" data-slide="next">
   <span class="glyphicon glyphicon-chevron-right"></span>
 </a>
</div><!-- /메인 비주얼 -->
<!--@else-->
<!-- 서브 비주얼 -->
<header class="bs-docs-jumbotron subhead">
 <div class="container">
 <h1 loop="$GNB->list=>$key1,$val1" cond="$val1['selected']">{$val1['link']}</h1>
 <p class="lead">Overview of the project, its contents, and how to get started with a simple template.</p>
 </div>
</header><!-- /서브 비주얼 -->
<!--@end-->

<!-- 컨테이너_본문 -->
<div class="container">
<!--@if($_is_indexmodule)-->
 {$content}
<!--@else-->
 <div class="row">
  <!-- 왼쪽메뉴 -->
  <div class="span3 bs-docs-sidebar">
   <!-- LNB -->
   <h1 loop="$GNB->list=>$key1,$val1" cond="$val1['selected']"><a href="{$val1['href']}" target="_blank"|cond="$val1['open_window']=='Y'">{$val1['link']}</a></h1>
   <ul class="nav nav-list bs-docs-sidenav" loop="$GNB->list=>$key1,$val1" cond="$val1['selected'] && $val1['list']">
    <li loop="$val1['list']=>$key2,$val2" class="active"|cond="$val2['selected']"><a href="{$val2['href']}" target="_blank"|cond="$val2['open_window']=='Y'">{$val2['link']}</a>
     <ul cond="$val2['list']">
      <li loop="$val2['list']=>$key3,$val3" class="active"|cond="$val3['selected']"><a href="{$val3['href']}" target="_blank"|cond="$val3['open_window']=='Y'">{$val3['link']}</a></li>
     </ul>
    </li>
   </ul>
   <!-- /LNB -->
  </div><!-- /왼쪽메뉴 -->
  <div class="span9">
  {$content}
  </div>
 </div>
<!--@end-->
</div><!-- /컨테이너_본문 -->
 
<!-- 컨테이너_푸터 -->
<div class="container">
     <p>Powered by <a href="http://xpressengine.com/">XE</a>.</p>
</div><!-- /컨테이너_푸터 -->


<!--[if lt IE 9]>
<script src="/publish/assets/js/respond/respond.min.js"></script>
<![endif]-->


</body>
</html>
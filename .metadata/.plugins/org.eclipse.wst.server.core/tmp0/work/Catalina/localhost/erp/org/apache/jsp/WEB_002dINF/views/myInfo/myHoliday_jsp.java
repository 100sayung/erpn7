/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-09-18 05:54:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.myInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myHoliday_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/J:/erpn7/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/erp2/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1595218327510L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Document</title>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<link href=\"/erp/css/default.css\" rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\tmedia=\"all\" />\r\n");
      out.write("<style>\r\n");
      out.write("#header {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 200px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#side_menu {\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tfont-weight: bolder;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tborder-right:1px solid #E6E6E6;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#side_menu #menuList {\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("\tmargin-top: 150px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#side_menu #menuList li {\r\n");
      out.write("\tmargin: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#description {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul {\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("}\r\n");
      out.write(".attendance{\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("}\r\n");
      out.write("table{\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("table, th, td{\r\n");
      out.write("\tborder-bottom : 1px solid balck;\r\n");
      out.write("\tborder-top : 1px solid black;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("}\r\n");
      out.write("#calendar td{\r\n");
      out.write("\twidth:30px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"build();\">\r\n");
      out.write("\t<div id=\"header\">\r\n");
      out.write("\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t<h1>\r\n");
      out.write("\t\t\t\t<a href=\"#\">N7 ERP SYSTEM</a>\r\n");
      out.write("\t\t\t</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li class=\"current_page_item\"><a href=\"/erp/myInfo/myInfo\" accesskey=\"4\" title=\"\">내 정보</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/erp/hr/hr\" accesskey=\"2\"\r\n");
      out.write("\t\t\t\t\ttitle=\"\">인사 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\" accesskey=\"3\" title=\"\">영업 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\" accesskey=\"5\" title=\"\">구매 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\" accesskey=\"6\" title=\"\">자재 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">회계 관리</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"side_menu\">\r\n");
      out.write("\t\t<ul id=\"menuList\">\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/checkattendance\">출/퇴근 등록</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/myinfo\">내 정보 보기</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/myPaycheck\">급여명세서 보기</li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/myattendance\">내 출결 보기</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/myholiday\">내 휴가 보기</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/applyholiday\">휴가신청</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/mydocument\">나의 결재함</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"description\">\r\n");
      out.write("\t크게만들기\r\n");
      out.write("\t\r\n");
      out.write("\t\t<table align=\"center\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td style=\"width : 100px;\"><font color=\"#B3B6B3\"><label\r\n");
      out.write("\t\t\t\t\t\tonclick=\"beforem()\" id=\"before\"></label></font></td>\r\n");
      out.write("\t\t\t\t<td style=\"width : 150px; font-size: 15px;\" align=\"center\" id=\"yearmonth\" style=\"font-size: 15px;\"></td>\r\n");
      out.write("\t\t\t\t<td style=\"width : 100px;\"><font color=\"#B3B6B3\"><label\r\n");
      out.write("\t\t\t\t\t\tonclick=\"nextm()\" id=\"next\"></label></font></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<table align=\"center\" id=\"calendar\">\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div id=\"container\"></div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tvar str = \"\";\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\t//이 아래로 달력\r\n");
      out.write("\t\tvar today = new Date(); // 오늘 날짜\r\n");
      out.write("\t\tvar date = new Date();\r\n");
      out.write("\r\n");
      out.write("\t\tfunction beforem() //이전 달을 today에 값을 저장\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\ttoday = new Date(today.getFullYear(), today.getMonth() - 1, today\r\n");
      out.write("\t\t\t\t\t.getDate());\r\n");
      out.write("\t\t\tbuild(); //만들기\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction nextm() //다음 달을 today에 저장\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\ttoday = new Date(today.getFullYear(), today.getMonth() + 1, today\r\n");
      out.write("\t\t\t\t\t.getDate());\r\n");
      out.write("\t\t\tbuild();\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction build() {\r\n");
      out.write("\t\t\tvar nMonth = new Date(today.getFullYear(), today.getMonth(), 1); //현재달의 첫째 날\r\n");
      out.write("\t\t\tvar lastDate = new Date(today.getFullYear(), today.getMonth() + 1,\r\n");
      out.write("\t\t\t\t\t0); //현재 달의 마지막 날\r\n");
      out.write("\t\t\tvar tbcal = document.getElementById(\"calendar\"); // 테이블 달력을 만들 테이블\r\n");
      out.write("\t\t\tvar yearmonth = document.getElementById(\"yearmonth\"); //  년도와 월 출력할곳\r\n");
      out.write("\t\t\tyearmonth.innerHTML = today.getFullYear() + \"년 \"\r\n");
      out.write("\t\t\t\t\t+ (today.getMonth() + 1) + \"월\"; //년도와 월 출력\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (today.getMonth() + 1 == 12) //  눌렀을 때 월이 넘어가는 곳\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tbefore.innerHTML = (today.getMonth()) + \"월\";\r\n");
      out.write("\t\t\t\tnext.innerHTML = \"1월\";\r\n");
      out.write("\t\t\t} else if (today.getMonth() + 1 == 1) //  1월 일 때\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tbefore.innerHTML = \"12월\";\r\n");
      out.write("\t\t\t\tnext.innerHTML = (today.getMonth() + 2) + \"월\";\r\n");
      out.write("\t\t\t} else //   12월 일 때\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tbefore.innerHTML = (today.getMonth()) + \"월\";\r\n");
      out.write("\t\t\t\tnext.innerHTML = (today.getMonth() + 2) + \"월\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t        // 남은 테이블 줄 삭제\r\n");
      out.write("\t        while (tbcal.rows.length > 0) \r\n");
      out.write("\t        {\r\n");
      out.write("\t            tbcal.deleteRow(tbcal.rows.length - 1);\r\n");
      out.write("\t        }\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar row = null;\r\n");
      out.write("\t\t\trow = tbcal.insertRow();\t\r\n");
      out.write("\t\t\tvar cnt = 0;\r\n");
      out.write("\t\t\t// 달력 출력\r\n");
      out.write("\t\t\tfor (i = 1; i <= lastDate.getDate(); i++) // 1일부터 마지막 일까지\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tcell = row.insertCell();\r\n");
      out.write("\t\t\t\tcell.style.width=\"30px;\";\r\n");
      out.write("\t\t\t\tcell.innerHTML = \"<span id=\"+i+\"><a href='javascript:checkMyAt(\"\r\n");
      out.write("\t\t\t\t\t\t+ i + \")'>\" + i + \"</a></span>\";\r\n");
      out.write("\t\t\t\tcnt = cnt + 1;\r\n");
      out.write("\t\t\t\tif (cnt % 7 == 1) {//일요일 계산\r\n");
      out.write("\t\t\t\t\tcell.innerHTML = \"<span id=\"+i+\"><a href='javascript:checkMyAt(\"\r\n");
      out.write("\t\t\t\t\t\t\t+ i\r\n");
      out.write("\t\t\t\t\t\t\t+ \")'><font color=#FF9090>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ i\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</font></a></span>\";//일요일에 색\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (cnt % 7 == 0) { // 1주일이 7일 이므로 토요일 계산\r\n");
      out.write("\t\t\t\t\tcell.innerHTML = \"<span id=\"+i+\"><a href='javascript:checkMyAt(\"\r\n");
      out.write("\t\t\t\t\t\t\t+ i\r\n");
      out.write("\t\t\t\t\t\t\t+ \")'><font color=#7ED5E4>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ i\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</font></a></span>\";//토요일에 색\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (today.getFullYear() == date.getFullYear()\r\n");
      out.write("\t\t\t\t\t\t&& today.getMonth() == date.getMonth()\r\n");
      out.write("\t\t\t\t\t\t&& i == date.getDate()) {\r\n");
      out.write("\t\t\t\t\tcell.bgColor = \"#BCF1B1\"; //오늘날짜배경색\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"/erp/rest/hr/employeeholiday\",\r\n");
      out.write("\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\tyearmonth : $(\"#yearmonth\").html()\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\tconsole.log($(\"#yearmonth\").html());\r\n");
      out.write("\t\t\t\t\tvar month = $(\"#yearmonth\").html().split(\"월\");\r\n");
      out.write("\t\t\t\t\tmonth = month[0].split(\" \");\r\n");
      out.write("\t\t\t\t\tvar year = month[0].substr(0, 4);\r\n");
      out.write("\t\t\t\t\tmonth = month[1];\r\n");
      out.write("\t\t\t\t\tif (month < 10) {\r\n");
      out.write("\t\t\t\t\t\tmonth = \"0\" + month;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\trow = calendar.insertRow();\r\n");
      out.write("\t\t\t\t\tfor (let k = 0; k < data.length; k++) {\r\n");
      out.write("\t\t\t\t\t\tlet startarr = data[k].hap_startday.split(\"-\");\r\n");
      out.write("\t\t\t\t\t\tlet startday = \"\";\r\n");
      out.write("\t\t\t\t\t\tfor (let sa = 0; sa < startarr.length; sa++) {\r\n");
      out.write("\t\t\t\t\t\t\tstartday += startarr[sa];\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tlet endarr = data[k].hap_endday.split(\"-\");\r\n");
      out.write("\t\t\t\t\t\tlet endday = \"\";\r\n");
      out.write("\t\t\t\t\t\tfor (let sa = 0; sa < endarr.length; sa++) {\r\n");
      out.write("\t\t\t\t\t\t\tendday += endarr[sa];\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tconsole.log(startday, endday);\r\n");
      out.write("\t\t\t\t\t\tfor (let j = 0; j < cnt + 1; j++) {\r\n");
      out.write("\t\t\t\t\t\t\tcell = row.insertCell();\r\n");
      out.write("\t\t\t\t\t\t\tlet day = j + 1;\r\n");
      out.write("\t\t\t\t\t\t\tif (day < 10) {\r\n");
      out.write("\t\t\t\t\t\t\t\tday = \"0\" + day;\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\tlet date = \"\" + year + month + day;\r\n");
      out.write("\t\t\t\t\t\t\tif (startday == date) {\r\n");
      out.write("\t\t\t\t\t\t\t\tcell.innerHTML = \"<--\";\r\n");
      out.write("\t\t\t\t\t\t\t} else if (endday == date) {\r\n");
      out.write("\t\t\t\t\t\t\t\tcell.innerHTML = \"-->\";\r\n");
      out.write("\t\t\t\t\t\t\t} else if (startday < date && date < endday) {\r\n");
      out.write("\t\t\t\t\t\t\t\tif(j!=cnt){\r\n");
      out.write("\t\t\t\t\t\t\t\t\tcell.innerHTML = \"---\";\r\n");
      out.write("\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\tcell.innerHTML = data[k].m_name;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tcell.style.width=\"90px;\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\tcell.className=\"last\"\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t} else if (j == cnt) {\r\n");
      out.write("\t\t\t\t\t\t\t\tcell.innerHTML = data[k].m_name;\r\n");
      out.write("\t\t\t\t\t\t\t\tcell.style.width=\"90px;\";\r\n");
      out.write("\t\t\t\t\t\t\t\tcell.clssName=\"last\"\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\tcell.innerHTML = \"\";\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tdesignThis(cell);\r\n");
      out.write("\t\t\t\t\t\trow = calendar.insertRow();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tstr\r\n");
      out.write("\t\t\t\t\t...............................................................................................................................................................................................................................\t= data[0].hap_type;\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(err) {\r\n");
      out.write("\t\t\t\t\tconsole.log(err);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction designThis(cell){\r\n");
      out.write("\t\t\tconsole.log(cell);\r\n");
      out.write("\t\t\tcell.style.width = \"100px\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#showMenu1\").hover(function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu1\").attr(\"style\", \"display:inline-block\");\r\n");
      out.write("\t\t}, function() {\r\n");
      out.write("\t\t\tconsole.log(str);\r\n");
      out.write("\t\t\t$(\"#smallMenu1\").attr(\"style\", \"display:none\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#showMenu2\").hover(function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu2\").attr(\"style\", \"display:inline-block\");\r\n");
      out.write("\t\t}, function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu2\").attr(\"style\", \"display:none\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#showMenu3\").hover(function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu3\").attr(\"style\", \"display:inline-block\");\r\n");
      out.write("\t\t}, function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu3\").attr(\"style\", \"display:none\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

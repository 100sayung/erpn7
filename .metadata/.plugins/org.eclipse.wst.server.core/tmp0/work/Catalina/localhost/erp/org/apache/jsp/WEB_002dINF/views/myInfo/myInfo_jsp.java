/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-09-18 06:30:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.myInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/J:/erpn7/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/N7_ERPProject/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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
      out.write("\twidth: 800px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul {\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("}\r\n");
      out.write(".attendance{\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
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
      out.write("\t\t\t\t<li><a href=\"/erp/stock/setcategory\" accesskey=\"6\" title=\"\">자재 관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/erp/Account/acerp\">회계 관리</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"side_menu\">\r\n");
      out.write("\t\t<ul id=\"menuList\">\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/checkattendance\">출/퇴근 등록</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/myinfo\">내 정보 보기</li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/myPaycheck\">급여명세서 보기</li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/myattendance\">내 출결 보기</li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/myholiday\">내 휴가 보기</li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/applyholiday\">휴가신청</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/erp/myinfo/mydocument\">나의 결재함</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("<div id=\"description\">\r\n");
      out.write("<h1>CSS 테이블 만들기 정리하기</h1>\r\n");
      out.write("<h1>인사카드 세부정보 / 수정</h1>\r\n");
      out.write("<div id=\"member\"></div>\r\n");
      out.write("\r\n");
      out.write("<br><br><br>\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("<div id=\"hrmenu\"></div>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<form id=\"form\" method=\"post\">\r\n");
      out.write("<div id=\"hrDetailInfo\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border='1px solid black'>\r\n");
      out.write("<div id=\"addRecord\"></div>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<input type='hidden' value='' id='current'>\r\n");
      out.write("<input type='button' value='추가하기' onclick='addRecord()' id='addRecordBtn'>\r\n");
      out.write("<br>\r\n");
      out.write("<input type='button' value='수정하기' onclick='changeMode()' id='changeBtn'>\r\n");
      out.write("<input type='submit' value='등록하기' disabled=\"disabled\" id='registBtn'>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("  \t  $(function(){\r\n");
      out.write("  \t      var responseMessage = \"");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("\";\r\n");
      out.write("  \t      if (responseMessage != \"\"){\r\n");
      out.write("            alert(responseMessage)\r\n");
      out.write("   \t     }\r\n");
      out.write(" \t  });\r\n");
      out.write("\t\tvar num;\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"/erp/rest/myinfo/myinfo\",\r\n");
      out.write("\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\tmethod:\"get\",\r\n");
      out.write("\t\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\tlet info = \"\";\r\n");
      out.write("\t\t\t\t\tinfo += '<span style=\"height:200px;\"><img src=\"/erp/upload/'+data.photo+'\"></span>&nbsp;'\r\n");
      out.write("\t\t\t\t\tinfo += '<span style=\"height:200px;\"><table style=\"width:500px\"><tr class=\"info\"><td id=\"m_name\">'+data.name+'</td><td id=\"m_gender\">'+data.m_gender+'</td></tr>';\r\n");
      out.write("\t\t\t\t\tinfo += '<tr class=\"info\"><td id=\"m_phonenum\">'+data.phonenum+'</td><td id=\"m_birth\">'+data.birth+'</td></tr>';\r\n");
      out.write("\t\t\t\t\tinfo += '<tr style=\"height:80px;\"><td id=\"m_address\" colspan=\"2\">'+data.address+'</td></tr></table></span>';\r\n");
      out.write("\t\t\t\t\t$(\"#member\").html(info);\r\n");
      out.write("\t\t\t\t}, error : function(err){\r\n");
      out.write("\t\t\t\t\tconsole.log(err);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"/erp/rest/myinfo/hrexistfromid\",\r\n");
      out.write("\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\tmethod:\"get\",\r\n");
      out.write("\t\t\t\tcontentType: 'application/json',\r\n");
      out.write("\t\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\t\tlet str=\"\";\r\n");
      out.write("\t\t\t\t\tstr+='<tr><td><a href=\"javascript:InCompanyInfo()\"> 사내정보 </a></td>';\r\n");
      out.write("\t\t\t\t\tif(data){\r\n");
      out.write("\t\t\t\t\t\tstr +='<td><a href=\"javascript:AcademicInfo()\"> 학력 </a></td>';\r\n");
      out.write("\t\t\t\t\t\tstr +='<td><a href=\"javascript:CareerInfo() \"> 이력 </a></td>';\r\n");
      out.write("\t\t\t\t\t\tstr +='<td><a href=\"javascript:CertificationInfo()\"> 자격증 </a></td>';\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tstr+='</tr>';\r\n");
      out.write("\t\t\t\t\t$(\"#hrmenu\").html(str);\r\n");
      out.write("\t\t\t\t}, error : function(err){\r\n");
      out.write("\t\t\t\t\tconsole.log(err);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tconsole.log(\"load\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tfunction replaceAll(str, searchStr, replaceStr) {\r\n");
      out.write("\t\t    return str.split(searchStr).join(replaceStr);\r\n");
      out.write("\t\t }\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkDateValue(val1, val2){\r\n");
      out.write("\t\t\tlet date1 = Number(replaceAll(val1.value, \"-\", \"\"));\r\n");
      out.write("\t\t\tlet date2 = Number(replaceAll(val2.value, \"-\", \"\"));\r\n");
      out.write("\t\t\tif(date1>date2){\r\n");
      out.write("\t\t\t\talert(\"종료일은 시작일보다 이전일 수 없습니다.\");\r\n");
      out.write("\t\t\t\tval2.value = \"\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction addRecord(){\r\n");
      out.write("\t\t\tlet str =\"\";\r\n");
      out.write("\t\t\tlet cntAc = 0;\r\n");
      out.write("\t\t\tlet cntCt = 0;\r\n");
      out.write("\t\t\tvar $current = $(\"#current\").val();\r\n");
      out.write("\t\t\tconsole.log(num);\r\n");
      out.write("\t\t\tif($current == 'Academic'){\r\n");
      out.write("\t\t\t\tstr += \"<tr id='test'><td><input type='text' name='hac_school' class='detailInfo'></td>\";\r\n");
      out.write("\t\t\t\tstr += \"<td><input type='text' name='hac_major' class='detailInfo'></td>\";\r\n");
      out.write("\t\t\t\tstr += \"<td><input type='date' name='hac_year' class='detailInfo'></td>\";\r\n");
      out.write("\t\t\t\tstr += \"<td><input type='button' value='삭제' onclick='javascript:thisRowDel(this);'></td></tr>\";\r\n");
      out.write("\t\t\t}else if($current =='Certification'){\r\n");
      out.write("\t\t\t\tstr += \"<tr><td><input type='text' name='hct_name' class='detailInfo'></td>\";\r\n");
      out.write("\t\t\t\tstr += \"<td><input type='text' name='hct_agency' class='detailInfo'></td>\";\r\n");
      out.write("\t\t\t\tstr += \"<td><input type='date' name='hct_date' class='detailInfo'></td>\"\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='button' value='삭제' onclick='javascript:thisRowDel(this);'></td></tr>\";\r\n");
      out.write("\t\t\t}else if($current =='Career'){\r\n");
      out.write("\t\t\t\tstr += \"<tr><td><input type='text' name='hcr_cname' class='detailInfo'></td>\";\r\n");
      out.write("\t\t\t\tstr += \"<td><input type='date' name='hcr_startperiod' id='chk\"+(num*2)+\"' class='detailInfo checkDate'><br>\";\r\n");
      out.write("\t\t\t\tstr += \"<input type='date' name='hcr_endperiod' id='chk\"+((num*2)+1)+\"' class='detailInfo checkDate' onchange='checkDateValue(chk\"+(num*2)+\", chk\"+((num*2)+1)+\")'></td>\"\r\n");
      out.write("\t\t\t\tstr += \"<td><input type='text' name='hcr_position' class='detailInfo'></td>\";\r\n");
      out.write("\t\t\t\tstr += \"<td><textarea rows='3' cols='20' name='hcr_content' class='detailInfo'></textarea></td>\"\r\n");
      out.write("\t\t\t\tstr += \"<td><input type='button' value='삭제' onclick='javascript:thisRowDel(this);'></td></tr>\";\r\n");
      out.write("\t\t\t\tnum++;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\"#hrDetailInfo\").append(str);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction thisRowDel(row){\r\n");
      out.write("\t\t\tconsole.log(row);\r\n");
      out.write("\t\t\tlet tr = row.parentNode.parentNode;\r\n");
      out.write("\t\t\ttr.parentNode.removeChild(tr);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction changeMode(){\r\n");
      out.write("\t\t\tconsole.log($(\"#changeBtn\").attr('class'));\r\n");
      out.write("\t\t\tif($(\"#changeBtn\").attr('class')==\"mf\"){\r\n");
      out.write("\t\t\t\t$(\".detailInfo\").attr(\"readonly\", true).addClass(\"modifyMode\").removeClass(\"registMode\");\r\n");
      out.write("\t\t\t\t$(\"#registBtn\").attr(\"disabled\", false);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$(\".detailInfo\").removeAttr(\"readonly\").removeClass(\"modifyMode\").addClass(\"registMode\");\r\n");
      out.write("\t\t\t\t$(\"#registBtn\").attr(\"disabled\", true);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\"#changeBtn\").toggleClass(\"mf\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar formURL = \"/erp/myinfo\";\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\tfunction AcademicInfo(){\r\n");
      out.write("\t\t\t$(\"#form\").attr(\"action\", formURL + \"/newacademic\");\r\n");
      out.write("\t\t\t$(\"#current\").val(\"Academic\");\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"/erp/rest/myinfo/academic\",\r\n");
      out.write("\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\tmethod:\"get\",\r\n");
      out.write("\t\t\t\tcontentType: 'application/json',\r\n");
      out.write("\t\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\t\tif(data.length==undefined){\r\n");
      out.write("\t\t\t\t\t\tvar arr = [data]\r\n");
      out.write("\t\t\t\t\t\tdata = arr;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tlet str =\"\";\r\n");
      out.write("\t\t\t\t\tstr += \"<table border='1px solid black'><tr>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<td>학교/학위</td><td>전공</td><td>날짜</td></tr>\";\r\n");
      out.write("\t\t\t\t\tfor(let i = 0 ; i <data.length ; i++){\r\n");
      out.write("\t\t\t\t\tconsole.log(data[i].hac_year);\r\n");
      out.write("\t\t\t\t\tstr += \"<tr><td><input type='text' name='hac_school' class='detailInfo' value='\"+data[i].hac_school+\"' readonly></td>\"\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='text' name='hac_major' class='detailInfo' value='\"+data[i].hac_major+\"' readonly></td>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='date' name='hac_year' class='detailInfo' value='\"+data[i].hac_year+\"' readonly>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<input type='hidden' name='hac_num' value='\"+data[i].hac_num+\"'></td></tr>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tstr += \"</table>\";\r\n");
      out.write("\t\t\t\t\t$(\"#hrDetailInfo\").html(str);\r\n");
      out.write("\t\t\t\t},error : function(err){\r\n");
      out.write("\t\t\t\t\t/* let str =\"\";\r\n");
      out.write("\t\t\t\t\tstr += \"<table border='1px solid black'><tr>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<td>학교/학위</td><td>전공</td><td>날짜</td></tr>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<tr><td><input type='text' name='hac_school' class='detailInfo'></td>\"\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='text' name='hac_major' class='detailInfo'></td>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='date' name='hac_year' class='detailInfo'></td></tr>\";\r\n");
      out.write("\t\t\t\t\tstr += \"</table>\";\r\n");
      out.write("\t\t\t\t\t$(\"#hrDetailInfo\").html(str); */\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction CertificationInfo(){\r\n");
      out.write("\t\t\t$(\"#form\").attr(\"action\", formURL + \"/newcertification\");\r\n");
      out.write("\t\t\t$(\"#current\").val(\"Certification\");\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"/erp/rest/myinfo/certification\",\r\n");
      out.write("\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\tmethod:\"get\",\r\n");
      out.write("\t\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\t\tif(data.length==undefined){\r\n");
      out.write("\t\t\t\t\tvar arr = [data]\r\n");
      out.write("\t\t\t\t\tconsole.log(arr);\r\n");
      out.write("\t\t\t\t\tdata = arr;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tlet str =\"\";\r\n");
      out.write("\t\t\t\t\tstr += \"<table border='1px solid black'><tr>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<td>자격증</td><td>발급처</td><td>발급일</td></tr>\";\r\n");
      out.write("\t\t\t\t\tfor(let i = 0 ; i <data.length ; i++){\r\n");
      out.write("\t\t\t\t\tstr += \"<tr><td><input type='text' name='hct_name' class='detailInfo' value='\"+data[i].hct_name+\"' readonly ></td>\"\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='text' name='hct_agency' class='detailInfo' value='\"+data[i].hct_agency+\"' readonly ></td>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='date' name='hct_date' class='detailInfo' value='\"+data[i].hct_date+\"' readonly></td>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<input type='hidden' name='hct_num' value='\"+data[i].hct_num+\"'></td></tr>\";\r\n");
      out.write("\t\t\t\t\t}str += \"</table>\";\r\n");
      out.write("\t\t\t\t\t$(\"#hrDetailInfo\").html(str);\r\n");
      out.write("\t\t\t\t},error : function(err){\r\n");
      out.write("\t\t\t\t\t/* let str =\"\";\r\n");
      out.write("\t\t\t\t\tstr += \"<table border='1px solid black'><tr>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<td>자격증</td><td>발급처</td><td>발급일</td></tr>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<tr><td><input type='text' name='hct_name' class='detailInfo'></td>\"\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='text' name='hct_agency' class='detailInfo'></td>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='date' name='hct_date' class='detailInfo' required pattern='\\d{4}-\\d{2}-\\d{2}'></td></tr>\";\r\n");
      out.write("\t\t\t\t\tstr += \"</table>\";\r\n");
      out.write("\t\t\t\t\t$(\"#hrDetailInfo\").html(str); */\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction CareerInfo(){\r\n");
      out.write("\t\t\t$(\"#form\").attr(\"action\", formURL + \"/newcareer\");\r\n");
      out.write("\t\t\t$(\"#current\").val(\"Career\");\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"/erp/rest/myinfo/career\",\r\n");
      out.write("\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\tmethod:\"get\",\r\n");
      out.write("\t\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\t\tconsole.log(\"안됨?\");\r\n");
      out.write("\t\t\t\t\tlet str =\"\";\r\n");
      out.write("\t\t\t\t\tstr += \"<table border='1px solid black'><tr>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<td>회사/프로젝트명</td><td>기간</td><td>직책</td><td>내용</td></tr>\";\r\n");
      out.write("\t\t\t\t\tfor(let i=0; i<data.length ; i++){\r\n");
      out.write("\t\t\t\t\tstr += \"<tr><td><input type='text' name='hcr_cname' class='detailInfo' value='\"+data[i].hcr_cname+\"' readonly ></td>\"\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='date' name='hcr_startperiod' id='chk\"+(i*2)+\"'class='detailInfo checkDate' value='\"+data[i].hcr_startperiod+\"' readonly ><br>\"\r\n");
      out.write("\t\t\t\t\tstr += \"<input type='date' name='hcr_endperiod' id='chk\"+((i*2)+1)+\"' class='detailInfo checkDate' value='\"+data[i].hcr_endperiod+\"' readonly onchange='checkDateValue(chk\"+(i*2)+\", chk\"+((i*2)+1)+\")'> </td>\"\r\n");
      out.write("\t\t\t\t\tstr += \"<td><input type='text' name='hcr_position' class='detailInfo' value='\"+data[i].hcr_position+\"' readonly ></td>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<td><textarea rows='3' cols='20' name='hcr_content' class='detailInfo' value='\"+data[i].hcr_content+\"'></textarea>\";\r\n");
      out.write("\t\t\t\t\tstr += \"<input type='hidden' name='hcr_num' value='\"+data[i].hcr_num+\"'></td></tr>'\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tstr+=\"</table>\";\r\n");
      out.write("\t\t\t\t\t$(\"#hrDetailInfo\").html(str);\r\n");
      out.write("\t\t\t\t\tnum=data.length;\r\n");
      out.write("\t\t\t\t},error : function(err){\r\n");
      out.write("\t\t\t\t\tconsole.log(err);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction InCompanyInfo(){\r\n");
      out.write("\t\t\t$(\"#form\").attr(\"action\", formURL + \"/newhrcard\");\r\n");
      out.write("\t\t\t$(\"#current\").val(\"HRCard\");\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"/erp/rest/myinfo/hrcard\",\r\n");
      out.write("\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\tmethod:\"get\",\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\t\t\tvar married =\"\";\r\n");
      out.write("\t\t\t\t\t\t\tvar status =\"\";\r\n");
      out.write("\t\t\t\t\t\t\tvar work=\"\";\r\n");
      out.write("\t\t\t\t\t\t\tif(data.hc_status==1){\r\n");
      out.write("\t\t\t\t\t\t\t\tstatus=\"근무\";\r\n");
      out.write("\t\t\t\t\t\t\t}else if(data.hc_status==0){\r\n");
      out.write("\t\t\t\t\t\t\t\tstatus=\"퇴근\"\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\tstatus=\"휴가\";\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\tif(data.hc_work==1){\r\n");
      out.write("\t\t\t\t\t\t\t\twork=\"재직\";\r\n");
      out.write("\t\t\t\t\t\t\t}else if(data.hc_work==2){\r\n");
      out.write("\t\t\t\t\t\t\t\twork=\"휴직\";\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\twork=\"퇴사\";\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\tlet str =\"\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<table border='1px solid black'><tr>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td>사원코드</td><td>부서</td><td>직책</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<tr><td><input type='text' name='hc_code' value='\"+data.hc_hrcode+\"' readonly></td>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td><input type='text' name='hc_dept' value='\"+data.hc_dept+\"' readonly></td>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td><input type='text' name='hc_position' value='\"+data.hc_position+\"' readonly></td>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"</tr><td colspan='3'>입사일</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td colspan='3'><input type='date' name='hc_joindate' value='\"+data.hc_joindate+\"' class='detailInfo' readonly></td>\"\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<tr><td>현재 상태</td><td>재/휴직 상태</td><td>사용한 월차</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td><input type='text' value='\"+status+\"' readonly></td>\"\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td><input type='text' value='\"+work+\"'readonly></td>\"\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td><input type='text' value='\"+data.hc_numholi+\"' readonly></td></tr></table>\";\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#hrDetailInfo\").html(str);\r\n");
      out.write("\t\t\t\t\t\t},error : function(err){\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(deptList);\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(err);\r\n");
      out.write("\t\t\t\t\t\t\tlet str =\"\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<table border='1px solid black'><tr>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td>사원코드</td><td>부서</td><td>직책</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<tr><td><input type='text' name='hc_code' placeholder='---' readonly></td>\"\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td><input type='text' name='hc_dept' value='\"+data.hc_dept+\"' readonly></td>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td><input type='text' name='hc_position' value='\"+data.hc_position+\"' readonly></td>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"</tr><td colspan='3'>입사일</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td colspan='3'><input type='date' name='hc_joindate' readonly></td></tr>\"\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<tr><td>현재 상태</td><td>재/휴직 상태</td><td>사용한 월차</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td><input type='text' placeholder='---' readonly></td>\"\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td><input type='text' placeholder='---' readonly></td>\"\r\n");
      out.write("\t\t\t\t\t\t\tstr += \"<td><input type='text' placeholder='---' readonly></td></tr></table>\";\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#hrDetailInfo\").html(str);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    boolean _jspx_th_c_005fout_005f0_reused = false;
    try {
      _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fout_005f0.setParent(null);
      // /WEB-INF/views/myInfo/myInfo.jsp(116,32) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
      if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      _jspx_th_c_005fout_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fout_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fout_005f0_reused);
    }
    return false;
  }
}

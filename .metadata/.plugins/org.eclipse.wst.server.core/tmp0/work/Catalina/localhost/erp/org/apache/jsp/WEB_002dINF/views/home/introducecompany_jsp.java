/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-09-18 06:08:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class introducecompany_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<!-- <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script> -->\r\n");
      out.write("<meta name=\"keywords\" content=\"\" />\r\n");
      out.write("<meta name=\"description\" content=\"\" />\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1 user-scalable=no\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no\">\r\n");
      out.write("<link\r\n");
      out.write("\thref='http://fonts.googleapis.com/css?family=Open+Sans:300,400,700'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("<script src=\"lib/jquery/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"lib/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"lib/php-mail-form/validate.js\"></script>\r\n");
      out.write("<script src=\"lib/easing/easing.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Template Main Javascript File -->\r\n");
      out.write("<script src=\"resources/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<title>회사소개</title>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("#container {\r\n");
      out.write("\tborder-bottom: gray 1px solid;\r\n");
      out.write("\tborder-top: gray 1px solid;\r\n");
      out.write("\tline-height: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".list {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tpadding: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".subNavBtn {\r\n");
      out.write("\twidth: 27%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table, tr, td {\r\n");
      out.write("\tborder: 1px black solid;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#info {\r\n");
      out.write("\tpadding: 0 0 0 26%;\r\n");
      out.write("}\r\n");
      out.write(".wrap{\r\n");
      out.write("height:1000px;\r\n");
      out.write("}\r\n");
      out.write(".erpimg{\r\n");
      out.write("float: left;\r\n");
      out.write("width:300px;\r\n");
      out.write("height:450px;\r\n");
      out.write("margin-left: 6%;\r\n");
      out.write("}\r\n");
      out.write(".img{\r\n");
      out.write("width:300px;\r\n");
      out.write("height: 400px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body data-spy=\"scroll\" data-offset=\"58\" data-target=\"#navbar-main\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <div id=\"navbar-main\">\r\n");
      out.write("    <!-- Fixed navbar -->\r\n");
      out.write("    <div class=\"navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("            <span class=\"icon icon-shield\" style=\"font-size:30px; color:#3498db;\"></span>\r\n");
      out.write("          </button>\r\n");
      out.write("          <a class=\"navbar-brand hidden-xs hidden-sm smoothscroll\" href=\"#home\"><span class=\"icon icon-shield\" style=\"font-size:18px; color:#3498db;\"></span></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"navbar-collapse collapse\">\r\n");
      out.write("          <ul class=\"nav navbar-nav\">\r\n");
      out.write("            <li><a href=\"#home\" class=\"smoothscroll\">인사말</a></li>\r\n");
      out.write("            <li> <a href=\"#about\" class=\"smoothscroll\"> 회사소개</a></li>\r\n");
      out.write("            <li> <a href=\"#services\" class=\"smoothscroll\">회사기술</a></li>\r\n");
      out.write("            <li> <a href=\"#team\" class=\"smoothscroll\"> 오시는길</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <!-- ==== HEADERWRAP ==== -->\r\n");
      out.write("  <div id=\"home\"></div>\r\n");
      out.write("  <div id=\"headerwrap\" name=\"home\">\r\n");
      out.write("    <header class=\"clearfix\">\r\n");
      out.write("      <h1><span class=\"icon icon-shield\"></span></h1>\r\n");
      out.write("      <h1>인사말\r\n");
      out.write("\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t<span> <br>최첨단 기술과 최고의 전문 인력으로 고객에게 최상의 결과물을 제공하는 IT기업,\r\n");
      out.write("\t\t\t\t\t<span style=\"color: #FFB2D9\">N7 ERP</span>입니다!</span>\r\n");
      out.write("\t\t\t\t<p>ERP의 최신 기술을 경험해 보세요!</p>\r\n");
      out.write("\t\t\t\t<span>눈앞에 물질보다 정보의 가치가 더 커진 요즘 고객들의 소중한 정보를 지키기 위해 보안 메일 솔루션을<br>\r\n");
      out.write("\t\t\t\t구축하여 고객에게 안전한 업무 환경을 제공하고 있으며, 기업 관리 시스템 구축으로 보다 효율적으로 사업을 <br>\r\n");
      out.write("\t\t\t\t진행할 수 있도록 도와드리고 있습니다.<br>\r\n");
      out.write("                              그 외에도 홈페이지 구축, 그룹웨어 등 기업에서 필요로 하는 많은 기술을 제공할 수 있는 기업이 되었습니다.</span>\r\n");
      out.write("    </header>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <!-- ==== ABOUT ==== -->\r\n");
      out.write("  <div class=\"container\" id=\"about\" name=\"about\">\r\n");
      out.write("    <div class=\"row white\">\r\n");
      out.write("      <br>\r\n");
      out.write("      <h1 class=\"centered\">회사소개</h1>\r\n");
      out.write("      <hr>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"col-lg-6\">\r\n");
      out.write("        <p><img src=\"img/companyimg.png\" style=\"width:190%; height: 500px;\"></p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("<hr>\r\n");
      out.write("  <!-- ==== SERVICES ==== -->\r\n");
      out.write("  <div class=\"container\" id=\"services\" name=\"services\">\r\n");
      out.write("    <br>\r\n");
      out.write("    <br>\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("      <h2 class=\"centered\">회사기술</h2>\r\n");
      out.write("      <hr>\r\n");
      out.write("      <br>\r\n");
      out.write("                <div class=\"erpimg\">\r\n");
      out.write("                <table>\r\n");
      out.write("                <tr><td><img class=\"img\" src=\"img/erp1.png\" alt=\"최고의 기술로 가치를 창조하고\"></td></tr>\r\n");
      out.write("                <tr><td><span> 좋은 ERP로 최고의 기술의 가치를 창조하고</span></td></tr>\r\n");
      out.write("                </table>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"erpimg\">\r\n");
      out.write("                <table>\r\n");
      out.write("                <tr><td><img class=\"img\" src=\"img/erp2.jpg\" alt=\"혁신적인 기술로 시장을 선도하며\"></td></tr>\r\n");
      out.write("                <tr><td><span>혁신적인 기술로 시장을 선도하며</span></td></tr>\r\n");
      out.write("                </table>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div>\r\n");
      out.write("                <table class=\"erpimg\">\r\n");
      out.write("                <tr><td><img class=\"img\" src=\"img/erp3.jpg\" alt=\"항상 고객을 최우선으로 생각하는 기업\"></td></tr>\r\n");
      out.write("                <tr><td><span>항상 고객을 최우선으로 생각하는 기업</span></td></tr>\r\n");
      out.write("                </table>\r\n");
      out.write("                </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("  <!-- ==== SECTION DIVIDER2 -->\r\n");
      out.write("  <section class=\"section-divider textdivider divider2\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- container -->\r\n");
      out.write("  </section>\r\n");
      out.write("  <!-- section -->\r\n");
      out.write("\r\n");
      out.write("  <!-- ==== TEAM MEMBERS ==== -->\r\n");
      out.write("  <div class=\"container\" id=\"team\" name=\"team\">\r\n");
      out.write("    <br>\r\n");
      out.write("    <div class=\"row white centered\">\r\n");
      out.write("      <h1>오시는길</h1>\r\n");
      out.write("\t\t\t\t<div id=\"info\">\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>회사이름</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>달콤살벌한 SELECT</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>회사전화번호</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>010-6851-4495</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>회사주소</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>인천 미추홀구 매소홀로488번길 6-32 태승빌딩 4층</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"map\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 600px; border: 1px solid black; height: 400px; margin: 20px auto; display: block;\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\tvar map = null;\r\n");
      out.write("\r\n");
      out.write("\tfunction initMap() {\r\n");
      out.write("\t\tmap = new naver.maps.Map('map', {\r\n");
      out.write("\t\t\tcenter : new naver.maps.LatLng(37.438891, 126.675119),\r\n");
      out.write("\t\t\tzoom : 15,\r\n");
      out.write("\t\t\tmapTypeControl : true,\r\n");
      out.write("\t\t\tzoomControl : true,\r\n");
      out.write("\t\t\tzoomControlOptions : {\r\n");
      out.write("\t\t\t\tposition : naver.maps.Position.TOP_RIGHT\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar marker = new naver.maps.Marker({\r\n");
      out.write("\t\t\tposition : new naver.maps.LatLng(37.438891, 126.675119),\r\n");
      out.write("\t\t\tmap : map\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
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
}
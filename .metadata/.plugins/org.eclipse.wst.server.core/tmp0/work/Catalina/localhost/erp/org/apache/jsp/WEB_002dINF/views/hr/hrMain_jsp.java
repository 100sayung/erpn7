/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-09-21 05:12:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.hr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class hrMain_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\twidth: 800px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul {\r\n");
      out.write("\tlist-style: none;\r\n");
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
      out.write("\t\t\t\t<li><a href=\"/erp/myinfo/myinfo\" accesskey=\"4\" title=\"\">내 정보</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"current_page_item\"><a href=\"/erp/hr/hr\" accesskey=\"2\"\r\n");
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
      out.write("\t\t\t<li id=\"showMenu1\">인사 관리\r\n");
      out.write("\t\t\t\t<ul id=\"smallMenu1\" style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/erp/hr/deptregistpage\">부서등록</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/erp/hr/movehrcardpage\">인사카드</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<li id=\"showMenu2\">근태 관리\r\n");
      out.write("\t\t\t\t<ul id=\"smallMenu2\" style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/erp/hr/receiptholiday\">휴가 접수</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/erp/hr/attendance\">사원 출결 관리</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/erp/hr/employeestatus\">근무 조회</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/erp/hr/retiremm\">휴/퇴직 관리</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"showMenu3\">급여 관리\r\n");
      out.write("\t\t\t\t<ul id=\"smallMenu3\" style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/erp/hr/deptpay\">부서/직급별 급여</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/erp/hr/deduct\">공제사항 관리</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/erp/hr/searchpaymm\">급여 관리</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"description\"> 본 화면\r\n");
      out.write("\r\n");
      out.write("\t<br> 임시페이지\r\n");
      out.write("\t<a href=\"/erp/management/deptauth\"> dept 권한 설정 </a>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(\"#showMenu1\").hover(function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu1\").attr(\"style\", \"display:inline-block\");\r\n");
      out.write("\t\t}, function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu1\").attr(\"style\", \"display:none\");\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t$(\"#showMenu2\").hover(function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu2\").attr(\"style\", \"display:inline-block\");\r\n");
      out.write("\t\t}, function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu2\").attr(\"style\", \"display:none\");\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t$(\"#showMenu3\").hover(function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu3\").attr(\"style\", \"display:inline-block\");\r\n");
      out.write("\t\t}, function() {\r\n");
      out.write("\t\t\t$(\"#smallMenu3\").attr(\"style\", \"display:none\");\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
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
}

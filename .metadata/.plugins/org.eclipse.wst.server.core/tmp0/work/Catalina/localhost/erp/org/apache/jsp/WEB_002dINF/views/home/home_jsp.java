/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-09-18 06:08:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<!--\r\n");
      out.write("Design by TEMPLATED\r\n");
      out.write("http://templated.co\r\n");
      out.write("Released for free under the Creative Commons Attribution License\r\n");
      out.write("\r\n");
      out.write("Name       : UpRight\r\n");
      out.write("Description: A two-column, fixed-width design with dark color scheme.\r\n");
      out.write("Version    : 1.0\r\n");
      out.write("Released   : 20130526\r\n");
      out.write("\r\n");
      out.write("-->\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("<meta name=\"keywords\" content=\"\" />\r\n");
      out.write("<meta name=\"description\" content=\"\" />\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<link href=\"/erp/css/default.css\" rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\tmedia=\"all\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\" />\r\n");
      out.write("\t\t<link href=\"img/favicon.png\" rel=\"icon\" />\r\n");
      out.write("  <link href=\"img/apple-touch-icon.png\" rel=\"apple-touch-icon\" />\r\n");
      out.write("  <link href=\"lib/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("  <link href=\"lib/icomoon/icomoon.css\" rel=\"stylesheet\" />\r\n");
      out.write("  <script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=1a9e4h5a1u&callback=initMap\"></script>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\"\r\n");
      out.write("\tintegrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\"\r\n");
      out.write("\tcrossorigin=\"anonymous\" />\r\n");
      out.write("\t<!--[if IE 6]>\r\n");
      out.write("<link href=\"default_ie6.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<![endif]-->\r\n");
      out.write("\t<style>\r\n");
      out.write(".button {\r\n");
      out.write("\tcolor: #ffffff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#description div {\r\n");
      out.write("\tborder-radius: 25px;\r\n");
      out.write("\tbackground-color: rgb(85, 82, 82);\r\n");
      out.write("\twidth: 200px;\r\n");
      out.write("\tmargin: 5px;\r\n");
      out.write("\theight: 150px;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tline-height: 150px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#description div:hover {\r\n");
      out.write("\tbackground-color: #eeeeee;\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#description {\r\n");
      out.write("\tmargin-left: 340px;\r\n");
      out.write("\tmargin-top: 200px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#desc {\r\n");
      out.write("margin-left: 200px;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tfont-weight: bolder;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"header\" class=\"container\">\r\n");
      out.write("\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t<h1>\r\n");
      out.write("\t\t\t\t<a href=\"/erp/\">N7 ERP SYSTEM</a>\r\n");
      out.write("\t\t\t</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"/erp/adminpage\"  title=\"\">ADMIN관리</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\" id=\"introduce\" accesskey=\"2\" title=\"\">회사\r\n");
      out.write("\t\t\t\t\t\t소개</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/erp/erpboard\" accesskey=\"3\" title=\"\">신청 게시판</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/erp/erpapply\" accesskey=\"4\" title=\"\">ERP 신청</a></li>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<br><br><br><br> \r\n");
      out.write("메인 메뉴 통일해야함 이름이 다름\r\n");
      out.write("<br>\r\n");
      out.write("\t<div id=\"description\">\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t<div class=\"icons\" id=\"personManagement\">\r\n");
      out.write("\t\t\t<i class='fas fa-id-card' style='font-size: 36px; color: white;'></i>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"icons\" id=\"salesManagement\">\r\n");
      out.write("\t\t\t<i class='far fa-handshake' style='font-size: 36px; color: white;'></i>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"icons\" id=\"purchaseManagement\">\r\n");
      out.write("\t\t\t<i class='fas fa-shopping-cart'\r\n");
      out.write("\t\t\t\tstyle='font-size: 36px; color: white;'></i>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"icons\" id=\"stockManagement\">\r\n");
      out.write("\t\t\t<i class='fas fa-archive' style='font-size: 36px; color: white;'></i>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"icons\" id=\"accountingManagement\">\r\n");
      out.write("\t\t\t<i class='fas fa-dollar-sign' style='font-size: 36px; color: white;'></i>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"desc\" style=\"float: left;\"></div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t$(\"#introduce\").click(function(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl:'introducecompany',\r\n");
      out.write("\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t$(\"#description\").hide();\r\n");
      out.write("\t\t\t\t$(\"#desc\").html(data);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror:function(error){\r\n");
      out.write("\t\t\t\tconsole.log(error);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\t\tvar msg=location.search.substring(5, 6);\r\n");
      out.write("\t\tconsole.log(msg)\r\n");
      out.write("\t\tif(!msg){\r\n");
      out.write("\t\t\tconsole.log(\"테스트1 msg el 값 없음\")\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\thistory.replaceState({}, null, location.pathname);\r\n");
      out.write("\t\t\tif(msg==1){\r\n");
      out.write("\t\t\t\talert(\"회원가입 성공\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\talert(\"회원가입 실패\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(\".icons\")\r\n");
      out.write("\t\t\t\t.hover(\r\n");
      out.write("\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\tvar template = $(this).attr(\"id\");\r\n");
      out.write("\t\t\t\t\t\t\t$(this).siblings().attr(\"style\", \"display:none\");\r\n");
      out.write("\t\t\t\t\t\t\t$(this).children().attr(\"style\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\"color:black;font-size:36px;\");\r\n");
      out.write("\t\t\t\t\t\t\tif (template == \"personManagement\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#desc\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t'<h1>인사 관리</h1><br><br>다양한 인사정보의 효율적 검색 기능 제공<br>다양한 급여처리 방식으로 고객사에 최적화된 급여처리 방법 제공<br>입사 후 인적 정보의 효율적 관리<br>다양한 보직변경 항목 제공<br>자유로운 급여기준 설정을 통해 급여처리의 편리성 추구<br>사원/조직별 정보를 그래프 형식으로 병렬 제공하여 다양한 현황 분석 용이')\r\n");
      out.write("\t\t\t\t\t\t\t} else if (template == \"salesManagement\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#desc\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t'<h1>영업 관리</h1><br><br>영업 실적 관리의 편안함과 정확성<br>미수금 잔액을 한 눈에 파악<br>웹 기반 시스템의 편리성<br>각 영업 사원에게 고유 ID 제공하여 권한 제어')\r\n");
      out.write("\t\t\t\t\t\t\t} else if (template == \"purchaseManagement\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#desc\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t'<h1>구매 관리</h1><br><br>구매 내역 자동 재고 반영<br>실시간 재고 확인<br>발주 수량 자동 계산하여 적정재고량 유지에 도움<br>실제 재고와 장부상 재고 비교하여 정확도 UP')\r\n");
      out.write("\t\t\t\t\t\t\t} else if (template == \"stockManagement\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#desc\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t'<h1>재고 관리</h1><br><br>다양한 보고서 제공<br>재고 장부 자동화<br>재고 수량 관리의 정확성<br>월수불실적 제공을 통한 편리함<br>적정 수량 유지를 통한 안정성<br>')\r\n");
      out.write("\t\t\t\t\t\t\t} else if (template == \"accountingManagement\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#desc\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t'<h1>회계 관리</h1><br><br>경영자를 위한 보고서 제공<br>실시간 보고서 확인 가능(인터넷 연결 필수)<br>경영자 보고서 자동화를 통한 편안함<br>영업, 구매 내역을 그대로 처리하여 정확도 UP<br>예산 관리의 편안함')\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#desc\").html('');\r\n");
      out.write("\t\t\t\t\t\t\t$(this).siblings().attr(\"style\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\"display:inline-block\");\r\n");
      out.write("\t\t\t\t\t\t\t$(this).children().attr(\"style\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\"color:white;font-size:36px;\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/home/home.jsp(89,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id==null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<li><a href=\"/erp/login\" accesskey=\"5\" title=\"\">LOGIN</a></li>\r\n");
          out.write("\t\t\t\t<li><a href=\"/erp/join\" accesskey=\"6\" title=\"\">JOIN</a></li>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/views/home/home.jsp(93,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id!=null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("             \t<li><form action=\"logout\" method=\"post\"><button>LOGOUT</button></form></li>\r\n");
          out.write("\t\t\t\t<li class=\"current_page_item\"><a href=\"#\" onClick='window.open(\"/erp/main\", \"ERP START\", \"width=1200, height=900, toolbar=no, menubar=no, resizable=yes\"); return false;'>ERP시작</a></li>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-09-16 02:54:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class acApproval_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("   \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>매출/매입결제양식</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html,body{\r\n");
      out.write("text-align: center;\r\n");
      out.write("}\r\n");
      out.write("table, tr, th, td{\r\n");
      out.write("border: 1px solid silver;\r\n");
      out.write("text-align: center;\r\n");
      out.write("margin-left: auto;\r\n");
      out.write("margin-right: auto;\r\n");
      out.write("}\r\n");
      out.write(".txt{\r\n");
      out.write("width: 200px;\r\n");
      out.write("height: 20px;\r\n");
      out.write("border-style: none;\r\n");
      out.write("text-align: center;\r\n");
      out.write("}\r\n");
      out.write(".select{\r\n");
      out.write("width: 150px;\r\n");
      out.write("height: 25px;\r\n");
      out.write("}   \r\n");
      out.write(".draft{\r\n");
      out.write("width: 500px; \r\n");
      out.write("height: 20px; \r\n");
      out.write("border-style: none; \r\n");
      out.write("text-align: center;\"\r\n");
      out.write("}\r\n");
      out.write(".draft2{\r\n");
      out.write("width: 600px; \r\n");
      out.write("text-align: center;\r\n");
      out.write("}\r\n");
      out.write(".draft3{\r\n");
      out.write("width: 230px;\r\n");
      out.write("border-style: none; \r\n");
      out.write("text-align: center;\r\n");
      out.write("}\r\n");
      out.write("#ect{\r\n");
      out.write("resize: none;\r\n");
      out.write("}\r\n");
      out.write("input{\r\n");
      out.write("border: 0px;\r\n");
      out.write("text-align: center;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div style=\"width: auto; background-color: white; padding: 1%;\">\r\n");
      out.write("<button type=\"button\" id=\"approvalLine\">결재라인 불러오기</button>\r\n");
      out.write("   </div>\r\n");
      out.write("   <div style=\"width: auto; background-color: #FFB2D9; color: white; padding: 1%;\">기안문 작성</div>\r\n");
      out.write("   <div style=\"height: auto; padding-top: 5px; background-color: #F8F7F7;\">\r\n");
      out.write("   <form id=\"formdata\">\r\n");
      out.write("         <table>\r\n");
      out.write("         \r\n");
      out.write("            <tr>\r\n");
      out.write("               <th>일자</th>\r\n");
      out.write("               <th><input id=\"time\" type=\"text\" name=\"rs_date\"></th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("               <th>제목</th>\r\n");
      out.write("               <th><textarea rows=\"1\" cols=\"190\" name=\"rs_title\"></textarea></th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("               <th>결재자</th>\r\n");
      out.write("               <th id=\"line\"></th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            \r\n");
      out.write("            <tr>\r\n");
      out.write("               <th>내용</th>\r\n");
      out.write("               <td>\r\n");
      out.write("                  <div style=\"border: 1px solid #EAEAEA; background-color: white;\">\r\n");
      out.write("                     <div>\r\n");
      out.write("                        <table>\r\n");
      out.write("                        ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                           <tr>\r\n");
      out.write("\t\t\t\t\t<th colspan='2'>품목</th>\r\n");
      out.write("\t\t\t\t\t<th>수량</th>\r\n");
      out.write("\t\t\t\t\t<th>단가</th>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"2\">공급가액</th>\r\n");
      out.write("\t\t\t\t\t<th colspan='2'>세액</th>\r\n");
      out.write("\t\t\t\t\t<th>합계</th>\r\n");
      out.write("\t\t\t\t\t<th>비고</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("                        <tbody id=\"tbody\">\r\n");
      out.write("                        \r\n");
      out.write("                        </tbody>\r\n");
      out.write("                        <tr><th colspan=\"3\">총합계(원)</th><th id=\"total\" colspan=\"7\"></th></tr>\r\n");
      out.write("                           <tr>\r\n");
      out.write("                              <th>기타</th>\r\n");
      out.write("                              <th colspan=\"10\"><textarea rows=\"5\" cols=\"163\" name=\"rs_reason\"></textarea></th>\r\n");
      out.write("                           </tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("         </table>\r\n");
      out.write("   </form>\r\n");
      out.write("      </div>\r\n");
      out.write("   <button id=\"commit\" type=\"button\">결제상신</button>&nbsp;<button type=\"reset\">취소</button>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("$(\"#commit\").click(function(){\r\n");
      out.write("\tvar data = $(\"#formdata\").serialize();\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl:'/erp/Account/approdocument',\r\n");
      out.write("\t\ttype:'post',\r\n");
      out.write("\t\tdata: data,\r\n");
      out.write("\t\tdatatype:'json',\r\n");
      out.write("\t\tsuccess:function(data){\r\n");
      out.write("\t\t\talert(\"결제요청성공\")\r\n");
      out.write("\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\twindow.close();\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror:function(error){\r\n");
      out.write("\t\t\tconsole.log(error);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var saleList = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sList2}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("var total=0;\r\n");
      out.write("var str=\"\";\r\n");
      out.write("for(var i in saleList){\r\n");
      out.write("\tstr+=\"<tr><td colspan='2'><input type='text' name='rs_pkind' value=\"+saleList[i].s_pkind+\"></td>\";\r\n");
      out.write("\tstr+=\"<td><input type='text' name='rs_cnt' value=\"+saleList[i].s_cnt+\"></td>\";\r\n");
      out.write("\tstr+=\"<td><input type='text' name='rs_price' value=\"+saleList[i].s_price+\"></td>\";\r\n");
      out.write("\tstr+=\"<td colspan='2'><input type='text' name='rs_price2' value=\"+saleList[i].s_price2+\"></td>\";\r\n");
      out.write("\tstr+=\"<td colspan='2'><input type='text' name='rs_tax' value=\"+saleList[i].s_tax+\"></td>\";\r\n");
      out.write("\tstr+=\"<td><input type='text' name='rs_total' value=\"+saleList[i].s_total+\"></td>\";\r\n");
      out.write("\tstr+=\"<td><input type='text' name='rs_memo' value=\"+saleList[i].s_memo+\"></td></tr>\";\r\n");
      out.write("\ttotal+=Number(saleList[i].s_total);\r\n");
      out.write("}\r\n");
      out.write("$(\"#tbody\").html(str);\r\n");
      out.write("$(\"#total\").html(total);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var time = new Date();\r\n");
      out.write("$(\"#time\").val(time.toLocaleDateString()+time.toLocaleTimeString());\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\tfunction setChildValue(data) {\r\n");
      out.write("\t\tconsole.log(data);\r\n");
      out.write("\t\tif (data.tList1 != \"\") {\r\n");
      out.write("\t\tvar str = \"\";\r\n");
      out.write("\t\t\tfor ( var i in data.tList1) {\r\n");
      out.write("\t\t        str +=\"<input type='text' name='rs_apcode\"+i+\"' value='\"+data.tList1[i].hc_hrcode+\"' hidden='true'>\";\r\n");
      out.write("\t\t\t\tstr +=data.tList1[i].hc_position+\"/\";\r\n");
      out.write("\t\t\t\tstr +=\"<input style='width:50px;' type='text' name='rs_apname\"+i+\"' value='\"+ data.tList1[i].m_name+\"'>&nbsp;&nbsp;||&nbsp;&nbsp;\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tconsole.log(str)\r\n");
      out.write("\t\t\t$(\"#line\").html(str);\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t/* if (data.tList2 != \"\") {\r\n");
      out.write("\t\t\tfor ( var i in data.tList2) {\r\n");
      out.write("\t\tvar str2 = \"\";\r\n");
      out.write("\t\t\t\tstr2 +=\"<input type='text' name='ad_recode\"+i+\"' value='\"+data.tList2[i].m_code+\"' hidden='true'>\";\r\n");
      out.write("\t\t\t\tstr2 += data.tList2[i].m_grade + \"<br>\";\r\n");
      out.write("\t\t\t\tstr2 += data.tList2[i].m_name;\r\n");
      out.write("\t\t\t$(\"#refer\"+i).html(str2);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}; */\r\n");
      out.write("\t\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\t$(\"#approvalLine\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\twindow.open('/erp/Account/approvalLine', 'approvalLine', 'width=1400,height=700');\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/Account/acApproval.jsp(82,24) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("approval");
      // /WEB-INF/views/Account/acApproval.jsp(82,24) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/Account/acApproval.jsp(82,24) '${sList1}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${sList1}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                           <tr>\r\n");
            out.write("                              <th colspan=\"10\">매출/매입 기안문</th>\r\n");
            out.write("                           </tr>\r\n");
            out.write("                           <tr>\r\n");
            out.write("                           <th>전표번호</th>\r\n");
            out.write("                           <th colspan=\"2\"><input type=\"text\" name=\"rs_num\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${approval.s_num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"></th>\r\n");
            out.write("                              <th>유형</th>\r\n");
            out.write("                              <th><input type=\"text\" name=\"rs_kind\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${approval.s_kind}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"></th>\r\n");
            out.write("                              <th colspan=\"2\">거래처</th>\r\n");
            out.write("                              <th colspan=\"3\"><input type=\"text\" name=\"rs_company\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${approval.s_company}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"></th>\r\n");
            out.write("                           </tr>\r\n");
            out.write("                           <tr>\r\n");
            out.write("                           <th>사업자번호</th>\r\n");
            out.write("                           <th colspan=\"2\"><input type=\"text\" name=\"rs_comnum\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${approval.s_comnum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"></th>\r\n");
            out.write("                              <th>매출일자</th>\r\n");
            out.write("                              <th><input type=\"text\" name=\"rs_sdate\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${approval.s_date}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"></th>\r\n");
            out.write("                              <th>담당자</th>\r\n");
            out.write("                              <th>부서명</th>\r\n");
            out.write("                              <th><input type=\"text\" name=\"rs_dept\" value=\"회계팀\"></th>\r\n");
            out.write("                              <th>성명</th>\r\n");
            out.write("                              <th><input type=\"text\" name=\"rs_employee\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${approval.s_employee}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"></th>\r\n");
            out.write("                           </tr>\r\n");
            out.write("                           ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}

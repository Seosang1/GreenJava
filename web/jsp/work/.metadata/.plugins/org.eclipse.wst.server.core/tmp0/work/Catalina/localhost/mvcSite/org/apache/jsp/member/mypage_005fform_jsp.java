/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-06-08 07:19:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vo.*;

public final class mypage_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("vo");
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
      return;
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
      out.write("\r\n");

MemberInfo loginMember = (MemberInfo) session.getAttribute("loginMember");
// ????????? ??????(attribute)??? ???????????? ????????? ??????(MemberInfo??? ????????????)??? ????????? 

if (loginMember == null) {
	out.println("<script>");
	out.println("alert('????????? ??? ???????????? ??? ????????????.');");
	out.println("location.href='../login_form.jsp?url=member/mypage.mem';");
	out.println("</script>");
	out.close();
}

request.setCharacterEncoding("utf-8"); 

String[] arrPhone = loginMember.getMi_phone().split("-");
String[] arrEmail = loginMember.getMi_email().split("@");

String[] arrDomain = new String[5];
arrDomain[0] = "naver.com";
arrDomain[1] = "nate.com";
arrDomain[2] = "gmail.com";
arrDomain[3] = "daum.net";
arrDomain[4] = "yahoo.com";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction byeBye() {\r\n");
      out.write("\t\tif (confirm(\"?????? ?????? ???? \\n???????????? ?????? ?????????????\")) {\r\n");
      out.write("\t\t\t// ???????????? ???????????? N - ????????????\r\n");
      out.write("\t\t\tlocation.href = \"proc.mem?wtype=del\";\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h2>???????????? ?????? ???</h2>\r\n");
      out.write("\t<form name=\"frmJoin\" action=\"proc.mem\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"wtype\" value=\"up\" />\r\n");
      out.write("\t\t<table border=\"1\" cellpadding=\"5\" width=\"700\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"20%\">?????????</th>\r\n");
      out.write("\t\t\t\t<td width=\"*\">");
      out.print(loginMember.getMi_id());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>?????? ????????????</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"old_pwd\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>??? ????????????</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"mi_pwd\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>??? ???????????? ??????</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"mi_pwd2\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>??????</th>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(loginMember.getMi_name());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>????????????</th>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(loginMember.getMi_birth());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>??????</th>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(loginMember.getMi_gender().equals("f") ? "??????" : "??????");
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>????????????</th>\r\n");
      out.write("\t\t\t\t<td><select name=\"p1\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"010\" ");
if (arrPhone[0].equals("010")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tselected=\"selected\" ");
}
      out.write(">010</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"011\" ");
if (arrPhone[0].equals("011")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tselected=\"selected\" ");
}
      out.write(">011</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"016\" ");
if (arrPhone[0].equals("016")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tselected=\"selected\" ");
}
      out.write(">016</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"019\" ");
if (arrPhone[0].equals("019")) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tselected=\"selected\" ");
}
      out.write(">019</option>\r\n");
      out.write("\t\t\t\t</select> - <input type=\"text\" name=\"p2\" size=\"4\" maxlength=\"4\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(arrPhone[1]);
      out.write("\" /> - <input type=\"text\" name=\"p3\"\r\n");
      out.write("\t\t\t\t\tsize=\"4\" maxlength=\"4\" value=\"");
      out.print(arrPhone[2]);
      out.write("\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>?????????</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"e1\" value=\"");
      out.print(arrEmail[0]);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t@ <select name=\"e2\" onchange=\"setDomain(this.value);\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"\">????????? ??????</option>\r\n");
      out.write("\t\t\t\t\t\t");

						for (int i = 0; i < arrDomain.length; i++) {
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(arrDomain[i]);
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t");
if (arrEmail[1].equals(arrDomain[i])) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t\t");
}
      out.write('>');
      out.print(arrDomain[i]);
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t");

						}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"direct\">?????? ??????</option>\r\n");
      out.write("\t\t\t\t</select> <input type=\"text\" name=\"e3\" value=\"");
      out.print(arrEmail[1]);
      out.write("\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>SNS ??????</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"radio\" name=\"mi_issns\" value=\"y\"\r\n");
      out.write("\t\t\t\t\tchecked=\"checked\"\r\n");
      out.write("\t\t\t\t\t");
if (loginMember.getMi_issns().equals("y")) {
      out.write("\r\n");
      out.write("\t\t\t\t\tchecked=\"checked\" ");
}
      out.write(" />?????? <input type=\"radio\" name=\"mi_issns\"\r\n");
      out.write("\t\t\t\t\tvalue=\"n\" ");
if (loginMember.getMi_issns().equals("n")) {
      out.write("\r\n");
      out.write("\t\t\t\t\tchecked=\"checked\" ");
}
      out.write(" />?????????</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>?????? ??????</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"radio\" name=\"mi_ismail\" value=\"y\"\r\n");
      out.write("\t\t\t\t\t");
if (loginMember.getMi_ismail().equals("y")) {
      out.write("\r\n");
      out.write("\t\t\t\t\tchecked=\"checked\" ");
}
      out.write(" />?????? <input type=\"radio\"\r\n");
      out.write("\t\t\t\t\tname=\"mi_ismail\" value=\"n\"\r\n");
      out.write("\t\t\t\t\t");
if (loginMember.getMi_ismail().equals("n")) {
      out.write("\r\n");
      out.write("\t\t\t\t\tchecked=\"checked\" ");
}
      out.write(" />?????????</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<p style=\"width: 700px; text-align: center;\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"?????? ??????\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<input type=\"reset\" value=\"?????? ??????\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"?????? ??????\" onclick=\"byeBye()\" />\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t</form>\r\n");
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-06-30 13:33:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JS;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class studentInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>></title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      function verifyName(input) {\r\n");
      out.write("      \r\n");
      out.write("      var kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;\r\n");
      out.write("      \r\n");
      out.write("      if(kor.test(input) == false) {\r\n");
      out.write("         alert(\"올바른 이름을 입력하세요\");\r\n");
      out.write("         return false;\r\n");
      out.write("         \r\n");
      out.write("      } else {\r\n");
      out.write("         alert(\"이름 입력 완료\");\r\n");
      out.write("         return true;      \r\n");
      out.write("      }   \r\n");
      out.write("}      \r\n");
      out.write("      function verifyNumber(input1) {\r\n");
      out.write("      \r\n");
      out.write("      var num = /^(\\s|\\d)+$/;\r\n");
      out.write("      \r\n");
      out.write("      if(num.test(input1) == false) {\r\n");
      out.write("         alert(\"올바르지 않은 학번입니다\");\r\n");
      out.write("         return false;\r\n");
      out.write("\r\n");
      out.write("      } else {\r\n");
      out.write("         alert(\"학번 입력 완료\");\r\n");
      out.write("         return true;\r\n");
      out.write("      }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("      function verifyEmail(input2) {\r\n");
      out.write("      \r\n");
      out.write("      var mail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;\r\n");
      out.write("\r\n");
      out.write("      if(mail.test(input2) == false) {\r\n");
      out.write("         alert(\"올바른 이메일 형식으로 입력하세요\");\r\n");
      out.write("         return false;\r\n");
      out.write("      } else {\r\n");
      out.write("         alert(\"이메일 입력 완료\");\r\n");
      out.write("         return true;\r\n");
      out.write("      }\r\n");
      out.write("     \r\n");
      out.write("}\r\n");
      out.write("      \r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <script>\r\n");
      out.write("    var input = prompt(\"이름을 입력해주세요\");\r\n");
      out.write("    verifyName(input);\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("    var input1 = prompt(\"학번을 입력해주세요\");\r\n");
      out.write("    verifyNumber(input1);\r\n");
      out.write("   \r\n");
      out.write("   var input2 = prompt(\"이메일을 입력해 주세요\");\r\n");
      out.write("         verifyEmail(input2);\r\n");
      out.write("   \r\n");
      out.write("   confirm(\"학생정보를 입력하시겠습니까?\")\r\n");
      out.write("   var con_test = confirm\r\n");
      out.write("   if(con_test ==true) {\r\n");
      out.write("   document.write(input);\r\n");
      out.write("   document.write(input1);\r\n");
      out.write("   document.write(input2);\r\n");
      out.write("   }else if(con_test ==false){\r\n");
      out.write("   document.write();\r\n");
      out.write("   }\r\n");
      out.write("   </script> \r\n");
      out.write("   \r\n");
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
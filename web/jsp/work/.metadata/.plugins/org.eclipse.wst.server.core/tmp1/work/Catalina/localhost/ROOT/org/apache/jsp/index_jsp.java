/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-07-01 14:35:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vo.MemberInfo;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/_inc/incFooter.jsp", Long.valueOf(1624255204000L));
    _jspx_dependants.put("/_inc/incHead.jsp", Long.valueOf(1625148662000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("vo.MemberInfo");
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
      out.write(" \r\n");
      out.write('\r');
      out.write('\n');
 
String incSrc = request.getContextPath() + "/_inc/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(incSrc );
      out.write("/css/reset1.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(incSrc );
      out.write("/css/base1.css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(incSrc );
      out.write("/css/layout1.css\" />\r\n");
      out.write(" \t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(incSrc );
      out.write("/css/main1.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t\t<h1 class=\"logo\"><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_logo_150_177.png\" width=\"159\" height=\"177\" alt=\"??????\" onclick = \"location.href ='index.jsp'\" /></a></h1>\r\n");
      out.write("\t\t<ul id=\"infoMenu\">\r\n");
      out.write("\t\t\t<li><a href=\"member/join_form.jsp\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_upper_77_17_join.png\" width=\"77\" height=\"17\" alt=\"?????? ??????\" class=\"hand\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_ov_80_19_join.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_77_17_join.png';\"/></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"member/mypage_form.jsp\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_upper_97_16_mypage.png\" width=\"97\" height=\"16\" alt=\"???????????????\"  class=\"hand\"  onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_ov_100_18_mypage.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_97_16_mypage.png';\"/></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_upper_58_17_event.png\" width=\"58\" height=\"17\" alt=\"?????????\"  class=\"hand\"  onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_ov_61_20_event.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_58_17_event.png';\"/></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_upper_77_18_center.png\" width=\"77\" height=\"18\" alt=\"????????????\" class=\"hand\"  onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_ov_81_20_center.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_77_18_center.png';\"/></a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<ul id=\"navigation\">\r\n");
      out.write("\t\t\t<li id = \"navi\"><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_menu_126_27_tourInfo.png\" width=\"126\" height=\"27\" alt=\"?????? ??????\" class=\"hand\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_ov_130_29_tourInfo.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_126_27_tourInfo.png';\"/></a>\t</li>\r\n");
      out.write("\t\t\t<li id = \"navi\"><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_menu_57_27_hotel.png\" width=\"57\" height=\"27\" alt=\"??????\" class=\"hand\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_ov_60_29_hotel.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_57_27_hotel.png';\"/></a></li>\r\n");
      out.write("\t\t\t<li id = \"navi\"><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_menu_87_27_flight.png\" width=\"87\" height=\"27\" alt=\"?????????\" class=\"hand\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_ov_90_29_flight.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_87_27_flight.png';\"/></a></li>\r\n");
      out.write("\t\t\t<li id = \"navi\"><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_menu_85_26_planner.png\" width=\"85\" height=\"26\" alt=\"?????????\" class=\"hand\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_ov__90_26_planner.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_85_26_planner.png';\"/></a></ul>\r\n");
      out.write("\t\t<ul id=\"naviSub\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_submenu_28_13_all.png\" width=\"28\" height = \"13\" alt = \"????????\" class=\"naviSubs\"  onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_ov_31_15_all.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_28_13_all.png';\"/></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_submenu_78_14_addMem.png\" width=\"78\" height = \"14\" alt = \"????????? ??????\"  class=\"naviSubs\"onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_ov_80_15_addMem.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_78_14_addMem.png';\"/></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_submenu_78_14_makePlan.png\" width=\"78\" height = \"14\" alt = \"?????? ?????????\"  class=\"naviSubs\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_ov_81_15_makePlan.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_78_14_makePlan.png';\"/></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_submenu_93_14_sharePlan.png\" width=\"93\" height = \"14\" alt = \"?????? ????????????\" class=\"naviSubs\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_ov_96_15_sharePlan.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_93_14_sharePlan.png';\"/></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_submenu_93_14_chkPlan.png\" width=\"93\" height = \"13\" alt = \"?????? ????????????\"  class=\"naviSubs\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_ov_96_15_chkPlan.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_93_14_chkPlan.png';\"/></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>");
      out.write("   \r\n");
      out.write("\t\r\n");
      out.write("\t");


	MemberInfo loginMember = (MemberInfo) session.getAttribute("loginMember");
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
	if (loginMember == null) { 
      out.write("\r\n");
      out.write("\t\t\t<a href=\"login_form.jsp\">?????????</a>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t");
	} else { 
      out.write("\r\n");
      out.write("\t\t\t");
      out.print(loginMember.getMi_id());
      out.write('(');
      out.print(loginMember.getMi_name());
      out.write(") ?????????\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<a href=\"logout.jsp\">????????????</a>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t");
 	} 
      out.write("\r\n");
      out.write("\t<hr />\r\n");
      out.write("\t\r\n");
      out.write("\t<!--[[?????????]] -->\r\n");
      out.write("\t<a href=\"javascript:alert('??????????????????.')\">???????????????</a><br />\r\n");
      out.write("\t<hr />\r\n");
      out.write("\t\r\n");
      out.write("\t<!--[[??????]] -->\r\n");
      out.write("\t<a href=\"hotel_list.hotel\">???????????????</a><br />\r\n");
      out.write("\t<a href=\"\"></a>\r\n");
      out.write("\t<hr />\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- [[SNS ?????????]] -->\t\r\n");
      out.write("\t<a href=\"\">SNS ????????? ???</a><br />\r\n");
      out.write("\t<a href=\"\"></a>\r\n");
      out.write("\t<hr />\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- [[?????????]] -->\t \r\n");
      out.write("\t<a href=\"food_list.food\">????????? ?????????</a><br />\r\n");
      out.write("\t<hr />\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- [[?????????]] -->\t\r\n");
      out.write("\t<a href=\"\">???????????????</a><br />\r\n");
      out.write("\t<a href=\"\"></a>\r\n");
      out.write("\t<hr />\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<a href=\"\"></a>\r\n");
      out.write("\t<hr />\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<div id = \"footer\">\r\n");
      out.write("\t<div class=\"footerInner\">\r\n");
      out.write("\t\t<p class=\"footerLogo\"><img src=\"/_inc/footer/footer_logo_100_127.png\" width=\"100\" height=\"127\" alt=\"??????\" /></p>\r\n");
      out.write("\t\t\t<ul class=\"guideMenu\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">????????????</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">????????????????????????</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">?????????????????????????????????</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Contact Us</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Site map</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">QnA</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">?????? ??????</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<address>\r\n");
      out.write("\t\t\t\t<span class=\"addr\">?? ????????? ????????? ????????? 123-12 ???????????? 5???</span><br />\r\n");
      out.write("\t\t\t\t<span class=\"tel\">?? ?????? : 02-1234-5678</span><br />\r\n");
      out.write("\t\t\t\t<span class=\"fax\">?? FAX : 02-9876-5432</span><br />\r\n");
      out.write("\t\t\t\t<span class=\"email\">?? E-MAIL : webmaster@mail.com</span><br />\r\n");
      out.write("\t\t\t\t<span class=\"copyright\">?? Copyright ??? WebCafe CONRPORATION ALL RIGHTSRESERVED.</span>\r\n");
      out.write("\t\t\t</address>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write(' ');
      out.write(' ');
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-06-21 00:40:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vo.*;
import vo.*;

public final class pdt_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/product/../_inc/incHead.jsp", Long.valueOf(1623899498000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

request.setCharacterEncoding("utf-8");

MemberInfo loginMember = (MemberInfo)session.getAttribute("loginMember");
boolean isLogin = false;
if (loginMember != null)	isLogin = true;

      out.write("\r\n");
      out.write("<a href=\"/mvcSite/\">인덱스</a>\r\n");
      out.write('\r');
      out.write('\n');

ProductInfo pdtInfo = (ProductInfo)request.getAttribute("pdtInfo");
if (pdtInfo == null) {
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다.');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script>\r\n");
      out.write("var cnt = 1;\r\n");
      out.write("var total = ");
      out.print(pdtInfo.getPi_price() );
      out.write(";\r\n");
      out.write("function changeCnt(op) {\r\n");
      out.write("\tvar obj1 = document.getElementById(\"occnt\");\r\n");
      out.write("\tvar obj2 = document.getElementById(\"total\");\r\n");
      out.write("\tif (op == \"+\") {\r\n");
      out.write("\t\tcnt = cnt + 1;\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\tif (cnt > 1)\tcnt = cnt - 1;\r\n");
      out.write("\t}\r\n");
      out.write("\tobj1.innerHTML = cnt;\t// 수량변경\r\n");
      out.write("\tobj2.innerHTML = (cnt * total);\t// 총 구매가 변경\r\n");
      out.write("\tdocument.frmPdt.occnt.value = cnt;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function cartBuy(chk) {\r\n");
      out.write("// 장바구니나 즉시 구매로 이동시키는 함수로 비로그인 시 로그인 폼으로 이동시켜야 함\r\n");
      out.write("// 장바구니 : cart_in_proc.ord / 즉시 구매 : order_form.ord\r\n");
      out.write("\tvar lnk = \"\";\r\n");
      out.write("\tif (chk == \"c\")\tlnk = \"cart_in_proc.ord\";\r\n");
      out.write("\telse\t\t\tlnk = \"order_form.ord\";\r\n");
 if (!isLogin) { 
      out.write("\r\n");
      out.write("\tlocation.href = \"login_form.jsp?url=\" + lnk;\r\n");
 } else { 
      out.write("\r\n");
      out.write("\tvar frm = document.frmPdt;\r\n");
      out.write("\tfrm.action = lnk;\r\n");
      out.write("\tfrm.submit();\r\n");
 } 
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"800\" cellpadding=\"0\">\r\n");
      out.write("<tr align=\"center\"><td>\r\n");
      out.write("\t<!-- 상품 이미지 및 상품 정보 보기 영역 시작 -->\r\n");
      out.write("\t<table width=\"100%\" cellpadding=\"5\">\r\n");
      out.write("\t<tr align=\"center\">\r\n");
      out.write("\t<td width=\"55%\">\r\n");
      out.write("\t\t<table width=\"100%\">\r\n");
      out.write("\t\t<tr><td align=\"center\" valign=\"middle\">\r\n");
      out.write("\t\t\t<img src=\"product/pdt_img/");
      out.print(pdtInfo.getPi_img1());
      out.write("\" width=\"300\" height=\"300\" />\r\n");
      out.write("\t\t</td></tr>\r\n");
      out.write("\t\t<tr><td align=\"center\" valign=\"middle\">\r\n");
      out.write("\t\t\t<img src=\"product/pdt_img/");
      out.print(pdtInfo.getPi_img1());
      out.write("\" width=\"50\" height=\"50\" />\r\n");
 if (pdtInfo.getPi_img2() != null && !pdtInfo.getPi_img2().equals("")) { 
      out.write("\r\n");
      out.write("\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<img src=\"product/pdt_img/");
      out.print(pdtInfo.getPi_img2());
      out.write("\" width=\"50\" height=\"50\" />\r\n");
 } 
      out.write('\r');
      out.write('\n');
 if (pdtInfo.getPi_img3() != null && !pdtInfo.getPi_img3().equals("")) { 
      out.write("\r\n");
      out.write("\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<img src=\"product/pdt_img/");
      out.print(pdtInfo.getPi_img3());
      out.write("\" width=\"50\" height=\"50\" />\r\n");
 } 
      out.write("\r\n");
      out.write("\t\t</td></tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td width=\"*\" valign=\"top\">\r\n");
      out.write("\t\t<table width=\"100%\" cellpadding=\"3\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th width=\"25%\">분류</th>\r\n");
      out.write("\t\t<td width=\"*\">");
      out.print(pdtInfo.getCb_name() + " -> " + pdtInfo.getCs_name() );
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr><th>브랜드</th><td>");
      out.print(pdtInfo.getB_name() );
      out.write("</td></tr>\r\n");
      out.write("\t\t<tr><th>상품명</th><td>");
      out.print(pdtInfo.getPi_name() );
      out.write("</td></tr>\r\n");
      out.write("\t\t<tr><th>판매가</th><td>");
      out.print(pdtInfo.getPi_price() );
      out.write("</td></tr>\r\n");
      out.write("\t\t<tr><th>할인율</th><td>");
      out.print(pdtInfo.getPi_discount() );
      out.write("%</td></tr>\r\n");
      out.write("\t\t<tr><th>별점평균</th>\r\n");
      out.write("\t\t<td>");
      out.print((pdtInfo.getPi_star() == 0.0) ? "별점 없음" : pdtInfo.getPi_star() + "점" );
      out.write("</td></tr>\r\n");
      out.write("\t\t<form name=\"frmPdt\" action=\"\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"piid\" value=\"");
      out.print(pdtInfo.getPi_id() );
      out.write("\" />\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"occnt\" value=\"1\" />\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th>수량</th>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"-\" onclick=\"changeCnt(this.value);\" />\r\n");
      out.write("\t\t\t<span id=\"cnt\">1</span>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"+\" onclick=\"changeCnt(this.value);\" />\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");

if (pdtInfo.getPi_option() != null && !pdtInfo.getPi_option().equals("")) {
	String[] arrOpt = pdtInfo.getPi_option().split(";");

      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th>옵션</th>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<select name=\"ocoption\">\r\n");
      out.write("\t\t\t\t<option value=\"\">도수 선택</option>\r\n");
	for (int i = 0 ; i < arrOpt.length ; i++) { 
      out.write("\r\n");
      out.write("\t\t\t\t<option value=\"");
      out.print(arrOpt[i]);
      out.write('"');
      out.write('>');
      out.print(arrOpt[i]);
      out.write("</option>\r\n");
	} 
      out.write("\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
 } 
      out.write("\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<tr><td colspan=\"2\" align=\"right\">\r\n");
      out.write("\t\t\t총 구매가격 : <span id=\"total\">");
      out.print(pdtInfo.getPi_price() );
      out.write("</span> 원\r\n");
      out.write("\t\t</td></tr>\r\n");
      out.write("\t\t<tr><td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"장바구니 담기\" onclick=\"cartBuy('c');\" />\r\n");
      out.write("\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"즉시 구매하기\" onclick=\"cartBuy('d');\" />\r\n");
      out.write("\t\t</td></tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<!-- 상품 이미지 및 상품 정보 보기 영역 종료 -->\r\n");
      out.write("</td></tr>\r\n");
      out.write("</table>\r\n");
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
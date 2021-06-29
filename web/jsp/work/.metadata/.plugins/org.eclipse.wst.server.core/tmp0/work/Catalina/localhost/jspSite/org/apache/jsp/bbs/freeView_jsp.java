/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-06-08 06:56:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.bbs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import mem.*;

public final class freeView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.net");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("mem");
    _jspx_imports_packages.add("javax.sql");
    _jspx_imports_packages.add("javax.naming");
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
      out.write("\r\n");
      out.write("\r\n");

String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/testmall?useUnicode=true&characterEncoding=UTF8";
url += "&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String sql = null;

MemberInfo login_info = (MemberInfo)session.getAttribute("login_info");

request.setCharacterEncoding("utf-8");
int idx = Integer.parseInt(request.getParameter("idx"));		// 글번호
int cpage = Integer.parseInt(request.getParameter("cpage"));	// 페이지번호
String schType = request.getParameter("schType");
String keyword = request.getParameter("keyword");

String args = "?cpage=" + cpage, schargs = "";
if (schType != null && keyword != null) {
	URLEncoder.encode(keyword, "UTF-8");
	schargs = "&schType=" + schType + "&keyword=" + keyword;
	args += schargs;
} // 쿼리 스트링으로 URL에 넣을 값들을 args 변수에 담음

String bf_ismem = "", bf_pwd = "", bf_writer = "";
String bf_title = "", bf_content = "", bf_date = "";
int bf_read = 0;
try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "root", "1234");
	stmt = conn.createStatement();
	sql = "select * from t_brd_free where bf_idx = " + idx;
	rs = stmt.executeQuery(sql);
	if (rs.next()) {
		bf_ismem 	= rs.getString("bf_ismem");	bf_writer	= rs.getString("bf_writer");
		bf_title	= rs.getString("bf_title");	bf_content	= rs.getString("bf_content");
		bf_date		= rs.getString("bf_date");	bf_read		= rs.getInt("bf_read");
	} else {
		out.println("<script>");
		out.println("alert('잘못된 경로로 들어오셨습니다.');");
		out.println("history.back();");
		out.println("</script>");
		out.close();
	}

} catch(Exception e) {
	out.println("자유 게시판 조회수 증가 작업 시 오류가 발생했습니다.");
	e.printStackTrace();
}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("#brd th, #brd td { border-bottom:1px black solid; }\r\n");
      out.write("#reply td { border-bottom:2px #efefef solid; }\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("function replyUp(bfridx) {\r\n");
      out.write("\tvar cont = eval(\"document.frm.cont\" + bfridx + \".value\");\r\n");
      out.write("\tvar frm = document.frmReply;\r\n");
      out.write("\tfrm.rcontent.value = cont;\r\n");
      out.write("\tfrm.wtype.value = \"up\";\r\n");
      out.write("\tfrm.bfridx.value = bfridx;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function replyDel(bfridx) {\r\n");
      out.write("\tif (confirm(\"정말 삭제하시겠습니까?\")) {\r\n");
      out.write("\t\tvar frm = document.frmReply;\r\n");
      out.write("\t\tfrm.wtype.value = \"del\";\r\n");
      out.write("\t\tfrm.bfridx.value = bfridx;\r\n");
      out.write("\t\tfrm.submit();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>자유 게시판 내용 보기</h2>\r\n");
      out.write("<table width=\"700\" cellpadding=\"5\" cellspacing=\"0\" id=\"brd\">\r\n");
      out.write("<tr>\r\n");
      out.write("<th width=\"15%\">이름</th><td width=\"18%\">");
      out.print(bf_writer );
      out.write("</td>\r\n");
      out.write("<th width=\"15%\">작성일</th><td width=\"*\">");
      out.print(bf_date );
      out.write("</td>\r\n");
      out.write("<th width=\"15%\">조회수</th><td width=\"5%\">");
      out.print(bf_read );
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr><th>제목</th><td colspan=\"5\">");
      out.print(bf_title );
      out.write("</td></tr>\r\n");
      out.write("<tr><th>내용</th><td colspan=\"5\">");
      out.print(bf_content.replace("\r\n", "<br />") );
      out.write("</td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("<p style=\"width:700px; text-align:center;\">\r\n");

boolean isPermission = false;
String lnk1 = "", lnk2 = "";
if (bf_ismem.equals("n")) {	// 비회원 글이면
	isPermission = true;
	lnk1 = "location.href='freePwd.jsp" + args + "&wtype=up&idx=" + idx + "'";
	lnk2 = "location.href='freePwd.jsp" + args + "&wtype=del&idx=" + idx + "'";
} else if (login_info != null && login_info.getMi_id().equals(bf_writer)) {
// 현재 로그인한 회원이 작성자이면
	isPermission = true;
	lnk1 = "location.href='freeForm.jsp" + args + "&wtype=up&idx=" + idx + "'";
	lnk2 = "isDel();";
}

if (isPermission) {
	if (bf_ismem.equals("y")) {

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function isDel() {\r\n");
      out.write("\tif (confirm(\"정말 삭제하시겠습니까?\")) {\r\n");
      out.write("\t\tlocation.href = \"freeProc.jsp?wtype=del&idx=");
      out.print(idx);
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
	} 
      out.write("\r\n");
      out.write("\t<input type=\"button\" value=\"수 정\" onclick=\"");
      out.print(lnk1 );
      out.write("\" />&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"button\" value=\"삭 제\" onclick=\"");
      out.print(lnk2 );
      out.write("\" />&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
 } 
      out.write("\r\n");
      out.write("\t<input type=\"button\" value=\"목 록\" onclick=\"location.href='freeList.jsp");
      out.print(args );
      out.write("';\" />\r\n");
      out.write("</p>\r\n");
      out.write("<!-- 댓글 관련 기능 -->\r\n");

String ord = request.getParameter("ord");	// 댓글 정렬 기준
if (ord == null) ord = "asc";

      out.write("\r\n");
      out.write("<form name=\"frmReply\" action=\"freeReplyProc.jsp");
      out.print(args );
      out.write("\" method=\"post\">\r\n");
      out.write("<input type=\"hidden\" name=\"wtype\" value=\"in\" />\r\n");
      out.write("<input type=\"hidden\" name=\"idx\" value=\"");
      out.print(idx );
      out.write("\" />\r\n");
      out.write("<input type=\"hidden\" name=\"bfridx\" value=\"\" />\r\n");
      out.write("<input type=\"hidden\" name=\"ord\" value=\"");
      out.print(ord );
      out.write("\" />\r\n");
      out.write("<div id=\"reply\" style=\"width:700px; height:60px; border:1px solid black; padding:5px;\">\r\n");
      out.write("\t<textarea name=\"rcontent\" style=\"width:550px; height:50px; float:left;\" \r\n");
      out.write("\t");
 if (login_info == null) { 
      out.write("onfocus=\"alert('로그인 후에 사용하실 수 있습니다.'); this.blur();\"");
 } 
      out.write('>');
 if (login_info == null) { 
      out.write("댓글 기능은 로그인 후에 사용할 수 있습니다.");
 } 
      out.write("</textarea>\r\n");
      out.write("\t<input type=\"submit\" value=\"댓 글\" style=\"width:130px; height:55px; margin-left:10px;\" />\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("<hr align=\"left\" style=\"width:700px;\" />\r\n");

out.println("댓글 정렬 : ");
if (ord.equals("asc")) {
	out.println("▲");
	out.println("<a href='freeView.jsp" + args + "&idx=" + idx + "&ord=desc'>▽</a>");
} else {
	out.println("<a href='freeView.jsp" + args + "&idx=" + idx + "&ord=asc'>△</a>");
	out.println("▼");
}

      out.write("\r\n");
      out.write("<br />\r\n");
      out.write("<form name=\"frm\">\r\n");

try {
	sql = "select * from t_brd_free_reply where bf_idx = " + 
		idx + " order by bfr_idx " + ord;
	rs = stmt.executeQuery(sql);
	if (rs.next()) {
		boolean isPms = false;
		out.println("<table width='700' cellpadding='10' cellspacing='0' id='reply'>");
		do {
			isPms = false;
			if (login_info != null && rs.getString("mi_id").equals(login_info.getMi_id())) {
				isPms = true;
			}

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td width=\"15%\">");
      out.print(rs.getString("mi_id") );
      out.write("</td>\r\n");
      out.write("<td width=\"*\">");
      out.print(rs.getString("bfr_content").replace("\r\n", "<br />") );
      out.write("</td>\r\n");
      out.write("<td width=\"26%\" align=\"right\" valign=\"top\">\r\n");
      out.write("\t");
      out.print(rs.getString("bfr_date").substring(5) );
      out.write("\r\n");
      out.write("\t<a href=\"javascript:");
 if (isPms) { 
      out.write("replyUp(");
      out.print(rs.getInt(1));
      out.write(')');
      out.write(';');
 } else { 
      out.write("alert('수정 권한이 없습니다.');");
 } 
      out.write("\">[u]</a>\r\n");
      out.write("\t<a href=\"javascript:");
 if (isPms) { 
      out.write("replyDel(");
      out.print(rs.getInt(1));
      out.write(')');
      out.write(';');
 } else { 
      out.write("alert('삭제 권한이 없습니다.');");
 } 
      out.write("\">[x]</a>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<input type=\"hidden\" name=\"cont");
      out.print(rs.getInt(1));
      out.write("\" value=\"");
      out.print(rs.getString("bfr_content"));
      out.write("\" />\r\n");

		} while(rs.next());
		out.println("</table>");
	} else {

      out.write("\r\n");
      out.write("<div id=\"reply\" style=\"width:700px; height:60px; border:1px solid black; text-align:center;\">\r\n");
      out.write("\t<br />등록된 댓글이 없습니다.\r\n");
      out.write("</div>\r\n");

	}
} catch(Exception e) {
	e.printStackTrace();
} finally {
	try {
		rs.close();		stmt.close();	conn.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
}

      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("<br /><br />\r\n");
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

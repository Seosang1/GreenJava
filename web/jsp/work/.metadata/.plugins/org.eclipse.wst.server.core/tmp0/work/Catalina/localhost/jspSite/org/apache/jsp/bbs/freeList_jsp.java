/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-06-08 06:56:02 UTC
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

public final class freeList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

MemberInfo login_info = (MemberInfo)session.getAttribute("login_info");
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/testmall?useUnicode=true&characterEncoding=UTF8";
url += "&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

request.setCharacterEncoding("utf-8");
int cpage = 1, psize = 2, bsize = 5, rcnt = 0, pcnt = 0;
// 현재 페이지번호, 페이지크기, 블록크기, 게시글 개수, 페이지개수를 저장한 변수

String tmpPage = request.getParameter("cpage");
if (tmpPage != null)	cpage = Integer.parseInt(tmpPage);
// 받아온 페이지 번호가 있으면 무조건 정수이므로 int형으로 형변환

String schType = request.getParameter("schType");	// 검색조건
String keyword = "";
if (schType != null)	keyword = request.getParameter("keyword").trim();
// 검색조건 중 schType의 값이 있을 경우에만 검색어(keyword)를 받아옴
else	schType = "";

String schargs = ""; // 검색관련 쿼리스트링을 저장할 변수
String where = "";	// 검색조건이 있을 경우 where절을 저장할 변수
if (!schType.equals("") && !keyword.equals("")) {	// 검색조건과 검색어가 있을 경우
	URLEncoder.encode(keyword, "UTF-8");
	// 쿼리스트리으로 주고 받는 검색어가 한글일 경우 IE에서 간혹 문제가 발생하므로 유니코드로 전환시켜 사용

	if (schType.equals("tc")) {	// 검색조건이 '제목+내용'일 경우
		where = " where bf_title like '%" + keyword + 
			"%' or bf_content like '%" + keyword + "%' ";
	} else {
		where = " where bf_" + schType + " like '%" + keyword + "%' ";
	}
	schargs += "&schType=" + schType + "&keyword=" + keyword;
}

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "root", "1234");
	stmt = conn.createStatement();

	// 전체 게시글의 개수를 받아오는 쿼리
	String sql = "select count(*) from t_brd_free " + where;
	rs = stmt.executeQuery(sql);
	rs.next();	rcnt = rs.getInt(1);
	// count()함수를 사용하므로 데이터의 유무는 검사할 필요가 없으나 데이터를 사용하려면 next()를 해야 함

	pcnt = rcnt / psize;
	if (rcnt % psize > 0)	pcnt++;	// 전체 페이지 개수

	int snum = (cpage - 1) * psize;	// limit 절의 시작 인덱스 번호
	sql = "select bf_idx, bf_writer, bf_title, bf_reply, bf_read, bf_date " + 
	" from t_brd_free " + where + " order by bf_idx desc limit " + snum + ", " + psize;
	rs = stmt.executeQuery(sql);

} catch(Exception e) {
	out.println("자유 게시판 목록화면 작업 시 오류가 발생했습니다.");
	e.printStackTrace();
}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("#brd th { border-bottom:3px black double; }\r\n");
      out.write("#brd td { border-bottom:1px black solid; }\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("function goPage(page) {\r\n");
      out.write("\tlocation.href = \"freeList.jsp?cpage=\" + page + \"");
      out.print(schargs);
      out.write("\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>자유 게시판 목록 화면</h2>\r\n");
      out.write("<table width=\"700\" cellpadding=\"5\" cellspacing=\"0\" id=\"brd\">\r\n");
      out.write("<tr>\r\n");
      out.write("<th width=\"8%\">번호</th><th width=\"*\">제목</th>\r\n");
      out.write("<th width=\"15%\">작성자</th><th width=\"10%\">조회수</th><th width=\"15%\">작성일</th>\r\n");
      out.write("</tr>\r\n");

boolean isBrd = false;
int num = 0;
if (rs.next()) {
	isBrd = true;
	num = rcnt - (psize * (cpage - 1));
	do {
		String title = rs.getString("bf_title");
		String reply = "";
		if (title.length() > 24)	title = title.substring(0, 24) + "...";
		if (rs.getInt("bf_reply") > 0) {
			reply = " [" + rs.getInt("bf_reply") + "]";
			if (title.length() > 22)	title = title.substring(0, 22) + "...";
		}
		String lnk = "<a href='freePreView.jsp?idx=" + rs.getInt("bf_idx") + 
			"&cpage=" + cpage + schargs + "'>";

      out.write("\r\n");
      out.write("<tr align=\"center\">\r\n");
      out.write("<td>");
      out.print(num );
      out.write("</td>\r\n");
      out.write("<td align=\"left\">");
      out.print(lnk + title + "</a>" + reply );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(rs.getString("bf_writer") );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(rs.getInt("bf_read") );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(rs.getString("bf_date").substring(2, 11).replace('-', '.') );
      out.write("</td>\r\n");
      out.write("</tr>\r\n");

		num--;
	} while (rs.next());
} else {
	out.println("<tr><td colspan='5' align='center'>검색결과가 없습니다.</td></tr>");
}

      out.write("\r\n");
      out.write("</table><br />\r\n");
      out.write("<table width=\"700\" cellpadding=\"5\" cellspacing=\"0\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td width=\"*\" align=\"center\">\r\n");

if (isBrd) {	// 게시글이 있으면 페이징 영역을 보여줌 
	if (cpage == 1) {
		out.println("<<&nbsp;&nbsp;<&nbsp;&nbsp;");
	} else {
		out.println("<a href='javascript:goPage(1);'>&lt;&lt;</a>&nbsp;&nbsp;");
		out.println("<a href='javascript:goPage(" + (cpage - 1) + ");'>&lt;</a>&nbsp;&nbsp;");
	}

	int spage = (cpage - 1) / bsize * bsize + 1;
	for (int i = 1, j = spage ; i <= bsize && j <= pcnt ; i++, j++) {
	// i : 블록에서 보여줄 페이지의 개수만큼 루프를 돌릴 조건으로 사용되는 변수
	// j : 실제 출력할 페이지 번호로 전체 페이지 개수(마지막 페이지 번호)를 넘지 않게 사용해야 함
		if (cpage == j) {
			out.println("&nbsp;<strong>" + j + "</strong>&nbsp;");
		} else {
			out.println("&nbsp;<a href='javascript:goPage(" + j + ");'>" + j + "</a>&nbsp;");
		}
	}

	if (cpage == pcnt) {
		out.println("&nbsp;&nbsp;>&nbsp;&nbsp;>>");
	} else {
		out.println("<a href='javascript:goPage(" + (cpage + 1) + ");'>&gt;</a>&nbsp;&nbsp;");
		out.println("<a href='javascript:goPage(" + pcnt + ");'>&gt;&gt;</a>");
	}
}

      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"10%\" align=\"right\">\r\n");
      out.write("\t<input type=\"button\" value=\"글쓰기\" onclick=\"location.href='freeForm.jsp?wtype=in';\" />\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<form name=\"frmSch\" method=\"get\">\r\n");
      out.write("<tr align=\"right\">\r\n");
      out.write("<td colspan=\"2\">\r\n");
      out.write("\t<select name=\"schType\">\r\n");
      out.write("\t\t<option value=\"title\" ");
 if (schType.equals("title")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">제목</option>\r\n");
      out.write("\t\t<option value=\"content\" ");
 if (schType.equals("content")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">내용</option>\r\n");
      out.write("\t\t<option value=\"tc\" ");
 if (schType.equals("tc")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">제목+내용</option>\r\n");
      out.write("\t\t<option value=\"writer\" ");
 if (schType.equals("writer")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">작성자</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t<input type=\"text\" name=\"keyword\" value=\"");
      out.print(keyword );
      out.write("\" />\r\n");
      out.write("\t<input type=\"submit\" value=\"검 색\" />\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</form>\r\n");
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

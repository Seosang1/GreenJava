/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-06-08 06:40:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vo.*;

public final class notice_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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

ArrayList<NoticeInfo> articleList = 
	(ArrayList<NoticeInfo>)request.getAttribute("articleList");
// 화면에서 보여줄 게시글 목록을 ArrayList로 받아옴
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
// 페이징에 필요한 각종 데이터들을 PageInfo형 인스턴스에 담음
// attribute에 들어있는 데이터들은 Object로 되어 있기 때문에 사용하려면 해당 자료형으로 형변환을 해야 함

int cpage = pageInfo.getCpage();	// 현재 페이지 번호
int pcnt = pageInfo.getPcnt();		// 전체 페이지 개수
int rcnt = pageInfo.getRcnt();		// 전체 게시글 개수
int spage = pageInfo.getSpage();	// 블록 시작 페이지 번호
int epage = pageInfo.getEpage();	// 블록 종료 페이지 번호
int psize = pageInfo.getPsize();	// 페이지 크기
int bsize = pageInfo.getBsize();	// 블록 크기

String schargs = "", args = "";
// 검색 쿼리스트링, 전체 쿼리스트링
String schtype = pageInfo.getSchtype();	// 검색조건
String keyword = pageInfo.getKeyword();	// 검색어
if (schtype == null || keyword == null) {	// 검색을 하지 않은 경우
	schtype = "";	keyword = "";
} else if (!keyword.equals("")) {	// 검색어가 있으면
	schargs = "&schtype=" + schtype + "&keyword=" + keyword;
	// 검색어가 있을 경우 검색관련 데이터를 쿼리스트링으로 지정
}
args = "&cpage=" + cpage + schargs;

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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>공지사항 목록 화면</h2>\r\n");
      out.write("<table width=\"700\" cellpadding=\"5\" cellspacing=\"0\" id=\"brd\">\r\n");
      out.write("<tr>\r\n");
      out.write("<th width=\"10%\">번호</th><th width=\"*\">제목</th>\r\n");
      out.write("<th width=\"10%\">조회수</th><th width=\"15%\">작성일</th>\r\n");
      out.write("</tr>\r\n");

if (articleList.size() > 0 && rcnt > 0) {	// 보여줄 목록이 있으면
	int num = rcnt - (psize * (cpage - 1));
	String title = "", lnk = "";
	for (int i= 0 ; i < articleList.size() ; i++) {
		title = articleList.get(i).getBn_title();
		lnk = "<a href='brd_view.ntc?idx=" + articleList.get(i).getBn_idx() + 
			args + "' title='" + title + "'>";
		if (title.length() > 28)	title = title.substring(0, 26) + "...";

      out.write("\r\n");
      out.write("<tr align=\"center\">\r\n");
      out.write("<td>");
      out.print(num );
      out.write("</td><td align=\"left\">");
      out.print(lnk + title + "</a>" );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(articleList.get(i).getBn_read() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(articleList.get(i).getBn_date().substring(2, 11).replace('-', '.') );
      out.write("</td>\r\n");
      out.write("</tr>\r\n");

		num--;
	}
}

      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<table width=\"700\" cellpadding=\"5\" cellspacing=\"0\">\r\n");
      out.write("<tr><td align=\"center\">\r\n");

if (rcnt > 0) {	// 게시글이 있을 경우
	if (cpage == 1) {	// 현재 페이지 번호가 1이면
		out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
	} else {
		out.print("<a href='brd_list.ntc?cpage=1" + schargs + "'>");
		out.println("[&lt;&lt;]</a>&nbsp;&nbsp;");
		out.print("<a href='brd_list.ntc?cpage=" + (cpage - 1) + schargs + "'>");
		out.println("[&lt;]</a>&nbsp;&nbsp;");
	} // 첫 페이지와 이전 페이지 링크

	for (int i = 1, j = spage ; i <= bsize && j <= epage ; i++, j++) {
	// i : 루프돌릴 횟수를 검사하는 용도의 변수, j : 페이지 번호 출력용 변수
	// 조건 : bsize만큼 루프를 도는데 페이지가 마지막 페이지일 경우 bsize보다 작아도 멈춤
		if (cpage == j) {	// 현재 페이지 번호일 경우 링크없이 강조만 함
			out.print("&nbsp;<strong>" + j + "</strong>&nbsp;");
		} else {
			out.print("&nbsp;<a href='brd_list.ntc?cpage=" + j + schargs + "'>");
			out.print(j + "</a>&nbsp;");
		}
	}

	if (cpage == pcnt) {	// 현재 페이지번호가 마지막 페이지 번호이면
		out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
	} else {
		out.println("&nbsp;&nbsp;<a href='brd_list.ntc?cpage=" + 
			(cpage + 1) + schargs + "'>[&gt;]</a>");
		out.print("&nbsp;&nbsp;<a href='brd_list.ntc?cpage=" + pcnt + schargs + "'>");
		out.println("[&gt;&gt;]</a>");
	}

} else {	// 게시글이 없을 경우 : 페이징 생략
	out.println("검색결과가 없습니다.");
}

      out.write("\r\n");
      out.write("</td></tr>\r\n");
      out.write("<form name=\"frmSch\" method=\"get\">\r\n");
      out.write("<tr align=\"right\"><td>\r\n");
      out.write("\t<select name=\"schtype\">\r\n");
      out.write("\t\t<option value=\"title\" ");
 if (schtype.equals("title")) { 
      out.write("selected");
 } 
      out.write(">제목</option>\r\n");
      out.write("\t\t<option value=\"content\" ");
 if (schtype.equals("content")) { 
      out.write("selected");
 } 
      out.write(">내용</option>\r\n");
      out.write("\t\t<option value=\"tc\" ");
 if (schtype.equals("tc")) { 
      out.write("selected");
 } 
      out.write(">제목+내용</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t<input type=\"text\" name=\"keyword\" value=\"");
      out.print(keyword );
      out.write("\" />\r\n");
      out.write("\t<input type=\"submit\" value=\"검 색\" />\r\n");
      out.write("</td></tr>\r\n");
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
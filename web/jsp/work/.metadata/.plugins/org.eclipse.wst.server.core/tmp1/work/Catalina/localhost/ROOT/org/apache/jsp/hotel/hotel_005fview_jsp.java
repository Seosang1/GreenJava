/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-07-01 16:36:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.hotel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vo.*;

public final class hotel_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/hotel/../_inc/incFooter.jsp", Long.valueOf(1624255204000L));
    _jspx_dependants.put("/hotel/../_inc/incHead.jsp", Long.valueOf(1625148662000L));
  }

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
      out.write("/header/header_logo_150_177.png\" width=\"159\" height=\"177\" alt=\"로고\" onclick = \"location.href ='index.jsp'\" /></a></h1>\r\n");
      out.write("\t\t<ul id=\"infoMenu\">\r\n");
      out.write("\t\t\t<li><a href=\"member/join_form.jsp\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_upper_77_17_join.png\" width=\"77\" height=\"17\" alt=\"회원 가입\" class=\"hand\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_ov_80_19_join.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_77_17_join.png';\"/></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"member/mypage_form.jsp\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_upper_97_16_mypage.png\" width=\"97\" height=\"16\" alt=\"마이페이지\"  class=\"hand\"  onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_ov_100_18_mypage.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_97_16_mypage.png';\"/></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_upper_58_17_event.png\" width=\"58\" height=\"17\" alt=\"이벤트\"  class=\"hand\"  onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_ov_61_20_event.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_58_17_event.png';\"/></a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_upper_77_18_center.png\" width=\"77\" height=\"18\" alt=\"고객센터\" class=\"hand\"  onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_ov_81_20_center.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_upper_77_18_center.png';\"/></a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<ul id=\"navigation\">\r\n");
      out.write("\t\t\t<li id = \"navi\"><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_menu_126_27_tourInfo.png\" width=\"126\" height=\"27\" alt=\"여행 정보\" class=\"hand\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_ov_130_29_tourInfo.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_126_27_tourInfo.png';\"/></a>\t</li>\r\n");
      out.write("\t\t\t<li id = \"navi\"><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_menu_57_27_hotel.png\" width=\"57\" height=\"27\" alt=\"숙박\" class=\"hand\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_ov_60_29_hotel.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_57_27_hotel.png';\"/></a></li>\r\n");
      out.write("\t\t\t<li id = \"navi\"><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_menu_87_27_flight.png\" width=\"87\" height=\"27\" alt=\"항공권\" class=\"hand\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_ov_90_29_flight.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_87_27_flight.png';\"/></a></li>\r\n");
      out.write("\t\t\t<li id = \"navi\"><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_menu_85_26_planner.png\" width=\"85\" height=\"26\" alt=\"플래너\" class=\"hand\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_ov__90_26_planner.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_menu_85_26_planner.png';\"/></a></ul>\r\n");
      out.write("\t\t<ul id=\"naviSub\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_submenu_28_13_all.png\" width=\"28\" height = \"13\" alt = \"��ü\" class=\"naviSubs\"  onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_ov_31_15_all.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_28_13_all.png';\"/></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_submenu_78_14_addMem.png\" width=\"78\" height = \"14\" alt = \"동행인 구인\"  class=\"naviSubs\"onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_ov_80_15_addMem.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_78_14_addMem.png';\"/></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_submenu_78_14_makePlan.png\" width=\"78\" height = \"14\" alt = \"일정 만들기\"  class=\"naviSubs\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_ov_81_15_makePlan.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_78_14_makePlan.png';\"/></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_submenu_93_14_sharePlan.png\" width=\"93\" height = \"14\" alt = \"일정 공유하기\" class=\"naviSubs\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_ov_96_15_sharePlan.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_93_14_sharePlan.png';\"/></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\"><img src=\"");
      out.print(incSrc );
      out.write("/header/header_submenu_93_14_chkPlan.png\" width=\"93\" height = \"13\" alt = \"일정 확인하기\"  class=\"naviSubs\" onmouseover= \"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_ov_96_15_chkPlan.png';\" onmouseout =\"this.incSrc='");
      out.print(incSrc );
      out.write("/header/header_submenu_93_14_chkPlan.png';\"/></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>");
      out.write('\r');
      out.write('\n');

	request.setCharacterEncoding("utf-8");
	Common common = new Common();
	
	// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼ 
	HotelInfo hotelInfo = (HotelInfo)request.getAttribute("hotelInfo");
	ArrayList<RoomInfo> roomList = (ArrayList<RoomInfo>) request.getAttribute("roomList");
	ArrayList<ReplyInfo> replyList = (ArrayList<ReplyInfo>) request.getAttribute("replyList");
	HashMap<String, String> mapSchargs = (HashMap<String, String>) request.getAttribute("schargs");
	String schargs = "";

	// ▼▼▼ 검색관련 쿼리스트링 제작 ▼▼▼ 
	for (String key : mapSchargs.keySet()) {
		schargs += "&" + key + "=" + mapSchargs.get(key);
	}
	// System.out.println("hotel_view.jsp schargs : "+ schargs);
	// &sdate=2021-06-09&name=해비치&hotel_code=A0003&type=RST&edate=2021-07-07

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- content 영역 시작 -->\r\n");
      out.write("<div id=\"contents\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- *** Search Layout *** -->\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<form id=\"frm\" name=\"frm\" method=\"get\" action=\"hotel_view.hotel\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"hotel_code\" value=\"");
      out.print(common.nullToString(mapSchargs.get("hotel_code")) );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"type\" value=\"");
      out.print(common.nullToString(mapSchargs.get("type")) );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"name\" value=\"");
      out.print(common.nullToString(mapSchargs.get("name")) );
      out.write("\" />\r\n");
      out.write("\t\t\t<div class=\"box_search01\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>체크인</th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"date\" name=\"sdate\" value=\"");
      out.print(common.nullToString(mapSchargs.get("sdate")) );
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"date\" name=\"edate\" value=\"");
      out.print(common.nullToString(mapSchargs.get("edate")) );
      out.write("\" /></td> \r\n");
      out.write("\t\t\t\t\t\t<th>숙박인원</th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"number\" name=\"txt_cnt\" value=\"");
      out.print(common.nullToString(mapSchargs.get("cnt")) );
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"button\" value=\"조회\" onclick=\"document.frm.submit()\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- *** hotel Info Layout *** -->\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table width=\"750px;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<img src =\"/jejurisong/common/images/HotelImg/");
      out.print(hotelInfo.getHotel_img1() );
      out.write("\" width=\"300px;\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
      out.print(hotelInfo.getHotel_name() );
      out.write("<br/>\r\n");
      out.write("\t\t\t\t\t");
      out.print(common.getArea().get(hotelInfo.getHotel_area()) );
      out.write(' ');
      out.write('|');
      out.write(' ');
      out.print(hotelInfo.getHotel_addr() );
      out.write("<br/>\r\n");
      out.write("\t\t\t\t\t");
      out.print(hotelInfo.getHotel_score() );
      out.write(' ');
      out.write('총');
      out.write(' ');
      out.print(hotelInfo.getHotel_review_cnt() );
      out.write("건의 리뷰<br/>\r\n");
      out.write("\t\t\t\t\t-----------------------<br />\r\n");
      out.write("\t\t\t\t\t");
      out.print(hotelInfo.getHotel_detail() );
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- *** Room list *** -->\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<table width=\"750px;\">\r\n");
      out.write("\t");

		if (roomList != null && roomList.size() > 0) {
			for (int i = 0; i < roomList.size(); i++) {
				RoomInfo info = roomList.get(i);
				
				String[] arrEq = info.getRoom_eq().split(",");
	
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"180px;\"><img src =\"/jejurisong/common/images/RoomImg/");
      out.print(info.getRoom_img() );
      out.write("\" width=\"150px;\" /></td>\r\n");
      out.write("\t\t\t<td width=\"180px;\">\r\n");
      out.write("\t\t\t\t<strong>");
      out.print(common.getRoomType().get(info.getRoom_type()));
      out.write("</strong> <br />\r\n");
      out.write("\t\t\t\t");
for (int j = 0; j < arrEq.length; j++ ) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t");
      out.print(common.getHoteEquip().get(arrEq[j].trim()) );
      out.write(" \r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"*\">");
      out.print(info.getRoom_svc());
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"150px;\">기본 ");
      out.print(info.getRoom_min());
      out.write("인/최대 ");
      out.print(info.getRoom_max());
      out.write("인</td>\r\n");
      out.write("\t\t\t<td width=\"200px;\"> \r\n");
      out.write("\t\t\t\t");
      out.print(String.format("%,d", info.getRoom_dis_price()));
      out.write("<br />\r\n");
      out.write("\t\t\t\t1박당 객실요금 (세금포함) <br />\r\n");
      out.write("\t\t\t\t 총 금액 : ");
      out.print(String.format("%,d", (info.getRoom_dis_price() * 2)));
      out.write("\r\n");
      out.write("\t\t\t</td width=\"100px;\">\r\n");
      out.write("\t\t\t<td><a href=\"reserve_form.reserve?room_code=");
      out.print(info.getRoom_code() + schargs);
      out.write("\">예약하기</a></td>\t\r\n");
      out.write("\t\t</tr> \r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");

			}
		} else {
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"7\">해당되는 객실이 없습니다. 다른 날을 선택해주세요.</td>\r\n");
      out.write("\t\t</tr>\t\t\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t \r\n");
      out.write("\t \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- *** 후기 list *** -->\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

			if (replyList != null && replyList.size() > 0) { 
				for (int i = 0; i < replyList.size(); i++) {
					ReplyInfo replyInfo = replyList.get(i);
		
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<img src =\"/jejurisong/common/images/MemImg/");
      out.print(replyInfo.getMem_img() );
      out.write("\" width=\"150px;\" /><br />\r\n");
      out.write("\t\t\t\t");
      out.print(replyInfo.getMem_id() );
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t ");
      out.print(replyInfo.getRoom_type() );
      out.write("<br />\r\n");
      out.write("\t\t\t\t ");
      out.print(replyInfo.getRoom_re_content() );
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t");
      out.print(replyInfo.getRoom_re_date() );
      out.write("<br />\r\n");
      out.write("\t\t\t\t");
      out.print(replyInfo.getRoom_re_score() );
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<span> <a href=\"hotel_del_proc.hotel?reply_code=");
      out.print(replyInfo.getRoom_re_idx());
      out.write("\">x</a></span>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t\t");

				}
			}
		
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t \r\n");
      out.write("\t<!-- content 영역 시작 -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- \r\n");
      out.write("\r\n");
      out.write("<div id = \"footer\">\r\n");
      out.write("\t<div class=\"footerInner\">\r\n");
      out.write("\t\t<p class=\"footerLogo\"><img src=\"/_inc/footer/footer_logo_100_127.png\" width=\"100\" height=\"127\" alt=\"로고\" /></p>\r\n");
      out.write("\t\t\t<ul class=\"guideMenu\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">회사소개</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">개인정보보호정책</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">이메일주소무단수집거부</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Contact Us</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Site map</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">QnA</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">제휴 문의</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<address>\r\n");
      out.write("\t\t\t\t<span class=\"addr\">· 서울시 마포구 상수동 123-12 한주빌딩 5층</span><br />\r\n");
      out.write("\t\t\t\t<span class=\"tel\">· 전화 : 02-1234-5678</span><br />\r\n");
      out.write("\t\t\t\t<span class=\"fax\">· FAX : 02-9876-5432</span><br />\r\n");
      out.write("\t\t\t\t<span class=\"email\">· E-MAIL : webmaster@mail.com</span><br />\r\n");
      out.write("\t\t\t\t<span class=\"copyright\">· Copyright ⓒ WebCafe CONRPORATION ALL RIGHTSRESERVED.</span>\r\n");
      out.write("\t\t\t</address>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" -->");
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
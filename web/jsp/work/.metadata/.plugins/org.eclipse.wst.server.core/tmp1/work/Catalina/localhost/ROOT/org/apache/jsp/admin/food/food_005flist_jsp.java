/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-06-21 01:45:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin.food;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vo.*;
import java.util.Arrays;
import vo.*;

public final class food_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/admin/food/../_inc/incAdminFooter.jsp", Long.valueOf(1624198132000L));
    _jspx_dependants.put("/admin/food/../_inc/incAdminHead.jsp", Long.valueOf(1624198132000L));
    _jspx_dependants.put("/admin/food/../_inc/incAdminLeft.jsp", Long.valueOf(1624207058000L));
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Arrays");
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
      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head> \r\n");
      out.write("\t<title>::: [JJRS] 관리자 :::</title>\r\n");
      out.write("\t<link href=\"../admin/common/css/default.css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- wrapper -->\r\n");
      out.write("\t<div class=\"wrapper\">\r\n");
      out.write("\t\t<!-- header -->\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t<div class=\"session\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li class=\"user\"><span>홍길동</span>님 환영합니다.</li>\r\n");
      out.write("\t\t\t\t<!-- <li class=\"download\"><a href=\"#\">매뉴얼 다운로드</a></li> -->\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t<!-- //header -->");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

 
 
String menu = ((String)request.getAttribute("menuPage") != null) ? (String)request.getAttribute("menuPage") : "";

String group1 = "hotel room reply reserve";
int gIdx = group1.indexOf(menu);
String gId = "";
if (gIdx != -1) 	gId="group-1";



      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\r\n");
      out.write("\t  window.addEventListener(\"load\", function(event) {\r\n");
      out.write("\t    console.log(\"All resources finished loading!\");\r\n");
      out.write("\r\n");
      out.write("\t\tdocument.getElementById(\"group-1\").checked = false;\r\n");
      out.write("\t\tdocument.getElementById(\"group-2\").checked = false;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"");
      out.print(gId);
      out.write("\").checked = true;\r\n");
      out.write("\t\t\r\n");
      out.write("\t  });\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t<!-- section -->\r\n");
      out.write("\t\t<section> \r\n");
      out.write("\t\t\t<!-- aside --> \r\n");
      out.write("\t\t\t<aside>\r\n");
      out.write("\t\t\t<h2>Admin Menu</h2>\r\n");
      out.write("\t\t\t\t<!-- side menu -->\r\n");
      out.write("\t\t\t\t<ul class=\"cd-accordion-menu animated\">\r\n");
      out.write("\t\t\t\t\t<li class=\"has-children\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" name=\"group-1\" id=\"group-1\" checked> \r\n");
      out.write("\t\t\t\t\t\t<label for=\"group-1\" class=\"sm02_01\">숙박권 리스트</label>\r\n");
      out.write("\t\t\t\t\t\t<ul>\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"has-children\"><a href=\"hotel_list.hotela\" class=\"sublabel ");
      out.print((menu.equals("hotel")?"on" : ""));
      out.write("\">숙박 리스트</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"has-children\"><a href=\"room_list.rooma\" class=\"sublabel ");
      out.print((menu.equals("room")?"on" : ""));
      out.write("\">방 리스트</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"has-children\"><a href=\"reply_list.replya\" class=\"sublabel ");
      out.print((menu.equals("reply")?"on" : ""));
      out.write("\">후기 리스트</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"has-children\"><a href=\"reserve_list.reservea\" class=\"sublabel ");
      out.print((menu.equals("reserve")?"on" : ""));
      out.write("\">숙박 예약 리스트</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"has-children\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" name=\"group-1\" id=\"group-1\" checked> \r\n");
      out.write("\t\t\t\t\t\t<label for=\"group-1\" class=\"sm02_03\">음식점 리스트</label>\r\n");
      out.write("\t\t\t\t\t\t<ul>\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"has-children\"><a href=\"food_list.fooda\" class=\"sublabel on\">음식점 리스트</a></li> \r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"has-children\"><a href=\"reply_list.replya\" class=\"sublabel\">후기 리스트</a></li> \r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"has-children\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" name=\"group-2\" id=\"group-2\"> \r\n");
      out.write("\t\t\t\t\t\t<label for=\"group-2\" class=\"sm02_02\">플래너 관리</label>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"has-children\"><a href=\"#\" class=\"sublabel\">결재내역</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<!-- //side menu --> \r\n");
      out.write("\t\t\t</aside> \r\n");
      out.write("\t\t\t<!-- //aside --> ");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("\r\n");

request.setCharacterEncoding("utf-8");
@SuppressWarnings("unchecked")
//(어노테이션) 호환되지 않은 유형으로 작동하면 프로그램이 컴파일 되지 않기에 해당 경고를 보여줌 (ArrayList 제네릭 사용시 밑줄 가리는 방법)


// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼ 
ArrayList<FoodInfo> foodList = (ArrayList<FoodInfo>)request.getAttribute("foodList"); 
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");  
Common common = new Common(); 
HashMap<String, String> mapSchargs = (HashMap<String, String> )request.getAttribute("schargs"); 
String schargs = "";

// ▼▼▼ 검색관련 쿼리스트링 제작 ▼▼▼
String args = "?cpage=" + pageInfo.getCpage();  
for(String key : mapSchargs.keySet()) {
	schargs += "&"+key +"=" +  mapSchargs.get(key);
}


      out.write(" \r\n");
      out.write("\t\t\t<!-- *** article *** -->  \r\n");
      out.write("\t\t\t<script> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t/* 체크박스 전체 선택/해제 */\r\n");
      out.write("\t\t\t\tfunction onCheckAll(status) {\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar chk_del = document.getElementsByName(\"chk_del\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tfor (var i = 0; i < chk_del.length; i++ ) {\r\n");
      out.write("\t\t\t\t\t\tchk_del[i].checked = status; \r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t/* 삭제처리 */\r\n");
      out.write("\t\t\t\tfunction onProcDel() {\r\n");
      out.write("\t\t\t\t\tconsole.log(\"delete proc\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar chk_del = document.getElementsByName(\"chk_del\");\r\n");
      out.write("\t\t\t\t\tvar arrCheck = []; \r\n");
      out.write("\t\t\t\t\tfor (var i = 0; i < chk_del.length; i++ ) {\r\n");
      out.write("\t\t\t\t\t\tif (chk_del[i].checked == true) {\r\n");
      out.write("\t\t\t\t\t\t\tarrCheck[i] = chk_del[i].value;\r\n");
      out.write("\t\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tconsole.log(arrCheck);\r\n");
      out.write("\t\t\t\t\tif (arrCheck.length == 0) {\r\n");
      out.write("\t\t\t\t\t\talert(\"삭제할 음식점 정보가 없습니다. \\n삭제할 데이터를 선택 후 삭제해주세요.\");\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\tif (confirm(\"정말 삭제하시겠습니까?\")) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t        var frm = document.createElement(\"form\"); \r\n");
      out.write("\t\t\t\t\t        frm.setAttribute(\"method\", \"Post\");  \t\t\t\t\t//Post 방식\r\n");
      out.write("\t\t\t\t\t        frm.setAttribute(\"action\", \"food_del.fooda\"); //요청 보낼 주소\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t        var hiddenField = document.createElement(\"input\"); \r\n");
      out.write("\t\t\t\t\t        hiddenField.setAttribute(\"type\", \"hidden\");\r\n");
      out.write("\t\t\t\t\t        hiddenField.setAttribute(\"name\", \"arrCheck\");\r\n");
      out.write("\t\t\t\t\t        hiddenField.setAttribute(\"value\", arrCheck); \r\n");
      out.write("\t\t\t\t\t        frm.appendChild(hiddenField); \r\n");
      out.write("\t\t\t\t\t        document.body.appendChild(frm); \r\n");
      out.write("\t\t\t\t\t        frm.submit();\r\n");
      out.write("\t\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<article>\r\n");
      out.write("\t\t\t\t<h3>음식점 리스트 > 음식점 리스트</h3>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- content -->\r\n");
      out.write("\t\t\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- *** Search Layout *** -->\r\n");
      out.write("\t\t\t\t\t<form name=\"frmSearch\" method=\"get\" action=\"food_list.fooda\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"box_search01\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul> \r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"title01\">지역</span>  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span style=\"width: 140px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"sl_area\" style=\"width: 120px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">전체</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 for(String key : common.getArea().keySet()) { 
											String sl = "";
											if (key.equals(mapSchargs.get("area"))) sl = " selected = 'selected' ";
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(key);
      out.write('"');
      out.write(' ');
      out.print(sl );
      out.write('>');
      out.print(common.getArea().get(key) );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"title01\">음식점 유형</span> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span style=\"width: 180px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"sl_type\" style=\"width: 160px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">전체</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 for(String key : common.getFoodType().keySet()) {
											String sl = "";
											if (key.equals(mapSchargs.get("type"))) sl = " selected = 'selected' "; 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(key);
      out.write('"');
      out.write(' ');
      out.print(sl );
      out.write('>');
      out.print(common.getFoodType().get(key) );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t</span>  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"title01\">오픈여부</span> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"sl_open_yn\" style=\"width: 100px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">전체</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 for(String key : common.getOpenYn().keySet()) { 
											String sl = "";
											if (key.equals(mapSchargs.get("open_yn"))) sl = " selected = 'selected' ";
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(key);
      out.write('"');
      out.write(' ');
      out.print(sl );
      out.write('>');
      out.print(common.getOpenYn().get(key) );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
 } 
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t</span> \r\n");
      out.write("\t\t\t\t\t\t\t\t</li> \r\n");
      out.write("\t\t\t\t\t\t\t\t<li> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"title01\">음식점명</span> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span><input type=\"text\" name=\"txt_name\" value=\"");
      out.print(common.nullToString(mapSchargs.get("name")) );
      out.write("\" style=\"width: 300px\"></span> \r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"btn\" style=\"margin-top:15px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\" onclick=\"document.frmSearch.submit()\" class=\"btn_search\">조회</a> \r\n");
      out.write("\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"table_top\">\r\n");
      out.write("\t\t\t\t\t\t총 <span>12</span>건 \r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<span class=\"btn_event\" style=\"display:block;position:absolute;top:0px;right:0px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"food_form.fooda\" class=\"btn_default blue\">등록</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" onclick=\"onProcDel()\" class=\"btn_default gray\">삭제</a>\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t<!-- *** list *** -->\r\n");
      out.write("\t\t\t\t\t<div class=\"tbl_wrap_list\">\r\n");
      out.write("\t\t\t\t\t\t<table class=\"tbl_list\">  \r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\"><input type=\"checkbox\" id=\"allCheck\" onclick=\"onCheckAll(this.checked)\" /></th> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">지역</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">음식점 유형</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">음식점명</th>  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">운영시간</th>  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">평점</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">리뷰</th> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">운영여부</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th scope=\"col\">삭제여부</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t");

						
						if (foodList != null && foodList.size() > 0) {
							// 음식점 리스트가 있다면 돌리기
							for (int i = 0 ; i < foodList.size() ; i++) {
						      	FoodInfo foodInfo = foodList.get(i); 
						      	String food_addr = ( foodInfo.getFood_addr().length() > 10 ) ? foodInfo.getFood_addr().substring(0, 10) + "..." : foodInfo.getFood_addr();
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<tr onmouseover=\"this.className='on'\" onmouseout=\"this.className=''\" onclick=\"location.href='#';\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><input type=\"checkbox\" name=\"chk_del\" value=\"");
      out.print(foodInfo.getFood_code() );
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(common.getArea().get(foodInfo.getFood_area()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(common.getFoodType().get(foodInfo.getFood_type()) );
      out.write("</td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<td><a href=\"food_view.fooda?food_code=");
      out.print(foodInfo.getFood_code() );
      out.write('"');
      out.write('>');
      out.print(foodInfo.getFood_name() );
      out.write("</a></td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(foodInfo.getFood_open() );
      out.write('-');
      out.print(foodInfo.getFood_close() );
      out.write("</td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(foodInfo.getFood_score() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(foodInfo.getFood_review_cnt() );
      out.write("</td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(common.getOpenYn().get(foodInfo.getFood_open_yn()) );
      out.write("</td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(common.getDelYn().get(foodInfo.getFood_del_yn()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t            ");

							}
						} else {
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t                <td colspan=\"13\" style=\"height:150px\">\r\n");
      out.write("\t\t\t\t\t                    <div class=\"nodata\"><p>조회 하신 데이터가 없습니다.</p></div>\r\n");
      out.write("\t\t\t\t\t            \t</td>\r\n");
      out.write("\t\t\t\t\t            </tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
}
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- *** paging ***  -->\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"paging\">\r\n");
      out.write("\t\t\t\t");
 if (foodList != null && foodList.size() > 0) {
						args = "?psize=" + pageInfo.getPsize() + schargs;
						
						String firstUrl = "#";
						String prevUrl = "#";
						String lastUrl = "#";
						String nextUrl = "#";
					
						if (pageInfo.getCpage() > 1) { 
							firstUrl = "food_list.fooda" + args + "&cpage=1";
							prevUrl  = "food_list.fooda?cpage=" + (pageInfo.getCpage() - 1);
						} // 첫 페이지와 이전 페이지 링크
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.print(firstUrl);
      out.write("\"><img src='../admin/common/images/btn_pg_first.png' alt='첫 페이지' /></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.print(prevUrl);
      out.write("\"><img src='../admin/common/images/btn_pg_previous.png' alt='이전 페이지' /></a>\r\n");
      out.write("\t\t\t\t\t\t<span class='wrap'>\r\n");
      out.write("\t\t\t\t\t");
  
						for (int i = 1, k = pageInfo.getSpage() ; i <= pageInfo.getBsize() && k <= pageInfo.getEpage() ; i++, k++) {
							if (pageInfo.getCpage() == k) { 
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t\t<a href='#' class='on'>");
      out.print(k );
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t");
		} else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"food_list.fooda");
      out.print(args + "&cpage=" + k );
      out.write('"');
      out.write('>');
      out.print(k );
      out.write("</a> \r\n");
      out.write("\t\t\t\t\t");
		}
						}
						if (pageInfo.getCpage() != pageInfo.getPcnt()) {	// 현재 페이지번호가 마지막 페이지 번호이면
							lastUrl = "food_list.fooda" + args + (pageInfo.getCpage() + 1);
							nextUrl = "food_list.fooda" + args + "&cpage=" + pageInfo.getPcnt(); 
						} 
					
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.print(nextUrl);
      out.write("\"><img src='../admin/common/images/btn_pg_next.png' id='next' alt='다음 페이지' /></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.print(lastUrl);
      out.write("\"><img src='../admin/common/images/btn_pg_last.png' id='nextEnd' alt='마지막 페이지' /></a>\r\n");
      out.write("\t\t\t\t\t");
 
					
				}
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- //페이징 -->  \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- //content --> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</article> \r\n");
      out.write("\t\t\t<!-- //article --> \r\n");
      out.write("\t\t \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("<!-- //section -->\r\n");
      out.write("<!-- footer -->\r\n");
      out.write("<footer>copyright</footer>\r\n");
      out.write("<!-- //footer -->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- //wrapper -->\r\n");
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

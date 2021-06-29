<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="mem.*" %>
<%
MemberInfo login_info = (MemberInfo)session.getAttribute("login_info");
if (login_info == null) {
%>
<script>
   alert("잘못된 경로로 들어오셨습니다.");
   history.back();
</script>
<%
   out.close();   // 파일 실행을 강제로 종료시킴
}

request.setCharacterEncoding("utf-8");

String mi_id = request.getParameter("mi_id");


String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/testmall?useUnicode=true&characterEncoding=UTF8";
url += "&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String sql = "select * from t_member_addr where mi_id = '" + login_info.getMi_id() +
   "' order by ma_basic desc";
try {
   Class.forName(driver);
   conn = DriverManager.getConnection(url, "root", "1qaz2wsx");
   stmt = conn.createStatement();
   rs = stmt.executeQuery(sql);

} catch(Exception e) {
   out.println("주소록 목록 호출 시 오류가 발생했습니다.");
   e.printStackTrace();
} 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#addrForm {width:600px; border:1px black solid; display:none;}
</style>
<script >
function fnBasic(chk) {
   if (confirm("선택하신 주소를 '기본주소'로 등록하시겠습니까?")) {
      location.href = "addrProc.jsp?wtype=basic&idx=" + chk;   
   }
}
function fnDel(idx) {
   if (confirm("선택하신 주소를 삭제하시겠습니까?")) {
      location.href = "addrProc.jsp?wtype=del&idx=" + idx;
   }
}
function shosAddr(btn) {
	var frm = document.frmAddr;
	
    var obj = document.getElementById("addrForm");
    if (obj.style.display == "none") {
      obj.style.display = "block";
      btn.value = "새주소 등록 취소";
      frm.wtype.value = "in";
   } else {
      obj.style.display = "none";
      btn.value = "새주소 등록 폼";
      frm.wtype.value="";
   }
}
</script>
</head>
<body>
<h2><%=login_info.getMi_id()%>님의 주소록</h2>
<table border="1" cellpadding="5" width="600">
<tr>
<th width="10%">우편번호</th>
<th width="30%">주소1</th>
<th width="*">주소2</th>
<th width="10%">기본</th>
<th width="10%">삭제</th>
</tr>
<tr>
<%
if (rs.next()) {   // 해당 회원에 등록된 주소가 있으면
   do {
      String chk ="onclick='fnBasic(this.value)';";
      String isDel = "fnDel(" + rs.getInt("ma_idx") + ");";
      if (rs.getString("ma_basic").equals("y")){
         chk = "checked ='checked'";
         isDel = "alert('기본주소는 삭제할 수 없습니다.\\n삭제하려면 다른 주소를 기본 주소로 설정한 후 삭제 해야 합니다.')";
      }
      if (rs.getString("ma_basic").equals("y")) chk = " checked='checked'";
%>
<tr>
<td><%=rs.getString("ma_zip") %></td>
<td align="left"><%=rs.getString("ma_addr1") %></td>
<td align="left"><%=rs.getString("ma_addr2") %></td>
<td><input type="radio" name="zip" value="<%=rs.getInt("ma_idx") %>"<%=chk %> /></td>
<td><input type="button" value="삭제" onclick="<%=isDel %>" /></td>
</tr>
<%   
   } while (rs.next());
   
} else {
   out.println("<tr><td colspan='5' align='center'>등록된 주소가 없습니다.</td></tr>");
}
%>
</table>
<p style="width:600px; text-align:right;">
   <input type="button" value="새주소 등록 폼 " onclick="shosAddr(this);" />
</p>
<div id="addrForm">
<form name="frmAddr" action="addrProc.jsp" method="post">
<table width="600" cellpadding="5">
<tr>
<th width="20%">우편번호</th>
<td width="*"><input type="text" name="zip" size="5" maxlength="5" /></td>
</tr>
<tr>
<th>주소</th>
<td>
   <input type="text" name="addr1" size="29" />&nbsp;
   <input type="text" name="addr2" size="29" />
</td>
</tr>
<tr><td colspan="2" align="center">
   <input type="submit" value="주소 등록" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="reset" value="다시 입력" />
</td></tr>
</table>
</form>
</div>
</body>
</html>


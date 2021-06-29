<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/testmall?useUnicode=true&characterEncoding=UTF8";
url += "&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";

Connection conn = null;	// db와 연결시키기 위한 객체 선언
Statement stmt = null;	// db에 쿼리를 보내기 위한 객체 선언
ResultSet rs = null;	// select쿼리의 결과를 받아 오기 위한 객체 선언
String sql = "select mi_id, mi_name, if(mi_gender = 'm', '남자', '여자') gender, " + 
	"ifnull(mi_recommend, '없음') rec, if(mi_isactive = 'y', '사용중', '탈퇴') act " +
	" from t_member_info";

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "root", "1234");
	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	// 커서의 위치를 자유롭게 이동시킬 수 있는 ResultSet 생성이 가능함
	rs = stmt.executeQuery(sql);

} catch(Exception e) {
	out.println("회원목록에서 오류가 발생했습니다.");
	e.printStackTrace();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>ResultSet 사용예제 - 회원목록</h3>
<table border="1" cellpadding="5">
<tr><th>번호</th><th>아이디</th><th>이름</th><th>성별</th><th>추천인</th><th>상태</th></tr>
<%
// rs에 들어있는 데이터들을 역순으로 출력하고, 2번 째 데이터와 4번 째 데이터는 마지막 한 번 더 출력

if (rs.next()) {	// rs에 데이터가 들어 있으면
	int n = 1;
	rs.last();	// rs의 마지막 레코드로 이동
	do {
%>
<tr align="center">
<td><%=n %></td><td><%=rs.getString("mi_id") %></td>
<td><%=rs.getString("mi_name") %></td><td><%=rs.getString("gender") %></td>
<td><%=rs.getString("rec") %></td><td><%=rs.getString("act") %></td>
</tr>
<%
		n++;
	} while (rs.previous());
	// rs.previous() : 이전 레코드가 있는지 여부와 이전 레코드로 커서 이동

	rs.absolute(2);	// rs의 두 번째 레코드로 커서 이동
%>
<tr align="center">
<td><%=n %></td><td><%=rs.getString("mi_id") %></td>
<td><%=rs.getString("mi_name") %></td><td><%=rs.getString("gender") %></td>
<td><%=rs.getString("rec") %></td><td><%=rs.getString("act") %></td>
</tr>
<%	rs.absolute(4); %>
<tr align="center">
<td><%=n %></td><td><%=rs.getString("mi_id") %></td>
<td><%=rs.getString("mi_name") %></td><td><%=rs.getString("gender") %></td>
<td><%=rs.getString("rec") %></td><td><%=rs.getString("act") %></td>
</tr>
<%
} else {
	out.println("<tr><td colspan='6' align='center'>검색결과가 없습니다.</td></tr>");
}

try {
	rs.close();
	stmt.close();
	conn.close();
} catch(Exception e) {
	e.printStackTrace();
}
%>
</table>
</body>
</html>

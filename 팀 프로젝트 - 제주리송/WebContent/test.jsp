<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@page import="db.JdbcUtil"%>
<%
Connection conn = JdbcUtil.getConnection();
Statement stmt = null;
ResultSet rs = null;
String sql = "";
try {
	stmt	= conn.createStatement();
	sql 	= "select * from t_member_info";
	rs 		= stmt.executeQuery(sql); 
	
} catch(Exception e) {
	e.printStackTrace();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
if (rs.next()) {
	do { 
		out.println(rs.getString("mi_id") + "<br />");

	} while (rs.next());
} else {
	out.println("���Ե� ȸ���� �����ϴ�.");
} 

JdbcUtil.close(rs);
JdbcUtil.close(stmt);
JdbcUtil.close(conn);

%> 
</body>
</html>
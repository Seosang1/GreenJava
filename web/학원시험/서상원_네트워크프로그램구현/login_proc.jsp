<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %> 
<%@ page import="mem.*" %> 
<%
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/testmall?useUnicode=true&characterEncoding=UTF8";
url += "&verifyServerCertificate=false&useSSL=false&serverTimezone=UTC";

request.setCharacterEncoding("utf-8");
String uid = request.getParameter("uid");
String pwd = request.getParameter("pwd");

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
String sql = "select * from t_member " + "where m_id = '" + uid + "';";
out.println(sql);
 
try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "root", "1234");
	stmt = conn.prepareStatement(sql);  
	rs = stmt.executeQuery(sql);
	
 
if(rs.next()) {   
	if (uid.equals(rs.getString("m_id")))  {	
		if (pwd.equals(rs.getString("m_pwd"))) {
			MemberInfo mi = new MemberInfo();	 
			mi.setM_id(uid);
			mi.setM_pwd(pwd);  
			
			session.setAttribute("login_info", mi);	 
			out.println("<script>");
			out.println("location.href = 'index.jsp';");
			out.println("</script>");
		} 
		out.println("<script>"); 	 
		out.println("alert(' 암호를 확인하세요.');");
		out.println("history.back();");
		out.println("</script>"); 	 
	}   
} 
	out.println("<script>");  
	out.println("alert(' 등록된 아이디가 없습니다.');");
	out.println("history.back();");
	out.println("</script>"); 	
		
} catch(Exception e) {
	out.println("로그인 처리시 오류가 발생했습니다.");
	e.printStackTrace();
} 
%> 
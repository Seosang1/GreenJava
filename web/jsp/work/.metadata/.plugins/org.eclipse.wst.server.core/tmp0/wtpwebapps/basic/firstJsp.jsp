<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%
Calendar today = Calendar.getInstance(); // 오늘 날짜 및 현재 시간
int year = today.get(Calendar.YEAR);
int month = today.get(Calendar.MONTH) + 1;
int day = today.get(Calendar.DATE);
int hour = today.get(Calendar.HOUR_OF_DAY);
int minute = today.get(Calendar.MINUTE);
int second = today.get(Calendar.SECOND);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>오늘 날짜는 <%=year %>년 <%=month %>월 <%=day %>일 이고,</h2>
<h3>현재 시간은 <%=hour %>시 <%=minute %>분 <%=second %>초 입니다.</h3>
현재는 <% if (hour >= 12) { %><b>오후</b><% } else { %><b>오전</b><% } %> 입니다.

<%
if  (hour >= 12) {
	out.println("<b>오후</b>");
} else {
	out.println("<b>오전</b>"); 
}
%>
입니다. 
</body>
</html>

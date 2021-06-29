<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="700" cellpadding="0" cellspacing="0">
<caption>게시판 목록 화면</caption>
<tr height="35">
<th width="7%">번호</th><th width="*">제목</th><th width="10%">작성자</th>
<th width="15%">작성일</th><th width="10%">조회수</th>
</tr>
<tr height="1"><td colspan="5" bgcolor="black"></td></tr>
<%
int num = 10;
while (num > 0) {
%>
<tr height="35" align="center">
<td><%=num%></td><td align="left">동해 물과 백두산이 마르고 닳도록 하느님이 보우…</td>
<td>홍길동</td><td>2021-02-03</td><td>123</td>
</tr>
<tr height="1"><td colspan="5" bgcolor="black"></td></tr>
<%
	num--;
}
%>
</table>

</body>
</html>
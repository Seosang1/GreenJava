<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>

<html>
<head>
</head>
<body>
세션 ID : <%= session.getId() %> <br>
세션 생성 시간 : <%= new Date(session.getCreationTime()) %> <br>
세션 최근 접근 시간 : <%= new Date(session.getLastAccessedTime())  %> <br>
rkqt : ${session.getU_code()}
${sessionScope.u_id}
${sessionScope.u_pwd}


</body>
</html>


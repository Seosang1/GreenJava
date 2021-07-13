<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="_inc/incHead.jsp" %>   
<%
	session.invalidate();		// 세션의 모든 정보를 삭제	
%>
<script>
	location.href= "index.jsp";
</script>
<%@ include file="_inc/incFooter.jsp" %>  
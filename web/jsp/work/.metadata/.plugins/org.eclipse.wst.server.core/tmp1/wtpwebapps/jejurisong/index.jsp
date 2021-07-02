<%@page import="vo.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ include file="_inc/incHead.jsp" %>   
	
	<%

	MemberInfo loginMember = (MemberInfo) session.getAttribute("loginMember");
	%>
	
	<%	if (loginMember == null) { %>
			<a href="login_form.jsp">로그인</a>
			<br />
	<%	} else { %>
			<%=loginMember.getMi_id()%>(<%=loginMember.getMi_name()%>) 로그인
			<br />
			<a href="logout.jsp">로그아웃</a>
			<br />
	<% 	} %>
	<hr />
	
	<!--[[항공권]] -->
	<a href="javascript:alert('준비중입니다.')">항공권예약</a><br />
	<hr />
	
	<!--[[숙박]] -->
	<a href="hotel_list.hotel">숙박리스트</a><br />
	<a href=""></a>
	<hr />
	
	<!-- [[SNS 로그인]] -->	
	<a href="">SNS 로그인 폼</a><br />
	<a href=""></a>
	<hr />	
	
	<!-- [[음식점]] -->	 
	<a href="food_list.food">음식점 리스트</a><br />
	<hr />
	
	<!-- [[플래너]] -->	
	<a href="">전체플레너</a><br />
	<a href=""></a>
	<hr />
	
	
	<a href=""></a>
	<hr />

	
<%@ include file="_inc/incFooter.jsp" %>  
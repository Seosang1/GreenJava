<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*"%> 
<%
	request.setCharacterEncoding("utf-8");
	AdminInfo adminInfo = (AdminInfo) session.getAttribute("adminInfo");
	if (adminInfo == null) {
		out.println("<script>");
		out.println("alert('로그인 후 사용하실 수 있습니다.');");
		out.println("location.href='login_form.jsp';");
		out.println("</script>");
		out.close();
	}
	 
	String cURI = request.getRequestURI();
	int endIdx = cURI.lastIndexOf("/");
	int startIdx = cURI.lastIndexOf("/", endIdx - 1);
	// String cFolder = cURI.substring(startIdx + 1, endIdx);	// 현재 파일의 기능명 
	  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<title>JEJURISONG ADMIN</title>
	<link href="../admin/common/css/default.css" rel="stylesheet" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/js/bootstrap-datepicker.min.js"></script>

    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/css/bootstrap-datepicker3.min.css">
           
    <link rel="apple-touch-icon" sizes="57x57" href="/jejurisong/admin/common/images/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="/jejurisong/admin/common/images/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="/jejurisong/admin/common/images/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="/jejurisong/admin/common/images/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="/jejurisong/admin/common/images/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="/jejurisong/admin/common/images/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="/jejurisong/admin/common/images/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="/jejurisong/admin/common/images/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="/jejurisong/admin/common/images/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="/jejurisong/admin/common/images/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="/jejurisong/admin/common/images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="/jejurisong/admin/common/images/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="/jejurisong/admin/common/images/favicon-16x16.png">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="/jejurisong/admin/common/images/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">
  
</head>


<body>
	<!-- wrapper -->
	<div class="wrapper">
		<!-- header -->
		<header>
		<div class="session">
			<ul>
				<li class="user"><span><%=adminInfo.getAi_name() %></span>님 환영합니다.</li>
				<li style="margin-left:10px;"><a href="logout.jsp">로그아웃</a></li>
				<!-- <li class="download"><a href="#">매뉴얼 다운로드</a></li> -->
			</ul>
		</div>
		</header>
		<!-- //header -->
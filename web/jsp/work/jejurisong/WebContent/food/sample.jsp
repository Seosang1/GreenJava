<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="db.JdbcUtil"%>
<%@ page import="vo.*" %> 
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="common/css/form.css?alter"> 
<link rel="stylesheet" type="text/css" href="common/css/button.css?alter"> 
<link rel="stylesheet" type="text/css" href="common/css/default.css?alter">    
<link rel="stylesheet" type="text/css" href="common/css/food.css?alter">    
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>   
	<style>
	body { margin:0; font-size:13px; }
	ol, ul { list-style:none; }
	a:link { color:#4f4f4f; text-decoration:none; }
	a:visited { color:#4f4f4f; text-decoration:none; }
	a:hover { color:#f00; text-decoration:underline; }
	#wrapper { width:1250px; margin:0 auto; }
	#top {
		width:100%; height:50px; text-align:center; font-size:25px; color:#4f4f4f; 
		font-weight:bold; padding-top:30px;
	}
	.outerBox {
		border:5px #4f4f4f solid; width:270px; text-align:center;
		padding:5px; margin:10px; float:left;
	}
	.innerBox {
		border:1px #000 solid; width:260px; height:190px; padding:5px; 
		text-align:center; display:table-cell; vertical-align:middle;
	}
	.pdtName { font-size:15px; padding-top:7px; padding-bottom:3px; font-weight:bold; }
	.pdtPrice { color:red; font-weight:bold; }
	</style>
</head>
<body>
<div id="wrapper">
	<div id="top">PRODUCTS LIST</div>
	<div class="outerBox">
		<div class="innerBox"><img src="pdt01.png" width="256" height="200" /></div>
		<div class="pdtName">아주 좋은 분무기</div>￦ <span class="pdtPrice">25000</span>
	</div>
	<div class="outerBox">
		<div class="innerBox"><img src="pdt02.png" width="256" height="200" /></div>
		<div class="pdtName">몸에 좋은 채소 Set</div>￦ <span class="pdtPrice">35000</span>
	</div>
	<div class="outerBox">
		<div class="innerBox"><img src="pdt03.png" width="256" height="200" /></div>
		<div class="pdtName">목욕용 클리너 Set</div>￦ <span class="pdtPrice">55000</span>
	</div>
	<div class="outerBox">
		<div class="innerBox"><img src="pdt04.png" width="256" height="200" /></div>
		<div class="pdtName">화장품 Set</div>￦ <span class="pdtPrice">100000</span>
	</div>
	<div class="outerBox">
		<div class="innerBox"><img src="pdt05.png" width="256" height="200" /></div>
		<div class="pdtName">엄청 선명한 모니터</div>￦ <span class="pdtPrice">400000</span>
	</div>
	<div class="outerBox">
		<div class="innerBox"><img src="pdt06.png" width="256" height="200" /></div>
		<div class="pdtName">종합 비타민 (500정)</div>￦ <span class="pdtPrice">45000</span>
	</div>
</div>
</body>
</html>

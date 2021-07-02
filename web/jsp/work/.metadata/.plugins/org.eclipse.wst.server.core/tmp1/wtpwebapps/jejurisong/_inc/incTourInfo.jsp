<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String src = request.getContextPath() + "/common/images/InfoImg/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JujuriSong</title>
<style>
div {margin:auto;}
div .tourInfoTitle {display:flex; }
div .infoImg {width:150px; height:100px;}
div #infoRel {position:relative;} 
</style>
</head>
<body> 
<div class="tourInfoTitle">
		<div class="infoSrc" id="infoRel">
			<a href="food_list.food" ><img src="<%=src %>foodMain.png" class="infoImg" /></a>
		</div>
		<div class="infoSrc" class="infoAb">
			<a href="culture_info.info" ><img src="<%=src %>cultMain.png" class="infoImg" /></a>
		</div>
		<div class="infoSrc" class="infoAb">
			<a href="traffic_info.info" ><img src="<%=src %>trafficMain.png" class="infoImg" /></a>
		</div>
		<div class="infoSrc" class="infoAb">
			<a href="guide_info.info" ><img src="<%=src %>guideMain.png" class="infoImg" /></a>
		</div>
</div>  
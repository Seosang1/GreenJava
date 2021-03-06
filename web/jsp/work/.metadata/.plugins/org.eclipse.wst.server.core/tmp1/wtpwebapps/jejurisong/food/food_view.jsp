<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %> 
<% 
request.setCharacterEncoding("utf-8");
 
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");   
FoodInfo foodInfo = (FoodInfo)request.getAttribute("foodInfo");  

if (foodInfo == null) {
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다.');");
	out.println("history.back();");
	out.println("</script>");
	out.close();
}

String src = request.getContextPath(); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>  
div {margin:0 auto; text-align:center;}
div #totalView {width:1180px;}
div #fdLay {display:flex;}  
div .br {display:block; height:30px;}
.foodColumn {text-align:left;}
</style>
<script>  
</script>
</head>
<body>
<div id="totalView"> 
<!-- 헤더영역 -->
<%@ include file="../_inc/incHead.jsp" %>  
<%@ include file="../_inc/incInfo.jsp" %>  
<div class="br"></div> 
	<div id="fdLay">
		<div id="mainImg">
			<img src="<%=src %>/common/images/FoodImg/<%=foodInfo.getFood_img1()%>" width="300" height="300" />
		</div> 
		<div id="foodDetail">
		<ul class="foodColumn" > 
		<li>상 호 명 : <%=foodInfo.getFood_name() %></li> 
		<li>전화번호 : <%=foodInfo.getFood_tel() %></li>
		<li>지     역 : <%=foodInfo.getFood_area() %></li>
		<li>주     소 : <%=foodInfo.getFood_addr() %></li>
		<li>우편번호 : <%=foodInfo.getFood_zip() %></li> 
		</ul>
		</div>

</body>
</html>

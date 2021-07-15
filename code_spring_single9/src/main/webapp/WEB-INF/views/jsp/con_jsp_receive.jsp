<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<pre>

<!-- jsp 파일로.

java > session 메소드 생성, cookie메소드 생성 > a.jsp로 세션불러오기, b.jsp로 쿠키불러오기 -->

	<h1>java 데이터를 받았습니다</h1>
	<a href="kjh/receive"></a>
	
	<h1>맵 데이터(키값이 keyTest 를 가져오세요)</h1>  : ${HCMap }



	
	<h1>리스트 데이터</h1> :  ${list }	
		
</pre>

</body>
</html>
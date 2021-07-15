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
	
<!-- list형인데. 자료형을 맵으로 받으세요 -->
	
<!-- c태그(for)를 이용하여 list형의 데이터를 한줄씩 출력하세요  -->
<%-- <c:forEach test="listmap"> 리스트 수만큼 반복이돌거고. 
				
</c:forEach>
--%>
	 
<h1>리스트에 저장한 맵 데이터</h1> :  ${listMap }
	 
	 
<h1>리스트에 저장한 맵 데이터 하나씩 출력</h1> :
	<c:set var="listMap" value="${listMap }" />
		
	<c:forEach var="data" items="${listMap}">
	 	${data }
	</c:forEach>
	
<h1>리스트에 저장한 맵 데이터 하나씩 출력하되 이름과 나이만 출력</h1> :	  
	 <c:forEach var="data" items="${listMap}">
		 ${data.name }
		 ${data.age }
	 	
	</c:forEach>
	
		
		
</pre>

</body>
</html>
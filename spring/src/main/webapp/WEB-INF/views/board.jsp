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


<h1>list</h1>
	<table border="1">
		<colgroup>
			<col width="100">
			<col width="100">
		</colgroup>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>연락처</th>
			<th>생일</th>
			<th>결혼</th>
			<th>배우자생일</th>
			<th>이메일</th>
			<th>주소</th>
			<th>생성낳짜</th>
			<th>정보</th>
			
			
		</tr>
		
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" align="center">---------------작성된 글이 없습니다.---------------</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.id }</td>
						<td>${dto.pwd }</td>
						<td>${dto.name }</td>
						<td>${dto.tel }</td>
						<td>${dto.birth }</td>
						<td>${dto.wedding }</td>
						<td>${dto.p_birth }</td>
						<td>${dto.email }</td>
						<td>${dto.address }</td>
						<td>${dto.start_date }</td>
						<td>${dto.code }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="right">
			</td>
		</tr>
		
	</table>
</body>
</html>
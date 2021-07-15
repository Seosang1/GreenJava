<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
.h-no{
	width:150px;
}
#contentSpace{
	justify-content:center;
}
</style> 
<div class='container'>
	<h3>Q&A</h3>
	<div class='row'>
		<div class='col-sm-10'></div>
		<div class='col-sm-2'>
			<button type='button' class='btn btn-outline-secondary' id='writeQna'><a href="writeQna">문의하기</a></button>
		</div>
	</div>
	<div class='row' style='height:30px'></div>
	<div class='row' style="height:500px">
		<table border="1">
		<thead>
		<tr>
			<th class='no'>번호</th>
			<th class='category'>카테고리</th>
			<th class='title'>제목</th>
			<th class='writer'>작성자</th>
			<th class='cnt'>조회수</th>
			<th class='regDate'>등록일</th>
			<th class='response'>답변여부</th>
		</tr>
		</thead>
		<tbody id='contentSpace'>
		</tbody>

			<tbody>

				<c:choose>
					<c:when test="${empty boardList }">
						<tr>
							<td colspan="5" align="center">데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${!empty boardList}">
						<c:forEach var="list" items="${boardList}">
							<tr>
								<td><c:out value="${list.seq}" /></td>
								<td><c:out value="${list.category}" /></td>
								<td><c:out value="${list.title}" /></td>
								<td><c:out value="${list.u_id}" /></td>
								<td><c:out value="${list.view_count}" /></td>
								<td><c:out value="${list.create_date}" /></td>
								<td><c:out value="${list.response_yn}" /></td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</tbody>
 
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>
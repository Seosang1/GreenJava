<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
function viewDetail(seq){
	var url = "${pageContext.request.contextPath}/board/qnaDetail";
	var uid = <%=(String) session.getAttribute("u_id")%>;
	
	url = url + "?seq="+seq;
	
	if (uid == null /*&& uid.equals(${list.u_id}) && 어드민 아이디 확인 */) {
		location.href = url;	
		System.out.println(uid);
	} else {
		alert("작성자만 조회 가능합니다.")
	}
}
 
$(document).on('click', '#writeQna', function(e){
	e.preventDefault();
	location.href = "${pageContext.request.contextPath}/board/writeQna";
});

//이전 버튼 이벤트
function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		var url = "${pageContext.request.contextPath}/board/qnaList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;

		location.href = url;
}

 //페이지 번호 클릭
function fn_pagination(page, range, rangeSize, searchType, keyword) {
	var url = "${pageContext.request.contextPath}/board/qnaList";
	url = url + "?page=" + page;
	url = url + "&range=" + range;


	location.href = url;	
}

//다음 버튼 이벤트
function fn_next(page, range, rangeSize) {
	var page = parseInt((range * rangeSize)) + 1;
	var range = parseInt(range) + 1;
	var url = "${pageContext.request.contextPath}/board/qnaList";
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	location.href = url;
}

$(document).ready(function() {
	let result = '<c:out value="${result}"/>';
	
	chAlert(result);
	console.log(result);

	function chAlert(result) { 
		if (result == "update success") {
			alert("수정 성공");
		} else {
			("수정 실패");
		}
	}
});
</script>

<style>
.h-no {
	width: 150px;
}

#contentSpace {
	justify-content: center;
}
</style>
<div class='container'>
	<h3>Q&A</h3>
	<div class='row'>
		<div class='col-sm-10'></div>
		<div class='col-sm-2'>
			<button type='button' class='btn btn-outline-secondary' id='writeQna'>문의하기</button>
		</div>
	</div>
	<div class='row' style='height: 30px'></div>
	<div class='row'>
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
								<td><a href="#"
									onclick="viewDetail(<c:out value="${list.seq}"/>)"><c:out
											value="${list.title}" /></a></td>
								<td><c:out value="${list.u_id}" /></td>
								<td><c:out value="${list.view_count}" /></td>
								<td><c:out value="${list.create_date}" /></td>
								<td><c:choose>
										<c:when test="${list.response_yn eq 'Y'}">
											<p>답변완료</p>
										</c:when>
										<c:otherwise>
											<p>미답변</p>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</tbody>
		</table>
	</div>

	<!-- pagination{s} -->
	<div id="paginationBox">
		<ul class="pagination">
			<c:if test="${pagination.prev}">
				<li class="page-item"><a class="page-link" href="#"
					onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
			</c:if>

			<c:forEach begin="${pagination.startPage}"
				end="${pagination.endPage}" var="idx">
				<li
					class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a
					class="page-link" href="#"
					onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')">
						${idx} </a></li>
			</c:forEach>

			<c:if test="${pagination.next}">
				<li class="page-item"><a class="page-link" href="#"
					onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a></li>
			</c:if>
		</ul>
	</div>
	<!-- pagination{e} -->



</div>
<div class='row' style='height: 30px'></div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
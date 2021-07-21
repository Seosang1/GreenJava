<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url var="getBoardListURL" value="/board/qnaList"></c:url>
<script>


$(document).on('click', '#btnSearch', function(e){
	e.preventDefault();
	var url = "${qnaList}";
	url = url + "?searchType=" + $('#searchType').val();
	url = url + "&keyword=" + $('#keyword').val();
	location.href = url;
	console.log(url);
});	



// 조회자 검사
function viewDetail(seq){
	var url = "${pageContext.request.contextPath}/board/qnaDetail";
	var uid = "<%=(String)session.getAttribute("u_id")%>";
	var admin = "<%=(String)session.getAttribute("u_code")%>";
	
	url = url + "?seq="+seq;
	
	if (uid == null) {
		alert("작성자만 조회 가능합니다.")
		System.out.println(uid);
	} else if (uid == "admin" && admin == "A" ) {
		location.href = url;	
		console.log("어드민 접속 " + uid + "code" + admin);
	} else {
		location.href = url;	
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
		var url = "${qnaList}";
		url = url + "?page=" + page;
		url = url + "&range=" + range;

		location.href = url;
}

 //페이지 번호 클릭
function fn_pagination(page, range, rangeSize, searchType, keyword) {
	var url = "${qnaList}";
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	location.href = url;	
}

//다음 버튼 이벤트
function fn_next(page, range, rangeSize) {
	var page = parseInt((range * rangeSize)) + 1;
	var range = parseInt(range) + 1;
	var url = "${qnaList}";
	url = url + "?page=" + page;
	url = url + "&range=" + range; 
	location.href = url;
}


// 검색기능
$(document).on('click', '#btnSearch', function(e){
	e.preventDefault();
	var url = "${qnaList}"; 
	url = url + "?searchType=" + $('#searchType').val();
	url = url + "&keyword=" + $('#keyword').val();
	location.href = url;
	console.log(url);
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
	<!-- search{s} -->
	<div class="form-group row justify-content-center" style="display:flex;">
		<div class="w100" style="padding-right: 10px">
			<select style="height:27px;" class=" form-control-sm" name="searchType" id="searchType">
				<option value="title">제목</option>
				<option value="contents">본문</option>
				<option value="u_id">작성자</option>
			</select>
		</div>
		<div class="w300" style="padding-right: 10px">
			<input type="text" class=" form-control-sm"
				name="keyword" id="keyword">
		</div>
		<div>
			<button style="height:27px;" class="btn btn-sm btn-primary" name="btnSearch"
				id="btnSearch">검색</button>
		</div>
	</div>
	<!-- search{e} -->
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
					onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${search.searchType }', '${search.keyword }' )"></a>

			</c:if>

			<c:forEach begin="${pagination.startPage}"
				end="${pagination.endPage}" var="idx">
				<li
					class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a
					class="page-link" href="#"
					onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}', '${search.searchType }', '${search.keyword }')">	${idx} </a></li>
			</c:forEach>

			<c:if test="${pagination.next}">
				<li class="page-item"><a class="page-link" href="#"
					onClick="fn_next('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${search.searchType }', '${search.keyword }')">Next</a></li>
			</c:if>
		</ul>
	</div>
	<!-- pagination{e} -->




</div>
<div class='row' style='height: 30px'></div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
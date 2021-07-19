<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>  

$(document).on('click', '#btnList', function(){
	location.href = "${pageContext.request.contextPath}/board/qnaList";
});

$(document).on('click', '#btnUpdate', function(){
	var url = "${pageContext.request.contextPath}/board/updateQna";
	url = url + "?seq="+${qnaDetail.seq};
	url = url + "&mode=edit";
	
	location.href = url;
});

$(document).on('click', '#btnDelete', function(){
    var url = "${pageContext.request.contextPath}/board/deleteQna";
    url = url + "?seq=" + ${qnaDetail.seq};
		location.href = url;
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
	<div class='row' style='height: 30px'></div>
		<div class='row m-3'>
			<label for="title" class='col-sm-2 col-form-label'>게시글번호</label>
			<div class='col-sm-5'>
				<p>${qnaDetail.seq}</p>
			</div>
		</div>
		<div class='row m-3'>
			<label for="title" class='col-sm-2 col-form-label'>제목</label>
			<div class='col-sm-5'>
				<p>${qnaDetail.title}</p>
			</div>
		</div>
		<div class='row m-3'>
			<label for="view_count" class='col-sm-2 col-form-label'>조회수</label>
			<div class='col-sm-5'>
				<p>${qnaDetail.view_count}</p>
			</div>
		</div>
		<div class='row m-3'>
			<label for="contents" class='col-sm-2 col-form-label'>내용</label>
			<div class='col-sm-5'>
				<p>${qnaDetail.contents}</p>
			</div>
		</div>
		<div class='row'>
			<label for="response_yn" class='col-sm-2 col-form-label'>답변</label>
			<div class='col-sm-5'>

				<c:choose>
					<c:when test="${qnaDetail.response_yn eq 'N'}">
						<p>답변이 없습니다.</p>
					</c:when>
					<c:otherwise>
						<p>${reply.reply_contents}</p>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
		<div class="mb-3">
				<label for="contents">댓글</label>
				<input type="text" path="contents" id="reply" class="form-control"  />
		</div>
		<div class='row' style='height: 30px'></div>
		<div class='row d-flex justify-content-end'>
			<button type='button' class='btn btn-outline-secondary' id='btnList'>목록</button>
			<button type='button' class='btn btn-outline-secondary' id='btnUpdate'>수정</button>
			<%-- <a href = "${contextPath}/board/updateQna?seq=${list.seq}">수정</a> --%>
			<button type="button" class='btn btn-outline-secondary' id='btnDelete'>삭제</button>
		</div>
		<br> <br>
		<div class='row' style='height: 30px'></div>
		<div>
			<c:if test="${nextTitle != null }">
				<p>
					다음글 : <a href="${contextPath}/board/qnaDetail?seq=${nextSeq}">${sessionScope.nextTitle }</a>
				</p>
			</c:if>

			<c:if test="${prevTitle != null }">
				<p>
					이전글 : <a href="${contextPath}/board/qnaDetail?seq=${prevSeq}">${sessionScope.prevTitle }</a>
				</p>
			</c:if>
		</div>
		<div class='row' style="height: 300px"></div>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
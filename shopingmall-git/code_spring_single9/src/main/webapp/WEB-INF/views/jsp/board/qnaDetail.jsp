<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
function init(){
	$('#list').click(()=>{
		location.href="${contextPath}/board/qnaList";
	})
}
$(init);


function changeView(address){
	window.location.href=address;
}


function updateQna2() {
	
	location.href='/board/updateQna?seq='+ ${data.seq};
}

function deleteQna2() {
	
	location.href='/board/boardDelete?seq='+ ${data.seq};
}

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
	<form name="qna" method="POST" action="../board/writeQna"
		id="submitQna">
		<div class='row m-3'>
			<label for="title" class='col-sm-2 col-form-label'>게시글번호</label>
			<div class='col-sm-5'>
				<p>${data.seq}</p>
			</div>
		</div>
		<div class='row m-3'>
			<label for="title" class='col-sm-2 col-form-label'>제목</label>
			<div class='col-sm-5'>
				<p>${data.title}</p>
			</div>
		</div>
		<div class='row' style='height: 15px'></div>
		<div class='row'>
			<label for="contents" class='col-sm-2 col-form-label'>내용</label>
			<div class='col-sm-5'>
				<p>${data.contents}</p>
			</div>
		</div>
		<div class='row'>
			<label for="response_yn" class='col-sm-2 col-form-label'>답변</label>
			<div class='col-sm-5'>

				<c:choose>
					<c:when test="${data.response_yn eq '답변대기'}">
						<p>답변이 없습니다.</p>
					</c:when>
					<c:otherwise>
						<p>${reply.reply_contents}</p>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
		<div class='row d-flex justify-content-end'>
			<button type='button' class='btn btn-outline-secondary' id='list'>목록</button>
			<button type='button' class='btn btn-outline-secondary'
				id='updateQna' onclick="updateQna2()">수정</button>
			<%-- <a href = "${contextPath}/board/updateQna?seq=${data.seq}">수정</a> --%>
			<button type="button" class='btn btn-outline-secondary' 
				id='deleteQna' onclick="deleteQna2()">삭제</button>
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
	</form>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
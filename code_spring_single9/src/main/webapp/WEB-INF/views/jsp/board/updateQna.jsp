<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
 

<script>   
//목록으로 이동 이벤트
$(document).on('click', '#btnList', function(){
	location.href = "${pageContext.request.contextPath}/board/qnaList";
});

$(document).on('click', '#updateSave', function(){
	location.href = "${pageContext.request.contextPath}/board/updateSave";
});



</script>
<style>
textarea{
	width:485px;
	resize:none;
}

</style>
<input type="hidden" name="mode" />
<div class='container'>
	<h3>Q&A 수정</h3>
	<div class='row' style='height:30px'></div>
	<form method="POST" action="/board/updateSave" id="submitQna">
		<div class='row m-3'>
			<div class='col-sm-5'>
				<input type='hidden' id='seq' name='seq' value="${qnaDetail.seq }">
			</div>	
		</div>
		<div class='row'>
			<label for="view_count" class='col-sm-2 col-form-label'>조회수</label>
			<div class='col-sm-5'>
				<input type='text' id='title' name='title' readonly value="${qnaDetail.view_count }">
			</div>	
		</div>
		<div class='row' style='height:15px'></div>
		<div class='row m-3'>
			<label for="title" class='col-sm-2 col-form-label'>제목</label>
			<div class='col-sm-5'>
				<input type='text' id='title' name='title' value="${qnaDetail.title }">
			</div>	
		</div>
		<div class='row' style='height:15px'></div>
		<div class='row'>
			<label for="u_id" class='col-sm-2 col-form-label'>작성자</label>
			<div class='col-sm-5'>
				<input type='text' id='title' name='title' readonly value="${qnaDetail.u_id }">
			</div>	
		</div>
		<div class='row' style='height:15px'></div>
		<div class='row'>
			<label for="contents" class='col-sm-2 col-form-label'>내용</label>
			<div class='col-sm-5'>
				<p><textarea id='contents' name='contents'>${qnaDetail.contents}</textarea></p>
			</div>		
		</div>
		<div class='row d-flex justify-content-end'>
			<button type='button' class='btn btn-outline-secondary' id='updateSave' onclick="updateSave()">수정</button>
		</div>
		<div class='row' style="height:300px"></div>
	</form>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>
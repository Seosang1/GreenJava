<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
function init(){
	$('#updateQna').click(()=>{
		console.log($('#title').val() +" "+ $('#contents').val())
		if($('#title').val() && $('#contents').val()){
			$('#submitQna').submit();		
		}	
	})
}
$(init);


</script>
<style>
textarea{
	width:485px;
	resize:none;
}

</style>
<div class='container'>
	<h3>Q&A 수정</h3>
	<div class='row' style='height:30px'></div>
	<form method="POST" action="/board/updateBoard" id="submitQna">
		<div class='row m-3'>
			<div class='col-sm-5'>
				<input type='hidden' id='seq' name='seq' value="${data.seq }">
			</div>	
		</div>
		<div class='row m-3'>
			<label for="title" class='col-sm-2 col-form-label'>제목</label>
			<div class='col-sm-5'>
				<input type='text' id='title' name='title' value="${data.title }">
			</div>	
		</div>
		<div class='row' style='height:15px'></div>
		<div class='row'>
			<label for="contents" class='col-sm-2 col-form-label'>내용</label>
			<div class='col-sm-5'>
				<p><textarea id='contents' name='contents'>${data.contents}</textarea></p>
			</div>		
		</div>
		<div class='row d-flex justify-content-end'>
			<button type='button' class='btn btn-outline-secondary' id='updateQna'>수정</button>
		</div>
		<div class='row' style="height:300px"></div>
	</form>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>
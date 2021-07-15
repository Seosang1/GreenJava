<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

	$(document).on('click', '#write', function(e) {

		e.preventDefault();

		$("#submitQna").submit();
		

	});
 
</script>



<style>
textarea{
	width:485px;
	resize:none;
}

</style>
<div class='container'>
	<h3>Q&A 작성</h3>
	<div class='row' style='height:30px'></div>
	<form method="POST" action="writeQnaAct" id="submitQna">
		<div class='row m-3'>
			<label for="category" class='col-sm-2 col-form-label'>카테고리</label>
			<div class='col-sm-5'>
				<input type='text' id='category' name='category'  value="etc">
			</div>	
			
			<label for="title" class='col-sm-2 col-form-label'>제목</label>
			<div class='col-sm-5'>
				<input type='text' id='title' name='title'>
			</div>	
			
			<label for="u_id" class='col-sm-2 col-form-label'>아이디</label>
			<div class='col-sm-5'>
				<input type='text' id='u_id' name='u_id'>
			</div>	
		</div>
		<div class='row' style='height:15px'></div>
		<div class='row'>
			<label for="contents" class='col-sm-2 col-form-label'>내용</label>
			<div class='col-sm-5'>
				<p><textarea id='contents' name='contents'></textarea></p>
			</div>		
		</div>
		<div class='row d-flex justify-content-end'>
			<button type='button' class='btn btn-outline-secondary' id='write'>제출</button>
		</div>
		<div class='row' style="height:300px"></div>
	</form>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>
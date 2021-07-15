<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
function changeView(address){
	window.location.href=address;
}
function init(){
	$.ajax({
		url:'../admin/getReply',
		type:'post'
	}).done(result => {
		if(result != ""){
			$('#responseSpace').append('<p>'+result+'</p>')
		} else {
			$('#responseSpace').append('<textarea id="reply_contents"></textarea>');
		}
	})
	$('#response').click(()=>{
		alert($('#reply_contents').val());
		$.ajax({
			type:'post',
			url:'../admin/response',
			data:({
				reply_contents:$('#reply_contents').val()
			})
		}).done(result=>{
			if(result != 0){
				alert(`${responseResult}`);
				changeView('../admin/ad_BOARD');
			}
			
		})
		
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
	<h3>Q&A</h3>
	<div class='row' style='height:30px'></div>
	<form method="POST" action="../board/writeQna" id="submitQna">
		<div class='row m-3'>
			<label for="title" class='col-sm-2 col-form-label'>제목</label>
			<div class='col-sm-5'>
				<p>${data.title}</p>
			</div>	
		</div>
		<div class='row' style='height:15px'></div>
		<div class='row'>
			<label for="contents" class='col-sm-2 col-form-label'>내용</label>
			<div class='col-sm-5'>
				<p>${data.contents}</p>
			</div>		
		</div>
		<div class='row'>
			<label for="response_contents" class='col-sm-2 col-form-label'>답변</label>
			<div class='col-sm-5' id='responseSpace'>
			</div>		
		</div>
		<div class='row d-flex justify-content-end'>
			<button type='button' class='btn btn-secondary' id='response'>답변</button>
			<button type='button' class='btn btn-outline-secondary' id='modify'>수정</button>
			<button type='button' class='btn btn-outline-secondary' id='delete'>삭제</button>
		</div>
		<div class='row' style="height:300px"></div>
	</form>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>
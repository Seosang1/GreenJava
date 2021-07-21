<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<% String uid = (String)session.getAttribute("u_id");  %>
<script>

	$(document).on('click', '#write', function(e) {
		e.preventDefault();
		$("#form").submit();
	});
 
	
	$(document).ready(function(){
		var mode = '<c:out value="${mode}"/>';
		if ( mode == 'edit'){
			//입력 폼 셋팅
			$("#u_id").prop('readonly', true);
			$("input:hidden[name='seq']").val(<c:out value="${list.seq}"/>);
			$("input:hidden[name='mode']").val('<c:out value="${mode}"/>');
			$("#u_id").val('<c:out value="${qnaDetail.u_id}"/>');
			$("#title").val('<c:out value="${qnaDetail.title}"/>');
			$("#contents").val('<c:out value="${qnaDetail.contents}"/>');
			$("#category").val('<c:out value="${qnaDetail.category}"/>');
		}
	});
</script>



<style>
textarea{
	width:485px;
	resize:none;
}  

</style>
<div class='container'>
<form:form name="form" id="form" role="form" modelAttribute="boardDto"  action="writeQnaAct">
<form:hidden path="seq" />
<input type="hidden" name="mode" />
<h3>Q&A 작성</h3>
<div class='row' style='height:30px'></div>
<div class='row'>
	<div class="mb-3">
		<label for="category">카테고리</label>
		<form:input path="category" id="category" class="form-control" />
	</div>
	
	<div class="mb-3">
		<label for="title">제목</label>
		<form:input path="title" id="title" class="form-control" />
	</div>

	<div class="mb-3">
		<label for="u_id">작성자</label>
		<form:input path="u_id" id="u_id" class="form-control" value="<%=uid%>" readonly="true"  />
	</div>

	<div class="mb-3">
		<label for="contents">내용</label>
		<form:textarea path="contents" id="contents" class="form-control" rows="5"  />
	</div>
</div>
<div class='row d-flex justify-content-end'>
	<button type='button' class='btn btn-outline-secondary' id='write'>저장</button>
</div>
<div class='row' style="height:300px"></div>

</form:form>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<script>
$(function() {
	var uid = "<%=(String)session.getAttribute("u_id")%>";
	if(uid == null && uid == "") {
		document.getElementById("u_id").value = "로그인 후 작성가능합니다.";
	} else {
		console.log("아이디 확인");
		document.getElementById("u_id").value = userId;
	}
});



$(function(){
	showReplyList();
});


function showReplyList() {
	var url = "${pageContext.request.contextPath}/restBoard/getReplyList";
	var paramData = { "seq" : "${qnaDetail.seq}" };
	$.ajax({
	type : 'POST',
	url : url,
	data : paramData,
	dataType : 'json',
	success : function(result) { 
		var htmls = "";
		if (result.length < 1) {
			htmls = "등록된 댓글이 없습니다.";
		} else {
			$(result).each(
				function() {
					htmls += '<div class="media text-muted pt-3" id="rid' + this.rid + '">';
					htmls += '<p class="media-body pb-3 mb-0 lh-125 border-bottom horder-gray" style="font-size:12px">';
					htmls += '<span class="d-block">'; 
					htmls += '<strong class="text-gray-dark">' + this.u_id + '</strong></span>';
					htmls += '<span style="padding-left: 7px;">' + this.reply_contents + '&nbsp;&nbsp;&nbsp;</span>';
					htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.rid + ', \'' + this.u_id + '\', \'' + this.reply_contents + '\' )" style="padding-right:5px">수정</a>';
					htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.rid + ')" >삭제</a></p></div>';	
				}); //each end
		}
		$("#replyList").html(htmls);
		} // Ajax success end
	}); // Ajax end

}
// 수정기능
function fn_editReply(rid, u_id, reply_contents){
	var uid = "<%=(String)session.getAttribute("u_id")%>";
	var admin = "<%=(String)session.getAttribute("u_code")%>";
	var htmls = "";
	if (uid == u_id && admin == 'A') {
		alert("작성자만 수정할 수 있습니다.");
	} else {
		htmls += '<div class="media text-muted pt-3" id="rid' + this.rid + '">';
		htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
		htmls += '<span class="d-block">';
		htmls += '<strong class="text-gray-dark">' + u_id + '</strong>';
		htmls += '<span style="padding-left: 7px; font-size: 9pt">';
		htmls += '<a href="javascript:void(0)" onclick="fn_updateReply(' + rid + ', \'' + u_id + '\')" style="padding-right:5px">저장</a>';
		htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소<a>';
		htmls += '</span>';
		htmls += '</span>';		
		htmls += '<textarea name="editContent" id="editContent" class="form-control" rows="3">';
		htmls += reply_contents;
		htmls += '</textarea>';
		htmls += '</p>';
		htmls += '</div>';
		$('#rid' + rid).replaceWith(htmls);
		$('#rid' + rid + ' #editContent').focus();
	}

}



//댓글 저장 버튼 클릭 이벤트
$(document).on('click', '#btnReplySave', function(){
	var replyContent = $('#reply_contents').val();
	var replyReg_id = $('#u_id').val();
	var paramData = JSON.stringify({"reply_contents": replyContent, "u_id": replyReg_id, "seq":'${qnaDetail.seq}'});
	var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: "${pageContext.request.contextPath}/restBoard/saveReply"
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();
			$('#reply_contents').val('');
			$('#u_id').val('');
		}
		, error: function(error){
			console.log("저장버튼 에러 : " + error);
		}
	});
});

// 수정내용 저장
function fn_updateReply(rid, reg_id){
	var replyEditContent = $('#editContent').val();
	var paramData = JSON.stringify({"reply_contents": replyEditContent, "rid": rid });
	var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: "${pageContext.request.contextPath}/restBoard/updateReply"
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){ 
			console.log(result);
			showReplyList();
		}
		, error: function(error){
			console.log("댓글 저장버튼 에러 : " + error);
		}
	});
}

function fn_deleteReply(rid){
	var paramData = {"rid": rid};
	$.ajax({
		url: "${pageContext.request.contextPath}/restBoard/deleteReply"
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();
		}
		, error: function(error){
			console.log("댓글 삭제 에러 : " + error);
		}
	});
}


$(document).on('click', '#btnList', function() {
	location.href = "${pageContext.request.contextPath}/board/qnaList";
});

$(document).on('click', '#btnUpdate', function() {
	var url = "${pageContext.request.contextPath}/board/updateQna";
	url = url + "?seq=" + ${qnaDetail.seq};
	url = url + "&mode=edit";

	location.href = url;
});

$(document).on('click', '#btnDelete', function() {
	var url = "${pageContext.request.contextPath}/board/deleteQna";
	url = url + "?seq=" + $
	{qnaDetail.seq};
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
	<!-- Reply Form {s} -->
	<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
		<form:form name="form" id="form" role="form" modelAttribute="boardDto"
			method="post">
			<form:hidden path="seq" id="seq" />
			<div class="row">
				<div class="col-sm-10">
					<form:textarea path="reply_contents" id="reply_contents" class="form-control"
						rows="3" placeholder="댓글을 입력해 주세요"></form:textarea>
				</div>
				<div class="col-sm-2">
					<form:input path="u_id" class="form-control" id="u_id" ></form:input>
					<button type="button" class="btn btn-sm btn-primary"
						id="btnReplySave" style="width: 100%; margin-top: 10px">
						저 장
					</button>
				</div>
			</div>
		</form:form>
	</div>
	<!-- Reply Form {e} -->

	<!-- Reply List {s}-->
	<div class="my-3 p-3 bg-white rounded shadow-sm"
		style="padding-top: 10px">
		<div id="replyList"></div>
	</div>
	<!-- Reply List {e}-->

	<div class='row' style='height: 30px'></div>
	<div class='row d-flex justify-content-end'>
		<button type='button' class='btn btn-outline-secondary' id='btnList'>목록</button>
		<button type='button' class='btn btn-outline-secondary' id='btnUpdate'>수정</button>
		<%-- <a href = "${contextPath}/board/updateQna?seq=${list.seq}">수정</a> --%>
		<button type="button" class='btn btn-outline-secondary' id='btnDelete'>삭제</button>
	</div>
	<br> <br>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/ad_header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
function loadData(){
		$('#contentSpace').empty();
		$.ajax({
			type:'post',
			url:"<%=request.getContextPath() %>/board/load"
		}).done(result => {
			if(result.length){
				let contentList = [];
				$.each(result, (idx, a) => {
					contentList.unshift(
						`<tr>
							<td>\${a.seq}</td>
							<td>\${a.title}</td>
							<td>\${a.u_id}</td>
							<td>\${a.view_count}</td>
							<td>\${a.create_date}</td>
						</tr>`
					);
					
					$('#contentSpace').append(contentList.join(''));
				})	
			} else {
				$('#contentSpace').append(
						`<tr>
						<td colspan="5">등록된 글이 없습니다.</td>
					</tr>`
				);
			}
			
		});
}

function init(){
	loadData();	
}
$(init);
</script>
<style>
.h-no{
	width:150px;
}
#contentSpace{
	justify-content:center;
}
</style>
<div class='container'>
	<div class='row' style="height:500px">
		<table border="1">
		<thead>
		<tr>
			<th class='h-no'>번호</th>
			<th class='h-title'>제목</th>
			<th class='h-writer'>작성자</th>
			<th class='h-cnt'>조회수</th>
			<th class='h-regDate'>등록일</th>
		</tr>
		</thead>
		<tbody id='contentSpace'>
		</tbody>
	</table>
	</div>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>
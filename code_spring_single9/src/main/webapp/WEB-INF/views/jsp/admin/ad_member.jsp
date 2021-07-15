<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/ad_header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
function loadData(){
	var lastScrollTop = 0;
	$(window).scroll(function(){
		var currentScrollTop = $(window).scrollTop();
		//console.log(currentScrollTop);
	})
		//$('#contentSpace').empty();
	
		$.ajax({
			type:'post',
			url:"<%=request.getContextPath() %>/member/list"
		}).done(result => {
			if(result.length){
				let contentList = [];
				$.each(result, (idx, a) => {
					var identity = a.u_code;
					if(identity == "A"){
						identity = "관리자";
					} else identity = "일반회원";
					contentList.unshift(
						`<tr>
							<td>\${a.u_id}</td>
							<td>\${a.u_name}</td>
							<td>\${a.u_tel}</td>
							<td>\${a.u_email}</td>
							<td>\${a.u_address}</td>
							<td>\${a.u_start_date}</td>
							<td>\${identity}</td>
						</tr>`
					);
				})	
				$('#contentSpace').append(contentList.join(''));
			} else {
				$('#contentSpace').append(
						`<tr>
						<td colspan="2">유저가 없습니다.</td>
					</tr>`
				);
			}
			
		});
	
}
function search(){
	$('#contentSpace').empty();
	let keyword = $('#keyword').val();
	$.ajax({
		type:"post",
		url:"${contextPath}/member/find_user",
		data:({
			keyword: keyword
		})
	}).done(result => {
		//alert(`${searchErr}`);
		let userList = [];
		if(result != ""){
			$.each(result, (idx, a) => {
				userList.unshift(
						`<tr>
						<td>\${a.u_id}</td>
						<td>\${a.u_name}</td>
						<td>\${a.u_tel}</td>
						<td>\${a.u_email}</td>
						<td>\${a.u_address}</td>
						<td>\${a.u_start_date}</td>
						<td>\${a.u_code}</td>
					</tr>`					
				);
			})
			$('#contentSpace').append(userList.join(''));
		} else {
			$('#contentSpace').append(
					`<tr>
					<td colspan="5">유저가 없습니다.</td>
				</tr>`
			);
		}
	})
}
function init(){
	loadData();	
	$('#keyword').keydown(e=>{
		if(e.keyCode == 13){
			search();
		}
	})
	$('#search').click(()=>{
		search();
	})
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
	<input type='hidden' id='lastId'/>
		<div class='row'>
			<label for="keyword" class="col-sm-2 col-form-label">유저 검색</label>
			<div class='col-sm-5'>
				<input type='text' class="form-control" id="keyword" placeholder="이름이나 아이디를 입력하세요"/>
			</div>
			<div class='col'>
				<button type="button" class="btn btn-secondary" id="search">검색</button>
			</div>
		</div>
		<div class='row' style="height:30px"></div>
	
	<div class='row' style="height:500px">
		<table border="1">
		<thead>
		<tr>
			<th class='userId'>아이디</th>
			<th class='userName'>이름</th>
			<th class='userTel'>전화번호</th>
			<th class='userEmail'>이메일</th>
			<th class='userAddress'>주소</th>
			<th class='userStartDate'>가입일</th>
			<th class='userCode'>구분</th>
		</tr>
		</thead>
		<tbody id='contentSpace'>
		</tbody>
	</table>
	</div>
</div>
<!-- 관리자페이지 푸터 삭제 -->
</body>
</html>
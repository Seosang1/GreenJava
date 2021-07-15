<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<head>
<script>
	function goBack() {
		window.history.back();
	}
</script>
</head>
<br>
<br>
<br>
<br>
<br>
<div id="login_wrap">
	<div class='row' style="height: 400px">
		<div class='col-sm-3'></div>
		<div class='col-sm-9'>
			<h2 class="login_title">비밀번호 찾기</h2>
			<form method="post" action="member/find_pwd" name="findform">
				<div class="mb-3 row">
					<label for="u_name" class="col-sm-2 col-form-label">아이디</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="u_id" name="u_id"
							placeholder="아이디를 입력하세요">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="u_name" class="col-sm-2 col-form-label">이름</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="u_name" name="u_name"
							placeholder="이름을 입력하세요">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="u_email" class="col-sm-2 col-form-label">이메일</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="u_email"
							name="u_email" placeholder="이메일을 입력하세요">
					</div>
				</div>
				<c:if test="${check == 1}">
					<script>
						alert("일치하는 정보가 없습니다.");
						history.back();
					</script>
				</c:if>

				<c:if test="${check == 0 }">
					<script>
						alert("해당 이메일로 임시 비밀번호를 보냈습니다.");
						location.href = "/main"
					</script>
				</c:if>

				<div class="mb-3 row">
					<label for="u_name" class="col-sm-2 col-form-label"></label>
					<div class="col-sm-5">
						<input type="submit" value="확인" class="input_button" />
					</div>
				</div>

				<div class='mb-3 row'>
					<div id="login_menu">
						<input type="button" value="뒤로가기" class="input_button"
							onclick="goBack();" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>


<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
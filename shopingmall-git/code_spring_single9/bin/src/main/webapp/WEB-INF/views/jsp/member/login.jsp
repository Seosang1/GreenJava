<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp" %>

<head>
<script>
</script>
</head>
<br><br><br><br><br>
<div id="login_wrap">
	<h2 class="login_title">로그인</h2>
	<form method="post" action="login_ok" >
		<table id="login_table">
			<div class="mb-3 row">
				<label for="u_id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_id" name="u_id" placeholder="ID를 입력하세요">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="u_pwd" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="u_pwd" name="u_pwd" placeholder="비밀번호를 입력하세요">
				</div>
			</div>
		</table>
		<div id="login_menu">
			<input type="submit" value="로그인" class="input_button" />
		</div>
	</form>
</div>

<br>
<tr>
	<td>아직 회원이 아니신가요?</td>
	<td><input type="button" value="회원가입" class="input_button"
		onclick="location.href='join'" /></td>
<tr>
	<br>
	<br>
	<td>비밀번호가 기억이 안나나요?</td>
	<input type="button" value="비번찾기" class="input_button"
		 />
<br><br><br><br><br>
		
		
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>
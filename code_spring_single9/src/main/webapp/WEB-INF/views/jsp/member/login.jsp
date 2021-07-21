<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp" %>

<head>


 <c:choose>
 	<c:when test="${sessionScope.loginErr != null}">
 		<script>
 			alert(`${loginErr}`)
 		</script>
 	</c:when>
 </c:choose>
</head>
<br><br><br><br><br>
<div id="login_wrap">
<div class='row' style="height:400px">
	<div class='col-sm-3'>
	
	</div>
	<div class='col-sm-9'>
		<h2 class="login_title">로그인</h2>
	<form name="loginForm" method="post" action="/member/userlogin">
			<div class="mb-3 row">
				<label for="u_id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_id" name="u_id"
						placeholder="ID를 입력하세요">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="u_pwd" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="u_pwd" name="u_pwd"
						placeholder="비밀번호를 입력하세요">
				</div>
				<input type="submit" value="로그인" class="input_button"  />
			</div>
			<div class='mb-3 row'>
				<div id="login_menu">
				
				<p>아직 회원이 아니신가요?</p>
				<input type="button" value="회원가입" class="input_button" onclick="location.href='join'" />
				<p>아이디가 기억이 안나나요?</p>
				<input type="button" value="아이디찾기" class="input_button" onclick="location.href='findIdView'" />
				<p>비밀번호가 기억이 안나나요?</p>
				<input type="button" value="비번찾기" class="input_button" onclick="location.href='findPwdView'" />
				</div>	
			</div>
		
	</form>
	</div>
</div>
</div>
		
		
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>
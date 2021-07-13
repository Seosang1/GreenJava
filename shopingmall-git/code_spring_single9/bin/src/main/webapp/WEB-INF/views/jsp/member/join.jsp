<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<head>
<script>
</script>
</head>
<body>
	<br><br><b>회원정보</b><br><br>

	<b>기본정보</b><br><br>

	<form  method="POST" action="registId" id="joinForm" >
<!-- 	<input type="button" value="test" id="test"/> -->
		<table id=basic-info border="1">
			<div class="mb-3 row">
				<label for="u_id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_id" name="u_id"  maxlength="20" placeholder="ID를 입력하세요">
				</div>
			<div class="check_font" id="id_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_pwd" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="u_pwd" name="u_pwd" maxlength="15" placeholder="비밀번호를 입력하세요">
				</div>
				<div class="check_font" id="pwd_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_pwd" class="col-sm-2 col-form-label">비밀번호 확인</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="u_pwd2" name="u_pwd2" maxlength="15" placeholder="비밀번호 확인을 입력하세요">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="u_name" class="col-sm-2 col-form-label">이름</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_name" name="u_name" maxlength="20" placeholder="이름을 입력하세요">
				</div>
					<div class="check_font" id="name_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_email" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_email" name="u_email" maxlength="40" placeholder="E-MAIL을 입력하세요">	
				</div>
				<div class="check_font" id="email_check"></div>
			</div>
			
			<div class="mb-3 row">
				<label for="u_tel" class="col-sm-2 col-form-label">휴대전화</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_tel" name="u_tel" maxlength="20" placeholder="'-' 없이 휴대폰 번호만 입력해주세요">
				</div>
				<div class="check_font" id="tel_check"></div>
			</div>
			
			<div class="mb-3 row">
				<label for="u_address" class="col-sm-2 col-form-label">주소</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_address" name="u_address" maxlength="40" placeholder="주소를 입력하세요">
				</div>
			</div>
		</table> <br><br>
		<b>추가정보</b> <br><br>
		
		<table id=basic-info border="1">
			<div class="mb-3 row">
				<label for="u_birth_yy" class="col-sm-2 col-form-label">생일</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_birth" name="u_birth" maxlength="40" placeholder="생일을 입력하세요 EX)19990102">
				</div>
				<div class="check_font" id="birth_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_birth_yy" class="col-sm-2 col-form-label">결혼기념일</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_wedding" name="u_wedding" maxlength="40" placeholder="결혼기념일 입력하세요">
				</div>
				<div class="check_font" id="wedding_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_birth_yy" class="col-sm-2 col-form-label">배우자생일</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_p_birth" name="u_p_birth" maxlength="40" placeholder="배우자생일 입력하세요">
				</div>
				<div class="check_font" id="pbirth_check"></div>
			</div>

		</table>
		<br>
		<br>
		<b>전체 동의</b><br>
		<br> 
		<button type="submit" id="joinBtn" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">가입</button>
		<button type="button" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">취소</button>
	</form>

	<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
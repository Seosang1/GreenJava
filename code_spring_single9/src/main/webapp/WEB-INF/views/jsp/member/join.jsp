<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<head>
<script type="text/javascript" charset="UTF-8">
</script>
</head>
<body>
	<br>
	<br>
	<b>회원정보</b>
	<br>
	<br>

	<b>기본정보</b>
	<br>
	<br>
	
	<form method="POST" action="member/joinmember" id="joinForm">
		<table id=basic-info border="1">
			<div class="mb-4 row">
				<label for="u_id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_id" name="u_id"
						maxlength="20" placeholder="ID를 입력하세요">
				</div>
				<div class="check_font" id="id_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_pwd" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="u_pwd" name="u_pwd"
						maxlength="15" placeholder="비밀번호를 입력하세요">
				</div>
				<div class="check_font" id="pwd_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_pwd" class="col-sm-2 col-form-label">비밀번호 확인</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="u_pwd2"
						name="u_pwd2" maxlength="15" placeholder="비밀번호 확인을 입력하세요">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="u_name" class="col-sm-2 col-form-label">이름</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_name" name="u_name"
						maxlength="20" placeholder="이름을 입력하세요">
				</div>
				<div class="check_font" id="name_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_email" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_email" name="u_email"
						maxlength="40" placeholder="E-MAIL을 입력하세요">
				</div>
				<input type="button" value="인증번호 받기" class="input_button" id="emailSend" />
				<div class="check_font" id="email_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_authKey" class="col-sm-2 col-form-label">이메일 인증번호</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_authKey" name="u_authKey"
						maxlength="40" placeholder="인증번호를 입력하세요" disabled="disabled">
				</div>
				<!-- <input type="button" value="인증하기" class="input_button" onclick="emailAuthSend()" /> -->
				<div class="check_font" id="u_authKey_check"></div>
			</div>

			<div class="mb-3 row">
				<label for="u_tel" class="col-sm-2 col-form-label">휴대전화</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_tel" name="u_tel"
						maxlength="20" placeholder="'-' 없이 휴대폰 번호만 입력해주세요">
				</div>
				<div class="check_font" id="tel_check"></div>
			</div>

			<div class="mb-3 row">
				<label for="u_address" class="col-sm-2 col-form-label">주소</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_address"
						name="u_address" maxlength="40" placeholder="주소를 입력하세요">
				</div>
			</div>
		</table>
		<br> <br> <b>추가정보</b> <br> <br>

		<table id=basic-info border="1">
			<div class="mb-3 row">
				<label for="u_birth_yy" class="col-sm-2 col-form-label">생일</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_birth" name="u_birth"
						maxlength="40" placeholder="생일을 입력하세요 EX)19990102">
				</div>
				<div class="check_font" id="birth_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_birth_yy" class="col-sm-2 col-form-label">결혼기념일</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_wedding"
						name="u_wedding" maxlength="40" placeholder="결혼기념일 입력하세요">
				</div>
				<div class="check_font" id="wedding_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_birth_yy" class="col-sm-2 col-form-label">배우자생일</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_p_birth"
						name="u_p_birth" maxlength="40" placeholder="배우자생일 입력하세요">
				</div>
				<div class="check_font" id="pbirth_check"></div>
			</div>

		</table>
		<br> <br> <b>전체 동의</b><br> <br>
		<button type="submit" id="joinBtn"
			class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">가입</button>
		<button type="button"
			class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">취소</button>
			
		
	</form>
<script>
$(function(){
		
		var authNum = "";
		var empPattern = /\s/g;
		var idPattern = /^[A-Za-z0-9]{1}[A-Za-z0-9]{3,19}$/;
		var namePattern = /^[가-힣]{2,6}$/;
		var pwdPattern = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[0-9a-zA-Z])(?=.*[!@#$%^&+=./.,?]).*$/;
		var telPattern = /^01{0|1|6|7|8|9}-\d{3,4}-\d{4}$/;
		var dayPattern = /^\d{8}$/;
		var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

	$("#u_id").blur(function() {
		if (idPattern.test($(this).val())) {
				console.log(idPattern.test($(this).val()));
				$("#id_check").text('');
				check_id();
		} else {
			$('#id_check').text('아이디를 확인해주세요 (4자 이상)');
			$('#id_check').css('color', 'red');
		}
	});
	
	$("#u_pwd").blur(function() {
		if (pwdPattern.test($(this).val())) {
				console.log(pwdPattern.test($(this).val()));
				$("#pwd_check").text('');
		} else {
			$('#pwd_check').text('비밀번호를 확인해주세요 (8자 이상, 영문&특수문자사용)');
			$('#pwd_check').css('color', 'red');
		}
	});
	
	$("#u_pwd2").blur(function() {
		if (pwdPattern.test($(this).val())) {
				console.log(pwdPattern.test($(this).val()));
				$("#pwd_check2").text('');
		} else {
			$('#pwd_check2').text('비밀번호를 확인해주세요');
			$('#pwd_check2').css('color', 'red');
		}
	});
	

	$("#u_name").blur(function() {
		if (namePattern.test($(this).val())) {
				console.log(namePattern.test($(this).val()));
				$("#name_check").text('');
		} else {
			$('#name_check').text('이름을 확인해주세요');
			$('#name_check').css('color', 'red');
		}
	});
	
	$("#u_email").blur(function() {
		if (emailPattern.test($(this).val())) {
				console.log(emailPattern.test($(this).val()));
				$("#email_check").text('');
		} else {
			$('#email_check').text('이메일을 확인해주세요');
			$('#email_check').css('color', 'red');
		}
	}); 

	$("#emailSend").click(function() {
		var u_email = $("#u_email").val(); //입력한 이메일
		
		if(emailPattern.test($("#u_email").val())){
			console.log(emailPattern.test($("#u_email").val()));
			$.ajax({
				type : "GET",
				url : "<%=request.getContextPath() %>member/mailCheck?u_email=" + u_email,
				success:function(data){
					authNum = data;
					console.log("data : " + authNum);
					$("#u_authKey").attr("disabled",false);
				}
			});
		}
	});
	$("#u_authKey").blur(function() {
		var chk_auth = $("#u_authKey").val();
		
		if (chk_auth == authNum) {
			$('#u_authKey_check').text('인증확인이 되었습니다.');
			$('#u_authKey_check').css('color', 'green');
		} else{
			$('#u_authKey_check').text('인증번호가 맞지 않습니다.');
			$('#u_authKey_check').css('color', 'red');
			
		}
	});
		
	// 휴대전화
	$('#u_tel').blur(function(){
		if(telPattern.test($(this).val())){
			console.log(telPattern.test($(this).val()));
			$("#tel_check").text('');
		} else {
			$('#tel_check').text('휴대폰번호를 확인해주세요 :)');
			$('#tel_check').css('color', 'red');
		}
	});
	

	$('#u_birth').blur(function(){
		if(dayPattern.test($(this).val())){
			console.log(dayPattern.test($(this).val()));
			$("#birth_check").text('');
		} else {
			$('#birth_check').text('올바른 양식으로 작성해주세요 :)');
			$('#birth_check').css('color', 'red');
		}
	});
	

	$('#u_wedding').blur(function(){
		if(dayPattern.test($(this).val())){
			console.log(dayPattern.test($(this).val()));
			$("#wedding_check").text('');
		} else {
			$('#wedding_check').text('생년월일과 같은 양식으로 작성해주세요 :)');
			$('#wedding_check').css('color', 'red');
		}
	});
	

	$('#u_p_birth').blur(function(){
		if(dayPattern.test($(this).val())){
			console.log(dayPattern.test($(this).val()));
			$("#pbirth_check").text('');
		} else {
			$('#pbirth_check').text('생년월일과 같은 양식으로 작성해주세요 :)');
			$('#pbirth_check').css('color', 'red');
		}
	});
	
		
	 $("#joinForm").submit(function(){
		if($("#u_pwd").val() !== $("#u_pwd2").val()){
			alert("비밀번호가 다릅니다.");
			$("#u_pwd").val("").focus();
			$("#u_pwd2").val("");
			return false;
		}else if ($("#u_pwd").val().length < 8) {
			alert("비밀번호는 8자 이상으로 설정해야 합니다.");
			$("#u_pwd").val("").focus();
			return false;
		}else if($.trim($("#u_pwd").val()) !== $("#u_pwd").val() || $.trim($("#u_email").val()) !== $("#u_email").val() || $.trim($("#u_id").val()) !== $("#u_id").val()){
			alert("공백은 입력이 불가능합니다.");
			return false;
		}else if(!($("#u_authKey").val()==authNum)){
			alert("이메일 인증을 하셔야 합니다.");
			$("#u_authKey").val("").focus();
			return false;
		}
	}) 
	
	function check_id() {
		$.ajax({
			url : "<%=request.getContextPath() %>/member/checkid",
			type : "POST",
			data : { u_id : $("#u_id").val() },
			success : function(result) {
				if (result == 1) {
					$("#id_check").html("중복된 아이디가 있습니다.");
					$("#joinBtn").attr("disabled", "disabled");
				} else {
					$("#id_check").html("사용 가능한 아이디입니다.");
					$('#id_check').css('color', 'green');
					$("#joinBtn").removeAttr("disabled");
					
				}
			},
		})
	};
})
</script>
</body>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
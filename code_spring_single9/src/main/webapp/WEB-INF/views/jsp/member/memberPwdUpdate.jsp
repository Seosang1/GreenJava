<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<head>
<script type="text/javascript" charset="UTF-8">
	
</script>

<style>
#sideBanner {
	position: absolute;
	top: 100px;
	right: 0px;
	width: 100px;
	height: 400px;
}
</style>
</head>
<body>
	<br>
	<br>
	<b>비밀번호변경</b>
	<br>
	<br>


	<table id=basic-info border="1">
		<div class="mb-4 row">
			<label for="u_id" class="col-sm-2 col-form-label">아이디</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="u_id" name="u_id"
					maxlength="20" value="${member.u_id}" disabled="disabled">
			</div>
			<div class="check_font" id="id_check"></div>
		</div>
		<div class="mb-3 row">
			<label for="u_pwd" class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="u_pwd" name="u_pwd"
					maxlength="15" placeholder="새로운 비밀번호를 입력하세요">
			</div>
			<div class="check_font" id="pwd_check"></div>
		</div>
		<div class="mb-3 row">
			<label for="u_pwd" class="col-sm-2 col-form-label">비밀번호 확인</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="u_pwd2"
					name="u_pwd2" maxlength="15" placeholder="비밀번호 확인을 입력하세요">
			</div>
			<div class="check_font" id="pwd_check2"></div>
		</div>
	</table>
	<button type="submit" id="updatePwdBtn"
			class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">수정하기</button>
		
	<div id="sideBanner"></div>


	<script>
		$(function() {
			var empPattern = /\s/g;
			var idPattern = /^[A-Za-z0-9]{1}[A-Za-z0-9]{3,19}$/;
			var pwdPattern = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[0-9a-zA-Z])(?=.*[!@#$%^&+=./.,?]).*$/;

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

			$('#updatePwdBtn').click(function() {
				if ($("#u_pwd").val() !== $("#u_pwd2").val()) {
					alert("비밀번호가 다릅니다.");
					$("#u_pwd").val("").focus();
					$("#u_pwd2").val("");
					return false;
				} else if ($("#u_pwd").val().length < 8) {
					alert("비밀번호는 8자 이상으로 설정해야 합니다.");
					$("#u_pwd").val("").focus();
					return false;
				} else if ($.trim($("#u_pwd").val()) !== $("#u_pwd").val()) {
					alert("공백은 입력이 불가능합니다.");
					return false;
				}
				var data = {"u_pwd" : $("#u_pwd").val(),};
				$.ajax({
					method : "post",
					url : "member/memberPwdUpdate.do",
					data : JSON.stringify(data),
					contentType : "application/json;charset=utf-8",
					dataType : "json",
					success : function(d) {
						alert("비밀번호 수정이 완료되었습니다.");
					}
				})
			})
		})
	</script>
</body>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
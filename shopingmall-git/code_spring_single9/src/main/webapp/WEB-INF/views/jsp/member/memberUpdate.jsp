<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<head>
<script type="text/javascript" charset="UTF-8">
</script>
<style>
ul{
	list-style: none;
}

a{
	text-decoration: none;
}
#sideBanner {
	position: absolute;
	top: 100px;
	right: 0px;
	width: 100px;
	height: 350px;
	margin-top : 100px;
}

</style>
</head>
<body>
	<br>
	<br>
	<b>회원수정</b>
	<br>
	<br>


		<table id=basic-info border="1">
			<div class="mb-4 row">
				<label for="u_id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_id" name="u_id"
						maxlength="20" placeholder="ID를 입력하세요" value="${member.u_id}" disabled="disabled">
					<input type="hidden" id="u_pwd" name="u_pwd" value="${member.u_pwd}">
				</div>
				<div class="check_font" id="id_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_name" class="col-sm-2 col-form-label">이름</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_name" name="u_name"
						maxlength="20" placeholder="이름을 입력하세요"
						value="${member.u_name}">
				</div>
				<div class="check_font" id="name_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_email" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_email" name="u_email"
						maxlength="40" placeholder="E-MAIL을 입력하세요"
						value="${member.u_email}">
				</div>
				<div class="check_font" id="email_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_tel" class="col-sm-2 col-form-label">휴대전화</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_tel" name="u_tel"
						maxlength="20" placeholder="'-' 없이 휴대폰 번호만 입력해주세요"
						value="${member.u_tel}">
				</div>
				<div class="check_font" id="tel_check"></div>
			</div>
			<div class="mb-3 row">
				<label for="u_address" class="col-sm-2 col-form-label">주소</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="u_address"
						name="u_address" maxlength="40" placeholder="주소를 입력하세요"
						value="${member.u_address}">
				</div>
			</div>
			
		</table>

		</table>
		<button type="submit" id="updateBtn"
			class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">수정하기</button>
		<button type="button" id="deleteBtn"
			class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">탈퇴</button>
		
		<div id="sideBanner">
			<ul>
				<li><a href="../memberUpdateView">회원수정</a></li>
				<li><a href="../memberPwdUpdateView">비밀번호 변경</a></li>
			</ul>
		</div>

<script>
$

$(function(){
	
		var empPattern = /\s/g;
		var idPattern = /^[A-Za-z0-9]{1}[A-Za-z0-9]{3,19}$/;
		var namePattern = /^[가-힣]{2,6}$/;
		var pwdPattern = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[0-9a-zA-Z])(?=.*[!@#$%^&+=./.,?]).*$/;
		var telPattern = /^01{0|1|6|7|8|9}-\d{3,4}-\d{4}$/;
		var dayPattern = /^\d{8}$/;
		var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

	

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
	
	$('#updateBtn').click(function(){
		var data = {"u_name" :$("#u_name").val(),
				"u_email":$("#u_email").val(),
				"u_tel":$("#u_tel").val(),
				"u_address":$("#u_address").val()};
		$.ajax({
			method:"post",
			url:"member/memberUpdate.do",
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			dataType:"json",
			success:function(d){
				alert("회원 프로필이 수정 되었습니다.");
			}
		})		
	})
	
	$('#deleteBtn').click(function() {
		if(${empty sessionScope.member}){
			location.href="/";
			return false;
		}
		var result = confirm("정말 탈퇴하시겠습니까?");
		if(result){
			alert("계정이 삭제되었습니다.")
			location.href="member/memberDelete.do";
		}
		
	})
}) 
	
	
	</script>
</body>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
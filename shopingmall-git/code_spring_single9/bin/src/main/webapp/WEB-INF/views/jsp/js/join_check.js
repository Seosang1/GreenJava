$(function(){
	
		var empPattern = /\s/g;
		var idPattern = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;
		var namePattern = /^[가-힣]{2,6}$/;
		var pwdPattern = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
		var telPattern = /^01{0|1|6|7|8|9}-\d{3,4}-\d{4}$/;
		var dayPattern = /^\d{8}$/;
		var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
	$("#u_id").blur(function() {
		if (idPattern.test($(this).val())) {
				console.log(idPattern.test($(this).val()));
				$("#id_check").text('');
		} else {
			$('#id_check').text('아이디를 확인해주세요');
			$('#id_check').css('color', 'red');
		}
	});
	
	$("#u_pwd").blur(function() {
		if (pwdPattern.test($(this).val())) {
				console.log(pwdPattern.test($(this).val()));
				$("#pwd_check").text('');
		} else {
			$('#pwd_check').text('비밀번호를 확인해주세요');
			$('#pwd_check').css('color', 'red');
		}
	});
	
	$("#u_pwd2").blur(function() {
		if (pwdPattern.test($(this).val())) {
				console.log(pwdPattern.test($(this).val()));
				$("#pwd_check2").text('');
		} else {
			$('#pwd_check2').text('아이디를 확인해주세요');
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
		}
	}) 
	
	$("#u_id").keyup(function() {
		$.ajax({
			url : "check_id",
			type : "POST",
			data : {
				u_id : $("#u_id").val()
			},
			success : function(result) {
				if (result == 1) {
					$("#id_check").html("중복된 아이디가 있습니다.");
					$("#joinBtn").attr("disabled", "disabled");
				} else {
					$("#id_check").html("사용 가능한 아이디입니다.");
					$("#joinBtn").removeAttr("disabled");
					
				}
			},
		})
	});

	$("#u_email").keyup(function(){
		$.ajax({
			url : "check_email",
			type : "POST",
			data : {
				u_email : $("#u_email").val()
			},
			success : function(result) {
				if (result < 1) { /* 테이블 생성 후 테스트 시에 같은 이메일 값으로 등록해둬서 result == 1 을 사용하지 않고 < 1 로 작성*/
					$("#email_check").html("중복된 이메일이 있습니다.");
				} else {
					$("#email_check").html("");
			}
			},
		})
	});
})
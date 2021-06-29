<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function chkValue(frm) {
	var id = frm.uid.value;	
	var pwd = frm.pwd.value;	
	
	if (id == "") {
		alert("아이디를 입력하세요.");		
		return false;
	}
	else if (id.length < 4) {
		alert("아이디를 4자 이상 입력하세요.");		
		return false;
	}
	if (pwd == "") {
		alert("비밀번호를 입력하세요.");		
		return false; 
	} else {   
		document.frmLogin.onsubmit(); 
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 폼</h2>
<a href="joinForm.jsp">회원가입</a>
<br /><br />
<form id="frmLogin" name="frmLogin" action="login_proc.jsp" method="post" onsubmit="return chkValue(this);">
아이디 : <input type="text" maxlength="20" name="uid" placeholder="아이디 입력" id="uid" /><br />
비밀번호 : <input type="password" maxlength="20" name="pwd" placeholder="비밀번호 입력" id="pwd" /><br />
<input type="submit" value="로그인" /> 
</form>
</body>
</html>

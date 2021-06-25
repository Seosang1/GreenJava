<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style> 
	#main {margin:auto; padding:0; text-align:center;}
 	#fldSet {width:350px; margin:auto 0; padding:0;}  
 	th {font-size:14px;}
 	.btn1 { position:relative; left:40px; }
	#btn2 { position:relative; left:40px; }
</style>
<script>
function isImg(str) {
	var arrImg = ["jpg", "gif", "png", "jpeg"];
	var ext = str.substring(str.lastIndexOf(".") + 1);
	for (var i = 0 ; i < arrImg.length ; i++) {
		if (ext == arrImg[i])	return true;
	}
	return false;
}

function isOffice(str) {
	var arrOff = ["hwp", "doc", "docx", "xls", "xlsx", "ppt", "pptx"];
	var ext = str.substring(str.lastIndexOf(".") + 1);
	for (var i = 0 ; i < arrOff.length ; i++) {
		if (ext == arrOff[i])	return true;
	}
	return false;
}
function chkValue(frm) {
	var img = frm.img.value; var file1 = frm.file1.value; 
	var file2 = frm.file2.value; var file3 = frm.file3.value;
	
	if (!isImg(img)) {
		alert("증명사진이 이미지 파일이 아닙니다."); return false;
	} else if (!isOffice(file1)) {
		alert("이력서가 오피스 파일이 아닙니다."); return false; 
	} else if (!isOffice(file2)) {
		alert("증빙서류1이 오피스 파일이 아닙니다."); return false; 
	} else if (!isOffice(file3)) {
		alert("증빙서류2가 오피스 파일이 아닙니다."); return false; 
	}  
}
</script>
</head>
<body> 
<form name="frmJoin" action="testProc.jsp" method="post" enctype="multipart/form-data"
	onsubmit="return chkValue(this);">
<fieldset id="fldSet">
	<table id="main" cellpadding="5" cellspacing="5">
	<legend id="title">개인정보 등록 폼</legend>
	<tr><th><label for="name">이름</label></th>
		<td><input type="text" placeholder="예) 홍길동" name="name" id="name"> 
	</tr>
	<tr><th><label for="birth">생년월일</label></th>
		<td><input type="number" placeholder="숫자만 입력 예) 880504"></td>
	</tr>
	<tr><th><label for="img">증명사진</label></th>
		<td><input type="file" name="img" id="img" class="btn1"></td>
	</tr>
	<tr><th><label for="file3">이력서</label></th>
		<td><input type="file" name="file3" id="file3" class="btn1"></td>
	</tr>
	<tr><th><label for="file2">증빙서류1</label></th>
		<td><input type="file" name="file2" id="file2" class="btn1"></td>
	</tr>
	<tr><th><label for="file1">증빙서류2</label></th>
		<td><input type="file" name="file1" id="file1" class="btn1"></td>
	</tr>
	<tr>
		<td><input type="submit" value="정보 등록" id="btn2"></td><td>
		<input type="reset" value="다시 입력"></td>
	</tr>
	</form>
	</table>
	</fieldset>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title> 
</head>
<body>
<h2>글 등록 폼</h2>
<form name="frmForm" action="test_proc.brd" method="post"> 
<input type="hidden" name="wtype" value="in" />
<table width="700" cellpadding="5" cellspacing="0" id="brd">
<tr> 
<th width="15%">이름</th><td width="35%"><input type="text" name="bfwriter" /></td>
<th width="15%">암호</th><td width="35%"><input type="password" name="bfpwd" /></td> 
</tr>
<tr>
<th>제목</th>
<td colspan="3"><input type="text" name="bntitle" size="70" /></td>
</tr>
<tr>
<th>내용</th>
<td colspan="3"><textarea name="bncontent" cols="80" rows="10"></textarea></td>
</tr>
</table>
<p style="width:700px; text-align:center;">
	<input type="submit" value="등록 " />
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="다시 입력" />
</p>
</form>
</body>
</html>

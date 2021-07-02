<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
MemberInfo loginMember = (MemberInfo)session.getAttribute("loginMember");
// 세션의 속성(attribute)에 들어있는 로그인 정보(MemberInfo형 인스턴스)를 받아옴

if (loginMember == null) {
	out.println("<script>");
	out.println("alert('로그인 후 사용하실 수 있습니다.');");
	out.println("location.href='../login_form.jsp?url=member/mypage.mem';");
	out.println("</script>");
	out.close();
}

String[] arrPhone = loginMember.getMi_phone().split("-");
String[] arrEmail = loginMember.getMi_email().split("@");

String[] arrDomain = new String[5];
arrDomain[0] = "naver.com";
arrDomain[1] = "nate.com";
arrDomain[2] = "gmail.com";
arrDomain[3] = "daum.net";
arrDomain[4] = "yahoo.com";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function byeBye() {
	if (confirm("정말 탈퇴하시겠습니까?\n탈퇴시 적립된 포인트가 모두 소멸됩니다.")) {
		location.href = "proc.mem?wtype=del";
	}
}
</script>
</head>
<body>
<h2>회원정보 수정 폼</h2>
<form name="frmJoin" action="proc.mem" method="post">
<input type="hidden" name="wtype" value="up" />
<table border="1" cellpadding="5" width="700">
<tr>
<th width="20%">아이디</th>
<td width="*"><%=loginMember.getMi_id() %></td>
</tr>
<tr><th>이전 비밀번호</th><td><input type="password" name="old_pwd" /></td></tr>
<tr><th>바꿀 비밀번호</th><td><input type="password" name="mi_pwd" /></td></tr>
<tr><th>비밀번호 확인</th><td><input type="password" name="mi_pwd2" /></td></tr>
<tr><th>이름</th><td><%=loginMember.getMi_name() %></td></tr>
<tr><th>생년월일</th><td><%=loginMember.getMi_birth() %></td></tr>
<tr><th>성별</th><td><%=loginMember.getMi_gender().equals("f") ? "여자" : "남자" %></td></tr>
<tr>
<th>전화번호</th>
<td>
	<select name="p1">
		<option value="010" <% if (arrPhone[0].equals("010")) { %>selected="selected"<% } %>>010</option>
		<option value="011" <% if (arrPhone[0].equals("011")) { %>selected="selected"<% } %>>011</option>
		<option value="016" <% if (arrPhone[0].equals("016")) { %>selected="selected"<% } %>>016</option>
		<option value="019" <% if (arrPhone[0].equals("019")) { %>selected="selected"<% } %>>019</option>
	</select> -
	<input type="text" name="p2" size="4" maxlength="4" value="<%=arrPhone[1] %>" /> -
	<input type="text" name="p3" size="4" maxlength="4" value="<%=arrPhone[2] %>" />
</td>
</tr>
<tr>
<th>이메일</th>
<td>
	<input type="text" name="e1" value="<%=arrEmail[0] %>" /> @
	<select name="e2" onchange="setDomain(this.value);">
		<option value="">도메인 선택</option>
<% for (int i = 0 ; i < arrDomain.length ; i++) { %>
		<option value="<%=arrDomain[i] %>" <% if (arrEmail[1].equals(arrDomain[i])) { %>selected="selected"<% } %>><%=arrDomain[i] %></option>
<% } %>
		<option value="direct">직접 입력</option>
	</select>
	<input type="text" name="e3" value="<%=arrEmail[1] %>" />
</td>
</tr>
<tr>
<th>SNS 수신</th>
<td>
	<input type="radio" name="mi_issns" value="y"<% if (loginMember.getMi_issns().equals("y")) { %> checked="checked"<% } %> />수신
	<input type="radio" name="mi_issns" value="n"<% if (loginMember.getMi_issns().equals("n")) { %> checked="checked"<% } %> />미수신
</td>
</tr>
<tr>
<th>메일 수신</th>
<td>
	<input type="radio" name="mi_ismail" value="y"<% if (loginMember.getMi_ismail().equals("y")) { %> checked="checked"<% } %> />수신
	<input type="radio" name="mi_ismail" value="n"<% if (loginMember.getMi_ismail().equals("n")) { %> checked="checked"<% } %> />미수신
</td>
</tr>
</table>
<p style="width:700px; text-align:center;">
	<input type="submit" value="정보 수정" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="다시 입력" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="회원 탈퇴" onclick="byeBye();" />
</p>
</form>
</body>
</html>

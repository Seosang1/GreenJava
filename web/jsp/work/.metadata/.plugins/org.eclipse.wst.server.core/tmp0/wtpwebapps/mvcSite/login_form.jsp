<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="vo.*" %>
<%

	MemberInfo loginMember = (MemberInfo)session.getAttribute("loginMember"); 
	if (loginMember != null) {
	   out.println("<script>");
	   out.println("alert('�߸��� ��η� �����̽��ϴ�.');");
	   out.println("history.back();");
	   out.println("</script>");
	   out.close();
	}

	request.setCharacterEncoding("utf-8");
	String url = request.getParameter("url");	//	�α��� �� �̵��� ������ �ּ�(���� ��쵵 ����)
	if (url == null) url = "";	// url ���� ������ �� ���ڿ��� ��ȯ�Ͽ� ���
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	function chkVal(frm) {
		var uid = frm.uid.value;
		var pwd = frm.pwd.value;

		if (uid == "") {
			alert("���̵� �Է��ϼ���");
			frm.uid.focus(); 	return false;
		} else if (uid.length < 4) {
			alert("���̵�� 4�� �̻� ");
			frm.uid.focus(); 	return false;
		}

		if (pwd == "") {
			alert("��й�ȣ�� �Է��ϼ���");
			frm.pwd.focus(); 	return false;
		} else if (uid.length < 4) {
			alert("��й�ȣ�� 4�� �̻� ");
			frm.pwd.focus(); 	return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<h3>�α��� ��</h3>
	<form name="frmLogin" action="login" method="post" onsubmit="return chkVal(this);">
		<input type="hidden" name="url" value="<%=url %>" />
		<table cellpadding="5">
			<tr>
				<th><label for="uid">���̵�</label></th>
				<td><input type="text" name="uid" maxlength="20" value="test1"/></td>
			</tr>
			<tr>
				<th><label for="pwd">��й�ȣ</label></th>
				<td><input type="password" name="pwd" maxlength="20" value="1111" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="�α���" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="�ٽ� �Է�" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
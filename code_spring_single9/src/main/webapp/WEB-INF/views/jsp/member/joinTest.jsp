<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>

<body>
<b>회원정보</b><br><br>

<b>기본정보</b>

		<form action="">
			<table id=basic-info border="1">
				<tr>
					<td id="title">아이디</td>
					<td><input type="text" name="join_id" maxlength="20"> 
					<input type="button" value="중복확인"></td>
				</tr>
				<tr>
					<td id="title">비밀번호</td>
					<td><input type="password" name="join_password" maxlength="15">
					</td>
				</tr>
				<tr>
					<td id="title">비밀번호 확인</td>
					<td><input type="password" name="join_password" maxlength="15">
					</td>
				</tr>
				<tr>
					<td id="title">이름</td>
					<td><input type="text" name="join_name" maxlength="40"></td>
				</tr>
				<tr>
					<td id="title">성별</td>
					<td><input type="radio" name="join_gender" value="남" checked>남
						<input type="radio" name="join_gender" value="여" checked>여</td>
				</tr>
				<tr>
					<td id="title">이메일</td>
					<td><input type="text" name="email_1" maxlength="30">@
						<select name="email_2">
							<option>naver.com</option>
							<option>daum.net</option>
							<option>gmail.com</option>
							<option>nate.com</option>
					</select></td>
				</tr>
				<tr>
					<td id="title">휴대전화</td>
					<td><input type="text" name="phone" /></td>
				</tr>
				<tr>
					<td id="title">주소</td>
					<td><input type="text" size="50" name="address" /></td>
				</tr>
			</table><br><br>	

<b>추가정보</b>
<table id=basic-info border="1">
	<tr>
		<td id="title">생일</td>
		<td>
			<input type="text" name="join_birth_yy" maxlength="4" placeholder="년(4자)" size="6">년
			<input type="text" name="join_birth_mm" maxlength="2" placeholder="월" size="4">월
			<input type="text" name="join_birth_dd" maxlength="2" placeholder="일" size="4">일
		</td>
	</tr><br><br>	
	<tr>
		<td id="title">결혼기념일</td>
		<td>
			<input type="text" name="join_marry_yy" maxlength="4" placeholder="년(4자)" size="6">년
			<input type="text" name="join_birth_marry_mm" maxlength="2" placeholder="월" size="4">월
			<input type="text" name="join_birth_marry_dd" maxlength="2" placeholder="일" size="4">일
		</td>		
	</tr><br><br>
	<tr>
		<td id="title">배우자생일</td>
		<td>
			<input type="text" name="join_partner_yy" maxlength="4" placeholder="년(4자)" size="6">년	
			<input type="text" name="join_partner_mm" maxlength="2" placeholder="월" size="4">월
			<input type="text" name="join_partner_dd" maxlength="2" placeholder="일" size="4">일
		</td>
	</tr>
</table>
<br><br><b>전체 동의</b><br><br>

		
			<br> <input type="submit" value="가입" />  
				 <input type="button"value="취소">

		</form>
		
	<%@ include file="/WEB-INF/views/jsp/main/footer.jsp"%>
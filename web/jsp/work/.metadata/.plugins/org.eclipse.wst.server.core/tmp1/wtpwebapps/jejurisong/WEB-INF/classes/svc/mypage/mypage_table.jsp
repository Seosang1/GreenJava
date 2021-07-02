<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="db.JdbcUtil"%>
<%@ page import="vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>

</style>
<body>
<table>
<td>
<table style="border:1px solid;">
<tr>
	<h3 style="width:250px; height:90px;">마이페이지</h3>
</tr>
<tr>
	<td style="width:250px; height:60px;">예약내역</td>
</tr>
<tr>
	<td style="width:250px; height:60px;">나의 여행 일정</td>
</tr>
<tr>
	<td style="width:250px; height:60px;">회원정보수정</td>
</tr>
</table>
</td>
<td>
<table style="border:1px solid;">
	<tr>
		<h3 style="width:800px; height:60px;">예약내역</h3>
		<td style="width:256px; height:60px; text-align: center;">예약확정<br/></td>
		<td style="width:256px; height:60px; text-align: center;">여행완료<br/></td>
		<td style="width:256px; height:60px; text-align: center;">예약취소<br/></td>
	</tr>
	<tr>
		<td style="width:256px; height:60px; text-align: center;">0건</td>
		<td style="width:256px; height:60px; text-align: center;">0건</td>
		<td style="width:256px; height:60px; text-align: center;">0건</td>
	</tr>
</table>
<table style="border:1px solid;">
	<tr>
		<td style="width:150px; height:50px; text-align: center;">예약내역</td>
		<td style="width:150px; height:50px; text-align: center;">취소내역</td>
	</tr>
</table>
<table style="border:1px solid;">
	<tr>
		<th style="width:120px; height:50px;">예약일</th>
		<th style="width:390px; height:50px;">상품정보</th>
		<th style="width:130px; height:50px;">금액</th>
		<th style="width:130px; height:50px;">"예약상태"</th>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>
<table style="text-align: right;">
	<tr>
		<td><strong class="fc-orange">1</strong> /1</td>	
	</tr>
</td>
</table>
</body>
</html>
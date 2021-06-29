<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.*"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#searchDiv { width:800px; border: solid; }
	#orderDiv { width:800px; border: solid; }
	#hotelDiv { width:800px; border: solid; }
	
</style>
</head>
<body>
	<h2>상품 목록</h2>

	<!--  검색 layout 시작  -->
	<div id="searchDiv">
		<form name="frmSch" method="get">
			<table width="100%" cellpadding="5" cellspacing="5">
				<tr>
					<th>숙박지</th>
					<th>체크인</th>
					<th>체크아웃</th>
					<th>숙박유형</th>
					<th>숙박명</th>
					<th>숙박인원</th> 
					<th rowspan="2">
						<input type="button" value="검색"/>
					</th>
				</tr>
				<tr>
					<td>
						<select name="sl_area">
							<option value="">제주도 전체</option>
						</select>
					</td>
					<td>
						체크인 날
					</td>
					<td>
						체크아웃 날
					</td>
					<td>
						<select name="sl_type">
							<option value="">전체</option>
						</select>
					</td>
					<td>
						<input type="text" name="txt_name" />
					</td>
					<td>
						<input type="text" name="txt_cnt" />
					</td> 
				</tr>
			</table>
		</form>
	</div>
	<!--  // 검색 layout 종료  -->
	
	<!--  정렬조건 선택 시작 -->
	<div id="orderDiv" >
		<select name="sl_order">
			<option value="s">인기순</option>
			<option value="p">가격순</option> 
		</select>
	</div>
	<!-- // 정렬조건 선택 종료 -->
	
	<!--  숙소리스트 시작 -->
	<div id="hotelDiv">

	</div>
	<!-- // 숙소리스트 종료 -->
</body>
</html>

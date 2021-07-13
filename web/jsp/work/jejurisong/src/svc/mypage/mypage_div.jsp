<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="db.JdbcUtil"%>
<%@ page import="vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

.lnb{
	float:left;
	width:250px;
}
h3 {display:block;}



</style>
</head>
<body>
<div id="container">
	<div class="lnb">
		<h2>마이페이지</h2>
		<ul>
			<li>
				<a href="#" class="selected">예약내역</a>
			</li>
			<li>
				<a href="#">나의 여행 일정</a>
			</li>
			<li>
				<a href="#">회원 정보 수정</a>
			</li>
		</ul>
	</div>
<!-- 왼쪽 메뉴 끝=================================================== -->
<!--  중간역역 시작 -->
	<div class="contents">
		<div class="mypage reserv-list">
			<h3 class="title">예약내역</h3>
			<div class="reserv-summary">
				<dl>
					<dt>
						<strong>예약확정</strong>
					</dt>
					<dd>
						<strong>0</strong>
						"건 "
					</dd>
				</dl>
				<dl>
					<dt>
						<strong>여행완료</strong>
					</dt>
					<dd>
						<strong>0</strong>
						"건 "
					</dd>
				</dl>
				<dl>
					<dt>
						<strong>예약취소</strong>
						<small>(환불요청)</small>
					</dt>
					<dd>
						<strong>0</strong>
						"건 " 
					</dd>
				</dl>
			</div>
		</div>
	</div>
</div>


<dl class="tab-menu">
	<dt class="selected">
		<a href="#">예약내역</a>
	</dt>
	<dt style="left:150px;">
		<a href="#">취소내역</a>
	</dt>
	<dd style="display:block;">
		<div>
			<table class="data_table">
				<colgroup>
					<col style="width:120px;">
					<col style>
					<col style="width:130px;">
					<col style="width:130px;">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">예약일</th>
						<th scope="col">상품정보</th>
						<th scope="col">금액</th>
						<th scope="col">
							"예약상태"
						</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
			<div class="pagination align-right">
				<span>
					<strong class="fc-orange">1</strong>
					 / 1
				</span>
			</div>
		</div>
	</dd>
	
</dl>
<!-- 중간영역 끝================================================================== -->
<!--  사이드 바 시작 -->
<aside id="sidemenu" class="sidearea_close">
	<div class="side_wrap dumy_open" style="display:none;">
		<a href="#" class="gotop">
			<img src="img" alt="TOP">
		</a>
	</div>
</aside>
<script>
$(function(){
	$('#sidemenu .side_open').on('click', function(e){
		
		$('#sidemenu').removeClass('sidearea_close').addClass('sidearea_open');
		$('#sidemenu .dumy_close').hide();
		$('#sidemenu .dumy_open').show("slide", { direction: "right" }, 100);
		
		e.preventDefault();
	});
	
	$('#sidemenu .side_close').on('click', function(e){
		$('#sidemenu .dumy_open').hide("slide", { direction: "left" }, 100, function(){
			$('#sidemenu .dumy_close').show();
			$('#sidemenu').removeClass('sidearea_open').addClass('sidearea_close');
		});
		e.preventDefault();
	});	
	
	
});
</script>
<!-- 사이드 바====================================================================================== -->
</body>
</html>
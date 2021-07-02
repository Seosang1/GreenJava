<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ include file="../_inc/incAdminHead.jsp"%>
<%@ include file="../_inc/incAdminLeft.jsp"%>


<%
	request.setCharacterEncoding("utf-8");
	@SuppressWarnings("unchecked")
	//(어노테이션) 호환되지 않은 유형으로 작동하면 프로그램이 컴파일 되지 않기에 해당 경고를 보여줌 (ArrayList 제네릭 사용시 밑줄 가리는 방법)

	// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼ 
	ReserveInfo info = (ReserveInfo)request.getAttribute("info");
	Common common = new Common();

	// ▼▼▼ 검색관련 쿼리스트링 제작 ▼▼▼
	String args = "", schargs = "";
	
	String tmp = "";
	

  	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    Calendar c1 = Calendar.getInstance();
 	String now = dateFormat.format(c1.getTime()); 
 	Date dtNow = dateFormat.parse(now);
 	Date dtEdate = dateFormat.parse(info.getRv_edate());

 	String rv_sdate = info.getRv_sdate().substring(0, 10);
 	String rv_edate = info.getRv_edate().substring(0, 10);
 	
  	String rv_status = "예약확정";
  	if (info.getRv_state().equals("B")) rv_status = "예약취소";
 	if (dtNow.after(dtEdate)) rv_status += "(여행종료)";
%>
 
<script>
	// 삭제
	function onSubmit(code) {
		if (confirm("예약 정보를 취소하시겠습니까?")) {
			var arrCheck = []; 
			arrCheck[0] = code; 
			

	        var frm = document.createElement("form"); 
	        frm.setAttribute("method", "Post");  				//Post 방식
	        frm.setAttribute("action", "reserve_del.reservea"); //요청 보낼 주소

	        var hiddenField = document.createElement("input"); 
	        hiddenField.setAttribute("type", "hidden");
	        hiddenField.setAttribute("name", "arrCheck");
	        hiddenField.setAttribute("value", arrCheck); 
	        frm.appendChild(hiddenField); 
	        document.body.appendChild(frm); 
	        frm.submit();
		} 
		
		var frm = document.frm;   
		frm.submit();
	} 
</script>

<!-- article -->

<style>
.section-title {
    height: 35px;
    margin-top: 40px;
    background: url(/jejurisong/admin/common/images/bg_package_title.gif) no-repeat;
    padding-left: 10px;
    font-size: 17px;
    line-height: 1; 
}
    
article #content {
    position: relative;
    margin-top: -15px;
}
</style>
<article>
	<h3>숙박권 리스트 > 예약 상제정보 [<%=info.getRv_code()%>]</h3> 
				
	<!-- content -->
	<div id="content">
	
		<!-- *** Search Layout *** -->
		<form name="frmSearch" method="get" action="hotel_list.hotela">
			<input type="hidden" value="<%=info.getRv_code()%> name="hd_rv_code" />
			<h4 class="section-title">기본 예약정보</h4>
			<div class="box_search01">
				<ul> 
					<li>
						<span class="title01" style="margin-left: 30px;">예약일</span>  
						<span style="width: 180px;"><%=info.getRv_date() %></span>
						<span class="title01">예약번호</span>  
						<span style="width: 180px;"><%=info.getRv_code() %></span>
						<span class="title01">예약상태</span>  
						<span><%=rv_status %></span> 
					</li>
				</ul> 
			</div> 
		</form>
 
		<!-- *** list *** -->  
		<div class="tbl_wrap_list">
			<h4 class="section-title">예약 숙소정보</h4>
			<table class="tbl_list">  
				<thead>
					<tr>
						<th scope="col">호텔명</th>
						<th scope="col">방종류</th> 
						<th scope="col">투숙일자</th> 
						<th scope="col">투숙인원</th>
					</tr>
				</thead>
				<tbody> 
				<tr onmouseover="this.className='on'" onmouseout="this.className=''" onclick="location.href='#';">
					<td><%=info.getHotel_name() %></td>
					<td><%=common.getRoomType().get(info.getRoom_type()) %></td> 
					<td><%=rv_sdate %> ~ <%=rv_edate %></td>
					<td><%=info.getRv_cnt() %>명</td>
				</tr>  
				</tbody>
			</table>
		</div> 
		<!-- // *** list *** -->
 
		<!-- *** list *** --> 
		<h4 class="section-title">예약자 정보</h4>
		<div class="tbl_wrap_list">
			<table class="tbl_list">  
				<thead>
					<tr>
						<th scope="col">예약자아이디</th>
						<th scope="col">사용자성명</th>
						<th scope="col">이메일</th> 
						<th scope="col">연락처</th> 
						<th scope="col">수집동의</th>
					</tr>
				</thead>
				<tbody> 
				<tr onmouseover="this.className='on'" onmouseout="this.className=''" onclick="location.href='#';">
					<td><%=info.getMem_id() %></td>
					<td><%=info.getRv_name() %></td>
					<td><%=info.getRv_email() %></td>
					<td><%=info.getRv_phone() %></td>
					<td><%=common.getAgree().get(info.getRv_agree()) %></td> 
				</tr>
				<% if (!info.getRv_content().equals("")) { %>  
				<tr>
					<td style="background: #f6f6f6;">요청사항</td>
					<td colspan="4" style="text-align:left;"><%=info.getRv_content() %></td>
				</tr>
				<% } %>
				</tbody>
			</table>
		</div> 
		<!-- // *** list *** -->
 
		<!-- *** list *** -->
		<h4 class="section-title">결제상세내역</h4>
		<div class="tbl_wrap_list">
			<table class="tbl_list">  
				<thead>
					<tr>
						<th scope="col">기본상품가</th>
						<th scope="col">할인율</th>
						<th scope="col">결제금액</th> 
						<th scope="col">결제방법</th> 
						<th scope="col">상태</th>
					</tr>
				</thead>
				<tbody> 
				<tr onmouseover="this.className='on'" onmouseout="this.className=''" onclick="location.href='#';">
					<td><%=String.format("%,d", info.getRv_price()) %>원</td>
					<td><%=info.getRv_discount() %>%</td>
					<td><%=String.format("%,d", info.getRv_dis_price()) %>원</td>
					<td>카드결제</td>
					<td><%=rv_status %></td>
				</tr>  
				</tbody>
			</table>
		</div> 
		<!-- // *** list *** -->
		
		<!-- 버튼 -->
		<div class="btn_wrap01_detail mgt25">
		<%if (info.getRv_state().equals("a")) { %>
			<a href="#" onclick="onSubmit('<%=info.getRv_code()%>');" class="btn_big blue">예약취소</a>
		<% } %>
			<a href="reserve_list.reservea" class="btn_big">목록</a>
		</div>
		<!-- //버튼 -->

	</div> 
	
	<!-- //content -->

</article>
<!-- //article -->

<%@ include file="../_inc/incAdminFooter.jsp"%>
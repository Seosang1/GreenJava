<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.*"%>
<%@ include file="../_inc/_header.jsp"%>
<%
request.setCharacterEncoding("utf-8");

// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼ 
ArrayList<HotelInfo> list = (ArrayList<HotelInfo>) request.getAttribute("list");
PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
Common common = new Common();
HashMap<String, String> mapSchargs = (HashMap<String, String>) request.getAttribute("schargs");
String schargs = "";

// ▼▼▼ 검색관련 쿼리스트링 제작 ▼▼▼
String args = "?cpage=" + pageInfo.getCpage();
for (String key : mapSchargs.keySet()) {
	schargs += "&" + key + "=" + mapSchargs.get(key);
}
%>

<!-- 내용 -->
<div class="dummy">

	<!-- 조회 -->
	<div class="card">
		<div class="card-body">
			<form class="row g-3" id="frm" name="frm" method="get"
				action="hotel_list.hotel">
				<div class="col-md-2">
					<label for="sl_area" class="form-label">지역</label> 
					<select class="form-select" name="sl_area"
						aria-label="원하시는 지역을 선택해주세요">
						<option value="" selected>전체</option>
					<% for(String key : common.getArea().keySet()) { 
						String sl = "";
						if (key.equals(mapSchargs.get("area"))) sl = " selected = 'selected' ";
					%>
						<option value="<%=key%>" <%=sl %>><%=common.getArea().get(key) %></option>
					<% } %>
					</select>  
				</div>
				<div class="col-md-2">
					<label for="sl_type" class="form-label">유형</label> <select
						class="form-select" name="sl_type" aria-label="원하시는 유형을 선택해주세요">
						<option value="" selected>전체</option>
					<% for(String key : common.getHotelType().keySet()) {
						String sl = "";
						if (key.equals(mapSchargs.get("type"))) sl = " selected = 'selected' "; %>
						<option value="<%=key%>" <%=sl %>><%=common.getHotelType().get(key) %></option>
					<% } %>
					</select> 
				</div>
				<div class="col-md-2">
					<label for="txt_sdate" class="form-label">시작일</label> <input
						type="text" class="form-control" id="txt_sdate" name="txt_sdate" value="<%=common.nullToString(mapSchargs.get("sdate")) %>">
				</div>
				<div class="col-md-2">
					<label for="txt_edate" class="form-label">종료일</label> <input
						type="text" class="form-control" id="txt_edate" name="txt_edate" value="<%=common.nullToString(mapSchargs.get("edate")) %>">
				</div>
				<div class="col-md-2">
					<label for="txt_name" class="form-label">호텔명</label> 
					<input type="text" class="form-control" id="txt_name" name="txt_name" value="<%=common.nullToString(mapSchargs.get("name")) %>">
				</div>
				<div class="col-md-2" style="margin-top: 46px;">
					<button type="submit" class="btn btn-primary">조회</button>
				</div>
			</form>

		</div>
	</div>

	<!-- 리스트 -->
	<div class="album py-5 bg-light" style="margin-top: 20px;">
		<div class="container">

			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

				<%
				if (list != null && list.size() > 0) {
					// 숙박 리스트가 있다면 돌리기
					for (int i = 0; i < list.size(); i++) {
						HotelInfo hotelInfo = list.get(i);
						String hotel_addr = common.txtToShort(hotelInfo.getHotel_addr(), 10);
				%>
				<div class="col">			
					<a href="hotel_view.hotel?hotel_code=<%=hotelInfo.getHotel_code() + schargs %>" >
					<div class="card shadow-sm">
						<img src="/jejurisong/common/images/HotelImg/<%=hotelInfo.getHotel_img1() %>" width="100%" height="100%" />
						<div class="card-body">
							<p class="card-text"><%=hotelInfo.getHotel_name() %></p>
							<p class="card-text"><%=hotelInfo.getHotel_name() %></p>
							<p class="card-text"><%=common.getArea().get(hotelInfo.getHotel_area()) %></p>
					 		<p class="card-text"><%=String.format("%,d", hotelInfo.getRoom_dis_price()) %>원</p>
						</div>
					</div>
					</a>
				</div>

				<%
					}
				}
				%>

			</div>
		</div>
	</div>
</div>



<%@ include file="../_inc/_footer.jsp"%>
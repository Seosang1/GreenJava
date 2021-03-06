<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.*"%>
<%@ include file="../_inc/incHead.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
	Common common = new Common();
	
	// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼ 
	HotelInfo hotelInfo = (HotelInfo)request.getAttribute("hotelInfo");
	ArrayList<RoomInfo> roomList = (ArrayList<RoomInfo>) request.getAttribute("roomList");
	ArrayList<ReplyInfo> replyList = (ArrayList<ReplyInfo>) request.getAttribute("replyList");
	HashMap<String, String> mapSchargs = (HashMap<String, String>) request.getAttribute("schargs");
	String schargs = "";

	// ▼▼▼ 검색관련 쿼리스트링 제작 ▼▼▼ 
	for (String key : mapSchargs.keySet()) {
		schargs += "&" + key + "=" + mapSchargs.get(key);
	}
	// System.out.println("hotel_view.jsp schargs : "+ schargs);
	// &sdate=2021-06-09&name=해비치&hotel_code=A0003&type=RST&edate=2021-07-07
%>


<!-- content 영역 시작 -->
<div id="contents">

	<!-- *** Search Layout *** -->
	<div>
		<form id="frm" name="frm" method="get" action="hotel_view.hotel">
			<input type="hidden" name="hotel_code" value="<%=common.nullToString(mapSchargs.get("hotel_code")) %>" />
			<input type="hidden" name="type" value="<%=common.nullToString(mapSchargs.get("type")) %>" />
			<input type="hidden" name="name" value="<%=common.nullToString(mapSchargs.get("name")) %>" />
			<div class="box_search01">
				<table>
					<tr>
						<th>체크인</th>
						<td><input type="date" name="sdate" value="<%=common.nullToString(mapSchargs.get("sdate")) %>" /></td>
						<td><input type="date" name="edate" value="<%=common.nullToString(mapSchargs.get("edate")) %>" /></td> 
						<th>숙박인원</th>
						<td><input type="number" name="txt_cnt" value="<%=common.nullToString(mapSchargs.get("cnt")) %>"></td>
						<td><input type="button" value="조회" onclick="document.frm.submit()"></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	
	<!-- *** hotel Info Layout *** -->
	<div>
		
		<table width="750px;">
			<tr>
				<td>
					<img src ="/jejurisong/common/images/HotelImg/<%=hotelInfo.getHotel_img1() %>" width="300px;" />
				</td>
				<td>
					<%=hotelInfo.getHotel_name() %><br/>
					<%=common.getArea().get(hotelInfo.getHotel_area()) %> | <%=hotelInfo.getHotel_addr() %><br/>
					<%=hotelInfo.getHotel_score() %> 총 <%=hotelInfo.getHotel_review_cnt() %>건의 리뷰<br/>
					-----------------------<br />
					<%=hotelInfo.getHotel_detail() %>
				</td>
			</tr>
		</table>
	</div>


	<!-- *** Room list *** -->
	<div>
		<table width="750px;">
	<%
		if (roomList != null && roomList.size() > 0) {
			for (int i = 0; i < roomList.size(); i++) {
				RoomInfo info = roomList.get(i);
				
				String[] arrEq = info.getRoom_eq().split(",");
	%>
		<tr>
			<td width="180px;"><img src ="/jejurisong/common/images/RoomImg/<%=info.getRoom_img() %>" width="150px;" /></td>
			<td width="180px;">
				<strong><%=common.getRoomType().get(info.getRoom_type())%></strong> <br />
				<%for (int j = 0; j < arrEq.length; j++ ) { %>
					<%=common.getHoteEquip().get(arrEq[j].trim()) %> 
				<% } %>
			</td>
			<td width="*"><%=info.getRoom_svc()%></td>
			<td width="150px;">기본 <%=info.getRoom_min()%>인/최대 <%=info.getRoom_max()%>인</td>
			<td width="200px;"> 
				<%=String.format("%,d", info.getRoom_dis_price())%><br />
				1박당 객실요금 (세금포함) <br />
				 총 금액 : <%=String.format("%,d", (info.getRoom_dis_price() * 2))%>
			</td width="100px;">
			<td><a href="reserve_form.reserve?room_code=<%=info.getRoom_code() + schargs%>">예약하기</a></td>	
		</tr> 
	</div>

	<%
			}
		} else {%>
		<tr>
			<td colspan="7">해당되는 객실이 없습니다. 다른 날을 선택해주세요.</td>
		</tr>		
	<% } %>
		</table>


	</div>
	 
	 


	<!-- *** 후기 list *** -->
	<div>
		<table>
		
		<%
			if (replyList != null && replyList.size() > 0) { 
				for (int i = 0; i < replyList.size(); i++) {
					ReplyInfo replyInfo = replyList.get(i);
		%>
		<tr>
			<td>
				<img src ="/jejurisong/common/images/MemImg/<%=replyInfo.getMem_img() %>" width="150px;" /><br />
				<%=replyInfo.getMem_id() %>
			</td>
			<td>
				 <%=replyInfo.getRoom_type() %><br />
				 <%=replyInfo.getRoom_re_content() %>
			</td>
			<td>
				<%=replyInfo.getRoom_re_date() %><br />
				<%=replyInfo.getRoom_re_score() %>
			</td>
			<td>
				<span> <a href="hotel_del_proc.hotel?reply_code=<%=replyInfo.getRoom_re_idx()%>">x</a></span>
			</td>
		</tr>
	
		<%
				}
			}
		%>
		</table>

	</div>
	 
	<!-- content 영역 시작 -->

	<!-- 
<%@ include file="../_inc/incFooter.jsp"%>

 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.*"%>
<%@ include file="../_inc/incHead.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
	Common common = new Common();

	// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼ 
	RoomInfo roomInfo = (RoomInfo) request.getAttribute("roomInfo"); 
	HashMap<String, String> mapSchargs = (HashMap<String, String>) request.getAttribute("schargs");
	String schargs = "";

	// ▼▼▼ 검색관련 쿼리스트링 제작 ▼▼▼ 
	for (String key : mapSchargs.keySet()) {
		schargs += "&" + key + "=" + mapSchargs.get(key);
	}
	// System.out.println("hotel_view.jsp schargs : "+ schargs);
	
	String hotel_code 	= roomInfo.getHotel_code();
	String room_code 	= roomInfo.getRoom_code();
	String hotel_name 	= roomInfo.getHotel_name();
	String room_type 	= roomInfo.getRoom_type();
	String mem_id 		= (String)request.getAttribute("mem_id");
	String rv_sdate		= mapSchargs.get("sdate"); // 투숙시작일
	String rv_edate		= mapSchargs.get("edate"); // 투숙종료일
	int rv_cnt			= Integer.parseInt(mapSchargs.get("cnt")); // 투숙인원
	int rv_price		= roomInfo.getRoom_price(); // 금액
	int rv_discount		= roomInfo.getRoom_discount(); // 할인율
	
	//  할인금액 x 박 + (2인 이상일 경우 인당 10,000원 추가)
	int dateDiff 		= 2;
	int cntDiff			= (rv_cnt - roomInfo.getRoom_min()) * 10000;
	int rv_dis_price	= (roomInfo.getRoom_dis_price() * dateDiff + cntDiff) ;// 결제금액

	
%>


<!-- article -->

<article>

	<style>
		.tb { width:700px; border-style:solid; }
		.h3_Header {
			margin-top: 20px;
		    margin-bottom: 6px;
		    font-size: 18px;
		    font-weight: 600;
		}
	</style>

	<!-- content -->
	<div id="contents">
		<h3>예약하기!</h3>
		<form name="frm" method="post" action="reserve_proc.reserve">
			<input type="hidden" name="hd_hotel_code" value="<%=hotel_code %>" />
			<input type="hidden" name="hd_room_code" value="<%=room_code %>" />
			<input type="hidden" name="hd_hotel_name" value="<%=hotel_name %>" />
			<input type="hidden" name="hd_room_type" value="<%=room_type %>" />
			<input type="hidden" name="hd_mem_id" value="<%=mem_id %>" />
			<input type="hidden" name="hd_rv_sdate" value="<%=rv_sdate %>" />
			<input type="hidden" name="hd_rv_edate" value="<%=rv_edate %>" />
			<input type="hidden" name="hd_rv_cnt" value="<%=rv_cnt %>" />
			<input type="hidden" name="hd_rv_price" value="<%=rv_price %>" />
			<input type="hidden" name="hd_rv_discount" value="<%=rv_discount %>" />
			<input type="hidden" name="hd_rv_dis_price" value="<%=rv_dis_price %>" /> 

			<!-- *** 상품 상세 정보 *** -->
			<h3 class="h3_Header">상품 상세 정보</h3>
			<table class="tb" border="1" cellpadding="0" callspacing="0">
				<tr>
					<th>숙소정보</th>
					<td><%=roomInfo.getHotel_name()%></td>
				</tr>
				<tr>
					<th>투숙일</th>
					<td><%=rv_sdate%>~<%=rv_edate%>(1박)</td>
				</tr>
				<tr>
					<th>투숙인원</th>
					<td><%=rv_cnt%>인</td>
				</tr>
				<tr>
					<th>결제금액</th>
					<td>
						<%=rv_dis_price%>원 <br />
						기본 상품가: <%=roomInfo.getRoom_price()%> , 할인율 : <%=roomInfo.getRoom_discount()%>
						<br /> 
						<% if (cntDiff > 0 ) { %>
							추가요금 : <%=rv_cnt %>인 (<%=cntDiff %> 원)
						<% } %>
					</td>
				</tr>
			</table>
			
			
			<!-- *** 예약자 정보 입력 *** -->
			<h3 class="h3_Header">예약자 정보 입력</h3>
			<table class="tb" border="1" cellpadding="0" callspacing="0">
				<tr>
					<th width="100px">성명</th>
					<td><input type="text" name="rv_name" style="width:100px;" value="홍길동" /></td>
					<th>이메일</th>
					<td><input type="text" name="rv_email" style="width:100px;" value="gd@naver.com" /></td>
					<th>연락처</th>
					<td>
						<input type="text" name="rv_p1" style="width:70px;" value="010"/>-
						<input type="text" name="rv_p2" style="width:70px;" value="1111"/>-
						<input type="text" name="rv_p3" style="width:70px;" value="2222"/>
					</td>
				</tr>
				<tr>
					<th>요청사항</th>
					<td colspan="5"><textarea name="rv_content" style="width: 590px;height: 50px;">없음</textarea></td>
				</tr>
			</table>
			

			<!-- *** 결제정보 입력 *** -->
			<h3 class="h3_Header">결제정보 입력</h3>
			<table class="tb" border="1" cellpadding="0" callspacing="0">
				<tr>
					<th width="100px">카드정보</th>
					<td colspan="3">
						<input type="text" name="rv_c1" style="width:50px;" /> <input type="text" name="rv_c2" style="width:50px;" />
						<input type="text" name="rv_c3" style="width:50px;" /> <input type="text" name="rv_c4" style="width:50px;" />
					</td>
				</tr>
				<tr>
					<th>종료기간</th>
					<td>
						<input type="number" name="txt_year" style="width:50px;" />
						<input type="number" name="txt_month" style="width:50px;" />
					</td>
					<th>할부개월</th>
					<td>
						<select name="sl_division" >
							<option value="">일시불</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="txt_pwd" style="width:50px;" />**
					</td>
					<th>SVC</th>
					<td>
						<input type="text" name="txt_svc" style="width:50px;" />
					</td>
				</tr>
				<tr> 
					<td colspan="4">
						동의동의
					</td>
				</tr>
			</table> 
			
			<!-- 버튼 -->
			<div>  
				<a href="#" onclick="javascript:frm.submit();" >결제하기</a>
			</div>
			<!-- //버튼 -->

		</form>


	</div>

	<!-- //content -->

</article>
<!-- //article -->

<!-- content 영역 시작 -->

<!-- 
<%@ include file="../_inc/incFooter.jsp"%>

 -->
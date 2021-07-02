<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ include file="../_inc/incAdminHead.jsp"%>
<%@ include file="../_inc/incAdminLeft.jsp"%>


<%
	request.setCharacterEncoding("utf-8");
	@SuppressWarnings("unchecked")
	//(어노테이션) 호환되지 않은 유형으로 작동하면 프로그램이 컴파일 되지 않기에 해당 경고를 보여줌 (ArrayList 제네릭 사용시 밑줄 가리는 방법)

	// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼ 
	HotelInfo info = (HotelInfo) request.getAttribute("info");
	ArrayList<RoomInfo> roomList = (ArrayList<RoomInfo>)request.getAttribute("roomList"); 
	ArrayList<ReplyInfo> replyList = (ArrayList<ReplyInfo>)request.getAttribute("replyList"); 
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	Common common = new Common();

	// ▼▼▼ 검색관련 쿼리스트링 제작 ▼▼▼
	String args = "", schargs = "";
	
	String tmp = "";
%>

<style>
.radio_my {
    display: inline-block; 
    vertical-align: middle;
    cursor: pointer;
    padding-left: 10px;
}
.radio_my input {
	margin-top: -5px;
}
</style>

<script>
	function onSubmit() {
		var frm = document.frm; 
		
		if (frm.sl_area.value == "") {
			alert("지역을 선택해주세요");
			return false;
		}
		
		if (frm.sl_type.value == "") {
			alert("숙박유형을 선택해주세요");
			return false;
		}
		
		if (frm.txt_name.value == "") {
			alert("숙박명을 입력해주세요");
			return false;
		}
		
		if (frm.txt_zip.value == "") {
			alert("우편번호를 입력해주세요");
			return false;
		}
		
		if (frm.txt_addr.value == "") {
			alert("주소를 입력해주세요");
			return false;
		}
		
		if (frm.txt_tel.value == "") {
			alert("전화번호를 입력해주세요");
			return false;
		}
		
		if (frm.txt_stime.value == "") {
			alert("체크인 시간을 입력해주세요");
			return false;
		}
		
		if (frm.txt_etime.value == "") {
			alert("체크아웃 시간을 입력해주세요");
			return false;
		}
		
		if (frm.txt_detail.value == "") {
			alert("상세내용을 입력해주세요");
			return false;
		}
		
		if(frm.img_1.value != "" && !isFileExt(frm.img_1.value)) {
			alert("'이미지1'의 파일은 jpg, gif, png, jpeg 파일만 선택 가능합니다. 다시 선택해주세요.");	return false;
		}
		
		if(frm.img_2.value != "" && !isFileExt(frm.img_2.value)) {
			alert("'이미지2'의 파일은 jpg, gif, png, jpeg 파일만 선택 가능합니다. 다시 선택해주세요.");	return false;
		}
		
		if(frm.img_3.value != "" && !isFileExt(frm.img_3.value)) {
			alert("'이미지3'의 파일은 jpg, gif, png, jpeg 파일만 선택 가능합니다. 다시 선택해주세요.");	return false;
		}
		
		frm.submit();
	}
	
	// 숫자만
	function onlyNum(obj) {
		if (isNaN(obj.value) == true)  {
			obj.value = "";
		}
	}

	 
	// 파일확장자 확인(이미지파일 확인여부)
	var arrImg = ["jpg", "gif", "png", "jpeg"];
	function isFileExt(str) { 
		var arrTmp = str.split("\\");
		fileNameTmp =  arrTmp[arrTmp.length - 1]; 
		var ext = str.substring(str.lastIndexOf(".") + 1);
		for (var i = 0; i < arrImg.length; i++ ) {
			if (ext == arrImg[i]) return true;
		}
		return false;
	}
</script>
<!-- article -->
<article>
	<h3>숙박권 리스트 > 숙박 등록 폼</h3>
	<!-- content -->
	<div id="content">

		
		<form name="frm" action="hotel_up_proc.hotela" method="post" enctype="multipart/form-data">
			<input type="hidden" name="hd_code" value="<%=info.getHotel_code()%>" />
			<!-- table_view -->
			<div class="tbl_wrap_view">
				<table class="tbl_view01">
					<tr>
						<th scope="row" style="width:80px">지역</th>
						<td>
							<select name="sl_area">
								<option value="">선택</option>
							<% for(String key : common.getArea().keySet()) { 
								String sl = "";
								if (key.equals(info.getHotel_area())) sl = " selected = 'selected' "; %>
								<option value="<%=key%>" <%=sl %>><%=common.getArea().get(key) %></option>
							<% } %>
							</select> 
						</td>
						<th scope="row" style="width:80px">숙박유형</th>
						<td>
							<select name="sl_type">
								<option value="">선택</option>
							<% for(String key : common.getHotelType().keySet()) { 
								String sl = "";
								if (key.equals(info.getHotel_type())) sl = " selected = 'selected' "; %>
								<option value="<%=key%>" <%=sl %>><%=common.getHotelType().get(key) %></option>
							<% } %>
							</select> 
						</td>
						<th scope="row" style="width:80px">숙박명</th>
						<td>
							<span><input type="text" name="txt_name" value="<%=info.getHotel_name()%>"></span>
						</td>
					</tr> 
					<tr> 
						<th scope="row">우편번호</th>
						<td>
							<span><input type="text" name="txt_zip" onkeyup="onlyNum(this);" value="<%=info.getHotel_zip()%>"></span>
						</td>
						<th scope="row">주소</th>
						<td colspan="3">
							<span><input type="text" name="txt_addr" style="width: 460px" value="<%=info.getHotel_addr()%>"></span>
						</td>
					</tr>
					<tr> 
						<th scope="row">전화번호</th>
						<td>
							<span><input type="text" name="txt_tel" value="<%=info.getHotel_tel()%>"></span>
						</td>
						<th scope="row">체크인</th>
						<td>
							<span><input type="text" name="txt_stime" value="<%=info.getHotel_stime()%>"></span>
						</td>
						<th scope="row">체크아웃</th>
						<td>
							<span><input type="text" name="txt_etime" value="<%=info.getHotel_etime()%>"></span>
						</td>
					</tr>
					<tr> 
						<th scope="row">상세내용</th>
						<td colspan="5">
							<span><textarea name="txt_detail" style="width:770px; height:60px;"><%=info.getHotel_detail()%></textarea></span>
						</td>
					</tr>
					<tr> 
						<th scope="row">사진등록1</th>
						<td colspan="5">
							<span><input type="file" name="img_1" style="width:770px;" /></span>
							<div class="photo">
								<img src="/jejurisong/common/images/HotelImg/<%= info.getHotel_img1() %>"  width="80px;" />
								<%= info.getHotel_img1() %>
							</div>
						</td>
					</tr>
					<tr> 
						<th scope="row">사진등록2</th>
						<td colspan="5"><span><input type="file" name="img_2" style="width:770px;" /></span>
						<% if(!common.isEmpty(info.getHotel_img2())) { %>
							<div class="photo">
								<img src="/jejurisong/common/images/HotelImg/<%=info.getHotel_img2() %>"  width="80px;" />
								<%= info.getHotel_img2() %>
							</div>
						<% } %>
						</td>
					</tr>
					<tr> 
						<th scope="row">사진등록3</th>
						<td colspan="5"><span><input type="file" name="img_3" style="width:770px;" /></span>
						<% if(!common.isEmpty(info.getHotel_img2())) { %>
							<div class="photo">
								<img src="/jejurisong/common/images/HotelImg/<%= info.getHotel_img3() %>"  width="80px;" />
								<%= info.getHotel_img3() %>
							</div>
						<% } %>
						</td>
					</tr>
					<tr>
						<th scope="row" style="width:80px">주차여부</th>
						<td>
					    <% for(String key : common.getHotelParkingYn().keySet()) { 
					    	String label = common.getHotelParkingYn().get(key);
					    	String chk = (key.equals(info.getHotel_park_yn())) ? "checked = 'checked'" : "";
					    %> 
							<div class="radio_my"> 
							    <input type="radio" id="sl_park_<%=key %>" name="rdo_park_yn" value="<%=key%>" <%=chk %>/>
							    <label for="radio1"><%=label %></label>
						  	</div>
						<% } %>
					   
						</td>
						<th scope="row" style="width:80px">운영여부</th>
						<td>
						<% for(String key : common.getOpenYn().keySet()) {
					    	String label = common.getOpenYn().get(key);
					    	String chk = (key.equals(info.getHotel_open_yn())) ? "checked = 'checked'" : "";
					    %> 
							<div class="radio_my"> 
							    <input type="radio" id="sl_open_<%=key %>" name="rdo_open_yn" value="<%=key%>" <%=chk %>/>
							    <label for="radio1"><%=label %></label>
						  	</div>
						<% } %> 
						</td> 
						<th scope="row" style="width:80px">등록정보</th>
						<td>
						등록자 : <%= info.getHotel_reg_id()%> <br />
						등록일자 : <%=info.getHotel_reg_date() %>
						</td> 
					</tr> 
					<% if(info.getHotel_del_yn().equals("y")) { %>
					<tr>
						<th scope="row" style="width:80px">삭제여부</th>
						<td><%=common.getDelYn().get(info.getHotel_del_yn()) %></td>
						<th scope="row" style="width:80px">삭제상태</th>
						<td colspan="3"> 
						<% if(info.getHotel_del_yn().equals("y")) { %>
						삭제처리자 : <%= info.getHotel_del_id()%> / 
						삭제처리일자 : <%=info.getHotel_del_date() %>
						<% } else { %> 미삭제 데이터 <% } %>
						</td> 
					</tr> 
					<% } %>
				</table>
			</div>
			<!-- //table_view -->
			
			
			<!-- *** room list *** -->
			<h3 style="margin-top: 20px;"> * 방 리스트</h3>
			<div class="tbl_wrap_list">
				<table class="tbl_list">  
					<thead>
						<tr>
							<th scope="col">방번호</th> 
							<th scope="col">방종류</th> 
							<th scope="col">방호수</th> 
							<th scope="col">인원수</th>
							<th scope="col">금액</th>
							<th scope="col">운영여부</th> 
							<th scope="col">삭제여부</th>
						</tr>
					</thead>
					<tbody>
				<%
				
				if (roomList != null && roomList.size() > 0) {
					int ridx = roomList.size();
					for (int i = 0 ; i < roomList.size() ; i++) {
				      	RoomInfo rInfo = roomList.get(i); 
				%>
					<tr onmouseover="this.className='on'" onmouseout="this.className=''">
						<td><%=ridx-- %></td> 
						<td><%=common.getRoomType().get(rInfo.getRoom_type()) %></td> 
						<td><strong><a href="room_view.rooma?room_code=<%=rInfo.getRoom_code() %>"><%=common.getRoomType().get(rInfo.getRoom_type()) %></a></strong></td> 
						<td><%=rInfo.getRoom_min() %>/<%=rInfo.getRoom_max() %></td> 
						<td><%=rInfo.getRoom_dis_price() %></td>
						<td><%=common.getOpenYn().get(rInfo.getRoom_open_yn()) %></td>
						<td><%=common.getDelYn().get(rInfo.getRoom_del_yn()) %></td>
					</tr> 
		            <%
					}
				} else {
					%>
						<tr>
			                <td colspan="8" style="height:150px">
			                    <div class="nodata"><p>조회 하신 데이터가 없습니다.</p></div>
			            	</td>
			            </tr>
						<%}
						%>
					</tbody>
				</table>
			</div>  
			
			<!-- table_view(Reply List) --> 
			<h3 style="margin-top: 20px;"> * 후기 리스트</h3>
			<!-- *** list *** -->
			<div class="tbl_wrap_list">
				<table class="tbl_list">  
					<thead>
						<tr> 
							<th scope="col">방번호</th> 
							<th scope="col">호텔명</th>
							<th scope="col">방종류</th> 
							<th scope="col">작성자</th> 
							<th scope="col">평가</th>
							<th scope="col">평점</th>
							<th scope="col">등록날짜</th> 
							<th scope="col">삭제여부</th>
						</tr>
					</thead>
					<tbody>
				<%
				
				if (replyList != null && replyList.size() > 0) {
					int replyIdx = replyList.size();
					for (int i = 0 ; i < replyList.size() ; i++) {
						ReplyInfo replyInfo = replyList.get(i);
				%>
					<tr onmouseover="this.className='on'" onmouseout="this.className=''" >
						<td><%=replyIdx-- %></td> 
						<td><%=replyInfo.getHotel_name() %></td>
						<td><%=common.getRoomType().get(replyInfo.getRoom_type()) %></td> 
						<td><%=replyInfo.getMem_id() %></td>
						<td><%=replyInfo.getRoom_re_content() %></td>
						<td><%=replyInfo.getRoom_re_score() %></td>
						<td><%=replyInfo.getRoom_re_date() %></td>
						<td><%=common.getDelYn().get(replyInfo.getRoom_re_del_yn()) %></td>
					</tr> 
		            <%
					}
				} else {
					%>
						<tr>
			                <td colspan="8" style="height:150px">
			                    <div class="nodata"><p>조회 하신 데이터가 없습니다.</p></div>
			            	</td>
			            </tr>
						<%}
						%>
					</tbody>
				</table>
			</div> 
			<!-- //table_view(Reply List) -->
			
			
			<!-- 버튼 -->
			<div class="btn_wrap01_detail mgt25">
				<a href="#" onclick="onSubmit();" class="btn_big blue">수정</a>
				<a href="hotel_list.hotela" class="btn_big">목록</a>
			</div>
			<!-- //버튼 -->
		</form>
	</div>
	<!-- //content -->

</article>
<!-- //article -->

<%@ include file="../_inc/incAdminFooter.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ include file="../_inc/incAdminHead.jsp"%>
<%@ include file="../_inc/incAdminLeft.jsp"%>


<%
	request.setCharacterEncoding("utf-8");
	@SuppressWarnings("unchecked")
	//(어노테이션) 호환되지 않은 유형으로 작동하면 프로그램이 컴파일 되지 않기에 해당 경고를 보여줌 (ArrayList 제네릭 사용시 밑줄 가리는 방법)

	// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼ 
	// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼ 
	RoomInfo info = (RoomInfo) request.getAttribute("info");
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

.chkLabel {
	width: 90px;
    display: inline-block;
}

.txtNum {
	width: 60px;
}
</style>

<script>
	function onSubmit() {
		var frm = document.frm; 
		
		if (frm.txt_hotel_name.value == "" || frm.hd_hotel_code.value == "") {
			alert("방을 추가할 호텔 선택해주세요");
			return false;
		}
		
		if (frm.sl_type.value == "") {
			alert("방 종류를 선택해주세요");
			return false;
		}
		
		if (frm.txt_svc.value == "") {
			alert("추가 제공 서비스 내용을 입력해주세요");
			return false;
		}
		
		if (frm.txt_min.value == "") {
			alert("최소인원을 입력해주세요");
			return false;
		}
		
		if (frm.txt_max.value == "") {
			alert("최대인원을 입력해주세요");
			return false;
		}
		
		if (frm.txt_price.value == "") {
			alert("금액을 입력해주세요");
			return false;
		}
		
		if (frm.txt_discount.value == "") {
			alert("할인율을 입력해주세요");
			return false;
		}
		 
		
		if (frm.txt_number.value == "" ) {
			alert("생성할 방개수를 입력해주세요");
			return false;
		}
		
		if (frm.img_1.value != "" && !isFileExt(frm.img_1.value)) {
			alert("'이미지1'의 파일은 jpg, gif, png, jpeg 파일만 선택 가능합니다. 다시 선택해주세요.");	return false;
		}

		// 객실구성 체크박스 루프
		var chk_eq = document.getElementsByName("chk_eq");
		var arrCheck = [];
		var n = 0;
		for (var i = 0; i < chk_eq.length; i++ ) {
			if (chk_eq[i].checked == true) { 
				arrCheck[n] = chk_eq[i].value;
				n++;
			} 
		} 
		 
		if (arrCheck.length > 0) {
			frm.hd_eq.value = arrCheck;
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
	 
	
	// 호텔검색
	function findHotel() {
		var options = 'top=10, left=10, width=700, height=600, status=no, menubar=no, toolbar=no, resizable=no';
	    window.open("hotel_list_pop.hotela", "숙박업소 검색", options);
	}
	
	// 금액 , 할인금액 ==> 계산 함수
	function onCalcPrice() {
	}
</script>
<!-- article -->
<article>
	<h3>숙박권 리스트 > 방 등록 폼</h3>
	<!-- content -->
	<div id="content"> 
		<!-- table_view -->
		<form name="frm" action="room_up_proc.rooma" method="post" enctype="multipart/form-data">
			<input type="hidden" name="room_code" value="<%=info.getRoom_code()%>" />
			<div class="tbl_wrap_view">
				<table class="tbl_view01">
					<tr>
						<th scope="row" style="width:80px">호텔</th>
						<td colspan="2">
							<span>
								<input type="hidden" name="hd_hotel_code" value="<%=info.getHotel_code()%>" >
								<input type="text" name="txt_hotel_name" value="<%=info.getHotel_name()%>" >
								<input type="button" onclick="findHotel()" value="호텔검색"  /> 
							</span>
						</td>
						<th scope="row" >방종류</th>
						<td colspan="2">
							<select name="sl_type" style="width:200px">
								<option value="">선택</option>
							<% for(String key : common.getRoomType().keySet()) { 
								String sl = "";
								if (key.equals(info.getRoom_type())) sl = " selected = 'selected' "; %>
								<option value="<%=key%>" <%=sl %>><%=common.getRoomType().get(key) %></option>
							<% } %>
							</select> 
						</td> 
					</tr> 
					<tr>
						<th scope="row">객실구성</th>  
						<td colspan="5">
							<input type="hidden" name="hd_eq" value="" />
							<% int n = 0;
							for(String key : common.getHoteEquip().keySet()) { 
								String chk = "";
								//if (key.equals(info.getRoom_eq())) chk = " checked='checked' ";
								if (info.getRoom_eq().indexOf(key) != -1) chk = " checked='checked' ";
							%>
							<span><input type="checkbox" name="chk_eq" id="eq<%=key%>" value="<%=key%>" <%=chk %>/></span>
							<label class="chkLabel"><%=common.getHoteEquip().get(key) %></label>
							<%if (n % 7 == 6) { %> <br /> <% }
							n++;
							} %>
						</td> 
					</tr> 
					<tr>
						<th scope="row">추가제공<br />서비스</th>  
						<td colspan="5">
							<span><textarea name="txt_svc" style="width:770px; height:60px;"><%=info.getRoom_svc() %></textarea></span>
						</td> 
					</tr> 
					<tr> 
						<th scope="row">기본인원</th>
						<td>
							<span><input type="text" name="txt_min" onkeyup="onlyNum(this);" value="<%=info.getRoom_min() %>" class="txtNum"></span>
						</td>
						<th scope="row" style="width:80px;">최대인원</th>
						<td>
							<span><input type="text" name="txt_max" onkeyup="onlyNum(this);" value="<%=info.getRoom_max() %>" class="txtNum"></span>
						</td>
						<th scope="row">방개수</th>
						<td>
							<span><input type="text" name="txt_number" onkeyup="onlyNum(this);" value="<%=info.getRoom_cnt() %>" class="txtNum"></span>
						</td>
					</tr>
					<tr> 
						<th scope="row">금액</th>
						<td>
							<span><input type="text" name="txt_price" onkeyup="onlyNum(this); onCalcPrice();" value="<%=info.getRoom_price() %>" class="txtNum"></span>
						</td>
						<th scope="row">할인율</th>
						<td>
							<span><input type="text" name="txt_discount" onkeyup="onlyNum(this); onCalcPrice();" value="<%=info.getRoom_discount() %>" class="txtNum"> %</span>
						</td>
						<th scope="row">할인금액</th>
						<td> 
							<span></span><input type="text" name="txt_dis_price" value="<%=info.getRoom_dis_price() %>" style="width:60px;"></span>
						</td>
					</tr>
					<tr> 
						<th scope="row">사진등록1</th>
						<td colspan="5">
							<span><input type="file" name="img_1" style="width:770px;" /></span>
							<div class="photo">
								<img src="/jejurisong/common/images/RoomImg/<%= info.getRoom_img() %>"  width="80px;" />
								<%= info.getRoom_img() %>
							</div>
						</td>
					</tr> 
					<tr>
						<th scope="row" style="width:80px">운영여부</th>
						<td colspan="3"> 
						<% for(String key : common.getOpenYn().keySet()) {
					    	String label = common.getOpenYn().get(key);
					    	String chk = (key.equals(info.getRoom_open_yn())) ? "checked = 'checked'" : "";
					    %> 
							<div class="radio_my"> 
							    <input type="radio" id="sl_open_<%=key %>" name="rdo_open_yn" value="<%=key%>" <%=chk %>/>
							    <label for="radio1"><%=label %></label>
						  	</div>
						<% } %> 
						</td> 
						<th scope="row" style="width:80px">등록정보</th>
						<td>
						등록자 : <%= info.getRoom_reg_id()%> <br />
						등록일자 : <%=info.getRoom_reg_date() %>
						</td> 
					</tr> 
					<% if(info.getRoom_del_yn().equals("y")) { %>
					<tr>
						<th scope="row" style="width:80px">삭제여부</th>
						<td><%=common.getDelYn().get(info.getRoom_del_yn()) %></td>
						<th scope="row" style="width:80px">삭제상태</th>
						<td colspan="3"> 
							<% if(info.getRoom_del_yn().equals("y")) { %>
							삭제처리자 : <%= info.getRoom_del_id()%> / 
							삭제처리일자 : <%=info.getRoom_del_date() %>
							<% } else { %> 미삭제 데이터 <% } %>
						</td> 
					</tr>
					<% } %>
				</table>
			</div>
			<!-- //table_view -->
			
			<!-- 버튼 -->
			<div class="btn_wrap01_detail mgt25">
				<a href="#" onclick="onSubmit();" class="btn_big blue">수정</a>
				<a href="room_list.rooma" class="btn_big">목록</a>
			</div>
			<!-- //버튼 -->
		</form>
	</div>
	<!-- //content -->

</article>
<!-- //article -->

<%@ include file="../_inc/incAdminFooter.jsp"%>
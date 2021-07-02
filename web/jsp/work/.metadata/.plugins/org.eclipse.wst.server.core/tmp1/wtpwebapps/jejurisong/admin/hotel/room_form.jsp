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
	ArrayList<RoomInfo> list = (ArrayList<RoomInfo>)request.getAttribute("list");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
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
	width: 70px;
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
			alert("생성할 방호수를 입력해주세요");
			return false;
		}
		
		if (frm.img_1.value == "") {
			alert("사진을 선택해주세요");
			return false;
		} else if(!isFileExt(frm.img_1.value)) {
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
		<form name="frm" action="room_proc.rooma" method="post" enctype="multipart/form-data">
			<div class="tbl_wrap_view">
				<table class="tbl_view01">
					<tr>
						<th scope="row" style="width:80px">호텔</th>
						<td colspan="2">
							<span>
								<input type="hidden" name="hd_hotel_code"  >
								<input type="text" name="txt_hotel_name"  >
								<input type="button" onclick="findHotel()" value="호텔검색"  /> 
							</span>
						</td>
						<th scope="row" >방종류</th>
						<td colspan="2">
							<select name="sl_type" style="width:200px">
								<option value="">선택</option>
							<% for(String key : common.getRoomType().keySet()) { %>
								<option value="<%=key%>"><%=common.getRoomType().get(key) %></option>
							<% } %>
							</select> 
						</td> 
					</tr> 
					<tr>
						<th scope="row">객실구성</th>  
						<td colspan="5">
							<input type="hidden" name="hd_eq" value="" />
							<% int n = 0;
							for(String key : common.getHoteEquip().keySet()) { %>
							<span><input type="checkbox" name="chk_eq" id="eq<%=key%>" value="<%=key%>"/></span>
							<label class="chkLabel"><%=common.getHoteEquip().get(key) %></label>
							<%if (n % 8 == 7) { %> <br /> <% }
							n++;
							} %>
						</td> 
					</tr> 
					<tr>
						<th scope="row">추가제공<br />서비스</th>  
						<td colspan="5">
							<span><textarea name="txt_svc" style="width:770px; height:60px;">이 방은 이러합니다.</textarea></span>
						</td> 
					</tr> 
					<tr> 
						<th scope="row">기본인원</th>
						<td>
							<span><input type="text" name="txt_min" onkeyup="onlyNum(this);" value="2" class="txtNum"></span>
						</td>
						<th scope="row" style="width:80px;">최대인원</th>
						<td>
							<span><input type="text" name="txt_max" onkeyup="onlyNum(this);" value="4" class="txtNum"></span>
						</td>
						<th scope="row">방개수</th>
						<td>
							<span><input type="text" name="txt_number" onkeyup="onlyNum(this);" value="1" class="txtNum"></span>
						</td>
					</tr>
					<tr> 
						<th scope="row">금액</th>
						<td>
							<span><input type="text" name="txt_price" onkeyup="onlyNum(this); onCalcPrice();" value="1000" class="txtNum"></span>
						</td>
						<th scope="row">할인율</th>
						<td>
							<span><input type="text" name="txt_discount" onkeyup="onlyNum(this); onCalcPrice();" value="10" class="txtNum"> %</span>
						</td>
						<th scope="row">할인금액</th>
						<td> 
							<span></span><input type="text" name="txt_dis_price" value="900" style="width:60px;"></span>
						</td>
					</tr>
					<tr> 
						<th scope="row">사진등록1</th>
						<td colspan="5"><span><input type="file" name="img_1" style="width:770px;" /></span></td>
					</tr> 
					<tr>
						<th scope="row" style="width:80px">운영여부</th>
						<td colspan="5">
						<% for(String key : common.getOpenYn().keySet()) {
					    	String label = common.getOpenYn().get(key);
					    	String chk = (key.equals("n")) ? "checked = 'checked'" : "";
					    %> 
							<div class="radio_my"> 
							    <input type="radio" id="sl_open_<%=key %>" name="rdo_open_yn" value="<%=key%>" <%=chk %>/>
							    <label for="radio1"><%=label %></label>
						  	</div>
						<% } %> 
						</td> 
					</tr> 
				</table>
			</div>
			<!-- //table_view -->
			
			<!-- 버튼 -->
			<div class="btn_wrap01_detail mgt25">
				<a href="#" onclick="onSubmit();" class="btn_big blue">등록</a>
				<a href="room_list.rooma" class="btn_big">목록</a>
			</div>
			<!-- //버튼 -->
		</form>
	</div>
	<!-- //content -->

</article>
<!-- //article -->

<%@ include file="../_inc/incAdminFooter.jsp"%>
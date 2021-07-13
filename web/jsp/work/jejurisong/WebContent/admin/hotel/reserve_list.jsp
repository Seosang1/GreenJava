<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ include file="../_inc/incAdminHead.jsp" %>
<%@ include file="../_inc/incAdminLeft.jsp" %>


<%
request.setCharacterEncoding("utf-8");
@SuppressWarnings("unchecked")

// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼  
ArrayList<ReserveInfo> list = (ArrayList<ReserveInfo>)request.getAttribute("list");
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");  
Common common = new Common(); 
HashMap<String, String> mapSchargs = (HashMap<String, String> )request.getAttribute("schargs"); 
String schargs = "";

// ▼▼▼ 검색관련 쿼리스트링 제작 ▼▼▼
String args = "?cpage=" + pageInfo.getCpage();  
for(String key : mapSchargs.keySet()) {
	schargs += "&"+key +"=" +  mapSchargs.get(key);
}

%> 
			
<!-- *** article *** -->
			 
			<script> 
				
				/* 체크박스 전체 선택/해제 */
				function onCheckAll(status) {
					
					var chk_del = document.getElementsByName("chk_del");
					
					for (var i = 0; i < chk_del.length; i++ ) {
						if (chk_del[i].disabled == false) {
							chk_del[i].checked = status;	
						}
						 
					} 
				}
				
				/* 삭제처리 */
				function onProcDel(code) {
					console.log("delete proc :" + code); 
					var arrCheck = []; 
					
					if (code == "all") {
						var chk_del = document.getElementsByName("chk_del");
						for (var i = 0; i < chk_del.length; i++ ) {
							if (chk_del[i].checked == true && chk_del[i].disabled == false) {
								arrCheck[i] = chk_del[i].value;
							} 
						} 
					} else {
						arrCheck[0] = code; 
					}
					
					console.log(arrCheck);
					if (arrCheck.length == 0) {
						alert("삭제할 정보가 없습니다. \n삭제할 데이터를 선택 후 삭제해주세요.");
						return false;
					} else {

						if (confirm("정말 삭제하시겠습니까?")) {

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
					}  
				}

				
				// 호텔검색
				function findHotel() {
					var options = 'top=10, left=10, width=700, height=600, status=no, menubar=no, toolbar=no, resizable=no';
				    window.open("hotel_list_pop.hotela", "숙박업소 검색", options);
				} 
				
			</script>
						
<article>
				<h3>숙박권 리스트 > 예약 리스트</h3>
				
				<!-- content -->
				<div id="content">
				
					<!-- *** Search Layout *** -->
					<form name="frm" method="get" action="reserve_list.reservea">
						
						<div class="box_search01">
							<ul>  
								<li>
									<span class="title01" style="margin-left:20px;">예약번호</span> 
									<span>
										<input type="text" name="txt_rv_code" value="<%=common.nullToString(mapSchargs.get("rv_code")) %>" style="width: 120px">
									</span> 
									
									<span class="title01" style="margin-left:20px;">예약회원</span>  
									<span>
										<input type="text" name="txt_mem_id" value="<%=common.nullToString(mapSchargs.get("mem_id")) %>" style="width: 120px"/>
									</span>  
									<span class="title01" style="margin-left:20px;">예약자명</span>  
									<span>
										<input type="text" name="txt_rv_name" value="<%=common.nullToString(mapSchargs.get("rv_name")) %>" style="width: 120px"/>
									</span> 
								</li>
								<li>
									<span class="title01" style="margin-left:20px;">방종류</span>  
									<span>
										<select name="sl_room_type" style="width: 143px;">
											<option value="">전체</option>
										<% for(String key : common.getRoomType().keySet()) {  
											String sl = "";
											if (key.equals(mapSchargs.get("room_type"))) sl = " selected = 'selected' "; %>
											<option value="<%=key%>" <%=sl %>><%=common.getRoomType().get(key) %></option>
										<% } %>
										</select>  
									</span> 
									<span class="title01" style="margin-left:20px;">숙박명</span> 
									<span>
										<input type="hidden" name="hd_hotel_code" />
										<input type="text" name="txt_hotel_name" value="<%=common.nullToString(mapSchargs.get("hotel_name")) %>" style="width: 120px">
										<input type="button" onclick="findHotel()" value="호텔검색"  /> 	
									</span> 
								</li> 
								<li>
									<span class="title01" style="margin-left:20px;">투숙일</span> 
									<span> 
										<input type="date" name="txt_rv_sdate" data-date-format="YYYY-MM-DD" style="width: 150px;" value="<%=common.nullToString(mapSchargs.get("rv_sdate")) %>" /> ~ 
										<input type="date" name="txt_rv_edate" data-date-format="YYYY-MM-DD" style="width: 150px;" value="<%=common.nullToString(mapSchargs.get("rv_edate")) %>" /> 	
									</span>  
									<span class="title01" style="margin-left:20px;">예약상태</span> 
									<span> 
										<select name="sl_rv_state" style="width: 143px;">
											<option value="">전체</option>
										<% for(String key : common.getRvState().keySet()) {  
											String sl = "";
											if (key.equals(mapSchargs.get("rv_state"))) sl = " selected = 'selected' "; %>
											<option value="<%=key%>" <%=sl %>><%=common.getRvState().get(key) %></option>
										<% } %>
										</select>   	
									</span>  
								</li>  
							</ul>
							<span class="btn" style="margin-top: 30px;">
								<a href="#" onclick="document.frm.submit()" class="btn_search">조회</a> 
							</span>
						</div> 
					</form>
		
					<div class="table_top">
						총 <span><%=pageInfo.getRcnt() %></span>건 
						
						<span class="btn_event" style="display:block;position:absolute;top:0px;right:0px;">
							<a href="#" onclick="onProcDel('all')" class="btn_default gray">예약취소</a>
						</span>
					</div>
		
					<!-- *** list *** -->
					<div class="tbl_wrap_list">
						<table class="tbl_list">  
							<thead>
								<tr>
									<th scope="col"><input type="checkbox" id="allCheck" onclick="onCheckAll(this.checked)" /></th> 
									<th scope="col">예약번호</th>
									<th scope="col">숙소명</th> 
									<th scope="col">방종류</th> 
									<th scope="col">투숙일자</th>
									<th scope="col">예약회원</th>
									<th scope="col">사용자정보</th>
									<th scope="col">결제금액</th> 
									<th scope="col">예약상태</th>
								</tr>
							</thead>
							<tbody>
						<%
						
						if (list != null && list.size() > 0) {
							for (int i = 0 ; i < list.size() ; i++) {
								ReserveInfo info = list.get(i); 
						      	String dis = "";
						      	if(info.getRv_state().equals("A")) {
						      		dis = "disabled";
						      	}
						      	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
						        Calendar c1 = Calendar.getInstance();
							 	String now = dateFormat.format(c1.getTime()); 
							 	Date dtNow = dateFormat.parse(now);
							 	Date dtEdate = dateFormat.parse(info.getRv_edate());

							 	String rv_sdate = info.getRv_sdate().substring(0, 10);
							 	String rv_edate = info.getRv_edate().substring(0, 10);
							 	
						      	String rv_status = "예약확정";
						      	if (info.getRv_state().equals("b")) rv_status = "예약취소";
							 	if (dtNow.after(dtEdate)) rv_status += "<br />(여행종료)";
					            
						%>
							<tr onmouseover="this.className='on'" onmouseout="this.className=''" onclick="location.href='#';">
								<td><input type="checkbox" name="chk_del" value="<%=info.getRv_code() %>"  <%=dis %>/></td>
								<td><strong><a href="reserve_view.reservea?rv_code=<%=info.getRv_code() %>"><%=info.getRv_code() %></a></strong></td> 
								<td><%=info.getHotel_name() %></td>
								<td><%=common.getRoomType().get(info.getRoom_type()) %></td>
								<td><%=rv_sdate %> ~ <%=rv_edate %></td> 
								<td><%=info.getMem_id() %></td>
								<td><%=info.getRv_name() %></td>
								<td><%=String.format("%,d", info.getRv_dis_price()) %></td>  
								<td>
									<% if(info.getRv_state().equals("a")) { %>
									<input type="button" value="예약취소" onclick="onProcDel('<%=info.getRv_code() %>')" />
									<% } else { %>
										<%=rv_status %>
									<% } %>
								</td>
							</tr> 
				            <%
							}
						} else {
							%>
								<tr>
					                <td colspan="10" style="height:150px">
					                    <div class="nodata"><p>조회 하신 데이터가 없습니다.</p></div>
					            	</td>
					            </tr>
								<%}
								%>
							</tbody>
						</table>
					</div> 
					
					
					<!-- *** paging ***  -->
					<div class="paging">
				<% if (list != null && list.size() > 0) {
						args = "?psize=" + pageInfo.getPsize() + schargs;
						
						String firstUrl = "#", prevUrl = "#", lastUrl = "#", nextUrl = "#";
					
						if (pageInfo.getCpage() > 1) { 
							firstUrl = "reserve_list.reservea" + args + "&cpage=1";
							prevUrl  = "reserve_list.reservea?cpage=" + (pageInfo.getCpage() - 1);
						} // 첫 페이지와 이전 페이지 링크
					%>
						<a href="<%=firstUrl%>"><img src='../admin/common/images/btn_pg_first.png' alt='첫 페이지' /></a>
						<a href="<%=prevUrl%>"><img src='../admin/common/images/btn_pg_previous.png' alt='이전 페이지' /></a>
						<span class='wrap'>
					<%  
						for (int i = 1, k = pageInfo.getSpage() ; i <= pageInfo.getBsize() && k <= pageInfo.getEpage() ; i++, k++) {
							if (pageInfo.getCpage() == k) { %> 
								<a href='#' class='on'><%=k %></a>
					<%		} else { %>
								<a href="reserve_list.reservea<%=args + "&cpage=" + k %>"><%=k %></a> 
					<%		}
						}
						if (pageInfo.getCpage() != pageInfo.getPcnt()) {	// 현재 페이지번호가 마지막 페이지 번호이면
							lastUrl = "reserve_list.reservea" + args + (pageInfo.getCpage() + 1);
							nextUrl = "reserve_list.reservea" + args + "&cpage=" + pageInfo.getPcnt(); 
						} 
					%> 
						</span>
						<a href="<%=nextUrl%>"><img src='../admin/common/images/btn_pg_next.png' id='next' alt='다음 페이지' /></a>
						<a href="<%=lastUrl%>"><img src='../admin/common/images/btn_pg_last.png' id='nextEnd' alt='마지막 페이지' /></a>
					<% 
					
				}%>
					</div>
					<!-- //페이징 -->  
		
				</div>
				<!-- //content --> 
			
			</article> 
			<!-- //article --> 
<%@ include file="../_inc/incAdminFooter.jsp" %>
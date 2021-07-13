<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ include file="../_inc/incAdminHead.jsp" %>
<%@ include file="../_inc/incAdminLeft.jsp" %>
<%
request.setCharacterEncoding("utf-8");
@SuppressWarnings("unchecked")

// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼  
ArrayList<ReplyInfo> list = (ArrayList<ReplyInfo>)request.getAttribute("list");
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
					        frm.setAttribute("method", "Post");  					//Post 방식
					        frm.setAttribute("action", "reply_del.replya"); //요청 보낼 주소

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
				<h3>숙박권 리스트 > 후기 리스트</h3>
				
				<!-- content -->
				<div id="content">
				
					<!-- *** Search Layout *** -->
					<form name="frm" method="get" action="reply_list.replya">
						<div class="box_search01">
							<ul>  
								<li>
									<span class="title01" style="margin-left:20px;">숙박명</span> 
									<span>
										<input type="hidden" name="hd_hotel_code" />
										<input type="text" name="txt_hotel_name" value="<%=common.nullToString(mapSchargs.get("name")) %>" style="width: 200px">
										<input type="button" onclick="findHotel()" value="호텔검색"  /> 	
									</span> 
									<span class="title01" style="margin-left:50px;">방종류</span>  
									<span>
										<select name="sl_room_type" style="width: 150px;">
											<option value="">전체</option>
										<% for(String key : common.getRoomType().keySet()) {  
											String sl = "";
											if (key.equals(mapSchargs.get("type"))) sl = " selected = 'selected' "; %>
											<option value="<%=key%>" <%=sl %>><%=common.getRoomType().get(key) %></option>
										<% } %>
										</select>  
									</span> 
								</li> 
							</ul>
							<span class="btn" style="margin-top: 0px;">
								<a href="#" onclick="document.frm.submit()" class="btn_search">조회</a> 
							</span>
						</div> 
					</form>
		
					<div class="table_top">
						총 <span><%=pageInfo.getRcnt() %></span>건 
						
						<span class="btn_event" style="display:block;position:absolute;top:0px;right:0px;"> 
							<a href="#" onclick="onProcDel('all')" class="btn_default gray">삭제</a>
						</span>
					</div>
		
					<!-- *** list *** -->
					<div class="tbl_wrap_list">
						<table class="tbl_list">  
							<thead>
								<tr> 
									<th scope="col"><input type="checkbox" id="allCheck" onclick="onCheckAll(this.checked)" /></th> 
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
						
						if (list != null && list.size() > 0) {
							for (int i = 0 ; i < list.size() ; i++) {
								ReplyInfo info = list.get(i); 
						      	String dis = "";
						      	if(info.getRoom_re_del_yn().equals("y")) {
						      		dis = "disabled";
						      	}
						%>
							<tr onmouseover="this.className='on'" onmouseout="this.className=''">
								<td><input type="checkbox" name="chk_del" value="<%=info.getRoom_code() %>"  <%=dis %>/></td>
								<td><%=info.getHotel_name() %></td>
								<td><%=common.getRoomType().get(info.getRoom_type()) %></td> 
								<td><%=info.getMem_id() %></td>
								<td><%=info.getRoom_re_content() %></td>
								<td><%=info.getRoom_re_score() %></td>
								<td><%=info.getRoom_re_date() %></td>
								<td>
									<% if(!info.getRoom_re_del_yn().equals("y")) { %>
									<input type="button" value="삭제" onclick="onProcDel('<%=info.getRv_code() %>')" />
									<% } else { %>
										삭제완료
									<% } %>
								</td>
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
					
					
					<!-- *** paging ***  -->
					<div class="paging">
				<% if (list != null && list.size() > 0) {
						args = "?psize=" + pageInfo.getPsize() + schargs;
						
						String firstUrl = "#", prevUrl = "#", lastUrl = "#", nextUrl = "#";
					
						if (pageInfo.getCpage() > 1) { 
							firstUrl = "reply_list.replya" + args + "&cpage=1";
							prevUrl  = "reply_list.replya?cpage=" + (pageInfo.getCpage() - 1);
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
								<a href="reply_list.replya<%=args + "&cpage=" + k %>"><%=k %></a> 
					<%		}
						}
						if (pageInfo.getCpage() != pageInfo.getPcnt()) {	// 현재 페이지번호가 마지막 페이지 번호이면
							lastUrl = "reply_list.replya" + args + (pageInfo.getCpage() + 1);
							nextUrl = "reply_list.replya" + args + "&cpage=" + pageInfo.getPcnt(); 
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
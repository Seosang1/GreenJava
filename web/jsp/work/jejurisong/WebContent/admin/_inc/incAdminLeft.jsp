<%@page import="java.util.Arrays"%>
<%@page import="vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 
 
String menu = ((String)request.getAttribute("menuPage") != null) ? (String)request.getAttribute("menuPage") : "";

String gId = "";
String group1 = "hotel room rReply reserve";
String group2 = "food fReply";
String group3 = "tour";
String group4 = "planner";
String group5 = "notice contract faq";
String group6 = "event";
String group7 = "member";

int gIdx1 = group1.indexOf(menu);
int gIdx2 = group2.indexOf(menu);
int gIdx3 = group3.indexOf(menu);
int gIdx4 = group4.indexOf(menu);
int gIdx5 = group5.indexOf(menu);
int gIdx6 = group6.indexOf(menu);
int gIdx7 = group7.indexOf(menu);

// out.println(gIdx1 + " / " +gIdx2);
if (gIdx1 != -1) 	gId="group-1";
if (gIdx2 != -1) 	gId="group-2";
if (gIdx3 != -1) 	gId="group-3";
if (gIdx4 != -1) 	gId="group-4";
if (gIdx5 != -1) 	gId="group-5";
if (gIdx6 != -1) 	gId="group-6";
if (gIdx7 != -1) 	gId="group-7"; 

%>
	<script>
  
	  window.addEventListener("load", function(event) {
//	    console.log("All resources finished loading!");

			document.getElementById("group-1").checked = false;
			document.getElementById("group-2").checked = false;
			document.getElementById("group-3").checked = false;
			document.getElementById("group-4").checked = false;
			document.getElementById("group-5").checked = false;
			document.getElementById("group-6").checked = false;
			document.getElementById("group-7").checked = false; 
			
			document.getElementById("<%=gId%>").checked = true;
		
	  });
	  
	 
	</script>
		<!-- section -->
		<section> 
			<!-- aside --> 
			<aside>
			<h2>Admin Menu</h2>
				<!-- side menu -->
				<ul class="cd-accordion-menu animated">
					<li class="has-children">
						<input type="checkbox" name="group-1" id="group-1"> 
						<label for="group-1" class="sm_01">숙박권 관리</label>
						<ul>		
							<li class="has-children"><a href="hotel_list.hotela" class="sublabel <%=(menu.equals("hotel")?"on" : "")%>">숙박 리스트</a></li>
							<li class="has-children"><a href="room_list.rooma" class="sublabel <%=(menu.equals("room")?"on" : "")%>">방 리스트</a></li>
							<li class="has-children"><a href="reserve_list.reservea" class="sublabel <%=(menu.equals("reserve")?"on" : "")%>">숙박 예약 리스트</a></li>
							<li class="has-children"><a href="reply_list.replya" class="sublabel <%=(menu.equals("rReply")?"on" : "")%>">후기 리스트</a></li>
						</ul>
					</li>
					<li class="has-children">
						<input type="checkbox" name="group-2" id="group-2"> 
						<label for="group-2" class="sm_02">음식점 관리</label>
						<ul>		
							<li class="has-children"><a href="food_list.fooda" class="sublabel  <%=(menu.equals("food")?"on" : "")%>">음식점 리스트</a></li> 
							<li class="has-children"><a href="reply_list.replya" class="sublabel  <%=(menu.equals("fReply")?"on" : "")%>">후기 리스트</a></li> 
						</ul>
					</li>
					<li class="has-children">
						<input type="checkbox" name="group-3" id="group-3"> 
						<label for="group-3" class="sm_03">관광지 관리</label>
						<ul>		
							<li class="has-children"><a href="food_list.fooda" class="sublabel  <%=(menu.equals("tour")?"on" : "")%>">관광지 리스트</a></li>  
						</ul>
					</li>
					<li class="has-children">
						<input type="checkbox" name="group-4" id="group-4"> 
						<label for="group-4" class="sm_04">플래너 관리</label>
						<ul>
							<li class="has-children"><a href="#" class="sublabel <%=(menu.equals("planner")?"on" : "")%>">전체일정리스트</a></li>
						</ul>
					</li>
					<li class="has-children">
						<input type="checkbox" name="group-5" id="group-5"> 
						<label for="group-5" class="sm_05">고객센터</label>
						<ul>
							<li class="has-children"><a href="#" class="sublabel <%=(menu.equals("notice")?"on" : "")%>">공지사항</a></li>
							<li class="has-children"><a href="#" class="sublabel <%=(menu.equals("contract")?"on" : "")%>">1:1문의사항</a></li>
							<li class="has-children"><a href="#" class="sublabel <%=(menu.equals("faq")?"on" : "")%>">자주묻는질문</a></li> 
						</ul>
					</li>
					<li class="has-children">
						<input type="checkbox" name="group-6" id="group-6"> 
						<label for="group-6" class="sm_06">이벤트</label>
						<ul>
							<li class="has-children"><a href="#" class="sublabel <%=(menu.equals("event")?"on" : "")%>">이벤트리스트</a></li>
						</ul>
					</li>
					<li class="has-children">
						<input type="checkbox" name="group-7" id="group-7"> 
						<label for="group-7" class="sm_07">회원</label>
						<ul>
							<li class="has-children"><a href="#" class="sublabel  <%=(menu.equals("member")?"on" : "")%>">전체회원관리</a></li>
						</ul>
					</li>
				</ul>
				<!-- //side menu --> 
			</aside> 
			<!-- //aside --> 
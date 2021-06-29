<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@ page import="vo.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<title>::: 숙소리스트 팝업 :::</title>
	<link href="../admin/common/css/default.css" rel="stylesheet" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<style> 
		article { margin-left: 10px; width: 690px; }
		article #content { margin-top: 0px; }
		.box_search01 ul { float: left; width:460px; } 
		.tbl_wrap_list { padding-top: 10px; }
		.tbl_wrap_list .tbl_list thead th {
		    height: 35px;
		    padding: 0px 10px 0px 10px;
		    font-weight: normal;
		    background: #f6f6f6;
		    text-align: center;
		    border-top: 1px solid #555;
		    border-left: 1px solid #ddd;
		    border-bottom: 1px solid #c4c4c4;
		}
		.tbl_wrap_list .tbl_list tbody td {
		    height: 35px;
		    position: relative;
		    padding: 0px 10px 0px 10px;
		    text-align: center;
		    border-bottom: 1px solid #e0e0e0;
		    border-left: 1px solid #e0e0e0;
		}
		.box_search01 .btn {
		    float: left;
		    min-height: 30px;
		    border-left: 1px solid #e6e6e6;
		    padding-left: 30px;
		    margin-top: 0px;
		}
		
	</style>
	<script>
		function onSetName(code, name){
			opener.frm.hd_hotel_code.value = code;
			opener.frm.txt_hotel_name.value = name;
			window.close();
		}
	</script>
</head> 
<body>
<%
request.setCharacterEncoding("utf-8");
@SuppressWarnings("unchecked")
//(어노테이션) 호환되지 않은 유형으로 작동하면 프로그램이 컴파일 되지 않기에 해당 경고를 보여줌 (ArrayList 제네릭 사용시 밑줄 가리는 방법)


// ▼▼▼ 데이터 받아와서 변수 셋팅 ▼▼▼ 
ArrayList<HotelInfo> hotelList = (ArrayList<HotelInfo>)request.getAttribute("hotelList"); 
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
			<article> 
				<!-- content -->
				<div id="content">
					<h3>숙박업소 검색</h3>
					<!-- *** Search Layout *** -->
					<form name="frmSearch" method="get" action="hotel_list_pop.hotela">
						<div class="box_search01">
							<ul>  
								<li> 
									<span class="title01">숙박명</span> 
									<span><input type="text" name="txt_name" value="<%=common.nullToString(mapSchargs.get("name")) %>" style="width: 300px"></span> 
								</li>
							</ul>
							<span class="btn">
								<a href="#" onclick="document.frmSearch.submit()" class="btn_search">조회</a> 
								<a href="#" onclick="window.close()" class="btn_default gray">닫기</a>
							</span>
						</div> 
					</form> 
		
					<!-- *** list *** -->
					<form name="frm" method="get">
						<div class="tbl_wrap_list">
							<table class="tbl_list">  
								<thead>
									<tr>
										<th scope="col">지역</th>
										<th scope="col">유형</th>
										<th scope="col">숙소명</th> 
										<th scope="col">위치</th>
									</tr>
								</thead>
								<tbody>
							<%
							
							if (hotelList != null && hotelList.size() > 0) {
								// 숙박 리스트가 있다면 돌리기
								for (int i = 0 ; i < hotelList.size() ; i++) {
							      	HotelInfo hotelInfo = hotelList.get(i); 
							      	String hotel_addr = common.txtToShort(hotelInfo.getHotel_addr(), 10);
							%>
								<tr onmouseover="this.className='on'" onmouseout="this.className=''" onclick="location.href='#';">
									<td><%=common.getArea().get(hotelInfo.getHotel_area()) %></td>
									<td><%=common.getHotelType().get(hotelInfo.getHotel_type()) %></td> 
									<td><a href="#" onclick="onSetName('<%=hotelInfo.getHotel_code() %>', '<%=hotelInfo.getHotel_name() %>')"><%=hotelInfo.getHotel_name() %></a></td> 
									<td><%=hotel_addr %></td>
								</tr> 
					            <%
								}
							} else {
								%>
									<tr>
						                <td colspan="4" style="height:150px">
						                    <div class="nodata"><p>조회 하신 데이터가 없습니다.</p></div>
						            	</td>
						            </tr>
									<%}
									%>
								</tbody>
							</table>
						</div> 
					</form>
					
					<!-- *** paging ***  -->
					

					<div class="paging">
				<% if (hotelList != null && hotelList.size() > 0) {
						args = "?psize=" + pageInfo.getPsize() + schargs;
						
						String firstUrl = "#";
						String prevUrl = "#";
						String lastUrl = "#";
						String nextUrl = "#";
					
						if (pageInfo.getCpage() > 1) { 
							firstUrl = "hotel_list_pop.hotela" + args + "&cpage=1";
							prevUrl  = "hotel_list_pop.hotela?cpage=" + (pageInfo.getCpage() - 1);
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
								<a href="hotel_list_pop.hotela<%=args + "&cpage=" + k %>"><%=k %></a> 
					<%		}
						}
						if (pageInfo.getCpage() != pageInfo.getPcnt()) {	// 현재 페이지번호가 마지막 페이지 번호이면
							lastUrl = "hotel_list_pop.hotela" + args + (pageInfo.getCpage() + 1);
							nextUrl = "hotel_list_pop.hotela" + args + "&cpage=" + pageInfo.getPcnt(); 
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
</section>
<!-- //section --> 

</div>
<!-- //wrapper -->
</body>
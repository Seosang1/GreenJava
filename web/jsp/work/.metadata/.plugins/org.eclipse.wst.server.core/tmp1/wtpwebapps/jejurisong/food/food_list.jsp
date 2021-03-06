
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="db.JdbcUtil"%> 
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");
String src = request.getContextPath() + "/common/";

ArrayList<FoodInfo> foodList = (ArrayList<FoodInfo>)request.getAttribute("foodList");   
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");   
FoodInfo foodInfo = (FoodInfo)request.getAttribute("foodInfo"); 

String pmOrder = (String)request.getAttribute("pmOrder"); 	//	 정렬에 대한 쿼리스트링 셋팅
String pmArea = (String)request.getAttribute("pmArea"); 	//	 지역에 대한 쿼리스트링 셋팅

String args = "", schargs = "";
// 검색관련 쿼리스트링 제작 
args = "?cpage=" + pageInfo.getCpage() + schargs; 
if (pageInfo.getKeyword() == null) schargs += "&keyword=";  
else schargs += "&keyword=" + pageInfo.getKeyword();


Common comm = new Common(); 
%> 
	  
<!-- content 영역 --> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <link rel="stylesheet" type="text/css" href="common/css/food.css?alter">   --%>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>   
<style> 
body  {text-align:center;}
div {margin:0 auto; text-align:center;}
#totalList { margin:0 auto; height:100%; display:inline-block;} 
#fdRay {display:inline-block;}

div #top {
    width:100%; height:50px; text-align:center; font-size:25px; color:#4f4f4f; 
    font-weight:bold; padding-top:30px; margin:0;	
	}

div #foodOrd {margin:20px auto;}
#ord {text-align:right;}
div #fdSch {width:*;  }
div .foodList {width:100%; display:inline-block; position:relative; height:100%;} 
div .foodCard { position:absolute; width:100%;} 

div .br {display:block; height:30px; width:*; }
 
div #fdFilterBox {border:3px #fff solid; width:100%; font-size:14px;}
div .fdFilter #filterLine {display:block; } 
div .fdFilter #fdMap {margin: 10px; display:block; }
.fdFilter ul li {font-size:20px;}
.fdFilter .fdOrdChk {margin-left:0px; float:left; margin-top:5px;}
.fdFilter .fdChkBox {width:15px; height:15px; }
.fdFilter #filterSubmit {width:40px; height:30rpx;}
#fdMapTitile {display:block; width:800px; }
div #fdOrdTitle {display:block; border:5px #4f4f4f solid;}
#fdFilterBox #allChk {font-weight:bold; line-height:0.5em;}


div #foodInline {display:inline-block; width:100%; margin:0 auto;} 
div .foodBr {display:inline-block; width:100%; height:30px;}

.outerBox {
    border:5px #4f4f4f solid; width:350px; height:440px; text-align:center;
    padding:5px; margin:10px; display:inline-block;
}
.innerBox {
    border:1px #000 solid; width:340px; height:435px; padding:5px; 
    text-align:center; display:table-cell;  
} 
div .foodImg { margin-top:0;}
.foodName { font-size:15px; padding-top:7px; padding-bottom:3px; font-weight:bold; }
.starRate {width:100px; height:40px;} 
 
div #foodPage { width:100%;}
</style>
<script>
function getSelectedChk() {	// 선택한 체크박스들의 value값을 리턴하는 함수
	var idx = "";	// 선택한 체크박스들의 value값을 쉼표로 구분하여 저장하는 변수
}

function chkAll(all) {
	var arrChk = document.frmFood.chk;
	for (var i = 0 ; i < arrChk.length ; i++) {
		arrChk[i].checked = all.checked;
	}
}

function choose(chk) {
	if (!chk.checked) {	// 현재 체크박스를 체크 해제했을 경우
		document.frmCart.all.checked = false;
	}
} 
function chkVal() {
	var flag = false;
	var fdVal = document.getElementByName("chk");	// 배열의 형태
	System.out.println("name 밸류값 :" +chkVal);
	for (var i = 0; i < fdVal.length; i++) {
		if (fdVal[i].checked) {
			System.out.println("name 하나이상 :" +chkVal[i].value);
		}
	}
	return flag;
}
</script>
</head>
<body>  
<input type="hidden" name="ord" value="<%=pageInfo.getOrd() %>" />
<input type="hidden" name="area" value="<%=pageInfo.getArea() %>" />
<input type="hidden" name="psize" value="<%=pageInfo.getPsize() %>" />
<div id="totalList"> 
<!-- 헤더영역 -->
<%@ include file="../_inc/incHead.jsp" %>  
<form name="frmFood" action="" method="get">
	<div id="fdLay">
			<p width="40%"></p>  
		<div id="top">제주 음식점 추천 목록</div>  
	</div> 
	<!-- 제주정보 이미지 -->
<%@ include file="../_inc/incInfo.jsp"  %> 
	<div class="br"></div>
		<div class="foodList">   
			<div align="right" id="fdSch">
				<span>상호명<input type="text" name="keyword" value="<%=pageInfo.getKeyword() %>" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="식당 검색" /> </span> 
			</div><br />  
			<div class="foodCard">
				<!-- 필터 영역 -->
				<div id="fdFilterBox" >
					<div id="filterLine">
						<div id="fdMapTitle" >
							<h2>지도에서 선택</h2>
						</div>
							<div id="mapImg">
								<img src="<%=src %>images/FoodImg/jejuMap.png" usemap="#useJejuMap" >
								<map name="useJejuMap" >
									<area shape="poly" coords="101,72,164,58,175,70,183,69,189,120,232,140,183,147,158,188,144,184,135,228,106,226,94,257,14,193,14,159,75,94"
										href="food_list.food?area=W<%=pmOrder %>">
									<area shape="poly" coords="209,40,278,26,275,36,286,40,287,57,297,68,300,95,251,138,234,144,222,130,201,126,183,101,182,68,167,68,169,58,200,47"
										href="food_list.food?area=N<%=pmOrder %>">
									<area shape="poly" coords="299,15,313,23,385,9,408,13,412,26,455,36,455,47,464,53,469,72,473,69,475,101,463,103,462,122,440,138,430,159,420,183,380,184,365,202,300,207,292,221,288,200,276,190,267,162,253,148,242,143,254,132,279,125,291,102,299,96,297,66,287,45,274,39,276,29,297,21"
										href="food_list.food?area=E<%=pmOrder %>">
									<area shape="poly" coords="144,225,137,230,165,225,197,225,201,237,228,231,256,232,280,228,291,222,289,201,279,191,278,174,271,163,256,153,247,145,214,147,200,146,184,145,173,162,158,189,148,183,140,197,139,216,136,221"                            
										href="food_list.food?area=S<%=pmOrder %>">
								</map>
							</div>
							<div id="fdMap" class="fdFilter">
								
							</div>
						<div id="fdOrdTitle">
							<h3>음식점 분류</h3>
						</div>
							<div id="fdOrd" class="fdFilter">
								<ul>  
									<li class="fdOrdChk" id="allChk"><input type="checkbox" class="fdChkBox" checked="checked" name="all" onclick="chkAll(this);"/>&nbsp;전체선택</li><br /><br />
									<li class="fdOrdChk"><input type="checkbox" class="fdChkBox" name="chk" value="KFR" checked="checked"  onclick="choose(this);" />&nbsp;한식&nbsp;&nbsp;</li>
									<li class="fdOrdChk"><input type="checkbox" class="fdChkBox" name="chk" value="CFR" checked="checked" onclick="choose(this);" />&nbsp;중식&nbsp;&nbsp;</li>
									<li class="fdOrdChk"><input type="checkbox" class="fdChkBox" name="chk" value="KJFR" checked="checked" onclick="choose(this);" />&nbsp;향토음식&nbsp;&nbsp;</li>
								</ul>
								<ul>
									<li class="fdOrdChk"><input type="checkbox" class="fdChkBox" name="chk" value="JFR" checked="checked" onclick="choose(this);" />&nbsp;일식&nbsp;&nbsp;</li>
									<li class="fdOrdChk"><input type="checkbox" class="fdChkBox" name="chk" value="WTF" checked="checked" onclick="choose(this);" />&nbsp;양식&nbsp;&nbsp;</li>
									<li class="fdOrdChk"><input type="checkbox" class="fdChkBox" name="chk" value="CF" checked="checked" onclick="choose(this);" />&nbsp;카페&nbsp;&nbsp;
									<input type="submit" onclick="chkVal();" id="filterSubmit" value="적 용" /></li>
								</ul> 
								 
							</div>
						<div id="foodOrd">
							<p id="ord">정렬조건 : 
							<a href="food_list.food<%=args%>&ord=review_cntd<%=pmArea %>" 
								style="font-weight:<%=(pageInfo.getOrd().equals("review_cntd")) ? "bold; color:blue;" : "normal" %>">리뷰순</a>&nbsp;&nbsp;
							<a href="food_list.food<%=args%>&ord=scored<%=pmArea %>" 
								style="font-weight:<%=(pageInfo.getOrd().equals("scored")) ? "bold; color:blue;" : "normal" %>">별점순</a>&nbsp;&nbsp;
							<a href="food_list.food<%=args%>&ord=liked<%=pmArea %>" 
								style="font-weight:<%=(pageInfo.getOrd().equals("liked")) ? "bold; color:blue;" : "normal" %>">좋아요 순</a>&nbsp;&nbsp;
							<a href="food_list.food<%=args%>&ord=reg_datea<%=pmArea %>" 
								style="font-weight:<%=(pageInfo.getOrd().equals("reg_datea")) ? "bold; color:blue;" : "normal" %>">등록일 순</a>&nbsp;&nbsp;
							</p>
						</div>  
					</div>
				</div>
				<!-- 음식점 목록 영역 -->
				<div id="foodInline">  
					<% 
					if (foodList != null && foodList.size() > 0) {
					// 상품 검색결과가 있으면
						for (int i = 0 ; i < foodList.size() ; i++) {
						FoodInfo fi = foodList.get(i);  
						String lnk = "<a href=\"food_view.food" + args + "&id=" + fi.getFood_code() + 
							"&ord=" + pageInfo.getOrd() + "&psize=" + pageInfo.getPsize() + "\">"; 
							if (pageInfo.getPsize() == 9) {	// 식당목록을 한 줄에 3개씩 보여주기 
								if (i % 3 == 0)  out.println("<div class=\"foodBr\"></div>");  
					%> 
							<div class="outerBox">
								<div class="innerBox"> 
									<div class="foodImg">
									<%=lnk%><img src="<%=src %>/images/FoodImg/<%=fi.getFood_img1()%>" width="335" height="220" ></a>
									</div>
									<div><br />
										<span class="foodName">
										<%=fi.getFood_name()%><br /><br />
										</span>
										<span class="foodContent">
										<%=fi.getFood_detail()%><br /><br />
										지역 : <%=comm.getArea().get(fi.getFood_area())%><br />
										전화번호 : <%=fi.getFood_tel() %><br />
										좋아요수 : <%=fi.getFood_like() %><br />
										리     뷰 : <%=fi.getFood_review_cnt() %><br />
										<%=comm.getStar().get(Math.ceil(fi.getFood_score())) %>	 									
										</span>
									</div>   
								</div>
							</div> 
							<% 
							}
						}
					} else {
						out.println("<tr><th>검색결과가 없습니다.</th></tr>");
					}
					%>
			</div>  
			<!--  페이징 영역 -->
				<%
				if (foodList != null && foodList.size() > 0) {
					args = "?ord=" + pageInfo.getOrd() + "&psize=" + pageInfo.getPsize() + schargs;
				
					out.println("<div id=\"foodPage\">");
				
					if (pageInfo.getCpage() == 1) {	// 현재 페이지 번호가 1이면
						out.println("[&lt;&lt;]&nbsp;&nbsp;[&lt;]&nbsp;&nbsp;");
					} else {
						out.print("<a href='food_list.food" + args + "&cpage=1" + "'>");
						out.println("[&lt;&lt;]</a>&nbsp;&nbsp;");
						out.print("<a href='food_list.food" + args + 
							"&cpage=" + (pageInfo.getCpage() - 1) + "'>");
						out.println("[&lt;]</a>&nbsp;&nbsp;");
					} // 첫 페이지와 이전 페이지 링크
				
					for (int i = 1, k = pageInfo.getSpage() ; i <= pageInfo.getBsize() && k <= pageInfo.getEpage() ; i++, k++) {
					// i : 루프돌릴 횟수를 검사하는 용도의 변수, k : 페이지 번호 출력용 변수
					// 조건 : bsize만큼 루프를 도는데 페이지가 마지막 페이지일 경우 bsize보다 작아도 멈춤
						if (pageInfo.getCpage() == k) {	// 현재 페이지 번호일 경우 링크없이 강조만 함
							out.print("&nbsp;<strong>" + k + "</strong>&nbsp;");
						} else {
							out.print("&nbsp;<a href='food_list.food" + args + "&cpage=" + k + "'>");
							out.print(k + "</a>&nbsp;");
						}
					} 
				
					if (pageInfo.getCpage() == pageInfo.getPcnt()) {	// 현재 페이지번호가 마지막 페이지 번호이면
						out.println("&nbsp;&nbsp;[&gt;]&nbsp;&nbsp;[&gt;&gt;]");
					} else {
						out.println("&nbsp;&nbsp;<a href='food_list.food" + args + 
							"&cpage=" + (pageInfo.getCpage() + 1) + "'>[&gt;]</a>");
						out.print("&nbsp;&nbsp;<a href='food_list.food" + args + 
							"&cpage=" + pageInfo.getPcnt() + "'>");
						out.println("[&gt;&gt;]</a>");
					}
				
					out.println("</div>");
				}
				%> 
			</div> 
		</div>
	</div>   
</form> 
<script src="food/jquery-1.11.3.min.js"></script>
<script src="food/star.js"></script>
</body>
</html>

	  
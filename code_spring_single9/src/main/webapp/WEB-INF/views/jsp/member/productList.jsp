<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/jsp/main/header.jsp"%>
<style>
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);

html {
   font-family: "Noto Sans KR", sans-serif;
}

/*노말라이즈*/
body, ul, li {
   list-style: none;
   padding: 0;
   margin: 0;
}

a {
   text-decoration: none;
   color: inherit;
}

/*라이브러리*/
.con {
   margin-left: auto;
   margin-right: auto;
}

.cell {
   float: left;
   box-sizing: border-box;
   margin-bottom: 20px;
}

.row::after {
   content: "";
   display: block;
   clear: both;
}

.img-box>img {
   display: block;
   width: 100%;
}
/*커스텀*/
html, body {
   overflow-x: hidden;
}

.con {
   max-width: 1000px;
}

.logo-bar {
   text-align: center;
   margin-bottom: 20px;
   margin-top: 20px;
}

.bn-box {
   margin-bottom: 20px;
   margin-top: 20px;
}

@media ( max-width :700px ) {
   .top-bn-box-1 {
      overflow-x: hidden;
   }
   .top-bn-box-1>.img-box {
      margin-left: -50%;
   }
}

.menu-box {
   margin-bottom: 20px;
   margin-top: 20px;
}

.menu-box>ul>li {
   width: calc(100%/ 7);
}

@media ( max-width : 800px) {
   .menu-box {
      display: none;
   }
}

.menu-box>ul>li>a {
   display: block;
   text-align: center;
   font-weight: bold;
   position: relative;
}

.menu-box>ul>li:hover>a {
   color: red;
   text-decoration: underline;
}

.menu-box>ul>li>a::before, .menu-box>ul>li>a::after {
   content: "";
   width: 1px;
   height: 13px;
   background-color: black;
   position: absolute;
   top: 50%;
   transform: translatey(-50%);
   left: 0;
}

.menu-box>ul>li>a::after {
   left: auto;
   right: 0;
}

.menu-box>ul>li:first-child>a::before, .menu-box>ul>li:last-child>a::after
   {
   width: 2px;
}

.list>ul>li {
   width: calc(100%/ 6);
}

.list>ul>li {
   padding: 0 10px;
}

.list>ul {
   margin: 0 -10px;
}

.list>ul>li>.product-name {
   text-align: Center;
   font-weight: bold;
}

.list>ul>li:hover>.product-name {
   text-decoration: underline;
}

.list>ul>li>.product-price {
   text-align: center;
   font-weight: bold;
   font-size: 1.5rem;
}

.list>ul>li>.product-price::after {
   content: "원";
   font-size: 1rem;
   font-weight: normal;
}

@media ( max-width : 800px) {
   .list>ul>li {
      width: calc(100%/ 5);
   }
}

@media ( max-width : 650px) {
   .list>ul>li {
      width: calc(100%/ 4);
   }
}

@media ( max-width : 500px) {
   .list>ul>li {
      width: calc(100%/ 3);
   }
}

@media ( max-width : 400px) {
   .list>ul>li {
      width: calc(100%/ 2);
   }
}

@media ( max-width : 300px) {
   .list>ul>li {
      width: calc(100%/ 1);
   }
}

#aaa {
   color: red;
}
</style>

<script type="text/javascript">
	var isEnd = false;
	var startNumber = 4;
	var endNumber = 6;
	
	

	
	$(function(){
	    $(window).scroll(function(){
	        
	    	//스크롤 바닥에 도달하면 실행
	        //if( $(window).scrollTop() == $(document).height() - $(window).height() ){
	        if( $(window).scrollTop()+$(window).height()+30 > $(document).height() ){
	            fetchList();
	            startNumber += 3;
	            endNumber += 3;
	        }
	    })
	    
	})
	
	var fetchList = function(){
	    if(isEnd == true){
	        return;
	    }
	    
	    $.ajax({
	        url: "productListScroll.do",
	        type: "GET",
	        data : {'startNumber' : startNumber, 
	        		'endNumber' : endNumber}, 
	        success: function(result){
	        	
	        	scrollPrint(result);
	        	
	        }
	    });
	}
	
	</script>




<div class="container-fluid bg-3 text-center">
   <!-- <%@ include file="/WEB-INF/views/jsp/main/ad_gnb.jsp"%> -->

   <h1>NEW</h1>
   <br>
   <div class="logo-bar con">
      <div class="menu-bar">
         <div class="menu-box">
            <ul class="row">
               <li class="cell" id="aaa"><a href="/admin/new">NEW</a></li>
               <li class="cell"><a href="#">STANDARD</a></li>
               <li class="cell"><a href="#">OUTER</a></li>
               <li class="cell"><a href="#">TOP</a></li>
               <li class="cell"><a href="#">BOTTOM</a></li>
               <li class="cell"><a href="#">ACC</a></li>
               <li class="cell"><a href="#">ALL</a></li>
            </ul>


         </div>
      </div>
   </div>
   <div class="list con">
      <ul class="row">
         <c:forEach var="dto" items="${list}" varStatus="status">
            <!-- list is modelName that made in AdminController -->
            <li class="cell">
               <div class="img-box">
                  <img src="/images/product/${ dto.title_photo }" width="225" height="180"
                     onclick="location.href='productDetail?seq=${ dto.seq }'">
               </div>
               <div class="product-name" onclick="location.href='productDetail?seq=${ dto.seq }'">${ dto.title }</div>
               <div class="product-price">${ dto.price }</div>
               <div class="product-viewCount">view : ${dto.view_count }</div>
               <div class="product-viewCount">like : ${dto.likecnt }</div>               
            </li>
         </c:forEach>
      </ul>
   </div>
</div>
<br>
<br>





<!-- 관리자페이지 푸터 삭제 -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>AT Shopping Mall</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" integrity="sha384-vSIIfh2YWi9wW0r9iZe7RJPrKwp6bG+s9QZMoITbCckVJqGCCRhc+ccxNcdpHuYu" crossorigin="anonymous">
  <style>
	   .dropmenu{
		border:none;
		border:0px;
		margin:0px;
		padding:0px;
		font: "sans-serif";
		}
		
		.dropmenu ul{
		
		height:100px;
		list-style:none;
		margin:0;
		padding:0;
		}
		
		.dropmenu li{
		float:left;
		padding:0px;
		}
		
		.dropmenu li a{
		display:block;
		line-height:100px;
		margin:0px;
		padding:0px 25px;
		text-align:center;
		text-decoration:none;
		}
		
		.dropmenu li a:hover, .dropmenu ul li:hover a{
		background: #8C8C8C;
		text-decoration:none;
		}
		
		.dropmenu li ul{
		background: white;
		display:none; 
		height:auto;
		border:0px;
		position:absolute;
		width:200px;
		z-index:200;
		/*top:1em;
		/*left:0;*/
		}
		
		.dropmenu li:hover ul{
		display:block;
		}
		
		.dropmenu li li {
		background: white;
		float:none;
		margin:0px;
		padding:0px;
		width:200px;
		}
		
		.dropmenu li:hover li a{
		background:none;
		}
		
		.dropmenu li ul a{
		display:block;
		height:80px;
		font-size:14px;
		margin:0px;
		padding:0px 10px 0px 15px;
		text-align:left;
		}
		
		.dropmenu li ul a:hover, .dropmenu li ul li:hover a{
		background: rgb(171,171,171);
		border:0px;
		color:#ffffff;
		text-decoration:none;
		}
		
		.dropmenu p{
		clear:left;
		}
    /* 테이블 크기  */
   table{
   	width : 1181px;
   }

	#aaa {
		color: red;
	}
  </style>
</head>
<body>

<nav class="navbar navbar-light" style="background-color: #d3d3d3;">
	<div class="container-fluid-header">
	<div class='row'>
		<div class="navbar-header col-sm-3">
		<!-- 
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="menu_shop">
        <span class="icon-bar">dd</span>
        <span class="icon-bar">dd</span>
        <span class="icon-bar"></span>                        
      </button>
      	 -->
      <!-- 로고 이미지 -->
<%--      <a href="main"><img alt="메인" src="${path}/images/kjh/logo.png">AT-TONG</a> --%>

			<a href="../admin/operator_main"><img alt="메인" src="/images/kjh/logo.png"></a>
    </div>
    <div class='row' style="height:50px"></div>
    <div class="collapse navbar-collapse dropmenu" id="myNavbar">
    
      <ul class="nav navbar-nav col-sm-6 big">
      	<li><a href="/admin/ad_member">회원관리</a></li>
        <li><a>상품관리</a>
        
        	<ul class="menu_shop">
        		<li><a href="/admin/productList">상품리스트</a></li>
        		<li><a href="../productReg.do">상품등록</a></li>
          	</ul>
        </li>
        
        
        <!-- 
        <li><a href="/new">SHOP</a>
      	/admin/new
      		<ul class="menu_shop">
        		<li><a href="/new">NEW</a></li>
        		<li><a href="#">STANDARD</a></li>
        		<li><a href="#">OUTER</a></li>
        		<li><a href="#">TOP</a></li>
        		<li><a href="#">BOTTOM</a></li>
        		<li><a href="#">ACC</a></li>
        		<li><a href="#">ALL</a></li>
          	</ul>
          
        </li>
         -->
        <li><a href="/admin/ad_BOARD">게시판관리</a></li>
        <li><a href="#">댓글관리</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right col-sm-3">
        <li><a href="../" id="aaa"><i class="far fa-user">관리자 모드</i></a></li>
     
      <c:choose>
       	<c:when test="${sessionScope.u_id == null}">
        <li><a href="../login"><i class="far fa-user">로그인</i></a></li>
        <li><a href="../join"><i class="far fa-edit">회원가입</i></a></li>
		</c:when>
		<c:otherwise>
        <li><a href="../member/logout"><i class="far fa-user">로그아웃</i></a></li>
        <li><a href="/admin/SHOPPING_BASKET"><i class="fas fa-shopping-basket">장바구니</i></a></li>
       </c:otherwise>
       </c:choose>         
      </ul>
    </div>
	</div>
	</div>
</nav>
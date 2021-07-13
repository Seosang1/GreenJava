<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    .container-fluid-header{
/*     	background-color: rgb(223, 225, 210);     */	
		font-family:rgb(28, 15, 16);
      	padding: 15px;    
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
/*     .row.content {height: 450px} */
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */

    footer {
      background-color: rgb(223, 225, 210);
      color: rgb(28, 15, 16);
      padding: 15px;
    } */
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    
    /* 테이블 크기  */
   table{
   	width : 1181px;
   }
    
/*     ul, ol, li { list-style:none; margin:0; padding:0; }
   
    ul.nav navbar-nav {}
    ul.nav navbar-nav > li { display:inline-block; width:80px; padding:5px 10px; background:#eee; text-align:center; position:relative; }
    ul.nav navbar-nav > li:hover { background:#fff; }
    ul.nav navbar-nav > li ul.submenu { display:none;  position:absolute; top:30px; left:0;}
    ul.nav navbar-nav > li:hover ul.submenu { display:block; } 
    ul.nav navbar-nav > li ul.submenu > li { display:inline-block; width:80px; padding:5px 10px; background:#eee; text-align:center; }
    ul.nav navbar-nav > li ul.submenu > li:hover { background:#fff; }
     */
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid-header">
    <div class="navbar-header col-sm-3">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="menu_shop">
        <span class="icon-bar">dd</span>
        <span class="icon-bar">dd</span>
        <span class="icon-bar"></span>                        
      </button>
      
      <!-- 로고 이미지 -->
<%--      <a href="main"><img alt="메인" src="${path}/images/kjh/logo.png">AT-TONG</a> --%>

     <a href="main"><img alt="메인" src="/images/kjh/logo.png"></a>
    
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav col-sm-6">
        <li><a href="ABOUT">ABOUT</a></li>
        <li><a href="SHOP">SHOP</a>
      		<ul class="menu_shop">
        		<li>NEW</li>
        		<li>STANDARD</li>
        		<li>OUTER</li>
        		<li>TOP</li>
        		<li>BOTTOM</li>
        		<li>ACC</li>
        		<li>ALL</li>
          	</ul>
        </li>
        <li><a href="LOOK">LOOK</a></li>
        <li><a href="https://blog.naver.com/">BLOG</a></li>
        <li><a href="BOARD">BOARD</a>
        	<ul class="menu_board submenu">
        		<li>Q&A</li>
        		<li>REVIEW</li>
        		<li>NEWS</li>
        	</ul>
        </li>
        <li><a href="PEOPLE">PEOPLE</a>
        	<ul class="menu_people submenu">
        		<li>PEOPLE</li>
        		<li>PRESS</li>
        	</ul>
        </li>
        <li><a href="LOCATION">LOCATION</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right col-sm-3">      
        <li><a href="operator"><i class="far fa-user">관리자 임시 버튼</i></a></li>
        <li><a href="login"><i class="far fa-user">로그인</i></a></li>
        <li><a href="join"><i class="far fa-edit">회원가입</i></a></li>
        <li><a href="SHOPPING_BASKET"><i class="fas fa-shopping-basket">장바구니</i></a></li>
      </ul>
    </div>
  </div>
</nav>
  
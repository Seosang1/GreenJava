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
    /* Remove the navbar's default margin-bottom and rounded borders */ 
   
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
		background: rgb(31,31,31);
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
    <div class="collapse navbar-collapse dropmenu" id="myNavbar">
    <div class='row' style="height:50px"></div>
      <ul class="nav navbar-nav col-sm-6 big">
        <li><a href="/new">SHOP</a></li>
        <li><a href="BOARD">BOARD</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right col-sm-3">
       	<c:if test="${sessionScope.u_code eq 'A'}">
        <li><a href="/admin/operator_main"><i class="far fa-user">관리자 모드</i></a></li>
        </c:if>
       <c:choose>
       	<c:when test="${sessionScope.u_id == null}">
        <li><a href="login"><i class="far fa-user">로그인</i></a></li>
        <li><a href="join"><i class="far fa-edit">회원가입</i></a></li>
		</c:when>
		<c:otherwise>
        <li><a href="logout"><i class="far fa-user">로그아웃</i></a></li>
        <li><a href="SHOPPING_BASKET"><i class="fas fa-shopping-basket">장바구니</i></a></li>
       </c:otherwise>
       </c:choose>         
      </ul>
    </div>
  </div>
</nav>
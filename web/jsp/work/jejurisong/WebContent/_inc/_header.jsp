<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
String incSrc = request.getContextPath() + "/_inc/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Document</title>

	<!-- Bootstrap core CSS -->
	<link href="<%=incSrc %>/bootstrap.min.css" rel="stylesheet" >
 

	<style>
		/* 헤더 관련 css */
	body {
		margin:0; font-size:16px; line-height:1.5; background:rgb(240, 240, 240); 
		color:#000; min-width:960px; padding-top:10px;
	}
	h1, h2, h3, p, ul { margin:0; }
	ul { padding-left:0; }
	ul li { list-style-type:none; }
	a { color:inherit; text-decoration:none; }
	img { vertical-align:middle; }
	.dummy { margin:0 auto; max-width:70em; padding:5em 0; }

	.page-header {
		background:#fff; position:absolute; width:100%; min-width:960px; 
		-webkit-box-shadow:0 1px 1px rgba(0, 0, 0, 0.25);
				box-shadow:0 1px 1px rgba(0, 0, 0, 0.25);
	}
	.page-header.sticky { position:fixed; top:0; z-index: 1; }
	.page-header > .inner { margin:auto; width:960px; }
	.no-boxshadow .page-header { border-bottom:1px solid rgb(204, 204, 204); }
	.site-logo { float:left; margin-left:-75px; margin-top:10px; }

	.primary-nav { float:right; line-height:65px; letter-spacing:3px; text-transform:uppercase; margin-right:-100px; }
	.primary-nav li { float:left; }
	.primary-nav a { display:block; padding:0 1.36em; }
	.primary-nav a:hover { background:rgb(240, 240, 240); }

	.page-top { 
		margin: 0 auto;
    max-width: 94em;
		text-align: right;
		font-size: 12px;
		padding-bottom: 27px; 
	}

	.page-top-menu { float:right; line-height:20px; letter-spacing:1px; text-transform:uppercase; }
	.page-top-menu li { float:left; }
	.page-top-menu a { display:block; padding:0 0.5em; }
	.page-top-menu a:hover { background:rgb(240, 240, 240); }

	/* 안에 컨텐츠? */

	.bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }


	</style>
	<script src="<%=incSrc %>jquery-3.6.0.js"></script>
	<script>
	$(document).ready(function() {
		$(".page-header").each(function() {
			var $window = $(window);	// 브라우저 창을 jQuery객체로 저장
			var $header = $(this);		// page-header를 jQuery객체로 저장(고정시켜야 할 객체)
			var headerOffsetTop = $header.offset().top;
			// $header의 상단 지점의 위치(이 값에 따라 고정시킬지 여부가 결정됨)

			$window.on("scroll", function() {
			// 브라우저($window)에서 스크롤 이벤트가 발생했을 때 동작됨
				if ($window.scrollTop() > headerOffsetTop) {
				// 브라우저의 스크롤바 상단 위치($window.scrollTop())가 메뉴바 상단위치(headerOffsetTop)보다 크면
				// 메뉴바가 가려질 정도로 스크롤바가 내려왔을 경우
					$header.addClass("sticky");
					// $header에 'sticky'라는 클래스를 추가(sticky : css에서 상단에 고정시키는 스타일을 적용한 클래스)
				} else {
					$header.removeClass("sticky");
					// $header에 'sticky'라는 클래스를 제거(sticky : css에서 상단에 고정시키는 스타일을 적용한 클래스)
				}
			});

			$window.trigger("scroll");
			// trigger() : 선택한 객체에 지정한 이벤트를 인위적으로 발생시키는 메소드
			// 파일 로딩 후 헤더의 초기 위치를 조정하기 위해 실행됨 
		});
	});
	</script>
</head>
<body>
<div class="page-top"> 
	<div class="page-top-menu">
		<ul>
			<li><a href="#">로그인</a></li>
			<li>|</li>
			<li><a href="#">마이페이지</a></li>
			<li>|</li>
			<li><a href="#">고객센터</a></li>
		</ul>
	</div>
</div>
<div class="page-header">
	<div class="inner">
		<h1 class="site-logo"><a href="index.jsp">JEJUJEJU<!--img src="images/logo.png" width="200" height="65" /--></a></h1>
		<div class="primary-nav">
			<ul>
				<li><a href="#">제주정보</a></li>
				<li><a href="#">음식점</a></li>
				<li><a href="#">여행지</a></li>
				<li><a href="#">숙박</a></li>
				<!--li><a href="#">고객센터</a></li-->
			</ul>
		</div>
	</div>
</div>
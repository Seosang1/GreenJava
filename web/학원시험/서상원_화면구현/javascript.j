$(document).ready(function() {
		$(".slideshow").each(function() {
			var $container = $(this), 
				$slideGroup = $container.find(".slideshow-slides"), 
				$slides = $slideGroup.find(".slide"), 
				$nav = $container.find(".slideshow-nav"), 
				$indicator = $container.find(".slideshow-indicator"), 
				slideCount = $slides.length, 
				indicatorHTML = "", 
				currentIndex = 0, 
				duration = 500, 
				easing = "easeInOutExpo", 
				interval = 3000, 
				timer;

			$slides.each(function(i) {
				$(this).css({left:100 * i + "%"});
				indicatorHTML += "<a href='#'>" + (i + 1) + "</a>";
			});
			$indicator.html(indicatorHTML);

			function goToSlide(idx) {
				$slideGroup.animate({left:-100 * idx + "%"}, duration, easing);
				currentIndex = idx;
				updateNav();	
			}

			function updateNav() {
				var $navPrev = $nav.find(".prev");	
				var $navNext = $nav.find(".next");	

				if (currentIndex == 0) {
					$navPrev.addClass("disabled");
				} else {	
					$navPrev.removeClass("disabled");
				}
				if (currentIndex == slideCount - 1) {
					$navNext.addClass("disabled");
				} else {	
					$navNext.removeClass("disabled");
				}

				$indicator.find("a").removeClass("active").eq(currentIndex).addClass("active");
			}

			function startTimer() {
				timer = setInterval(function() {
					var nextIndex = (currentIndex + 1) % slideCount;
					goToSlide(nextIndex);
				}, interval);
			}

			function stopTimer() {
				clearInterval(timer);
			}

			$nav.on("click", "a", function(event) {
				event.preventDefault();

				if ($(this).hasClass("prev")) {
					goToSlide(currentIndex - 1);
				} else {
					goToSlide(currentIndex + 1);
				}
			});

			$indicator.on("click", "a", function(event) {
				event.preventDefault();
				if (!$(this).hasClass("active")) {
					goToSlide($(this).index());
				}
			});

			$container.on({
				mouseenter:stopTimer,	
				mouseleave:startTimer
			});

			goToSlide(currentIndex);

			startTimer();
		});
	});

				// 메뉴바 스크립트 시작

	$(document).ready(function() {
		$(".page-header").each(function() {
			var $window = $(window);		// 브라우저 창을 제이쿼리 객체로 저장	
			var $header = $(this);			// page-header를 제이쿼리 객체로 저장(고정시켜야할 객체)
			var headerOffsetTop = $header.offset().top;
			// $header의 상단 지점의 위치(이 값에 따라 고정시킬지 여부가 결정됨)
			
			$window.on("scroll", function() {
			// 브라우저($window)에서 스크롤 이벤트가 발생했을때 동작됨
				if ($window.scrollTop() > headerOffsetTop){
				// 브라우저의 스크롤바 상단 위치($window.scrollTop())가 메뉴바 상단위치(headerOffsetTop)보다 크면
				// 메뉴바가 가려질 정도로 스크롤바가 내려왔을 경우
					$header.addClass("sticky");
					// $header에 'sticky'라는 클래스를 추가(sticky : css에서 상단에 고정시키는 스타일을 적용한 클래스)
				} else {
					$header.removeClass("sticky");					// $header에 'sticky'라는 클래스를 제거(sticky : css에서 상단에 고정시키는 스타일을 적용한 클래스)
				}
			});

			$window.trigger("scroll");
			// trigger() : 선택한 객체에 지정한 이벤트를 인위적으로 발생시키는 메소드
			// 파일 로딩 후 헤더의 초기 위치를 조정하기 위해 실행됨
		});
		
	});
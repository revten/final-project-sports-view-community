<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SightSite</title>
<link rel="stylesheet"
	href="https://unpkg.com/flickity@2/dist/flickity.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/imgLiquid/0.9.944/js/imgLiquid-min.js"></script>
<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>

<link rel="stylesheet" href="resources/css/home.css" />

</head>
<body>
	<main class="main"> <!--==================== HOME ====================-->
	<div class="slider">
		<section class="slider__component js-slider">
			<!--LOADER-->
			<div class="slider__loader js-slider-loader" role="loader"></div>
			<!--LOADER-->

			<!--CONTROLS-->
			<div class="slider__controls is-prev" role="controls">
				<button type="button" class="js-slider-button-prev">
					<i class="fas fa-long-arrow-alt-left"></i>
				</button>
			</div>
			<div class="slider__controls is-next" role="controls">
				<button type="button" class="js-slider-button-next">
					<i class="fas fa-long-arrow-alt-right"></i>
				</button>
			</div>
			<!--CONTROLS-->

			<article class="slider__item" role="item" data-num="1">
				<!--IMAGE-->
				<div class="slider__item__image is-background">
					<img src="resources/files/home/home_main-1.jpg" alt="website">
				</div>
				<!--IMAGE-->

				<!--TEXT-->
				<div class="slider__item__text">
					<span>Team Miracle Project</span>
					<h1>TEAM MIRACLE</h1>

					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

					<a href="#" role="button"> Let's go </a>
				</div>
				<!--TEXT-->
			</article>

			<article class="slider__item" role="item" data-num="2">
				<!--IMAGE-->
				<div class="slider__item__image is-background">
					<img src="resources/files/home/home_main-2.jpg" alt="website">
				</div>
				<!--IMAGE-->

				<!--TEXT-->
				<div class="slider__item__text">
					<span>Team Miracle Project</span>
					<h1>Project for Fan</h1>

					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

					<a href="#" role="button"> Let's go </a>
				</div>
				<!--TEXT-->
			</article>

			<article class="slider__item" role="item" data-num="3">
				<!--IMAGE-->
				<div class="slider__item__image is-background">
					<img src="resources/files/home/home_main-3.jpg" alt="website">
				</div>
				<!--IMAGE-->

				<!--TEXT-->
				<div class="slider__item__text">
					<span>Team Miracle Project</span>
					<h1>Well thought out</h1>

					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

					<a href="#" role="button"> Let's go </a>
				</div>
				<!--TEXT-->
			</article>

			<article class="slider__item" role="item" data-num="4">
				<!--IMAGE-->
				<div class="slider__item__image is-background">
					<img src="resources/files/home/home_main-4.jpg" alt="website">
				</div>
				<!--IMAGE-->

				<!--TEXT-->
				<div class="slider__item__text">
					<span>Team Miracle Project</span>
					<h1>We Never Give Up</h1>

					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

					<a href="#" role="button"> Let's go </a>
				</div>
				<!--TEXT-->
			</article>

			<article class="slider__item" role="item" data-num="5">
				<!--IMAGE-->
				<div class="slider__item__image is-background">
					<img src="resources/files/home/home_main-5.jpg" alt="website">
				</div>
				<!--IMAGE-->

				<!--TEXT-->
				<div class="slider__item__text">
					<span>Team Miracle Project</span>
					<h1>Don't Stop Now</h1>

					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

					<a href="#" role="button"> Let's go </a>
				</div>
				<!--TEXT-->
			</article>
		</section>
	</div>

<!--==================== ABOUT US (사이트 간단설명 섹션)====================-->
	<section class="about section" id="about">
		<div class="about__container container grid">
			<div class="about__data">
				<span class="section__subtitle">About Team Miracle</span>
				<h2 class="section__title about__title">
					<div>
						팬들만의 쉼터 <img src="resources/files/home/about-title.png"
							alt="about image">
					</div>
				</h2>

				<p class="about__description">스포츠를 사랑하는 다양한 팬들이 서로의 경험을 자연스럽게
					공유합니다. 자신으로 인하여 다른 팬이 더 즐거운 경기를 관람하게 됩니다.</p>
			</div>

			<img src="resources/files/home/about-main.png" alt="about image"
				class="about__img"> <img
				src="resources/files/home/leaf-branch-2.png" alt="home image"
				class="home__leaf-1">
		</div>
		<img src="resources/files/home/leaf-branch-1.png" alt="about image"
			class="about__leaf">
	</section>


	<!--==================== POPULAR (유명섹션 - 인기리뷰)====================-->
	<section class="popular section" id="popular">
		<div></div>
		<span class="section__subtitle">The Best Review</span>
		<h2 class="section__title">멋진 후기를 추천해주세요</h2>

		<div class="popular__container container grid">

			<article class="popular__card">
				<img src="resources/files/home/popular-review1.jpg" alt="popular image"
					class="popular__img">
				<h3 class="popular__name">우승을 보다 ㅠ</h3>
				<span class="popular__description">임형규님의 후기</span> <span
					class="popular__price">10.09만 뷰</span>
				<button class="popular__button">
					<i class="ri-star-line"></i>
				</button>
			</article>
			
			<article class="popular__card">
				<img src="resources/files/home/popular-review2.png"
					alt="popular image" class="popular__img">
				<h3 class="popular__name">미친열기 여농..</h3>
				<span class="popular__description">송준우님의 후기</span> <span
					class="popular__price">9.69만 뷰</span>
				<button class="popular__button">
					<i class="ri-star-line"></i>
				</button>
			</article>

			<article class="popular__card">
				<img src="resources/files/home/popular-review3.jpg"
					alt="popular image" class="popular__img">
				<h3 class="popular__name">김연경 선수 멋져요</h3>
				<span class="popular__description">정권님의 후기</span> <span
					class="popular__price">12.31만 뷰</span>
				<button class="popular__button">
					<i class="ri-star-line"></i>
				</button>
			</article>
		</div>
					<img src="resources/files/home/leaf-branch-4.png" alt="home image"
				class="home__leaf-2">
	</section>


	<!--==================== RECENTLY (최신섹션 - 뉴스 정보) ====================-->
	<section class="recently section" id="recently">
		<div class="recently__container container grid">
			<div class="recently__data">
				<span class="section__subtitle">My Hot Point</span>
				<h2 class="section__title">
					자신만의 시선을 <br> 분석으로 보여주세요
				</h2>

				<p class="recently__description">많은 팬들이 팔로우할지도 모릅니다. 자유게시판에서 편하게
					의견을 나누세요.</p>
				<a href="#" class="button"> 보러가기<i class="ri-arrow-right-line"></i>
				</a> <img src="resources/files/home/spinach-leaf.png"
					alt="recently image" class="recently__data-img">
			</div>

			<img src="resources/files/home/recently-new_pic.png"
				alt="recently image" class="recently__img">
		</div>

		<img src="resources/files/home/leaf-branch-2.png" alt="recently image"
			class="recently__leaf-1"> <img
			src="resources/files/home/leaf-branch-3.png" alt="recently image"
			class="recently__leaf-2">
	</section>


	<!--==================== NEWSLETTER ====================-->
	<section class="newsletter section">
		<div class="newsletter__container container">
			<div class="newsletter__content grid">
				<img src="resources/files/home/newsletter-sushi.png"
					alt="newsletter image" class="newsletter__img">

				<div class="newsletter__data">
					<span class="section__subtitle">Newsletter</span>
					<h2 class="section__title">
						구단 소식과 이벤트를 <br> 메일로 받아보세요
					</h2>

					<form action="#" class="newsletter__form">
						<input type="email" placeholder="이메일" class="newsletter__input">
						<button type="button" class="button newsletter__button">
							Subscribe <i class="ri-send-plane-line"></i>
						</button>
					</form>
				</div>
			</div>

			<img src="resources/files/home/spinach-leaf.png"
				alt="newsletter image" class="newsletter__spinach">
		</div>
	</section>
	</main>


	<script>
		var Slider = function() {

			var Images = function() {
				$(".is-background").imgLiquid();
			}

			var Component = function() {
				var $Slider = $('.js-slider');

				// bind event listener first
				$Slider.on('ready.flickity', function() {
					// Loader...
					TweenMax.to($('.js-slider-loader'), 1, {
						delay : 0.2,
						autoAlpha : 0,
						ease : Expo.easeInOut,
						onComplete : function() {
							// Slider...
							TweenMax.to($Slider, 0.5, {
								delay : 0,
								autoAlpha : 1,
								ease : Expo.easeInOut
							});

							// Text...
							TweenMax.to($('.slider__item__text h1'), 0.8, {
								delay : 0.3,
								autoAlpha : 1,
								ease : Expo.easeInOut
							});
							TweenMax.to($('.slider__item__text p'), 0.8, {
								delay : 0.6,
								autoAlpha : 1,
								ease : Expo.easeInOut
							});
							TweenMax.to($('.slider__item__text a'), 0.8, {
								delay : 0.9,
								autoAlpha : 1,
								ease : Expo.easeInOut
							});
						}
					});
				});

				$Slider.flickity({
					cellAlign : 'left',
					contain : true,
					draggable : true,
					cellSelector : '.slider__item',
					wrapAround : true,
					autoPlay : 3600,
					pauseAutoPlayOnHover : false,
					prevNextButtons : false
				});

				// Controls...
				$('.js-slider-button-prev').on('click', function() {
					$Slider.flickity('previous');
				});
				$('.js-slider-button-next').on('click', function() {
					$Slider.flickity('next');
				});
			}

			return {
				init : function() {
					Images();
					Component();
				}
			};
		}();

		// Run...
		Slider.init();
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SightSite</title>
</head>
<body>
	<main class="main"> <!--==================== HOME ====================-->
	<section class="home section" id="home">
		<div class="home__container container grid">
			<img src="resources/home_img/main_synthesis.png" alt="home image"
				class="home__img">
			<div class="home__data">
				<h1 class="home__title">
						<img src="resources/files/home/about-title.png" alt="home image">
				</h1>
				<p class="home__description"></p>

				<a href="#" class="button"> <!-- rec5.main.go --> 경기좌석 보러가기 <i
					class="ri-arrow-right-line"></i>
				</a>
			</div>
		</div>

		<img src="resources/files/home/leaf-branch-2.png" alt="home image"
			class="home__leaf-1"> <img
			src="resources/files/home/leaf-branch-4.png" alt="home image"
			class="home__leaf-2">
	</section>


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

				<p class="about__description"> 스포츠를 사랑하는 다양한 팬들이 서로의 경험을 자연스럽게 공유합니다.
					자신으로 인하여 다른 팬이 더 즐거운 경기를 관람하게 됩니다. 이러한 소통은 스포츠에 대한 몰입감을 높이고
					국내 스포츠계에 자연스러운 선순환을 선사해드리겠습니다.</p>
			</div>

			<img src="resources/files/home/about-main.png" alt="about image"
				class="about__img">
		</div>
		<img src="resources/files/home/leaf-branch-1.png" alt="about image"
			class="about__leaf">
	</section>


	<!--==================== POPULAR (유명섹션 - 인기리뷰)====================-->
	<section class="popular section" id="popular">
		<span class="section__subtitle">The Best Review</span>
		<h2 class="section__title">멋진 후기를 추천해주세요</h2>

		<div class="popular__container container grid">

			<article class="popular__card">
				<img src="resources/home_img/main_baseball3.jpg"
					alt="popular image" class="popular__img">
				<h3 class="popular__name">한일전 승자는?</h3>
				<span class="popular__description">임형규님의 후기</span> <span
					class="popular__price">10.09만 뷰</span>
				<button class="popular__button">
					<i class="ri-star-line"></i>
				</button>
			</article>

			<article class="popular__card">
				<img src="resources/home_img/main_soccer_busan.jpg"
					alt="popular image" class="popular__img">
				<h3 class="popular__name">부산축구 이대로인가..</h3>
				<span class="popular__description">송준우님의 후기</span> <span
					class="popular__price">9.69만 뷰</span>
				<button class="popular__button">
					<i class="ri-star-line"></i>
				</button>
			</article>

			<article class="popular__card">
				<img src="resources/home_img/main_volleyball_kim.jpg"
					alt="popular image" class="popular__img">
				<h3 class="popular__name">김연경 선수 멋지내요!</h3>
				<span class="popular__description">정권님의 후기</span> <span
					class="popular__price">12.31만 뷰</span>
				<button class="popular__button">
					<i class="ri-star-line"></i>
				</button>
			</article>

		</div>
	</section>


	<!--==================== RECENTLY (최신섹션 - 뉴스 정보) ====================-->
	<section class="recently section" id="recently">
		<div class="recently__container container grid">
			<div class="recently__data">
				<span class="section__subtitle">My Hot Point</span>
				<h2 class="section__title">
					자신만의 시선을 <br> 분석으로 보여주세요
				</h2>

				<p class="recently__description"> 많은 팬들이 팔로우할지도 모릅니다.
					글과 댓글로 서로 정보와 의견을 교환해보세요.</p>
				<a href="#" class="button"> 보러가기<i class="ri-arrow-right-line"></i>
				</a> <img src="resources/files/home/spinach-leaf.png"
					alt="recently image" class="recently__data-img">
			</div>

			<img src="resources/home_img/volleyball.jpg"
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
						최신 소식과 이벤트를 <br> 메일로 받아보세요
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
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Enjoy Sports</title> <
<!-- --------------- FAVICON --------------- -->
<link rel="shortcut icon" href="resources/files/home/favicon.png"
	type="image/x-icon" />

<!-- --------------- REMIXICONS --------------- -->
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet" />

<!--=============== [CSS CDN]===============-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/flickity/1.0.0/flickity.css" />
<!-- 리뷰 게시판 뗴지않고 움직이면 슬라이더가 움직임-->

<!--=============== [JS CDN] ===============-->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/flickity/1.0.0/flickity.pkgd.js"></script>
<script src="//cdn.ckeditor.com/4.19.0/full/ckeditor.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>

<!-- --------------- Jquerry --------------- -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>

<!-- --------------- IMAGESLOADED --------------- -->
<script type="text/javascript"
	src="https://unpkg.com/imagesloaded@4/imagesloaded.pkgd.min.js"></script>

<!-- --------------- SCROLLREVEAL --------------- -->
<script src="https://unpkg.com/scrollreveal"></script>


<!--=============== [CSS MEMBER]===============-->
<link rel="stylesheet" href="resources/css/index.css" />
<link rel="stylesheet" href="resources/css/account.css" />
<link rel="stylesheet" href="resources/css/news.css" />
<link rel="stylesheet" href="resources/css/stadium/stadium.css" />
<link rel="stylesheet" href="resources/css/stadium/stadiumMain.css" />
<link rel="stylesheet" href="resources/css/map.css" />
<link rel="stylesheet" href="resources/css/clubEvent.css" />
<link rel="stylesheet" href="resources/css/review.css" />
<link rel="stylesheet" href="resources/css/withGo.css" />
<link rel="stylesheet" href="resources/css/fanBoard.css">
<link rel="stylesheet" href="resources/css/myPage.css" />

</head>

<body>
	<!--==================== HEADER ====================-->
	<header class="header" id="header">
		<nav class="nav container">

			<div class="nav__buttons">
				<!-- Theme change button 라이트모드/다크모드-->
				<i class="ri-moon-line change-theme" id="theme-button"></i>

				<!-- Toggle button 폰으로 볼때 위에 내비처럼 생기는거-->
				<div class="nav__toggle" id="nav-toggle">
					<i class="ri-apps-line"></i>
				</div>
				
				<!--==================== login area - loginSucces.jsp ====================-->
				<div>
					<a class="nav__link"><jsp:include page="${loginPage }"></jsp:include></a>
				</div>
				
			</div>

			<div class="nav__menu" id="nav-menu">
				<ul class="nav__list">
					<li class="nav__item"><a href="stadium.main.go"
						class="nav__link">STADIUM</a></li>
					<li class="nav__item"><a href="review.board.go?post_board=12"
						class="nav__link">REVIEW</a></li>
					<li class="nav__item"><a href="fan.board.go?post_board=21"
						class="nav__link">THE FAN</a></li>
				</ul>

				<ul class="nav__list">
					<li class="nav__item"><a href="index.go" class="nav__logo">
							<img src="resources/files/home/logo.png" alt="logo image" />
							TRIPPLE
					</a></li>
				</ul>

				<ul class="nav__list">
					<li class="nav__item"><a href="withGo.board.go?post_board=11"
						class="nav__link">STORE</a></li>
					<li class="nav__item"><a href="news.main.go" class="nav__link">NEWS</a></li>
					<li class="nav__item"><a
						href="clubEvent.board.go?post_board=31" class="nav__link">EVENT</a></li>
				</ul>

				<!-- close button -->
				<div class="nav__close" id="nav-close">
					<i class="ri-close-line"></i>
				</div>

				<img src="resources/files/home/leaf-branch-4.png" alt="nav image"
					class="nav__img-1" /> <img
					src="resources/files/home/leaf-branch-3.png" alt="nav image"
					class="nav__img-2" />
			</div>
		</nav>
	</header>

	<!--==================== home.jsp ====================-->

	<div class="content__page" align="center"><jsp:include
			page="${contentPage }"></jsp:include></div>

	<!--==================== FOOTER ====================-->
	<footer class="footer">
		<div class="footer__container container grid">
			<div>
				<a href="#" class="footer__logo" style="color: hsl(19, 16%, 15%);">
					<img src="resources/files/home/logo.png" alt="logo image" />
					TRIPPLE
				</a>

				<p class="footer__description">
					모두가 같이 <br /> 만들어가는 <br /> 스포츠 컬쳐
				</p>
			</div>

			<div class="footer__content">
				<div>
					<h3 class="footer__title" style="color: hsl(19, 16%, 15%);">Main
						Menu</h3>
					<ul class="footer__links">
						<li><a href="#" class="footer__link">SIGHT</a></li>
						<li><a href="#" class="footer__link">WITH</a></li>
						<li><a href="#" class="footer__link">REVIEW</a></li>
						<li><a href="#" class="footer__link">THE FAN</a></li>
					</ul>
				</div>

				<div>
					<h3 class="footer__title" style="color: hsl(19, 16%, 15%);">Information</h3>
					<ul class="footer__links">
						<li><a href="#" class="footer__link">Team Miracle</a></li>
						<li><a href="#" class="footer__link">Videos</a></li>
						<li><a href="#" class="footer__link">Contact</a></li>
					</ul>
				</div>

				<div>
					<h3 class="footer__title" style="color: hsl(19, 16%, 15%);">Address</h3>
					<ul class="footer__links">
						<li class="footer__information">서울특별시 미라클시 <br /> 미라클빌딩 777호
						</li>
					</ul>
				</div>

				<div>
					<h3 class="footer__title" style="color: hsl(19, 16%, 15%);">Social
						Media</h3>
					<ul class="footer__social">
						<a href="https://www.facebook.com" target="_blank"
							class="footer__social-link"> <i
							class="ri-facebook-circle-fill"></i>
						</a>
						<a href="https://www.instagram.com" target="_blank"
							class="footer__social-link"> <i class="ri-instagram-fill"></i>
						</a>
						<a href="https://www.twitter.com" target="_blank"
							class="footer__social-link"> <i class="ri-twitter-fill"></i>
						</a>
					</ul>
				</div>
			</div>

			<img src="resources/files/home/spring-onion.png" alt="footer image"
				class="footer__onion" /> <img
				src="resources/files/home/spinach-leaf.png" alt="footer image"
				class="footer__spinach" /> <img
				src="resources/files/home/leaf-branch-4.png" alt="footer image"
				class="footer__leaf" />
		</div>

		<div class="footer__info container">
			<div class="footer__card">
				<img src="resources/files/home/footer-card-1.png" alt="footer image" />
				<img src="resources/files/home/footer-card-2.png" alt="footer image" />
				<img src="resources/files/home/footer-card-3.png" alt="footer image" />
				<img src="resources/files/home/footer-card-4.png" alt="footer image" />
			</div>

			<span class="footer__copy"> &#169; Copyright TeamMiracle. All
				rights reserved </span>
		</div>
	</footer>

	<!--========== SCROLL UP ==========-->
	<a href="#" class="scrollup" id="scroll-up"> <i
		class="ri-arrow-up-line"></i>
	</a>

	<!--=============== MAIN JS ===============-->
	<script src="resources/js/index.js"></script>

	<!--=============== [JS MEMBER]===============-->
	<script src="resources/js/account/account_go.js"></script>
	<script src="resources/js/account/account_condition.js"></script>
	<script src="resources/js/account/account_check.js"></script>
	<script src="resources/js/account/account_validCheck.js"></script>

	<script src="resources/js/stadium/stadium_go.js"></script>
	<script src="resources/js/stadium/stadiumDetail.js"></script>
	<script src="resources/js/stadium/seat_detail.js"></script>

	<script src="resources/js/myPage/myPage.js"></script>
	<script src="resources/js/news/paging.js"></script>
	<script src="resources/js/fan/fan_reply.js"></script>
	<script src="resources/js/fan/fanPost.js"></script>
</body>
</html>

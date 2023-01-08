<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <main class="main">
        <!--==================== HOME ====================-->
        <section class="home section" id="home">
            <div class="home__container container grid">
                <img src="resources/files/home/home-main.png" alt="home image" class="home__img">
                <div class="home__data">
                    <h1 class="home__title">
                        Enjoy Sports
                        <div> <img src="resources/files/home/home-title.png" alt="home image"> 감동실화</div>
                    </h1>
                    <p class="home__description">
                        Enjoy a good Play with the best guide in Our website and improve your life.
                    </p>

                    <a href="#" class="button"> <!-- rec5.main.go -->
                        경기좌석 보러가기 <i class="ri-arrow-right-line"></i>
                    </a>
                </div>
            </div>

            <img src="resources/files/home/leaf-branch-2.png" alt="home image" class="home__leaf-1">
            <img src="resources/files/home/leaf-branch-4.png" alt="home image" class="home__leaf-2">
        </section>


        <!--==================== ABOUT US (사이트 간단설명 섹션)====================-->
        <section class="about section" id="about">
            <div class="about__container container grid">
                <div class="about__data">
                    <span class="section__subtitle">About Team Miracle</span>
                    <h2 class="section__title about__title">
                        <div>
                            최고의 관람을
                            <img src="resources/files/home/about-title.png" alt="about image">
                        </div>
                        도와드리립니다
                    </h2>

                    <p class="about__description">
                        이제는 여행을 누군과 함께 떠나야 할 필요는 없습니다. 혼자 떠나는 여행만이 줄 수 있는 설렘과 감동을 느끼고 싶을때가 있습니다. 여기에서 많은 사람들과 소통하며
                        여행하세요. 홀로떠나지만 돌아올땐 좋은 사람들을 얻어서 돌아오는 경험을 드리겠습니다.
                    </p>
                </div>

                <img src="resources/files/home/about-main.png" alt="about image" class="about__img">
            </div>
            <img src="resources/files/home/leaf-branch-1.png" alt="about image" class="about__leaf">
        </section>


        <!--==================== POPULAR (유명섹션 - 인기리뷰)====================-->
        <section class="popular section" id="popular">
            <span class="section__subtitle">The Best Review</span>
            <h2 class="section__title">멋진 리뷰를 감상하세요</h2>

            <div class="popular__container container grid">

                <article class="popular__card">
                    <img src="resources/files/home/popular-review1.png" alt="popular image" class="popular__img">
                    <h3 class="popular__name">Tokyo Trip</h3>
                    <span class="popular__description">임형규님의 하루</span>
                    <span class="popular__price">$10.09</span>
                    <button class="popular__button">
                        <i class="ri-star-line"></i>
                    </button>
                </article>

                <article class="popular__card">
                    <img src="resources/files/home/popular-review2.png" alt="popular image" class="popular__img">
                    <h3 class="popular__name">Osaka Trip</h3>
                    <span class="popular__description">송준우님의 하루</span>
                    <span class="popular__price">$9.69</span>
                    <button class="popular__button">
                        <i class="ri-star-line"></i>
                    </button>
                </article>

                <article class="popular__card">
                    <img src="resources/files/home/popular-review3.png" alt="popular image" class="popular__img">
                    <h3 class="popular__name">Kyoto Trip</h3>
                    <span class="popular__description">정권님의 하루</span>
                    <span class="popular__price">$12.31</span>
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
                    <span class="section__subtitle">Recent Hot Place</span>
                    <h2 class="section__title">
                        떠오르는 여행지를 <br>
                        확인해보세요
                    </h2>

                    <p class="recently__description">
                        1인 여행자들이 주목하는 최신 뉴스를 바로 접하세요. 댓글로 서로 정보와 의견을 교환해보세요.
                    </p>
                    <a href="#" class="button">
                        보러가기<i class="ri-arrow-right-line"></i>
                    </a>

                    <img src="resources/files/home/spinach-leaf.png" alt="recently image" class="recently__data-img">
                </div>

                <img src="resources/files/home/recently-new_pic.png" alt="recently image" class="recently__img">
            </div>

            <img src="resources/files/home/leaf-branch-2.png" alt="recently image" class="recently__leaf-1">
            <img src="resources/files/home/leaf-branch-3.png" alt="recently image" class="recently__leaf-2">
        </section>


        <!--==================== NEWSLETTER ====================-->
        <section class="newsletter section">
            <div class="newsletter__container container">
                <div class="newsletter__content grid">
                    <img src="resources/files/home/newsletter-sushi.png" alt="newsletter image" class="newsletter__img">

                    <div class="newsletter__data">
                        <span class="section__subtitle">Newsletter</span>
                        <h2 class="section__title">
                            미라클 소식지를 <br>
                            이메일로 받아보세요
                        </h2>

                        <form action="#" class="newsletter__form">
                            <input type="email" placeholder="이메일" class="newsletter__input">
                            <button type="button" class="button newsletter__button">
                                Subscribe <i class="ri-send-plane-line"></i>
                            </button>
                        </form>
                    </div>
                </div>

                <img src="resources/files/home/spinach-leaf.png" alt="newsletter image" class="newsletter__spinach">
            </div>
        </section>
    </main>
</body>
</html>
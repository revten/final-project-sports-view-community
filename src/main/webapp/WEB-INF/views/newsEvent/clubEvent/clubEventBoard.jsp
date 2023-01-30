<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.4.1/css/swiper.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Oswald:500"
	rel="stylesheet">
<script>!function (e) { "undefined" == typeof module ? this.charming = e : module.exports = e }(function (e, n) { "use strict"; n = n || {}; var t = n.tagName || "span", o = null != n.classPrefix ? n.classPrefix : "char", r = 1, a = function (e) { for (var n = e.parentNode, a = e.nodeValue, c = a.length, l = -1; ++l < c;) { var d = document.createElement(t); o && (d.className = o + r, r++), d.appendChild(document.createTextNode(a[l])), n.insertBefore(d, e) } n.removeChild(e) }; return function c(e) { for (var n = [].slice.call(e.childNodes), t = n.length, o = -1; ++o < t;)c(n[o]); e.nodeType === Node.TEXT_NODE && a(e) }(e), e });
  </script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.4.1/js/swiper.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.2/TweenMax.min.js"></script>
 
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- <div class="nav__menu" id="nav-menu" style="width:55%;align:center;">
				<ul class="nav__list">
					<li class="nav__item"><a href="clubEvent.board.go"
						class="nav__link">구단공식이벤트</a></li>
						
					<li class="nav__item"><a href="news.sports.go"
						class="nav__link">스포츠</a></li>
					<li class="nav__item"><a href="newsEvent.main.go"
						class="nav__link">뉴스</a>
					</li>
						
						

				</ul>
		</div> -->
		<br><br>
		
	<section class="swiper_section">

		<div class="swiper-container slideshow">

			<div class="swiper-wrapper">

				<div class="swiper-slide slide">
					<div class="slide-image"
						style="background-image: url(https://img.danawa.com/contents/event/101129_pangpang/con01.jpg">
					</div>
					<span class="slide-title">Event</span>
				</div>

				<div class="swiper-slide slide">
					<div class="slide-image"
						style="background-image: url(https://wimg.mk.co.kr/news/cms/202212/15/news-p.v1.20221215.e4489ff792cd4e8a9fbb8d2dc75e00d8.jpg">
					</div>
					<span class="slide-title">Together</span>
				</div>

				<div class="swiper-slide slide">
					<div class="slide-image"
						style="background-image: url(https://cfile1.onoffmix.com/attach/jJZA0D8PBE4Xw1x3GLTMhtFvU2WYnQda">
					</div>
					<span class="slide-title">Chicken</span>
				</div>

				<!--         <div class="swiper-slide slide">
            <div class="slide-imageswiper-lazy" data-background="https://images.unsplash.com/photo-1538083024336-555cf8943ddc?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=66b476a51b19889e13182c0e4827af18&auto=format&fit=crop&w=1950&q=80">
            </div>
            </div>
            <span class="slide-title">Exotic places</span>
          </div>
        
          <div class="swiper-slide slide">
            <div class="slide-image swiper-lazy" data-background="https://images.unsplash.com/photo-1500375592092-40eb2168fd21?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=e07d2457879a4e15577ec75a31023e47&auto=format&fit=crop&w=2134&q=80">
            </div>
            <span class="slide-title">Meet ocean</span>
          </div>
        
          <div class="swiper-slide slide">
            <div class="slide-image swiper-lazy" data-background="https://images.unsplash.com/photo-1482059470115-0aadd6bf6834?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=267bba9a4e280ec64388fe8fb01e9d1b&auto=format&fit=crop&w=1950&q=80">
            </div>
            <span class="slide-title">Around the world</span>
          </div> -->

			</div>

			<div class="slideshow-pagination"></div>

			<div class="slideshow-navigation">
				<div class="slideshow-navigation-button prev">
					<span class="fas fa-chevron-left"></span>
				</div>
				<div class="slideshow-navigation-button next">
					<span class="fas fa-chevron-right"></span>
				</div>
			</div>

		</div>

	</section>
<hr style="width: 1200px;">


	<!--==================== 게시판 ====================-->
	<div class="board__container">
		<%-- <div class="board__top">
			<c:choose>
				<c:when test="${sessionScope.loginAccount ne null}">
					<a href=clubEvent.reg.go> 새글쓰기</a>
				</c:when>
				<c:otherwise>
					<a href="clubEvent.reg.go" onclick="alert('로그인하세요')">새글쓰기</a>
				</c:otherwise>
			</c:choose>
		</div> --%>


				<c:forEach var="p" items="${posts }">
					<div class='clubEvent'>
						<div class='title'>
							<span><a class='clubEventTitle'
								href="clubEvent.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">${p.post_title }
									[${p.post_like_count}]</a></span>
						</div>
						<div>
							<span class='time'><%--  글번호 ${p.post_id} | 탭 ${p.post_category} | --%> ${p.member_nick} | <c:choose>
									<c:when test="${p.post_update_date eq null }">
										<fmt:formatDate value="${p.post_reg_date}"
											pattern="yy-MM-dd HH:mm" />
									</c:when>
									<c:otherwise>
										<fmt:formatDate value="${p.post_update_date}"
											pattern="yy-MM-dd HH:mm" />
									</c:otherwise>
								</c:choose>
								| 조회수 ${p.post_hit_count}
							</span>
						</div>
						<br>
						<span class='clubEventContent'>${p.post_content } </span>
					<br>
					<hr style="border: 0; height: 1px; background: #ccc;">
					</div>
				</c:forEach>

		<br>
		<div class="board__bot">
			<div class="board__bot-search">
				<form action="clubEvent.search.do" name="boardSearchForm"
					onsubmit="return boardSearchCheck();">
					<table id="snsSearchArea">
						<tr>
							<td id="ssaTd1"><input id="search" name="search"
								maxlength="10" autocomplete="off" placeholder="검색어를 입력해주세요."></td>
							<td id="ssaTd2"><button class="search_btn search_btn-dark">검색</button></td>
						</tr>
					</table>
				</form>
			</div>

			<div class="board__bot-paging">
				<c:if test="${curPage != 1}">
					<span><a href="clubEvent.page.change?pg=1">[맨처음]</a></span>
					<span><a href="clubEvent.page.change?pg=${curPage - 1}">
							◀이전 </a></span>
				</c:if>
				<c:forEach var="i" begin="1" end="${pageCount}">
					<a href="clubEvent.page.change?pg=${i}"> [${i}] </a>
				</c:forEach>
				<c:if test="${curPage != pageCount}">
					<span> <a href="clubEvent.page.change?pg=${curPage + 1}">
							다음▶ </a></span>
					<span><a href="clubEvent.page.change?pg=${pageCount}">[맨끝]</a></span>
				</c:if>
			</div>
			<br>
			<hr style="width: 1200px;">
		</div>

	</div>
	
	<script>
		function boardSearchCheck() {
			let searchInput = document.boardSearchForm.search;

			if (isEmpty(searchInput)) {
				alert("?");
				searchInput.focus();
				return false;
			}
			return true;
		}
	</script>
	<script>


	// The Slideshow class.
	class Slideshow {
	    constructor(el) {

	        this.DOM = {el: el};

	        this.config = {
	          slideshow: {
	            delay: 3000,
	            pagination: {
	              duration: 3,
	            }
	          }
	        };

	        // Set the slideshow
	        this.init();

	    }
	    init() {

	      var self = this;

	      // Charmed title
	      this.DOM.slideTitle = this.DOM.el.querySelectorAll('.slide-title');
	      this.DOM.slideTitle.forEach((slideTitle) => {
	        charming(slideTitle);
	      });

	      // Set the slider
	      this.slideshow = new Swiper (this.DOM.el, {

	          loop: true,
	          autoplay: {
	            delay: this.config.slideshow.delay,
	            disableOnInteraction: false,
	          },
	          speed: 500,
	          preloadImages: true,
	          updateOnImagesReady: true,

	          // lazy: true,
	          // preloadImages: false,

	          pagination: {
	            el: '.slideshow-pagination',
	            clickable: true,
	            bulletClass: 'slideshow-pagination-item',
	            bulletActiveClass: 'active',
	            clickableClass: 'slideshow-pagination-clickable',
	            modifierClass: 'slideshow-pagination-',
	            renderBullet: function (index, className) {

	              var slideIndex = index,
	                  number = (index <= 8) ? '0' + (slideIndex + 1) : (slideIndex + 1);

	              var paginationItem = '<span class="slideshow-pagination-item">';
	              paginationItem += '<span class="pagination-number">' + number + '</span>';
	              paginationItem = (index <= 8) ? paginationItem + '<span class="pagination-separator"><span class="pagination-separator-loader"></span></span>' : paginationItem;
	              paginationItem += '</span>';

	              return paginationItem;

	            },
	          },

	          // Navigation arrows
	          navigation: {
	            nextEl: '.slideshow-navigation-button.next',
	            prevEl: '.slideshow-navigation-button.prev',
	          },

	          // And if we need scrollbar
	          scrollbar: {
	            el: '.swiper-scrollbar',
	          },

	          on: {
	            init: function() {
	              self.animate('next');
	            },
	          }

	        });

	        // Init/Bind events.
	        this.initEvents();

	    }
	    initEvents() {

	        this.slideshow.on('paginationUpdate', (swiper, paginationEl) => this.animatePagination(swiper, paginationEl));
	        //this.slideshow.on('paginationRender', (swiper, paginationEl) => this.animatePagination());

	        this.slideshow.on('slideNextTransitionStart', () => this.animate('next'));

	        this.slideshow.on('slidePrevTransitionStart', () => this.animate('prev'));

	    }
	    animate(direction = 'next') {

	        // Get the active slide
	        this.DOM.activeSlide = this.DOM.el.querySelector('.swiper-slide-active'),
	        this.DOM.activeSlideImg = this.DOM.activeSlide.querySelector('.slide-image'),
	        this.DOM.activeSlideTitle = this.DOM.activeSlide.querySelector('.slide-title'),
	        this.DOM.activeSlideTitleLetters = this.DOM.activeSlideTitle.querySelectorAll('span');

	        // Reverse if prev
	        this.DOM.activeSlideTitleLetters = direction === "next" ? this.DOM.activeSlideTitleLetters : [].slice.call(this.DOM.activeSlideTitleLetters).reverse();

	        // Get old slide
	        this.DOM.oldSlide = direction === "next" ? this.DOM.el.querySelector('.swiper-slide-prev') : this.DOM.el.querySelector('.swiper-slide-next');
	        if (this.DOM.oldSlide) {
	          // Get parts
	          this.DOM.oldSlideTitle = this.DOM.oldSlide.querySelector('.slide-title'),
	          this.DOM.oldSlideTitleLetters = this.DOM.oldSlideTitle.querySelectorAll('span');
	          // Animate
	          this.DOM.oldSlideTitleLetters.forEach((letter,pos) => {
	            TweenMax.to(letter, .3, {
	              ease: Quart.easeIn,
	              delay: (this.DOM.oldSlideTitleLetters.length-pos-1)*.04,
	              y: '50%',
	              opacity: 0
	            });
	          });
	        }

	        // Animate title
	        this.DOM.activeSlideTitleLetters.forEach((letter,pos) => {
						TweenMax.to(letter, .6, {
							ease: Back.easeOut,
							delay: pos*.05,
							startAt: {y: '50%', opacity: 0},
							y: '0%',
							opacity: 1
						});
					});

	        // Animate background
	        TweenMax.to(this.DOM.activeSlideImg, 1.5, {
	            ease: Expo.easeOut,
	            startAt: {x: direction === 'next' ? 200 : -200},
	            x: 0,
	        });

	        //this.animatePagination()

	    }
	    animatePagination(swiper, paginationEl) {

	      // Animate pagination
	      this.DOM.paginationItemsLoader = paginationEl.querySelectorAll('.pagination-separator-loader');
	      this.DOM.activePaginationItem = paginationEl.querySelector('.slideshow-pagination-item.active');
	      this.DOM.activePaginationItemLoader = this.DOM.activePaginationItem.querySelector('.pagination-separator-loader');

	      console.log(swiper.pagination);
	      // console.log(swiper.activeIndex);

	      // Reset and animate
	        TweenMax.set(this.DOM.paginationItemsLoader, {scaleX: 0});
	        TweenMax.to(this.DOM.activePaginationItemLoader, this.config.slideshow.pagination.duration, {
	          startAt: {scaleX: 0},
	          scaleX: 1,
	        });


	    }

	}

	const slideshow = new Slideshow(document.querySelector('.slideshow'));


  </script>

</body>
</html>
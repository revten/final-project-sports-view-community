<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<div class="watch__container">
		
		<!-- watch 페이지 헤더 -->
		<div class="watch__header">
			<input class="search-bar" placeholder="Search..." type="text">
			<div class="watch__header-title">
				스포츠 열기는<span> 모두와 함께</span>
			</div>
			<div class="move__button-wrapper">
				<button class="action-button" onclick="location.href='withGo.board.go?post_board=11';">
					<span>함께봐요</span>
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						viewBox="0 0 24 24" fill="none" stroke="currentColor"
						stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
						class="feather feather-filter">
								<polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" /></svg>
				</button>
			</div>

		</div>


		<!-- 리뷰 : top 슬라이더 -->
		<div class="review__slide">
			<div class="review js-flickity"
				data-flickity-options='{ "wrapAround": true }'>

				<!-- 야구 -->
				<div class="review__cell">
					<div class="review__img">
						<img
							src="https://images-na.ssl-images-amazon.com/images/I/81WcnNQ-TBL.jpg"
							alt="" class="review__photo">
					</div>
					<div class="review__content">
						<div class="review__title">야구 리뷰 제목</div>
						<div class="review__member">by 김태형</div>
						<div class="rate">
							<fieldset class="rating">
								<input type="checkbox" id="star5" name="rating" value="5" /> <label
									class="full" for="star5"></label> <input type="checkbox"
									id="star4" name="rating" value="4" /> <label class="full"
									for="star4"></label> <input type="checkbox" id="star3"
									name="rating" value="3" /> <label class="full" for="star3"></label>
								<input type="checkbox" id="star2" name="rating" value="2" /> <label
									class="full" for="star2"></label> <input type="checkbox"
									id="star1" name="rating" value="1" /> <label class="full"
									for="star1"></label>
							</fieldset>
							<span class="review__voters">1.987 voters</span>
						</div>
						<div class="review__sum">Readers of all ages and walks of
							life have drawn inspiration and empowerment from Elizabeth
							Gilbert’s books for years.</div>
						<div class="review__see">리뷰보기</div>
					</div>
				</div>

				<!-- 축구 -->
				<div class="review__cell">
					<div class="review__img">
						<img
							src="https://i.pinimg.com/originals/a8/b9/ff/a8b9ff74ed0f3efd97e09a7a0447f892.jpg"
							alt="" class="review__photo">
					</div>
					<div class="review__content">
						<div class="review__title">축구 리뷰 제목</div>
						<div class="review__member">by 임형규</div>
						<div class="rate">
							<fieldset class="rating blue">
								<input type="checkbox" id="star6" name="rating" value="5" /> <label
									class="full1" for="star6"></label> <input type="checkbox"
									id="star7" name="rating" value="4" /> <label class="full1"
									for="star7"></label> <input type="checkbox" id="star8"
									name="rating" value="3" /> <label class="full1" for="star8"></label>
								<input type="checkbox" id="star9" name="rating" value="2" /> <label
									class="full1" for="star9"></label> <input type="checkbox"
									id="star10" name="rating" value="1" /> <label class="full1"
									for="star10"></label>
							</fieldset>
							<span class="review__voters">1.987 voters</span>
						</div>
						<div class="review__sum">The hunt for each splinter of
							Paul's soul sends Marguerite racing through a war-torn San
							Francisco.</div>
						<div class="review__see review-blue">리뷰보기</div>
					</div>
				</div>

				<!-- 농구 -->
				<div class="review__cell">
					<div class="review__img">
						<img
							src="https://images-na.ssl-images-amazon.com/images/I/81af+MCATTL.jpg"
							alt="" class="review__photo">
					</div>
					<div class="review__content">
						<div class="review__title">농구 리뷰 제목</div>
						<div class="review__member">by 정 권</div>
						<div class="rate">
							<fieldset class="rating yellow">
								<input type="checkbox" id="star16" name="rating" value="5" /> <label
									class="full" for="star16"></label> <input type="checkbox"
									id="star17" name="rating" value="4" /> <label class="full"
									for="star17"></label> <input type="checkbox" id="star18"
									name="rating" value="3" /> <label class="full" for="star18"></label>
								<input type="checkbox" id="star19" name="rating" value="2" /> <label
									class="full" for="star19"></label> <input type="checkbox"
									id="star20" name="rating" value="1" /> <label class="full"
									for="star20"></label>
							</fieldset>
							<span class="review__voters">1.987 voters</span>
						</div>
						<div class="review__sum">The Great Gatsby, F. Scott
							Fitzgerald’s third book, stands as the supreme achievement of his
							career.</div>
						<div class="review__see review-purple">리뷰보기</div>
					</div>
				</div>

				<!-- 배구 -->
				<div class="review__cell">
					<div class="review__img">
						<img
							src="https://images-na.ssl-images-amazon.com/images/I/81UWB7oUZ0L.jpg"
							alt="" class="review__photo">
					</div>
					<div class="review__content">
						<div class="review__title">배구 리뷰 제목</div>
						<div class="review__member">by 송준우</div>
						<div class="rate">
							<fieldset class="rating dark-purp">
								<input type="checkbox" id="star21" name="rating" value="5" /> <label
									class="full" for="star21"></label> <input type="checkbox"
									id="star22" name="rating" value="4" /> <label class="full"
									for="star22"></label> <input type="checkbox" id="star23"
									name="rating" value="3" /> <label class="full" for="star23"></label>
								<input type="checkbox" id="star24" name="rating" value="2" /> <label
									class="full" for="star24"></label> <input type="checkbox"
									id="star25" name="rating" value="1" /> <label class="full"
									for="star25"></label>
							</fieldset>
							<span class="review__voters">1.987 voters</span>
						</div>
						<div class="review__sum">Louisa Clark is no longer just an
							ordinary girl living an ordinary life. After the transformative
							six months spent.</div>
						<div class="review__see review-yellow">리뷰보기</div>
					</div>
				</div>
			</div>
		</div>


		<!-- 리뷰 : bot -->
		<div class="watch__wrapper">

			<!-- 리뷰 : bot left -->
			<div class="reviews-of">

				<!-- 리뷰 : bot left top -->
				<div class="week1">

					<div class="review__fan__title">Fan of the week</div>

					<div class="review__fan">
						<img
							src="https://images.unsplash.com/photo-1586297098710-0382a496c814?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1650&q=80"
							alt="" class="review__fan__img">
						<div class="review__fan__member">정 권</div>
					</div>
				</div>

				<!-- 리뷰 : bot left bot -->
				<div class="week1 week2">

					<div class="review__fan__title">Review of the week</div>
					<div class="review__best">
						<img
							src="https://images-na.ssl-images-amazon.com/images/I/A1kNdYXw0GL.jpg"
							alt="" class="review__best__img">
						<div class="review__best__content">
							<div class="review__best__title">Disappearing Earth</div>
							<div class="review__best__member">by 임형규</div>
						</div>
					</div>

				</div>
				<div class="overlay"></div>
			</div>


			<!-- 리뷰 : bot right -->
			<div class="review__posts__wrapper">

				<!-- 리뷰 : bot right top -->
				<div class="review__posts__menu">
					<div class="review__posts__genre">Stadium Reviews</div>
					<div class="review__sports__types">
						<a href="#" class="review__sports__type active"> All Sports</a> <a
							href="#" class="review__sports__type"> Baseball</a> <a href="#"
							class="review__sports__type"> Soccer</a> <a href="#"
							class="review__sports__type"> Basketbll</a> <a href="#"
							class="review__sports__type"> Volleyball</a>
					</div>
				</div>

				<!-- 리뷰 : bot right bot -->
				<div class="review__posts">

					<div class="review__post">
						<div class="review__post__content-wrapper">
							<img
								src="https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2019%2F07%2Fchances-are-1-2000.jpg&q=85"
								alt="" class=review__post__img>
							<div class="review__post__content">
								<div class="review__post__title">Changes Are</div>
								<div class="review__post__by">by Richard Russo</div>
								<div class="rate">
									<fieldset class="rating book-rate">
										<input type="checkbox" id="star-c1" name="rating" value="5">
										<label class="full" for="star-c1"></label> <input
											type="checkbox" id="star-c2" name="rating" value="4">
										<label class="full" for="star-c2"></label> <input
											type="checkbox" id="star-c3" name="rating" value="3">
										<label class="full" for="star-c3"></label> <input
											type="checkbox" id="star-c4" name="rating" value="2">
										<label class="full" for="star-c4"></label> <input
											type="checkbox" id="star-c5" name="rating" value="1">
										<label class="full" for="star-c5"></label>
									</fieldset>
									<span class="review__voters card-vote">1.987 voters</span>
								</div>
								<div class="review__sum card-sum">Readers of all ages and
									walks of life have drawn inspiration and empowerment from
									Elizabeth Gilbert’s books for years.</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		/*=============== 스크롤 나타나는 효과 ===============*/
		const srWatch = ScrollReveal({ /* srSTM으로 한것은, sr이 메인에서 쓰여서. STM은 stadiumMain */
			origin : 'top',
			distance : '60px',
			duration : 2500,
			delay : 400
		//reset: true, // 애니메이션은 반복
		})

		srWatch.reveal(`.watch__header`, {
			origin : 'top'
		});
		srWatch.reveal(`.review__slide`, {
			origin : 'left'
		});
		srWatch.reveal(`.watch__wrapper`, {
			origin : 'right'
		});
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRIPPLE: Review</title>

</head>

<body>
	<div class="review__bg-1" style="float: right; position: absolute; top: 400px; left: 80%;">
		<img src="resources/files/backgroundImg/review5.png">
	</div>
	<div class="watch__container">

		<!-- watch 페이지 헤더 -->
		<div class="watch__header">
			<div class="watch__header-title">
				<a href="review.board.go?post_board=12" class="nav__link"
					style="font-size: 15px">&nbsp;&nbsp;&nbsp;&nbsp;REVIEW</a>
			</div>
			<div class="watch__header-title">
				스포츠 열기는<span> 모두와 함께</span>
			</div>
			<div class="move__button-wrapper">
				<c:choose>
					<c:when test="${sessionScope.loginAccount ne null}">
						<button class="action-button"
							onclick="location.href='review.reg.go?post_board=${param.post_board}'">
							새글쓰기</button>
					</c:when>
					<c:otherwise>
						<a href="review.reg.go?post_board=${param.post_board}"
							onclick="alert('로그인하세요')">새글쓰기</a>
					</c:otherwise>
				</c:choose>
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
							src="https://images.pexels.com/photos/5184705/pexels-photo-5184705.jpeg?auto=compress&cs=tinysrgb&w=600"
							alt="" class="review__photo">
					</div>
					<div class="review__content">
						<div class="review__title">야구 리뷰 제목</div>
						<div class="review__member">by 김태형</div>
						<div class="rate">
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
							src="https://images.pexels.com/photos/5246966/pexels-photo-5246966.jpeg?auto=compress&cs=tinysrgb&w=600
"
							alt="" class="review__photo">
					</div>
					<div class="review__content">
						<div class="review__title">축구 리뷰 제목</div>
						<div class="review__member">by 임형규</div>
						<div class="rate">
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
							src="https://images.pexels.com/photos/159611/basketball-player-game-sport-159611.jpeg?auto=compress&cs=tinysrgb&w=600"
							alt="" class="review__photo">
					</div>
					<div class="review__content">
						<div class="review__title">농구 리뷰 제목</div>
						<div class="review__member">by 정 권</div>
						<div class="rate">
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
							src="https://images.pexels.com/photos/6203676/pexels-photo-6203676.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
							alt="" class="review__photo">
					</div>
					<div class="review__content">
						<div class="review__title">배구 리뷰 제목</div>
						<div class="review__member">by 송준우</div>
						<div class="rate">
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
			<div class="review__posts__wrapper">

				<!-- 리뷰 : bot right top -->
				<div class="review__posts__menu">
					<div class="review__posts__genre">
						<!-- 왼쪽 검색바 -->
						<form action="review.search.do" name="boardSearchForm"
							onsubmit="return boardSearchCheck();">
							<input type="hidden" name="post_board"
								value="${param.post_board}">
							<div id="snsSearchArea">
								<input class="search-bar" name="search" type="search"
									maxlength="10" autocomplete="off" placeholder="검색">
							</div>
						</form>
					</div>
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
					<c:forEach var="p" items="${posts }">
						<div class="review__post">
							<div class="review__post__content-wrapper">
								<img src="resources/ckeditor/fileUpload/${p.post_img}" alt=""
									class=review__post__img>
								<div class="review__post__content">
									<div class="review__post__title">
										<a
											href="review.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">${p.post_title }
											[${p.post_reply_count}]</a>
									</div>
									<div class="review__post__by">by ${p.member_nick}</div>
									<div class="rate">
										<span class="review__voters card-vote">${p.post_like_count}
											추천</span>
									</div>
									<div class="review__sum card-sum">Readers of all ages and
										walks of life have drawn inspiration and empowerment from
										Elizabeth Gilbert’s books for years.</div>
									<!-- ck에디터 안에 이미지주소도 들어있어서 이미지가 또 나온다 -->
								</div>
							</div>
						</div>

					</c:forEach>

					<!-- 복사해서 샘플 넣기 -->
					<div class="review__post">
						<div class="review__post__content-wrapper">
							<img
								src="https://mblogthumb-phinf.pstatic.net/MjAxOTA1MDlfMTQx/MDAxNTU3MzkwMjAxOTY3.g6XFTOlHku4f5I3sCVhoJ8HgjbtF1_gi_56OccLy0twg.a1i6ueEWdwMjMyhntYnNutyVa3QNYHNsV6ZwSCrHo9Mg.JPEG.apsl_2004/22.jpg?type=w800"
								alt="" class=review__post__img>
							<div class="review__post__content">
								<div class="review__post__title">대한민국 vs 콜롬비아</div>
								<div class="review__post__by">by 인하대학교 아태물류학부</div>
								<div class="rate">
									<span class="review__voters card-vote">1.987 voters</span>
								</div>
								<div class="review__sum card-sum">지난 3월 26일, SIOL은 국가대표 친선경기 콜롬비아전을 직관하고 왔습니다.
									서울월드컵경기장에서 열린 경기를 관람하기 위해 수업이 끝나자마자 전철을 타고 서울로 이동했습니다.</div>
							</div>
						</div>
					</div>
					<div class="review__post">
						<div class="review__post__content-wrapper">
							<img
								src="https://cdn.pixabay.com/photo/2019/09/06/02/52/football-4455306__340.jpg"
								alt="" class=review__post__img>
							<div class="review__post__content">
								<div class="review__post__title">축구선수</div>
								<div class="review__post__by">by 어느 선수</div>
								<div class="rate">
									<span class="review__voters card-vote">2.998 voters</span>
								</div>
								<div class="review__sum card-sum">저희 SIOL은 축구를 좋아하는 학부생들의 소모임입니다.
									실력에 상관없이 축구를 좋아하는 누구나 즐겁게 축구를 즐길 수 있는 곳입니다.
									주 1회 정기모임을 통해 축구나 풋살을 즐기지만, 이외에도 다양한 행사를 통해 선수뿐만 아니라 매니저들도 함께 즐길 수 있습니다.</div>
							</div>
						</div>
					</div>
					<div class="review__post">
						<div class="review__post__content-wrapper">
							<img
								src="https://mblogthumb-phinf.pstatic.net/MjAxOTA1MDlfMjYg/MDAxNTU3MzkwMjQ3NjQw.TSQAXwyxsSWRG2XaR3vYGG_MwFkt8DA_sk0lJ94MLoEg.QhROcTuuzoxuipAlq_Np0-y8_KPZ9VeB4d1Z1_fmOjEg.JPEG.apsl_2004/33.jpg?type=w800"
								alt="" class=review__post__img>
							<div class="review__post__content">
								<div class="review__post__title">직관 갔다옴</div>
								<div class="review__post__by">by 사람 5인</div>
								<div class="rate">
									<span class="review__voters card-vote">2.778 voters</span>
								</div>
								<div class="review__sum card-sum">직관 갔다 왔습니다.
								티켓 인증 올림 ㅋ</div>
							</div>
						</div>
					</div>
					<div class="review__post">
						<div class="review__post__content-wrapper">
							<img
								src="https://mblogthumb-phinf.pstatic.net/MjAxOTA1MDlfMTcw/MDAxNTU3MzkwMzI0MjIx.TgyA8T2HIm-onEILykZqM3V88RvsiO5G-TdLw8UaW8kg.0Nuazo3AlAw4He55zHaOYY4FeQAEi9sA6OXutyE6I6sg.JPEG.apsl_2004/44.jpg?type=w800"
								alt="" class=review__post__img>
							<div class="review__post__content">
								<div class="review__post__title">경기장의 응원 열기</div>
								<div class="review__post__by">by 무수히 많은 관객</div>
								<div class="rate">
									<span class="review__voters card-vote">3.5179 voters</span>
								</div>
								<div class="review__sum card-sum">사진으로만 봐도 당시의 응원 열기가 느껴지시나요?
									이 경기에는 무려 63,488명의 관중이 모였으며, 국가대표 A매치 6경기 연속 매진이었다고 합니다.
									최근 국가대표 축구에 대한 관심이 얼마나 커졌는지 알 수 있었습니다!</div>
							</div>
						</div>
					</div>
					<div class="review__post">
						<div class="review__post__content-wrapper">
							<img
								src="https://blog.kakaocdn.net/dn/lnxWZ/btrOigASzde/JdOBKhJCMyR14IryiKQlkk/img.jpg"
								alt="" class=review__post__img>
							<div class="review__post__content">
								<div class="review__post__title">안양 종합운동장</div>
								<div class="review__post__by">매우 크진 않음</div>
								<div class="rate">
									<span class="review__voters card-vote">2.178 voters</span>
								</div>
								<div class="review__sum card-sum">안양 종합운동장이 매우 크진 않았기에, 어느 자리에 앉더라도 선수들 모습이 잘 보였습니다.
(서포터석이 아닌 일반석은 어디든 OK)</div>
							</div>
						</div>
					</div>
					<div class="review__post">
						<div class="review__post__content-wrapper">
							<img
								src="https://blog.kakaocdn.net/dn/PI0kP/btrOkSflFoW/UtgkVagJUSp1xvT9CZ2oj1/img.jpg"
								alt="" class=review__post__img>
							<div class="review__post__content">
								<div class="review__post__title">경기장 주차장</div>
								<div class="review__post__by">by 주차</div>
								<div class="rate">
									<span class="review__voters card-vote">2.11 voters</span>
								</div>
								<div class="review__sum card-sum">주차비는 5시간 기준 2천원으로 저렴했습니다.</div>
							</div>
						</div>
					</div>

				</div>
					


				<!-- 페이징 -->
				<div class="board__bot-paging">
					<c:if test="${curPage != 1}">
						<span><span style="cursor: pointer"
							onclick="location.href='review.page.change?pg=1&post_board=${param.post_board }'">[맨처음]</span></span>
						<span><span style="cursor: pointer"
							onclick="location.href='review.page.change?pg=${curPage - 1}&post_board=${param.post_board }'">
								◀이전 </span></span>
					</c:if>
					<c:forEach var="i" begin="1" end="${pageCount}">
						<span style="cursor: pointer"
							onclick="location.href='review.page.change?pg=${i}&post_board=${param.post_board }'">
							[${i}] </span>
					</c:forEach>
					<c:if test="${curPage != pageCount}">
						<span> <span style="cursor: pointer"
							onclick="location.href='review.page.change?pg=${curPage + 1}&post_board=${param.post_board }'">
								다음▶ </span></span>
						<span><span style="cursor: pointer"
							onclick="location.href='review.page.change?pg=${pageCount}&post_board=${param.post_board }'">[맨끝]</span></span>
					</c:if>
				</div>
			</div>

		</div>
	</div>

	<script>
		/*=============== 스크롤 나타나는 효과 ===============*/
		const srReview = ScrollReveal({ 
			origin : 'right',
			distance : '290px',
			duration : 2400,
			delay : 200
		//reset: true, // 애니메이션은 반복
		})
		
		srReview.reveal(`.review__bg-1`, {
			origin : 'right'
		});
		
		srReview.reveal(`.watch__container`, {
			origin : 'right'
		});

		srReview.reveal(`.watch__header`, {
			origin : 'right'
		});
		srReview.reveal(`.review__slide, .watch__wrapper`, {
			origin : 'right'
		});
	</script>
</body>
</html>
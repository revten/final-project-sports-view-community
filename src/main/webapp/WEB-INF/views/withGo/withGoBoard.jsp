<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRIPPLE: WithGo</title>
</head>

<body>
	<div class="withGo__bg-leftTop"
		style="float: left; position: absolute; top: 300px; left: -9%;">
		<img src="resources/files/backgroundImg/with1.png">
	</div>

	<div class="withGo__bg-rightTop"
		style="float: right; position: absolute; top: -10px; left: 77%;">
		<img src="resources/files/backgroundImg/with2.png">
	</div>

	<div class="withGo__container">
		<div class="withGo__content">
			<!-- 2번줄 헤더 -->
			<div class="withGo__header" style="margin-bottom: 10px;">
				<!-- 왼쪽 검색바 -->
				<form action="withGo.search.do" name="boardSearchForm"
					onsubmit="return boardSearchCheck();">
					<input type="hidden" name="post_board" value="${param.post_board}">
					<div id="snsSearchArea">
						<input class="withGo__search-bar" name="search" type="search"
							maxlength="10" autocomplete="off" placeholder="검색">
					</div>
				</form>
				<div>
					<a href="withGo.board.go?post_board=11" class="nav__link ">WITH
						GO</a>
				</div>

				<!-- 이동버튼 -->
				<div class="move__button-wrapper">
					<c:choose>
						<c:when test="${sessionScope.loginAccount ne null}">
							<button class="action-button"
								onclick="location.href='withGo.reg.go?post_board=${param.post_board}'">
								새글쓰기</button>
						</c:when>
						<c:otherwise>
							<a href="withGo.reg.go?post_board=${param.post_board}"
								onclick="alert('로그인하세요')">새글쓰기</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<!-- 게시글 테이블 시작 -->
			<div class="products-area-wrapper gridView">
				<!-- forEach문으로 돌릴 구간, 샘플을 위해서 일단 게시글 4개정도 남김, function 할땐 하나만 하면됨 -->
				<!-- resources/ckeditor/fileUpload/ -->
				<%-- <c:forEach var="p" items="${posts }">
					<div class="products-row">
						<button class="cell-more-button">
							<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
						</button>
						<div class="product-cell image">
							<img src="resources/ckeditor/fileUpload/${p.post_img}"> <span><a
								href="withGo.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">${p.post_title }
									[${p.post_reply_count}]</a></span>
						</div>

						<!-- 나중에 팀 선택, 스포츠 선택을 추가해야함 -->
						<div class="product-cell sales">
							<span class="cell-label">닉네임:</span>${p.member_nick}
						</div>
						<div class="product-cell price">
							<span class="cell-label">등록일:</span>
							<c:choose>
								<c:when test="${p.post_update_date eq null }">
									<fmt:formatDate value="${p.post_reg_date}"
										pattern="yy-MM-dd HH:mm" />
								</c:when>
								<c:otherwise>
						수정 <fmt:formatDate value="${p.post_update_date}"
										pattern="yy-MM-dd HH:mm" />
								</c:otherwise>
							</c:choose>
						</div>
						<div class="product-cell price">
							<span class="cell-label">조회수:</span>${p.post_hit_count}
						</div>
					</div>
				</c:forEach> --%>
				
				<!-- 복사해서 샘플 넣기 -->
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img src="https://res.klook.com/image/upload/c_fill,w_843,h_474/q_80/w_80,x_15,y_15,g_south_west,l_Klook_water_br_trans_yhcmh3/activities/xhfpqiep6z1z5fcoiwen.webp"> <span><a
							href="withGo.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">같이 응원 갈사람
								</a></span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">닉네임:</span>토트넘팬
					</div>
					<div class="product-cell price">
						<span class="cell-label">등록일:</span>2023-01-31 3:30
					</div>
					<div class="product-cell price">
						<span class="cell-label">조회수:</span>3
					</div>
				</div>
				
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img src="data:image/jpeg;base64,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"> <span><a
							href="withGo.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">오빠랑 같이 응원갈래?
								</a></span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">닉네임:</span>메시짱짱123
					</div>
					<div class="product-cell price">
						<span class="cell-label">등록일:</span>2023-01-31 3:31
					</div>
					<div class="product-cell price">
						<span class="cell-label">조회수:</span>7
					</div>
				</div>
				
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img src="https://images.chosun.com/resizer/WPjSD1gKAN2606nVBIPn1QnVQbU=/616x0/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/JDH4F64PPNIOBKMZ5MWN3XQFZU.jpg"> <span><a
							href="withGo.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">물이 없는곳에서 이정도의 수둔을
								</a></span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">닉네임:</span>한반두
					</div>
					<div class="product-cell price">
						<span class="cell-label">등록일:</span>2023-01-31 3:32
					</div>
					<div class="product-cell price">
						<span class="cell-label">조회수:</span>7
					</div>
				</div>
				
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img src="data:image/jpeg;base64,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"> <span><a
							href="withGo.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">같이 야구보러가자
								</a></span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">닉네임:</span>빠따
					</div>
					<div class="product-cell price">
						<span class="cell-label">등록일:</span>2023-01-31 3:34
					</div>
					<div class="product-cell price">
						<span class="cell-label">조회수:</span>2
					</div>
				</div>
				
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Jordan_by_Lipofsky_16577.jpg/240px-Jordan_by_Lipofsky_16577.jpg"> <span><a
							href="withGo.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">농구보러 갈사람
								</a></span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">닉네임:</span>덩크왕김통키
					</div>
					<div class="product-cell price">
						<span class="cell-label">등록일:</span>2023-01-31 3:38
					</div>
					<div class="product-cell price">
						<span class="cell-label">조회수:</span>4
					</div>
				</div>
				
				<div class="products-row">
					<button class="cell-more-button">
						<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-more-vertical">
							<circle cx="12" cy="12" r="1" />
							<circle cx="12" cy="5" r="1" />
							<circle cx="12" cy="19" r="1" /></svg>
					</button>
					<div class="product-cell image">
						<img src="https://img.olympicchannel.com/images/image/private/f_auto/t_s_pog_staticContent_hero_xl_2x/primary/zhqlj6x592eudgh4frqz"> <span><a
							href="withGo.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">배구 보러 같이가요
								</a></span>
					</div>
					<div class="product-cell sales">
						<span class="cell-label">닉네임:</span>스파이크1
					</div>
					<div class="product-cell price">
						<span class="cell-label">등록일:</span>2023-01-31 3:39
					</div>
					<div class="product-cell price">
						<span class="cell-label">조회수:</span>1
					</div>
				</div>
			</div>

			<!-- 페이징 -->
			<div class="board__bot-paging">
				<c:if test="${curPage != 1}">
					<span><span style="cursor: pointer"
						onclick="location.href='withGo.page.change?pg=1&post_board=${param.post_board }'">[맨처음]</span></span>
					<span><span style="cursor: pointer"
						onclick="location.href='withGo.page.change?pg=${curPage - 1}&post_board=${param.post_board }'">
							◀이전 </span></span>
				</c:if>
				<c:forEach var="i" begin="1" end="${pageCount}">
					<span style="cursor: pointer"
						onclick="location.href='withGo.page.change?pg=${i}&post_board=${param.post_board }'">
						[${i}] </span>
				</c:forEach>
				<c:if test="${curPage != pageCount}">
					<span> <span style="cursor: pointer"
						onclick="location.href='withGo.page.change?pg=${curPage + 1}&post_board=${param.post_board }'">
							다음▶ </span></span>
					<span><span style="cursor: pointer"
						onclick="location.href='withGo.page.change?pg=${pageCount}&post_board=${param.post_board }'">[맨끝]</span></span>
				</c:if>
			</div>
		</div>
	</div>
	
	<script>
		/*=============== 스크롤 나타나는 효과 ===============*/
		const srWatch = ScrollReveal({
			  origin: 'right',
			  distance: '290px',
			  duration: 2400,
			  delay: 200
		//reset: true, // 애니메이션은 반복
		})

		srWatch.reveal(`.withGo__bg-rightTop`, {
			origin : 'right'
		});

		srWatch.reveal(`.withGo__bg-leftTop`, {
			origin : 'right'
		});

		srWatch.reveal(`.withGo__header`, {
			origin : 'right'
		});
		srWatch.reveal(`.withGo__container`, {
			origin : 'right'
		});
	</script>
</body>
</html>
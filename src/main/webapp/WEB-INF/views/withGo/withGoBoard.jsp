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
				<c:forEach var="p" items="${posts }">
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
				</c:forEach>
				
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
			</div>


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
			origin : 'top',
			distance : '90px',
			duration : 2500,
			delay : 400
		//reset: true, // 애니메이션은 반복
		})

		srWatch.reveal(`.withGo__bg-rightTop`, {
			origin : 'top'
		});

		srWatch.reveal(`.withGo__bg-leftTop`, {
			origin : 'left'
		});

		srWatch.reveal(`.withGo__header`, {
			origin : 'bottom'
		});
		srWatch.reveal(`.withGo__container`, {
			origin : 'left'
		});
	</script>
</body>
</html>
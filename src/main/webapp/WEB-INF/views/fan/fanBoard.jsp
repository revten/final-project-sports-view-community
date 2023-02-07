<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRIPPLE: Community</title>
<!--=============== [JS]===============-->

</head>
<body>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 my-3"> <!-- 부트스트랩 클래스명이라 main은 남겨야 할듯 -->
	<div class="fan_bg-leftTop"
		style="float: left; position: absolute; left: -9%;">
		<img src="resources/files/backgroundImg/review1.png">
	</div>
	<div class="fan_bg-RightTop"
		style="float: right; position: absolute; top: 400px; left: 86%;">
		<img src="resources/files/backgroundImg/review3.png">
	</div>
	<div style="float: right; position: absolute; top: 800px; left: 66%;">
		<img src="resources/files/backgroundImg/review2.png">
	</div>
	<div style="float: left; position: absolute; top: 900px; left: -9%;">
		<img src="resources/files/backgroundImg/fan1.png">
	</div>
	<div class="container-field">
		<div class="board-main">
			<!--==================== fan__best 부분 - 종목별 베스트 (각 게시판별로 CRUD별로 존재해야)  ====================-->
			<div class="card-list">
				<!-- 맨위에 fan__best 부분 - 상위글 보여주는 부분 -->
				<div class="card blue" style="cursor: pointer"
					onclick="location.href='fan.board.go?post_board=21'">
					<div class="title">
						<span>야구 게시판</span>
					</div>
					<i class="zmdi zmdi-upload"></i>
					<div class="value">KBO</div>
					<div class="stat">It ain't over till it's over.</div>
				</div>
				<div class="card green" style="cursor: pointer"
					onclick="location.href='fan.board.go?post_board=22'">
					<div class="title">
						<span>축구 게시판</span>
					</div>
					<i class="zmdi zmdi-upload"></i>
					<div class="value">KFA</div>
					<div class="stat">No sweat, no sweet!</div>
				</div>
				<div class="card orange" style="cursor: pointer"
					onclick="location.href='fan.board.go?post_board=23'">
					<div class="title">
						<span>농구 게시판</span>
					</div>
					<i class="zmdi zmdi-download"></i>
					<div class="value">KBL</div>
					<div class="stat">make each day</div>
				</div>
				<div class="card red" style="cursor: pointer"
					onclick="location.href='fan.board.go?post_board=24'">
					<div class="title">
						<span>배구 게시판</span>
					</div>
					<i class="zmdi zmdi-download"></i>
					<div class="value">KOVO</div>
					<div class="stat">Nothing Better</div>
				</div>
			</div>
		</div>
		<!--==================== 게시판 ====================-->
		<div class="app-container">
			<!-- 맨위의 게시판 제목 -->
			<div class="app-content">
				<!-- 1번줄 헤더 -->
				<div class="app-content-header">
					<!-- 왼쪽게시판 제목 -->
					<h1 class="app-content-headerText">${board_name }게시판</h1>
				</div>
				<!-- 2번줄 헤더 -->
				<div class="app-content-actions">
					<form action="fan.search.do" name="boardSearchForm"
						onsubmit="return boardSearchCheck();">
						<input type="hidden" name="post_board" value="${param.post_board}">
						<div id="snsSearchArea">
							<input class="search-bar" name="search" type="search"
								maxlength="10" autocomplete="off" placeholder="검색">
						</div>
					</form>
					<!-- 검색바 오른쪽 메뉴들 -->
					<div class="app-content-actions-wrapper">
						<!-- 필터버튼 -->
						<div class="filter-button-wrapper">
							<c:choose>
								<c:when test="${sessionScope.loginAccount ne null}">
									<button class="action-button"
										onclick="location.href='fan.reg.go?post_board=${param.post_board}'">
										새글쓰기</button>
								</c:when>
								<c:otherwise>
									<a href="fan.reg.go?post_board=${param.post_board}"
										onclick="alert('로그인하세요')">새글쓰기</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<!-- 게시글 테이블 시작 -->
				<div class="board__wrapper tableView">
					<!-- 게시판 칼럼 (제목, 닉네임, 조회수 등등)-->
					<div class="board__header">
						<div class="board__cell num">글 번호</div>
						<div class="board__cell category">카테고리</div>
						<div class="board__cell post_title">제목</div>
						<div class="board__cell reg_date">등록일</div>
						<div class="board__cell nick">닉네임</div>
						<div class="board__cell view_count">조회수</div>
					</div>
					<!-- forEach문으로 돌릴 구간, 샘플을 위해서 일단 게시글 4개정도 남김, function 할땐 하나만 하면됨 -->
					<c:forEach var="p" items="${posts }">
						<div class="board__row">
							<div class="board__cell num">${p.post_id}</div>
							<div class="board__cell category">${post_category}</div>
							<div class="board__cell post_title">
								<span style="cursor: pointer"
									onclick="location.href='fan.detail.go?post_id=${p.post_id }&post_member=${p.post_member}'">${p.post_title }
									<span>[${p.post_reply_count}]</span>
								</span>
							</div>
							<div class="board__cell reg_date">
								<c:choose>
									<c:when test="${p.post_update_date eq null }">
										<fmt:formatDate value="${p.post_reg_date}"
											pattern="yy-MM-dd HH:mm" />
									</c:when>
									<c:otherwise>
										<fmt:formatDate value="${p.post_update_date}"
											pattern="yy-MM-dd HH:mm" />
									</c:otherwise>
								</c:choose>
							</div>
							<div class="board__cell nick">${p.member_nick}</div>
							<div class="board__cell view_count">${p.post_hit_count}</div>
						</div>
						<hr style="background: #f0f0f0; height: 0.5px; border: 0;">
					</c:forEach>
				</div>
				<div class="board__bot-paging">
					<c:if test="${curPage != 1}">
						<span><span style="cursor: pointer"
							onclick="location.href='fan.page.change?pg=1&post_board=${param.post_board }'">[맨처음]</span></span>
						<span><span style="cursor: pointer"
							onclick="location.href='fan.page.change?pg=${curPage - 1}&post_board=${param.post_board }'">
								◀이전 </span></span>
					</c:if>
					<c:forEach var="i" begin="1" end="${pageCount}">
						<span style="cursor: pointer"
							onclick="location.href='fan.page.change?pg=${i}&post_board=${param.post_board }'">
							[${i}] </span>
					</c:forEach>
					<c:if test="${curPage != pageCount}">
						<span> <span style="cursor: pointer"
							onclick="location.href='fan.page.change?pg=${curPage + 1}&post_board=${param.post_board }'">
								다음▶ </span></span>
						<span><span style="cursor: pointer"
							onclick="location.href='fan.page.change?pg=${pageCount}&post_board=${param.post_board }'">[맨끝]</span></span>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	</main>
	<script>
		const srFan = ScrollReveal({
			origin : 'right',
			distance : '290px',
			duration : 2400,
			delay : 200
		//reset: true, // Animations repeat
		})
		srFan.reveal(`.container-field`, {
			origin : 'right'
		});
		srFan.reveal(`.fan_bg-leftTop`, {
			origin : 'left'
		});
		srFan.reveal(`.fan_bg-RightTop`, {
			origin : 'right'
		});
		srFan.reveal(`.app-container`, {
			origin : 'right'
		});
	</script>


</body>
</html>
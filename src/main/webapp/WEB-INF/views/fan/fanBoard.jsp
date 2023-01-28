<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/fan/fan.css">
<%-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">--%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/jquery.selectric/1.10.1/selectric.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
<!--=============== [JS]===============-->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.selectric/1.10.1/jquery.selectric.min.js"></script>
<script src="resources/js/fan/fanBoard.js"></script>
</head>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>


	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 my-3"> <!-- 부트스트랩 클래스명이라 main은 남겨야 할듯 -->
	<div class="container-field">

		<div class="board-main">
			<!--==================== fan__best 부분 - 종목별 베스트 (각 게시판별로 CRUD별로 존재해야)  ====================-->
			<div class="card-list">
				<!-- 맨위에 fan__best 부분 - 상위글 보여주는 부분 -->
				<div class="card blue">
					<div class="title">
						<a href="fan.board.go?post_board=21">야구 게시판</a>
					</div>
					<i class="zmdi zmdi-upload"></i>
					<div class="value">89</div>
					<div class="stat">
						<b>13</b>% increase
					</div>
				</div>

				<div class="card green">
					<div class="title">
						<a href="fan.board.go?post_board=22">축구 게시판</a>
					</div>
					<i class="zmdi zmdi-upload"></i>
					<div class="value">5,990</div>
					<div class="stat">
						<b>4</b>% increase
					</div>
				</div>

				<div class="card orange">
					<div class="title">
						<a href="fan.board.go?post_board=23">농구 게시판</a>
					</div>
					<i class="zmdi zmdi-download"></i>
					<div class="value">$80,990</div>
					<div class="stat">
						<b>13</b>% decrease
					</div>
				</div>

				<div class="card red">
					<div class="title">
						<a href="fan.board.go?post_board=24">배구 게시판</a>
					</div>
					<i class="zmdi zmdi-download"></i>
					<div class="value">3</div>
					<div class="stat">
						<b>13</b>% decrease
					</div>
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
					<h1 class="app-content-headerText">Board</h1>
				</div>

				<!-- 2번줄 헤더 -->
				<div class="app-content-actions">

					<!-- 왼쪽 검색바 -->
					<input class="search-bar" placeholder="Search..." type="text">

					<!-- 검색바 오른쪽 메뉴들 -->
					<div class="app-content-actions-wrapper">

						<!-- 필터버튼 -->
						<div class="filter-button-wrapper">
							<button class="action-button filter jsFilter">
								<span>Filter</span>
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-filter">
								<polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" /></svg>
							</button>
							<div class="filter-menu">
								<label>Category</label> <select>
									<option>All Categories</option>
									<option>Furniture</option>
									<option>Decoration</option>
									<option>Kitchen</option>
									<option>Bathroom</option>
								</select> <label>Status</label> <select>
									<option>All Status</option>
									<option>Active</option>
									<option>Disabled</option>
								</select>
								<div class="filter-menu-buttons">
									<button class="filter-button reset">Reset</button>
									<button class="filter-button apply">Apply</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 게시글 테이블 시작 -->
				<div class="board__wrapper tableView">

					<!-- 게시판 칼럼 (제목, 닉네임, 조회수 등등)-->
					<div class="board__header">
						<div class="board__cell num">글 번호</div>
						<div class="board__cell category">탭</div>
						<div class="board__cell post_title">제목</div>
						<div class="board__cell reg_date">등록일</div>
						<div class="board__cell nick">닉네임</div>
						<div class="board__cell view_count">조회수</div>
					</div>

					<!-- forEach문으로 돌릴 구간, 샘플을 위해서 일단 게시글 4개정도 남김, function 할땐 하나만 하면됨 -->
					<div class="board__row">
						<c:forEach var="p" items="${posts }">
							<div class="board__cell num">
								<span>${p.post_id}</span>
							</div>
							<div class="board__cell category">
								<span class="cell-label">${p.post_category}</span>
							</div>
							<div class="board__cell post_title">
								<span class="cell-label"><a
									href="fan.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">${p.post_title }
										[${p.post_reply_count}]</a></span>
							</div>
							<div class="board__cell reg_date">
								<span class="cell-label"><c:choose>
										<c:when test="${p.post_update_date eq null }">
											<fmt:formatDate value="${p.post_reg_date}"
												pattern="yy-MM-dd HH:mm" />
										</c:when>
										<c:otherwise>
											<fmt:formatDate value="${p.post_update_date}"
												pattern="yy-MM-dd HH:mm" />
										</c:otherwise>
									</c:choose></span>
							</div>
							<div class="board__cell nick">
								<span class="cell-label">${p.member_nick}</span>
							</div>
							<div class="board__cell view_count">
								<span class="cell-label">${p.post_hit_count}</span>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	</main>
</body>
</html>
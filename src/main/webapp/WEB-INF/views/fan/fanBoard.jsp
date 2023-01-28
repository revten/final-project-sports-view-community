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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
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
<style>
body {
	background-color: #1b2431;
	color: #202020;
	font-family: "Montserrat", "Helvetica", "Open Sans", "Arial";
	font-size: 13px;
}

a:hover {
	text-decoration: none;
}

p, figure {
	margin: 0;
	padding: 0;
}
</style>
</head>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>


	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 my-3"> <!-- 부트스트랩 클래스명이라 main은 남겨야 할듯 -->
	<div class="container-fluid">

		<div class="row">
			<!--==================== fan__best 부분 - 종목별 베스트 (각 게시판별로 CRUD별로 존재해야)  ====================-->
			<div class="card-list">

				<div class="row">
					<!-- 맨위에 fan__best 부분 - 상위글 보여주는 부분 -->

					<div class="col-12 col-md-6 col-lg-4 col-xl-3 mb-4">
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
					</div>

					<div class="col-12 col-md-6 col-lg-4 col-xl-3 mb-4">
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
					</div>

					<div class="col-12 col-md-6 col-lg-4 col-xl-3 mb-4">
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
					</div>

					<div class="col-12 col-md-6 col-lg-4 col-xl-3 mb-4">
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
			</div>

			<!--==================== 게시판 ====================-->
			<div class="projects mb-4">
				<div class="projects-inner">

					<!-- 게시판 제목 -->
					<header class="projects-header">
						<div class="title">
							<h3>${param.post_board }게시판</h3>
						</div>
						<div class="count">| 32 Projects</div>
						<i class="zmdi zmdi-download"></i>
					</header>

					<!-- 게시글 목록 테이블 -->
					<table class="projects-table">
						<thead>
							<tr>
								<th>게시판넘버</th>
								<!-- 확인차 해둔거고 나중에 지울 칼럼 -->
								<th>글번호</th>
								<th>탭</th>
								<th>제목</th>
								<th>등록일</th>
								<th>닉네임</th>
								<th>조회수</th>
								<th>추천수</th>
								<th class="text-right">Actions</th>
							</tr>
						</thead>

						<tr>
							<td>
								<p>New Dashboard</p>
								<p>Google</p>
							</td>
							<td>
								<p>17th Oct, 15</p>
								<p class="text-danger">Overdue</p>
							</td>
							<td class="member">
								<figure>
									<img
										src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/584938/people_8.png" />
								</figure>
								<div class="member-info">
									<p>Myrtle Erickson</p>
									<p>UK Design Team</p>
								</div>
							</td>
							<td>
								<p>$4,670</p>
								<p>Paid</p>
							</td>
							<td class="status"><span class="status-text status-orange">In
									progress</span></td>
							<td>
								<form class="form" action="#" method="POST">
									<select class="action-box">
										<option>Actions</option>
										<option>Start project</option>
										<option>Send for QA</option>
										<option>Send invoice</option>
									</select>
								</form>
							</td>
						</tr>
					</table>
				</div>
			</div>


		</div>
	</div>
	</main>






	<!--==================== 기존 게시판 -> 아래를 위에 적용시키고 클래스명도 우리걸로 바꿔서 css도 바꾸기(부트스트랩 클래스명은 주의) ====================-->
	<main class="fanBoard__main"> <br>
	<div class="fanBoard__container">
		<div class="fanBoard__top">
			<c:choose>
				<c:when test="${sessionScope.loginAccount ne null}">
					<a href="fan.reg.go?post_board=${param.post_board}"> 새글쓰기</a>
				</c:when>
				<c:otherwise>
					<a href="fan.reg.go?post_board=${param.post_board}"
						onclick="alert('로그인하세요')">새글쓰기</a>
				</c:otherwise>
			</c:choose>
		</div>


		<table class="fanBoard__table">
			<thead>
				<tr>
					<th>게시판넘버</th>
					<th>글번호</th>
					<th>탭</th>
					<th>제목</th>
					<th>등록일</th>
					<th>닉네임</th>
					<th>조회수</th>
					<th>추천수</th>
				</tr>
			</thead>
			<c:forEach var="p" items="${posts }">
				<tr>
					<td>${p.post_board}</td>
					<td>${p.post_id}</td>
					<td>${p.post_category}</td>
					<td><a
						href="fan.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">${p.post_title }
							[${p.post_reply_count}]</a></td>
					<td><c:choose>
							<c:when test="${p.post_update_date eq null }">
								<fmt:formatDate value="${p.post_reg_date}"
									pattern="yy-MM-dd HH:mm" />
							</c:when>
							<c:otherwise>
								<fmt:formatDate value="${p.post_update_date}"
									pattern="yy-MM-dd HH:mm" />
							</c:otherwise>
						</c:choose></td>
					<td>${p.member_nick}</td>
					<td>${p.post_hit_count}</td>
					<td>${p.post_like_count}</td>
				</tr>
			</c:forEach>

		</table>


		<div class="fanBoard__bot">
			<div class="fanBoard__bot-search">
				<form action="fan.search.do" name="boardSearchForm"
					onsubmit="return boardSearchCheck();">
					<input type="hidden" name="post_board" value="${param.post_board}">
					<table id="snsSearchArea">
						<tr>
							<td id="ssaTd1"><input name="search" type="search"
								maxlength="10" autocomplete="off"></td>
							<td id="ssaTd2"><button class="search btn-dark">검색</button></td>
						</tr>
					</table>
				</form>
			</div>
			${pageCount}
			<div class="fanBoard__bot-paging">
				<c:if test="${curPage != 1}">
					<span><a
						href="fan.page.change?pg=1&post_board=${param.post_board }">[맨처음]</a></span>
					<span><a
						href="fan.page.change?pg=${curPage - 1}&post_board=${param.post_board }">
							◀이전 </a></span>
				</c:if>
				<c:forEach var="i" begin="1" end="${pageCount}">
					<a href="fan.page.change?pg=${i}&post_board=${param.post_board }">
						[${i}] </a>
				</c:forEach>
				<c:if test="${curPage != pageCount}">
					<span> <a
						href="fan.page.change?pg=${curPage + 1}&post_board=${param.post_board }">
							다음▶ </a></span>
					<span><a
						href="fan.page.change?pg=${pageCount}&post_board=${param.post_board }">[맨끝]</a></span>
				</c:if>
			</div>
		</div>
	</div>
	</main>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- --------------- Jquerry --------------- -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/adminClub.css" />
</head>

<body>
	<nav>
		<a href="admin.main.go">관리자 홈</a> <a href="admin.member.go">회원 관리</a>
		<a href="admin.board.go">게시물 관리</a> <a href="admin.club.go">구단 관리</a>
	</nav>
	<div>
		<div class="adminClub__list">
			<div class="adminClub__list__item adminClub__category__selected">
				<span>구단</span>
			</div>
			<div class="adminClub__list__item">
				<span>관계자</span>
			</div>
		</div>


		<div class="adminClub__category__item-1 adminClub__category__item-on">
			<div>
				<h1>구단 등록</h1>
			</div>
		</div>

		<div class="adminClub__category__item-2">
			<div>
				<h1>관계자 등록</h1>
			</div>
		</div>
	</div>
</body>
<script src="resources/js/admin/adminClub.js"></script>
</html>
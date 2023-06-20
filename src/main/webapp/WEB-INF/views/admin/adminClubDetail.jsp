<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- --------------- Jquerry --------------- -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
<script src="/resources/js/admin/admin.js"></script>
<script src="/resources/js/admin/adminBoard.js"></script>
<script src="/resources/js/admin/adminClub.js"></script>
<script src="/resources/js/admin/adminUser.js"></script>
<link rel="stylesheet" href="/resources/css/admin/admin.css" />
<link rel="stylesheet" href="/resources/css/admin/adminBoard.css" />
<link rel="stylesheet" href="/resources/css/admin/adminClub.css" />
<link rel="stylesheet" href="/resources/css/admin/adminUser.css" />
</head>
<script type="text/javascript">
	
</script>
<body>
	<div class="admin__container">
		<!--==================== NAV ====================-->
		<aside class="aside">
			<h1>ADMIN PAGE</h1>
			<nav class="">
				<h1>
					<a href="admin.go">관리자 홈</a>
				</h1>
			</nav>
			<nav class="">
				<h1>회원 관리</h1>
				<ul>
					<li><a href="adminUser.go">회원 조회</a></li>
					<li><a href="">탈퇴회원 관리</a></li>
				</ul>
			</nav>
			<nav class="">
				<h1>게시물 관리</h1>
				<ul>
					<li><a href="adminBoard.go">게시물 조회</a></li>
					<li><a href="">게시물 관리</a></li>
				</ul>
			</nav>
			<nav class="">
				<h1>구단 관리</h1>
				<ul>
					<li><a href="adminClub.go">구단 조회</a></li>
					<li><a href="adminClub.reg.go">구단 등록</a></li>
				</ul>
			</nav>
		</aside>

		<!--==================== MAIN ====================-->

		<main>

		<h2 class="main title">구단 정보</h2>
		<div class="margin-top first">
			<table class="table">
				<tbody>
					<tr>
						<th>구단코드</th>
						<td class="">${club.id}</td>
					</tr>
					<tr>
						<th>구단명</th>
						<td class="">${club.name}</td>
					</tr>
					<tr>
						<th>구단명(영문)</th>
						<td class="">${club.name_eng}</td>
					</tr>
					<tr>
						<th>종목</th>
						<td class="">${club.sports_id}</td>
					</tr>
					<tr>
						<th>리그</th>
						<td class="">${club.league_id}</td>
					</tr>
					<tr>
						<th>연고도시</th>
						<td class="">${club.city}</td>
					</tr>
					<tr>
						<th>홈구장명</th>
						<td class="">${club.stadium_name}</td>
					</tr>
					<tr>
						<th>홈구장주소</th>
						<td class="">${club.stadium_address}</td>
					</tr>
					<tr>
						<th>창단년도</th>
						<td class="">${club.found_year}</td>
					</tr>
					<tr>
						<th>구단 홈페이지</th>
						<td class="">${club.website}</td>
					</tr>
					<tr>
						<th>구단 소개</th>
						<td>${club.intro}</td>
					</tr>
					<hr>
				</tbody>
			</table>
		</div>

		<hr>

		<div>
			<div>
				<h3>로고사진</h3>
				<c:forEach var="ci" items="${clubImages }">
					<c:if test="${ci.sort eq 0 }">
						<img alt=""
							src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
							width="200">
					</c:if>
				</c:forEach>
			</div>
			<hr>

			<div>
				<h3>구장사진</h3>
				<c:forEach var="ci" items="${clubImages }">
					<c:if test="${ci.sort eq 1 }">
						<img alt=""
							src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
							width="200">
					</c:if>
				</c:forEach>
			</div>
			<hr>

			<div>
				<h3>좌석사진</h3>
				<c:forEach var="ci" items="${clubImages }">
					<c:if test="${ci.sort eq 2 }">
						<img alt=""
							src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
							width="200">
					</c:if>
				</c:forEach>
			</div>
			<hr>

			<div>
				<h3>직관사진3시</h3>
				<c:forEach var="ci" items="${clubImages }">
					<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '3') }">
						<img alt=""
							src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
							width="200">
					</c:if>
				</c:forEach>
			</div>
			<hr>

			<div>
				<h3>직관사진 6시</h3>
				<c:forEach var="ci" items="${clubImages }">
					<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '6') }">
						<img alt=""
							src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
							width="200">
					</c:if>
				</c:forEach>
			</div>
			<hr>

			<div>
				<h3>직관사진9시</h3>
				<c:forEach var="ci" items="${clubImages }">
					<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '9') }">
						<img alt=""
							src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
							width="200">
					</c:if>
				</c:forEach>
			</div>
			<hr>

			<div>
				<h3>직관사진12시</h3>
				<c:forEach var="ci" items="${clubImages }">
					<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '12')}">
						<img alt=""
							src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
							width="200">
					</c:if>
				</c:forEach>
			</div>
		</div>
		<hr>
		
		<div class="">
			<a class="" onclick="history.back()">이전으로</a> <a class=""
				href="adminClub.update.go?id=${club.id }">수정</a>
		</div>
		</main>

	</div>
</body>
</html>
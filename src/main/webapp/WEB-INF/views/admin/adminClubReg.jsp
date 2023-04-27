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
<script src="resources/js/admin/admin.js"></script>
<script src="resources/js/admin/adminBoard.js"></script>
<script src="resources/js/admin/adminClub.js"></script>
<script src="resources/js/admin/adminUser.js"></script>
<link rel="stylesheet" href="resources/css/admin/admin.css" />
<link rel="stylesheet" href="resources/css/admin/adminBoard.css" />
<link rel="stylesheet" href="resources/css/admin/adminClub.css" />
<link rel="stylesheet" href="resources/css/admin/adminUser.css" />
</head>
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
					<li><a href="admin.user.go">회원 조회</a></li>
					<li><a href="">탈퇴회원 관리</a></li>
				</ul>
			</nav>
			<nav class="">
				<h1>게시물 관리</h1>
				<ul>
					<li><a href="admin.board.go">게시물 조회</a></li>
					<li><a href="">게시물 관리</a></li>
				</ul>
			</nav>
			<nav class="">
				<h1>구단 관리</h1>
				<ul>
					<li><a href="admin.club.go">구단 조회</a></li>
					<li><a href="">구단 등록</a></li>
				</ul>
			</nav>
		</aside>

		<!--==================== MAIN ====================-->
		<main>
		<h2 class="main title">구단 등록</h2>

		<form method="post" action="adminClub.reg.do"
			enctype="multipart/form-data">
			<div class="margin-top first">
				<table class="table">
					<tbody>
						<tr>
							<th>구단코드</th>
							<td class=""><input type="text" name="club_id" /></td>
						</tr>
						<tr>
							<th>구단명</th>
							<td class=""><input type="text" name="club_name" /></td>
						</tr>
						<tr>
							<th>구단명(영문)</th>
							<td class=""><input type="text" name="club_name_eng" /></td>
						</tr>
						<tr>
							<th>종목</th>
							<td class=""><select name="sports_id">
									<option value="1">야구</option>
									<option value="2">축구</option>
									<option value="3">농구</option>
									<option value="4">배구</option>
							</select></td>
						</tr>
						<tr>
							<th>리그</th>
							<td class=""><select name="league_id">
									<option value="101">KBO</option>
									<option value="201">K-LEAGUE</option>
									<option value="301">KBL</option>
									<option value="351">WKBL</option>
									<option value="401">V-LEAGUE(남)</option>
									<option value="451">V-LEAGUE(여)</option>

							</select></td>
						</tr>
						<tr>
							<th>남녀</th>
							<td class="">남녀</td>
						</tr>
						<tr>
							<th>연고도시</th>
							<td class=""><input type="text" name="city" /></td>
						</tr>
						<tr>
							<th>홈구장명</th>
							<td class=""><input type="text" name="stadium_name" /></td>
						</tr>
						<tr>
							<th>홈구장주소</th>
							<td class=""><input type="text" name="stadium_address" /></td>
						</tr>
						<tr>
							<th>창단년도</th>
							<td class=""><input type="text" name="found_year" /></td>
						</tr>
						<tr>
							<th>구단 홈페이지</th>
							<td class=""><input type="text" name="website" /></td>
						</tr>
						<tr>
							<th>구단 소개</th>
							<td><textarea class="content" name="intro"></textarea></td>
						</tr>
						<tr>
							<th>로고사진</th>
							<td class=""><input type="file" name="logo" /></td>
						</tr>
						<tr>
							<th>좌석사진</th>
							<td class=""><input type="file" name="seat" /></td>
						</tr>
						<tr>
							<th>구장사진</th>
							<td class=""><input type="file" name="seat" /></td>
						</tr>
						<tr>
							<th>직관사진3</th>
							<td class=""><input type="file" name="sight" /></td>
						</tr>
						<tr>
							<th>직관사진6</th>
							<td class=""><input type="file" name="sight" /></td>
						</tr>
						<tr>
							<th>직관사진9</th>
							<td class=""><input type="file" name="sight" /></td>
						</tr>
						<tr>
							<th>직관사진12</th>
							<td class=""><input type="file" name="sight" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="">
				<input class="" type="submit" value="등록" /> <a class=""
					href="adminClub">취소</a>
			</div>
		</form>
		</main>
	</div>
</body>
</html>
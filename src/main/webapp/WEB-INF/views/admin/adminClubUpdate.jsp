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
<script type="text/javascript">
	$(function() {
		$("#sports_option").val(${club.sports_id}).attr("selected", "selected");
		$("#league_option").val(${club.league_id}).attr("selected", "selected");
	});
</script>


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
		<h2 class="main title">구단 수정</h2>

		<form id="adminClubInfo-update" method="post"
			action="adminClub.update.do" enctype="multipart/form-data">
			<div class="margin-top first">
				<table class="table">
					<tbody>
						<tr>
							<th>구단코드</th>
							<td class=""><input class="admin__clubCode" type="text"
								name="id" placeholder="${club.id}" required /> <input
								id="admin__clubCode" type="hidden" value="${club.id}" /></td>

						</tr>
						<tr>
							<th>구단명</th>
							<td class=""><input type="text" name="name"
								placeholder="${club.name}" required /></td>
						</tr>
						<tr>
							<th>구단명(영문)</th>
							<td class=""><input type="text" name="name_eng"
								placeholder="${club.name_eng}" required /></td>
						</tr>
						<tr>
							<th>종목</th>
							<td class=""><select id="sports_option" name="sports_id"
								required>
									<option value="1">야구</option>
									<option value="2">축구</option>
									<option value="3">농구</option>
									<option value="4">배구</option>
							</select></td>
						</tr>
						<tr>
							<th>리그</th>
							<td class=""><select id="league_option" name="league_id"
								required>
									<option value="101">KBO</option>
									<option value="201">K-LEAGUE</option>
									<option value="301">KBL</option>
									<option value="351">WKBL</option>
									<option value="401">V-LEAGUE(남)</option>
									<option value="451">V-LEAGUE(여)</option>
							</select></td>
						</tr>
						<tr>
							<th>연고도시</th>
							<td class=""><input type="text" name="city"
								placeholder="${club.city}" required /></td>
						</tr>
						<tr>
							<th>홈구장명</th>
							<td class=""><input type="text" name="stadium_name"
								placeholder="${club.stadium_name}" required /></td>
						</tr>
						<tr>
							<th>홈구장주소</th>
							<td class=""><input type="text" name="stadium_address"
								placeholder="${club.stadium_address}" required /></td>
						</tr>
						<tr>
							<th>창단년도</th>
							<td class=""><input type="text" name="found_year"
								placeholder="${club.found_year}" required /></td>
						</tr>
						<tr>
							<th>구단 홈페이지</th>
							<td class=""><input type="text" name="website"
								placeholder="${club.website}" /></td>
						</tr>
						<tr>
							<th>구단 소개</th>
							<td><textarea class="content" name="intro"
									placeholder="${club.intro}"></textarea></td>
						</tr>
						<hr>
					</tbody>
				</table>
			</div>
		</form>

		<div>
			<div>
				<h3>로고사진</h3>
				<div>
					<c:forEach var="ci" items="${clubImages }">
						<c:if test="${ci.sort eq 0 }">
							<img alt=""
								src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
								width="200">
							<input type="hidden" value="${ci.id}" id="clubImage-id" />
						</c:if>
					</c:forEach>
				</div>
				<div class="uploadWrap">
					<input type="file" onchange="imagePreview(event);" id="image-file">
					<button onclick="uploadClubImg(0)">업로드</button>
				</div>
			</div>
			<hr>

			<div>
				<h3>구장사진</h3>
				<div>
					<c:forEach var="ci" items="${clubImages }">
						<c:if test="${ci.sort eq 1 }">
							<img alt=""
								src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
								width="200">
						</c:if>
					</c:forEach>
				</div>
				<div class="uploadWrap">
					<input type="file" onchange="imagePreview(event);" id="image-file">
					<button onclick="uploadClubImg(1)">업로드</button>
				</div>
			</div>
			<hr>

			<div>
				<h3>좌석사진</h3>
				<div>
					<c:forEach var="ci" items="${clubImages }">
						<c:if test="${ci.sort eq 2 }">
							<img alt=""
								src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
								width="200">
						</c:if>
					</c:forEach>
				</div>
				<div class="uploadWrap">
					<input type="file" onchange="imagePreview(event);" id="image-file">
					<button onclick="uploadClubImg(2)">업로드</button>
				</div>
			</div>
			<hr>
			<div>
				<h3>직관사진3시</h3>
				<div>
					<c:forEach var="ci" items="${clubImages }">
						<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '3')}">
							<img alt=""
								src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
								width="200">
						</c:if>
					</c:forEach>
				</div>
				<div class="uploadWrap">
					<input type="file" onchange="imagePreview(event);" id="image-file">
					<button onclick="uploadClubImg(3)">업로드</button>
				</div>
			</div>
			<hr>

			<div>
				<h3>직관사진 6시</h3>
				<div>
					<c:forEach var="ci" items="${clubImages }">
						<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '6')}">
							<img alt=""
								src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
								width="200">
						</c:if>
					</c:forEach>
				</div>
				<div class="uploadWrap">
					<input type="file" onchange="imagePreview(event);" id="image-file">
					<button onclick="uploadClubImg(3)">업로드</button>
				</div>
			</div>
			<hr>

			<div>
				<h3>직관사진9시</h3>
				<div>
					<c:forEach var="ci" items="${clubImages }">
						<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '9')}">
							<img alt=""
								src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
								width="200">
						</c:if>
					</c:forEach>
				</div>
				<div class="uploadWrap">
					<input type="file" onchange="imagePreview(event);" id="image-file">
					<button onclick="uploadClubImg(3)">업로드</button>
				</div>
			</div>
			<hr>

			<div>
				<h3>직관사진12시</h3>
				<div>
					<c:forEach var="ci" items="${clubImages }">
						<c:if test="${ci.sort eq 3 && fn:contains(ci.file_name, '12')}">
							<img alt=""
								src="resources/files/club_images/${ci.club_id }/${ci.file_name}"
								width="200">
						</c:if>
					</c:forEach>
				</div>
				<div class="uploadWrap">
					<input type="file" onchange="imagePreview(event);" id="image-file">
					<button onclick="uploadClubImg(3)">업로드</button>
				</div>
			</div>
		</div>
		<hr>

		<div class="">
			<a class="" href="adminClub.go">취소</a>
			<button type="submit" form="adminClubInfo-update">수정완료</button>
		</div>
		</main>

	</div>
</body>
</html>
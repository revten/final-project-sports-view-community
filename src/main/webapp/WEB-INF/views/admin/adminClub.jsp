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
		<main class="main">
		<h2 class="main title">구단 조회</h2>

		<div class="">
			<form class="">
				<fieldset>
					<legend class="hidden">구단 검색 필드</legend>
					<label class="hidden">검색분류</label> <select name="field">
						<option ${(param.field == "club_name")?"selected":"" }
							value="club_name">구단</option>
						<option ${(param.field == "sports")?"selected":"" } value="sports">스포츠</option>
					</select>
					<!-- 검색후 검색한 필드 그대로 나타나도록 설정한 것 -->
					<label class="hidden">검색어</label>
					<!-- 검색후 검색한 단어 그대로 나타나도록 설정한 것 -->
					<input type="text" name="query" value="${param.query }" /> <input
						class="" type="submit" value="검색" />
				</fieldset>
			</form>
		</div>

		<div class="">
			<table class="table" border=1>
				<thead>
					<tr>
						<th class="">구단코드</th>
						<th class="">구단명</th>
						<th class="">종목</th>
						<th class="">리그</th>
						<th class="">연고도시</th>
						<th class="">홈구장명</th>
						<th class="">로고사진</th>
						<th class="">구장사진수</th>
						<th class="">등록일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${list }">
						<tr>
							<td>${c.club_id}</td>
							<td class="title indent text-align-left"><a
								href="detail?id=${c.club_id }">${nc.club_name}</a></td>
							<td>${c.sports}</td>
							<td>${c.league}</td>
							<td>${c.city}</td>
							<td>${c.stadium_name}</td>
							<td>로고사진</td>
							<td>구장사진수</td>
							<td><fmt:formatDate value="${c.reg_date}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<!-- 페이징을 위한 설정 --> <c:set var="page"
			value="${(param.p == null)?1:param.p }" /> <!-- 한 화면에 페이지 번호 5개 -->
		<c:set var="startNum" value="${page-(page-1)%5 }" /> <!-- 컨트롤러에서 서비스를 통해 총 게시물수 계산부터 -->
		<!-- 소수점은 올림 해줘야 되므로 fn 불러와서 서보자 --> <c:set var="lastNum"
			value="${fn:substringBefore(Math.ceil(count/10), '.')}" />

		<div class="">
			<h3 class="hidden">현재 페이지</h3>
			<div>
				<!-- 현재 페이지 -->
				<span class="text-strong">${(empty param.p)?1:param.p}</span> /
				${lastNum} pages
			</div>
		</div>

		<!-- 페이징 -->
		<div class="">
			<div>
				<c:if test="${startNum>1 }">
					<a href="?p=${startNum-1}&f=&q=" class="btn btn-prev">이전</a>
				</c:if>
				<c:if test="${startNum<=1 }">
					<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
				</c:if>
			</div>

			<ul class="-list- center">
				<c:forEach begin="0" end="4" var="i">
					<!-- 현제 페이지 번호 하이라이트 (oragne : 에 홑따옴표 쓴것 주목) -->
					<c:if test="${(startNum+i) <= lastNum }">
						<li><a
							class="-text- ${(page==(startNum+i))?'orange':'' } bold"
							href="?p=${startNum+i}&f=${param.f }&q=${param.q}">${startNum+i}</a></li>
					</c:if>
				</c:forEach>
			</ul>

			<div>
				<c:if test="${startNum+5<=lastNum }">
					<a href="?p=${startNum+5}&f=&q=" class="btn btn-next">다음</a>
				</c:if>
				<c:if test="${startNum+5>lastNum }">
					<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
				</c:if>
			</div>
		</div>
		</main>
	</div>
</body>
</html>
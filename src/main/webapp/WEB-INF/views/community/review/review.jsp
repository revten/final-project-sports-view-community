<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="row">
	<div id="community_area">
			<ul id="community_list">
				<li><a style="cursor: pointer" href='community.main.go?wg_cat=withGo'>커뮤니티 메인</a>
				<li><a style="cursor: pointer"
					href='reviewList.go?rv_cat=review'>직관 후기 게시판</a></li>
				<li><a style="cursor: pointer"
					href='withGoList.go?wg_cat=withGo'>같이 직관/경기 게시판</a></li>
				<li><a style="cursor: pointer" onclick="">야구 게시판</a></li>
				<li><a style="cursor: pointer" onclick="">축구 게시판</a></li>
				<li><a style="cursor: pointer" onclick="">농구 게시판</a></li>
				<li><a style="cursor: pointer" onclick="">배구 게시판</a></li>
				<li><a style="cursor: pointer" onclick="">기타 게시판</a></li>
				</ul>
				</div>
		<form action="reviewList.go">
			<div style="text-align: center;">
				<div>
					<a id="writeBtn" href='reviewWrite.go?rv_cat=${param.rv_cat}'
						class="btn btn-success writeBtn">직관 후기 작성하기</a>
				</div>
				<input type="text" id="searchInput" name="search"
					placeholder="검색어를 입력해주세요"> <input type="hidden"
					name="rv_cat" value="${param.rv_cat}">
				<button id="searchBtn" class="btn btn-success btn-sm">완료</button>
			</div>
		</form>
	</div>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th><a href="reviewList.go?rv_cat=${param.rv_cat}&sort=0">날짜</a></th>
				<th><a href="reviewList.go?rv_cat=${param.rv_cat}&sort=1">조회수</a></th>
				<th><a href="reviewList.go?rv_cat=${param.rv_cat}&sort=2">좋아요</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${posts}">

				<tr onclick="location.href='reviewDetail.go?rv_no=${b.rv_no}'">
					<td>${b.rv_no}</td>
					<td style="width: 40%;">${b.rv_title}</td>
					<td>${b.rv_id}</td>
					<td><fmt:formatDate value="${b.rv_date}"
							pattern="yy-MM-dd HH:mm" /></td>
					<td>${b.rv_count}</td>
					<td>${b.rv_like}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<ul class="pagination pagination-sm"
		style="padding-left: 40%; padding-bottom: 20px;">
		<!-- <li class="page-item active" aria-current="page"> <span class="page-link">1</span> </li> -->
		<c:forEach var="i" begin="1" end="${r}">
			<li class="page-item"><a class="page-link"
				href="reviewList.go?rv_cat=${param.rv_cat}&vpage=${i}&search=${search}&sort=${sort}">${i}</a>
			</li>
		</c:forEach>
	</ul>


	<input id="loginCheckId" type="hidden"
		value="${sessionScope.loginAccount.ac_id}">
</body>
</html>
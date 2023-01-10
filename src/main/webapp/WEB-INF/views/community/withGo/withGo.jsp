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
		<form action="withGoList.go">
			<div style="text-align: center;">
				<input type="text" id="searchInput" name="search"
					placeholder="검색어를 입력해주세요"> <input type="hidden"
					name="wg_cat" value="${param.wg_cat}">
				<button id="searchBtn" class="btn btn-success btn-sm">완료</button>
			</div>
		</form>
	</div>
	<div>
		<a id="writeBtn" href='withGoWrite.go?wg_cat=${param.wg_cat}'
			class="btn btn-success writeBtn">글쓰기</a>
	</div>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th><a
					href="withGoList.go?wg_cat=${param.wg_cat}&sort=0">날짜</a></th>
				<th><a
					href="withGoList.go?wg_cat=${param.wg_cat}&sort=1">조회수</a></th>
				<th><a
					href="withGoList.go?wg_cat=${param.wg_cat}&sort=2">좋아요</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${posts}">

				<tr onclick="location.href='withGoDetail.go?wg_no=${b.wg_no}'">
					<td>${b.wg_no}</td>
					<td style="width: 40%;">${b.wg_title}</td>
					<td>${b.wg_id}</td>
					<td><fmt:formatDate value="${b.wg_date}"
							pattern="yy-MM-dd HH:mm" /></td>
					<td>${b.wg_count}</td>
					<td>${b.wg_like}</td>
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
				href="withGoList.go?wg_cat=${param.wg_cat}&vpage=${i}&search=${search}&sort=${sort}">${i}</a>
			</li>
		</c:forEach>
	</ul>


	<input id="loginCheckId" type="hidden"
		value="${sessionScope.loginAccount.ac_id}">
</body>
</html>
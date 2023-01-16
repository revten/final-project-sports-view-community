<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	
	<div class="nav__menu" id="nav-menu" style="width:70%;align:center;">
				<ul class="nav__list">
					<li class="nav__item"><a href="news.soccer.go"
						class="nav__link">축구</a>
					</li>

					<li class="nav__item"><a href="news.baseball.go" class="nav__link">야구</a></li>

					<li><a href="news.basketball.go" class="nav__link">농구</a></li>

					<li class="nav__item"><a href="news.volleyball.go"
						class="nav__link">배구</a></li>
						
					<li class="nav__item"><a href="news.sports.go"
						class="nav__link">스포츠</a></li>
						
					<li class="nav__item"><a href="team.event.main.go"
						class="nav__link">구단공식이벤트</a></li>
						
					<li class="nav__item"><a href="sports.info.main.go"
						class="nav__link">생활체육정보</a></li>

				</ul>

				<!-- close button -->
				<div class="nav__close" id="nav-close">
					<i class="ri-close-line"></i>
				</div>
			</div>
	<div>
	<form action="teamEvent.search.do">
		<select name="">
			<option value="ie_te_title">제목</option>
			<option value="ie_te_team">구단</option>
		</select> <input type="text" placeholder="입력" name="ie_te_title">
		<button>검색</button>
		</form>
		<c:choose>
			<c:when test="${sessionScope.loginAccount eq null}">
				<a href="" onclick="alert('로그인하세요')">새글쓰기</a>
			</c:when>
			<c:otherwise>
				<a href="teamEvent.insert.go">새글쓰기</a>
			</c:otherwise>
		</c:choose>
	</div>

	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>구단</th>
				<th>제목</th>
				<th>작성자</th>
				<th>시간</th>
				<th>조회</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>MainNo</td>
				<td>MainTeam</td>
				<td><a style="cursor: pointer; color: blue;"
					onclick="location.href='team.event.detail.go'">MainTitle</a></td>
				<td>MainWriter</td>
				<td>MainTime</td>
				<td>MainCount</td>
			</tr>
			<c:forEach var="te" items="${teamEvents }">
				<tr>
					<td>${te.ie_te_no }</td>
					<td>${te.ie_te_team }</td>
					<td><a style="cursor: pointer; color: blue;" href="team.event.detail.go?ie_te_no=${te.ie_te_no}">${te.ie_te_title }</a></td>
					<td>${te.ie_te_nick }</td>
					<td>${te.ie_te_regdate }</td>
					<td>${te.ie_te_views }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${curPage !=1 }">
		<a href="teamEvent.page.change?p=${curPage-1 }" id="snsL">&lt;</a>
	</c:if>
	<c:forEach var="i" begin="1" end="${pageCount }">
		<a href="teamEvent.page.change?p=${i }"> [${i }] </a>
	</c:forEach>
	<c:if test="${curPage != pageCount }">
		<a href="teamEvent.page.change?p=${curPage+1 }" id="snsR">&gt;</a>
	</c:if>
</body>
</html>
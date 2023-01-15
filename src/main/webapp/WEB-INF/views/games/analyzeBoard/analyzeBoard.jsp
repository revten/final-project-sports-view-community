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
	<br>
	<br>
	<a href="games.main.go">games 메인</a>
	<div>유저분석</div>

	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>종목</td>
				<td>리그</td>
				<td>제목</td>
				<td>등록일</td>
				<td>작성자</td>
				<td>추천</td>
				<td>조회</td>
			<tr>
		</thead>

		<c:forEach var="p" items="${posts }">
			<tbody>
				<tr>
					<td>${p.anlyz_no}</td>
					<td>${p.anlyz_sports}</td>
					<td>리그</td>
					<td><a
						href="games.analyzeBoard.getDetail?anlyz_no=${p.anlyz_no}">${p.anlyz_title}</a></td>
					<td>${p.anlyz_date_created}</td>
					<td>${p.ac_nick}</td>
					<td>22</td>
					<td>25</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<form action="games.analyzeBoard.search" name="analyzeBoardSearchForm"
		onsubmit="return AnalyzeBoardSearchCheck();">
		<table id="analyzeBoard-SearchArea">
			<tr>
				<td id="analyzeBoard-SearchArea-1"><input name="search"
					maxlength="10" autocomplete="off"></td>
				<td id="analyzeBoard-SearchArea-2"><button>검색</button></td>
				<!-- <td> <img id="analyzeBoard-SearchFormSummoner" src="resources/files/games/search.png"><button>검색</button></td> -->
			</tr>
		</table>
	</form>

	<c:if test="${curPage !=1 }">
		<a href="games.page.change?p=${curPage-1 }" id="snsL">&lt;</a>
	</c:if>
	<c:if test="${curPage != pageCount }">
		<a href="games.page.change?p=${curPage+1 }" id="snsR">&gt;</a>
	</c:if>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>
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
<br><br><br><br><br>
	<h1>토토</h1>
	<div><c:choose>
			<c:when test="${sessionScope.loginAccount eq null}">
				<a href="" onclick="alert('로그인하세요')">새글쓰기</a>
			</c:when>
			<c:otherwise>
				<a href="toto.insert.go">새글쓰기</a>
			</c:otherwise>
		</c:choose></div>

	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>닉네임</th>
				<th>시간</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tt" items="${totos }">
				<tr>
					<td>${tt.toto_no }</td>
					<td>${tt.toto_cat }</td>
					<td><a style="cursor: pointer; color: blue;" href="games.toto.detail.go?toto_no=${tt.toto_no }">${tt.toto_title }</a></td>
					<td>${tt.toto_nick }</td>
					<td>${tt.toto_date }</td>
					<td>${tt.toto_count }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
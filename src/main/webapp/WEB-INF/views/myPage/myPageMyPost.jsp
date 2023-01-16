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
	<h1>내글목록 보기!</h1>
	<div><c:choose>
			<c:when test="${sessionScope.loginAccount eq null}">
				<a href="" onclick="alert('로그인하세요')">새글쓰기</a>
			</c:when>
			<c:otherwise>
				<a href="mypost.insert.go">새글쓰기</a>
			</c:otherwise>
		</c:choose></div>
	<table>
		<thead>
			<tr>
				<th>카테고리</th>
				<th>제목</th>
				<th>시간</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mpt" items="${MyPosts }">
				<tr>
					<td>${mpt.mypost_cat }</td>
					<td><a style="cursor: pointer; color: blue;" href="myPage.myPost.detail.go?mypost_no=${mpt.mypost_no}">${mpt.mypost_title }</a></td>
					<td><fmt:formatDate value="${mpt.mypost_date }" pattern="yyyy-MM-dd HH:mm" /></td>
					<td>${mpt.mypost_count }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${curPage !=1 }">
		<a href="mypost.page.change?p=${curPage-1 }" id="snsL">&lt;</a>
	</c:if>
	<c:forEach var="i" begin="1" end="${pageCount }">
		<a href="mypost.page.change?p=${i }"> [${i }] </a>
	</c:forEach>
	<c:if test="${curPage != pageCount }">
		<a href="mypost.page.change?p=${curPage+1 }" id="snsR">&gt;</a>
	</c:if>

</body>
</html>
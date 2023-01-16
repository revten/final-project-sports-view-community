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
	<br>
	<br>
	<br>
	<table border="1">
		<thead>
			<tr>
				<td>종목</td>
				<td>리그</td>
				<td>제목</td>
				<td>등록일</td>
				<td>작성자</td>
				<td>추천</td>
				<td>조회</td>
			<tr>
		</thead>
		<tbody>
			<tr>
				<td>${post.anlyz_sports}</td>
				<td>리그</td>
				<td><a>${post.anlyz_title}</a></td>
				<td>${post.anlyz_date_created}</td>
				<td>${post.ac_nick}</td>
				<td>22</td>
				<td>25</td>
			</tr>
		</tbody>
	</table>
	<c:forEach var="pc" items="${post.anlyz_cmnts }">
		<table>
			<tbody>
				<tr>
					<td>${pc.anlyz_cmnt_content}</td>
					<td>${pc.anlyz_cmnt_date_created}</td>
				</tr>
			</tbody>
		</table>
	</c:forEach>
</body>
</html>
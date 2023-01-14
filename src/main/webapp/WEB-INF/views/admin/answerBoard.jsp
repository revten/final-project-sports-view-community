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
	<h1>문의처리</h1>

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
			<c:forEach var="ans" items="${answers }">
				<tr>
					<td>${ans.answer_no }</td>
					<td>${ans.answer_cat }</td>
					<td><a style="cursor: pointer; color: blue;" href="admin.answer.detail.go?answer_no=${ans.answer_no }">${ans.answer_title }</a></td>
					<td>${ans.answer_nick }</td>
					<td>${ans.answer_date }</td>
					<td>${ans.answer_count }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
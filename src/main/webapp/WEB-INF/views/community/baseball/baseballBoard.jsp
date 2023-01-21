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
	<h1>야구게시판</h1>${result}

	<table border="1">
		<button onclick="location.href='baseball.reg.go'">게시글작성</button>
		<thead>
			<tr>
				<th>탭</th>
				<th>제목</th>
				<th>내용</th>
				<th>등록일</th>
				<th>닉네임</th>
			</tr>
			<tr>
				<c:forEach var="p" items="${posts }">
					<td colspan="5"></td>
					<tr
						onclick="location.href='baseballBoardDetail.go?cm_bs_no=${p.post_id}'">
						<td>${p.post_category}</td>
						<td>${p.post_title}</td>
						<td>${p.post_title}</td>
						<td><c:choose>
								<c:when test="${p.post_update_date eq null }">
									<fmt:formatDate value="${p.post_reg_date}"
										pattern="yy-MM-dd HH:mm" />
								</c:when>
								<c:otherwise>
									<fmt:formatDate value="${p.post_update_date}"
										pattern="yy-MM-dd HH:mm" />
								</c:otherwise>
							</c:choose></td>
						<td>${p.member_nick}</td>
					</tr>
				</c:forEach>
			</tr>
		</thead>
	</table>
</body>
</html>
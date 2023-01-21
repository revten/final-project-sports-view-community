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
	<h1>상세페이지</h1>
	<table border="1">
		<tr>
			<td>제목:${post.post_title}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:choose>
					<c:when test="${p.post_update_date eq null }">
						작성날짜:<fmt:formatDate value="${p.post_reg_date}"
							pattern="yy-MM-dd HH:mm" />
					</c:when>
					<c:otherwise>
						작성날짜:<fmt:formatDate value="${p.post_reg_date}"
							pattern="yy-MM-dd HH:mm" />
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>닉네임:${post.member_nick}</td>
		</tr>
		<tr>
			<td>글내용:${post.member_content}</td>
		</tr>
		<tr>
			<td>
				<button
					onclick="location.href='baseballUpdate.go?cm_bs_no=${post.post_id}'">수정</button>
				<button
					onclick="location.href='baseballDelete.do?cm_bs_no=${post.post_id}'">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>
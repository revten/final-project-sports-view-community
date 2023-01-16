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

	<div style="border: 1px solid; width: 70%; align: center;">
		<button onclick="history.back()">이전으로</button>
		<div>${toto.toto_no }</div>
		<div>${toto.toto_title }</div>
		<div>
			<fmt:formatDate value="${toto.toto_date }" pattern="yyyy-MM-dd HH:mm" />
		</div>
		<div>조회수:${toto.toto_count }</div>
	</div>
	<div>
		<img src="resources/files/totoImg/${toto.toto_img }">
	</div>
	<div>${toto.toto_content }</div>
	<div>
		<c:choose>
			<c:when test="${sessionScope.loginAccount.ac_id eq toto.toto_id }">
				<c:choose>
					<c:when test="${sessionScope.loginAccount.ac_id eq null}">
						<button onclick="alert('로그인하세요')">수정</button>
						<button onclick="alert('로그인하세요')">삭제</button>
					</c:when>
					<c:otherwise>
						<button
							onclick="location.href='toto.update.go?toto_no=${toto.toto_no}'">수정</button>
						<button
							onclick="location.href='toto.delete.do?toto_no=${toto.toto_no}'">삭제</button>
					</c:otherwise>
				</c:choose>
			</c:when>
		</c:choose>
	</div>
			<form action="toto.comment.insert" method="post">
				댓글<input name="toto_comment_comtent"><button>등록</button>
			</form>
	<table>
		<tbody>
			<c:forEach var="ttc" items="${toto.toto_comments }">
				<tr>
					<%-- <td>${totos.ac_nick}</td> --%>
					 <td>${ttc.toto_comment_content}</td>
					<td>${ttc.toto_comment_date}</td> 
					<td><c:choose>
			<c:when test="${sessionScope.loginAccount.ac_nick eq ttc.ac_nick }">
				<c:choose>
					<c:when test="${sessionScope.loginAccount.ac_id eq null}">
						<button onclick="alert('로그인하세요')">삭제</button>
					</c:when>
					<c:otherwise>
						<button
							onclick="location.href='toto.comment.delete.do?toto_comment_no=${ttc.toto_comment_no}'">삭제</button>
					</c:otherwise>
				</c:choose>
			</c:when>
		</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
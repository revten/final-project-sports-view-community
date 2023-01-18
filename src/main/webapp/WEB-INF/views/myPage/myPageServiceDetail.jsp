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
<div style="border:1px solid;width:70%;align:center;">
			<div>${ask.ask_no }</div>
			<div>${ask.ask_title }</div>
			<div><fmt:formatDate value="${ask.ask_date }" pattern="yyyy-MM-dd HH:mm" /></div>
			<div>조회수:${ask.ask_count }</div>
		</div>
		<div><img src="resources/files/AskImg/${ask.ask_img }"></div>
		<div>${ask.ask_content }</div>
		<div>
					<button onclick="history.back()">이전으로</button>
					<c:choose>
							<c:when test="${sessionScope.loginAccount.ac_id eq ask.ask_id }">
								<c:choose>
									<c:when test="${sessionScope.loginAccount.ac_id eq null}">
										<button onclick="alert('로그인하세요')">수정</button>
										<button onclick="alert('로그인하세요')">삭제</button>
									</c:when>
									<c:otherwise>
										<button onclick="location.href='ask.update.go?ask_no=${ask.ask_no}'">수정</button>
										<button onclick="location.href='ask.delete.do?ask_no=${ask.ask_no}'">삭제</button>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
				</div>
		<form action="ask.comment.insert" method="post">
			<input type="hidden" name="ask_no" value="${ask.ask_no }">
				댓글<input name="ask_comment_content"><button>등록</button>
			</form>
	<table>
		<tbody>
		<c:if test="${ask.ask_comments ne null}">
			<c:forEach var="ask" items="${ask.ask_comments }">
				<tr>
					<%-- <td>${asks.ac_nick}</td> --%>
					 <td>${ask.ask_comment_content}</td>
					<td>${ask.ask_comment_date}</td> 
					<td><c:choose>
			<c:when test="${sessionScope.loginAccount.ac_nick eq ask.ac_nick }">
				<c:choose>
					<c:when test="${sessionScope.loginAccount.ac_id eq null}">
						<button onclick="alert('로그인하세요')">삭제</button>
					</c:when>
					<c:otherwise>
						<button
							onclick="location.href='ask.comment.delete.do?ask_comment_no=${ask.ask_comment_no}'">삭제</button>
					</c:otherwise>
				</c:choose>
			</c:when>
		</c:choose></td>
				</tr>
			</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>
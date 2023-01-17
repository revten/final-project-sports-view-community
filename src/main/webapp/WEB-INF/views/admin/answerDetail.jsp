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
			<div>${answer.answer_no }</div>
			<div>${answer.answer_title }</div>
			<div><fmt:formatDate value="${answer.answer_date }" pattern="yyyy-MM-dd HH:mm" /></div>
			<div>조회수:${answer.answer_count }</div>
		</div>
		<div><img src="resources/files/answerImg/${answer.answer_img }"></div>
		<div>${answer.answer_content }</div>
		<div>
					<button onclick="history.back()">이전으로</button>
					<c:choose>
							<c:when test="${sessionScope.loginAccount.ac_id eq answer.answer_id }">
								<c:choose>
									<c:when test="${sessionScope.loginAccount.ac_id eq null}">
										<button onclick="alert('로그인하세요')">수정</button>
										<button onclick="alert('로그인하세요')">삭제</button>
									</c:when>
									<c:otherwise>
										<button onclick="location.href='answer.update.go?answer_no=${answer.answer_no}'">수정</button>
										<button onclick="location.href='answer.delete.do?answer_no=${answer.answer_no}'">삭제</button>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
				</div>
				
				<form action="answer.comment.insert" method="post">
				<input type="hidden" name="answer_no" value="${answer.answer_no }">
				댓글<input name="answer_comment_content"><button>등록</button>
			</form>
	<table>
		<tbody>
		<c:if test="${answer.answer_comments ne null}">
			<c:forEach var="asc" items="${answer.answer_comments }">
				<tr>
					<%-- <td>${answers.ac_nick}</td> --%>
					 <td>${asc.answer_comment_content}</td>
					<td>${asc.answer_comment_date}</td> 
					<td><c:choose>
			<c:when test="${sessionScope.loginAccount.ac_nick eq asc.ac_nick }">
				<c:choose>
					<c:when test="${sessionScope.loginAccount.ac_id eq null}">
						<button onclick="alert('로그인하세요')">삭제</button>
					</c:when>
					<c:otherwise>
						<button
							onclick="location.href='answer.comment.delete.do?answer_comment_no=${asc.answer_comment_no}'">삭제</button>
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
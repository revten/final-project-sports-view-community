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
			<div>${MyPost.post_id }</div>
			<div>${MyPost.post_title }</div>
			<div><fmt:formatDate value="${MyPost.post_reg_date }" pattern="yyyy-MM-dd HH:mm" /></div>
			<div>조회수:${MyPost.post_hit_count }</div>
		</div>
		<div><img src="resources/files/myPostImg/${MyPost.post_img }"></div>
		<div>${MyPost.post_content }</div>
		<div>
					<button onclick="history.back()">이전으로</button>
					<c:choose>
							<c:when test="${sessionScope.loginAccount.member_id eq MyPost.member_id }">
								<c:choose>
									<c:when test="${sessionScope.loginAccount.member_id eq null}">
										<button onclick="alert('로그인하세요')">수정</button>
										<button onclick="alert('로그인하세요')">삭제</button>
									</c:when>
									<c:otherwise>
										<button onclick="location.href='myPost.update.go?mypost_no=${MyPost.post_id}'">수정</button>
										<button onclick="location.href='myPost.delete.do?mypost_no=${MyPost.post_id}'">삭제</button>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
				</div>
				
				<form action="mypost.comment.insert" method="post">
				<input type="hidden" name="mypost_no" value="${MyPost.post_id }">
				댓글<input name="mypost_comment_content"><button>등록</button>
			</form>
	<table>
		<tbody>
		<c:if test="${MyPost.post_comments ne null}">
			<c:forEach var="mpc" items="${MyPost.post_comments }">
				<tr>
					<%-- <td>${myposts.ac_nick}</td> --%>
					 <td>${mpc.post_comments_content}</td>
					<td>${mpc.post_comments_date}</td> 
					<td><c:choose>
			<c:when test="${sessionScope.loginAccount.member_nick eq mpc.member_nick }">
				<c:choose>
					<c:when test="${sessionScope.loginAccount.member_id eq null}">
						<button onclick="alert('로그인하세요')">삭제</button>
					</c:when>
					<c:otherwise>
						<button
							onclick="location.href='mypost.comment.delete.do?mypost_comment_no=${mpcpost_comment_no}'">삭제</button>
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
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
			<div>${Ask.ask_no }</div>
			<div>${Ask.ask_title }</div>
			<div><fmt:formatDate value="${Ask.ask_date }" pattern="yyyy-MM-dd HH:mm" /></div>
			<div>조회수:${Ask.ask_count }</div>
		</div>
		<div><img src="resources/files/AskImg/${Ask.ask_img }"></div>
		<div>${Ask.ask_content }</div>
		<div>
					<button onclick="history.back()">이전으로</button>
					<c:choose>
							<c:when test="${sessionScope.loginAccount.ac_id eq Ask.ask_id }">
								<c:choose>
									<c:when test="${sessionScope.loginAccount.ac_id eq null}">
										<button onclick="alert('로그인하세요')">수정</button>
										<button onclick="alert('로그인하세요')">삭제</button>
									</c:when>
									<c:otherwise>
										<button onclick="location.href='ask.update.go?ask_no=${Ask.ask_no}'">수정</button>
										<button onclick="location.href='ask.delete.do?ask_no=${Ask.ask_no}'">삭제</button>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
				</div>
</body>
</html>
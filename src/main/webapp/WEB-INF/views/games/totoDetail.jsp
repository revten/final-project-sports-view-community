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
			<div>${toto.toto_no }</div>
			<div>${toto.toto_title }</div>
			<div><fmt:formatDate value="${toto.toto_date }" pattern="yyyy-MM-dd HH:mm" /></div>
			<div>조회수:${toto.toto_count }</div>
		</div>
		<div><img src="resources/files/totoImg/${toto.toto_img }"></div>
		<div>${toto.toto_content }</div>
		<div>
					<button onclick="history.back()">이전으로</button>
					<c:choose>
							<c:when test="${sessionScope.loginAccount.ac_id eq toto.toto_id }">
								<c:choose>
									<c:when test="${sessionScope.loginAccount.ac_id eq null}">
										<button onclick="alert('로그인하세요')">수정</button>
										<button onclick="alert('로그인하세요')">삭제</button>
									</c:when>
									<c:otherwise>
										<button onclick="location.href='toto.update.go?toto_no=${toto.toto_no}'">수정</button>
										<button onclick="location.href='toto.delete.do?toto_no=${toto.toto_no}'">삭제</button>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
				</div>
</body>
</html>
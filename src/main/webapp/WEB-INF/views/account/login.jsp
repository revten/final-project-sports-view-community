<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="loginSuccessArea">

		<c:choose>
			<c:when test="${sessionScope.loginAccount.id eq null}">
				<a class="nav__link" href="account.login.go">LOGIN</a>
			</c:when>
			<c:otherwise>
				<div class="info-area">
					<div>
						<span>${sessionScope.loginAccount.id }님</span> <a class="mP_btn"
							onclick="goMyPage()">마이페이지</a> <a class="mP_btn"
							onclick="logout()">로그아웃</a>
						<c:if test="${sessionScope.loginAccount.id eq 'admin' }">
							<a href="admin.go" class="nav__link">관리자 페이지</a>
						</c:if>
					</div>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>
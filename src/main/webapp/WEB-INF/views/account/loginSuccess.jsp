<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="loginSuccessArea">
		<div class="info-area">
			<div>
				<span>${sessionScope.loginAccount.id }님</span>
				<a class="mP_btn" onclick="goMyPage()">마이페이지</a>
				<a class="mP_btn" onclick="logout()">로그아웃</a>
			</div>
		</div>
	</div>
</body>
</html>
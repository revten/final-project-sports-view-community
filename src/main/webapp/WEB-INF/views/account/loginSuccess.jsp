<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="loginSuccessArea">
		<div class="info-area">
			<div>
				<span style="font-size: 11px; font-family: Georgia, Serif;">${sessionScope.loginAccount.member_id }님</span>
				<a class="mP_btn" onclick="goMyPage()"> <%-- ${sessionScope.loginAccount.member_id }의  --%>마이페이지
				</a> <a class="mP_btn" onclick="logout()">로그아웃</a>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css" />
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="animated bounceInDown">
		<div class="login_area">
			<h1 class="login_title">비밀번호 찾기</h1>
			
			<form class="content" action="change.pw.go" onsubmit="return searchPw()">
				<!-- 이메일 인증 인풋 -->
				<div class="accountReg__emailInput">
					<input class="input_id" placeholder="이메일" type="email" id="search_member_email" name="email">
					<button class="emailBtn2" type="button" id="email_auth">이메일 인증</button>
					
					<input class="input_id" placeholder="인증번호를 입력해주세요" id="checkNum" disabled="disabled">
					<input type="hidden" id="valid">
					<span id="mail-check-warn"></span>
					<span id="emailcheckResult"></span>
				</div>
			</form>
			
			<div>
				이미 회원이신가요?&nbsp;&nbsp;&nbsp; <a href="account.login.go">로그인</a>
			</div>
			<div>
				아직 회원이 아니신가요?&nbsp;&nbsp;&nbsp;<a href="account.reg.go">회원가입</a>
			</div>
			
		</div>
	</div>
</body>
</html>
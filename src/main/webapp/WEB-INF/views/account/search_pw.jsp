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
				<div>
					<input class="input_id" id="id-input" name="id" placeholder="아이디를 입력해주세요" required>
				</div>
				
				<!-- 이메일 인증 -->
				<div class="accountReg__emailInput">
					<!-- 이메일 입력 -->
					<input class="input_id" id="email-input" name="email"  placeholder="이메일" type="email" >
					<button class="emailBtn2" id="email-send-btn" type="button">이메일 인증</button>
					<!-- 받은 인증번호 저장-->
					<input type="hidden" id="email-certNum">
					<!-- 인증번호 입력 -->					
					<input class="input_id"  id="email-certNum-input" placeholder="인증번호를 입력해주세요" disabled="disabled"  type="text" size="13" maxlength="6" >
					
					<button class="emailBtn2" id="email-auth-complete-btn" disabled="disabled" type="button">인증확인</button>
				</div>
				
				<button class="emailBtn2" style="margin-bottom: 15px;">비밀번호 변경</button>
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
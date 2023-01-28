<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css" />
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
	<div class="animated bounceInDown">
	<div class="login_area">
	<h1 class="login_title">아이디 찾기</h1>
	<form name="searchIdForm" action="search.id.do" method="post">
		<div>
			<input class="input_id" id="ac_name" name="ac_name" placeholder="이름을 입력해주세요">
		</div>
		<div>
			<input class="input_id" id="ac_email" name="ac_email" placeholder="이메일을 입력해주세요">
		</div>
		<div>
			<button class="loginBtn">아이디 찾기</button>
		</div>
	</form>
	<br>
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
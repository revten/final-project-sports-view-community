<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="con"></div>
	<form name="searchIdForm" action="search.id.do" method="post">
		<div>
			<input id="ac_name" name="ac_name" placeholder="이름을 입력해주세요">
		</div>
		<div>
			<input id="ac_email" name="ac_email" placeholder="이메일을 입력해주세요">
		</div>
		<div>
			<button>아이디 찾기</button>
		</div>
	</form>
	<div>
		이미 회원이신가요?&nbsp;&nbsp;&nbsp; <a href="account.login.go">로그인</a>
	</div>
	<div>
		아직 회원이 아니신가요?&nbsp;&nbsp;&nbsp;<a href="account.reg.go">회원가입</a>
	</div>
</body>
</html>
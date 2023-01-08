<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form class="content" action="search.pw.do" method="post"
		onsubmit="return searchPw()">
		<div>
			<input id="search_ac_id" name="ac_id" placeholder="아이디"> <input
				name="ac_email" type="email" id="search_ac_email" placeholder="이메일">
			<button type="button" id="email_check">이메일 인증</button>
			<br> <input placeholder="인증번호를 입력해주세요" id="email_num"
				disabled="disabled"> <input type="hidden" id="valid">
			<span id="mail-check-warn"></span> <span id="emailcheckResult"></span>
			<p>
				<button>확인</button>
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
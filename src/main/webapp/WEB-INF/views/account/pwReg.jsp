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
	<form action="change.pw.do" method="post" onsubmit="return changePw();">
		<input type="hidden" value="${Account.ac_id }" name="ac_id"
			id="change-pw-id"> <input name="ac_pw"
			placeholder="새 비밀번호 입력" id="change-pw-pw"> <input
			name="ac_pwConfirm" placeholder="비밀번호 확인" id="change-pw-pwConfirm">
		<button>비밀번호 변경</button>
	</form>
</body>
</html>
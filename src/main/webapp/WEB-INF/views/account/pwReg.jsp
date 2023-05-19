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
		<input type="hidden" value="${sessionScope.loginAccount.id}}" name="id">
		<!-- 비밀번호 인풋 -->
		<div class="accountReg__pwdInput">
			<input class="input_pwd" placeholder="비밀번호(영어+숫자+특수문자 7-20)" type="password" id="pwdInput" name="password"  oninput="checkPwd()">
			<span class="pwd__good">사용가능 합니다.</span>
			<span class="pwd__bad">비밀번호 양식을 확인해 주세요</span>
		</div>
		<button>비밀번호 변경</button>
	</form>
</body>
</html>
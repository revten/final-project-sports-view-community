<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 - Enjoy Sports</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h1>회원 가입</h1>
	<div id="accountReg__contrainer">
		<form action="account.reg.do" method="post"
			enctype="multipart/form-data">
			<div class="accountReg__idInput-1">아이디</div>
			<div class="accountReg__idInput-2">
				<input id="idInput" name="ac_id">
			</div>

			<div class="accountReg__pwInput-1">비밀번호</div>
			<div class="accountReg__pwInput-2">
				<input type="password" id="pwInput" name="ac_pw">
			</div>

			<div class="accountReg__pwInput-1">비밀번호 확인</div>
			<div class="accountReg__pwInput-2">
				<input type="password" id="pwInput2" name="ac_pwConfirm"> <font
					id="pwConfirm" size="2"></font>
			</div>

			<div class="accountReg__nameInput-1">이름</div>
			<div class="accountReg__nameInput-2">
				<input id="nameInput" name="ac_name">
			</div>

			<div class="accountReg__addrInput">주소</div>
			<div>
				<input id="addrInput" name="ac_addr">
			</div>

			<div class="accountReg__emailInput-1">이메일</div>
			<div class="accountReg__emailInput-2">
				<input id="emailInput" name="ac_email">
			</div>
			<button>가입</button>
			<br>
			<button onclick='history.back(-1)'>뒤로가기</button>
		</form>
	</div>
</body>
</html>